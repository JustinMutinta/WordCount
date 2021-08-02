import javax.swing.*;
import java.awt.*;
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

        wordPanel.setLayout(null);                  //Set Layout of Panel to 'null'. I'll be customizing the layout so this will allow that
        wordPanel.setSize(300, 300);    //Set size of Panel to what the frame is.

        clearButton = new JButton("Clear");     //create clear button to clear text and reset counter.
        closeButton = new JButton("Close");     //close button to close the GUI.
        countButton = new JButton("Count");     //count button to Calculate words in box.

        wordPanel.add(clearButton);                 //add buttons to the Panel
        wordPanel.add(countButton);
        wordPanel.add(closeButton);

        inputBox = new JTextArea();                 //initialize Text Area
        inputBox.setLineWrap(true); //Wrap Text so that when the text exceeds the box size, the box does not get bigger but the text goes to a new line
        inputBox.setText("Input Box Test. Click on 'Clear' and type text in here"); //Set text for box

        JScrollPane wordScroll = new JScrollPane(inputBox); //To allow inputBox to scroll, a JScrollPane has to be created. Notice that inputBox is put into the JScrollPane
        wordPanel.add(wordScroll); //Once created, the TextArea has to be added to the JScrollPane and then the JScrollPane added to the Panel.


        wordLabel = new JLabel();                               //Initialize the Label
        wordLabel.setText("Number of words: " + numberOfWords); //Set the words that will go into it
        wordPanel.add(wordLabel);                               //Add to the panel

        Insets insets = getInsets();            //This will be used for the placement of objects in the panel
        Dimension size;                         //This will be for the custom size of objects in the panel

        /*
        This comment block is for the following blocks of code.
        size is set to the specific object we're about to work on. For example, buttons, JTextArea, and the Label
        Then we set Bounds for each object: x axis, y axis, how wide, how tall (insets.left and insets.top for x and y and size.width and size.height)
        If this is not done, the object will not show up in the panel. Since the layout is null, we have to be specific on placement
         */
        size = clearButton.getPreferredSize();
        clearButton.setBounds(5 + insets.left, 200 + insets.top, size.width + 10, size.height);

        size = closeButton.getPreferredSize();
        closeButton.setBounds(200 + insets.left, 200 + insets.top, size.width + 10, size.height);

        size = countButton.getPreferredSize();
        countButton.setBounds(100 + insets.left, 200 + insets.top, size.width + 10, size.height);

        size = wordScroll.getPreferredSize();
        wordScroll.setBounds(10 + insets.left, 10 + insets.top, size.width + 150, size.height + 100);

        size = wordLabel.getPreferredSize();
        wordLabel.setBounds(10 + insets.left, 170 + insets.top, size.width + 150, size.height);


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
                    if(checkValue == ' ' || checkValue == '\n'){ //is the char a ' ' or a newline, then add a 1 to the local counter variable
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
