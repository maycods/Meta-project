package Main;

import java.util.Random;

public class Test {


    public static void main(String[] args) throws CloneNotSupportedException {

           /* int problemsize=100;
            int  taillepop=90,nbriter=20,methS=3,methR=1,nbrpointC=3;
            double tauxM=0.1;
            double moyevaluation;
            Individu a;
            double bestEvaluation=1000000.0;
            int Tpop=0,Iter=0,MethS=0,MethR=0,Points=0;
            double TauxC=0, TauxM=0;
            // Noeud.T = generationInstance(problemsize);
            GA M =new GA();
         for( taillepop=100;taillepop<1000;taillepop+=100){
             System.out.println(taillepop);
            for( nbriter=100;nbriter<=500;nbriter+=100){//iterations
                for( methS=1;methS<4;methS++){
                    for( methR=1;methR<4;methR++){
                        for( nbrpointC=1;nbrpointC<4;nbrpointC++){
                                for( tauxM=0.001;tauxM<0.02;tauxM+=0.004){
                                    moyevaluation=0.0;

                                    for( int i=0;i<3;i++){
                                        a = M.Lancer(problemsize, taillepop,nbriter,tauxM,methS,methR,nbrpointC);
                                        moyevaluation +=a.evaluation2();
                                    }

                                    if((moyevaluation/3 )< bestEvaluation){
                                        bestEvaluation=(moyevaluation/3 );
                                        Tpop= taillepop;
                                        Iter=nbriter;
                                        TauxM=tauxM;
                                        MethS=methS;
                                        MethR=methR;
                                        Points=nbrpointC;//1000     1200      3         2           2        0.1
                                        System.out.println(Tpop+" "+Iter+" "+MethS+" "+MethR+" "+Points+" "+TauxM+" eva:"+bestEvaluation);
                                    }
                                }

                        }
                    }
                }
            }
        }*/

    /*int  taillepop=100,nbriter=100,methS=3,methR=1,nbrpointC=3;
        double tauxM=0.1;*/
            int nbr=0,nbr2=0,moy=0,moy2=0;
            PSO P = new PSO();
            GA g = new GA();
            // double taillepopp=M.factorial((long) 10.0)/10;
            //System.out.println(taillepopp);
           // for(int i=0;i<100;i++) {
                 Individu  pso = P.search(10,100,100);//700 500 3 1 2 0.017



                System.out.println(g.Lancer(10,100 ,100 ,0.5,1,1, 3,0.7,50).evaluation2());
         /*
                moy+=ga.evaluation2();
                moy2+=pso.evaluation2();
                if(ga.evaluation2()==0) nbr2++;
                if(pso.evaluation2()==0) nbr++;*/
           // }
       /* System.out.println(p.evaluation2());
        System.out.println(p.getEtat().toString());*/
            System.out.println(moy/100+" "+nbr2);
            System.out.println(moy2/100+" "+nbr);


        }

}
