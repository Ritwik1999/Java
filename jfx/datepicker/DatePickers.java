package jfx.datepicker;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class DatePickers extends Application {
    public static void main(String[] args) {
        System.out.println("Launching the app...");
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Label lbl = new Label("Select your date of birth");
        DatePicker d = new DatePicker();

        HBox root = new HBox();
        root.getChildren().addAll(lbl, d);
        Scene sc = new Scene(root);
        primaryStage.setTitle("My datepicker");
        primaryStage.setHeight(500);
        primaryStage.setWidth(500);
        primaryStage.setScene(sc);
        primaryStage.show();
    }
}
