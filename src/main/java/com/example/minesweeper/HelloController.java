package com.example.minesweeper;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class HelloController {

    @FXML
    private Button
            button00,button01,button02,button03,button04,button05,button06,button07,button08,button09,
            button10,button11,button12,button13,button14,button15,button16,button17,button18,button19,
            button20,button21,button22,button23,button24,button25,button26,button27,button28,button29,
            button30,button31,button32,button33,button34,button35,button36,button37,button38,button39,
            button40,button41,button42,button43,button44,button45,button46,button47,button48,button49,
            button50,button51,button52,button53,button54,button55,button56,button57,button58,button59,
            button60,button61,button62,button63,button64,button65,button66,button67,button68,button69,
            button70,button71,button72,button73,button74,button75,button76,button77,button78,button79,
            button80,button81,button82,button83,button84,button85,button86,button87,button88,button89,
            button90,button91,button92,button93,button94,button95,button96,button97,button98,button99;

    List<Button> buttons;
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
        int rowIndex = GridPane.getRowIndex(btn) == null ? 0 :  GridPane.getRowIndex(btn);
        int columnIndex = GridPane.getColumnIndex(btn) == null ? 0 : GridPane.getColumnIndex(btn);
        btn.setText("qwe");
        btn.setDisable(true);
//        ActionEvent qwe = new ActionEvent();
//        qwe.getTarget();



//        System.out.printf("r: %d    c: %d\n",rowIndex,columnIndex);
//        if(gameField[columnIndex][rowIndex] == 'x') btn.setText("пиздец!");
//        else{
//            btn.setText("Круто");
//        }

    }

    @FXML
    void initialize() {
        buttons = new ArrayList<>(Arrays.asList(
                button00,button01,button02,button03,button04,button05,button06,button07,button08,button09,
                button10,button11,button12,button13,button14,button15,button16,button17,button18,button19,
                button20,button21,button22,button23,button24,button25,button26,button27,button28,button29,
                button30,button31,button32,button33,button34,button35,button36,button37,button38,button39,
                button40,button41,button42,button43,button44,button45,button46,button47,button48,button49,
                button50,button51,button52,button53,button54,button55,button56,button57,button58,button59,
                button60,button61,button62,button63,button64,button65,button66,button67,button68,button69,
                button70,button71,button72,button73,button74,button75,button76,button77,button78,button79,
                button80,button81,button82,button83,button84,button85,button86,button87,button88,button89,
                button90,button91,button92,button93,button94,button95,button96,button97,button98,button99
        ));
    }

    @FXML
    void resetGame(ActionEvent event) {

    }



}
