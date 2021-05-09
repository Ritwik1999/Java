package jfx.events;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class CombBoxEvent extends Application {
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
        Button submit = new Button("Submit");
        Label lbl = new Label();

        submit.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                String val = subjects.getValue();
                lbl.setText("");

                if (val == null) {
                    lbl.setText("Nothing selected");
                    lbl.setTextFill(Color.RED);
                } else {
                    lbl.setText("You selected " + val);
                    lbl.setTextFill(Color.GREEN);
                }

                lbl.setFont(new Font("Times New Roman", 32));
            }

        });

        VBox root = new VBox();
        root.getChildren().addAll(subjects, submit, lbl);
        Scene sc = new Scene(root);
        primaryStage.setHeight(500);
        primaryStage.setWidth(500);
        primaryStage.setScene(sc);
        primaryStage.setTitle("My app");
        primaryStage.show();
    }
}