package jfx.uicontrols;

import java.io.File;
import java.io.FileInputStream;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Buttons extends Application {
    public static void main(String[] args) {
        System.out.println("Launching the app...");
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Add a button
        Button btn1 = new Button();
        btn1.setText("This is some random long sentence to check the wrapping of text inside a button, which is enabled in the next statement");
        btn1.setWrapText(true);
        btn1.setDisable(true);  // disable the button
        // Adding an image on the button
        File obj = new File("jfx/images/HBox.jpg");
        FileInputStream fin = new FileInputStream(obj);
        Image img = new Image(fin);
        ImageView imgview = new ImageView(img);
        Button btn2 = new Button("Clik here", imgview);
        // create a layout
        HBox root = new HBox(btn1);
        root.getChildren().add(btn2);
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
