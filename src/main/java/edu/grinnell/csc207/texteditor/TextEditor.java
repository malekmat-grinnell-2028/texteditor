package edu.grinnell.csc207.texteditor;

import com.googlecode.lanterna.terminal.DefaultTerminalFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor.RGB;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;

/**
 * The driver for the TextEditor Application.
 */
public class TextEditor {

    /**
     * the main method
     * @param args the file path as a string
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        DefaultTerminalFactory factory = new DefaultTerminalFactory();
        Screen screen = factory.createScreen();
        screen.newTextGraphics();
        GapBuffer text = new GapBuffer();
        screen.startScreen();
        if (args.length != 1) {
            System.err.println("Usage: java TextEditor <filename>");
            System.exit(1);
        }

        StringBuffer fileContents = new StringBuffer();
        String path = args[0];
        System.out.format("Loading %s...\n", path);
        if (Files.exists(Paths.get(path))) {
            fileContents.append(Files.readString(Paths.get(path)));
            
            for (int i = 0; i < fileContents.length(); i++) { 
                text.insert(fileContents.charAt(i));
            }
        }
            
        boolean isRunning = true;
        drawBuffer(text, screen, fileContents);
        while (isRunning) {
            KeyStroke stroke = screen.readInput();
            fileContents.delete(0, fileContents.length());
            if (stroke.getKeyType().equals(KeyType.Escape)) {
                isRunning = false;
            } else if (stroke.getKeyType().equals(KeyType.Character)) { 
                text.insert(stroke.getCharacter());
            } else if (stroke.getKeyType().equals(KeyType.ArrowLeft)) { 
                text.moveLeft();
            } else if (stroke.getKeyType().equals(KeyType.ArrowRight)) { 
                text.moveRight();
            } else if (stroke.getKeyType().equals(KeyType.Backspace)) { 
                text.delete();
            }
            
            drawBuffer(text, screen, fileContents);
        }
        Files.writeString(Paths.get(path), fileContents);
        screen.stopScreen();

    }

    /**
     * @param buf the GapBuffer to get the characters to write to the screen
     * @param screen the screen to write the characters in GapBuffer to
     * @param fileContents the contents of the file being edited
     * @throws IOException
     */
    public static void drawBuffer(GapBuffer buf, Screen screen, StringBuffer fileContents) 
        throws IOException {
        screen.clear();
        TerminalPosition t = new TerminalPosition(0, 0);
        screen.setCursorPosition(t);
        for (int i = 0; i < buf.index1; i++) {
            char c = buf.getChar(i);
            fileContents.append(c);
            screen.setCharacter(t, TextCharacter.fromCharacter(c)[0]);
            t = t.withRelativeColumn(1);
        }
        RGB col = new RGB(0, 0, 0);
        screen.setCharacter(t, TextCharacter.fromCharacter('#', col, col)[0]);
        t = t.withRelativeColumn(1);
        for (int i = buf.index2; i < buf.getAllocatedMemory(); i++) {
            char c = buf.getChar(i);
            fileContents.append(c);
            screen.setCharacter(t, TextCharacter.fromCharacter(c)[0]);
            t = t.withRelativeColumn(1);
        }
        screen.refresh();
    }

}