package jfx.layouts;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class FPLayout extends Application {
    public static void main(String[] args) {
        System.out.println("Launching the app...");
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Button btn1 = new Button("Click me");
        Button btn2 = new Button("Click me");
        Button btn3 = new Button("Click me");
        Button btn4 = new Button("Click me");
        Button btn5 = new Button("Click me");
        Button btn6 = new Button("Click me");
        Button btn7 = new Button("Click me");
        Button btn8 = new Button("Click me");
        Button btn9 = new Button("Click me");
        Button btn10 = new Button("Click me");
        Button btn11 = new Button("Click me");
        Button btn12 = new Button("Click me");
        Button btn13 = new Button("Click me");

        FlowPane root = new FlowPane(); // it is responsive, unlike HBox and VBox
        root.getChildren().add(btn1);
        root.getChildren().add(btn2);
        root.getChildren().add(btn3);
        root.getChildren().add(btn4);
        root.getChildren().add(btn5);
        root.getChildren().add(btn6);
        root.getChildren().add(btn7);
        root.getChildren().add(btn8);
        root.getChildren().add(btn9);
        root.getChildren().add(btn10);
        root.getChildren().add(btn11);
        root.getChildren().add(btn12);
        root.getChildren().add(btn13);

        Scene sc = new Scene(root);
        primaryStage.setScene(sc);
        primaryStage.setWidth(500);
        primaryStage.setHeight(500);
        primaryStage.setTitle("My App");
        primaryStage.show();
    }
}