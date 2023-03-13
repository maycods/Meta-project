package Main;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
//***Todo nombre de noeud generé et nbr de noeud develope
public class BFS {
    private Queue<Node> ouvert = new LinkedList<>();
//    private ArrayList<Node> ferme= new ArrayList<Node>();

  public  int nbrNdev=0,nbrNgen =1;
    int sizeInitial;


    public BFS() {}
    public int [] Recherche( Node G){

        Node d=G , n;

        ouvert.add(d);

        while (!ouvert.isEmpty()){
            nbrNdev++;
            n=ouvert.poll( );

            if (n.evaluation1()) {
                if(n.verification() ){
                    return n.getEtat();
                }

                sizeInitial =ouvert.size();
                ouvert.addAll(n.getNoeudEnfants());
                nbrNgen=nbrNgen+(ouvert.size() - sizeInitial);
            }
        }
    return null;}
}
