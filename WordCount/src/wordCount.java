import javax.swing.*;

public class wordCount extends JFrame {
    JLabel wordLabel;
    JPanel wordPanel;
    JButton clearButton;
    JButton countButton;
    JButton closeButton;
    JTextField inputBox;
    JTextField countBox;
    int numberOfWords = 0;


    public wordCount(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 300);


        wordLabel = new JLabel();
        wordPanel = new JPanel();
        wordLabel.setSize(100,100);

        clearButton = new JButton("Clear");
        closeButton = new JButton("Close");
        countButton = new JButton("Count");

        wordPanel.add(clearButton);
        wordPanel.add(countButton);
        wordPanel.add(closeButton);

        inputBox = new JTextField(20);
        inputBox.setText("Input Box Test");
        wordPanel.add(inputBox);

        //commenting out the below one because the number of words can be displayed in the label itself
        /*
        countBox = new JTextField("CountBox",10);
        wordPanel.add(countBox);
         */

        wordLabel = new JLabel();
        wordLabel.setText("Number of words: " + numberOfWords);
        wordPanel.add(wordLabel);

        add(wordPanel);



        setVisible(true);
    }

    public static void main(String[] args) {
        new wordCount();
    }
}
