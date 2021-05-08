package jfx.uicontrols;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ListViews extends Application {
    public static void main(String[] args) {
        System.out.println("Launching the app...");
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        ListView<String> subjects = new ListView<>();
        subjects.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        subjects.getItems().add("Computer Science");
        subjects.getItems().add("Physics");
        subjects.getItems().add("Maths");
        subjects.getItems().add("Chemistry");

        // Add ListView to layout
        HBox root = new HBox(subjects);
        // Add layout to scene
        Scene sc = new Scene(root);
        // Add scene to stage
        primaryStage.setHeight(500);
        primaryStage.setWidth(500);
        primaryStage.setScene(sc);
        primaryStage.show();  
    }
}
