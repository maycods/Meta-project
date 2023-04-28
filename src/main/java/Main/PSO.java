package Main;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class PSO {
    public int n;

    public PSO(int n) {
        this.n = n;
    }

    public void search(int n, int nbPop, int nbIteration, double w, double c1, double c2) {
        ArrayList<Node> population;
        ArrayList<ArrayList<Integer>> pBest;
        ArrayList<Integer> gBest = null;
        int gBestFitness = Integer.MAX_VALUE;
        // TODO implement the PSO algorithm
        population = new ArrayList<Node>();
        ArrayList<Double> velocity = new ArrayList<Double>();
        pBest = new ArrayList<>();
        ArrayList<Integer> pBestFitness = new ArrayList<>();
        for (int i = 0; i < nbPop; i++) {
            var rand = Node.generateRandomState(n);
            var copie = (ArrayList<Integer>) rand.clone();
            population.add(new Node(copie));
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
                    population.set(j,croisement(population.get(j), Node.generateRandomState(n), (double) 3/4));
//                    population.set(j, croisement(population.get(j),pBest.get((int) (Math.random()*n))));
                }


//                velocity.set(j, velocity.get(j));
                var newNode = new Node(updateParticle(population.get(j), v));

                if (newNode.cal_fitness() < pBestFitness.get(j)){
                    population.set(j, newNode);
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

        System.out.println("gBest = " + gBest);
        System.out.println("gBestFitness = " + gBestFitness);
    }

    private static Node croisement  (Node node1, ArrayList<Integer> node2, double taux) {
        ArrayList<Integer> child = new ArrayList<>();
        //partition the parents into 2 parts and then swap them
        int partition = (int) Math.floor(Math.random() * node1.getEtat().size());
        var rnd  = Math.random();
        if (Math.random() < taux) {
            for (int i = 0; i < partition; i++) {
                child.add(node1.getEtat().get(i));
            }
            for (int i = partition; i < node2.size(); i++) {
                child.add(node2.get(i));
            }
        } else {
            for (int i = partition; i < node2.size(); i++) {
                child.add(node2.get(i));
            }
            for (int i = 0; i < partition; i++) {
                child.add(node2.get(i));
            }
        }
        return new Node(child);
    }
    private ArrayList<Integer> updateParticle(Node particle, Double v) {
        // TODO update the particle position
        ArrayList<Integer> sol = particle.getEtat();

        for (int i = 0; i < n; i++) {
            var val = sol.get(i);
            var newVal = val +  v ;
            newVal = newVal % n ;

            sol.set(i, (int) Math.round(newVal));
        }
        return sol;
    }

    private Integer distance(ArrayList<Integer> d, Node node2) {
        //eucledian distance
//        int distance = 0;
//        for (int i = 0; i < n; i++) {
//            distance = distance + (int) Math.pow(d.get(i) - node2.getEtat().get(i), 2);
//        }
//        return (int) Math.sqrt(distance);
        //hamming distance
//        int distance = 0;
//        for (int i = 0; i < n; i++) {
//            if (d.get(i) != node2.getEtat().get(i)) {
//                distance++;
//            }
//        }
//        System.out.println("distance = " + distance);
//        return distance;
        int distance = 0;
        for (int i = 0; i < n; i++) {
            distance = distance + Math.abs(d.get(i) - node2.getEtat().get(i));
        }
        return  distance%n;
    }


}
