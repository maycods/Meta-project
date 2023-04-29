package Main;

import it.unimi.dsi.fastutil.ints.IntArrayList;

import java.util.ArrayList;

public class PSO {
    public int n;
    public PSO(int n) {
        this.n = n;
    }

    public Individu search(int nbPop, int nbIteration, double c1, double c2) {

        ArrayList<Individu> population;
        ArrayList<IntArrayList> pBest;
        IntArrayList gBest = null;
        int gBestFitness = Integer.MAX_VALUE;
        population = new ArrayList<Individu>();
        pBest = new ArrayList<>();
        ArrayList<Integer> pBestFitness = new ArrayList<>();


        for (int i = 0; i < nbPop; i++) {
            var rand = Individu.generateRandomSol(n);
            var copie = (IntArrayList) rand.clone();

            population.add(new Individu(copie));
            pBest.add(rand);
            pBestFitness.add(population.get(i).cal_fitness());
            if (population.get(i).cal_fitness() < gBestFitness) {
                gBest = population.get(i).getSolution();
                gBestFitness = population.get(i).cal_fitness();
            }
        }
       // System.out.println("gBest = " + gBest + " " + gBestFitness);



        int i = 0;
        while (i < nbIteration) {
            for (int j = 0; j < nbPop; j++) {
                double r1 = Math.random();
                if (r1 < c1) {
                    population.set(j,croisement(population.get(j).getSolution(), gBest));
                } else if (r1 < c2 && r1 > c1) {
                    population.set(j,croisement(population.get(j).getSolution(), pBest.get(j)));
                } else {
                    population.set(j,croisement(pBest.get(j), population.get((int) Math.floor(Math.random() * population.size())).getSolution()));//avec rdm de la popp
                }


                var fit = population.get(j).cal_fitness();
                if (fit < pBestFitness.get(j)) {
                    pBest.set(j, population.get(j).getSolution());
                    pBestFitness.set(j, fit);
                    /*if (fit < gBestFitness) {
                     //   System.out.println("i = " + i + " j = " + j);
                       // System.out.println("gBest = " + gBest + " ");
                       // System.out.println("gBestFitness = " + gBestFitness);
                    }*/
                    if (fit <= gBestFitness) {
                        gBest = pBest.get(j);
                        gBestFitness = fit;

                    }
                }
            }
            if (gBestFitness == 0) break;
            i++;
        }


        /*System.out.println("iteration " + i);
        System.out.println("gBest = " + gBest);*/
        Individu x = new Individu(gBest);
      //  System.out.println("gBestFitness = " + x.cal_fitness());
        return x;
    }

    private static Individu croisement(IntArrayList Individu1, IntArrayList Individu2) {
        IntArrayList child = new IntArrayList();
        //partition the parents into 2 parts and then swap them
        int partition = (int) Math.floor(Math.random() * Individu1.size() );

        var rnd = Math.random();
        if (rnd < 0.3) {
            for (int i = 0; i < partition; i++) {
                child.add(Individu1.getInt(i));
            }
            int j = 0;

            while (child.size() < Individu2.size()) {
                if (!child.contains(Individu2.getInt(j))) {
                    child.add(Individu2.getInt(j));
                }
                j++;
                j = j % Individu1.size();
            }
        } else {
            for (int i = partition; i < Individu2.size(); i++) {
                child.add(Individu2.get(i));
            }
            int j = 0;
            while (child.size() < Individu1.size()) {
                if (!child.contains(Individu1.getInt(j))) {
                    child.add(Individu1.getInt(j));
                }
                j++;
                j = j % Individu1.size();
            }
        }
        // swap two random elements
        int index1 = (int) Math.floor(Math.random() * Individu1.size());
        int index2 = (int) Math.floor(Math.random() * Individu1.size());
        int temp1 = child.getInt(index1);
        int temp2 = child.getInt(index2);
        child.set(index1, temp2);
        child.set(index2, temp1);
        return new Individu(child);
    }


}
