import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;

public class LoginPage implements ActionListener{

    HashMap<String, String> loginInfo = new HashMap<String, String>();

    //Create UI vars
    JFrame frame = new JFrame();
    JButton loginButton = new JButton("Login");
    JButton resetButton = new JButton("Reset");
    JTextField userIdField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    JLabel userIdLabel = new JLabel("userID:");
    JLabel userPasswordLabel = new JLabel("password:");
    JLabel messageLabel = new JLabel("");

    LoginPage(HashMap<String, String> loginInfoIn){

        loginInfo = loginInfoIn;

        //Set position and propertys of UI elements
        userIdLabel.setBounds(50,100,75,25);
        userPasswordLabel.setBounds(50,150,75,25);
        messageLabel.setBounds(125,250,250,35);
        messageLabel.setFont(new Font(null,Font.ITALIC,25));
        userIdField.setBounds(125,100,200,25);
        userPasswordField.setBounds(125,150,200,25);
        loginButton.setBounds(125,200,100,25);
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);
        resetButton.setBounds(225,200,100,25);
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);

        //Import UI elements into window
        frame.add(userIdLabel);
        frame.add(userPasswordLabel);
        frame.add(messageLabel);
        frame.add(userIdField);
        frame.add(userPasswordField);
        frame.add(loginButton);
        frame.add(resetButton);

        //Window settings
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //Reset button
        if(e.getSource() == resetButton){
            userIdField.setText("");
            userPasswordField.setText("");

        }

        //Login logic
        if(e.getSource() == loginButton){
            String userID = userIdField.getText();
            String password = String.copyValueOf(userPasswordField.getPassword());

            if(loginInfo.containsKey(userID)){
                if(loginInfo.get(userID).equals(password)){
                    messageLabel.setForeground(Color.green);
                    messageLabel.setText("Login successful");
                    frame.dispose();
                    WelcomePage welcomePage = new WelcomePage(userID);
                }
                else {
                    messageLabel.setForeground(Color.red);
                    messageLabel.setText("Wrong password");
                }
            }
            else {
                messageLabel.setForeground(Color.red);
                messageLabel.setText("Username not found");
            }
        }
    }


}
