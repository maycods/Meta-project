package Main;

import java.util.ArrayList;
import java.util.ArrayList;
import it.unimi.dsi.fastutil.ints.IntArrayList;
//implement cloneable
public class Node implements Cloneable {
    public static int n;
    private IntArrayList etat;
    private int profondeur, f;
    private int fitness,longevite;

    public int getLongevite() {
        return longevite;
    }
    public void setLongevite(int longevite) {
        this.longevite = longevite;
    }
    public int getFitness() {
        return fitness;
    }
    public void setFitness() {
        this.fitness = this.evaluation2();
    }
    public void setEtat(IntArrayList etat) {
        this.etat = etat;
    }
    public Node(int longevite,IntArrayList Etat) {
        this.etat = Etat;
        this.longevite=longevite;
    }
    public int evaluation2(){
        int c=0;
        for (int i = 0; i <etat.size(); i++) {
            for (int j = i + 1; j < etat.size(); j++) {
                if (j - i == Math.abs(etat.getInt(i) - etat.getInt(j)))  c++;
            }
        }
        return c;
    }
//////////////////////////////////////////////////////////////////////////////////////////
    public static boolean threatens(int i1, int j1, int i2, int j2) {
        return (j1 == j2) || (Math.abs(i1 - i2) == Math.abs(j1 - j2));
    }
    public static IntArrayList generateRandomState(int n) {
        IntArrayList state = new IntArrayList();
        for (int i = 0; i < n; i++) {
            var rnd = (int) (Math.random() * n);
//            if (!state.contains(rnd)) {
                state.add(rnd);
//            } else {
//                i--;
//            }
        }
        return  state.clone();
    }
    public  Integer cal_fitness() {
        int threatened = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (threatens(i, etat.get(i), j, etat.get(j))) {
                    threatened++;
                }
            }
        }
        return threatened;

    }
    public int fitness() {
        boolean b;
        if (etat.isEmpty()) {
            return n;
        }
        int cpt = 0, x, l, j, p;
        int[][] M = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int m = 0; m < n; m++) {
                M[i][m] = (m == etat.get(i)) ? 1 : 0;
            }
        }
        for (int i = 0; i < n; i++) {
            x = etat.get(i);
            ////////
            int k = 0;
            boolean c;
            j = i + 1;
            c = (j < n);
            do {
                l = x + 1;
                p = x - 1;
                b = false;
                while (c && (l < n || p >= 0) && !b) {

                    if ((l < n && (M[i][x] == M[j][l])) ||
                            ((p >= 0) && (M[i][x] == M[j][p]))) {
                        cpt++;
                        b = true;
                    }
                    if (k == 0) {
                        j++;
                        c = (j < n);
                    } else {
                        j--;
                        c = (j >= 0);
                    }
                    l = l + 1;
                    p = p - 1;
                }
                k++;
                j = i - 1;
                c = (j >= 0);
            } while (!b && k < 2);
            //////////
        }
        return cpt;
    }
    @Override
    public Node clone() throws CloneNotSupportedException {
            Node clone = (Node) super.clone();
            clone.etat = (IntArrayList) etat.clone();
        // TODO: copy mutable state here, so the clone can't change the internals of the original
        return clone;
    }
///////////////////////////////////////////////////////////////////////////////////////////////
    public boolean verification(){
        if (etat.size()!= n) return false;
        return true;
    }
    public boolean evaluation(){
        for (int i = 0; i <etat.size(); i++) {
            for (int j = i + 1; j < etat.size(); j++) {
                if (j - i == Math.abs(etat.getInt(i) - etat.getInt(j))) return false;
            }
        }
        return true;
    }
    public Node(IntArrayList etat) {
        this.etat = etat;
    }
    public Node(IntArrayList etat,int profondeur) {
        this.etat = etat;
        this.profondeur=profondeur;
    }
    public int getF() {
        return f;
    }
    public void setF(int f) {
        this.f = f;
    }
    public IntArrayList getEtat() {
        return etat;
    }
    public int getProfondeur() {
        return profondeur;
    }
    public ArrayList<Node> getNoeudEnfants() {

        ArrayList<Node> childs  = new ArrayList<Node>();
        for(int i=0;i<n;i++) {
            if (!etat.contains(i)){
                childs.add(new Node(copyWithIncreasedSize(i), this.profondeur + 1));
            }
        }
        return childs;
    }
    public IntArrayList copyWithIncreasedSize(int newElement){
        IntArrayList copy = etat.clone();
        copy.add(newElement);
        return copy;
    }

}




