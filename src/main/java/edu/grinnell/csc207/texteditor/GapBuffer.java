package edu.grinnell.csc207.texteditor;


/**
 * A gap buffer-based implementation of a text buffer.
 */
public class GapBuffer {
    int index1;
    int index2;
    char[] arr;

    public GapBuffer() {
        arr = new char[8];
        index1 = 0;
        index2 = arr.length;
    }

    public void insert(char ch) {
        if(index1 == index2) {
            char[] tempArr = new char[2 * arr.length];
            System.arraycopy(arr, 0, tempArr, 0, index1+1);
            System.arraycopy(arr, index2, tempArr, tempArr.length - (arr.length - index2), arr.length-index2);
            index2 = tempArr.length - (arr.length - index2);
            arr = tempArr;
            arr[index1] = ch;
            index1 += 1;
        } else {
            arr[index1] = ch;
            index1 += 1;
        }
    }

    public void delete() {
        if(index1 > 0) {
            index1 -= 1;
        }
    }

    public int getCursorPosition() {
        return index1;
    }

    public void moveLeft() {
        if(index1 > 0) {
            index2 -= 1;
            index1 -= 1;
            arr[index2] = arr[index1];
        }
    }

    public void moveRight() {
        if(index2 < arr.length) {
            index1 += 1;
            arr[index1] = arr[index2];
            index2 += 1;
        }
    }

    public int getSize() {
        return arr.length;
    }

    public char getChar(int i) {
        return arr[i];
    }

    @Override
    public String toString() {
        int buffSize = index2 - index1;
        char[] strArr = new char[arr.length - buffSize];
        System.arraycopy(arr, 0, strArr, 0, index1);
        System.arraycopy(arr, index2, strArr, index1, arr.length - index2);
        String str = new String(strArr);
        return str;
    }
}
