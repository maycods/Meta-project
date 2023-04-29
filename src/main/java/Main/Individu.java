package Main;

import it.unimi.dsi.fastutil.ints.IntArrayList;

import java.util.LinkedHashSet;

public class Individu {
    public static int n;
    private IntArrayList Solution;
    private int fitness, longevite;

    public int getLongevite() {
        return longevite;
    }

    public int getFitness() {
        return fitness;
    }

    public void setFitness() {
        this.fitness = this.cal_fitness();
    }

    public void setSolution(IntArrayList Solution) {
        this.Solution = Solution;
    }

    public Individu(int longevite, IntArrayList Solution) {
        this.Solution = Solution;
        this.longevite = longevite;
    }

    public Individu(IntArrayList Solution) {
        this.Solution = Solution;
    }


    public IntArrayList getSolution() {
        return Solution;
    }

    public boolean threatens(int i1, int j1, int i2, int j2) {
        return (j1 == j2) || (Math.abs(i1 - i2) == Math.abs(j1 - j2));
    }

    public  static IntArrayList generateRandomSol(int n) {
        IntArrayList state = new IntArrayList();
        for (int i = 0; i < n; i++) {
            var rnd = (int) (Math.random() * n);
            if (!state.contains(rnd)) {
                state.add(rnd);
            } else {
                i--;
            }
        }
        return state;
    }

    public Integer cal_fitness() {
        int threatened = 0;
        for (int i = 0; i <getSolution().size(); i++) {
            for (int j = i + 1; j <getSolution().size(); j++) {
                if (threatens(i, this.getSolution().getInt(i), j, this.getSolution().getInt(j))) {
                    threatened++;
                }
            }
        }
        return threatened;

    }
}




