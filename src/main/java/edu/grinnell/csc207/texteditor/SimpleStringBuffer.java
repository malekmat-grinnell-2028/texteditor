package edu.grinnell.csc207.texteditor;

/**
 * A naive implementation of a text buffer using a <code>String</code>.
 */
public class SimpleStringBuffer {

    public int index;
    
    public String str;

    /**
     * creates a new simpleStringBuffer
     */
    public SimpleStringBuffer() {
        index = 0;
        str = "";
    }

    /**
     * inserts a char in the simpleStringBuffer at the index of the cursor
     * @param ch the char to be inserted
     */
    public void insert(char ch) {
        str = str.substring(0, index) + ch + str.substring(index, str.length());
        moveRight();
    }

    /**
     * deletes the char in the simpleStringBuffer behind the cursor
     */
    public void delete() {
        if (index > 0) {
            str = str.substring(0, index - 1) + str.substring(index, str.length());
            moveLeft();
        }
    }

    /**
     * @return returns the current position of the cursor
     */
    public int getCursorPosition() {
        return index;
    }

    /**
     * moves the cursor left one character
     */
    public void moveLeft() {
        if (index > 0) {
            index -= 1;
        }
    }

    /**
     * moves the cursor right one character
     */
    public void moveRight() {
        if (index < str.length()) {
            index += 1;
        }
    }

    /**
     * @return the size of the simpleStringBuffer
     */
    public int getSize() {
        return str.length();
    }

    /**
     * @param i the index in the string buffer to get the character
     * @return the character in the simpleStringBuffer at index i
     */
    public char getChar(int i) {
        return str.charAt(i);
    }

    /**
     * @return returns the simpleStringBuffer
     */
    @Override
    public String toString() {
        return str;
    }
}
