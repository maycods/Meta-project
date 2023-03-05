package Main;

import Main.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
//***Todo nombre de noeud generé et nbr de noeud develope
public class BFS {
    private Queue<Node> ouvert = new LinkedList<>();
    private ArrayList<Node> ferme= new ArrayList<Node>();
     ArrayList<Integer> BestSol=new ArrayList<Integer>();

    public BFS() {}
    public void Recherche( Node G){

        Node d=G , n;

        ouvert.add(d);

        while (!ouvert.isEmpty()){

            n=ouvert.poll( );
            ferme.add(n);
            if(n.verification())
            {

                Node k = new Node(BestSol,null);
                if (n.evaluation() < k.evaluation()) {
                    BestSol=n.getEtat()  ;
                }
            }

            if (n.successeurs()) {

                for (Node enfant : n.getNoeudEnfants()) {

                    ouvert.add(enfant);

                }
            }
        }
    }
}
