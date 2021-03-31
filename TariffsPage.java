import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.*;

public class TariffsPage implements ActionListener {

    // Frame
    JFrame frame = new JFrame("Tariff Slabs");
    // Labels
    JLabel residentialTariffsLabel = new JLabel("Residential and Commercial Tariffs\n");
    JLabel industrialTariffsLabel = new JLabel("Industrial Tariffs\n");
    JLabel tariffOne = new JLabel("0-2000 kWh/Month: 23 fils/kWh\n");
    JLabel tariffTwo = new JLabel("2001-4000 kWh/Month: 28 fils/kWh\n");
    JLabel tariffThree = new JLabel("4001-6000 kWh/Month: 32 fils/kWh\n");
    JLabel tariffFour = new JLabel("6001 and Above: 38 fils/kWh\n");
    JLabel tariffFive= new JLabel("0-10000 kWh/Month: 23 fils/kWh\n");
    JLabel tariffSix= new JLabel("10001 and Above: 38 fils/kWh\n");
    // Buttons
    JButton closeButton = new JButton("Close");
    JButton quitButton = new JButton("Quit");
    // Panels
    JPanel westPanel = new JPanel();
    JPanel centerPanel = new JPanel();
    JPanel southPanel = new JPanel();

    TariffsPage() {

        // Setting the frame layout as BorderLayout
        frame.setLayout(new BorderLayout());

        quitButton.setFocusable(false);
        quitButton.addActionListener(this);

        closeButton.setFocusable(false);
        closeButton.addActionListener(this);
        // Setting the background color for all panels
        centerPanel.setBackground(Color.lightGray);
        westPanel.setBackground(Color.lightGray);
        southPanel.setBackground(Color.white);
        // Setting center panel size
        centerPanel.setPreferredSize(new Dimension(360, 450));
        centerPanel.setMinimumSize(new Dimension(360, 450));
        centerPanel.setMaximumSize(new Dimension(360, 450));
        // Setting west panel size
        westPanel.setPreferredSize(new Dimension(360, 450));
        westPanel.setMinimumSize(new Dimension(360, 450));
        westPanel.setMaximumSize(new Dimension(360, 450));
        // Setting south panel size
        southPanel.setPreferredSize(new Dimension(360, 100));
        southPanel.setMinimumSize(new Dimension(360, 100));
        southPanel.setMaximumSize(new Dimension(360, 100));
        // Setting frame size 
        frame.setPreferredSize(new Dimension(720, 550));
        frame.setMinimumSize(new Dimension(720, 550));
        frame.setMaximumSize(new Dimension(720, 550));
        frame.setLocation(350, 100);
        // Exiting the program when the frame is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Adding components to the center panel
        centerPanel.add(residentialTariffsLabel);
        centerPanel.add(tariffOne);
        centerPanel.add(tariffTwo);
        centerPanel.add(tariffThree);
        centerPanel.add(tariffFour);
        // Adding components to the west panel
        westPanel.add(industrialTariffsLabel);
        westPanel.add(tariffFive);
        westPanel.add(tariffSix);
        // Adding components to the south panel
        southPanel.add(quitButton);
        southPanel.add(closeButton);
        // Adding the panels to the frame
        frame.add(centerPanel, BorderLayout.CENTER);
        frame.add(westPanel, BorderLayout.WEST);
        frame.add(southPanel, BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Close button event handling
        if (e.getSource()==closeButton) {

            frame.dispose();

        }
        // Quit button event handling
        if (e.getSource()==quitButton) {

            System.exit(0);

        }

    }
}