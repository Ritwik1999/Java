package jfx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class JFXIntro extends Application {
    public static void main(String[] args) {
        System.out.println("Launching the app...");
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Add a control object (button)
        Button btn1 = new Button("Click me");
        Button btn2 = new Button("Click me");
        Button btn3 = new Button("Click me");
        // Define the layout; HBox = Horizontal Box; VBox = Vertical Box
        HBox root = new HBox();
        // set spacing between buttons
        root.setSpacing(20);
        // add control to layout
        root.getChildren().add(btn1);
        root.getChildren().add(btn2);
        root.getChildren().add(btn3);
        // add layout to scene
        Scene sc = new Scene(root);
        // add scene to a stage
        primaryStage.setScene(sc);
        primaryStage.setWidth(500);
        primaryStage.setHeight(500);    // Fallback dimensions for when the app is not in full screen mode
        primaryStage.setTitle("My App");
        primaryStage.setFullScreen(true);
        primaryStage.show();
        // primaryStage.close();
    }
}
