// Put all the components
// in a GridLayout, welcomeLabel TOP, billsList CENTER, sortingChoice LEFT, highest
// and lowest bill RIGHT
// Quit and close buttons BOTTOM
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class BillsPage extends IDandPasswords implements ActionListener {

    // Frame
    JFrame frame = new JFrame("Electricity Billing System");
    // Labels
    JLabel welcomeLabel = new JLabel("Your previous bills");
    JLabel billsLabel = new JLabel("");
    JLabel highestBillLabel = new JLabel("Your highest bill: " + Collections.min(billsList).toString() + "AED");
    JLabel lowestBillLabel = new JLabel("Your lowest bill: " + Collections.max(billsList).toString()+ "AED");
    //
    String[] choices = {"Amount Due: High -> Low", "Amount Due: Low -> High"};
    JComboBox sortingChoice = new JComboBox(choices);

    BillsPage(String userID) {

        Color customColor = new Color(44,100,51); // Custom color used to style welcomeLabel
        // Setting the background color for the frame
        frame.getContentPane().setBackground(Color.lightGray);

        // Setting location and dimensions of components
        welcomeLabel.setBounds(220, 0, 350, 35);
        welcomeLabel.setFont(new Font(null, Font.BOLD, 30));
        welcomeLabel.setForeground(customColor);

        sortingChoice.setBounds(240, 50, 300, 45);
        sortingChoice.addActionListener(this);

        billsLabel.setText(String.valueOf(billsHashMap.get(userID)).replace("[", "<html>").replace("]", "AED</html>").replace(",", "AED<br />"));
        billsLabel.setBounds(50, 100, 200, 500);
        billsLabel.setFont(new Font(null, Font.BOLD, 15));

        highestBillLabel.setBounds(300, 150, 200, 15);
        lowestBillLabel.setBounds(300, 170, 200, 15);

        frame.add(welcomeLabel);
        frame.add(billsLabel);
        frame.add(sortingChoice);
        frame.add(highestBillLabel);
        frame.add(lowestBillLabel);

        // Exiting the program when the frame is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Setting frame size (constricted to 720x550 in order to not need a layout to keep the project simple)
        frame.setPreferredSize(new Dimension(720, 550));
        frame.setMinimumSize(new Dimension(720, 550));
        frame.setMaximumSize(new Dimension(720, 550));
        // Frame does not use any layout, all components' x,y location was hard coded
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==sortingChoice) {

            sortingChoice.getSelectedItem();

            if(sortingChoice.getSelectedItem().equals("Amount Due: High -> Low")) {

                Collections.sort(billsList, Collections.reverseOrder());

                billsLabel.setText(String.valueOf(billsList).replace("[", "<html>").replace("[", "<html>").replace("]", "AED</html>").replace(",", "AED<br />"));

                highestBillLabel.setText("Your highest bill: " + Collections.max(billsList).toString() + "AED");
                lowestBillLabel.setText("Your lowest bill: " + Collections.min(billsList).toString() + "AED");
            }

            else if(sortingChoice.getSelectedItem().equals("Amount Due: Low -> High")) {

                Collections.sort(billsList);

                billsLabel.setText(String.valueOf(billsList).replace("[", "<html>").replace("]", "AED</html>").replace(",", "AED<br />"));

                highestBillLabel.setText("Your highest bill: " + Collections.max(billsList).toString() + "AED");
                lowestBillLabel.setText("Your lowest bill: " + Collections.min(billsList).toString() + "AED");
            }

        }
    }
}
