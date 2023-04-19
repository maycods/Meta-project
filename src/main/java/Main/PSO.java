package Main;

import java.util.ArrayList;
import java.util.Random;

public class PSO {
    public ArrayList<Node> population;
    public int n;
    public int nbPop;
    private ArrayList<Node> Pbest;
    private Node Gbest;
   private ArrayList<Double> velocity;
    public PSO(int n, int nbPop) {
        this.n = n;
        population = new ArrayList<Node>();
        velocity = new ArrayList<Double>();
        Pbest = new ArrayList<Node>();
        Random rand = new Random();
        for (int i = 0; i < nbPop; i++) {
            population.add(new Node(Node.generateRandomState(n)));
            velocity.add( (Math.random() ));
            Pbest.add(population.get(i));
            // get the Gbest from the minimum of the pbest fitness
            if (Gbest == null || Gbest.getF() > Pbest.get(i).getF()) {
                Gbest = Pbest.get(i);
            }
        }
    }
    public Node search(int w, int c1, int c2) {
        // TODO implement the PSO algorithm


        return null;

    }

    public ArrayList<Double> getVelocity() {
        return velocity;
    }

}
