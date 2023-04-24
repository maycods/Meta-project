package Main;

import java.util.ArrayList;
import java.lang.Math;
public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {



       /* Node.n = 10;
        PSO pso = new PSO(10);
         pso.search(10, 35, 700000, 0.6, 2, 2);*/
//        IntArrayList best;
//        long d,f,s1=0,s2=0,sF=0,sB=0;
//
//        for(int i=6;i<20;i++){
//            Node.n=i;
//           for(int j=0;j<20;j++){
//                d=System.currentTimeMillis();
//                best=a.Recherche(new Node(new IntArrayList(),0),1);//19
//                f=System.currentTimeMillis();
//                s1+=f-d;
//               //System.out.println(best.toString());
//
//                d=System.currentTimeMillis();
//                best=a2.Recherche(new Node(new IntArrayList(),0),2);//20
//                f=System.currentTimeMillis();
//                s2+=f-d;
//                //System.out.println(best.toString());
//
//                d=System.currentTimeMillis();
//                best=bfs.Recherche(new Node(new IntArrayList()));// 10
//                f=System.currentTimeMillis();
//                sB+=f-d;
//               // System.out.println(best.toString());
//
//                d=System.currentTimeMillis();
//                best=dfs.Recherche(new Node(new IntArrayList()));//12
//                f=System.currentTimeMillis();
//                sF+=f-d;
//              // System.out.println(best.toString());
//            }
//            System.out.println(i+") :\n"+(long)(s1/20.0)+" "+a.nbrNdev+" "+a.nbrNgen);
//            System.out.println((long)(s2/20.0)+" "+a2.nbrNdev+" "+a2.nbrNgen);
//            System.out.println((long)(sF/20.0)+" "+dfs.nbrNdev+" "+ dfs.nbrNgen);
//            System.out.println((long)(sB/20.0)+" "+bfs.nbrNdev+" "+ bfs.nbrNgen);
//        }

        int problemsize=1000;
        int  taillepop=90,nbriter=20,methS=3,methR=1,nbrpointC=3;
        double tauxM=0.1;
        double moyevaluation;
        Node a;
        double bestEvaluation=1000000.0;
        int Tpop=0,Iter=0,MethS=0,MethR=0,Points=0;
        double TauxC=0, TauxM=0;
        // Noeud.T = generationInstance(problemsize);
        GA M =new GA();/*
         for( taillepop=4000;taillepop<=5000;taillepop+=100){
             System.out.println(taillepop);
            for( nbriter=1000;nbriter<=2000;nbriter+=100){//iterations
                for( methS=1;methS<4;methS++){
                    for( methR=1;methR<4;methR++){
                        for( nbrpointC=1;nbrpointC<4;nbrpointC++){
                                for( tauxM=0.1;tauxM<0.5;tauxM+=0.1){
                                    moyevaluation=0.0;

                                   // for( int i=0;i<10;i++){
                                        a = M.Lancer(problemsize, taillepop,nbriter,tauxM,methS,methR,nbrpointC);
                                        moyevaluation +=a.evaluation2();
                                   // }4000 1200 3 2 3 0.2
                                    if(moyevaluation ==0 ) break;
                                    if((moyevaluation )< bestEvaluation){
                                        bestEvaluation=(moyevaluation );
                                        Tpop= taillepop;
                                        Iter=nbriter;
                                        TauxM=tauxM;
                                        MethS=methS;
                                        MethR=methR;
                                        Points=nbrpointC;//1000     1200      3         2           2        0.1
                                        System.out.println(Tpop+" "+Iter+" "+MethS+" "+MethR+" "+Points+" "+TauxM);
                                    }
                                }

                        }
                    }
                }
            }
        }*/
        /*int  taillepop=100,nbriter=100,methS=3,methR=1,nbrpointC=3;
        double tauxM=0.1;*/
        int nbr=0;

       // double taillepopp=M.factorial((long) 10.0)/10;
        //System.out.println(taillepopp);
for(int i=0;i<100;i++) {
 Individu  p = M.Lancer(10,7000, 1200, 0.1, 3, 2, 4);
    if(p.evaluation2()==0) nbr++;
    System.out.println(nbr);
}
       /* System.out.println(p.evaluation2());
        System.out.println(p.getEtat().toString());*/
        System.out.println(nbr);


    }
}
