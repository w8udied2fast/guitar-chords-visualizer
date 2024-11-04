package com.example;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class GuitarFretboard extends Canvas {
    private static final int NUM_FRETS = 5; 
    private static final int NUM_STRINGS = 6; 
    private static final int FRET_WIDTH = 60; 
    private static final int STRING_HEIGHT = 50; 
    private static final int BOTTOM_MARGIN = 25; 

    public GuitarFretboard() {
        setWidth(800);
        setHeight(600);
    }

    public void drawChord(String chordName, String[] strings) {
        GraphicsContext gc = getGraphicsContext2D();
        gc.clearRect(0, 0, getWidth(), getHeight());

        // гриф гитары
        drawFretboard(gc);

        // Расположение пальцев
        for (int i = 0; i < strings.length; i++) {
            int fret = Integer.parseInt(strings[i]);
            if (fret > 0) {
                gc.setFill(Color.RED);
                // Точка между ладами
                gc.fillOval(50 + (fret - 1) * FRET_WIDTH + FRET_WIDTH / 2 - 10, 50 + i * STRING_HEIGHT - 10, 20, 20);
            }
        }

        // надпись
        gc.setFont(new Font(20));
        gc.setFill(Color.BLACK);
        gc.fillText("Аккорд " + chordName, 50, 50 + NUM_STRINGS * STRING_HEIGHT + BOTTOM_MARGIN);
    }

    private void drawFretboard(GraphicsContext gc) {
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(2);

        // Рисуем лады
        for (int i = 0; i <= NUM_FRETS; i++) {
            int x = 50 + i * FRET_WIDTH;
            gc.strokeLine(x, 50, x, 50 + (NUM_STRINGS - 1) * STRING_HEIGHT);
            if (i > 0) {
                gc.setFont(new Font(12));
                gc.fillText(Integer.toString(i), x - 5, 40); 
            }
        }

        // Рисуем струны
        for (int i = 0; i < NUM_STRINGS; i++) {
            int y = 50 + i * STRING_HEIGHT;
            gc.strokeLine(50, y, 50 + NUM_FRETS * FRET_WIDTH + FRET_WIDTH / 2, y); 
            gc.setFont(new Font(12));
            gc.fillText(Integer.toString(i + 1), 30, y + 5);
        }
    }
    public void clear() {
        GraphicsContext gc = getGraphicsContext2D();
        gc.clearRect(0, 0, getWidth(), getHeight());
    }
}