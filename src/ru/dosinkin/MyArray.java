package ru.dosinkin;

public class MyArray {
    private int[] array;
    private int nElems;
    private int maxId = -1;

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
        nElems++;
        if (maxId > -1 && array[maxId] < newElement) {
            maxId = nElems;
        }
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
        for (int i = 0; i < nElems; i++) {
            if (this.array[i] == element) {
                if (this.nElems - 1 - i + 1 >= 0)
                    System.arraycopy(this.array, i + 1, this.array, i + 1 - 1, this.nElems - 1 - i + 1);
                nElems--;
                return true;
            }
        }
        return false;
    }

    public void print() {
        for (int el : this.array) {
            System.out.print(el + " ");
        }
        System.out.println("");
    }

    public int getMax() {
        return maxId;
    }

    public int removeMax() {
        maxId = -1;
        if(nElems == 0)
            return maxId;
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < nElems; i++) {
            if (array[i] > maxValue) {
                maxId = i;
                maxValue = array[i];
            }
        }
        this.delete(maxValue);
        return maxId;
    }


}
