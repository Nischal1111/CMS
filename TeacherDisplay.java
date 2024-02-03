package CMS;

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

public class TeacherDisplay extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public TeacherDisplay() {
		
		DefaultTableModel model = new DefaultTableModel();

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CMS", "root", "");
            Statement stmt = con.createStatement();
            String query = "Select TeacherId,Fullname,Email,Phone from Teacher";
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
		setLayout(null);

		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 6, 623, 288);
		add(scrollPane);
		
		table = new JTable(model);
		scrollPane.setViewportView(table);
		table.setRowSelectionAllowed(false);
        table.setFont(new Font("Niramit", Font.PLAIN, 13));
        table.setForeground(new Color(0, 0, 0));
        table.setBackground(new Color(238, 238, 238));

        TableColumnModel columnModel = table.getColumnModel();

        columnModel.getColumn(0).setPreferredWidth(30);
        columnModel.getColumn(1).setPreferredWidth(200);
        columnModel.getColumn(2).setPreferredWidth(50);
        columnModel.getColumn(3).setPreferredWidth(50);

        table.setShowGrid(true);
        table.setShowHorizontalLines(true);
        table.setShowVerticalLines(true);
        table.setGridColor(Color.BLACK);

        table.setRowHeight(30);

        JTableHeader header = table.getTableHeader();
        header.setVisible(true);
        header.setPreferredSize(new Dimension(header.getWidth(), 30)); 
        table.setIntercellSpacing(new java.awt.Dimension(7, 7));

	}
}
