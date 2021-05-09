package jfx.uicontrols;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ComboBoxes extends Application {
    public static void main(String[] args) {
        System.out.println("Launching the app...");
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        ComboBox<String> subjects = new ComboBox<>();
        subjects.getItems().add("Computer Science");
        subjects.getItems().add("Physics");
        subjects.getItems().add("Chemistry");
        subjects.getItems().add("Maths");

        // Add Combo Box to layout
        HBox root = new HBox(subjects);
        // Add layout to scene
        Scene sc = new Scene(root);
        // Add Scene to stage
        primaryStage.setHeight(500);
        primaryStage.setWidth(500);
        primaryStage.setScene(sc);
        primaryStage.setTitle("My app");
        primaryStage.show();
    }
}
