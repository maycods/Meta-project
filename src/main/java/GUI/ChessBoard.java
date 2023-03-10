package GUI;

import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import java.util.ArrayList;
import java.util.Arrays;

class ChessBoard extends GridPane {

    public ChessBoard(int size, int[] sol) {
        //assets..
        var cream = Color.web("#ebebd3");
        var green= Color.web("#749454");

        System.out.println(Arrays.toString(sol));

        var blackQueenImg = new ImagePattern(new Image("/blackqueen.png"));
        int squareSize = 55;


        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Rectangle bg = new Rectangle(squareSize , squareSize );
                StackPane pane = new StackPane(bg);
                if (sol[i] == j){

                    Rectangle square = new Rectangle(squareSize -4, squareSize -4);
                    square.setFill(blackQueenImg);
                    pane.getChildren().add(square);
                }
                bg.setFill((i + j) % 2 == 0 ? cream : green);
                add(pane, i, j);
            }
        }
    }
    public ChessBoard(int size) {
        //assets..
        var cream = Color.web("#ebebd3");
        var green= Color.web("#749454");
//        var blackQueenImg = new ImagePattern(new Image("/blackqueen.png"));

        int squareSize = 55;


        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Rectangle bg = new Rectangle(squareSize , squareSize );
//                Rectangle square = new Rectangle(squareSize -4, squareSize -4);
//                square.setFill(blackQueenImg);
                bg.setFill((i + j) % 2 == 0 ? cream : green);
//                StackPane pane = new StackPane(bg, square);
                add(bg, i, j);
            }
        }
    }
}
