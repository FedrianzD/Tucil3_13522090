package src;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
class UtilityFunc{
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static int getDifference(String w1, String w2){
        int diff = 0;
        for(int i = 0; i < w1.length(); i++){
            if(w1.charAt(i) != w2.charAt(i)){
                diff++;
            }
        }
        return diff;
    }
    public static void printString(String s1, String s2){
        for(int i = 0; i < s1.length(); i++){
            if(s1.charAt(i) == s2.charAt(i)){
                System.out.print(ANSI_GREEN + s1.charAt(i) + ANSI_RESET);
            }else{
                System.out.print(s1.charAt(i));
            }
        }
        System.out.println();
    }
    public static void printList(List<Node> l){
        String endword = l.get(l.size()-1).getString();
        l.forEach(s -> printString(s.getString(), endword));
    }
    public static List<String> readInputStartEnd(){
        String startword;
        String endword;
        try{
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter start word: ");
            startword = bufferedReader.readLine().trim().toLowerCase(); 
            while((!startword.chars().allMatch(Character::isLetter)) || startword.length() == 0 ){
                System.out.print("Enter start word: ");
                startword = bufferedReader.readLine().trim().toLowerCase();
            }
            System.out.print("Enter end word: ");
            endword = bufferedReader.readLine().trim().toLowerCase();
            while((!endword.chars().allMatch(Character::isLetter)) || endword.length() == 0 || endword.length() != startword.length()){
                System.out.print("Enter end word: ");
                endword = bufferedReader.readLine().trim().toLowerCase();
            }
            List<String> l = new ArrayList<>();
            l.add(startword);
            l.add(endword);
            return l;
        }
        catch (Exception e) {
            System.out.println("Terjadi kesalahan");
            System.out.println(e.getMessage());
            return null;
        }
    }
    public static int readAlgo(){
        try{
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Masukkan algoritma yang diinginkan: ");
            System.out.println("1. Uniform Cost Search Algorithm");
            System.out.println("2. Greedy Best First Search Algorithm");
            System.out.println("3. A* Algorithm\n");
            System.out.print("Masukkan pilihan algoritma: ");
            int choice = 0;
            try{
                choice = Integer.parseInt(bufferedReader.readLine().trim());
            }catch(Exception e){
                System.out.println("\nInput harus berupa angka");
            }
            while(choice < 1 || choice > 3){
                System.out.println("\nPilihan salah");
                System.out.print("Masukkan pilihan algoritma: ");
                try{
                    choice = Integer.parseInt(bufferedReader.readLine().trim());
                }catch(Exception e){
                    System.out.println("\nInput harus berupa angka");
                }
            }
            return choice;
        }catch (Exception e) {
            System.out.println("Terjadi kesalahan");
            System.out.println(e.getMessage());
            return 0;
        }
        
    }
}
