package Main;

import it.unimi.dsi.fastutil.ints.IntArrayList;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class PSO {
    public int n;

    public PSO(int n) {
        this.n = n;
    }

    public Individu search(int n, int nbPop, int nbIteration) {
        ArrayList<Noeud> population;
        ArrayList<IntArrayList> pBest;
        IntArrayList gBest = null;
        int gBestFitness = Integer.MAX_VALUE;
        population = new ArrayList<Noeud>();
        pBest = new ArrayList<>();
        ArrayList<Integer> pBestFitness = new ArrayList<>();
        for (int i = 0; i < nbPop; i++) {
            var  rand = Noeud.generateRandomState(n);
            var copie = (IntArrayList)rand.clone();

            population.add(new Noeud(copie));
            pBest.add(rand);
            pBestFitness.add(population.get(i).cal_fitness());
            if (population.get(i).cal_fitness() < gBestFitness) {
                gBest = population.get(i).getEtat();
                gBestFitness = population.get(i).cal_fitness();
            }
        }
        System.out.println("gBest = " + gBest + " " + gBestFitness);
        int i = 0;
        while (i < nbIteration) {
//            System.out.println("iteration numero : "+i);
            for (int j = 0; j < nbPop; j++) {
                double r1 = Math.random();
                var p = population.get(j);
                if(r1 < 0.40){
                    p = croisement(p.getEtat(), gBest);
//                    population.set(j,croisement(population.get(j).getEtat(), gBest));
                } else if (r1 < 0.60 && r1 > 0.40) {
                    p = croisement(p.getEtat(), pBest.get(j));
//                    population.set(j, croisement(population.get(j).getEtat(), pBest.get(j)));
                } else {
                    p = croisement(p.getEtat(), Noeud.generateRandomState(n));
//                    population.set(j,croisement(pBest.get(j), Noeud.generateRandomState(n)));
                }
                Noeud newNoeud = new Noeud(p.getEtat());
                population.set(j, newNoeud);
                if (newNoeud.cal_fitness() < pBestFitness.get(j)){
                        pBest.set(j, population.get(j).getEtat());
                        pBestFitness.set(j, population.get(j).cal_fitness());
                    if (pBestFitness.get(j) < gBestFitness) {
                        System.out.println("i = " + i + " j = " + j);
                        System.out.println("gBest = " + gBest + " " + gBestFitness);
                        gBest = pBest.get(j);
                        gBestFitness = pBestFitness.get(j);
                    }
                    if (gBestFitness == 0) break;
                }
            }
            i++;
        }

        System.out.println("iteration " + i);

        System.out.println("gBest = " + gBest);
        Individu x = new Individu(gBest);
        System.out.println("gBestFitness = " + gBestFitness);
        return x;
    }

    private static Noeud croisement  (IntArrayList Noeud1, IntArrayList Noeud2) {
        IntArrayList child = new IntArrayList();
        //partition the parents into 2 parts and then swap them
        int partition = (int) Math.floor(Math.random() * Noeud1.size());
//        int partition = (int) Noeud1.size()/2;
        var rnd  = Math.random();
        if (rnd < 0.5) {
            for (int i = 0; i < partition; i++) {
                child.add(Noeud1.getInt(i));
            }
            int j =0 ;

            while(child.size() < Noeud2.size()){
                if (!child.contains(Noeud2.getInt(j))){
                    child.add(Noeud2.getInt(j));
                }
                j++;
                j = j % Noeud1.size();
            }
//            for (int i = partition; i < Noeud2.size(); i++) {
//                child.add(Noeud2.get(i));
//            }
        } else {
            for (int i = partition; i < Noeud2.size(); i++) {
                child.add(Noeud2.get(i));
            }
            int j = 0;
            while(child.size() < Noeud1.size()){
                if (!child.contains(Noeud1.getInt(j))){
                    child.add(Noeud1.getInt(j));
                }
                j++;
                j = j % Noeud1.size();
            }
//            for (int i = 0; i < partition; i++) {
//                child.add(Noeud2.get(i));
//            }
        }
        return new Noeud(child);
    }


}
