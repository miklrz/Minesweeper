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
import javafx.scene.text.Text;

public class Controller {

    @FXML
    private Text endText;

    @FXML
    private Button
            button00,button10,button20,button30,button40,button50,button60,button70,button80,button90,
            button01,button11,button21,button31,button41,button51,button61,button71,button81,button91,
            button02,button12,button22,button32,button42,button52,button62,button72,button82,button92,
            button03,button13,button23,button33,button43,button53,button63,button73,button83,button93,
            button04,button14,button24,button34,button44,button54,button64,button74,button84,button94,
            button05,button15,button25,button35,button45,button55,button65,button75,button85,button95,
            button06,button16,button26,button36,button46,button56,button66,button76,button86,button96,
            button07,button17,button27,button37,button47,button57,button67,button77,button87,button97,
            button08,button18,button28,button38,button48,button58,button68,button78,button88,button98,
            button09,button19,button29,button39,button49,button59,button69,button79,button89,button99;

    List<Button> buttons;
//    private boolean gameStarted = false;

    char[][] gameField;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;


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



    static int countMinesAround(char[][] gameField,int columnIndex, int rowIndex){
        if(gameField[columnIndex][rowIndex] == 'x'){
            return -1;
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

    @FXML
    void checkMine(ActionEvent event) {
        Button btn = (Button)event.getSource();
        int rowIndex = GridPane.getRowIndex(btn) == null ? 0 :  GridPane.getRowIndex(btn);
        int columnIndex = GridPane.getColumnIndex(btn) == null ? 0 : GridPane.getColumnIndex(btn);
//        btn.setDisable(true);
        String count = String.valueOf(countMinesAround(gameField,columnIndex,rowIndex));
        if(gameField[columnIndex][rowIndex] == 'x'){
            buttons.forEach(this::buttonOff);
            endText.setText("Ты проиграл челик!");
        }
        openZeroButtons(gameField,columnIndex,rowIndex);

        System.out.println(gameField[columnIndex][rowIndex] + " " + buttons.get(columnIndex*9+rowIndex) +" "+ columnIndex +" "+ rowIndex);
        Button temp = buttons.get(columnIndex*rowIndex);
        temp.setDisable(true);
//        openNear(gameField,columnIndex,rowIndex);


//        if(countMinesAround(gameField,columnIndex,rowIndex) == 0){
//            openButtons();
//        }
//        else {
//            openNear();
//        }
    }

    void openZeroButtons(char[][] gameField, int columnIndex, int rowIndex) {
//        for (int x = columnIndex - 1; x <= columnIndex + 1; ++x) {
//            for (int y = rowIndex - 1; y <= rowIndex + 1; ++y) {
//                System.out.println(x + " " + y);
//                try {
//                    if(x==columnIndex && y==rowIndex) continue;
//                    if (gameField[x][y]!='x') {
//                        Button tempButton = buttons.get(columnIndex * 9 + rowIndex);
//                        tempButton.setDisable(true);
////                        openZeroButtons(gameField, x, y);
//                    }
//                } catch (ArrayIndexOutOfBoundsException ignored) {
//                }
//            }
//        }
    }

    void openNear(char[][] gameField, int columnIndex, int rowIndex){
//        for (int x = columnIndex - 1; x <= columnIndex + 1; ++x) {
//            for (int y = rowIndex - 1; y <= rowIndex + 1; ++y) {
//                try {
//                    if (countMinesAround(gameField, x, y) == 0) {
//                        Button tempButton = buttons.get(x * 9 + y);
//                        tempButton.setDisable(true);
//                        openButtons(gameField, x, y);
//                    }
//                } catch (Exception ignored) {
//                }
//            }
//        }
    }



    @FXML
    void initialize() {
        gameField =  getMinesArr(10,5);
        buttons = new ArrayList<>(Arrays.asList(
                button00,button10,button20,button30,button40,button50,button60,button70,button80,button90,
                button01,button11,button21,button31,button41,button51,button61,button71,button81,button91,
                button02,button12,button22,button32,button42,button52,button62,button72,button82,button92,
                button03,button13,button23,button33,button43,button53,button63,button73,button83,button93,
                button04,button14,button24,button34,button44,button54,button64,button74,button84,button94,
                button05,button15,button25,button35,button45,button55,button65,button75,button85,button95,
                button06,button16,button26,button36,button46,button56,button66,button76,button86,button96,
                button07,button17,button27,button37,button47,button57,button67,button77,button87,button97,
                button08,button18,button28,button38,button48,button58,button68,button78,button88,button98,
                button09,button19,button29,button39,button49,button59,button69,button79,button89,button99
        ));
        endText.setText("");
    }

    @FXML
    void resetGame(ActionEvent event) {
        buttons.forEach(this::resetButton);
        initialize();
    }

    void resetButton(Button button){
        button.setDisable(false);
        button.setText("");
    }
    void buttonOff(Button button){
        button.setDisable(true);
    }



}
