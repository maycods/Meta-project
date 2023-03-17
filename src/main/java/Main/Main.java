package Main;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {

        System.out.println("hello");
//        DFS dfs = new DFS();
        Astar a = new Astar();
        int[] best;
        Node.n=6;

        best=a.Recherche(new Node(new int[0],0),1).getEtat();
       /* for(int i=0;i<Node.n;i++){
            System.out.println(best[i]);
        }*/
       /* System.out.println("---------------------");
        best=bfs.Recherche(new Node(new int[0],0));

        for(int i=0;i<Node.n;i++){
            System.out.println(best[i]);
        }*/
    }
}
