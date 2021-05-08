package jfx.uicontrols;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CheckBoxes extends Application {
    public static void main(String[] args) {
        System.out.println("Launching the app...");
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        CheckBox opt1 = new CheckBox("Computer Science");
        CheckBox opt2 = new CheckBox("Physics");
        CheckBox opt3 = new CheckBox("Chemistry");
        CheckBox opt4 = new CheckBox("Maths");

        // create a layout
        VBox root = new VBox();
        root.getChildren().addAll(opt1, opt2, opt3, opt4);
        // add layout to scene
        Scene sc = new Scene(root);
        // add scene to a stage
        primaryStage.setScene(sc);
        primaryStage.setWidth(300);
        primaryStage.setHeight(300);
        primaryStage.setTitle("My App");
        primaryStage.show();

    }
}
