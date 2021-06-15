package jfx.events;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ButtonClickEvent extends Application {
    public static void main(String[] args) {
        System.out.println("Launching the app...");
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Button btn = new Button("Click here");
        Label lbl = new Label();
        lbl.setTextFill(Color.RED);
        lbl.setFont(new Font("Times New Roman", 20));

        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                lbl.setText("Button Clicked");
            }

        });

        HBox root = new HBox();
        root.getChildren().addAll(btn, lbl);
        Scene sc = new Scene(root);
        primaryStage.setScene(sc);
        primaryStage.setHeight(300);
        primaryStage.setWidth(300);
        primaryStage.show();
    }
}
