package TP.maya;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public  static void main(String[] args){
        Patitionnement patitionnement = new Patitionnement();
        patitionnement.generation(10);
       /*

        patitionnement.SoluAleatoire();
        System.out.println(Arrays.toString(patitionnement.getS()));

        System.out.println(patitionnement.verification(patitionnement.getS())?  "La solution est valide et son evaluation est de "+
                patitionnement.evaluation(patitionnement.getS()) : "la solution n es t pas valide");
*/
        Noeud.T=patitionnement.T;
        System.out.println(Arrays.toString(patitionnement.T));
        DFS dfs=new DFS();
        dfs.Recherche(new Noeud(new ArrayList<Integer>(),null));
        Noeud r = new Noeud(dfs.BestSol,null);
        System.out.print(dfs.BestSol.toString()+" "+ r.evaluation());
    }
}
