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
import javax.swing.ListSelectionModel;
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
        setLayout(null);
        
        DefaultTableModel model = new DefaultTableModel();

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CMS", "root", "");
            Statement stmt = con.createStatement();
            
            String query = "SELECT s.StudentId, s.fullname, s.level, " +
                    "CASE " +
                    "   WHEN s.level = 4 THEN 'ITP' " +
                    "   WHEN s.level = 5 THEN 'NMC' " +
                    "   WHEN s.level = 6 THEN 'HPC' " +
                    "END AS module_1, " +
                    "CASE " +
                    "   WHEN s.level = 4 THEN 'ISA' " +
                    "   WHEN s.level = 5 THEN 'AI' " +
                    "   WHEN s.level = 6 THEN 'BigData' " +
                    "END AS module_2, " +
                    "CASE " +
                    "   WHEN s.level = 4 THEN 'Math' " +
                    "   WHEN s.level = 5 THEN 'OOP' " +
                    "   WHEN s.level = 6 THEN 'HCI' " +
                    "END AS module_3, " +
                    "r.mark_1, r.mark_2, r.mark_3 " +
                    "FROM Student s " +
                    "JOIN Result r ON s.StudentID = r.StudentId";

            
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
        scrollPane.setBounds(0, 0, 712, 421);
        add(scrollPane);
        
        table = new JTable(model);
        table.setFillsViewportHeight(true);
        table.setRowSelectionAllowed(false);
        scrollPane.setViewportView(table);
        
        table.setFont(new Font("Niramit", Font.PLAIN, 13));
        table.setForeground(new Color(0, 0, 0));
        table.setBackground(new Color(238, 238, 238));
        table.setGridColor(Color.BLACK);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        table.setRowHeight(30);
        
        TableColumnModel columnModel = table.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(15);
        columnModel.getColumn(1).setPreferredWidth(100);
        columnModel.getColumn(2).setPreferredWidth(10);
        columnModel.getColumn(3).setPreferredWidth(50);
        columnModel.getColumn(4).setPreferredWidth(30);
        columnModel.getColumn(5).setPreferredWidth(50);
        columnModel.getColumn(6).setPreferredWidth(30);
        columnModel.getColumn(7).setPreferredWidth(50);
        columnModel.getColumn(8).setPreferredWidth(30);

        JTableHeader header = table.getTableHeader();
        header.setVisible(true);
        header.setPreferredSize(new Dimension(header.getWidth(), 30)); 
        table.setIntercellSpacing(new java.awt.Dimension(7, 7));
        
    }
}

