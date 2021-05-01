package jfx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class BPLayout extends Application {
    public static void main(String[] args) {
        System.out.println("Launching the app...");
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Button btn1 = new Button("Click me");
        Button btn2 = new Button("Click me");
        Button btn3 = new Button("Click me");

        BorderPane root = new BorderPane();
        root.setBottom(btn1);
        root.setCenter(btn2);
        root.setRight(btn3);

        Scene sc = new Scene(root);
        primaryStage.setScene(sc);
        primaryStage.setWidth(500);
        primaryStage.setHeight(500);
        primaryStage.setTitle("My App");
        primaryStage.show();
    }
}