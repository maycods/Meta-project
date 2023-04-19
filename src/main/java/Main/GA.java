package Main;

import it.unimi.dsi.fastutil.ints.IntArrayList;

import java.util.*;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


    public class GA {

        int i=0;
        public IntArrayList SoluAleatoire(int p){

            LinkedHashSet<Integer> uniqueArray = new LinkedHashSet<>();
            while(uniqueArray.size() != p){

                uniqueArray.add( (int)Math.floor(Math.random() * p ) );

            }
            IntArrayList S= new IntArrayList(uniqueArray);
            return S;
        }
        public ArrayList<Node> GenerationPopulation(int n,int p){
            Node.n=p;
            ArrayList<Node> population =new ArrayList<Node>();
            for(int i=0;i<n;i++){
                population.add(new Node(0,SoluAleatoire(p)));
            }
            return population;
        }

        public void EvaluationPop( ArrayList<Node> pop){
            for(int i=0;i<pop.size();i++){
                pop.get(i).setFitness();
            }
        }
        public Node getBestSol(ArrayList<Node> pop){
            pop.sort(new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    return Integer.compare(o1.getFitness(), o2.getFitness());
                }
            });
            return pop.get(0);
        }

        public Node Mutation(Node parent, double tauxM){
            Node child =new Node(i,parent.getEtat().clone());
            double mut ;
            for(int i=0;i<parent.getEtat().size();i++){
                mut = Math.random();
                if(mut<tauxM){
                    int a =(int)Math.floor(Math.random() * Node.n );
                    int el1= child.getEtat().getInt(i);
                    int el2= child.getEtat().getInt(a);
                    child.getEtat().set(i,el2);
                    child.getEtat().set(a,el1);
                }
            }
            return child;
        }
        public ArrayList<Node> Croisement(Node parent1 , Node parent2 ,int nbrpoints){

            ArrayList<Node> childs=new ArrayList<>();
            IntArrayList soluchild1 = new IntArrayList(),soluchild2 = new IntArrayList() ;
            LinkedHashSet<Integer> rdmm= new LinkedHashSet<>();

            while(rdmm.size() != nbrpoints){
                rdmm.add((int) ((Math.random() * (parent1.getEtat().size() - 2)) + 1));
            }
            ArrayList<Integer> rdm = new ArrayList<Integer>(rdmm);
            Collections.sort(rdm);
            int k=0;
            for(int i=0;i<parent1.getEtat().size();i++){
                if(k<rdm.size() && rdm.get(k)==i) k++;
                if(k%2!=0){
                    soluchild1.add(parent2.getEtat().getInt(i));
                    soluchild2.add(parent1.getEtat().getInt(i));

                }else{
                    soluchild1.add(parent1.getEtat().getInt(i));
                    soluchild2.add(parent2.getEtat().getInt(i));
                }
            }
            childs.add(new Node(i,soluchild1));
            childs.add(new Node(i,soluchild2));

            return childs;
        }

        public ArrayList<Node> Selection(ArrayList<Node> pop,int methode){
            ArrayList<Node> souspop = new ArrayList<Node>();
            int rdm;
            switch (methode) {
                case 1://uniforme
                    ArrayList<Node> popCopy = (ArrayList<Node>) pop.clone();
                    for (int i = 0; i < 2; i++) {
                        rdm = (int) Math.floor(Math.random() * popCopy.size());
                        souspop.add(pop.get(rdm));
                        popCopy.remove(rdm);
                    }
                    return souspop;
                case 2://elitiste
                    souspop.add(pop.get(0));
                    souspop.add(pop.get(1));
                    return souspop;
                case 3://tournoi
                    ArrayList<Node> souspop2 = new ArrayList<Node>();
                    ArrayList<Node> popCopy2 = (ArrayList<Node>) pop.clone();
                    int taillesous = (int) Math.floor(Math.random() * (popCopy2.size()/2));
                    for (int i = 0; i < taillesous; i++) {
                        rdm = (int) Math.floor(Math.random() * popCopy2.size());
                        souspop2.add(pop.get(rdm));
                        popCopy2.remove(rdm);
                    }
                    souspop2.sort(new Comparator<Node>() {
                        @Override
                        public int compare(Node o1, Node o2) {
                            return Integer.compare(o1.getFitness(), o2.getFitness());
                        }
                    });
                    souspop.add(pop.get(0));
                    souspop.add(pop.get(1));
                    break;
                default:
                    return souspop;
            }
            return souspop;
        }
        public ArrayList<Node> Remplacement(ArrayList<Node> pop,ArrayList<Node> childs,int methode){
            ArrayList<Node> newpop = (ArrayList<Node>) pop.clone();;
            switch (methode) {
                case 1://Elitist Replacement
                    newpop.addAll(childs);
                    newpop.sort(new Comparator<Node>() {
                        @Override
                        public int compare(Node o1, Node o2) {
                            return Integer.compare(o1.getFitness(), o2.getFitness());
                        }
                    });
                    newpop.subList(pop.size(), newpop.size()).clear();
                    return newpop;
                case 2://plus vieuw par new
                    newpop.addAll(childs);
                    newpop.sort(new Comparator<Node>() {
                        @Override
                        public int compare(Node o1, Node o2) {
                            return Integer.compare(o1.getLongevite(), o2.getLongevite());
                        }
                    });
                    newpop.subList(0, 4).clear();
                    return newpop;
                case 3://moins bon par enfants
                    newpop.subList(newpop.size()-childs.size(),newpop.size()).clear();
                    newpop.addAll(childs);
                    newpop.sort(new Comparator<Node>() {
                                    @Override
                                    public int compare(Node o1, Node o2) {
                                        return Integer.compare(o1.getFitness(), o2.getFitness());
                                    }
                                }
                    );
                    return newpop;
                default:
                    return newpop;
            }

        }

        public Node Lancer(int tailleProblm,int taillePop,int nbrIter,double tauxM,int methodeSel,int methodeRep,int nbrpoints){

            Node best,bestg;
            ArrayList<Node> parents,pop,children;

            pop= GenerationPopulation(taillePop,tailleProblm);

            EvaluationPop(pop);
            bestg=getBestSol(pop);

            while(i<nbrIter && bestg.getFitness()!=0){
                parents = Selection(pop,methodeSel);
                children = new ArrayList<>();

                children.addAll(Croisement(parents.get(0),parents.get(1),nbrpoints));
                children.add(Mutation(children.get(0),tauxM));
                children.add(Mutation(children.get(1),tauxM));

                EvaluationPop(children);
                best=getBestSol(children);
                if(bestg.getFitness() > best.getFitness()){bestg.setEtat(best.getEtat());}
                pop=Remplacement(pop,children,methodeRep);
                i++;
            }
            return bestg;
        }
    }


