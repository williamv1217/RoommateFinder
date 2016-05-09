import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Launches the Log-in screen of the Roomie Finder application.
 * Created by Raymond Gevorkian on 4/26/2016
 */

public class LogInGUI {
    private JLabel titleLabel;
    private JTextField nameField;
    private JPasswordField passwordField;
    private JButton logInButton;
    private JButton signUpButton;
    private JLabel errorLabel;
    private JPanel loginPanel;
    private List<String> logInEntryInfo;
    String currentUser;


    static Queue<Student> matches;
    static List<Student> fromFile;

//    /**
//     * Main method of the LogInGUI. Calls for the creation of the frame containing the log in window.
//     * Also, it reads in the account file to later be validated against.
//     */
//    public static void main(String[] args) {
//        LogInGUI.createFrame();
//    }

    /**
     * Creates the frame containing the log in window.
     */
    public static void createFrame() {
        JFrame frame = new JFrame("Roommate Finder Log In");
        frame.setContentPane(new LogInGUI().loginPanel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack(); //condensing contents of window to be as packed as possible.
        frame.setLocationRelativeTo(null); //setting location to middle of user's screen.
        frame.setVisible(true);
    }

    /**
     * Constructor for the LogInGUI.
     * Initializes a new ArrayList to monitor the inputted account information [username, password].
     * Initializes action listeners and JButtons. A user is only logged in if the input is valid.
     */
    public LogInGUI() {
        $$$setupUI$$$();
        ReadFile.read();

        logInEntryInfo = new ArrayList<>();

        logInButton.addActionListener(e -> {
            currentUser = nameField.getText();
            runSchool();

            logInEntryInfo.add(getUserName());
            logInEntryInfo.add(getPassword());

//            System.out.println(modifyPassword());
            if (validateInput()) {
                ((JFrame) loginPanel.getTopLevelAncestor()).dispose(); //closing the current screen.
                MainMenuGUI.createFrame();
            } else {
                errorLabel.setVisible(true); //displaying an error when the given input is incorrect.
            }
        });

        signUpButton.addActionListener(e -> {
            PasswordSetupGUI.createFrame(); //calling for the creation of the sign up frame.
            ((JFrame) loginPanel.getTopLevelAncestor()).dispose(); //closing the current screen.
        });
    }

    /**
     * Method to return the inputted username one is attempting to log in with.
     *
     * @return nameField.getText - the inputted username in the log in window.
     */
    private String getUserName() {
        return nameField.getText();
    }

    /**
     * Method to return the inputted password one is attempting to log in with.
     *
     * @return passwordField.getText - the inputted password in the log in window.
     */
    private String getPassword() {
        return passwordField.getText();
    }

    /**
     * Method to modify the password into its' encrypted state.
     *
     * @return Password.createPassword - the encrypted password by Huffman Tree.
     */
    private int modifyPassword() {
        return Password.createPassword(getPassword(), getPassword());
    }

    /**
     * Method to check the validity of the password.
     * Encrypts the password first, then compares against the encrypted password.
     *
     * @return ReadFile.validate - true or false on whether or not the password is correct.
     */
    private boolean validateInput() {
        String parsePassCheck = Integer.toString(modifyPassword());
        return ReadFile.validate(getUserName(), parsePassCheck);
    }

    void runSchool() {
        School sjsu = new School("SJSU");
        sjsu.add(new School.Building("CVB", 400));

        String userName = currentUser;
        Student me = null;
        fromFile = Student.readFile();

        for (Student student : fromFile) {
            if (student.getSchool().getName().equals(sjsu.getName())) sjsu.add(student);
            if (student.getName().equals(userName)) me = student;
        }

        sjsu.add(Student.generate());

        matches = me.matches();
    }

    Queue getMatchQueue() {
        return matches;
    }


    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        loginPanel = new JPanel();
        loginPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(5, 4, new Insets(10, 10, 10, 10), -1, -1));
        final com.intellij.uiDesigner.core.Spacer spacer1 = new com.intellij.uiDesigner.core.Spacer();
        loginPanel.add(spacer1, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer2 = new com.intellij.uiDesigner.core.Spacer();
        loginPanel.add(spacer2, new com.intellij.uiDesigner.core.GridConstraints(3, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(3, 3, new Insets(0, 0, 0, 0), -1, -1));
        loginPanel.add(panel1, new com.intellij.uiDesigner.core.GridConstraints(3, 1, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JLabel label1 = new JLabel();
        label1.setFont(new Font(label1.getFont().getName(), label1.getFont().getStyle(), 18));
        label1.setText("Name");
        panel1.add(label1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setFont(new Font(label2.getFont().getName(), label2.getFont().getStyle(), 18));
        label2.setText("Password");
        panel1.add(label2, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        passwordField = new JPasswordField();
        passwordField.setFont(new Font(passwordField.getFont().getName(), passwordField.getFont().getStyle(), passwordField.getFont().getSize()));
        panel1.add(passwordField, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        logInButton = new JButton();
        logInButton.setText("Log In");
        panel1.add(logInButton, new com.intellij.uiDesigner.core.GridConstraints(0, 2, 2, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        nameField = new JTextField();
        panel1.add(nameField, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        errorLabel = new JLabel();
        errorLabel.setEnabled(true);
        errorLabel.setForeground(new Color(-65536));
        errorLabel.setText("Invalid Username or Password");
        errorLabel.setVisible(false);
        panel1.add(errorLabel, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        signUpButton = new JButton();
        signUpButton.setText("Sign Up");
        panel1.add(signUpButton, new com.intellij.uiDesigner.core.GridConstraints(2, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer3 = new com.intellij.uiDesigner.core.Spacer();
        loginPanel.add(spacer3, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        titleLabel = new JLabel();
        titleLabel.setFont(new Font(titleLabel.getFont().getName(), titleLabel.getFont().getStyle(), 36));
        titleLabel.setText("Finder");
        loginPanel.add(titleLabel, new com.intellij.uiDesigner.core.GridConstraints(2, 1, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer4 = new com.intellij.uiDesigner.core.Spacer();
        loginPanel.add(spacer4, new com.intellij.uiDesigner.core.GridConstraints(4, 1, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final JLabel label3 = new JLabel();
        label3.setFont(new Font(label3.getFont().getName(), label3.getFont().getStyle(), 36));
        label3.setText("Roommate");
        loginPanel.add(label3, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return loginPanel;
    }
}
