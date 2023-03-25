package Main;
import java.util.ArrayList;
import it.unimi.dsi.fastutil.ints.IntArrayList;
public class Node {
        public static int n ;
       private IntArrayList etat ;
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

}

