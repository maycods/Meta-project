package TP.TP4;

import java.util.ArrayList;
import java.util.Comparator;

public class GA {
    //    algorithme génétique
//    1. initialiser la population
//    2. évaluer la population
//    3. sélectionner les parents
//    4. croiser les parents
//    5. muter les enfants
//    6. évaluer la population
//    7. si la population est stable ou si le nombre d'itération est atteint, arrêter
//    8. sinon, retourner à l'étape 3
//    9. sélectionner le meilleur individu
//    10. retourner le meilleur individu
    public static ArrayList<Noeud> genRandomPop(Integer populationSize, int solSize) {
        ArrayList<Noeud> pop = new ArrayList<>();
        for (int i = 0; i < populationSize; i++) {
            Noeud n = new Noeud();
            n.genRandom(solSize);
            pop.add(n);
        }
        return pop;
    }

    public static void search(ArrayList<Noeud> population, Integer populationSize, Integer maxIterations, double mutationRate, double crossRate) {
        int iteration = 0;
        Noeud best = population.get(0);
        while (iteration < maxIterations) {
//            System.out.println("iteration n : "+iteration);
            ArrayList<Noeud> parents = selectBest(population, 2);
            ArrayList<Noeud> children = new ArrayList<>();
            for (int i = 0; i < populationSize; i++) {
                children.add(cross(parents.get(0), parents.get(1), crossRate));
            }
            for (Noeud n : children) {
                mutate(n, mutationRate);
            }
            children = selectBest(children, populationSize);
            if (best.evaluation() > children.get(0).evaluation()) {
                best = children.get(0);
            }
            if (best.evaluation() == 0) {
                break;
            }
            population.addAll(children);
            population = selectBest(population, populationSize);
            iteration++;
        }
        System.out.println("nombre generation: " + iteration);
        System.out.println("Best solution: " + best.getEtat());
        System.out.println("Best evaluation: " + best.evaluation());
    }

    private static Noeud cross(Noeud parent1, Noeud parent2, double crossRate) {
        ArrayList<Integer> child = new ArrayList<>();
        //partition the parents into 2 parts and then swap them
        int partition = (int) Math.floor(Math.random() * parent1.getEtat().size());
        if (Math.random() < crossRate) {
            for (int i = 0; i < partition; i++) {
                child.add(parent1.getEtat().get(i));
            }
            for (int i = partition; i < parent2.getEtat().size(); i++) {
                child.add(parent2.getEtat().get(i));
            }
        } else {
            for (int i = partition; i < parent2.getEtat().size(); i++) {
                child.add(parent2.getEtat().get(i));
            }
            for (int i = 0; i < partition; i++) {
                child.add(parent1.getEtat().get(i));
            }
        }
        return new Noeud(child, null);

    }

    private static void mutate(Noeud child, double mutationRate) {
        int i = (int) Math.floor(Math.random() * child.getEtat().size());
//        for(int i = 0; i < child.getEtat().size(); i++){
        if (Math.random() < mutationRate) {
            child.getEtat().set(i, Math.abs(1 - child.getEtat().get(i)));
        }
//        }
    }

    private static ArrayList<Noeud> selectBest(ArrayList<Noeud> pop, int plage) {
        ArrayList<Noeud> parents = pop;
        parents.sort(new Comparator<Noeud>() {
            @Override
            public int compare(Noeud o1, Noeud o2) {
                return Integer.compare(o1.evaluation(), o2.evaluation());
            }
        });
        //get the best 2
        parents = new ArrayList<>(parents.subList(0, plage));
        return parents;
    }
}
