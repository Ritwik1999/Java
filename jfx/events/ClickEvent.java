package jfx.events;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ClickEvent extends Application {
    public static void main(String[] args) {
        System.out.println("Launching the app...");
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // onmouseclicked event
        Label lbl1 = new Label("Hoverover here and click");
        Label lbl2 = new Label();

        lbl1.setOnMouseClicked(new EventHandler<Event>() {

            @Override
            public void handle(Event arg0) {
                lbl2.setText("You clicked on the label");
                lbl2.setTextFill(Color.GREEN);
            }

        });

        BorderPane root = new BorderPane();
        root.setCenter(lbl1);
        root.setTop(lbl2);
        Scene sc = new Scene(root);
        primaryStage.setScene(sc);
        primaryStage.setWidth(300);
        primaryStage.setHeight(300);
        primaryStage.setTitle("My App");
        primaryStage.show();
    }
}
