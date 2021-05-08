package jfx.uicontrols;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Links extends Application {
    public static void main(String[] args) {
        System.out.println("Launching the app...");
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Creating hyperlinks
        Hyperlink mygithub = new Hyperlink("https://github.com/Ritwik1999");
        // create a layout
        VBox root = new VBox(mygithub);
        // add layout to scene
        Scene sc = new Scene(root);
        // add scene to a stage
        primaryStage.setScene(sc);
        primaryStage.setWidth(300);
        primaryStage.setHeight(300);
        primaryStage.setTitle("My App");
        primaryStage.show();
    }
}
