package edu.grinnell.csc207.texteditor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SimpleStringBufferTests {
    @Test
    public void testAddDeletetoStringBuffer() {
        SimpleStringBuffer buf = new SimpleStringBuffer();
        buf.insert('a');
        buf.insert('b');
        buf.insert('c');
        buf.insert('d');
        buf.delete();
        buf.moveLeft();
        buf.delete();
        assertEquals("ac", buf.toString());
    }

    @Test
    public void testGetCursorPos() {
        SimpleStringBuffer buf = new SimpleStringBuffer();
        buf.insert('a');
        buf.insert('b');
        buf.insert('c');
        buf.insert('d');
        buf.delete();
        buf.moveLeft();
        buf.moveLeft();
        buf.moveRight();
        assertEquals(2, buf.getCursorPosition());
    }

    @Test
    public void testCharAt() {
        SimpleStringBuffer buf = new SimpleStringBuffer();
        buf.insert('a');
        buf.insert('b');
        buf.insert('c');
        assertEquals('b', buf.getChar(1));
    }

}
