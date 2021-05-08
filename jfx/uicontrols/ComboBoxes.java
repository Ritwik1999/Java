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

        HBox root = new HBox(subjects);
        Scene sc = new Scene(root);
        primaryStage.setHeight(500);
        primaryStage.setWidth(500);
        primaryStage.setScene(sc);
        primaryStage.show();
    }
}
