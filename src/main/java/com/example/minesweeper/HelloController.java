package com.example.minesweeper;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;


public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    private char[][] gameField = new char[10][10];
    @FXML
    void checkMine(ActionEvent event) {
        Button btn = (Button)event.getSource();
        int rowIndex = GridPane.getRowIndex(btn) == null ? 0 : GridPane.getRowIndex(btn);
        int columnIndex = GridPane.getColumnIndex(btn) == null ? 0 : GridPane.getColumnIndex(btn);
        btn.setText("qwe");
        System.out.printf("r: %d    c: %d\n",rowIndex,columnIndex);
//      проверка на взрыв  gameField[columnIndex][rowIndex];
    }

    @FXML
    void initialize() {

    }

}
