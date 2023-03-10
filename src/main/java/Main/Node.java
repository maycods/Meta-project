package Main;

import java.util.*;

public class Node {

        public static int n ;
        private ArrayList<Integer> Etat ;
//        private ArrayList<Node> NoeudsEnfants=new ArrayList<Node>();
//        private Node NoeudParent;
        private int[] etat ;
//        ArrayList<Integer> etat;
//        private final Set<Node> NoeudsEnfants=new HashSet<Node>();

    public Boolean verification(){
            if (etat.length!= n) return false;
//            System.out.println(etat);
            int i=0;

            while(i<n){
                 if(!contains(etat, i)) return false;
                i++;
            }
            return true;
        }
        public int evaluation(){
            Boolean b;
            if(etat.length == 0) {return n;}
            int cpt=0,x,l,j,p;
            int[][] M = new int[n][n];
//            System.out.printli(M[3][4]);
            //array is already initialized with 0s already
            for (int i = 0; i< etat.length; i++){
                M[i][etat[i]] = 1;
            }
//            for (int i = 0; i < n; i++) {
//                for (int m = 0; m < n; m++) {
//                        M[i][m] = (m == etat[i])? 1 : 0;
//                }
//            }
            for (int i = 0; i < n; i++) {
                x = etat[i];
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
                } while (b == false && k < 2);
                //////////
            }
             return cpt;
        }

        public Boolean successeurs(){

            if(etat.length == n) return false;

            return true;
        }

        private boolean contains(int[] list, int val){
            for (int i = 0; i < list.length; i++) {
                if (list[i] == val) {
                    return true;
                }
            }
            return false;
        }

    public static int[] copyWithIncreasedSize(int[] original, int newElement) {
        int[] copy = new int[original.length + 1]; // create new array with one more element
        for (int i = 0; i < original.length; i++) {
            copy[i] = original[i]; // copy elements from original array
        }
        copy[original.length] = newElement; // add new element to the end
        return copy;
    }
        public Node(int[] etat) {
            this.etat = etat;
        }
        public int[] getEtat() {
            return etat;
        }
        public Set<Node> getNoeudEnfants() {
            Set<Node> childs  = new HashSet<Node>();
            for(int i=0;i<n;i++) {
                if(!contains(etat,i)){
//                    int[] a = etat.clone();
                    int[] a = copyWithIncreasedSize(etat, i);
//                    System.out.println(etat.length);
//                    a[etat.length + 1] =i;
                    childs.add(new Node( a));
                }
            }
            return childs;
        }


}

