package Main;


import java.util.LinkedList;
import java.util.Queue;
//***Todo nombre de noeud generé et nbr de noeud develope
public class BFS {
    private Queue<Node> ouvert = new LinkedList<>();
//    private ArrayList<Node> ferme= new ArrayList<Node>();
     private int[] bestSol=new int[Node.n];
     private int bestSolEvaluation = Integer.MAX_VALUE;

     public int[] getBestSol(){
         return this.bestSol;
     }

    public BFS() {}
    public void Recherche( Node G){

        Node d=G , n;

        ouvert.add(d);

        while (!ouvert.isEmpty()){

            n=ouvert.poll( );
//            ferme.add(n);
            if(n.verification())
            {

//                Node k = new Node(bestSol);
                int eva = n.evaluation();
                if (eva < bestSolEvaluation) {

                    bestSol=n.getEtat()  ;
                    bestSolEvaluation = eva;
                }
            }

            if (n.successeurs()) {
                    ouvert.addAll(n.getNoeudEnfants());

            }
        }
    }
}
