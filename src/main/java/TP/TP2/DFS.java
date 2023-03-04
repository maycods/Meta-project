package TP.TP2;


import java.util.ArrayList;
import java.util.Stack;

public class DFS {

    public static ArrayList<Integer> search(ArrayList<Integer> list, Noeud G){
        Stack<Noeud> pile = new Stack<>();
        ArrayList<Integer> bSol = new ArrayList<>();

            pile.add(G);
            while (!pile.isEmpty()) {
                Noeud n = pile.pop();
                if (n.verifie(list)) {
                    if (n.meilleur(list, bSol)) {
                        bSol = n.sol;
                    }
                }
                if (n.Voisins(list)){
                    pile.addAll(n.getVoisins());
                }
        }
            return bSol;
    }

}
