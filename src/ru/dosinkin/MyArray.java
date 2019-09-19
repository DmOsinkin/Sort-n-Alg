package ru.dosinkin;

public class MyArray {
    private int[] array;
    private int nElems;
    private int maxValue = Integer.MIN_VALUE;

    public MyArray(int size) {
        nElems = 0;
        this.array = new int[size];
    }

    public boolean find(int searchKey) {
        int j;
        for (j = 0; j < nElems; j++)
            if (array[j] == searchKey) break;
        return j != nElems;
    }

    public void insert(int newElement) {
        this.array[nElems] = newElement;
        maxValue = array[nElems] < newElement ? newElement : maxValue;
        nElems++;
    }

    private int findId(int leftEdge, int rightEdge, int newElement) {
        int middle = (rightEdge - leftEdge) / 2;
        if (newElement < array[middle]) {
            return findId(leftEdge, middle, newElement);
        } else {
            return findId(middle, rightEdge, newElement);
        }
    }

    public int getById(int id) {
        try {
            return this.array[id];
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Oh no!");
            return 0;
        }
    }

    public boolean delete(int element) {
        int j;
        for (j = 0; j < nElems; j++)
            if (element == array[j])
                break;
        if (j == nElems)
            return false;
        else {
            for (int k = j; k < nElems; k++) array[k] = array[k + 1];
            nElems--;
            return true;
        }
    }

    public void print() {
        for (int el : this.array) {
            System.out.print(el + " ");
        }
        System.out.println("");
    }

    public int getMax() {
        return maxValue;
    }

    public int removeMax() {
        maxValue = Integer.MIN_VALUE;
        if (nElems == 0)
            return -1;
        for (int i = 0; i < nElems; i++) {
            if (array[i] > maxValue) {
                maxValue = array[i];
            }
        }
        delete(maxValue);
        return maxValue;
    }

    public void choiceSort() {
        int min;
        int minId = -1;
        for (int i = 0; i < nElems; i++) {
            min = Integer.MAX_VALUE;
            for (int j = i; j < nElems; j++) {
                if (min > array[j]) {
                    min = array[j];
                    minId = j;
                }
            }
            array[minId] = array[i];
            array[i] = min;
        }
    }


}
