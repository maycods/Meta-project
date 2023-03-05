package Main;

import java.util.*;

public class Node {

        public static int n ;
        private ArrayList<Integer> Etat ;
        private ArrayList<Node> NoeudsEnfants=new ArrayList<Node>();
        private Node NoeudParent;

        public Boolean verification(){
            if (Etat.size()!= n) return false;

            int i=0;

            while(i<n){
                 if(!Etat.contains(i)) return false;
                i++;
            }
            return true;
        }
        public int evaluation(){
Boolean b;
            if(Etat.isEmpty()) {return n;}
            int cpt=0,x,l,j,p;
            int[][] M = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int m = 0; m < n; m++) {
                        M[i][m] = (m == Etat.get(i))? 1 : 0;
                }
            }
            for (int i = 0; i < n; i++) {
                x = Etat.get(i);
                ////////
                int k = 0;
                Boolean c;
                j = i + 1;
                c = (j < n);
                do {
                    l = x + 1;
                    p = x - 1;
                    b = false;
                    while (c && (l < n || p >= 0) && b == false) {

                        if ((l < n && (M[i][x] == M[j][l])) ||
                                ((p >= 0) && (M[i][x] == M[j][p]))) {
                            cpt++;
                            b = true;
                        }
                        if (k == 0) {
                            j++;
                            c = (j < n);
                        } else {j--;
                            c = (j >= 0);}
                        l = l + 1;
                        p = p - 1;
                    }
                    k++;
                    j = i - 1;
                    c = (j >= 0);
                } while (b == false && k < 2);
                //////////
            }
             return cpt;
        }

        public Boolean successeurs(){

            if(Etat.size() == n) return false;
            for(int i=0;i<n;i++) {
                if(!Etat.contains(i)){
                    ArrayList<Integer> a =  (ArrayList<Integer>) Etat.clone();
                    a.add(i);
                    NoeudsEnfants.add(new Node( a,this));
                }
            }
            return true;
        }


        public Node(ArrayList<Integer> Etat,Node noeudParent) {
            this.Etat = Etat;
            NoeudParent = noeudParent;
        }
        public ArrayList<Integer> getEtat() {
            return Etat;
        }
        public ArrayList<Node> getNoeudEnfants() {
            return NoeudsEnfants;
        }

   /* private  T valeur;
    private Set<Node<T>> voisins = new HashSet<>();
    public Node (T valeur){
        this.valeur = valeur;
        this.voisins = new HashSet<>();
    }
    public void connect(Node<T> n){
        if (this == n) throw new IllegalArgumentException("Can't connect node to itself");
        this.voisins.add(n);
        n.voisins.add(this);
    }

    public T getValeur() {
        return valeur;
    }
    public Set<Node<T>> getVoisins() {
        return voisins;
    }

*/

}

