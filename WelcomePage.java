import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.*;
import javax.swing.text.View;

public class WelcomePage extends IDandPasswords implements ActionListener {

    JFrame frame = new JFrame("Electricity Billing System");
    JLabel welcomeLabel = new JLabel("Main Menu");
    JButton viewTarrifButton = new JButton("View Tariffs");
    JButton viewBillsButton = new JButton("View Bills");
    JButton calculateBillButton = new JButton("Calculate Bill");
    JButton resetButton = new JButton("Reset");
    JButton quitButton = new JButton("Quit");
    JLabel consumptionSelectionLabel = new JLabel("Select the type of consumption");
    JLabel unitsConsumedLabel = new JLabel("Enter the units consumed, kWh/month");
    JLabel amountDueLabel = new JLabel("");
    JLabel billsListLabel = new JLabel("");
    JTextField unitsConsumedField = new JTextField();
    String[] choices = { "Residential/Commercial","Industrial"};
    final JComboBox<String> choicesDropdown = new JComboBox<>(choices);

    WelcomePage(String userID) {

        Color customColor = new Color(44,100,51);

        frame.getContentPane().setBackground(Color.lightGray);

        String UserID = userID;
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

        unitsConsumedLabel.setBounds(250, 175, 250, 25);
        unitsConsumedLabel.setFocusable(false);

        unitsConsumedField.setBounds(260, 200, 200, 25);
        unitsConsumedField.addActionListener(this);

        consumptionSelectionLabel.setBounds(260, 220, 200, 25);
        consumptionSelectionLabel.setFocusable(false);

        choicesDropdown.setBounds(260, 250, 220, 25);
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
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(720, 550));
        frame.setMinimumSize(new Dimension(720, 550));
        frame.setMaximumSize(new Dimension(720, 550));
        frame.setLayout(null);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==viewTarrifButton) {

            TariffsPage tariffsPage = new TariffsPage();

        }

        if (e.getSource()==viewBillsButton) {

            billsListLabel.setText(String.valueOf(billsHashMap.get(userID)).replace("[", "").replace("]", ""));

        }

        if (e.getSource()==calculateBillButton) {

            String consumeType = (String)choicesDropdown.getSelectedItem();
            Double unitsConsumed = Double.parseDouble(unitsConsumedField.getText());
            Double amountDue;

            // Start bill calc

            if (consumeType.equals("Residential/Commercial")) { // COMMENT


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

                billsList.add(amountDue); // Adding the amount due to the bills list
                billsHashMap.put(userID, billsList); // Adding the bills list to the corresponding hashmap
                amountDueLabel.setText("Amount due: " + String.valueOf(amountDue) + "AED");

            } // End if for consumeType

            else if (consumeType.equals("Industrial")) { // Comment


                if (unitsConsumed >= 0 && unitsConsumed <= 10000) {
                    amountDue = unitsConsumed * 0.23;
                }
                else {

                    amountDue = unitsConsumed * 0.38;

                }

                billsList.add(amountDue); // Adding the amount due to the bills list
                billsHashMap.put(userID, billsList); // Adding the bills list to the corresponding hashmap
                amountDueLabel.setText("Amount due: " + String.valueOf(amountDue) + "AED");

            }

            // End bill calc

        }

        if (e.getSource()==resetButton) {

            unitsConsumedField.setText("");
            choicesDropdown.setSelectedItem("Residential/Commercial");
            amountDueLabel.setText("");
        }

        if (e.getSource()==quitButton) {

            System.exit(0);

        }

    }
}
