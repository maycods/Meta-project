package Main;


import java.util.ArrayList;

public class Node {
        public static int n ;
        private int[] etat ;
        private int f,profondeur;

        public Boolean verification(){
            if (etat.length!= n) return false;
            return true;
        }

        public boolean evaluation(){
            for (int i = 0; i <etat.length; i++) {
                for (int j = i + 1; j < etat.length; j++) {
                    if (j - i == Math.abs(etat[i] - etat[j])) return false;
                }
            }
             return true;
        }
        public Boolean successeurs(){

            if(etat.length == n) return false;

            return true;

        }
        public ArrayList<Node> getNoeudEnfants() {
           ArrayList<Node> childs  = new ArrayList<Node>();
            for(int i=0;i<n;i++) {
                if (!contains(etat,i)){
                    int [] a = copyWithIncreasedSize(etat, i);
                childs.add(new Node(a, this.profondeur + 1));
                 }
            }
            return childs;
        }
        private boolean contains(int[] list, int val){
            for (int i = 0; i < list.length; i++) {
                if (list[i] == val) {
                    return true;
                }
            }
            return false;
        }
        public static int[] copyWithIncreasedSize(int[] original, int newElement){
            int[] copy = new int[original.length + 1];
            for (int i = 0; i < original.length; i++) {
                copy[i] = original[i];
            }
            copy[original.length] = newElement;
            return copy;
        }

        public Node(int[] etat) {
            this.etat = etat;
        }
        public Node(int [] etat,int profondeur) {
            this.etat = etat;
            this.profondeur=profondeur;
        }
        public int getF() {
            return f;
        }
        public void setF(int f) {
            this.f = f;
        }
        public int[] getEtat() {
            return etat;
        }
        public int getProfondeur() {
            return profondeur;
        }

}

