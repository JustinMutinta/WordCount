import javax.swing.*;
import java.awt.*;

public class wordCount extends JFrame {
    JLabel wordLabel;
    JPanel wordPanel;
    JButton clearButton;
    JButton countButton;
    JButton closeButton;
    JTextField inputBox;
    JTextField countBox;


    public wordCount(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 300);
        setLayout(new FlowLayout());


        wordLabel = new JLabel();
        wordPanel = new JPanel();
        wordLabel.setSize(100,100);

        clearButton = new JButton("Clear");
        closeButton = new JButton("Close");
        countButton = new JButton("Count");

        wordPanel.add(clearButton);
        wordPanel.add(closeButton);
        wordPanel.add(countButton);

        inputBox = new JTextField("Words and words");
        inputBox.setSize(100,50);
        wordPanel.add(inputBox);

        countBox = new JTextField();
        countBox.setSize(200,200);
        wordPanel.add(countBox);

        add(wordPanel);



        setVisible(true);
    }

    public static void main(String[] args) {
        new wordCount();
    }
}
