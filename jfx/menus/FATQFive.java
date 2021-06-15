// My mistakes: import javafx.scene.* does not import everything, it has to be included explicitly
// Line 39, I wrote newViewMenu.getItem() instead of newViewMenu.getItems()

package jfx.menus;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class FATQFive extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        MenuBar mainMenu = new MenuBar();
        Menu file = new Menu("File");
        Menu edit = new Menu("Edit");
        Menu view = new Menu("View");
        Menu history = new Menu("History");
        Menu bookmarks = new Menu("Bookmarks");
        Menu tools = new Menu("Tools");
        Menu help = new Menu("Help");

        mainMenu.getMenus().addAll(file, edit, view, history, bookmarks, tools, help);
        Menu newViewMenu = new Menu("Toolbars");
        Menu newBkmsMenu = new Menu("Bookmarks Toolbar");
        MenuItem aShow = new MenuItem("Always Show");
        MenuItem oShow = new MenuItem("Only show on new tab");
        MenuItem nShow = new MenuItem("Never Show \t Ctrl+Shift+B");
        newBkmsMenu.getItems().addAll(aShow, oShow, nShow);
        MenuItem mb = new MenuItem("Menu Bar");
        MenuItem ct = new MenuItem("Customize Toolbar...");
        newViewMenu.getItems().addAll(mb, newBkmsMenu, ct);
        MenuItem sb = new MenuItem("Sidebar");
        MenuItem z = new MenuItem("Zoom");
        MenuItem ps = new MenuItem("Page Style");
        MenuItem te = new MenuItem("Text Encoding");
        MenuItem fs = new MenuItem("Full Screen \t F11");
        view.getItems().addAll(newViewMenu, sb, z, ps, te, fs);

        BorderPane root = new BorderPane();
        root.setTop(mainMenu);
        Scene sc = new Scene(root);
        primaryStage.setScene(sc);
        primaryStage.show();
    }
}
