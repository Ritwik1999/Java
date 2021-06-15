package jfx.events;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class RadioButtonEvent extends Application {
    public static void main(String[] args) {
        System.out.println("Launching the app....");
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        ToggleGroup group = new ToggleGroup();
        RadioButton opt1 = new RadioButton("Computer Science");
        RadioButton opt2 = new RadioButton("Physics");
        RadioButton opt3 = new RadioButton("Chemistry");
        RadioButton opt4 = new RadioButton("Maths");
        opt1.setToggleGroup(group);
        opt2.setToggleGroup(group);
        opt3.setToggleGroup(group);
        opt4.setToggleGroup(group);
        Button submit = new Button("Submit");
        Label lbl = new Label();

        submit.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                String selectedOpt;
                lbl.setText("");

                if (opt1.isSelected()) {
                    selectedOpt = opt1.getText();
                } else if (opt2.isSelected()) {
                    selectedOpt = opt2.getText();
                } else if (opt3.isSelected()) {
                    selectedOpt = opt3.getText();
                } else if (opt4.isSelected()) {
                    selectedOpt = opt4.getText();
                } else {
                    selectedOpt = "";
                }

                lbl.setFont(new Font("Times New Roman", 32));
                if (!selectedOpt.isEmpty()) {
                    lbl.setText("You selected " + selectedOpt);
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