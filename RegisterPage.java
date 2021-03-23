import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.*;

public class RegisterPage extends IDandPasswords implements ActionListener {

    JFrame frame = new JFrame("Electricity Billing System");
    JLabel welcomeLabel = new JLabel("Registration Page");
    JButton registerButton = new JButton("Register");
    JButton resetButton = new JButton("Reset");
    JButton quitButton = new JButton("Quit");
    JTextField userIDField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    JLabel userIDLabel = new JLabel("userID: ");
    JLabel userPasswordLabel = new JLabel("Password: ");
    JLabel messageLabel = new JLabel("");

    RegisterPage(ArrayList registeredUsers, HashMap billsHashMap, ArrayList billsList) {

        Color customColor = new Color(44,100,51);

        frame.getContentPane().setBackground(Color.lightGray);

        welcomeLabel.setBounds(230, 0, 300, 35);
        welcomeLabel.setFont(new Font(null, Font.BOLD, 30));
        welcomeLabel.setForeground(customColor);

        userIDLabel.setBounds(200, 100, 75, 25);
        userPasswordLabel.setBounds(200, 150, 75, 25);

        userIDField.setBounds(300, 100, 200, 25);
        userPasswordField.setBounds(300, 150, 200, 25);

        registerButton.setBounds(320, 200, 100, 25);
        registerButton.setFocusable(false);
        registerButton.addActionListener(this);

        resetButton.setBounds(320, 250, 100, 25);
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);

        quitButton.setBounds(320, 300, 100, 25);
        quitButton.setFocusable(false);
        quitButton.addActionListener(this);

        messageLabel.setBounds(305, 180, 250, 12);
        messageLabel.setFont(new Font(null, Font.ITALIC, 14));
        messageLabel.setForeground(Color.red);

        frame.add(welcomeLabel);
        frame.add(userIDLabel);
        frame.add(userPasswordLabel);
        frame.add(userIDField);
        frame.add(userPasswordField);
        frame.add(registerButton);
        frame.add(resetButton);
        frame.add(quitButton);
        frame.add(messageLabel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(720, 550));
        frame.setMinimumSize(new Dimension(720, 550));
        frame.setMaximumSize(new Dimension(720, 550));
        frame.setLayout(null);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==registerButton) {

            if (logininfo.containsKey(userIDField.getText())) {

                messageLabel.setText("User already exists!");

            }

            else {

                frame.dispose();
                registeredUsers.add(userIDField.getText());
                logininfo.put(userIDField.getText(), String.valueOf(userPasswordField.getPassword()));
                LoginPage loginPage = new LoginPage(logininfo, registeredUsers, billsHashMap, billsList);

            }
        }

        if (e.getSource()==resetButton) {

            userIDField.setText("");
            userPasswordField.setText("");

        }

        if (e.getSource()==quitButton) {

            System.exit(0);

        }

    }
}
