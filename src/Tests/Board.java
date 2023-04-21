package Tests;
import java.awt.*;
import javax.swing.*;
public class Board {
    JFrame f;
    Board (){
        JPanel jPanel = new JPanel(new GridLayout(3, 1));
        JPanel jPanel2 = new JPanel(new GridLayout(1, 3));
        f=new JFrame();
        JButton b1=new JButton("1");
        JButton b2=new JButton("2");
        JButton b3=new JButton("3");
        JButton b4=new JButton("4");
        JButton b5=new JButton("5");
        JButton b6=new JButton("6");
        JButton b7=new JButton("7");
        JButton b8=new JButton("8");
        JButton b9=new JButton("9");
        // adding buttons to the frame
        jPanel.add(b1);
        jPanel.add(b3);
        jPanel.add(b5);
        jPanel2.add(b7);

        // setting grid layout of 3 rows and 3 columns
        f.setLayout(new GridLayout(1, 2));
        f.add(jPanel);
        f.add(jPanel2);
        f.setSize(500, 500);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
    public static void main(String[] args) {
        new Board();
    }
}
