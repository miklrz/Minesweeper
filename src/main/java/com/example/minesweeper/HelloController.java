package com.example.minesweeper;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;


public class HelloController {

    private boolean gameStarted = false;

    static char[][] getMinesArr(int N, int mines){
        char[][] arr = new char[N][N];
        int count = 0;
        while(count < mines){
            int newPath = ((int) (Math.random() * (N-1)*(N-1)));
            if(arr[newPath%(N-1)][newPath/(N-1)] != 'x') {
                arr[newPath%(N-1)][newPath/(N-1)] = 'x';
                count ++;
            }
        }
        return arr;
    }

    static void startGame(){}
    static void endGame(){}


    static int countMinesAround(char[][] gameField,int columnIndex, int rowIndex){
        if(gameField[columnIndex][rowIndex] == 'x'){
            endGame();
        }
        int count = 0;
        for(int x = columnIndex-1; x <= columnIndex+1; ++x){
            for(int y = rowIndex-1; y <= rowIndex+1; ++y){
                if(x == columnIndex && y == rowIndex) continue;
                try{
                    if(gameField[x][y] == 'x') count++;
                }
                catch(ArrayIndexOutOfBoundsException ignored){}
            }
        }
        return count;
    }

    char[][] gameField = getMinesArr(10,30);

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;


    @FXML
    void checkMine(ActionEvent event) {
        Button btn = (Button)event.getSource();
        int rowIndex = GridPane.getRowIndex(btn) == null ? 0 : GridPane.getRowIndex(btn);
        int columnIndex = GridPane.getColumnIndex(btn) == null ? 0 : GridPane.getColumnIndex(btn);


//        System.out.printf("r: %d    c: %d\n",rowIndex,columnIndex);
        if(gameField[columnIndex][rowIndex] == 'x') btn.setText("пиздец!");
        else{
            btn.setText("Круто");
        }

    }

    @FXML
    void initialize() {

    }

}
