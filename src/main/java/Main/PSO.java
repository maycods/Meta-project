package Main;

import it.unimi.dsi.fastutil.ints.IntArrayList;

import java.util.ArrayList;

public class PSO {
    public int n;

    public PSO(int n) {
        this.n = n;
    }

    public Individu search(int nbPop, int nbIteration, double c1, double c2) {
        ArrayList<Noeud> population;
        ArrayList<IntArrayList> pBest;
        IntArrayList gBest = null;
        int gBestFitness = Integer.MAX_VALUE;
        population = new ArrayList<Noeud>();
        pBest = new ArrayList<>();
        ArrayList<Integer> pBestFitness = new ArrayList<>();
        for (int i = 0; i < nbPop; i++) {
            var rand = Noeud.generateRandomState(n);
            var copie = (IntArrayList) rand.clone();

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
            for (int j = 0; j < nbPop; j++) {
                double r1 = Math.random();
                if (r1 < c1) {
                    population.set(j, croisement(population.get(j).getEtat(), gBest));
                } else if (r1 < c2 && r1 > c1) {
                    population.set(j, croisement(population.get(j).getEtat(), pBest.get(j)));
                } else {
                    population.set(j, croisement(pBest.get(j), Noeud.generateRandomState(n)));
                }
                var fit = population.get(j).cal_fitness();
                if (fit < pBestFitness.get(j)) {
                    pBest.set(j, population.get(j).getEtat());
                    pBestFitness.set(j, fit);
                    if (fit < gBestFitness) {
                        System.out.println("i = " + i + " j = " + j);
                        System.out.println("gBest = " + gBest + " ");
                        System.out.println("gBestFitness = " + gBestFitness);
                    }
                    if (fit <= gBestFitness) {
                        gBest = pBest.get(j);
                        gBestFitness = fit;

                    }
                }
            }
            if (gBestFitness == 0) break;
            i++;
        }

        System.out.println("iteration " + i);

        System.out.println("gBest = " + gBest);
        Individu x = new Individu(gBest);
        System.out.println("gBestFitness = " + gBestFitness);
        return x;
    }

    private static Noeud croisement(IntArrayList Noeud1, IntArrayList Noeud2) {
        IntArrayList child = new IntArrayList();
        //partition the parents into 2 parts and then swap them
        int partition = (int) Math.floor(Math.random() * Noeud1.size() /4);

        var rnd = Math.random();
        if (rnd < 0.30) {
            for (int i = 0; i < partition; i++) {
                child.add(Noeud1.getInt(i));
            }
            int j = 0;

            while (child.size() < Noeud2.size()) {
                if (!child.contains(Noeud2.getInt(j))) {
                    child.add(Noeud2.getInt(j));
                }
                j++;
                j = j % Noeud1.size();
            }
        } else {
            for (int i = partition; i < Noeud2.size(); i++) {
                child.add(Noeud2.get(i));
            }
            int j = 0;
            while (child.size() < Noeud1.size()) {
                if (!child.contains(Noeud1.getInt(j))) {
                    child.add(Noeud1.getInt(j));
                }
                j++;
                j = j % Noeud1.size();
            }
            // swap two random elements
            int index1 = (int) Math.floor(Math.random() * Noeud1.size());
            int index2 = (int) Math.floor(Math.random() * Noeud1.size());
            int temp1 = child.get(index1);
            int temp2 = child.get(index2);
            child.set(index1, temp2);
            child.set(index2, temp1);
        }
        return new Noeud(child);
    }


}
