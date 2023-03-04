package TP.TP1;


import java.util.*;

public class EXO1 {
    private ArrayList<Integer> list = new ArrayList<>();


    private ArrayList<Integer> l1 = new ArrayList<>(), l2 = new ArrayList<>();
    public static void main(String[] args) {
        EXO1 exo1 = new EXO1();
        exo1.getList(Arrays.asList(119, 277, 225, 371, 126, 71, 93, 151, 53, 300));
//        exo1.solutionAleatoire(5);
        exo1.solutionAleatoire2();
        System.out.println(exo1.getL1());
        System.out.println(exo1.getL2());
        System.out.println(exo1.verifierValidite());
        System.out.println(exo1.evaluer());
        exo1.solution(Arrays.asList(93, 53, 151, 371, 225),Arrays.asList(126, 71, 119, 300, 277));
        System.out.println(exo1.verifierValidite());
        System.out.println(exo1.evaluer());
//        // la liste:
//        ArrayList<Integer> list = getList(Arrays.asList(119, 277, 225, 371, 126, 71, 93, 151, 53, 300));
//        // les solutions
//        ArrayList<Integer> l1 =getList( Arrays.asList(93, 53, 151, 371, 225));
//        ArrayList<Integer> l2 = getList(Arrays.asList(126, 71, 119, 300, 277));
//        //2eme solution
//        ArrayList<Integer> l3 = getList(Arrays.asList(300, 71, 151, 371));
//        ArrayList<Integer> l4 = getList(Arrays.asList(126, 119, 277, 53, 225, 93));
//        ArrayList<Integer> listx = getList(Arrays.asList(2, 13, 7, 22, 51, 6, 57, 24, 16, 2));
    }

    public EXO1(ArrayList<Integer> list) {
        this.list = list;
    }
    public EXO1() {
        this.list = new ArrayList<>();
        this.l1 = new ArrayList<>();
        this.l2 = new ArrayList<>();
    }
    public void solutionAleatoire2(){
        Random rnd = new Random();
        int taille = list.size();
        ArrayList<Integer> clonedList = (ArrayList<Integer>) this.list.clone();
        int partition = rnd.nextInt(taille -1);
        for (int i =0; i< partition; i++){
            int elt = clonedList.get(rnd.nextInt(taille -i));
            this.l1.add(elt);
            clonedList.remove((Object)elt);
        }
        this.l2.addAll(clonedList);

    }
    public void solutionAleatoire(int n){
        Random rnd = new Random();
        int taille = rnd.nextInt(1000) ;
        int taille1 = rnd.nextInt(1000) ;
        for (int i = 0; i< taille;i ++){
            this.l1.add(rnd.nextInt(1000) );
        }
        for (int i = 0; i< taille1;i ++){
            this.l2.add(rnd.nextInt(1000) );
        }
    }
    public void solution(List<Integer> l1, List<Integer> l2 ){
        this.l1.clear();
        this.l2.clear();
        this.l1.addAll(l1);
        this.l2.addAll(l2);
    }
    public boolean verifierValidite(){
        ArrayList<Integer> clonedList = (ArrayList<Integer>) list.clone();
        if (this.l1.size() + this.l2.size() == this.list.size()){
            Iterator<Integer> iter1 = this.l1.iterator();
            Iterator<Integer> iter2 = this.l2.iterator()  ;
            int sum1 =0, sum2 =0;
            while (iter1.hasNext()){
                int elt = (int) iter1.next();
                if (!clonedList.contains(elt))return false;
                sum1 = sum1 + elt;
                clonedList.remove((Integer) elt);
            } while (iter2.hasNext()){
                int elt = (int) iter2.next();
                if (!clonedList.contains(elt))return false;
                sum2 = sum2 + elt;
                clonedList.remove((Integer) elt);
            }
            int sum = list.stream().mapToInt(Integer::intValue).sum();
            return sum1 + sum2 == sum;
        }
        return false;
    }
    public  int evaluer(){
        int sum1 = l1.stream().mapToInt(Integer::intValue).sum();
        int sum2 = l2.stream().mapToInt(Integer::intValue).sum();
        return Math.abs(sum1 - sum2);
    }
    public void getList(List<Integer> l ){
        this.list.addAll(l);
    }
    public ArrayList<Integer> getList() {
        return list;
    }

    public void setList(ArrayList<Integer> list) {
        this.list = list;
    }

    public ArrayList<Integer> getL1() {
        return l1;
    }

    public void setL1(ArrayList<Integer> l1) {
        this.l1 = l1;
    }

    public ArrayList<Integer> getL2() {
        return l2;
    }

    public void setL2(ArrayList<Integer> l2) {
        this.l2 = l2;
    }
}