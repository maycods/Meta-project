package Main;


import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        //subset problem.
        System.out.println("hello");
        //model the problem
        //  instantiate the problem
        // verification algorithm
        //

        BFS bfs = new BFS();
        Node.n =10;
        long start = System.nanoTime();
        bfs.Recherche(new Node(new int[0]));
        long end = System.nanoTime();
        System.out.println("time is : " + TimeUnit.MILLISECONDS.convert(end -start, TimeUnit.NANOSECONDS)/1000);


        Node a =new Node(bfs.getBestSol());

        System.out.println(Arrays.toString(bfs.getBestSol()) +" evaluation : "+a.evaluation());

    }
}
