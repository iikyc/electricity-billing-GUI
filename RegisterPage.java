import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.*;

public class RegisterPage extends BackEnd implements ActionListener {

    // Frame
    JFrame frame = new JFrame("Electricity Billing System");
    // Labels
    JLabel welcomeLabel = new JLabel("Registration Page");
    JLabel userIDLabel = new JLabel("userID: ");
    JLabel userPasswordLabel = new JLabel("Password: ");
    JLabel messageLabel = new JLabel("");
    // Buttons
    JButton registerButton = new JButton("Register");
    JButton resetButton = new JButton("Reset");
    JButton quitButton = new JButton("Quit");
    // Fields
    JTextField userIDField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    

    RegisterPage(ArrayList registeredUsers, HashMap billsHashMap, ArrayList billsList) {

        Color customColor = new Color(44,100,51); // Custom color used to style welcomeLabel
        // Setting the background color for the frame
        frame.getContentPane().setBackground(Color.lightGray);

        // Setting location and dimensions of components
        welcomeLabel.setBounds(230, 0, 300, 35);
        welcomeLabel.setFont(new Font(null, Font.BOLD, 30));
        welcomeLabel.setForeground(customColor);

        userIDLabel.setBounds(200, 100, 75, 25);
        userPasswordLabel.setBounds(200, 150, 75, 25);

        userIDField.setBounds(300, 100, 200, 25);
        userPasswordField.setBounds(300, 150, 200, 25);

        messageLabel.setBounds(305, 180, 250, 12);
        messageLabel.setFont(new Font(null, Font.ITALIC, 14));
        messageLabel.setForeground(Color.red);

        registerButton.setBounds(320, 200, 100, 25);
        registerButton.setFocusable(false);
        registerButton.addActionListener(this);

        resetButton.setBounds(320, 250, 100, 25);
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);

        quitButton.setBounds(320, 300, 100, 25);
        quitButton.setFocusable(false);
        quitButton.addActionListener(this);

        // Exiting the program when the frame is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Adding components to the frame
        frame.add(welcomeLabel);
        frame.add(userIDLabel);
        frame.add(userPasswordLabel);
        frame.add(userIDField);
        frame.add(userPasswordField);
        frame.add(messageLabel);
        frame.add(registerButton);
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
        // Register button event handling
        if (e.getSource()==registerButton) {
            // Comparing the text in userIDField to the HashMap logininfo,
            // if the text in userIDField is a key, an error message is displayed
            if (logininfo.containsKey(userIDField.getText())) {

                messageLabel.setText("User already exists!");

            }

            else {
                // Current frame is disposed
                frame.dispose();
                // If the text in userIDField is not a key in logininfo (the user does
                // not exist), it is added as a registered user in the registeredUsers
                // array list, and as a key in logininfo along with the password
                registeredUsers.add(userIDField.getText());
                logininfo.put(userIDField.getText(), String.valueOf(userPasswordField.getPassword()));
                // User is redirected to the login page
                LoginPage loginPage = new LoginPage(logininfo, registeredUsers, billsHashMap, billsList);

            }
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