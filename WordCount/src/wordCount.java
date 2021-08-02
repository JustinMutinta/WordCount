import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class wordCount extends JFrame {
    JLabel wordLabel;
    JPanel wordPanel;
    JButton clearButton;
    JButton countButton;
    JButton closeButton;
    JTextArea inputBox;
    int numberOfWords = 0;

    //for testing purposes
    JTextArea inputBox1;


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

        inputBox = new JTextArea();
        inputBox.setColumns(9);
        inputBox.setRows(9);
        inputBox.setLineWrap(true);
        inputBox.setText("Input Box Test. Click on clear and type text in here");

        JScrollPane wordScroll = new JScrollPane(inputBox);
        wordPanel.add(wordScroll);


        wordLabel = new JLabel();
        wordLabel.setText("Number of words: " + numberOfWords);
        wordPanel.add(wordLabel);

        add(wordPanel);

        clearButton.addActionListener(e -> {
            numberOfWords = 0;
            wordLabel.setText("Number of words: " + numberOfWords);
            inputBox.setText("");
        });

        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        countButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int counter = 0;
                if(inputBox.getText().length() > 0){
                    counter = 1;
                }

                for(int i = 0; i < inputBox.getText().length(); i++){
                    char checkValue = inputBox.getText().charAt(i);
                    if(checkValue == ' '){
                        counter++;
                    }
                }
                numberOfWords = counter;
                wordLabel.setText("Number of words: " + numberOfWords);
            }
        });



        setVisible(true);
    }

    public static void main(String[] args) {
        new wordCount();
    }
}
