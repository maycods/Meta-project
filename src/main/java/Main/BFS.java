package Main;

import it.unimi.dsi.fastutil.ints.IntArrayList;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    public int nbrNdev = 0, nbrNgen = 1;
    int sizeInitial;
    private Queue<Noeud> ouvert = new LinkedList<>();

    public BFS() {
    }

    public IntArrayList Recherche(Noeud G) {
        Noeud n;
        ouvert.add(G);
        while (!ouvert.isEmpty()) {
            nbrNdev++;
            n = ouvert.poll();

            if (n.verification() && n.evaluation()) {
                return n.getEtat();
            }

            if (!n.verification()) {
                sizeInitial = ouvert.size();
                ouvert.addAll(n.getNoeudEnfants());
                nbrNgen = nbrNgen + (ouvert.size() - sizeInitial);
            }
        }
        return null;
    }
}
