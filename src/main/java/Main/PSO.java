package Main;

import it.unimi.dsi.fastutil.ints.IntArrayList;

import java.util.ArrayList;

public class PSO {
    public int n;

    public PSO(int n) {
        this.n = n;
    }

    public Individu search(int n, int nbPop, int nbIteration, double w, int c1, int c2) {
        ArrayList<Noeud> population;
        ArrayList<IntArrayList> pBest;
        IntArrayList gBest = null;
        int gBestFitness = Integer.MAX_VALUE;
        // TODO implement the PSO algorithm
        population = new ArrayList<Noeud>();
        ArrayList<Double> velocity = new ArrayList<Double>();
        pBest = new ArrayList<>();
        ArrayList<Integer> pBestFitness = new ArrayList<>();
        for (int i = 0; i < nbPop; i++) {
            var  rand = Noeud.generateRandomState(n);
            var copie = (IntArrayList)rand.clone();

            population.add(new Noeud(copie));
            velocity.add(Math.random()*n);
            pBest.add(rand);
            pBestFitness.add(population.get(i).cal_fitness());
//            System.out.println("pop " + population.get(i).getEtat() + " " + population.get(i).cal_fitness());
            if (population.get(i).cal_fitness() < gBestFitness) {
                gBest = population.get(i).getEtat();
                gBestFitness = population.get(i).cal_fitness();
            }

        }
        System.out.println("gBest = " + gBest + " " + gBestFitness);
        int i = 0;
        int nbpbest = 0;
        int nbgbest = 0;
        while (i < nbIteration) {
            for (int j = 0; j < nbPop; j++) {
                // update the velocity
                double r1 = Math.random();
                double r2 = Math.random();
                double v = 0.0;
//                v = w * velocity.get(j) + c1 * r1 * (distance(pBest.get(j), population.get(j))) + c2 * r2 * (distance(gBest, population.get(j)));
                if(r1 < (double)1/3){
                    population.set(j,croisement(population.get(j), gBest, (double)1/4));
                } else if (r1 < (double) 2 /3 && r1 > (double) 1 /3) {
                    population.set(j, croisement(population.get(j), pBest.get(j), (double) 2 / 4));
//                }
                } else {
                    population.set(j,croisement(population.get(j), Noeud.generateRandomState(n), (double) 3/4));
//                    population.set(j, croisement(population.get(j),pBest.get((int) (Math.random()*n))));
                }


//                velocity.set(j, velocity.get(j));
                var newNoeud = new Noeud(updateParticle(population.get(j), v));

                if (newNoeud.cal_fitness() < pBestFitness.get(j)){
                    population.set(j, newNoeud);
//                    System.out.println("pbest i = " + i + " j = " + j);

                        nbpbest++;
                        pBest.set(j, population.get(j).getEtat());
                        pBestFitness.set(j, population.get(j).cal_fitness());
                    if (pBestFitness.get(j) < gBestFitness) {
                        System.out.println("i = " + i + " j = " + j);
                        System.out.println("gBest = " + gBest + " " + gBestFitness);
                        nbgbest++;
                        gBest = pBest.get(j);
                        gBestFitness = pBestFitness.get(j);
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

    private static Noeud croisement  (Noeud Noeud1, IntArrayList Noeud2, double taux) {
        IntArrayList child = new IntArrayList();
        //partition the parents into 2 parts and then swap them
        int partition = (int) Math.floor(Math.random() * Noeud1.getEtat().size());
        var rnd  = Math.random();
        if (Math.random() < taux) {
            for (int i = 0; i < partition; i++) {
                child.add(Noeud1.getEtat().getInt(i));
            }
            for (int i = partition; i < Noeud2.size(); i++) {
                child.add(Noeud2.get(i));
            }
        } else {
            for (int i = partition; i < Noeud2.size(); i++) {
                child.add(Noeud2.get(i));
            }
            for (int i = 0; i < partition; i++) {
                child.add(Noeud2.get(i));
            }
        }
        return new Noeud(child);
    }
    private IntArrayList updateParticle(Noeud particle, double v) {
        // TODO update the particle position
        IntArrayList sol = particle.getEtat();

        for (int i = 0; i < n; i++) {
            var val = sol.get(i);
            var newVal = val +  v ;
            newVal = newVal % n ;

            sol.set(i, (int) Math.round(newVal));
        }
        return sol;
    }

    private Integer distance(IntArrayList d, Noeud Noeud2) {
        //hamming distance
//        int distance = 0;
//        for (int i = 0; i < n; i++) {
//            if (d.get(i) != Noeud2.getEtat().get(i)) {
//                distance++;
//            }
//        }
//        System.out.println("distance = " + distance);
//        return distance;
        int distance = 0;
        for (int i = 0; i < n; i++) {
            distance = distance + Math.abs(d.get(i) - Noeud2.getEtat().get(i));
        }
        return  distance%n;
    }


}
