import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ray on 4/27/2016.
 */

public class StudentInfoGUI {
    private JPanel studentInfoPanel;
    private JLabel nameLabel;
    private JLabel schoolLabel;
    private JLabel sidLabel;
    private JLabel languageLabel;
    private JTextField nameField;
    private JTextField sidField;
    private JComboBox languageBox;
    private JButton nextButton;
    private JButton previousButton;
    private JComboBox schoolComboBox;
    private JLabel errorLabel;
    private List<String> studentInfo;

    public static void main(String[] args) {
        StudentInfoGUI.createFrame();
    }

    public static void createFrame() {
        JFrame frame = new JFrame("Student Information");
        frame.setContentPane(new StudentInfoGUI().studentInfoPanel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public StudentInfoGUI() {
        $$$setupUI$$$();
        studentInfo = new ArrayList<>();
        nextButton.addActionListener(e -> {

            studentInfo.add(getNameEntry());
            studentInfo.add(getLanguageEntry());
            studentInfo.add(getSidEntry());
            studentInfo.add(getSchoolEntry());

            if (getSidEntry() != null && getNameEntry() != null) {
                PasswordSetupGUI.createFrame();
                ((JFrame) studentInfoPanel.getTopLevelAncestor()).dispose();
            } else {
                errorLabel.setVisible(true);
            }
        });

        previousButton.addActionListener(e -> {
            LogInGUI.createFrame();
            ((JFrame) studentInfoPanel.getTopLevelAncestor()).dispose();
        });
    }

    private String getNameEntry() {
        String nameEntry = nameField.getText();
        if (legitNameEntry()) {
            return nameEntry;
        } else return null;
    }

    private boolean legitNameEntry() {
        String nameEntry = nameField.getText();
        if (nameEntry != null && nameEntry.matches("[a-zA-Z ]+")) {
            return true;
        } else {
            return false;
        }
    }

    private String getSidEntry() {
        String sidEntry = sidField.getText();
        if (legitSidEntry()) {
            return sidEntry;
        } else return null;
    }

    private boolean legitSidEntry() {
        String sidEntry = sidField.getText();
        if (sidEntry != null && sidEntry.matches("^\\d+$")) {
            return true;
        } else {
            return false;
        }
    }

    private String getSchoolEntry() {
        return (String) schoolComboBox.getSelectedItem();
    }

    private String getLanguageEntry() {
        return (String) languageBox.getSelectedItem();
    }

    private List<String> getStudentInfo() {
        return studentInfo;
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        studentInfoPanel = new JPanel();
        studentInfoPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(7, 5, new Insets(0, 25, 25, 25), -1, -1));
        final JLabel label1 = new JLabel();
        label1.setFont(new Font(label1.getFont().getName(), label1.getFont().getStyle(), 36));
        label1.setText("Student");
        studentInfoPanel.add(label1, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 3, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(4, 3, new Insets(0, 0, 0, 0), -1, -1));
        studentInfoPanel.add(panel1, new com.intellij.uiDesigner.core.GridConstraints(4, 1, 1, 3, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        schoolLabel = new JLabel();
        schoolLabel.setFont(new Font(schoolLabel.getFont().getName(), schoolLabel.getFont().getStyle(), 20));
        schoolLabel.setText("School:");
        panel1.add(schoolLabel, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        languageLabel = new JLabel();
        languageLabel.setFont(new Font(languageLabel.getFont().getName(), languageLabel.getFont().getStyle(), 20));
        languageLabel.setText("Language:");
        panel1.add(languageLabel, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        nameField = new JTextField();
        panel1.add(nameField, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_EAST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        sidField = new JTextField();
        panel1.add(sidField, new com.intellij.uiDesigner.core.GridConstraints(2, 1, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_EAST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        languageBox = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel1 = new DefaultComboBoxModel();
        defaultComboBoxModel1.addElement("English");
        defaultComboBoxModel1.addElement("Spanish");
        defaultComboBoxModel1.addElement("Farsi");
        defaultComboBoxModel1.addElement("Chinese");
        defaultComboBoxModel1.addElement("French");
        defaultComboBoxModel1.addElement("Klingon");
        languageBox.setModel(defaultComboBoxModel1);
        languageBox.setToolTipText("");
        panel1.add(languageBox, new com.intellij.uiDesigner.core.GridConstraints(3, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_EAST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        schoolComboBox = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel2 = new DefaultComboBoxModel();
        defaultComboBoxModel2.addElement("SJSU");
        defaultComboBoxModel2.addElement("UCLA");
        schoolComboBox.setModel(defaultComboBoxModel2);
        panel1.add(schoolComboBox, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_EAST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        nameLabel = new JLabel();
        nameLabel.setFont(new Font(nameLabel.getFont().getName(), nameLabel.getFont().getStyle(), 20));
        nameLabel.setText("Name:");
        panel1.add(nameLabel, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        sidLabel = new JLabel();
        sidLabel.setFont(new Font(sidLabel.getFont().getName(), sidLabel.getFont().getStyle(), 20));
        sidLabel.setText("Student ID:");
        panel1.add(sidLabel, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer1 = new com.intellij.uiDesigner.core.Spacer();
        panel1.add(spacer1, new com.intellij.uiDesigner.core.GridConstraints(1, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, 1, null, new Dimension(10, -1), null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer2 = new com.intellij.uiDesigner.core.Spacer();
        panel1.add(spacer2, new com.intellij.uiDesigner.core.GridConstraints(3, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, 1, null, new Dimension(10, -1), null, 0, false));
        nextButton = new JButton();
        nextButton.setText("   Next   ");
        studentInfoPanel.add(nextButton, new com.intellij.uiDesigner.core.GridConstraints(5, 2, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_EAST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        errorLabel = new JLabel();
        errorLabel.setBackground(new Color(-65536));
        errorLabel.setEnabled(true);
        errorLabel.setFont(new Font(errorLabel.getFont().getName(), errorLabel.getFont().getStyle(), 12));
        errorLabel.setForeground(new Color(-65536));
        errorLabel.setText("Error! Validate input!");
        errorLabel.setVisible(false);
        studentInfoPanel.add(errorLabel, new com.intellij.uiDesigner.core.GridConstraints(3, 1, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        previousButton = new JButton();
        previousButton.setText("Previous");
        studentInfoPanel.add(previousButton, new com.intellij.uiDesigner.core.GridConstraints(5, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setFont(new Font(label2.getFont().getName(), label2.getFont().getStyle(), 36));
        label2.setText("Information");
        studentInfoPanel.add(label2, new com.intellij.uiDesigner.core.GridConstraints(2, 1, 1, 3, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer3 = new com.intellij.uiDesigner.core.Spacer();
        studentInfoPanel.add(spacer3, new com.intellij.uiDesigner.core.GridConstraints(0, 4, 7, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer4 = new com.intellij.uiDesigner.core.Spacer();
        studentInfoPanel.add(spacer4, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 7, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer5 = new com.intellij.uiDesigner.core.Spacer();
        studentInfoPanel.add(spacer5, new com.intellij.uiDesigner.core.GridConstraints(3, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(-1, 16), null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer6 = new com.intellij.uiDesigner.core.Spacer();
        studentInfoPanel.add(spacer6, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 3, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer7 = new com.intellij.uiDesigner.core.Spacer();
        studentInfoPanel.add(spacer7, new com.intellij.uiDesigner.core.GridConstraints(6, 1, 1, 3, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return studentInfoPanel;
    }
}
