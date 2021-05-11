package guidb;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;

import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args) {
        System.out.println("Launching the app...");
        launch();
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            RegistrationForm form = new RegistrationForm();
            form.showForm(primaryStage);
        } catch (Exception e) {
            System.out.println("Exception occurred");
            System.out.println(e.getClass());
            System.out.println(e.getCause());
            e.printStackTrace();
        }
    }
}

class RegistrationForm {
    Label nameLbl;
    TextField nametxt;
    Label passLbl;
    PasswordField passtxt;
    Label genderLbl;
    RadioButton opt1;
    RadioButton opt2;
    Label subjectLbl;
    CheckBox chk1;
    CheckBox chk2;
    CheckBox chk3;
    Label countryLbl;
    ComboBox<String> cbox;
    Button submit;
    Label messageLbl;

    public void showForm(Stage primaryStage) {
        nameLbl = new Label("Enter your name");
        nametxt = new TextField();
        passLbl = new Label("Enter your password");
        passtxt = new PasswordField();
        ToggleGroup group = new ToggleGroup();
        genderLbl = new Label("Select your gender");
        opt1 = new RadioButton("Male");
        opt2 = new RadioButton("Female");
        opt1.setToggleGroup(group);
        opt2.setToggleGroup(group);
        subjectLbl = new Label("Select your favourite subjects");
        chk1 = new CheckBox("English");
        chk2 = new CheckBox("Computer Science");
        chk3 = new CheckBox("Physics");
        countryLbl = new Label("Select your country");
        cbox = new ComboBox<>();
        cbox.getItems().addAll("India", "US", "UK");
        submit = new Button("Submit");
        messageLbl = new Label();

        submit.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                boolean canProceed = validateForm();
                if (canProceed) {
                    String gender = "";
                    if (opt1.isSelected()) {
                        gender = opt1.getText();
                    }
                    if (opt2.isSelected()) {
                        gender = opt2.getText();
                    }
                    String selectedSubjects = "";
                    if (chk1.isSelected()) {
                        selectedSubjects += chk1.getText() + " ";
                    }
                    if (chk2.isSelected()) {
                        selectedSubjects += chk2.getText() + " ";
                    }
                    if (chk3.isSelected()) {
                        selectedSubjects += chk3.getText();
                    }
                    Student s = new Student(nametxt.getText(), passtxt.getText(), gender, selectedSubjects,
                            (String) cbox.getValue());
                    try {
                        boolean result = s.insertStudentRecord();
                        if (result) {
                            messageLbl.setText("Record inserted successfully");
                            messageLbl.setTextFill(Color.GREEN);
                        } else {
                            messageLbl.setTextFill(Color.RED);
                        }
                    } catch (Exception e) {
                        System.out.println("Exception occurred");
                        System.out.println(e.getClass());
                        System.out.println(e.getMessage());
                    }
                }
            }
        });

        GridPane root = new GridPane();
        root.add(nameLbl, 0, 1);
        root.add(nametxt, 1, 1);
        root.add(passLbl, 0, 2);
        root.add(passtxt, 1, 2);
        root.add(genderLbl, 0, 3);
        root.add(opt1, 0, 4);
        root.add(opt2, 0, 5);
        root.add(subjectLbl, 0, 6);
        root.add(chk1, 0, 7);
        root.add(chk2, 0, 8);
        root.add(chk3, 0, 9);
        root.add(countryLbl, 0, 10);
        root.add(cbox, 1, 10);
        root.add(submit, 0, 11);
        root.add(messageLbl, 0, 12);
        Scene sc = new Scene(root);
        primaryStage.setScene(sc);
        primaryStage.setTitle("GUI + JDBC App");
        primaryStage.setHeight(500);
        primaryStage.setWidth(500);
        primaryStage.show();
    }

    public boolean validateForm() {
        boolean canProceed = true;
        if (nametxt.getText().isEmpty() && canProceed) {
            messageLbl.setText("Enter your name");
            canProceed = false;
        }

        if (passtxt.getText().isEmpty() && canProceed) {
            messageLbl.setText("Enter your password");
            canProceed = false;
        }

        if (!opt1.isSelected() && !opt2.isSelected() && canProceed) {
            messageLbl.setText("Select your gender");
            canProceed = false;
        }

        if (!chk1.isSelected() && !chk2.isSelected() && !chk3.isSelected() && canProceed) {
            messageLbl.setText("Select your favourite subjects");
            canProceed = false;
        }

        if (cbox.getValue() == null && canProceed) {
            messageLbl.setText("Select your country");
            canProceed = false;
        }

        return canProceed;
    }
};

class Student {
    private String name;
    private String password;
    private String gender;
    private String subjects;
    private String country;

    Student(String name, String password, String gender, String subjects, String country) {
        this.name = name;
        this.password = password;
        this.gender = gender;
        this.subjects = subjects;
        this.country = country;
    }

    public boolean insertStudentRecord() throws Exception {
        DBMSConnection dbmsconnect = new DBMSConnection("jdbc:mysql://localhost:3306/vit", "root", "");
        Connection conn = dbmsconnect.getConnection();
        String sql = "insert into student1 values (?,?,?,?,?);";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, name);
        stmt.setString(2, password);
        stmt.setString(3, gender);
        stmt.setString(4, subjects);
        stmt.setString(5, country);
        int affectedRows = stmt.executeUpdate();

        dbmsconnect.closeConnection(conn, stmt);
        return (affectedRows > 0);
    }
}

class DBMSConnection {
    String url;
    String username;
    String password;

    DBMSConnection(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public Connection getConnection() throws InstantiationException, IllegalAccessException, IllegalArgumentException,
            InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException, SQLException {
        Connection conn = null;
        Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        conn = DriverManager.getConnection(url, username, password);
        System.out.println("Connection Established");
        return conn;
    }

    public void closeConnection(Connection conn, Statement stmt) throws SQLException {
        conn.close();
        stmt.close();
        System.out.println("Connection closed");
    }
}