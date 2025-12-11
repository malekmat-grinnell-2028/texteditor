package edu.grinnell.csc207.texteditor;


/**
 * A gap buffer-based implementation of a text buffer.
 */
public class GapBuffer {
    int index1;
    int index2;
    char[] arr;

    /**
     * creates a new GapBuffer
     */
    public GapBuffer() {
        arr = new char[8];
        index1 = 0;
        index2 = arr.length;
    }

    /**
     * inserts the given character at index1 in the GapBuffer
     * @param ch the character to be inserted
     */
    public void insert(char ch) {
        if(index1 == index2) {
            char[] tempArr = new char[2 * arr.length];
            System.arraycopy(arr, 0, tempArr, 0, index1);
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

    /**
     * deletes the character at index1
     */
    public void delete() {
        if(index1 > 0) {
            index1 -= 1;
        }
    }

    /**
     * gets the cursor position in GapBuffer (index1)
     * @return the cursor position (index1)
     */
    public int getCursorPosition() {
        return index1;
    }

    /**
     * moves the cursor in GapBuffer one character to the left
     */
    public void moveLeft() {
        if(index1 > 0) {
            index2 -= 1;
            index1 -= 1;
            arr[index2] = arr[index1];
        }
    }

    /**
     * moves the cursor in GapBuffer one character to the right
     */
    public void moveRight() {
        if(index2 < arr.length) {
            index1 += 1;
            arr[index1] = arr[index2];
            index2 += 1;
        }
    }

    /**
     * @return the size of GapBuffer
     */
    public int getSize() {
        return index1 + (arr.length - index2);
    }

    /**
     * @return the memory allocated to GapBuffer
     */
    public int getAllocatedMemory() {
        return arr.length;
    }

    /**
     * gets the character at index i in GapBuffer
     * @param i the index to retrieve the character from in GapBuffer
     * @return the character at index i in GapBuffer
     */
    public char getChar(int i) {
        return arr[i];
    }

    /**
     * @return the GapBuffer as a string
     */
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
