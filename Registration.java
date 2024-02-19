package CMS;

import java.awt.EventQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JEditorPane;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JCheckBox;


public class Registration extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField fullname;
    private JTextField email;
    private JPasswordField pw;
    private JPasswordField ConfirmPw;
    private JComboBox combo;
    private JComboBox comboBox;
    private JComboBox comboBox_1;
    private JTextField phone;
    private JPanel modulePanel;

    private String[] modulesForLevel4 = {"ITP", "ISA", "Math"};
    private String[] modulesForLevel5 = {"NMC", "AI", "OOP"};
    private String[] modulesForLevel6 = {"HPC", "BigData", "HCI"};

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Registration frame = new Registration();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    private void populateModules(String level) {
        contentPane.remove(modulePanel);
        modulePanel = new JPanel();
        modulePanel.setBackground(new Color(230, 230, 250));
        modulePanel.setBounds(397, 280, 328, 150);
        contentPane.add(modulePanel);
        modulePanel.setLayout(null);

        JLabel lblNewLabel = new JLabel("Select one module:");
        lblNewLabel.setBounds(10, 0, 200, 16);
        modulePanel.add(lblNewLabel);

        AtomicInteger selectedModulesCount = new AtomicInteger(0);
        int x = 10;
        int y = 30;

        switch (level) {
            case "4":
                for (String module : modulesForLevel4) {
                    JCheckBox checkBox = new JCheckBox(module);
                    checkBox.setBackground(new Color(230, 230, 250));
                    checkBox.setBounds(x, y, 150, 23);
                    y += 30;
                    checkBox.addItemListener(new ItemListener() {
                        public void itemStateChanged(ItemEvent e) {
                            if (e.getStateChange() == ItemEvent.SELECTED) {
                                if (selectedModulesCount.incrementAndGet() > 1) {
                                    JOptionPane.showMessageDialog(null, "Select only one modules.");
                                    checkBox.setSelected(false);
                                    selectedModulesCount.decrementAndGet();
                                }
                            } else if (e.getStateChange() == ItemEvent.DESELECTED) {
                                selectedModulesCount.decrementAndGet();
                            }
                        }
                    });
                    modulePanel.add(checkBox);
                }
                break;
            case "5":
                for (String module : modulesForLevel5) {
                    JCheckBox checkBox = new JCheckBox(module);
                    checkBox.setBackground(new Color(230, 230, 250));
                    checkBox.setBounds(x, y, 150, 23);
                    y += 30;
                    checkBox.addItemListener(new ItemListener() {
                        public void itemStateChanged(ItemEvent e) {
                            if (e.getStateChange() == ItemEvent.SELECTED) {
                                if (selectedModulesCount.incrementAndGet() > 1) {
                                    JOptionPane.showMessageDialog(null, "Select only one module.");
                                    checkBox.setSelected(false);
                                    selectedModulesCount.decrementAndGet();
                                }
                            } else if (e.getStateChange() == ItemEvent.DESELECTED) {
                                selectedModulesCount.decrementAndGet();
                            }
                        }
                    });
                    modulePanel.add(checkBox);
                }
                break;
            case "6":
                for (String module : modulesForLevel6) {
                    JCheckBox checkBox = new JCheckBox(module);
                    checkBox.setBackground(new Color(230, 230, 250));
                    checkBox.setBounds(x, y, 150, 23);
                    y += 30;
                    checkBox.addItemListener(new ItemListener() {
                        public void itemStateChanged(ItemEvent e) {
                            if (e.getStateChange() == ItemEvent.SELECTED) {
                                if (selectedModulesCount.incrementAndGet() > 2) {
                                    JOptionPane.showMessageDialog(null, "Select only one module.");
                                    checkBox.setSelected(false);
                                    selectedModulesCount.decrementAndGet();
                                }
                            } else if (e.getStateChange() == ItemEvent.DESELECTED) {
                                selectedModulesCount.decrementAndGet();
                            }
                        }
                    });
                    modulePanel.add(checkBox);
                }
                break;
            default:
                break;
        }

        contentPane.revalidate();
        contentPane.repaint();
    }


    
    private void registerUser(String email, String password, String role, String fullname,String level,String course,String phone) {
        String url = "jdbc:mysql://localhost:3306/CMS";
        String dbUsername = "root";
        String dbPassword = "";

        try (Connection connection = DriverManager.getConnection(url, dbUsername, dbPassword)) {
            switch (role) {
            case "Student":
                String moduleS1 = "";
                String moduleS2 = "";
                String moduleS3 = "";
                if (level.equals("4")) {
                    moduleS1 = "ITP";
                    moduleS2 = "ISA";
                    moduleS3 = "Math";
                } else if (level.equals("5")) {
                    moduleS1 = "NMC";
                    moduleS2 = "AI";
                    moduleS3 = "OOP";
                } else if (level.equals("6")) {
                    moduleS1 = "HPC";
                    moduleS2 = "BigData";
                    moduleS3 = "HCI";
                }

                try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Student (Email, Password, FullName, Level, Course, Phone, Module1, Module2, Module3) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)")) {
                    preparedStatement.setString(1, email);
                    preparedStatement.setString(2, password);
                    preparedStatement.setString(3, fullname);
                    preparedStatement.setString(4, level);
                    preparedStatement.setString(5, course);
                    preparedStatement.setString(6, phone);
                    preparedStatement.setString(7, moduleS1);
                    preparedStatement.setString(8, moduleS2);
                    preparedStatement.setString(9, moduleS3);

                    preparedStatement.executeUpdate();
                }
                break;

                case "Admin":
                    try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Admin (email, password, fullname,Phone) VALUES (?, ?, ?,?)")) {
                        preparedStatement.setString(1, email);
                        preparedStatement.setString(2, password);
                        preparedStatement.setString(3, fullname);
                        preparedStatement.setString(4, phone);
                        
                        preparedStatement.executeUpdate();
                    }
                    break;

                case "Teacher":
                    try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Teacher (Email, Password, Fullname, Phone, Level, Module1) VALUES ( ?, ?, ?, ?, ?, ?)")) {
                        preparedStatement.setString(1, email);
                        preparedStatement.setString(2, password);
                        preparedStatement.setString(3, fullname);
                        preparedStatement.setString(4, phone);
                        preparedStatement.setString(5, level);
                        
                        // Extract selected modules
                        String module1 = null;
                        int selectedModuleCount = 0;
                        for (Component component : modulePanel.getComponents()) {
                            if (component instanceof JCheckBox) {
                                JCheckBox checkBox = (JCheckBox) component;
                                if (checkBox.isSelected()) {
                                    selectedModuleCount++;
                                    if (selectedModuleCount == 1) {
                                        module1 = checkBox.getText();
                                    }
                                }
                            }
                        }
                        
                        preparedStatement.setString(6, module1);

                        preparedStatement.executeUpdate();
                    }
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Invalid role.");
                    return;
            }

            JOptionPane.showMessageDialog(null, "Registered as " + role);

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error occurred during registration.");
        }
    }


    
    public Registration() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 731, 501);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(230, 230, 250));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Registration Form");
        lblNewLabel.setFont(new Font("Monaco", Font.ITALIC, 20));
        lblNewLabel.setBounds(250, 92, 228, 28);
        contentPane.add(lblNewLabel);
        
        JLabel lblNewLabel_2 = new JLabel("Full Name:");
        lblNewLabel_2.setBounds(67, 154, 72, 16);
        contentPane.add(lblNewLabel_2);
        
        JLabel lblNewLabel_3 = new JLabel("E-mail:");
        lblNewLabel_3.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
        lblNewLabel_3.setBounds(67, 197, 61, 16);
        contentPane.add(lblNewLabel_3);
        
        JLabel lblNewLabel_4 = new JLabel("Password:");
        lblNewLabel_4.setBounds(67, 235, 72, 16);
        contentPane.add(lblNewLabel_4);
        
        JLabel lblNewLabel_5 = new JLabel("Confirm Password:");
        lblNewLabel_5.setBounds(63, 274, 118, 16);
        contentPane.add(lblNewLabel_5);
        
        JLabel lblNewLabel_1 = new JLabel("Level:");
        lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
        lblNewLabel_1.setBounds(397, 235, 61, 16);
        contentPane.add(lblNewLabel_1);
        
        JLabel lblNewLabel_8 = new JLabel("Courses:");
        lblNewLabel_8.setBounds(397, 274, 61, 16);
        contentPane.add(lblNewLabel_8);
        
        fullname = new JTextField();
        fullname.setForeground(new Color(169, 169, 169));
        fullname.setBounds(198, 149, 130, 26);
        contentPane.add(fullname);
        fullname.setColumns(10);
        
        email = new JTextField();
        email.setForeground(new Color(169, 169, 169));
        email.setBounds(198, 192, 130, 26);
        contentPane.add(email);
        email.setColumns(10);
        
        phone = new JTextField();
        phone.setBounds(482, 149, 130, 26);
        contentPane.add(phone);
        phone.setColumns(10);
        
        JButton btnNewButton = new JButton("Sign Up");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String FullName = fullname.getText();
                String Email=email.getText();
                String pass = pw.getText();
                String Confirmpw = ConfirmPw.getText();
                String role = (String) combo.getSelectedItem();
                String level = (String) comboBox.getSelectedItem();
                String course = (String) comboBox_1.getSelectedItem();
                String Phone = phone.getText();
                
                // Regex for LastName
                String regexLN = "([A-Z]{1}[a-z]+)( )([A-Z]{1}[a-z]+)";
                Pattern Lname = Pattern.compile(regexLN);
                Matcher LN = Lname.matcher(FullName);
                boolean lname = LN.matches();
                
                
                String regexEmail =  "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
                Pattern verifyEmail = Pattern.compile(regexEmail);
                Matcher eM = verifyEmail.matcher(Email);
                boolean checkEmail = eM.matches();
                
                // Regex for password
                String regexP = "[a-zA-Z0-9_+&*-]+";
                Pattern passN = Pattern.compile(regexP); 
                Matcher pN = passN.matcher(pass);
                boolean passNew = pN.matches();
                
                String regexPhone = "^\\d+$";
                Pattern PhoneN = Pattern.compile(regexPhone);
                Matcher phoneMatch = PhoneN.matcher(Phone);
                boolean checkPhone = phoneMatch.matches();
                
                if (role.equals("Teacher")) {
                    int selectedModuleCount = 0;
                    for (Component component : modulePanel.getComponents()) {
                        if (component instanceof JCheckBox) {
                            JCheckBox checkBox = (JCheckBox) component;
                            if (checkBox.isSelected()) {
                                selectedModuleCount++;
                            }
                        }
                    }
                    if (selectedModuleCount != 1) {
                        JOptionPane.showMessageDialog(null, "Please select only one modules.");
                        return;
                    }
                }
                
                if (!FullName.equals("") && !Email.equals("") && !pass.equals("") && !Confirmpw.equals("")&&!Phone.equals("")) {
                    if ( lname == true && passNew == true && Confirmpw.equals(pass)&&checkEmail==true &&checkPhone==true) {
                        registerUser(Email, pass, role,FullName,level,course,Phone);
                        Assessment login = new Assessment();
                        login.setVisible(true);
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid input or password mismatch.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Inputs cannot be empty.");
                }
            }
        });
        btnNewButton.setForeground(new Color(0, 0, 0));
        btnNewButton.setBackground(new Color(138, 43, 226));
        btnNewButton.setBounds(199, 334, 92, 46);
        contentPane.add(btnNewButton);
        
        pw = new JPasswordField();
        pw.setBounds(198, 230, 130, 26);
        contentPane.add(pw);
        
        ConfirmPw = new JPasswordField();
        ConfirmPw.setBounds(198, 269, 130, 26);
        contentPane.add(ConfirmPw);
        
        combo = new JComboBox();
        combo.setModel(new DefaultComboBoxModel(new String[] {"Student", "Admin", "Teacher"}));
        combo.setBounds(483, 193, 129, 27);
        contentPane.add(combo);
        
        combo.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String selectedRole = (String) combo.getSelectedItem();
                    if (selectedRole.equals("Student")) {
                        comboBox_1.setVisible(true);
                        lblNewLabel_8.setVisible(true);
                        comboBox.setVisible(true);
                        lblNewLabel_1.setVisible(true);
                    } else if (selectedRole.equals("Teacher")) {
                        comboBox.setVisible(true);
                        lblNewLabel_1.setVisible(true);
                        comboBox_1.setVisible(false);
                        lblNewLabel_8.setVisible(false);
                    } else {
                        comboBox.setVisible(false);
                        lblNewLabel_1.setVisible(false);
                        comboBox_1.setVisible(false);
                        lblNewLabel_8.setVisible(false);
                    }
                }
            }
        });
        
        JLabel lblNewLabel_6 = new JLabel("Register As:");
        lblNewLabel_6.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
        lblNewLabel_6.setBounds(397, 197, 105, 16);
        contentPane.add(lblNewLabel_6);
        
        JButton login = new JButton("Login");
        login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Assessment login = new Assessment();
                dispose();
                login.setVisible(true);
                
            }
        });
        login.setBounds(546, 424, 92, 46);
        contentPane.add(login);
        
        JLabel lblNewLabel_7 = new JLabel("Go to Login Page -->");
        lblNewLabel_7.setBounds(403, 438, 150, 16);
        contentPane.add(lblNewLabel_7);
        
        comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"--", "4", "5", "6"}));
        comboBox.setBounds(481, 231, 72, 27);
        contentPane.add(comboBox);
        
        comboBox_1 = new JComboBox();
        comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"BSc(Hons) Computer Science", "Bachelor in Intl Business Management", "Master of Business Administration","Bachelors in Computer Application"}));
        comboBox_1.setBounds(481, 270, 244, 27);
        contentPane.add(comboBox_1);
        
        JLabel lblNewLabel_9 = new JLabel("Phone:");
        lblNewLabel_9.setBounds(397, 154, 61, 16);
        contentPane.add(lblNewLabel_9);
        
        comboBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String selectedRole = (String) combo.getSelectedItem();
                    if (selectedRole.equals("Teacher")) {
                        String selectedLevel = (String) comboBox.getSelectedItem();
                        populateModules(selectedLevel);
                    } else {
                        contentPane.remove(modulePanel);
                        contentPane.revalidate();
                        contentPane.repaint();
                    }
                }
            }
        });

        modulePanel = new JPanel();
        modulePanel.setBackground(new Color(230, 230, 250));
        modulePanel.setBounds(397, 280, 328, 100);
        contentPane.add(modulePanel);
        modulePanel.setLayout(null);
    }
}
