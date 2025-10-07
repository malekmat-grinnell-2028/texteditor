package edu.grinnell.csc207.texteditor;

/**
 * A naive implementation of a text buffer using a <code>String</code>.
 */
public class SimpleStringBuffer {
    public int index;
    public String str;

    public SimpleStringBuffer() {
        index = 0;
        str = "";
    }

    public void insert(char ch) {
        str = str.substring(0, index) + ch + str.substring(index, str.length());
        moveRight();
    }

    public void delete() {
        if(index > 0) {
            str = str.substring(0, index-1) + str.substring(index, str.length());
            moveLeft();
        }
    }

    public int getCursorPosition() {
        return index;
    }

    public void moveLeft() {
        if(index > 0) {
            index -= 1;
        }
    }

    public void moveRight() {
        if(index < str.length()) {
            index += 1;
        }
    }

    public int getSize() {
        return str.length();
    }

    public char getChar(int i) {
        return str.charAt(i);
    }

    @Override
    public String toString() {
        return str;
    }
}
