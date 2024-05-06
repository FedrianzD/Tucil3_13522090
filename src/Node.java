package src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

class Node{
    private String w;
    private int fn;
    private int gn;
    private int hn;
    public Node pred;
    public static int nodeCreated = 0;
    public static int nodeVisited = 0;
    Node(String s, int cost, int hn, Node pred){
        this.w = s;
        this.pred = pred;
        this.hn = hn;
        // root node
        if(pred == null){
            this.gn = 0;
            this.fn = 0;
        }else{ // child node
            this.gn = this.pred.gn + cost;
            this.fn = this.gn + this.hn;
        }
        nodeCreated++;
    }
    public static void resetNode(){
        nodeCreated = 0;
        nodeVisited = 0;
    }
    public String getString(){
        return w;
    }
    public List<Node> pathToRoot(){
        List<Node> l = new ArrayList<>();
        Node currNode = this; 
        while(currNode != null){
            l.add(currNode);
            currNode = currNode.pred;
        }
        Collections.reverse(l);
        return l;
    }
    public int getFn(){
        return fn;
    }
    public List<String> getExpandNode(Map<String, Boolean> m){
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        List<String> l = new ArrayList<>();
        for(int i = 0; i < w.length(); i++){
            for(int j = 0; j < alphabet.length(); j++){
                if(w.charAt(i) == alphabet.charAt(j)){
                    continue;
                }
                StringBuilder wtmp = new StringBuilder(w);
                wtmp.setCharAt(i, alphabet.charAt(j));
                String newWord = wtmp.toString();
                // jika ada di dalam kamus, tambahkan ke dalam list
                if(m.containsKey(newWord)){
                    l.add(newWord);
                }   
            }
        }
        return l;
    }
}

class NodeComparator implements Comparator<Node>{
    public int compare(Node n1, Node n2) {
        if (n1.getFn() < n2.getFn()){
            return -1;
        } else if (n1.getFn() > n2.getFn()){
            return 1;
        } else{
            return 0;
        }
    }
}