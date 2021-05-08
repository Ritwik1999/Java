package jfx.uicontrols;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RadioButtons extends Application {
    public static void main(String[] args) {
        System.out.println("Launching the app...");
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // To create Radio Button, first create an object of type Toggle
        ToggleGroup group = new ToggleGroup();
        RadioButton opt1 = new RadioButton("Computer Science");
        RadioButton opt2 = new RadioButton("Physics");
        RadioButton opt3 = new RadioButton("Chemistry");
        RadioButton opt4 = new RadioButton("Maths");
        opt1.setToggleGroup(group);
        opt2.setToggleGroup(group);
        opt3.setToggleGroup(group);
        opt4.setToggleGroup(group);

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
