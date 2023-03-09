package GUI;

import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

class ChessBoard extends GridPane {
    public ChessBoard(int size) {
        var cream = Color.web("#ebebd3");
        var green= Color.web("#749454");

        int squareSize = 50;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Rectangle square = new Rectangle(squareSize, squareSize);
                square.setFill((i + j) % 2 == 0 ? cream : green);
                add(square, i, j);
            }
        }
    }
}
//class ChessBoard extends GridPane {
//    public ChessBoard(int size) {
//
//        int squareSize = 50;
//
//        for (int i = 0; i < size; i++) {
//            for (int j = 0; j < size; j++) {
//                Rectangle square = new Rectangle(squareSize, squareSize);
//                square.setFill((i + j) % 2 == 0 ? Color.WHITE : Color.BLACK);
//                add(square, i, j);
//            }
//        }
//    }
//}
