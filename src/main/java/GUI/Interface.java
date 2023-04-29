package GUI;

import Main.*;
import it.unimi.dsi.fastutil.ints.IntArrayList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class Interface extends Application {
    Node content;
    AnchorPane ap;
    ScrollPane sp;
    long start, end;
    int dev, gen;
    Boolean b;

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/interfacejava.fxml"));


        Scene scene = new Scene(fxmlLoader.load(), 1000, 800);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("N-REINES");
        Button Go = (Button) scene.lookup("#go");
        MenuButton choix = (MenuButton) scene.lookup("#choose");
        TextField textField = (TextField) scene.lookup("#taille");

        TextField nbiter = (TextField) scene.lookup("#nbiter");
        TextField nbpop = (TextField) scene.lookup("#tpop");
        TextField mut = (TextField) scene.lookup("#mut");
        TextField selection = (TextField) scene.lookup("#select");
        TextField remplacement = (TextField) scene.lookup("#remp");
        TextField nbrpnt = (TextField) scene.lookup("#nbrpnt");

        TextField sspopT = (TextField) scene.lookup("#tsspop");
        TextField taucT = (TextField) scene.lookup("#toc");

        TextField C1 = (TextField) scene.lookup("#c1");
        TextField C2 = (TextField) scene.lookup("#c2");
        C1.setText("0.6");
        C2.setText("0.7");
        mut.setText("0.3");
        selection.setText("1");
        remplacement.setText("1");
        nbrpnt.setText("3");
        sspopT.setText("50");
        taucT.setText("0.7");

        Label nbiterLabel = (Label) scene.lookup("#nbiterl");
        Label tpopLabel = (Label) scene.lookup("#tpopl");
        Label mutLabel = (Label) scene.lookup("#mutl");
        Label selectLabel = (Label) scene.lookup("#selectl");
        Label remplacementLabel = (Label) scene.lookup("#rempl");
        Label C1l = (Label) scene.lookup("#c1l");
        Label C2l = (Label) scene.lookup("#c2l");
        Label nbrpoint = (Label) scene.lookup("#nbrpnts");

        Label souspopL = (Label) scene.lookup("#Tsouspop");
        Label taucL = (Label) scene.lookup("#tauc");

        ArrayList<Node> elts = new ArrayList<>();
        elts.add(nbiterLabel);
        elts.add(tpopLabel);
        elts.add(mutLabel);
        elts.add(selectLabel);
        elts.add(remplacementLabel);
        elts.add(C1l);
        elts.add(C2l);
        elts.add(nbiter);
        elts.add(nbpop);
        elts.add(mut);
        elts.add(selection);
        elts.add(remplacement);
        elts.add(C1);
        elts.add(C2);
        elts.add(nbrpnt);
        elts.add(nbrpoint);
        elts.add(sspopT);
        elts.add(souspopL);
        elts.add(taucT);
        elts.add(taucL);
        setInvisible(elts);


        Text devTOnothing = (Text) scene.lookup("#data1");
        Text genTOevaluation = (Text) scene.lookup("#data11");

        Text exe = (Text) scene.lookup("#exe");
        Text ngen = (Text) scene.lookup("#ngen");
        Text ndev = (Text) scene.lookup("#ndev");


        choix.setText("Aucun");
        MenuItem bfs = choix.getItems().get(0);
        MenuItem dfs = choix.getItems().get(1);
        MenuItem h1 = choix.getItems().get(2);
        MenuItem h2 = choix.getItems().get(3);
        MenuItem GA = choix.getItems().get(4);
        MenuItem PSO = choix.getItems().get(5);

        bfs.setOnAction(event -> {
            setInvisible(elts);
            choix.setText(bfs.getText());
        });
        dfs.setOnAction(event -> {
            setInvisible(elts);
            choix.setText(dfs.getText());
        });
        h1.setOnAction(event -> {

            choix.setText(h1.getText());
            setInvisible(elts);
        });
        h2.setOnAction(event -> {
            choix.setText(h2.getText());
            setInvisible(elts);
        });
        GA.setOnAction(event -> {
            nbiter.setText("100");
            nbpop.setText("100");

            setInvisible(elts);

            choix.setText(GA.getText());
            nbiterLabel.setVisible(true);
            nbpop.setVisible(true);
            mut.setVisible(true);
            selection.setVisible(true);
            nbiter.setVisible(true);
            tpopLabel.setVisible(true);
            mutLabel.setVisible(true);
            selectLabel.setVisible(true);
            remplacementLabel.setVisible(true);
            remplacement.setVisible(true);
            nbrpnt.setVisible(true);
            nbrpoint.setVisible(true);
            taucL.setVisible(true);
            taucT.setVisible(true);
            sspopT.setVisible(true);
            souspopL.setVisible(true);
        });
        PSO.setOnAction(event -> {
            nbiter.setText("2000");
            nbpop.setText("2500");

            setInvisible(elts);
            choix.setText(PSO.getText());
            nbpop.setVisible(true);
            tpopLabel.setVisible(true);
            nbiter.setVisible(true);
            nbiterLabel.setVisible(true);
            C1.setVisible(true);
            C2.setVisible(true);
            C1l.setVisible(true);
            C2l.setVisible(true);
        });

        textField.textProperty().addListener((observable, oldValue, newValue) -> {

            if (!newValue.matches("\\d*")) {
                textField.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });

        Go.setOnAction(event -> {
            b = false;
            sp = (ScrollPane) scene.lookup("#t");
            content = sp.getContent();
            String newText = textField.getText();


            int a = parseInt(newText);//TODO ADD EXCEPTION OR SMTHG EN CAS OU MKCH NUMBER ENTERED
            Noeud.n = a;
            IntArrayList bestSol = null;

            if (a < 6) {
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
            } else {
                switch (choix.getText()) {
                    case "DFS":
                        DFS algoDfs = new DFS();
                        start = System.currentTimeMillis();
                        bestSol = algoDfs.Recherche(new Noeud(new IntArrayList(0)));
                        end = System.currentTimeMillis();
                        dev = algoDfs.nbrNdev;
                        gen = algoDfs.nbrNgen;
                        break;
                    case "BFS":
                        BFS algoBfs = new BFS();
                        start = System.currentTimeMillis();
                        bestSol = algoBfs.Recherche(new Noeud(new IntArrayList(0), 0));
                        end = System.currentTimeMillis();
                        dev = algoBfs.nbrNdev;
                        gen = algoBfs.nbrNgen;

                        break;
                    case "heuristique 1 ":
                        Astar A = new Astar();
                        start = System.currentTimeMillis();
                        bestSol = A.Recherche(new Noeud(new IntArrayList(0), 0), 1);
                        end = System.currentTimeMillis();
                        dev = A.nbrNdev;
                        gen = A.nbrNgen;
                        break;
                    case "heuristique 2":
                        Astar B = new Astar();
                        start = System.currentTimeMillis();
                        bestSol = B.Recherche(new Noeud(new IntArrayList(0), 0), 2);
                        end = System.currentTimeMillis();
                        dev = B.nbrNdev;
                        gen = B.nbrNgen;
                        break;
                    case "PSO"://TODO in case of meta 9alek lzm nkhelou l user il choisis les parametres si il veut sinon par default imed le meilleur
                        PSO pso = new PSO(a);
                        var nbpopVal = (int) Integer.parseInt(nbpop.getText());
                        var nbiterVal = (int) Integer.parseInt(nbiter.getText());
                        var c1val = Double.parseDouble(C1.getText());
                        var c2val = Double.parseDouble(C2.getText());
                        start = System.currentTimeMillis();
                        Individu p = pso.search(nbpopVal, nbiterVal, c1val, c2val);
                        end = System.currentTimeMillis();
                        bestSol = p.getSolution();
                        genTOevaluation.setText("nombre de reines en dangers: " + p.cal_fitness());
                        b = true;
                        break;
                    case "GA":
                        GA M = new GA();
                        nbpopVal = Integer.parseInt(nbpop.getText());
                        nbiterVal = Integer.parseInt(nbiter.getText());
                        var mutval = Double.parseDouble(mut.getText());
                        var method = Integer.parseInt(selection.getText());
                        var rempval = Integer.parseInt(remplacement.getText());
                        var nombrepnt = Integer.parseInt(nbrpnt.getText());
                        var tauxC = Double.parseDouble(taucT.getText());
                        var taillsoupop = Integer.parseInt(sspopT.getText());

                        start = System.currentTimeMillis();
                        Individu pa = M.Lancer(a, nbpopVal, nbiterVal, mutval, method, rempval, nombrepnt, tauxC, taillsoupop);
                        end = System.currentTimeMillis();
                        bestSol = pa.getSolution();
                        genTOevaluation.setText("nombre de reines en dangers: " + (pa.cal_fitness()));
                        b = true;
                        break;
                    default:
                        bestSol = new IntArrayList(a);
                }
                exe.setText((double) (end - start) + " ms");
                if (!b) {
                    devTOnothing.setText("nombre de noeuds developpés:");
                    genTOevaluation.setText("nombre de noeuds generés:");
                    ngen.setText(gen + "");
                    ndev.setText(dev + "");
                } else {
                    devTOnothing.setText(" ");
                    ngen.setText("");
                    ndev.setText("");
                }

                if (content instanceof AnchorPane) {
                    ap = (AnchorPane) content;
                    ChessBoard chessBoard = new ChessBoard(a, bestSol, ap.getWidth(), ap.getHeight());
                    ap.getChildren().clear();
                    ap.getChildren().add(chessBoard);
                }
            }

        });

    }

    private void setInvisible(ArrayList<Node> elts) {
        for (Node elt : elts) {
            elt.setVisible(false);
        }
    }


    public static void main(String[] args) {
        launch();
    }
}