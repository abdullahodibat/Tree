package main;

import java.util.Arrays;

/**
 * Created by abdullahodibat.
 * Implementation of Min-Heap
 */
public class Heap {
    public static void main (String[] args){

        Heap heap = new Heap();
        heap.insert(4);
        heap.insert(7);
        heap.insert(9);
        heap.insert(2);

        heap.poll();
        heap.insert(5);

        for (int i = 0; i < heap.size; i++) {
            System.out.println(heap.arr[i]);
        }

    }
    int capacity;
    int size;
    int[] arr;

    public void checkCapacity() {
        if (arr.length == capacity - 1) {
            capacity = capacity * 2;
            int[] newArr = new int[capacity];
            arr = Arrays.copyOf(arr, capacity);
        }
    }

    public boolean hasParent(int index) {
        return getParentIndex(index) >= 0;
    }

    public int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    public int getParent(int index) {
        return arr[(index - 1) / 2];
    }

    public int getLeftChildIndex(int index) {
        return (2 * index) + 1;
    }

    public boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < size;
    }

    public int getLeftChild(int index) {
        return arr[getLeftChildIndex(index)];
    }

    public int getRightChildIndex(int index) {
        return (2 * index) + 2;
    }

    public boolean hasRightChild(int index) {
        return getRightChildIndex(index) < size;
    }

    public int getRightChild(int index) {
        return arr[getRightChildIndex(index)];
    }


    public Heap() {
        this.capacity = 10;
        this.size = 0;
        this.arr = new int[capacity];
    }

    /**
     * remove the smalles elemnt from heap
     *
     * @return
     */
    public int poll() {
        if (size == 0) throw new IllegalStateException("arr is empty");
        else {
            int item = arr[0];
            arr[0] = arr[size - 1];
            size--;
            downHeapfy();
            return item;
        }
    }

    /**
     * insert new value into heap
     *
     * @param value
     */
    public void insert(int value) {
        checkCapacity();
        arr[size] = value;
        size++;
        upHeapfy();
    }


    /**
     * fix heap after adding new element
     */
    public void upHeapfy() {
        int index = size - 1;
        while (hasParent(index) && getParent(index) > arr[index]) {
            int tmp = arr[index];
            arr[index] = arr[getParentIndex(index)];
            arr[getParentIndex(index)] = tmp;
            index = getParentIndex(index);
        }
    }

    /**
     * fix heap after polling smalles element
     */
    public void downHeapfy() {
        int index = 0;
        while (hasLeftChild(index)) {
            int smallestIndex = getLeftChildIndex(index);
            if (hasRightChild(index) && getRightChild(index) < getLeftChild(index)) {
                smallestIndex = getRightChildIndex(index);
            }
            if (arr[index] < arr[smallestIndex]) {
                break;
            } else {
                int tmp = arr[index];
                arr[index] = arr[smallestIndex];
                arr[smallestIndex] = tmp;
                index = smallestIndex;
            }
        }
    }
}
