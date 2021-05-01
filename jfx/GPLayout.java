package jfx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class GPLayout extends Application {
    public static void main(String[] args) {
        System.out.println("Launching the app...");
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Button btn1 = new Button("Click me");
        Button btn2 = new Button("Click me");
        Button btn3 = new Button("Click me");

        GridPane root = new GridPane(); // it is responsive, unlike HBox and VBox
        root.add(btn1, 0, 0);   // root.add(Node, columnIndex, rowIndex)
        root.add(btn2, 1, 1);
        root.add(btn3, 2, 2);
        root.setHgap(20);
        root.setVgap(20);
        // root.setGridLinesVisible(true);

        Scene sc = new Scene(root);
        primaryStage.setScene(sc);
        primaryStage.setWidth(500);
        primaryStage.setHeight(500);
        primaryStage.setTitle("My App");
        primaryStage.show();
    }
}