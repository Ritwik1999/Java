package jfx.menus;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Menus extends Application {
    public static void main(String[] args) {
        System.out.println("Launching the app...");
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create a menubar
        MenuBar mainMenu = new MenuBar();
        // Create Menus
        Menu file = new Menu("File");
        Menu edit = new Menu("Edit");
        Menu source = new Menu("Source");
        Menu refactor = new Menu("Refactor");
        // Add Menus to Menubar
        mainMenu.getMenus().add(file);
        mainMenu.getMenus().add(edit);
        mainMenu.getMenus().add(source);
        mainMenu.getMenus().add(refactor);

        // Add menu items, they may have submenus
        Menu newFileMenu = new Menu("New");
        MenuItem javaproject = new MenuItem("Java Project");
        MenuItem project = new MenuItem("Project");
        MenuItem class1 = new MenuItem("Class");
        MenuItem package1 = new MenuItem("Package");
        newFileMenu.getItems().add(javaproject);
        newFileMenu.getItems().add(project);
        newFileMenu.getItems().add(class1);
        newFileMenu.getItems().add(package1);

        MenuItem openFile = new MenuItem("Open File");
        MenuItem openProject = new MenuItem("Open Project from File System");
        // Attach menu items to a menu
        file.getItems().add(newFileMenu);
        file.getItems().add(openFile);
        file.getItems().add(openProject);

        // Add menu items, they may have submenus
        Menu undoMenu = new Menu("Undo typing");
        MenuItem undonow = new MenuItem("Undo Now");
        MenuItem undolater = new MenuItem("Undo Later");
        undoMenu.getItems().add(undonow);
        undoMenu.getItems().add(undolater);

        MenuItem redo = new MenuItem("Redo");
        MenuItem cut = new MenuItem("Cut");
        MenuItem copy = new MenuItem("Copy");
        // Attach menu items to a menu
        edit.getItems().add(undoMenu);
        edit.getItems().add(redo);
        edit.getItems().add(cut);
        edit.getItems().add(copy);

        // Add Menubar to layout
        BorderPane root = new BorderPane();
        root.setTop(mainMenu);
        // Add layout to Scene
        Scene sc = new Scene(root);
        // Add Scene to stage
        primaryStage.setTitle("Ritwik\'s Menu");
        primaryStage.setHeight(500);
        primaryStage.setWidth(500);
        primaryStage.setScene(sc);
        primaryStage.show();
    }
}