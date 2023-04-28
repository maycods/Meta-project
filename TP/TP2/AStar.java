package TP.TP2;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class AStar {
    public static ArrayList<Integer> search(ArrayList<Integer> list, Noeud G) {
        PriorityQueue<Noeud> ouvert = new PriorityQueue<>(new NoeudComparator());
        ouvert.add(G);
        while (!ouvert.isEmpty()) {
            Noeud n = ouvert.poll();
            if (n.verifie(list)) {
//                if (n.isSol(list)) {
                return n.sol;
//                }
//                ouvert.addAll(n.Voisins(list));
            }
        }
        return new ArrayList<>();
    }

}
