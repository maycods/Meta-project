package Main;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {

        System.out.println("hello");
        DFS dfs = new DFS();
        int [] best;
        Node.n=11;
        long start = System.nanoTime();
        best=dfs.Recherche(new Node(new int[0],0));
        long end = System.nanoTime();
        for(int i=0;i<Node.n;i++){
            System.out.println(best[i]);
        }
        /*Node.n=4;
        Node a =new Node(new int[]{1,3,0,2});
        System.out.println(a.evaluation());*/

    }
}
