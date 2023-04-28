package Main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Astar {
    public int nbrNdev = 0, nbrNgen = 1;
    int sizeInitial;
    private PriorityQueue<Node> ouvert = new PriorityQueue<Node>(new Comparator<Node>() {
        @Override
        public int compare(Node o1, Node o2) {
            return (o1.getF() > o2.getF()) ? 1 : -1;
        }
    });

    public int h(Node n, int hi) {
        int m = n.getEtat().size() - 1;
        if (m == -1) return Node.n;
        if (m > 0) {
            for (int j = m - 1; j >= 0; j--) {
                if (m - j == Math.abs(n.getEtat().get(m) - n.getEtat().get(j))) return 1000;
            }
        }
        if (hi == 1) {

            int p = n.getEtat().get(m);
            return Math.min(p, m) + (Node.n - p) + (Node.n - m) + Math.min((Node.n - p - 1), (Node.n - m - 1));

        } else {
            return (Node.n - m);
        }
    }

    public int g(Node n) {

        return n.getProfondeur();
    }

    public ArrayList<Integer> Recherche(Node G, int hi) {

        Node n;
        G.setF(g(G) + h(G, hi));
        ouvert.add(G);

        while (!ouvert.isEmpty()) {

            n = ouvert.remove();
            nbrNdev++;

            if (n.verification()) {
                return n.getEtat();
            }

            sizeInitial = ouvert.size();
            for (Node enfant : n.getNoeudEnfants()) {

                enfant.setF(g(enfant) + h(enfant, hi));
                ouvert.add(enfant);
            }
            nbrNgen += (ouvert.size() - sizeInitial);

        }
        return null;
    }
}
