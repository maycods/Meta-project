package Main;

import it.unimi.dsi.fastutil.ints.IntArrayList;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class PSO {
    public int n;

    private static Individu croisement  (IntArrayList Individu1, IntArrayList Individu2) {
        IntArrayList child = new IntArrayList();
        //partition the parents into 2 parts and then swap them
        int partition = (int) Math.floor(Math.random() * Individu1.size());

        var rnd  = Math.random();
        if (rnd < 0.5) {
            for (int i = 0; i < partition; i++) {
                child.add(Individu1.getInt(i));
            }
            int j =0 ;

            while(child.size() < Individu2.size()){
                if (!child.contains(Individu2.getInt(j))){
                    child.add(Individu2.getInt(j));
                }
                j++;
                j = j % Individu1.size();
            }

        } else {
            for (int i = partition; i < Individu2.size(); i++) {
                child.add(Individu2.getInt(i));
            }
            int j = 0;
            while(child.size() < Individu1.size()){
                if (!child.contains(Individu1.getInt(j))){
                    child.add(Individu1.getInt(j));
                }
                j++;
                j = j % Individu1.size();
            }

        }
        return new Individu(child);
    }

    public Individu search(int n, int nbPop, int nbIteration) {

        ArrayList<Individu> population;
        ArrayList<IntArrayList> pBest;

        IntArrayList gBest = null;
        int gBestFitness = Integer.MAX_VALUE;


        population = new ArrayList<Individu>();
        pBest = new ArrayList<>();
        ArrayList<Integer> pBestFitness = new ArrayList<>();

        for (int i = 0; i < nbPop; i++) {
            var  rand = Individu.generateRandomState(n);
            var copie = (IntArrayList)rand.clone();

            population.add(new Individu(copie));
            pBest.add(rand);
            pBestFitness.add(population.get(i).evaluation2());
            if (population.get(i).evaluation2() < gBestFitness) {
                gBest = population.get(i).getSolution();
                gBestFitness = population.get(i).evaluation2();
            }
        }

        int i = 0;
        while (i < nbIteration) {
            for (int j = 0; j < nbPop; j++) {
                double r1 = Math.random();
                var p = population.get(j);

                if(r1 < 0.40){
                    p = croisement(p.getSolution(), gBest);
                } else if (r1 < 0.60 && r1 > 0.40) {
                    p = croisement(p.getSolution(), pBest.get(j));
                } else {
                    p = croisement(p.getSolution(), population.get((int) Math.floor(Math.random() * population.size())).getSolution() );
                }

                Individu newIndividu = new Individu(p.getSolution());
                population.set(j, newIndividu);
                if (newIndividu.evaluation2() < pBestFitness.get(j)){
                        pBest.set(j, population.get(j).getSolution());
                        pBestFitness.set(j, population.get(j).evaluation2());
                    if (pBestFitness.get(j) < gBestFitness) {
                       /* System.out.println("i = " + i + " j = " + j);
                        System.out.println("gBest = " + gBest + " " + gBestFitness);*/
                        gBest = pBest.get(j);
                        gBestFitness = pBestFitness.get(j);
                    }
                    if (gBestFitness == 0) break;
                }
            }
            i++;
        }

        Individu x = new Individu(gBest);
        return x;
    }

}
