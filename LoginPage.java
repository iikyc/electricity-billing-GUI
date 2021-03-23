import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.*;

public class LoginPage extends IDandPasswords implements ActionListener {

    JFrame frame = new JFrame("Electricity Billing System");
    JLabel welcomeLabel = new JLabel("Login");
    JButton loginButton = new JButton("Login");
    JButton registerButton = new JButton("Register");
    JButton resetButton = new JButton("Reset");
    JButton quitButton = new JButton("Quit");
    JTextField userIDField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    JLabel userIDLabel = new JLabel("userID: ");
    JLabel userPasswordLabel = new JLabel("Password: ");
    JLabel messageLabel = new JLabel();

    LoginPage(HashMap<String, String> loginInfoOriginal, ArrayList registeredUsers, HashMap billsHashMap, ArrayList billsList) {

        Color customColor = new Color(44,100,51);

        frame.getContentPane().setBackground(Color.lightGray);

        logininfo = loginInfoOriginal;

        welcomeLabel.setBounds(320, 0, 200, 35);
        welcomeLabel.setFont(new Font(null, Font.BOLD, 30));
        welcomeLabel.setForeground(customColor);

        userIDLabel.setBounds(205, 100, 75, 25);
        userPasswordLabel.setBounds(200, 150, 75, 25);

        messageLabel.setBounds(300, 180, 250, 12);
        messageLabel.setFont(new Font(null, Font.ITALIC, 12));

        userIDField.setBounds(300, 100, 200, 25);
        userPasswordField.setBounds(300, 150, 200, 25);

        loginButton.setBounds(320, 200, 100, 25);
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);
        loginButton.setBackground(Color.green);

        registerButton.setBounds(320, 250, 100, 25);
        registerButton.setFocusable(false);
        registerButton.addActionListener(this);

        resetButton.setBounds(320, 300, 100, 25);
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);

        quitButton.setBounds(320, 350, 100, 25);
        quitButton.setFocusable(false);
        quitButton.addActionListener(this);

        frame.add(welcomeLabel);
        frame.add(userIDLabel);
        frame.add(userPasswordLabel);
        frame.add(messageLabel);
        frame.add(userIDField);
        frame.add(userPasswordField);
        frame.add(loginButton);
        frame.add(registerButton);
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

        if (e.getSource()==loginButton) {

            String userID = userIDField.getText();
            String password = String.valueOf(userPasswordField.getPassword());

            if (logininfo.containsKey(userID)) {

                if (logininfo.get(userID).equals(password)) {

                    frame.dispose();
                    WelcomePage welcomePage = new WelcomePage(userID);

                }

                else {

                    messageLabel.setForeground(Color.red);
                    messageLabel.setText("userID or Password Incorrect");

                }

            }

            else {

                messageLabel.setForeground(Color.red);
                messageLabel.setText("userID or Password Incorrect");

            }
        }

        if (e.getSource()==registerButton) {

            frame.dispose();
            RegisterPage registerPage = new RegisterPage(registeredUsers, billsHashMap, billsList);

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
