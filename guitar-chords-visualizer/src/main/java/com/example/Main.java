package com.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.SQLException;

public class Main extends Application {
    private GuitarFretboard fretboard;
    private TextField chordNameField;

    @Override
    public void start(Stage primaryStage) {
        fretboard = new GuitarFretboard();
        chordNameField = new TextField();
        Button showChordButton = new Button("Show Chord");
        showChordButton.setOnAction(event -> {
            String chordName = chordNameField.getText();
            try {
                String[] strings = ChordRepository.findByName(chordName);
                if (strings != null) {
                    fretboard.drawChord(chordName, strings);
                } else {
                    fretboard.clear();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });

        VBox root = new VBox(chordNameField, showChordButton, fretboard);
        Scene scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Guitar Chords Visualizer");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}