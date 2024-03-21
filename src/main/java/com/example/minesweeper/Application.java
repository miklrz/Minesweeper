package com.example.minesweeper;

import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {

        try {
            Image img = new Image("src/res/icons/testLogo.jpg");
            stage.getIcons().add(img);
        }
        catch(Exception e) {
            System.out.println("Файл не найден! + " + e);
        }

        Group root = new Group();
        Scene scene = new Scene(root,600,600, Color.ALICEBLUE);

        stage.setTitle("Minesweeper");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}