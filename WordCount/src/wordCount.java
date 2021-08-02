import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class wordCount extends JFrame {  //Extending JFrame allows me to jump into GUI creation without creating Frame
    JLabel wordLabel;       //Label will be where the word count will be displayed
    JPanel wordPanel;       //Panel where all objects will be added. Panel will be added to Frame
    JButton clearButton;    //Button to clear all boxes and reset counter to 0
    JButton countButton;    //Button to calculate how many word are present
    JButton closeButton;    //Button to close the app. Different option from clicking the X button
    JTextArea inputBox;     //Where the user can input data
    int numberOfWords = 0;  //counter for word count.


    public wordCount(){                             //function for GUI
        setDefaultCloseOperation(EXIT_ON_CLOSE);    //close the windows when the X is clicked
        setSize(300, 300);              //set size of the window


        wordLabel = new JLabel();                   //initialize the Label. This is for the word count.
        wordPanel = new JPanel();                   //initialize the Panel. Objects will be added to it.

        clearButton = new JButton("Clear");     //create clear button to clear text and reset counter.
        closeButton = new JButton("Close");     //close button to close the GUI.
        countButton = new JButton("Count");     //count button to Calculate words in box.

        wordPanel.add(clearButton);                 //add buttons to the Panel
        wordPanel.add(countButton);
        wordPanel.add(closeButton);

        inputBox = new JTextArea();                 //initialize Text Area
        inputBox.setColumns(9);                     //set columns. Left to Right
        inputBox.setRows(9);                        //set rows. Up to down
        inputBox.setLineWrap(true); //Wrap Text so that when the text exceeds the box size, the box does not get bigger but the text goes to a new line
        inputBox.setText("Input Box Test. Click on 'Clear' and type text in here"); //Set text for box

        JScrollPane wordScroll = new JScrollPane(inputBox); //To allow inputBox to scroll, a JScrollPane has to be created. Notice that inputBox is put into the JScrollPane
        wordPanel.add(wordScroll); //Once created, the TextArea has to be added to the JScrollPane and then the JScrollPane added to the Panel.


        wordLabel = new JLabel();                               //Initialize the Label
        wordLabel.setText("Number of words: " + numberOfWords); //Set the words that will go into it
        wordPanel.add(wordLabel);                               //Add to the panel

        add(wordPanel);     //Add the Panel to the Frame

        clearButton.addActionListener(e -> {        //Lambda way of having action listener. for when button is clicked
            numberOfWords = 0;                              //resets global value to 0
            wordLabel.setText("Number of words: " + numberOfWords); //resets Label value
            inputBox.setText("");                   //clears inputBox
        });

        closeButton.addActionListener(new ActionListener() {    //Second method of action listener
            public void actionPerformed(ActionEvent e) {        //function for action
                System.exit(0);                         //closes out the window
            }
        });

        countButton.addActionListener(new ActionListener() {    //Second method of action listener
            @Override                               //Override was added by IntelliJ. Will work without it
            public void actionPerformed(ActionEvent e) {    //Function for action listener.
                int counter = 0;                    //local counter value
                if(inputBox.getText().length() > 0){   //if inputBox has more than 1 char, local value becomes 1
                    counter = 1;
                }

                for(int i = 0; i < inputBox.getText().length(); i++){ //for loop to check all values in the inputBox
                    char checkValue = inputBox.getText().charAt(i); //creates a char variable for that one instance in the loop
                    if(checkValue == ' '){ //is the char a ' ', then add a 1 to the local counter variable
                        counter++;
                    }
                }
                numberOfWords = counter;     //once complete, the global variable is updated.
                wordLabel.setText("Number of words: " + numberOfWords); //Label is now updated as well
            }
        });



        setVisible(true); // set GUI to be visible
    }

    public static void main(String[] args) {
        new wordCount();  //run it
    }
}
