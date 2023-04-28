package TP.TP2;


import java.util.ArrayList;
import java.util.List;

public class Noeud<T> {
    ArrayList<Integer> sol;

    ArrayList<Noeud> voisins;

    public Noeud() {
        this.sol = new ArrayList<>();
        this.voisins = new ArrayList<>();
    }

    public boolean verifie(List<Integer> list) {
        if (sol.size() >= list.size()) return false;
        return true;
    }

    public boolean Voisins(ArrayList<Integer> list) {
        ArrayList<Integer> clone = (ArrayList<Integer>) list.clone();
//        clone.removeAll(this.sol);
        for (Integer item : this.sol) {
            clone.remove(item);
        }
        for (Integer elt : clone) {
//            if (!this.sol.contains(elt)){
            Noeud n = new Noeud();
            n.sol.addAll(this.sol);
            n.sol.add(elt);
            this.voisins.add(n);
//            }
        }
        return true;
    }

    public ArrayList<Noeud> getVoisins() {
        return this.voisins;
    }

    public boolean meilleur(ArrayList<Integer> list, ArrayList<Integer> sol) {
        ArrayList<Integer> clonedList1 = (ArrayList<Integer>) list.clone();
        ArrayList<Integer> clonedList2 = (ArrayList<Integer>) list.clone();
        clonedList1.removeAll(sol);
        clonedList2.removeAll(this.sol);
        int diff1 = Math.abs(clonedList1.stream().mapToInt(Integer::intValue).sum() - sol.stream().mapToInt(Integer::intValue).sum());
        int diff2 = Math.abs(clonedList2.stream().mapToInt(Integer::intValue).sum() - this.sol.stream().mapToInt(Integer::intValue).sum());

        return diff2 <= diff1;
    }
}
