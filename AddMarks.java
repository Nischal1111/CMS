package CMS;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;

public class AddMarks extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private int studentId;
    private JLabel lblNewLabel_1;
    private JLabel lblNewLabel_1_2;
    private JLabel lblNewLabel_1_1;
    private String teacherMod1;
    private String teacherlev;

    /**
     * Create the frame.
     */
    public AddMarks(int studentId,String TeacherModule1,String TeachLevv) {
        this.studentId = studentId;
        teacherMod1 = TeacherModule1;
        teacherlev=TeachLevv;
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 468, 450);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(95, 158, 160));
        panel.setBounds(6, 6, 571, 61);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("Add Marks");
        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 28));
        lblNewLabel.setBounds(160, 6, 149, 49);
        panel.add(lblNewLabel);

        JLabel lblNewLabel_3 = new JLabel("Module 1:");
        lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        lblNewLabel_3.setBounds(61, 82, 77, 16);
        contentPane.add(lblNewLabel_3);

        JLabel lblNewLabel_3_1 = new JLabel("Module 2:");
        lblNewLabel_3_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        lblNewLabel_3_1.setBounds(61, 170, 77, 16);
        contentPane.add(lblNewLabel_3_1);

        JLabel lblNewLabel_3_2 = new JLabel("Module 3:");
        lblNewLabel_3_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        lblNewLabel_3_2.setBounds(61, 266, 77, 16);
        contentPane.add(lblNewLabel_3_2);

        lblNewLabel_1 = new JLabel("Module_1");
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        lblNewLabel_1.setBounds(76, 122, 91, 26);
        contentPane.add(lblNewLabel_1);

        lblNewLabel_1_1 = new JLabel("Module_2");
        lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        lblNewLabel_1_1.setBounds(76, 201, 91, 26);
        contentPane.add(lblNewLabel_1_1);

        lblNewLabel_1_2 = new JLabel("Module_3");
        lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        lblNewLabel_1_2.setBounds(76, 294, 91, 26);
        contentPane.add(lblNewLabel_1_2);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(309, 107, 130, 35);
        contentPane.add(textField_1);

        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(309, 198, 130, 35);
        contentPane.add(textField_2);

        textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setBounds(309, 294, 130, 35);
        contentPane.add(textField_3);

        JLabel lblNewLabel_4 = new JLabel("Marks 1:");
        lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        lblNewLabel_4.setBounds(341, 79, 77, 16);
        contentPane.add(lblNewLabel_4);

        JLabel lblNewLabel_4_1 = new JLabel("Marks 2:");
        lblNewLabel_4_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        lblNewLabel_4_1.setBounds(341, 170, 77, 16);
        contentPane.add(lblNewLabel_4_1);

        JLabel lblNewLabel_4_2 = new JLabel("Marks 3:");
        lblNewLabel_4_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        lblNewLabel_4_2.setBounds(341, 266, 77, 16);
        contentPane.add(lblNewLabel_4_2);

        JButton btnNewButton = new JButton("Add Marks");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addMarks();
            }
        });
        btnNewButton.setBounds(160, 342, 130, 41);
        contentPane.add(btnNewButton);

        JButton btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btnCancel.setBounds(332, 375, 130, 41);
        contentPane.add(btnCancel);

        populateModuleNames();
    }

    private void populateModuleNames() {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CMS", "root", "");

            // Fetch module names based on student's ID from the database
            String query = "SELECT module1, module2, module3 FROM Student WHERE studentid = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, studentId);
            ResultSet rs = pstmt.executeQuery();

            // If there are results, populate the labels with module names
            if (rs.next()) {
                lblNewLabel_1.setText(rs.getString("module1"));
                lblNewLabel_1_1.setText(rs.getString("module2"));
                lblNewLabel_1_2.setText(rs.getString("module3"));
            }

            pstmt.close();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void addMarks() {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CMS", "root", "");
            
            // Check if the level of the student matches the level of the teacher
            String queryCheckLevel = "SELECT level FROM Student WHERE studentid = ?";
            PreparedStatement pstmtCheckLevel = con.prepareStatement(queryCheckLevel);
            pstmtCheckLevel.setInt(1, studentId);
            ResultSet rsCheckLevel = pstmtCheckLevel.executeQuery();
            
            if (rsCheckLevel.next()) {
                String studentLevel = rsCheckLevel.getString("level");
                
                if (!studentLevel.equals(teacherlev)) {
                    JOptionPane.showMessageDialog(null, "You are not allowed to add marks for this student.");
                    return; // Exit the method if levels don't match
                }
            } else {
                JOptionPane.showMessageDialog(null, "Student not found.");
                return; // Exit the method if student not found
            }
            
            // Continue with adding marks if levels match
            String query2 = "INSERT INTO Result (StudentId, module_1, mark_1, module_2, mark_2, module_3, mark_3, percentage, result) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt2 = con.prepareStatement(query2);

            int mark1 = Integer.parseInt(textField_1.getText());
            int mark2 = Integer.parseInt(textField_2.getText());
            int mark3 = Integer.parseInt(textField_3.getText());

            // Calculate percentage
            float totalMarks = mark1 + mark2 + mark3;
            float percentage = totalMarks / 3;

            // Determine result
            String result = (percentage >= 40) ? "PASS" : "FAIL";

            pstmt2.setInt(1, studentId);
            pstmt2.setString(2, lblNewLabel_1.getText()); // module_1
            pstmt2.setInt(3, mark1); // mark_1
            pstmt2.setString(4, lblNewLabel_1_1.getText()); // module_2
            pstmt2.setInt(5, mark2); // mark_2
            pstmt2.setString(6, lblNewLabel_1_2.getText()); // module_3
            pstmt2.setInt(7, mark3); // mark_3
            pstmt2.setFloat(8, percentage); // percentage
            pstmt2.setString(9, result); // result

            int added = pstmt2.executeUpdate();

            if (added > 0) {
                JOptionPane.showMessageDialog(null, "Marks added successfully.");
            } else {
                JOptionPane.showMessageDialog(null, "Failed to Add.");
            }

            pstmt2.close();
            con.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


}
