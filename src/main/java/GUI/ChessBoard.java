package GUI;

import it.unimi.dsi.fastutil.ints.IntArrayList;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

class ChessBoard extends GridPane {
    public ChessBoard(int size, IntArrayList sol, double width, double height) {

        var cream = Color.web("#ebebd3");
        var green = Color.web("#749454");


        var blackQueenImg = new ImagePattern(new Image("/blackqueen.png"));
        int squareWidth = (int) (width / size);
        int squareHeight = (int) (height / size);


        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Rectangle bg = new Rectangle(squareWidth, squareHeight);
                StackPane pane = new StackPane(bg);
                if (sol.get(i) == j) {

                    Rectangle square = new Rectangle(squareWidth - 4, squareHeight - 4);
                    square.setFill(blackQueenImg);
                    pane.getChildren().add(square);
                }
                bg.setFill((i + j) % 2 == 0 ? cream : green);
                add(pane, i, j);
            }
        }
    }
}