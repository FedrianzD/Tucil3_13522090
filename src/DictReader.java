package src;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
// import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
// import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
public class DictReader {
    public static Map<String,Boolean> englishDictionary;
    public static Map<Integer, List<String>> findLengthWord(){
        Map<Integer, List<String>> mp= new HashMap<>();
        File file = new File("./src/dict/dict2.txt");
        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            String st;
            while ((st = br.readLine()) != null){
                List<String> exist = mp.putIfAbsent(st.length(), new ArrayList<>(Arrays.asList(st)));
                if(exist != null){
                    exist.add(st);
                }
            }
        } catch(IOException e){
            System.out.println(e.getMessage());
        }
        return mp;
    }
    public static void divideDict(){
        Map<Integer, List<String>> varLength = findLengthWord();
        for (Integer i : varLength.keySet()){
            File file = new File("./src/dict/" + Integer.toString(i) + ".txt");
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))){
                for(String word : varLength.get(i)){
                    if(word.equals(varLength.get(i).get(varLength.get(i).size()-1))){
                        // System.out.println(word + " " + varLength.get(i).get(varLength.get(i).size()-1));
                        bw.write(word);
                    }else{
                        bw.write(word + '\n');
                    }
                }
            } catch(IOException e){
                System.out.println(e.getMessage());
            }
        }


    }
    public static Map<String,Boolean> fileToMap(String filepath){
        Map<String,Boolean> dict = new HashMap<>();
        File file = new File(filepath);
        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            String st;
            while ((st = br.readLine()) != null){
                dict.put(st, true);
            }
        } catch(IOException e){
            System.out.println(e.getMessage());
            dict = null;
        }
        englishDictionary = dict;
        return dict;
    }  
}
// public static void main(String[] args){
//     // Map<String, Boolean> dict2 = fileToMap("./src/dict/2.txt");
//     Map<String, Boolean> dict3 = fileToMap("./src/dict/dict3.txt");
//     long startTime = System.nanoTime();
//     // Map<Word, List<Word>> dict = fileToMap2();
//     // dict2.forEach((k,v) -> System.out.println(k));
//     // System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
//     // dict3.forEach((k,v) -> System.out.println(k));
    
//     // divideDict();
//     // Node node = new Node("aa", 0, null);
//     // Node a = new Node("a",0,0, null);
//     // Node b = new Node("b",1,3, a);
//     // Node c = new Node("c",1,1, b);
//     // Node d = new Node("d",1,1, c);
//     // PriorityQueue<Node> pq = new PriorityQueue<>(new NodeComparator());
    
//     List<Node> l = A_Star.A_Starsolve("number", "figure");
//     // List<Node> l = UCS.UCSsolve("number", "figure");
//     // // List<Node> l = new ArrayList<>();
//     // System.out.println(l.size());
//     // pq.offer(a);
//     // pq.offer(b);
//     // pq.offer(c);
//     // pq.offer(d);
//     // // d.pathToRoot().forEach(z -> System.out.println(z.getString()));
//     l.forEach(n -> System.out.println(n.getString() + " " + n.getFn() ));
//     // System.out.println(pq.poll().getString());
//     // System.out.println(pq.poll().getString());
//     // System.out.println(pq.poll().getString());
//     // System.out.println(pq.poll().getString());
//     long endTime = System.nanoTime();
//     long duration = (endTime - startTime); 
//     System.out.println(duration/1000000);
// }