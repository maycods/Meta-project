package GUI;

import java.io.IOException;
import java.util.Arrays;

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



public class  Interface  extends Application {
    Node content;
    AnchorPane ap;
    ScrollPane sp;
    long start,end;
    int dev,gen;
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/interfacejava.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("N-REINES");
        // Set the width of the stage to the screen width
//        Screen screen = Screen.getPrimary();
//        Rectangle2D bounds = screen.getVisualBounds();
//        stage.setWidth(bounds.getWidth());
//        stage.setHeight(bounds.getHeight());
        stage.setFullScreen(true);

        Button Go = (Button) scene.lookup("#go");
        MenuButton choix = (MenuButton)scene.lookup("#choose");
        TextField textField = (TextField)scene.lookup("#taille");
        Text  INFOS = (Text)scene.lookup("#data");


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
//            if (newValue.length() > 10){
//                textField.setText("");
//            }
            if (!newValue.matches("\\d*")) {
                textField.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });

        Go.setOnAction(event -> {

            sp= (ScrollPane) scene.lookup("#t");
            content = sp.getContent();
            String newText = textField.getText(); // Retrieve the updated value of the text field


                int a = parseInt(newText);
                Main.Node.n = a;
                int[] bestSol;

            if(a<8){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("trop petit n");
                alert.setHeaderText(null);
                alert.setContentText("entrez une taille d'echiquier plus grande");
                alert.getButtonTypes().setAll(ButtonType.OK);
                alert.showAndWait().ifPresent(response -> {
                    if (response == ButtonType.OK) {
                        ap.getChildren().clear();
                    }
                });
            }else {
                switch (choix.getText()) {
                    case "DFS":
                        DFS algoDfs = new DFS();
                         start = System.currentTimeMillis();
                       bestSol=  algoDfs.Recherche(new Main.Node(new int[0]));
                        System.out.println(Arrays.toString(bestSol));
                         end = System.currentTimeMillis();
                         dev=algoDfs.nbrNdev;
                         gen=algoDfs.nbrNgen;
                        break;
                    case "BFS":
                        BFS algoBfs = new BFS();

                         start = System.currentTimeMillis();
                        bestSol=algoBfs.Recherche(new Main.Node(new int[0]));
                         end = System.currentTimeMillis();
                        dev=algoBfs.nbrNdev;
                        gen=algoBfs.nbrNgen;

                        break;
                    default:
                        bestSol = new int[a];
                }
                ChessBoard chessBoard = new ChessBoard(a, bestSol);
                INFOS.setText("Infos: \n temps d execution "+(double)(end-start)+"ms\n"+"NOMBRE DE NOEUDS GENERE "+gen+"\nNOMBRE DE NOEUDS DEVELOPE "+dev);

                if (content instanceof AnchorPane) {
               ap = (AnchorPane) content;
                    AnchorPane.setTopAnchor(chessBoard, 0.0);
                    AnchorPane.setBottomAnchor(chessBoard, 0.0);
                    AnchorPane.setRightAnchor(chessBoard, 0.0);
                    AnchorPane.setLeftAnchor(chessBoard, 0.0);
                    ap.getChildren().clear();
                    ap.getChildren().add(chessBoard);
                }
            }
        });



    }
    public static void main(String[] args) {
        launch();
    }
}