/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package javadatabase;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 *
 * @author moham
 */
public class JavaDataBase extends Application {
    
    GridPane gridPane;
    DataBaseConnection db = null;
    EmployeeClass Emp = null;
    Integer demployeeId;

    @Override
    public void start(Stage primaryStage) {

          gridPane = new GridPane();
          Label IDLabel = new Label("ID"); 
          IDLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
          GridPane.setMargin(IDLabel, new Insets(20, 50,20,50));
           gridPane.add(IDLabel, 0, 0);
     
          TextField IDField = new TextField();
           IDField.setEditable(false);
          IDField.setPrefHeight(40);
          IDField.setPrefWidth(300);
          gridPane.add(IDField,1,0);
        

        Label nameLabel = new Label("First Name  ");
        nameLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        GridPane.setMargin(nameLabel, new Insets(20, 0,20,20));
        gridPane.add(nameLabel, 0,1);

        // Add Name Text Field
        TextField nameField = new TextField();
        nameField.setPrefHeight(40);
        gridPane.add(nameField, 1,1);
         

          Label mLabel = new Label("Middle Name"); 
          mLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
          GridPane.setMargin(mLabel, new Insets(20, 50,20,20));
           gridPane.add(mLabel, 0, 2);
     
          TextField mNameField = new TextField();
          mNameField.setPrefHeight(40);
          mNameField.setPrefWidth(300);
          gridPane.add(mNameField,1,2);
        

        Label lLabel = new Label("Last Name  ");
        lLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        GridPane.setMargin(lLabel, new Insets(20, 0,20,20));
        gridPane.add(lLabel, 0,3);

        // Add Name Text Field
        TextField lnameField = new TextField();
        lnameField.setPrefHeight(40);
        gridPane.add(lnameField, 1,3);


        Label EmailLabel = new Label("Email  ");
        EmailLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        GridPane.setMargin(EmailLabel, new Insets(20, 0,20,20));
        gridPane.add(EmailLabel, 0,4);

        // Add Name Text Field
        TextField EmailField = new TextField();
        EmailField.setPrefHeight(40);
        gridPane.add(EmailField, 1,4);


        Label phoneLabel = new Label("Phone No.  ");
        phoneLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        GridPane.setMargin(phoneLabel, new Insets(20, 0,20,20));
        gridPane.add(phoneLabel, 0,5);

        // Add Name Text Field
        TextField phoneField = new TextField();
        phoneField.setPrefHeight(40);
        gridPane.add(phoneField, 1,5);

                // Add  New Button
        Button NewButton = new Button("New..");
        NewButton.setPrefHeight(40);
        NewButton.setPrefWidth(80);
        gridPane.add(NewButton, 0, 7,2, 1);
        GridPane.setHalignment(NewButton, HPos.CENTER);
        GridPane.setMargin(NewButton, new Insets(20, 0,20,0)); 
                // Add Update Button
        Button UpdateButton = new Button("Update");
        UpdateButton.setPrefHeight(40);
        UpdateButton.setPrefWidth(80);
        gridPane.add(UpdateButton, 0, 7,3, 1);
        GridPane.setHalignment(UpdateButton, HPos.CENTER);
        GridPane.setMargin(UpdateButton, new Insets(20, 0,20,200)); 
                // Add Delete Button
        Button DeleButton = new Button("Delete");
        DeleButton.setPrefHeight(40);
        DeleButton.setPrefWidth(80);
        gridPane.add(DeleButton, 0, 7,4, 1);
        GridPane.setHalignment(DeleButton, HPos.CENTER);
        GridPane.setMargin(DeleButton, new Insets(20, 0,20,400)); 
                // Add First Button
        Button FirstButton = new Button("First");
        FirstButton.setPrefHeight(40);
        FirstButton.setPrefWidth(80);
        gridPane.add(FirstButton, 0, 7,5, 1);
        GridPane.setHalignment(FirstButton, HPos.CENTER);
        GridPane.setMargin(FirstButton, new Insets(20, 0,20,500)); 
            // Add Previous Button
        Button PreviousButton = new Button("Previous");
        PreviousButton.setPrefHeight(40);
        PreviousButton.setPrefWidth(80);
        gridPane.add(PreviousButton, 0, 7,6, 1);
        GridPane.setHalignment(PreviousButton, HPos.CENTER);
        GridPane.setMargin(PreviousButton, new Insets(20, 0,20,600)); 
                // Add Next Button
        Button NextButton = new Button("Next");
        NextButton.setPrefHeight(40);
        NextButton.setPrefWidth(80);
        gridPane.add(NextButton, 0, 7,7, 1);
        GridPane.setHalignment(NextButton, HPos.CENTER);
        GridPane.setMargin(NextButton, new Insets(20, 0,20,700)); 
                // Add Last Button
        Button LastButton = new Button("Last");
        LastButton.setPrefHeight(40);
        LastButton.setPrefWidth(80);
        gridPane.add(LastButton, 0, 7,8, 1);
        GridPane.setHalignment(LastButton, HPos.CENTER);
        GridPane.setMargin(LastButton, new Insets(20, 0,20,800)); 


/********************************** Actions **************************************************/

 FirstButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                try {
                    db = new DataBaseConnection();
                    Emp = db.getFirstEmployee();
                    if (Emp != null) {
                        demployeeId = Emp.getId();
                        IDField.setText(demployeeId.toString());
                        nameField.setText(Emp.getfName());
                        mNameField.setText(Emp.getmName());
                        lnameField.setText(Emp.getlName());
                        EmailField.setText(Emp.getEmail());
                        phoneField.setText(Emp.getPhone());

                    }

                } catch (SQLException ex) {
                    Logger.getLogger(JavaDataBase.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(JavaDataBase.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });


   LastButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                try {
                    db = new DataBaseConnection();
                    Emp = db.getLastEmployee();
                    if (Emp != null) {
                        demployeeId = Emp.getId();
                        IDField.setText(demployeeId.toString());
                        nameField.setText(Emp.getfName());
                        mNameField.setText(Emp.getmName());
                        lnameField.setText(Emp.getlName());
                        EmailField.setText(Emp.getEmail());
                        phoneField.setText(Emp.getPhone());

                    }

                } catch (SQLException ex) {
                    Logger.getLogger(JavaDataBase.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(JavaDataBase.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

 PreviousButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                try {
                    db = new DataBaseConnection();
                    Emp = db.getPreviousEmployee();
                    if (Emp != null) {
                        demployeeId = Emp.getId();
                        IDField.setText(demployeeId.toString());
                        nameField.setText(Emp.getfName());
                        mNameField.setText(Emp.getmName());
                        lnameField.setText(Emp.getlName());
                        EmailField.setText(Emp.getEmail());
                        phoneField.setText(Emp.getPhone());

                    }

                } catch (SQLException ex) {
                    Logger.getLogger(JavaDataBase.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(JavaDataBase.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

   NextButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                try {
                    db = new DataBaseConnection();
                    Emp = db.getNextEmployee();
                    if (Emp != null) {
                        demployeeId = Emp.getId();
                        IDField.setText(demployeeId.toString());
                        nameField.setText(Emp.getfName());
                        mNameField.setText(Emp.getmName());
                        lnameField.setText(Emp.getlName());
                        EmailField.setText(Emp.getEmail());
                        phoneField.setText(Emp.getPhone());

                    }

                } catch (SQLException ex) {
                    Logger.getLogger(JavaDataBase.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(JavaDataBase.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

 NewButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                try {
                    Emp = new EmployeeClass(1, nameField.getText(), mNameField.getText(), lnameField.getText(), EmailField.getText(), phoneField.getText());
                    db = new DataBaseConnection();
                    db.addNewRow(Emp);
                    IDField.setText("");
                    nameField.setText("");
                    mNameField.setText("");
                    lnameField.setText("");
                    EmailField.setText("");
                    phoneField.setText("");
                } catch (SQLException ex) {
                    Logger.getLogger(JavaDataBase.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(JavaDataBase.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

 UpdateButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                try {
                    if (!IDField.getText().isEmpty()) {
                        Emp = new EmployeeClass(Integer.parseInt(IDField.getText()), nameField.getText(), mNameField.getText(), lnameField.getText(), EmailField.getText(), phoneField.getText());
                        db = new DataBaseConnection();
                        db.updateRow(Emp);
                    }

                } catch (SQLException ex) {
                    Logger.getLogger(JavaDataBase.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(JavaDataBase.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

        DeleButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                try {
                    if (!IDField.getText().isEmpty()) {
                        db = new DataBaseConnection();
                        db.DeleteRow(IDField.getText());
                        IDField.setText("");
                        nameField.setText("");
                        mNameField.setText("");
                        lnameField.setText("");
                        EmailField.setText("");
                        phoneField.setText("");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(JavaDataBase.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(JavaDataBase.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });


/********************************************************************************************/

        Scene scene = new Scene(gridPane, 1000, 500);
        
        primaryStage.setTitle("JavaDataBase!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
    
}
