package CMS;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import javax.swing.JScrollPane;

public class ResultTable extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTable table;

    /**
     * Create the panel.
     */
    public ResultTable() {
        setLayout(null); // Avoid using null layout, instead use layout managers

        DefaultTableModel model = new DefaultTableModel();

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CMS", "root", "");
            Statement stmt = con.createStatement();
            
            String query = "SELECT s.StudentId, s.fullname, s.level, r.module_1, r.mark_1, r.module_2, r.mark_2, r.module_3, r.mark_3, r.percentage, r.result "
                         + "FROM Student s "
                         + "JOIN Result r ON s.StudentID = r.StudentId";
            
            ResultSet rs = stmt.executeQuery(query);
            ResultSetMetaData rsmd = rs.getMetaData();

            int columnCount = rsmd.getColumnCount();
            

            for (int i = 1; i <= columnCount; i++) {
                model.addColumn(rsmd.getColumnName(i));
            }

            while (rs.next()) {
                Object[] row = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    row[i - 1] = rs.getObject(i);
                }
                model.addRow(row);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(0, 0, 1017, 317);
        add(scrollPane);
        
        table = new JTable(model);
        table.setRowSelectionAllowed(false);
        scrollPane.setViewportView(table);
        
        table.setFont(new Font("Niramit", Font.PLAIN, 13));
        table.setForeground(new Color(0, 0, 0));
        table.setBackground(new Color(238, 238, 238));
        table.setGridColor(Color.BLACK);
        

        table.setRowHeight(30);

        JTableHeader header = table.getTableHeader();
        header.setVisible(true);
        header.setPreferredSize(new Dimension(header.getWidth(), 30)); 
        table.setIntercellSpacing(new java.awt.Dimension(7, 7));

    }
}
