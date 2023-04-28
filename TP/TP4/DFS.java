package TP.TP4;

import java.util.ArrayList;
import java.util.Stack;

public class DFS {

    //Queue<Noeud> ouvert = new LinkedList<>();
    Stack<Noeud> ouvert = new Stack<Noeud>();
    ArrayList<Integer> BestSol = new ArrayList<Integer>();
    private ArrayList<Noeud> ferme = new ArrayList<Noeud>();

    public DFS() {
    }

    public void Recherche(Noeud G) {

        Noeud d = G, n;
        ouvert.push(d);// ouvert.add(d);
        while (!ouvert.isEmpty()) {
            n = ouvert.pop();//ouvert.poll( );
            ferme.add(n);
            if (n.verification()) {

                Noeud k = new Noeud(BestSol, null);
                // System.out.print(" "+n.evaluation()+" ");
                if (n.evaluation() < k.evaluation()) {
                    BestSol = n.getEtat();
                }
            }
            if (n.successeurs()) {
                for (Noeud enfant : n.getNoeudEnfants()) {
                    System.out.println("test");
                    System.out.print(" " + enfant.getEtat() + " ");
                    ouvert.push(enfant);//ouvert.add(enfant);
                }
            }
        }
    }
}