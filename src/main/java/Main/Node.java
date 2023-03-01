package Main;

import java.util.*;

public class Node <T>{
    private  T valeur;
    private Set<Node<T>> voisins = new HashSet<>();

    public Node (T valeur){
        this.valeur = valeur;
        this.voisins = new HashSet<>();
    }
    public void connect(Node<T> n){
        if (this == n) throw new IllegalArgumentException("Can't connect node to itself");
        this.voisins.add(n);
        n.voisins.add(this);
    }
    public static <T>Optional<Node<T>> BFS(T val, Node<T> deb){
        Queue<Node<T>> file = new ArrayDeque<>();
         file.add(deb);
         Node<T> curr;
         Queue<Node<T>> visite = new ArrayDeque<>();
         while (!file.isEmpty()){
             curr = file.remove();
             if (curr.getValeur().equals(val)){
                 return Optional.of(curr);
             }else {
                 visite.add(curr);
                 file.addAll(curr.getVoisins());
                 file.removeAll(visite);
             }
         }
         return Optional.empty();
    }

    public T getValeur() {
        return valeur;
    }

    public Set<Node<T>> getVoisins() {
        return voisins;
    }
}
