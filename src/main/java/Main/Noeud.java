//package Main;
//
//import java.util.ArrayList;
//import it.unimi.dsi.fastutil.ints.IntArrayList;
//
//public class Noeud  {
//    public static int n;
//    private IntArrayList etat;
//    private int profondeur, f;
//
//    public boolean verification(){
//        if (etat.size()!= n) return false;
//        return true;
//    }
//    public boolean evaluation(){
//        for (int i = 0; i <etat.size(); i++) {
//            for (int j = i + 1; j < etat.size(); j++) {
//                if (j - i == Math.abs(etat.getInt(i) - etat.getInt(j))) return false;
//            }
//        }
//        return true;
//    }
//    public Noeud(IntArrayList etat) {
//        this.etat = etat;
//    }
//    public Noeud(IntArrayList etat,int profondeur) {
//        this.etat = etat;
//        this.profondeur=profondeur;
//    }
//    public int getF() {
//        return f;
//    }
//    public void setF(int f) {
//        this.f = f;
//    }
//    public IntArrayList getEtat() {
//        return etat;
//    }
//    public int getProfondeur() {
//        return profondeur;
//    }
//    public ArrayList<Noeud> getNoeudEnfants() {
//
//        ArrayList<Noeud> childs  = new ArrayList<Noeud>();
//        for(int i=0;i<n;i++) {
//            if (!etat.contains(i)){
//                childs.add(new Noeud(copyWithIncreasedSize(i), this.profondeur + 1));
//            }
//        }
//        return childs;
//    }
//    public IntArrayList copyWithIncreasedSize(int newElement){
//        IntArrayList copy = etat.clone();
//        copy.add(newElement);
//        return copy;
//    }
////////////////////////////////////////////////////////////////////////////////////////////
//    public static boolean threatens(int i1, int j1, int i2, int j2) {
//        return (j1 == j2) || (Math.abs(i1 - i2) == Math.abs(j1 - j2));
//    }
//    public static IntArrayList generateRandomState(int n) {
//        IntArrayList state = new IntArrayList();
//        for (int i = 0; i < n; i++) {
//            var rnd = Math.random() * n;
//            state.add(Math.abs((int) (Math.random() * n)));
////            if (!state.contains(rnd)) {
////            state.add((int) rnd);
////            } else {
////                i--;
////            }
//        }
//        return  state.clone();
//    }
//<<<<<<< HEAD
//
//    public boolean verification() {
//        if (etat.size() != n) return false;
//        return true;
//    }
//
//    public boolean evaluation() {
//        for (int i = 0; i < etat.size(); i++) {
//            for (int j = i + 1; j < etat.size(); j++) {
//                if (j - i == Math.abs(etat.get(i) - etat.get(j))) return false;
//            }
//        }
//        return true;
//    }
//
//    public ArrayList<Noeud> getNoeudEnfants() {
//
//        ArrayList<Noeud> childs = new ArrayList<Noeud>();
//        for (int i = 0; i < n; i++) {
//            if (!etat.contains(i)) {
//                childs.add(new Noeud(copyWithIncreasedSize(i), this.profondeur + 1));
//            }
//        }
//        return childs;
//    }
//
//    public Integer cal_fitness() {
//=======
//    public  Integer cal_fitness() {
//>>>>>>> ec592c507752ab274358339e67180de189517841
//        int threatened = 0;
//        for (int i = 0; i < n; i++) {
//            for (int j = i + 1; j < n; j++) {
//                if (threatens(i, etat.get(i), j, etat.get(j))) {
//                    threatened++;
//                }
//            }
//        }
//        return threatened;
//
//    }
/////////////////////////////////////////////////////////////////////////////////////////////////
//
//
//<<<<<<< HEAD
//                    if ((l < n && (M[i][x] == M[j][l])) ||
//                            ((p >= 0) && (M[i][x] == M[j][p]))) {
//                        cpt++;
//                        b = true;
//                    }
//                    if (k == 0) {
//                        j++;
//                        c = (j < n);
//                    } else {
//                        j--;
//                        c = (j >= 0);
//                    }
//                    l = l + 1;
//                    p = p - 1;
//                }
//                k++;
//                j = i - 1;
//                c = (j >= 0);
//            } while (!b && k < 2);
//            //////////
//        }
//        return cpt;
//    }
//
//    public ArrayList<Integer> copyWithIncreasedSize(int newElement) {
//        ArrayList<Integer> copy = (ArrayList<Integer>) etat.clone();
//        copy.add(newElement);
//        return copy;
//    }
//
//    public int getF() {
//        return f;
//    }
//
//    public void setF(int f) {
//        this.f = f;
//    }
//
//    public ArrayList<Integer> getEtat() {
//        return (ArrayList<Integer>) etat.clone();
//    }
//
//    public int getProfondeur() {
//        return profondeur;
//    }
//
//    @Override
//    public Noeud clone() throws CloneNotSupportedException {
//        Noeud clone = (Noeud) super.clone();
//        clone.etat = (ArrayList<Integer>) etat.clone();
//        // TODO: copy mutable state here, so the clone can't change the internals of the original
//        return clone;
//    }
//=======
//>>>>>>> ec592c507752ab274358339e67180de189517841
//}

package Main;

import it.unimi.dsi.fastutil.ints.IntArrayList;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Noeud {

    public static int n;
    private IntArrayList etat;
    private int profondeur, f;

    public boolean verification() {
        if (etat.size() != n) return false;
        return true;
    }

    public boolean evaluation() {
        for (int i = 0; i < etat.size(); i++) {
            for (int j = i + 1; j < etat.size(); j++) {
                if (j - i == Math.abs(etat.getInt(i) - etat.getInt(j))) return false;
            }
        }
        return true;
    }

    public Noeud(IntArrayList etat) {
        this.etat = etat;
    }

    public Noeud(IntArrayList etat, int profondeur) {
        this.etat = etat;
        this.profondeur = profondeur;
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

    public ArrayList<Noeud> getNoeudEnfants() {

        ArrayList<Noeud> childs = new ArrayList<Noeud>();
        for (int i = 0; i < n; i++) {
            if (!etat.contains(i)) {
                childs.add(new Noeud(copyWithIncreasedSize(i), this.profondeur + 1));
            }
        }
        return childs;
    }

    public IntArrayList copyWithIncreasedSize(int newElement) {
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
            if (!state.contains(rnd)) {
                state.add(rnd);
            } else {
                i--;
            }
        }
        return state;
    }

    public Integer cal_fitness() {
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



