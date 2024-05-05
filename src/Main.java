package src;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        long startTime = 0;
        long endTime = 0;
        long before = 0;
        long after = 0;
        List<String> l = UtilityFunc.readInputStartEnd();
        String startword = l.get(0);
        String endword = l.get(1);
        int wordLength = startword.length();
        // DictReader.fileToMap("./src/dict/" + wordLength + ".txt");
        DictReader.fileToMap("./src/dict/dict3.txt");
        
        while(DictReader.englishDictionary == null){
            l = UtilityFunc.readInputStartEnd();
            startword = l.get(0);
            endword = l.get(1);
            wordLength = startword.length();
            DictReader.fileToMap("./src/dict/" + wordLength + ".txt");
        }
        
        int choice = UtilityFunc.readAlgo();
        List<Node> sol = new ArrayList<>();
        switch(choice){
            case 1:
                before = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
                startTime = System.nanoTime();
                sol = UCS.UCSsolve(startword, endword);
                endTime = System.nanoTime(); 
                after = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
                break;
            case 2:
                before = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
                startTime = System.nanoTime();
                sol = GBFS.GBFSsolve(startword, endword);
                endTime = System.nanoTime(); 
                after = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
                break;
            case 3:
                before = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
                startTime = System.nanoTime();
                sol = A_Star.A_Starsolve(startword, endword);
                endTime = System.nanoTime(); 
                after = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
                break;
            default:
                System.out.println("Something gone wrong");
        }
        if(sol == null){
            System.out.println("No solution found");
        }else{
            UtilityFunc.printList(sol);
            System.out.println("Jumlah langkah solusi: " + (sol.size()-1));
        }
        System.out.println("Node created: " + Node.nodeCreated);
        System.out.println("Node expanded: " + Node.nodeExpanded);
        System.out.println("Node checked: " + Node.nodeChecked);
        long duration = (endTime - startTime); 
        System.out.println("Waktu yang dibutuhkan: " + duration/1000000 + "ms");
        System.out.println("Before: " + before/(1024*1024));
        System.out.println("After: " + after/(1024*1024));
        System.out.println("Used memory: " + (after-before)/(1024*1024) + "MB") ;
    }
}
