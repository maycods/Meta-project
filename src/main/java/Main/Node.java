package Main;

import java.util.ArrayList;
import java.util.ArrayList;
import it.unimi.dsi.fastutil.ints.IntArrayList;

public class Node  {
    public static int n;
    private IntArrayList etat;
    private int profondeur, f;

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
///////////////////////////////////////////////////////////////////////////////////////////////


}




