import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.*;
import javax.swing.text.View;

public class WelcomePage extends BackEnd implements ActionListener {

    // Frame
    JFrame frame = new JFrame("Electricity Billing System");
    // Labels
    JLabel welcomeLabel = new JLabel("Main Menu");
    JLabel consumptionSelectionLabel = new JLabel("Select the type of consumption");
    JLabel unitsConsumedLabel = new JLabel("Enter the units consumed, kWh/month");
    JLabel amountDueLabel = new JLabel("");
    JLabel billsListLabel = new JLabel("");
    // Buttons
    JButton viewTarrifButton = new JButton("View Tariffs");
    JButton viewBillsButton = new JButton("View Bills");
    JButton calculateBillButton = new JButton("Calculate Bill");
    JButton resetButton = new JButton("Reset");
    JButton quitButton = new JButton("Quit");
    // Fields
    JTextField unitsConsumedField = new JTextField();
    // Choices to be displayed in the JComboBox choicesDropdown
    String[] choices = { "Residential/Commercial","Industrial"};
    // JComboBox (drop down menu) with choices passed in to be displayed
    final JComboBox<String> choicesDropdown = new JComboBox<>(choices);

    WelcomePage(String userID) {

        Color customColor = new Color(44,100,51); // Custom color used to style welcomeLabel
        // Setting the background color for the frame
        frame.getContentPane().setBackground(Color.lightGray);

        String UserID = userID;
        // Setting location and dimensions of components
        welcomeLabel.setBounds(250, 0, 250, 35);
        welcomeLabel.setFont(new Font(null, Font.BOLD, 30));
        welcomeLabel.setText("Welcome, " + userID);
        welcomeLabel.setForeground(customColor);

        viewTarrifButton.setBounds(260, 50, 200, 25);
        viewTarrifButton.setFocusable(false);
        viewTarrifButton.addActionListener(this);

        viewBillsButton.setBounds(260, 100, 200, 25);
        viewBillsButton.setFocusable(false);
        viewBillsButton.addActionListener(this);

        billsListLabel.setBounds(250, 150, 200, 25);
        billsListLabel.setFocusable(false);

        unitsConsumedLabel.setBounds(240, 175, 250, 25);
        unitsConsumedLabel.setFocusable(false);

        unitsConsumedField.setBounds(260, 200, 200, 25);
        unitsConsumedField.addActionListener(this);

        consumptionSelectionLabel.setBounds(260, 220, 200, 25);
        consumptionSelectionLabel.setFocusable(false);

        choicesDropdown.setBounds(250, 250, 220, 25);
        choicesDropdown.setFocusable(false);
        choicesDropdown.addActionListener(this);

        calculateBillButton.setBounds(260, 280, 200, 25);
        calculateBillButton.setFocusable(false);
        calculateBillButton.addActionListener(this);

        amountDueLabel.setBounds(280, 310, 200, 25);
        amountDueLabel.setFocusable(false);

        resetButton.setBounds(260, 360, 200, 25);
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);

        quitButton.setBounds(260, 400, 200, 25);
        quitButton.setFocusable(false);
        quitButton.addActionListener(this);

        // Exiting the program when the frame is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Adding components to the frame
        frame.add(welcomeLabel);
        frame.add(viewTarrifButton);
        frame.add(viewBillsButton);
        frame.add(billsListLabel);
        frame.add(calculateBillButton);
        frame.add(unitsConsumedField);
        frame.add(unitsConsumedLabel);
        frame.add(consumptionSelectionLabel);
        frame.add(choicesDropdown);
        frame.add(amountDueLabel);
        frame.add(resetButton);
        frame.add(quitButton);
        // Setting frame size (constricted to 720x550 in order to not need a layout to keep the project simple)
        frame.setPreferredSize(new Dimension(720, 550));
        frame.setMinimumSize(new Dimension(720, 550));
        frame.setMaximumSize(new Dimension(720, 550));
        frame.setLocation(350, 100);
        // Frame does not use any layout, all components' x,y location was hard coded
        frame.setLayout(null);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // View tariff button event handling
        if (e.getSource()==viewTarrifButton) {
            // User is redirected to the tariffs page
            TariffsPage tariffsPage = new TariffsPage();

        }
        // View bills button event handling
        if (e.getSource()==viewBillsButton) {
            // Displaying past bills (the value of the userID key (billsList) in billsHashMap)
            BillsPage billsPage = new BillsPage(userID);
        }
        // Calculate bill button event handling
        if (e.getSource()==calculateBillButton) {

            String consumeType = (String)choicesDropdown.getSelectedItem();
            Double unitsConsumed = Double.parseDouble(unitsConsumedField.getText());
            Double amountDue;

            // Start bill calculation

            if (consumeType.equals("Residential/Commercial")) { // Calculation according to residential/commercial tariffs


                if (unitsConsumed >= 0 && unitsConsumed <= 2000) {

                    amountDue = unitsConsumed * 0.23;

                }
                else if (unitsConsumed >= 2001 && unitsConsumed <= 4000) {

                    amountDue = unitsConsumed * 0.28;

                }
                else if (unitsConsumed >= 40001 && unitsConsumed <= 6000) {

                    amountDue = unitsConsumed * 0.32;

                }
                else {

                    amountDue = unitsConsumed * 0.38;

                }

                double finalAmountDue = (double) Math.round(amountDue * 100.0/100.0);

                billsList.add(finalAmountDue); // Adding the amount due to the bills list
                billsHashMap.put(userID, billsList); // Adding the bills list to the corresponding hashmap
                amountDueLabel.setText("Amount due: " + String.valueOf(finalAmountDue) + "AED");

            } // End of if statement

            else if (consumeType.equals("Industrial")) { // Calculation according to industrial tariffs


                if (unitsConsumed >= 0 && unitsConsumed <= 10000) {
                    amountDue = unitsConsumed * 0.23;
                }
                else {

                    amountDue = unitsConsumed * 0.38;

                }

                double finalAmountDue = (double) Math.round(amountDue * 100.0/100.0);

                billsList.add(finalAmountDue); // Adding the amount due to the bills list
                billsHashMap.put(userID, billsList); // Adding the bills list to the corresponding hashmap
                amountDueLabel.setText("Amount due: " + String.valueOf(finalAmountDue) + "AED");

            } // End of else if statement

            // End bill calculation

        }
        // Reset button event handling
        if (e.getSource()==resetButton) {
            // Any text in the unitsConsumedField is deleted by setting the text to null ("")
            unitsConsumedField.setText("");
            // Resetting the default displayed item in choicesDropdown
            choicesDropdown.setSelectedItem("Residential/Commercial");
            // Any text in the amountDueLabel is deleted by setting the text to null ("")
            amountDueLabel.setText("");
        }
        // Quit button event handling
        if (e.getSource()==quitButton) {
            // Exiting the program
            System.exit(0);

        }

    }
}