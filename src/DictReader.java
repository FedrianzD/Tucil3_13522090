package src;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
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
        Map<Integer, List<String>> mp = new HashMap<>();
        String filename;
        try{
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Put dict.txt in src/sourceDict/");
            System.out.print("Enter filename: ");
            filename = bufferedReader.readLine();
            File file = new File("./src/sourceDict/" + filename);
            while(!(file.exists() && !file.isDirectory())) { 
                System.out.println("\nFile did not exist or not a file");
                System.out.print("Enter filename: ");
                filename = bufferedReader.readLine();
                file = new File("./src/sourceDict/" + filename);
            }
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
        }catch(Exception e){

        }
        return mp;
    }
    public static void divideDict(){
        cleanDir();
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
    public static void cleanDir(){
        File dir = new File("./src/dict"); 
        for(File file: dir.listFiles()) 
        if (!file.isDirectory()){
            file.delete();
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
    public static void main(String[] args){
        divideDict();
    }
}