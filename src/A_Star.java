package src;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class A_Star {
    public static List<Node> A_Starsolve(String start, String end){
        Node.resetNode();
        Map<String, Boolean> visited = new HashMap<>();
        
        // panjang tidak sama
        if(start.length() != end.length()){
            return null;
        }

        // end word tidak ada di dictionary
        if(!DictReader.englishDictionary.containsKey(end)){
            return null;
        }

        // Buat prioQueue 
        PriorityQueue<Node> pq = new PriorityQueue<>(new NodeComparator());
        pq.add(new Node(start,0, 0, null));

        while(!pq.isEmpty()){
            Node currNode = pq.poll();
            Node.nodeChecked++;
            List<String> possibleString;
            Node.nodeExpanded++;
            if(currNode.getString().equals(end)){
                return currNode.pathToRoot();
            }
            possibleString = currNode.getExpandNode(DictReader.englishDictionary);
            visited.put(currNode.getString(), true);
            for(String s : possibleString){
                if(!visited.containsKey(s)){
                    Node newNode = new Node(s, 1, UtilityFunc.getDifference(s, end), currNode);
                    pq.add(newNode);
                }
            }
        }
        return null;
    }
}
