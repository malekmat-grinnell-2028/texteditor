package edu.grinnell.csc207.texteditor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class GapBufferTests {
    @Test
    public void testAddDeletetoStringBuffer() {
        GapBuffer buf = new GapBuffer();
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
        GapBuffer buf = new GapBuffer();
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
    public void testGetCursorPosLast() {
        GapBuffer buf = new GapBuffer();
        buf.insert('a');
        buf.insert('b');
        buf.insert('c');
        buf.insert('d');
        buf.moveRight();
        buf.moveRight();
        buf.moveRight();
        buf.moveRight();
        assertEquals(4, buf.getCursorPosition());
    }

    @Test
    public void testGetCursorPosFirst() {
        GapBuffer buf = new GapBuffer();
        buf.insert('a');
        buf.insert('b');
        buf.moveLeft();
        buf.insert('c');
        buf.insert('d');
        buf.moveLeft();
        buf.moveLeft();
        buf.moveLeft();
        buf.moveLeft();
        buf.moveLeft();
        buf.moveLeft();
        assertEquals(0, buf.getCursorPosition());
    }
    
    @Test
    public void testaddFirst() {
        GapBuffer buf = new GapBuffer();
        buf.insert('a');
        buf.insert('b');
        buf.insert('c');
        buf.insert('d');
        buf.moveLeft();
        buf.moveLeft();
        buf.moveLeft();
        buf.moveLeft();
        buf.moveLeft();
        buf.moveLeft();
        buf.insert('e');
        assertEquals("eabcd", buf.toString());
    }

    @Test
    public void testaddMiddle() {
        GapBuffer buf = new GapBuffer();
        buf.insert('a');
        buf.insert('b');
        buf.insert('c');
        buf.insert('d');
        buf.moveLeft();
        buf.moveLeft();
        buf.moveLeft();
        buf.moveRight();
        buf.insert('l');
        buf.insert('m');
        buf.insert('n');
        buf.insert('o');
        buf.insert('p');

        assertEquals("ablmnopcd", buf.toString());
    }


    @Test
    public void testCharAt() {
        GapBuffer buf = new GapBuffer();
        buf.insert('a');
        buf.insert('b');
        buf.insert('c');
        assertEquals('b', buf.getChar(1));
    }
}
