package GUI;

import java.io.IOException;

import static java.lang.Integer.parseInt;

import Main.BFS;
import Main.DFS;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Camera;
import javafx.scene.Node;
import javafx.scene.Scene;
        import javafx.scene.control.*;
        import javafx.scene.layout.*;
import javafx.scene.text.Text;
        import javafx.stage.Stage;


import static java.lang.Integer.parseInt;

public class  Interface  extends Application {
    int taille;
    int[] Sol;
    Node content;
    ChessBoard chessBoard;
    AnchorPane ap;
    ScrollPane sp;
    int i =0;
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

        INFOS.setText("Infos:\n NOMBRE DE NOEUDS GENERE\n NOMBRE DE NOEUDS DEVELOPE\n");


        MenuItem bfs = choix.getItems().get(0);
        MenuItem dfs=choix.getItems().get(1);
        MenuItem h1=choix.getItems().get(2);
        MenuItem h2=choix.getItems().get(3);


        OK.setOnAction(event -> {

        });

        dfs.setOnAction(event -> {

            System.out.println("lancer dfs");
            DFS algoDfs = new DFS();
            Main.Node.n = taille ;
            algoDfs.Recherche(new Main.Node(new int[0]));
           Sol =algoDfs.getBestSol();

        });
        bfs.setOnAction(event -> {
            BFS algoBfs = new BFS();
            Main.Node.n = taille;
           algoBfs.Recherche(new Main.Node(new int[0]));
          Sol = algoBfs.getBestSol();

        });
        h1.setOnAction(event -> {
            System.out.println("lancer h1");

            chessBoard= new ChessBoard(taille, new int[taille]);
            content = sp.getContent();

            if (content instanceof AnchorPane) {
                ap = (AnchorPane) content;
                ap.setTopAnchor(chessBoard, 0.0);
                ap.setBottomAnchor(chessBoard, 0.0);
                ap.setRightAnchor(chessBoard, 0.0);
                ap.setLeftAnchor(chessBoard, 0.0);
                ap.getChildren().add(chessBoard);
            }


        });
        h2.setOnAction(event -> {
            choix.setText(h2.getText());
        });


        Go.setOnAction(event -> {
      

        textField.textProperty().addListener((observable, oldValue, newValue) -> {
//            if (newValue.length() > 10){
//                textField.setText("");
//            }
            if (!newValue.matches("\\d*")) {
                textField.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });

        Go.setOnAction(event -> {
                System.out.println("Button clicked!");
if(i!=0){ chessBoard.getChildren().clear();}
          chessBoard= new ChessBoard(taille, Sol);
          sp= (ScrollPane) scene.lookup("#t");
          content = sp.getContent();

            if (content instanceof AnchorPane) {
               ap = (AnchorPane) content;
                ap.setTopAnchor(chessBoard, 0.0);
                ap.setBottomAnchor(chessBoard, 0.0);
                ap.setRightAnchor(chessBoard, 0.0);
                ap.setLeftAnchor(chessBoard, 0.0);
                ap.getChildren().add(chessBoard);
            }
                i++;
            String newText = textField.getText(); // Retrieve the updated value of the text field
            /***todo add exception user**/
            int a = parseInt(newText);
            Main.Node.n = a;
            int[] bestSol  ;

            ScrollPane sp= (ScrollPane) scene.lookup("#t");
            Node content = sp.getContent();
            switch (choix.getText()){
                case "DFS":
                    DFS algoDfs = new DFS();
                    algoDfs.Recherche(new Main.Node(new int[0]));
                    bestSol = algoDfs.getBestSol();
                    break;
                case "BFS":
                    BFS algoBfs = new BFS();
                    algoBfs.Recherche(new Main.Node(new int[0]));
                    bestSol = algoBfs.getBestSol();
                    break;
                default:
                    bestSol = new int[a];
            }
            ChessBoard chessBoard = new ChessBoard(a, bestSol);

            if (content instanceof AnchorPane) {
                AnchorPane ap = (AnchorPane) content;
                AnchorPane.setTopAnchor(chessBoard, 0.0);
                AnchorPane.setBottomAnchor(chessBoard, 0.0);
                AnchorPane.setRightAnchor(chessBoard, 0.0);
                AnchorPane.setLeftAnchor(chessBoard, 0.0);
                ap.getChildren().add(chessBoard);
            }
            System.out.println("Button clicked!");

            //lancer l algo
        });

        bfs.setOnAction(event -> {
            choix.setText(bfs.getText());

        });

    }
    public static void main(String[] args) {
        launch();
    }
}