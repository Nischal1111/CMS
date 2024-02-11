package CMS;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;

public class DelCourse extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    DelCourse frame = new DelCourse();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public DelCourse() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 429, 369);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Select the Course ID:");
        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lblNewLabel.setBounds(119, 120, 170, 16);
        contentPane.add(lblNewLabel);

        textField = new JTextField();
        textField.setForeground(new Color(255, 0, 0));
        textField.setBounds(116, 152, 173, 36);
        contentPane.add(textField);
        textField.setColumns(10);

        JButton btnNewButton = new JButton("Delete");
        btnNewButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String courseId = textField.getText();

                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/CMS", "root", "");

                    String sql = "DELETE FROM Courses WHERE Course_ID = ?";

                    try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

                        preparedStatement.setString(1, courseId);

                        int del = preparedStatement.executeUpdate();

                        if (del > 0) {
                            JOptionPane.showMessageDialog(null, "Course Deleted !!!");
                            
                        } else {
                            JOptionPane.showMessageDialog(null, "Course not found!!!");
                        }
                    }
                } catch (SQLException err) {
                    err.printStackTrace();
                }
            }
        });
        btnNewButton.setForeground(new Color(255, 0, 0));
        btnNewButton.setBackground(new Color(255, 0, 0));
        btnNewButton.setBounds(161, 210, 84, 41);
        contentPane.add(btnNewButton);

        JPanel panel = new JPanel();
        panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        panel.setBackground(new Color(169, 169, 169));
        panel.setBounds(6, 6, 417, 64);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel_1 = new JLabel("Delete a Course Here !!!");
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblNewLabel_1.setForeground(new Color(255, 0, 0));
        lblNewLabel_1.setBounds(105, 17, 236, 30);
        panel.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Go to courses -->");
        lblNewLabel_2.setBounds(62, 300, 132, 16);
        contentPane.add(lblNewLabel_2);

        JButton btnNewButton_1 = new JButton("GO");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btnNewButton_1.setBounds(184, 291, 84, 36);
        contentPane.add(btnNewButton_1);
    }
}
