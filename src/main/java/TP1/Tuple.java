package TP1;

import java.util.HashSet;
import java.util.Set;

public class Tuple {
    private Set<Integer> listA;
    private Set<Integer> listB;
    private Integer sumA;
    private Integer sumB;

    public Tuple(Set<Integer> listA, Set<Integer> listB) {
        this.listA = listA;
        this.listB = listB;
        this.sumA =0 ;
        this.sumB = 0;
    }

//    public Set<Tuple> generateNextStates(Set<Integer> remaining) {
//        Set<Tuple> nextStates = new HashSet<Tuple>();
//        for (int i : remaining) {
//            Tuple newStateA = new Tuple(new HashSet<Integer>(setA), new HashSet<Integer>(setB), sumA, sumB);
//            newStateA.addElementToSetA(i);
//            nextStates.add(newStateA);
//
//            PartitionState newStateB = new PartitionState(new HashSet<Integer>(setA), new HashSet<Integer>(setB), sumA, sumB);
//            newStateB.addElementToSetB(i);
//            nextStates.add(newStateB);
//        }
//        return nextStates;
//    }
//
    public Set<Integer> getListA() {
        return listA;
    }

    public void setListA(Set<Integer> listA) {
        this.listA = listA;
    }

    public Set<Integer> getListB() {
        return listB;
    }

    public void setListB(Set<Integer> listB) {
        this.listB = listB;
    }

    public Integer getSumA() {
        return sumA;
    }

    public void setSumA(Integer sumA) {
        this.sumA = sumA;
    }

    public Integer getSumB() {
        return sumB;
    }

    public void setSumB(Integer sumB) {
        this.sumB = sumB;
    }
}
