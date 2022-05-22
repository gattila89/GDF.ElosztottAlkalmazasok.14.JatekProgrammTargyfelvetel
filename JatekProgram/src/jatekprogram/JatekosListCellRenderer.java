package jatekprogram;

import Model.Szereplo;
import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

public class JatekosListCellRenderer extends DefaultListCellRenderer {
    @Override
    public Component getListCellRendererComponent(JList<?> list,
                                 Object value,
                                 int index,
                                 boolean isSelected,
                                 boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        if (value instanceof Szereplo) {
            Szereplo ingredient = (Szereplo)value;
            setText(ingredient.getNev());
        }
        return this;
    }
}
