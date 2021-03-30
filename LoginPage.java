import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.*;

public class LoginPage extends BackEnd implements ActionListener {

    // Frame
    JFrame frame = new JFrame("Electricity Billing System");
    // Labels
    JLabel welcomeLabel = new JLabel("Login");
    JLabel userIDLabel = new JLabel("userID: ");
    JLabel userPasswordLabel = new JLabel("Password: ");
    JLabel messageLabel = new JLabel(); // Used to indicate a failed login attempt
    // Buttons
    JButton loginButton = new JButton("Login");
    JButton registerButton = new JButton("Register");
    JButton resetButton = new JButton("Reset");
    JButton quitButton = new JButton("Quit");
    // Fields
    JTextField userIDField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    

    LoginPage(HashMap<String, String> loginInfoOriginal, ArrayList registeredUsers, HashMap billsHashMap, ArrayList billsList) {

        Color customColor = new Color(44,100,51); // Custom RGB color used to style welcomeLabel
        // Setting the background color for the frame
        frame.getContentPane().setBackground(Color.lightGray);

        logininfo = loginInfoOriginal;
        // Setting location and dimensions of components
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

        // Exiting the program when the frame is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Adding components to the frame
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
        // Login button event handling
        if (e.getSource()==loginButton) {

            // Setting the userID to the text entered in the userIDField
            String userID = userIDField.getText();
            // Setting the password to the text entered in userPasswordField
            String password = String.valueOf(userPasswordField.getPassword());

            // Comparing the userID string to the keys in the HashMap logininfo
            if (logininfo.containsKey(userID)) { 
                // If the userID is a key in logininfo, the value of the userID key
                // is compared to the password string entered in userPasswordField
                if (logininfo.get(userID).equals(password)) {
                    // If the userID and password match, the current frame is disposed,
                    // and the user is redirected to the welcome page
                    frame.dispose();
                    WelcomePage welcomePage = new WelcomePage(userID);

                }
                // If the password does not match the userID key in logininfo,
                // an error message is displayed
                else {

                    messageLabel.setForeground(Color.red);
                    messageLabel.setText("userID or Password Incorrect");

                }

            }
            // If the userID string is not a key in logininfo,
            // an error message is displayed
            else {

                messageLabel.setForeground(Color.red);
                messageLabel.setText("userID or Password Incorrect");

            }
        }
        // Register button event handling
        if (e.getSource()==registerButton) {
            // Current frame gets disposed
            frame.dispose();
            // User is redirected to the registration page
            RegisterPage registerPage = new RegisterPage(registeredUsers, billsHashMap, billsList);

        }
        // Reset button event handling
        if (e.getSource()==resetButton) {
            // Any text in the userIDField is deleted by setting the text to null ("")
            userIDField.setText("");
            // Any text in the userPasswordField is deleted by setting the text to null ("")
            userPasswordField.setText("");

        }
        // Quit button event handling
        if (e.getSource()==quitButton) {
            // Exiting the program
            System.exit(0);

        }

    }
}