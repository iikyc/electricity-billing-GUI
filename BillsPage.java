import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import javax.swing.*;
import javax.swing.border.Border;

public class BillsPage extends BackEnd implements ActionListener {

    JFrame frame = new JFrame();
    // Panels
    JPanel northPanel = new JPanel();
    JPanel southPanel = new JPanel();
    JPanel eastPanel = new JPanel();
    JPanel centerPanel = new JPanel();
    // Labels
    JLabel welcomeLabel = new JLabel("Your previous bills");
    JLabel billsLabel = new JLabel("");
    JLabel highestBillLabel = new JLabel("Your highest bill: " + Collections.max(billsList).toString() + "AED");
    JLabel lowestBillLabel = new JLabel("Your lowest bill: " + Collections.min(billsList).toString()+ "AED");
    // Buttons
    JButton quitButton = new JButton("Quit");
    JButton closeButton = new JButton("Close");
    //
    String[] choices = {"Amount Due: High -> Low", "Amount Due: Low -> High"};
    JComboBox sortingChoice = new JComboBox(choices);

    BillsPage(String userID) {

        Color customColor = new Color(44,100,51); // Custom color used to style welcomeLabel

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(new BorderLayout(10,10));
        frame.setVisible(true);

        welcomeLabel.setFont(new Font(null, Font.BOLD, 30));
        welcomeLabel.setForeground(customColor);

        billsLabel.setText(String.valueOf(billsHashMap.get(userID)).replace("[", "<html>").replace("]", "AED</html>").replace(",", "AED<br />"));
        billsLabel.setFont(new Font(null, Font.BOLD, 15));

        sortingChoice.addActionListener(this);

        quitButton.setSize(150, 100);
        quitButton.addActionListener(this);
        closeButton.setSize(150, 100);
        closeButton.addActionListener(this);

        northPanel.setBackground(Color.darkGray);
        southPanel.setBackground(Color.darkGray);
        eastPanel.setBackground(Color.white);
        centerPanel.setBackground(Color.lightGray);

        frame.setLayout(new BorderLayout());
        frame.setPreferredSize(new Dimension(720, 550));
        frame.setMinimumSize(new Dimension(720, 550));
        frame.setMaximumSize(new Dimension(720, 550));

        northPanel.setPreferredSize(new Dimension(100,50));
        southPanel.setPreferredSize(new Dimension(150,50));
        eastPanel.setPreferredSize(new Dimension(270,100));
        centerPanel.setPreferredSize(new Dimension(450,100));

        northPanel.add(welcomeLabel);
        southPanel.add(quitButton);
        southPanel.add(closeButton);
        eastPanel.add(sortingChoice);
        eastPanel.add(lowestBillLabel);
        eastPanel.add(highestBillLabel);
        centerPanel.add(billsLabel);
        frame.add(northPanel, BorderLayout.NORTH);
        frame.add(southPanel, BorderLayout.SOUTH);
        frame.add(eastPanel, BorderLayout.EAST);
        frame.add(centerPanel, BorderLayout.CENTER);
        frame.pack();

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

        if (e.getSource()==quitButton) {

            System.exit(0);

        }

        if (e.getSource()==closeButton) {

            frame.dispose();

        }
    }
}