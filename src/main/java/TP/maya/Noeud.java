package TP.maya;


import java.util.ArrayList;
import java.util.Arrays;

public class Noeud {
    public static int [] T ;
    private ArrayList<Integer> Etat =new ArrayList<Integer>();
    private Noeud NoeudParent;
    private ArrayList<Noeud> NoeudsEnfants=new ArrayList<Noeud>();
    static int cpt=0;
    public boolean verification(){
        int i=0;
        if (Etat!= null && T.length != Etat.size())return false;
        while(i<Etat.size()){
            if(Etat.get(i)!=0 && Etat.get(i)!=1){
                return false;
            }
            i++;
        }
        return true;
    }
    public int evaluation(){
        int cpt1=0,cpt2=0;
        if(!Etat.isEmpty()) {
            for (int i = 0; i < Etat.size(); i++) {
                if (Etat.get(i) == 0) {
                    cpt1 += T[i];
                } else {
                    cpt2 += T[i];
                }
            }
        }else {
            cpt1= Arrays.stream(T).sum();
        }
        return  Math.abs(cpt1-cpt2);
    }
    public int profondeur(){
        if(NoeudParent==null) return 0;
        return NoeudParent.profondeur()+1;
    }
    public Noeud(ArrayList<Integer> Etat, Noeud noeudParent) {
        this.Etat = Etat;
        NoeudParent = noeudParent;
    }

/*
etat : [ 0 1 0 ..]
I []
B   [0 1 0 0 0  1 0] solu valide
action .add(0)  .add(1)
succeseur(etat) return  action(etat)
test de but evaluation
 */

    public ArrayList<Integer> getEtat() {
        return Etat;
    }
    public ArrayList<Noeud> getNoeudEnfants() {
        return NoeudsEnfants;
    }
    public Boolean successeurs(){

        // que si la taille est < a la taille de T
        if(Etat.size() >= T.length) return false;

        ArrayList<Integer> a = (ArrayList<Integer>) this.Etat.clone(), b;
        b=(ArrayList<Integer>) this.Etat.clone();

        a.add(1);
        b.add(0);
        // System.out.print("\n mmm   "+a.toString());
        NoeudsEnfants.add(new Noeud(a, this));
        cpt++;
        //  System.out.print("\n"+cpt+"\n");
        NoeudsEnfants.add(new Noeud(b, this));
        return true;
    }
}
