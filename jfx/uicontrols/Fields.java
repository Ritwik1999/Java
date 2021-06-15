package jfx.uicontrols;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Fields extends Application {
    public static void main(String[] args) {
        System.out.println("Launching the app...");
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        TextField text = new TextField();
        // setMaxWidth is for only the UI, not the length of the input in the text field
        text.setMaxWidth(100);
        PasswordField password = new PasswordField();
        password.setMaxWidth(300);

        // Add fields to layout
        VBox root = new VBox();
        root.getChildren().addAll(text, password);
        // Add layout to scene
        Scene sc = new Scene(root);
        // Add scene to stage
        primaryStage.setHeight(500);
        primaryStage.setWidth(500);
        primaryStage.setScene(sc);
        primaryStage.show();
    }
}
