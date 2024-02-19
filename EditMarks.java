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

public class EditMarks extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private int studentId;
    private JLabel lblNewLabel_1;
    private JLabel lblNewLabel_1_2;
    private JLabel lblNewLabel_1_1;

    /**
     * Create the frame.
     */
    public EditMarks(int studentId) {
        this.studentId = studentId;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 468, 450);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(173, 216, 230));
        panel.setBounds(6, 6, 571, 61);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("Edit Marks");
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

        JButton btnNewButton = new JButton("Edit Marks");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                editMarks();
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

    private void editMarks() {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CMS", "root", "");

            String query2 = "UPDATE Result SET module_1 = ?, mark_1 = ?, module_2 = ?, mark_2 = ?, module_3 = ?, mark_3 = ?, percentage = ?, result = ? WHERE StudentId = ?";
            PreparedStatement pstmt2 = con.prepareStatement(query2);

            int mark1 = Integer.parseInt(textField_1.getText());
            int mark2 = Integer.parseInt(textField_2.getText());
            int mark3 = Integer.parseInt(textField_3.getText());

            // Calculate percentage
            float totalMarks = mark1 + mark2 + mark3;
            float percentage = totalMarks / 3;

            // Determine result
            String result = (percentage >= 40) ? "PASS" : "FAIL";

            pstmt2.setString(1, lblNewLabel_1.getText()); // Using label text for module name
            pstmt2.setInt(2, mark1);
            pstmt2.setString(3, lblNewLabel_1_1.getText()); // Using label text for module name
            pstmt2.setInt(4, mark2);
            pstmt2.setString(5, lblNewLabel_1_2.getText()); // Using label text for module name
            pstmt2.setInt(6, mark3);
            pstmt2.setFloat(7, percentage);
            pstmt2.setString(8, result);
            pstmt2.setInt(9, studentId);

            int updated = pstmt2.executeUpdate();

            if (updated > 0) {
                JOptionPane.showMessageDialog(null, "Marks updated successfully.");
            } else {
                JOptionPane.showMessageDialog(null, "Failed to update marks.");
            }

            pstmt2.close();
            con.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
