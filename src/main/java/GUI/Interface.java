package GUI;

import java.io.IOException;

import static java.lang.Integer.parseInt;

import Main.Astar;
import Main.BFS;
import Main.DFS;
import it.unimi.dsi.fastutil.ints.IntArrayList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
        import javafx.scene.control.*;
        import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class  Interface  extends Application {
    Node content;
    AnchorPane ap;
    ScrollPane sp;
    long start,end;
    int dev,gen;
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/interfacejava.fxml"));


        Scene scene = new Scene(fxmlLoader.load(), 1000, 800);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("N-REINES");
        Button Go = (Button) scene.lookup("#go");
        MenuButton choix = (MenuButton)scene.lookup("#choose");
        TextField textField = (TextField)scene.lookup("#taille");

        Text  exe = (Text)scene.lookup("#exe");
        Text  ngen  = (Text)scene.lookup("#ngen");
        Text  ndev = (Text)scene.lookup("#ndev");


        choix.setText("Aucun");
        MenuItem bfs = choix.getItems().get(0);
        MenuItem dfs=choix.getItems().get(1);
        MenuItem h1=choix.getItems().get(2);
        MenuItem h2=choix.getItems().get(3);

        dfs.setOnAction(event -> {
            choix.setText(dfs.getText());
        });
        bfs.setOnAction(event -> {
            choix.setText(bfs.getText());
        });
        h1.setOnAction(event -> {
            choix.setText(h1.getText());
        });
        h2.setOnAction(event -> {
            choix.setText(h2.getText());
        });


        textField.textProperty().addListener((observable, oldValue, newValue) -> {

            if (!newValue.matches("\\d*")) {
                textField.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });

        Go.setOnAction(event -> {

            sp= (ScrollPane) scene.lookup("#t");
            content = sp.getContent();
            String newText = textField.getText();


                int a = parseInt(newText);
                Main.Node.n = a;
               IntArrayList bestSol;

            if(a<6){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("valeur trop petite de n");
                alert.setHeaderText(null);
                alert.setContentText("entrez une taille d'echiquier plus grande");
                alert.getButtonTypes().setAll(ButtonType.OK);
                alert.showAndWait().ifPresent(response -> {
                    if (response == ButtonType.OK) {
                        ap.getChildren().clear();
                    }
                });
            }
            else{
                if(a>35){
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Espace insuffisant");
                    alert.setHeaderText(null);
                    alert.setContentText("entrez une taille d'echiquier plus petite");
                    alert.getButtonTypes().setAll(ButtonType.OK);
                    alert.showAndWait().ifPresent(response -> {
                        if (response == ButtonType.OK) {
                            ap.getChildren().clear();
                        }
                    });
                }
                else{
                    switch (choix.getText()) {
                        case "DFS":
                            DFS algoDfs = new DFS();
                             start = System.currentTimeMillis();
                           bestSol=  algoDfs.Recherche(new Main.Node(new IntArrayList(0)));
                             end = System.currentTimeMillis();
                             dev=algoDfs.nbrNdev;
                             gen=algoDfs.nbrNgen;
                            break;
                        case "BFS":
                            BFS algoBfs = new BFS();
                             start = System.currentTimeMillis();
                            bestSol=algoBfs.Recherche(new Main.Node(new IntArrayList(0)));
                             end = System.currentTimeMillis();
                            dev=algoBfs.nbrNdev;
                            gen=algoBfs.nbrNgen;
                            break;
                        case "heuristique 1 ":
                            Astar A = new Astar();
                            start = System.currentTimeMillis();
                            bestSol=A.Recherche(new Main.Node(new IntArrayList(0),0),1);
                            end = System.currentTimeMillis();
                            dev=A.nbrNdev;
                            gen=A.nbrNgen;
                            break;
                        case "heuristique 2":
                            Astar B = new Astar();
                            start = System.currentTimeMillis();
                            bestSol=B.Recherche(new Main.Node(new IntArrayList(0),0),2);
                            end = System.currentTimeMillis();
                            dev=B.nbrNdev;
                            gen=B.nbrNgen;
                            break;
                        default:
                            bestSol = new IntArrayList(a);
                    }
                    exe.setText((double)(end-start) + " ms");
                    ngen.setText(gen+"");
                    ndev.setText(dev+"");

                    if (content instanceof AnchorPane) {
                        ap = (AnchorPane) content;
                        ChessBoard chessBoard = new ChessBoard(a, bestSol,ap.getWidth(), ap.getHeight());
                        ap.getChildren().clear();
                        ap.getChildren().add(chessBoard);
                    }
                }
            }
        });

    }
    public static void main(String[] args) {
        launch();
    }
}