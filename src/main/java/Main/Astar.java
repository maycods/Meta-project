package Main;

import it.unimi.dsi.fastutil.ints.IntArrayList;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Astar {
    public int nbrNdev = 0, nbrNgen = 1;
    int sizeInitial;
    private PriorityQueue<Noeud> ouvert = new PriorityQueue<Noeud>(new Comparator<Noeud>() {
        @Override
        public int compare(Noeud o1, Noeud o2) {
            return (o1.getF() > o2.getF()) ? 1 : -1;
        }
    });

    public int h(Noeud n, int hi) {
        int m = n.getEtat().size() - 1;
        if (m == -1) return Noeud.n;
        if (m > 0) {
            for (int j = m - 1; j >= 0; j--) {
                if (m - j == Math.abs(n.getEtat().get(m) - n.getEtat().get(j))) return 1000;
            }
        }
        if (hi == 1) {

            int p = n.getEtat().get(m);
            return Math.min(p, m) + (Noeud.n - p) + (Noeud.n - m) + Math.min((Noeud.n - p - 1), (Noeud.n - m - 1));

        } else {
            return (Noeud.n - m);
        }
    }

    public int g(Noeud n) {

        return n.getProfondeur();
    }

    public IntArrayList Recherche(Noeud G, int hi) {

        Noeud n;
        G.setF(g(G) + h(G, hi));
        ouvert.add(G);

        while (!ouvert.isEmpty()) {

            n = ouvert.remove();
            nbrNdev++;

            if (n.verification()) {
                return n.getEtat();
            }

            sizeInitial = ouvert.size();
            for (Noeud enfant : n.getNoeudEnfants()) {

                enfant.setF(g(enfant) + h(enfant, hi));
                ouvert.add(enfant);
            }
            nbrNgen += (ouvert.size() - sizeInitial);

        }
        return null;
    }
}
