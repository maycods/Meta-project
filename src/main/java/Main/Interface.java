package Main;

import java.io.IOException;

import static java.lang.Integer.parseInt;

        import javafx.application.Application;
        import javafx.fxml.FXML;
        import javafx.fxml.FXMLLoader;
        import javafx.scene.Node;
        import javafx.scene.Scene;
        import javafx.scene.control.*;
        import javafx.scene.layout.*;
        import javafx.scene.paint.Color;
        import javafx.scene.shape.Rectangle;
        import javafx.scene.text.Text;
        import javafx.stage.Stage;
        import org.controlsfx.control.textfield.TextFields;


        import java.io.IOException;
        import java.util.Arrays;
        import java.util.List;

        import static java.lang.Integer.parseInt;
class ChessBoard extends GridPane {
    public ChessBoard(int size) {

        int squareSize = 50;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Rectangle square = new Rectangle(squareSize, squareSize);
                square.setFill((i + j) % 2 == 0 ? Color.WHITE : Color.BLACK);
                add(square, i, j);
            }
        }
    }
}

public class  Interface  extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("interfacejava.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("N-REINES");


        Button Go = (Button) scene.lookup("#go");
        MenuButton choix = (MenuButton)scene.lookup("#choose");
        TextField textField = (TextField)scene.lookup("#taille");
        Button OK =(Button) scene.lookup("#ok");
        Text  INFOS = (Text)scene.lookup("#data");

        INFOS.setText("Infos:\n" +
                "NOMBRE DE NOEUDS GENERE\n"
                +"NOMBRE DE NOEUDS DEVELOPE\n");

        MenuItem bfs = choix.getItems().get(0);
        MenuItem dfs=choix.getItems().get(1);
        MenuItem h1=choix.getItems().get(2);
        MenuItem h2=choix.getItems().get(3);

        bfs.setOnAction(event -> {
            System.out.println("lancer bfs");

        });
        dfs.setOnAction(event -> {
            System.out.println("lancer dfs");
        });
        h1.setOnAction(event -> {
            System.out.println("lancer h1");
        });
        h2.setOnAction(event -> {
            System.out.println("lancer h2");
        });

        Go.setOnAction(event -> {
            System.out.println("Button clicked!");

            //lancer l algo
        });



        OK.setOnAction(event -> {
            String newText = textField.getText(); // Retrieve the updated value of the text field
            /***todo add exception user**/
            int a = parseInt(newText);
            System.out.println("Text entered: " + a); // Use the text field value as needed

            ChessBoard chessBoard = new ChessBoard(a);

            ScrollPane sp= (ScrollPane) scene.lookup("#t");
            Node content = sp.getContent();

            if (content instanceof AnchorPane) {
                AnchorPane ap = (AnchorPane) content;
                ap.setTopAnchor(chessBoard, 0.0);
                ap.setBottomAnchor(chessBoard, 0.0);
                ap.setRightAnchor(chessBoard, 0.0);
                ap.setLeftAnchor(chessBoard, 0.0);
                ap.getChildren().add(chessBoard);
            }



        });

    }
    public static void main(String[] args) {
        launch();
    }
}