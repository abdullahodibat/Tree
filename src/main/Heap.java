package main;

import java.util.Arrays;

/**
 * Created by abdullahodibat on 26.12.17.
 */
public class Heap {
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

    public void insert(int value) {
        checkCapacity();
        arr[size] = value;
        size++;
        upHeapfy();
    }

    public void upHeapfy() {
        int index = size - 1;
        while (hasParent(index) && getParent(index) > arr[index]) {
            int tmp = arr[index];
            arr[index] = arr[getParentIndex(index)];
            arr[getParentIndex(index)] = tmp;
            index = getParentIndex(index);
        }
    }

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
