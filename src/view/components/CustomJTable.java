package view.components;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.TableModel;
import java.awt.*;

public class CustomJTable extends JTable {
    public CustomJTable(TableModel tableModel) {
        super(tableModel);
        setBackground(new Color(255,255,255));
        setForeground(new Color(118, 118, 118));
        setFont(new Font("SansSerif", Font.BOLD, 12));

        getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 12));
        getTableHeader().setOpaque(true);
        //getTableHeader().setBackground(new Color(255,255,255));
        getTableHeader().setForeground(new Color(42, 42, 42));
        setRowHeight(25);
    }
}
