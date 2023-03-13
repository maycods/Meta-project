package Main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class Astar {

        private ArrayList<Node> ouvert = new ArrayList<>();
        public int h(Node n,int hi){
            if(hi==1){

            }else {
                if(hi==2){

                }
            }
            return 0;
        }
        public int g(Node n ){

            return n.getProfondeur();
        }

        public Node Recherche(Node G,int hi){
            Node d = G,n;
            d.setF(g(d)+h(d,hi));
            ouvert.add(d);

            while (!ouvert.isEmpty()){

                n= ouvert.remove(0);
                if(n.verification()){System.out.println(n.evaluation()); return n;}
                if (n.successeurs()) {
                    for (Node enfant : n.getNoeudEnfants()) {
                        enfant.setF(g(enfant)+h(enfant,hi));
                        ouvert.add(enfant);
                        ouvert.sort(new Comparator<Node>() {
                            @Override
                            public int compare(Node o1, Node o2) {
                                return (o1.getF() < o2.getF())? 1 : -1;
                            }
                        });
                    }
                }
            }
            return null;
        }

}
