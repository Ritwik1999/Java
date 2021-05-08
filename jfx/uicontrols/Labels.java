package jfx.uicontrols;

import java.io.FileInputStream;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class Labels extends Application {
    public static void main(String[] args) {
        System.out.println("Launching the app...");
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create a label
        Label lbl = new Label("Enter your name");
        lbl.setText("Label text changed to some other random statement to check if or not the text wraps or not. It will not until mentioned explicitly");
        lbl.setWrapText(true);
        lbl.setTextFill(Color.RED);
        lbl.setFont(new Font("Times New Roman", 32));
        lbl.setTextAlignment(TextAlignment.JUSTIFY);
        // Setting an image for your label
        FileInputStream fin = new FileInputStream("jfx/images/HBox.jpg");
        Image img = new Image(fin);
        ImageView imgview = new ImageView(img);
        Label lbl2 = new Label("Testing labels with images", imgview);
        // Add label to layout
        HBox root = new HBox();
        root.getChildren().add(lbl);
        root.getChildren().add(lbl2);
        // Add layout to scene
        Scene sc = new Scene(root);
        // Add scene to stage
        primaryStage.setHeight(500);
        primaryStage.setWidth(500);
        primaryStage.setScene(sc);
        primaryStage.show();
    }
}
