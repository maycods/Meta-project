package Main;


import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        //subset problem.
        System.out.println("hello");
        //model the problem
        //  instantiate the problem
        // verification algorithm
        //

        BFS bfs = new BFS();
        Node.n =6;
        bfs.Recherche(new Node(new ArrayList<Integer>(),null));


        Node a =new Node(bfs.BestSol,null);
        System.out.println(bfs.BestSol.toString()+" evaluation : "+a.evaluation());

    }
}
