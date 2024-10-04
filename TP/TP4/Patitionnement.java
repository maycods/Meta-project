package TP.TP4;

import java.util.ArrayList;
import java.util.Arrays;

public class Patitionnement {

    int[] T;
    int[] S;

    public static void main(String[] args) {
        Patitionnement patitionnement = new Patitionnement();
        patitionnement.generation(10);
        System.out.println(Arrays.toString(patitionnement.T));

        patitionnement.SoluAleatoire();
        System.out.println(Arrays.toString(patitionnement.S));

        System.out.println(patitionnement.verification(patitionnement.S) ? "La solution est valide et son evaluation est de " +
                patitionnement.evaluation(patitionnement.S) : "la solution n es t pas valide");

    }

    public void generation(int n) {
        T = new int[n];
        for (int i = 0; i < n; i++) {
            T[i] = (int) Math.floor(Math.random() * 101);
            ;
            ;
        }
    }

    public void SoluAleatoire() {
        S = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            S[i] = (int) Math.floor(Math.random() * 2);
        }
    }

    public boolean verification(int S[]) {
        int i = 0;
        while (i < S.length) {
            if (S[i] != 0 && S[i] != 1) {
                return false;
            }
            i++;
        }
        return true;
    }

    public int evaluation(int S[]) {
        int cpt1 = 0, cpt2 = 0;
        for (int i = 0; i < S.length; i++) {
            if (S[i] == 0) {
                cpt1 += T[i];
            } else {
                cpt2 += T[i];
            }
        }
        return Math.abs(cpt1 - cpt2);
    }

    public ArrayList<Integer> newArray() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int x : this.T) {
            list.add((Integer) x);
        }
        return list;
    }

}