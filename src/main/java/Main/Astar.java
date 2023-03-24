package Main;
import java.util.Comparator;
import java.util.PriorityQueue;


public class Astar {

    public  int nbrNdev=0,nbrNgen =1;
    int sizeInitial;
    private PriorityQueue<Node> ouvert = new PriorityQueue<Node>(new Comparator<Node>() {
        @Override
        public int compare(Node o1, Node o2) {
            return (o1.getF() > o2.getF())? 1 : -1;
        }
    });


    public int h(Node n,int hi){
        int m=n.getEtat().length-1;
        if(m==-1 ) return 1000;
        if(m==0) return  -Math.abs( n.getEtat()[m] -Node.n/2);
        for (int j = m -1; j >= 0; j--) {
            if ( m-j == Math.abs(n.getEtat()[m] - n.getEtat()[j])) return 100;
        }
        int p=n.getEtat()[n.getEtat().length-1];
            if(hi==1){

                return -Math.abs(m*(p) - (Node.n*Node.n)/4);

            }else{

                return Math.min(p,m)+(Node.n - p - 1)+ (Node.n - m - 1) + Math.min((Node.n - p - 1), (Node.n - m - 1))+ 1  ;

            }
        }
        public int g(Node n ){

            return n.getProfondeur();
        }

        public int[] Recherche(Node G,int hi){
            Node d = G,n;
            d.setF(g(d)+h(d,hi));
            ouvert.add(d);
            while (!ouvert.isEmpty()){

                n= ouvert.remove();
                nbrNdev++;

                if(n.verification() ){return n.getEtat();}
                if (n.successeurs()) {
                    sizeInitial =ouvert.size();
                    for (Node enfant : n.getNoeudEnfants()) {
                        enfant.setF(g(enfant)+h(enfant,hi));
                        ouvert.add(enfant);

                    }
                    nbrNgen+=(ouvert.size() - sizeInitial);
                }
            }
            return null;
        }
}
