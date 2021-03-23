import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.*;

public class RegisterPage extends IDandPasswords implements ActionListener {

    JFrame frame = new JFrame("Register");
    JLabel welcomeLabel = new JLabel("Registration Page");
    JButton registerButton = new JButton("Register");
    JButton resetButton = new JButton("Reset");
    JButton quitButton = new JButton("Quit");
    JTextField userIDField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    JLabel userIDLabel = new JLabel("userID: ");
    JLabel userPasswordLabel = new JLabel("Password: ");
    JLabel messageLabel = new JLabel();

    RegisterPage(ArrayList registeredUsers, HashMap billsHashMap, ArrayList billsList) {

        Color customColor = new Color(44,100,51);

        frame.getContentPane().setForeground(Color.white);

        welcomeLabel.setBounds(0, 0, 250, 35);
        welcomeLabel.setFont(new Font(null, Font.BOLD, 25));
        welcomeLabel.setForeground(customColor);

        userIDLabel.setBounds(50, 100, 75, 25);
        userPasswordLabel.setBounds(50, 150, 75, 25);

        userIDField.setBounds(125, 100, 200, 25);
        userPasswordField.setBounds(125, 150, 200, 25);

        registerButton.setBounds(125, 200, 100, 25);
        registerButton.setFocusable(false);
        registerButton.addActionListener(this);

        resetButton.setBounds(125, 250, 100, 25);
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);

        quitButton.setBounds(125, 300, 100, 25);
        quitButton.setFocusable(false);
        quitButton.addActionListener(this);

        frame.add(welcomeLabel);
        frame.add(userIDLabel);
        frame.add(userPasswordLabel);
        frame.add(userIDField);
        frame.add(userPasswordField);
        frame.add(registerButton);
        frame.add(resetButton);
        frame.add(quitButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==registerButton) {

            frame.dispose();
            registeredUsers.add(userIDField.getText());
            logininfo.put(userIDField.getText(), String.valueOf(userPasswordField.getPassword()));
            LoginPage loginPage = new LoginPage(logininfo, registeredUsers, billsHashMap, billsList);

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
