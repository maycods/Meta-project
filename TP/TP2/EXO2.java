package TP.TP2;

import TP.TP1.EXO1;

import java.util.Arrays;

public class EXO2 {

    public static void main(String[] args) {
        EXO1 exo1 = new EXO1();
//        exo1.getList(Arrays.asList(119, 277, 225, 371, 126, 71, 93, 151, 53, 300));
        exo1.getList(Arrays.asList(2, 13, 7, 22, 51, 6, 57, 24, 16, 2));
        Noeud G = new Noeud<>();
        var reslt = DFS.search(exo1.getList(), G);
        System.out.println("best" + reslt);
        exo1.getList().removeAll(reslt);
        System.out.println(exo1.getList());
        System.out.println("diff: " + Math.abs(reslt.stream().mapToInt(Integer::intValue).sum() - exo1.getList().stream().mapToInt(Integer::intValue).sum()));

//        exo2.DFS();
    }
}
