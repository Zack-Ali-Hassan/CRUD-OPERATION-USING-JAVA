package com.example.crudoperation;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class HelloApplication extends Application {
    private double xOffSet=0;
    private double yOffSet=0;
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Login-view.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().getClass().getResource("style.css");
        root.setOnMousePressed(event->{
            xOffSet= event.getSceneX();
            yOffSet= event.getSceneY();
        });
        root.setOnMouseDragged(event->{
            stage.setX(event.getScreenX() - xOffSet);
            stage.setY(event.getScreenY()- yOffSet);
        });
        stage.setTitle("Login Student Management System");
        stage.initStyle(StageStyle.UNDECORATED);
//        stage.initStyle(StageStyle.UTILITY);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}