package Main;

public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {

        DFS dfs = new DFS();
        BFS bfs = new BFS();
        Astar a = new Astar();
        Astar a2 = new Astar();

        Noeud.n = 200;
//        var res = bfs.Recherche(new Noeud(new ArrayList<>()));
//        System.out.println("BFS " + res.toString() );
//        Noeud res2  = new Noeud(res);
//        System.out.println("BFS " + res2.cal_fitness() );
        PSO pso = new PSO(200);
//        for (int i = 5; i < 100; i=i+10) {
//            System.out. < 10; j++) {
//                System.out.pprintln("i = " + i);
////            double  c2 = 0;
////            double c1 = 0;
////            for (int j = 0; jrintln("c1 "+c1+" c2 "+c2);
        pso.search(800, 2500, 0.40, 0.50);
//                c1 = c1+0.1;
//                c2 = c2+ 0.1;
//            }
//        }
//        IntArrayList best;
//        long d,f,s1=0,s2=0,sF=0,sB=0;
//
//        for(int i=6;i<20;i++){
//            Noeud.n=i;
//           for(int j=0;j<20;j++){
//                d=System.currentTimeMillis();
//                best=a.Recherche(new Noeud(new IntArrayList(),0),1);//19
//                f=System.currentTimeMillis();
//                s1+=f-d;
//               //System.out.println(best.toString());
//
//                d=System.currentTimeMillis();
//                best=a2.Recherche(new Noeud(new IntArrayList(),0),2);//20
//                f=System.currentTimeMillis();
//                s2+=f-d;
//                //System.out.println(best.toString());
//
//                d=System.currentTimeMillis();
//                best=bfs.Recherche(new Noeud(new IntArrayList()));// 10
//                f=System.currentTimeMillis();
//                sB+=f-d;
//               // System.out.println(best.toString());
//
//                d=System.currentTimeMillis();
//                best=dfs.Recherche(new Noeud(new IntArrayList()));//12
//                f=System.currentTimeMillis();
//                sF+=f-d;
//              // System.out.println(best.toString());
//            }
//            System.out.println(i+") :\n"+(long)(s1/20.0)+" "+a.nbrNdev+" "+a.nbrNgen);
//            System.out.println((long)(s2/20.0)+" "+a2.nbrNdev+" "+a2.nbrNgen);
//            System.out.println((long)(sF/20.0)+" "+dfs.nbrNdev+" "+ dfs.nbrNgen);
//            System.out.println((long)(sB/20.0)+" "+bfs.nbrNdev+" "+ bfs.nbrNgen);
//        }
    }
}
