package Main;

import java.util.ArrayList;

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

        int problemsize=10000;
        // Noeud.T = generationInstance(problemsize);
        GA M =new GA();
         /*for( taillepop=60;taillepop<=100;taillepop+=10){
            for( nbriter=20;nbriter<=50;nbriter+=10){//iterations
                for( methS=1;methS<4;methS++){
                    for( methR=1;methR<4;methR++){
                        for( nbrpointC=1;nbrpointC<4;nbrpointC++){
                            for(tauxC=0.6;tauxC<0.9;tauxC=tauxC+0.1){
                                for( tauxM=0.1;tauxM<0.3;tauxM+=0.1){
                                    moyevaluation=0.0;
                                    System.out.println(taillepop);
                                    for( int i=0;i<10;i++){
                                        a = M.Lancer(problemsize, taillepop,nbriter,tauxC,tauxM,methS,methR,nbrpointC);
                                        moyevaluation +=a.evaluation();
                                    }

                                    if((moyevaluation / 10.0)< bestEvaluation){
                                        bestEvaluation=(moyevaluation / 10.0);
                                        Tpop= taillepop;
                                        Iter=nbriter;
                                        TauxC=tauxC;
                                        TauxM=tauxM;
                                        MethS=methS;
                                        MethR=methR;
                                        Points=nbrpointC;
                                        System.out.println(Tpop+" "+Iter+" "+MethS+" "+MethR+" "+Points+" "+TauxC+" "+TauxM);
                                    }
                                }

                            }
                        }
                    }
                }
            }
        }*/
        int  taillepop=100,nbriter=200,methS=3,methR=1,nbrpointC=3;
        double tauxM=0.1;

        Node p =M.Lancer(problemsize, taillepop, nbriter, tauxM, methS, methR, nbrpointC);

        System.out.println(p.evaluation2());
        System.out.println(p.getEtat().toString());


    }
}
