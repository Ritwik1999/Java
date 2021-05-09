package jfx.events;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class InputEvent extends Application {
    public static void main(String[] args) {
        System.out.println("Launching the app...");
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        TextField name = new TextField();
        name.setMaxWidth(300);
        Button btn = new Button("Click here");
        Label lbl = new Label();

        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                lbl.setText("");
                lbl.setText("Welcome, Mr. " + name.getText());
                lbl.setTextFill(Color.RED);
                lbl.setFont(new Font("Times New Roman", 32));
            }

        });

        VBox root = new VBox();
        root.getChildren().addAll(name, btn, lbl);
        Scene sc = new Scene(root);
        primaryStage.setTitle("JavaFX Event UI Demo");
        primaryStage.setScene(sc);
        primaryStage.setHeight(500);
        primaryStage.setWidth(500);
        primaryStage.show();
    }
}
