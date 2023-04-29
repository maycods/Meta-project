package Main;

public class Test {


    public static void main(String[] args)  {

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

        PSO P = new PSO(30);
        GA g = new GA();
        Individu pso = P.search(1000, 1000, 0.5, 0.4);//700 500 3 1 2 0.017
        Individu pa = g.Lancer(30, 1000, 1000, 0.5, 1, 1, 2, 0.3, 700);


        System.out.println("fitness pso "+pso.cal_fitness());
        System.out.println("fitness ga "+pa.cal_fitness());

    }

}
