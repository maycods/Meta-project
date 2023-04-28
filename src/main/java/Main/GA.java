package Main;

import it.unimi.dsi.fastutil.ints.IntArrayList;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class GA {
        public double factorial(Long n){
            if(n==0) {
                return 1.0;
            }
            else {
                return n * factorial(n - 1);
            }
        }

        int i=0;
        public IntArrayList SoluAleatoire(int p){

            LinkedHashSet<Integer> uniqueArray = new LinkedHashSet<>();
            while(uniqueArray.size() != p){

                uniqueArray.add( (int)Math.floor(Math.random() * p ) );

            }
            IntArrayList S= new IntArrayList(uniqueArray);
            return S;
        }
        public ArrayList<Individu> GenerationPopulation(int n,int p){
            Individu.n=p;
            ArrayList<Individu> population =new ArrayList<Individu>();
            for(int i=0;i<n;i++){
                population.add(new Individu(0,SoluAleatoire(p)));
            }
            return population;
        }

        public void EvaluationPop( ArrayList<Individu> pop){
            for(int i=0;i<pop.size();i++){
                pop.get(i).setFitness();
            }
        }
        public Individu getBestSol(ArrayList<Individu> pop){
            pop.sort(new Comparator<Individu>() {
                @Override
                public int compare(Individu o1, Individu o2) {
                    return Integer.compare(o1.getFitness(), o2.getFitness());
                }
            });
            return pop.get(0);
        }

        public Individu Mutation(Individu parent, double tauxM){
            Individu child =new Individu(i,parent.getSolution().clone());
            double mut ;
            for(int i=0;i<parent.getSolution().size();i++){
                mut = Math.random();
                if(mut<tauxM){
                    int a =(int)Math.floor(Math.random() * Individu.n );
                    int el1= child.getSolution().getInt(i);
                    int el2= child.getSolution().getInt(a);
                    child.getSolution().set(i,el2);
                    child.getSolution().set(a,el1);
                }
            }
            return child;
        }
        public ArrayList<Individu> Croisement(Individu parent1 , Individu parent2 ,int nbrpoints){

            ArrayList<Individu> childs=new ArrayList<>();
            IntArrayList soluchild1 = new IntArrayList(),soluchild2 = new IntArrayList() ;
            LinkedHashSet<Integer> rdmm= new LinkedHashSet<>();

            while(rdmm.size() != nbrpoints){
                rdmm.add((int) ((Math.random() * (parent1.getSolution().size() - 2)) + 1));
            }
            ArrayList<Integer> rdm = new ArrayList<Integer>(rdmm);
            Collections.sort(rdm);
            int k=0;
            for(int i=0;i<parent1.getSolution().size();i++){
                if(k<rdm.size() && rdm.get(k)==i) k++;
                if(k%2!=0){
                    soluchild1.add(parent2.getSolution().getInt(i));
                    soluchild2.add(parent1.getSolution().getInt(i));

                }else{
                    soluchild1.add(parent1.getSolution().getInt(i));
                    soluchild2.add(parent2.getSolution().getInt(i));
                }
            }
            childs.add(new Individu(i,soluchild1));
            childs.add(new Individu(i,soluchild2));

            return childs;
        }

        public ArrayList<Individu> Selection(ArrayList<Individu> pop,int methode){
            ArrayList<Individu> souspop = new ArrayList<Individu>();
            int rdm;
            switch (methode) {
                case 1://uniforme
                    ArrayList<Individu> popCopy = (ArrayList<Individu>) pop.clone();
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
                    ArrayList<Individu> souspop2 = new ArrayList<Individu>();
                    ArrayList<Individu> popCopy2 = (ArrayList<Individu>) pop.clone();
                    int taillesous = (int) Math.floor(Math.random() * (popCopy2.size()/2));
                    for (int i = 0; i < taillesous; i++) {
                        rdm = (int) Math.floor(Math.random() * popCopy2.size());
                        souspop2.add(pop.get(rdm));
                        popCopy2.remove(rdm);
                    }
                    souspop2.sort(new Comparator<Individu>() {
                        @Override
                        public int compare(Individu o1, Individu o2) {
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
        public ArrayList<Individu> Remplacement(ArrayList<Individu> pop,ArrayList<Individu> childs,int methode){
            ArrayList<Individu> newpop = (ArrayList<Individu>) pop.clone();;
            switch (methode) {
                case 1://Elitist Replacement
                    newpop.addAll(childs);
                    newpop.sort(new Comparator<Individu>() {
                        @Override
                        public int compare(Individu o1, Individu o2) {
                            return Integer.compare(o1.getFitness(), o2.getFitness());
                        }
                    });
                    newpop.subList(pop.size(), newpop.size()).clear();
                    return newpop;
                case 2://plus vieuw par new
                    newpop.addAll(childs);
                    newpop.sort(new Comparator<Individu>() {
                        @Override
                        public int compare(Individu o1, Individu o2) {
                            return Integer.compare(o1.getLongevite(), o2.getLongevite());
                        }
                    });
                    newpop.subList(0, 4).clear();
                    return newpop;
                case 3://moins bon par enfants
                    newpop.subList(newpop.size()-childs.size(),newpop.size()).clear();
                    newpop.addAll(childs);
                    newpop.sort(new Comparator<Individu>() {
                                    @Override
                                    public int compare(Individu o1, Individu o2) {
                                        return Integer.compare(o1.getFitness(), o2.getFitness());
                                    }
                                }
                    );
                    return newpop;
                default:
                    return newpop;
            }

        }

        public Individu Lancer(int tailleProblm,int taillePop,int nbrIter,double tauxM,int methodeSel,int methodeRep,int nbrpoints){

            Individu best,bestg;
            ArrayList<Individu> parents,pop,children;

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
                if(bestg.getFitness() > best.getFitness()){bestg.setSolution(best.getSolution());}
                pop=Remplacement(pop,children,methodeRep);
                i++;
            }
            return bestg;
        }


    }



