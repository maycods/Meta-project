package Main;

import Main.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
//***Todo nombre de noeud generé et nbr de noeud develope
public class DFS {
        private Stack<Node> pile = new Stack<>();
//    private ArrayList<Node> ferme= new ArrayList<Node>();
public  int nbrNdev=0,nbrNgen =1;
    int sizeInitial;

    public DFS() {}
    public int [] Recherche( Node G){

        Node d=G , n;

        pile.add(d);

            while (!pile.isEmpty()){
                nbrNdev++;
                n=pile.pop();
//            ferme.add(n);

                if(n.verification() && n.evaluation()==0){ return n.getEtat();}


            if (n.successeurs()) {

                sizeInitial =pile.size();
                pile.addAll(n.getNoeudEnfants());
                nbrNgen=nbrNgen+(pile.size() - sizeInitial);
            }
        }
return null;
    }
}
