package jfx.events;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class CheckBoxEvent extends Application {
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
        Button submit = new Button("Submit");
        Label lbl = new Label();

        submit.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                String selectedOptions = "";
                lbl.setText("");

                if (opt1.isSelected()) {
                    selectedOptions += opt1.getText() + ", ";
                }
                if (opt2.isSelected()) {
                    selectedOptions += opt2.getText() + ", ";
                }
                if (opt3.isSelected()) {
                    selectedOptions += opt3.getText() + ", ";
                }
                if (opt4.isSelected()) {
                    selectedOptions += opt4.getText() + ", ";
                }

                lbl.setFont(new Font("Times New Roman", 32));
                if (!selectedOptions.isEmpty()) {
                    lbl.setText("You selected " + selectedOptions);
                    lbl.setTextFill(Color.GREEN);
                } else {
                    lbl.setText("Nothing selected");
                    lbl.setTextFill(Color.RED);
                }
            }

        });

        VBox root = new VBox();
        root.getChildren().addAll(opt1, opt2, opt3, opt4, submit, lbl);
        Scene sc = new Scene(root);
        primaryStage.setScene(sc);
        primaryStage.setWidth(300);
        primaryStage.setHeight(300);
        primaryStage.setTitle("My App");
        primaryStage.show();
    }
}
