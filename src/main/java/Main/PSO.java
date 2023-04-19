package Main;

import java.util.ArrayList;
import java.util.List;

public class PSO {
    public int n;

    public PSO(int n) {
        this.n = n;
    }

    public void search(int n, int nbPop, int nbIteration, double w, int c1, int c2) {
        ArrayList<Node> population;
        ArrayList<ArrayList<Integer>> pBest;
        ArrayList<Integer> gBest = null;
        int gBestFitness = Integer.MAX_VALUE;
        ArrayList<Double> velocity;
        // TODO implement the PSO algorithm
        population = new ArrayList<Node>();
        velocity = new ArrayList<Double>();
        pBest = new ArrayList<>();
        ArrayList<Integer> pBestFitness = new ArrayList<>();
        for (int i = 0; i < nbPop; i++) {
            var rand = Node.generateRandomState(n);
            var copie = (ArrayList<Integer>)rand.clone();

            population.add(new Node(copie));
            velocity.add(Math.random());
            pBest.add(rand);
            pBestFitness.add(population.get(i).cal_fitness());
            System.out.println("pop " + population.get(i).getEtat() + " " + population.get(i).cal_fitness());
            if (population.get(i).cal_fitness() < gBestFitness) {
                gBest = population.get(i).getEtat();
                gBestFitness = population.get(i).cal_fitness();
            }

        }
        int i = 0;
        while (i < nbIteration) {
            for (int j = 0; j < nbPop; j++) {
                // update the velocity
                double r1 = Math.random();
                double r2 = Math.random();
                double v;

                v = w * velocity.get(j) + c1 * r1 * (distance(pBest.get(j), population.get(j))) + c2 * r2 * (distance(gBest, population.get(j)));
//                System.out.println("v = " + v);
                velocity.set(j, v);
                var newNode = updateParticle(population.get(j), v);
                population.set(j, new Node(newNode));
//                System.out.println("new "+newNode+ " "+ population.get(j).cal_fitness() );

                if (population.get(j).cal_fitness() < pBestFitness.get(j) ) {
                    pBest.set(j, population.get(j).getEtat() );
                    pBestFitness.set(j, population.get(j).cal_fitness());
                }
                if (population.get(j).cal_fitness() < pBestFitness.get(j)) {
                    gBest = population.get(j).getEtat();
                    gBestFitness = population.get(j).cal_fitness();
                }
                if (gBestFitness == 0) break;
            }
            i++;
        }
        System.out.println("iteration " + i);

        System.out.println("gBest = " + gBest);
        Node x = new Node(gBest);
        System.out.println("gBestFitness = " + x.evaluation());
        System.out.println("gBestFitness = " + gBestFitness);
    }

    private ArrayList<Integer> updateParticle(Node particle, double v) {
        // TODO update the particle position
        ArrayList<Integer> sol = particle.getEtat();

        for (int i = 0; i < n; i++) {
            var val = sol.get(i);
            var newVal = val + v+n;
            newVal = newVal % n;
            sol.set(i, (int) Math.round(newVal));
        }
        return sol;
    }

    private Integer distance(ArrayList<Integer> d, Node node2) {
        //hamming distance
        int distance = 0;
        for (int i = 0; i < n; i++) {
            distance = distance + Math.abs(d.get(i) - node2.getEtat().get(i));
        }
        return distance;
    }


}
