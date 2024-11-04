package com.example;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class GuitarFretboard extends Canvas {
    public GuitarFretboard() {
        setWidth(800);
        setHeight(600);
    }

    public void drawChord(String[] strings) {
        GraphicsContext gc = getGraphicsContext2D();
        gc.clearRect(0, 0, getWidth(), getHeight());

        // Рисуем гриф гитары
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(2);
        for (int i = 0; i < 6; i++) {
            gc.strokeLine(50, 50 + i * 50, 50 + 200, 50 + i * 50);
        }

        // Рисуем расположение пальцев
        for (int i = 0; i < strings.length; i++) {
            int fret = Integer.parseInt(strings[i]);
            if (fret > 0) {
                gc.setFill(Color.RED);
                gc.fillOval(50 + fret * 50 - 10, 50 + i * 50 - 10, 20, 20);
            }
        }
    }

    public void clear() {
        GraphicsContext gc = getGraphicsContext2D();
        gc.clearRect(0, 0, getWidth(), getHeight());
    }
}