package src;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class GUI extends JFrame {
    private JLabel label1;
    private JButton submitButton;
    private JPanel MainPanel;
    private JTextField endwordTXT;
    private JTextField startwordTXT;
    private JComboBox algoComboBOX;
    private JList list1;
    private JTextField langkahTXT;
    private JTextField WaktuTXT;
    private JTextField MemoryTXT;
    private JLabel langkah;
    private JTextField nodeCreatedTXT;
    private JTextField nodeExpandedTXT;
    private JTextField nodeCheckedTXT;
    private JLabel nodeCreated;
    private JLabel nodeExpanded;
    private JLabel nodeChecked;

    GUI(){
        setContentPane(MainPanel);
        setTitle("Word Ladder");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600,600);
        setLocationRelativeTo(null);
        setVisible(true);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                long startTime = 0;
                long endTime = 0;
                long before = 0;
                long after = 0;
                boolean isvalid = true;
                String startword = startwordTXT.getText();
                String endword = endwordTXT.getText();
                String algorithm = (String)algoComboBOX.getSelectedItem();
                startword = startword.trim().toLowerCase();
                if((!startword.chars().allMatch(Character::isLetter)) || startword.length() == 0 ){
                   JOptionPane.showMessageDialog(GUI.this,"wrong start word");
                   isvalid = false;
                }
                endword = endword.trim().toLowerCase();
                if((!endword.chars().allMatch(Character::isLetter)) || endword.length() == 0 || endword.length() != startword.length()){
                    JOptionPane.showMessageDialog(GUI.this,"wrong end word");
                    isvalid = false;
                }
                DictReader.fileToMap("./src/dict/" + startword.length() + ".txt");
                if(DictReader.englishDictionary == null){
                    isvalid = false;
                    JOptionPane.showMessageDialog(GUI.this, "Tidak ada file dengan jumlah kata tersebut");

                }
                List<Node> sol = new ArrayList<>();
                sol = null;
                if(isvalid){
                    if(algorithm.equals("UCS")){
                        before = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
                        startTime = System.nanoTime();
                        sol = UCS.UCSsolve(startword, endword);
                        endTime = System.nanoTime();
                        after = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
                    } else if(algorithm.equals("GBFS")){
                        before = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
                        startTime = System.nanoTime();
                        sol = GBFS.GBFSsolve(startword, endword);
                        endTime = System.nanoTime();
                        after = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
                    } else if(algorithm.equals("A*")){
                        before = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
                        startTime = System.nanoTime();
                        sol = A_Star.A_Starsolve(startword, endword);
                        endTime = System.nanoTime();
                        after = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
                    }
                }
                List<String> listSol = new ArrayList<>();
                list1.setListData(listSol.toArray());
                list1.setFont(new Font("Arial", Font.BOLD,20));
                list1.setBorder(new EmptyBorder(10,10,10,10));
                langkahTXT.setText("");
                WaktuTXT.setText("");
                MemoryTXT.setText("");
                nodeCheckedTXT.setText("");
                nodeExpandedTXT.setText("");
                nodeCreatedTXT.setText("");
                if (sol == null){
                    JOptionPane.showMessageDialog(GUI.this, "No solution");
                } else{
                    for(Node node:  sol){
                        String stringtoAdd = UtilityFunc.colorString(node.getString(), endword);
                        listSol.add(stringtoAdd);
                    }
                    list1.setListData(listSol.toArray());
                    langkahTXT.setText(Integer.toString(sol.size()-1));
                }
                long duration = (endTime - startTime);
                WaktuTXT.setText(Long.toString(duration/1000000) + "ms");
                MemoryTXT.setText((after-before)/(1024*1024) + "MB");
                nodeCheckedTXT.setText(Integer.toString(Node.nodeChecked));
                nodeExpandedTXT.setText(Integer.toString(Node.nodeExpanded));
                nodeCreatedTXT.setText(Integer.toString(Node.nodeCreated));


            }
        });
    }

    public static void main(String[] args) {
        new GUI();
    }
}
