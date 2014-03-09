package fr.Dilink.src.panels;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

@SuppressWarnings("rawtypes")
class CellRenderer extends JLabel implements ListCellRenderer
{
	private static final long serialVersionUID = 1L;

	public Component getListCellRendererComponent(JList list, Object value /* value to display */, int index /* cell index */, boolean isSelected /* is the cell selected */, boolean cellHasFocus)    /* the list and the cell have the focus */ {
		setText(value.toString());
		if (isSelected) {
			setBackground(list.getSelectionBackground());
			setForeground(list.getSelectionForeground());
		} else {
			setBackground(list.getBackground());
			setForeground(list.getForeground());
		}
		if (isSelected == true){
			setBackground(new Color(0xA1B0E2));
		}
		setEnabled(list.isEnabled());
		setFont(list.getFont());
		setOpaque(true);
		return this;
	}
}