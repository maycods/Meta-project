package GUI;

import java.io.IOException;

import static java.lang.Integer.parseInt;

import Main.BFS;
import Main.DFS;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
        import javafx.scene.Node;
import javafx.scene.Scene;
        import javafx.scene.control.*;
        import javafx.scene.layout.*;
import javafx.scene.text.Text;
        import javafx.stage.Stage;


import static java.lang.Integer.parseInt;

public class  Interface  extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/interfacejava.fxml"));
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
            System.out.println("lancer bfs");

        });
        dfs.setOnAction(event -> {
            System.out.println("lancer dfs");

            String newText = textField.getText(); // Retrieve the updated value of the text field
            /***todo add exception user**/
            int a = parseInt(newText);
            System.out.println("Text entered: " + a); // Use the text field value as needed
            DFS algoBfs = new DFS();
            Main.Node.n = a;
            algoBfs.Recherche(new Main.Node(new int[0]));

            ChessBoard chessBoard = new ChessBoard(a, algoBfs.getBestSol());

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

        bfs.setOnAction(event -> {
            String newText = textField.getText(); // Retrieve the updated value of the text field
            /***todo add exception user**/
            int a = parseInt(newText);
            System.out.println("Text entered: " + a); // Use the text field value as needed
            BFS algoBfs = new BFS();
            Main.Node.n = a;
            algoBfs.Recherche(new Main.Node(new int[0]));

            ChessBoard chessBoard = new ChessBoard(a, algoBfs.getBestSol());

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