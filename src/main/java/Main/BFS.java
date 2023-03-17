package Main;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    private Queue<Node> ouvert = new LinkedList<>();


  public  int nbrNdev=0,nbrNgen =1;
    int sizeInitial;

    public BFS() {}
    public int[] Recherche(Node G){

        Node d=G , n;

        ouvert.add(d);

        while (!ouvert.isEmpty()){
            nbrNdev++;
            n=ouvert.poll();

            if(n.verification() && n.evaluation()){ return n.getEtat();}

            if (n.successeurs()) {

                sizeInitial =ouvert.size();
                ouvert.addAll(n.getNoeudEnfants());
                nbrNgen=nbrNgen+(ouvert.size() - sizeInitial);
            }
        }
    return null;}
}
