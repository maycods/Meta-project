package Main;

import it.unimi.dsi.fastutil.ints.IntArrayList;

import java.util.Stack;

public class DFS {
    public int nbrNdev = 0, nbrNgen = 1;
    int sizeInitial;
    private Stack<Noeud> pile = new Stack<>();

    public DFS() {
    }

    public IntArrayList Recherche(Noeud G) {

        Noeud n;
        pile.add(G);
        while (!pile.isEmpty()) {
            nbrNdev++;
            n = pile.pop();
            if (n.verification() && n.evaluation()) {
                return n.getEtat();
            }
            if (!n.verification()) {
                sizeInitial = pile.size();
                for (int i = 0; i < n.getNoeudEnfants().size(); i++) {
                    pile.push(n.getNoeudEnfants().get(n.getNoeudEnfants().size() - i - 1));
                }
                nbrNgen += (pile.size() - sizeInitial);
            }
        }
        return null;
    }
}
