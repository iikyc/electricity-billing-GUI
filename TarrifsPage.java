import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.*;

public class TariffsPage implements ActionListener {

    JFrame frame = new JFrame("Tariff Slabs");
    JLabel residentialTariffsLabel = new JLabel("Residential and Commercial Tariffs");
    JLabel commercialTariffsLabel = new JLabel("Industrial Tariffs");
    JButton closeButton = new JButton("Close");
    JButton quitButton = new JButton("Quit");

    TariffsPage() {

        frame.getContentPane().setForeground(Color.white);

        quitButton.setBounds(0, 0, 100, 100);
        quitButton.setFocusable(false);
        quitButton.addActionListener(this);

        closeButton.setBounds(0, 0, 100, 100);
        closeButton.setFocusable(false);
        closeButton.addActionListener(this);

        frame.add(residentialTariffsLabel);
        frame.add(commercialTariffsLabel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(5, 2));
        frame.add(new JLabel("0-2000 kWh/Month: 23 fils/kWh"));
        frame.add(new JLabel("0-10000 kWh/Month: 23 fils/kWh"));
        frame.add(new JLabel("2001-4000 kWh/Month: 28 fils/kWh"));
        frame.add(new JLabel("10001 and Above: 38 fils/kWh"));
        frame.add(new JLabel("4001-6000 kWh/Month: 32 fils/kWh"));
        frame.add(new JLabel(""));
        frame.add(new JLabel("6001 and Above: 38 fils/kWh"));
        frame.add(quitButton);
        frame.add(closeButton);
        frame.setSize(420, 420);
        frame.pack();
        frame.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==closeButton) {

            frame.dispose();

        }

        if (e.getSource()==quitButton) {

            System.exit(0);

        }

    }
}

