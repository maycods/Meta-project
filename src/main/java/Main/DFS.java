package Main;


import java.util.Arrays;
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

                if (n.evaluation1()) {
                    System.out.println(Arrays.toString(n.getEtat()));
                    if(n.verification() ){
                        return n.getEtat();
                    }

                    sizeInitial =pile.size();
                    pile.addAll(n.getNoeudEnfants());
                    nbrNgen=nbrNgen+(pile.size() - sizeInitial);
                }
        }
return null;
    }
}
