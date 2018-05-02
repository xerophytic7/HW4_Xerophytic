import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class HW_4 extends JFrame{

	
	private JLabel label1, label2, label3, label4, label5, label6, label7;
	private JTextField tf1, tf2, tf3, tf4, tf5, tf6, tf7;
	private JButton b1, b2, b3, b4;
	private JRadioButton rb1, rb2, rb3; 
	private String[] columnNames = {"VIN","Brand","Model","Year","Mileage","Price","Color", "Brand New"};
	private Object[][] data={{"","","","","","","",""}};
	private JTable table;
	private DefaultTableModel dm;
	private JScrollPane scroll;
	private ButtonGroup bG;
	CarInventory ci = new CarInventory();
	public HW_4() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {

		super("Carmax");
		setSize(800,610);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		table = new JTable();
		dm = new DefaultTableModel(ci.getTable0(), columnNames);
	    table.setModel(dm);
		scroll = new JScrollPane(table);
		scroll.setSize(700, 270);
		scroll.setLocation(50, 50);
		add(scroll);
		
		b1 = new JButton("Search");
		b1.setSize(100, 30);
		b1.setLocation(50, 350);
		b1.addActionListener(new Button1Clicked());
		add(b1);
		b2 = new JButton("Add");
		b2.setSize(100, 30);
		b2.setLocation(200, 350);
		b2.addActionListener(new Button2Clicked());
		add(b2);
		b3 = new JButton("Delete");
		b3.setSize(100, 30);
		b3.setLocation(350, 350);
		b3.addActionListener(new Button3Clicked());
		add(b3);
		b4 = new JButton("Update");
		b4.setSize(100, 30);
		b4.setLocation(500, 350);
		b4.addActionListener(new Button4Clicked());
		add(b4);
		
		label1 = new JLabel("VIN");
		label1.setSize(100, 30);
		label1.setLocation(50, 400);
		add(label1);		
		tf1 = new JTextField();
		tf1.setSize(100, 30);
		tf1.setLocation(100, 400);
		add(tf1);
		
		label2 = new JLabel("Brand");
		label2.setSize(100, 30);
		label2.setLocation(50, 450);
		add(label2);		
		tf2 = new JTextField();
		tf2.setSize(100, 30);
		tf2.setLocation(100, 450);
		add(tf2);

		label3 = new JLabel("Model");
		label3.setSize(100, 30);
		label3.setLocation(250, 450);
		add(label3);		
		tf3 = new JTextField();
		tf3.setSize(100, 30);
		tf3.setLocation(300, 450);
		add(tf3);

		label4 = new JLabel("Year");
		label4.setSize(100, 30);
		label4.setLocation(450, 450);
		add(label4);		
		tf4 = new JTextField();
		tf4.setSize(100, 30);
		tf4.setLocation(500, 450);
		add(tf4);

		label5 = new JLabel("Mileage");
		label5.setSize(100, 30);
		label5.setLocation(50, 500);
		add(label5);		
		tf5 = new JTextField();
		tf5.setSize(100, 30);
		tf5.setLocation(100, 500);
		add(tf5);

		label6 = new JLabel("Price");
		label6.setSize(100, 30);
		label6.setLocation(250, 500);
		add(label6);		
		tf6 = new JTextField();
		tf6.setSize(100, 30);
		tf6.setLocation(300, 500);
		add(tf6);

		label7 = new JLabel("Color");
		label7.setSize(100, 30);
		label7.setLocation(450, 500);
		add(label7);		
		tf7 = new JTextField();
		tf7.setSize(100, 30);
		tf7.setLocation(500, 500);
		add(tf7);

		rb1 = new JRadioButton("New");
		rb1.setSize(100, 30);
		rb1.setLocation(250, 400);
		//rb1.setActionCommand("Y");
		//rb1.addActionListener(new rb1Clicked());
		add(rb1);
		rb2 = new JRadioButton("Used");
		rb2.setSize(100, 30);
		rb2.setLocation(350, 400);
		//rb2.setActionCommand("N");
		//rb2.addActionListener(new rb2Clicked());
		add(rb2);
		rb3 = new JRadioButton("Used & New");
		rb3.setSize(100, 30);
		rb3.setLocation(450, 400);
		add(rb3);

		bG = new ButtonGroup();
	    bG.add(rb1);
	    bG.add(rb2);
	    bG.add(rb3);
	    rb3.setSelected(true);
	    
		setVisible(true);
	}
	//Search
	private class Button1Clicked implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0)
		{
			try 
			{	
				dm.setDataVector(ci.getTable(tf1.getText(), tf2.getText(), tf3.getText(),
						tf4.getText(), tf5.getText(), tf6.getText(), tf7.getText(), 
						rb1.isSelected(), rb2.isSelected()), columnNames);	
			} 
			catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) 
			{
				e.printStackTrace();
			}
			dm.fireTableDataChanged();		
		}
	}
	//Add
	private class Button2Clicked implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0)
		{
			int er = 0;
			try 
			{	
				er = ci.AddCar(tf1.getText(), tf2.getText(), tf3.getText(), tf4.getText(), tf5.getText(),
						tf6.getText(), tf7.getText(),rb1.isSelected(), rb2.isSelected());	
			} 
			catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) 
			{
				e.printStackTrace();
			}
			dm.fireTableDataChanged();	
			if(er == 0)
			{
				//Display added Vehicle
				try 
				{	
					dm.setDataVector(ci.getTable(tf1.getText(), tf2.getText(), tf3.getText(),
						tf4.getText(), tf5.getText(), tf6.getText(), tf7.getText(), 
						rb1.isSelected(), rb2.isSelected()), columnNames);	
				} 
				catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) 
				{
					e.printStackTrace();
				}
				dm.fireTableDataChanged();
			}
		}
	}
	//Delete
	private class Button3Clicked implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0)
		{
			//del = 0 is default, 1 is successfully deleted
			//2: vin doesn't exist
			//3: there wasn't anything entered in vin field
			int del = 0;
			try 
			{	
				del = ci.DelCar(tf1.getText(), del);//, columnNames);	
			} 
			catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) 
			{
				e.printStackTrace();
			}
			dm.fireTableDataChanged();	
						
			if(del == 1)
			{
				try 
				{	
					dm.setDataVector(ci.getTable("", "", "", "", "", "", "", false, false), columnNames);	
				} 
				catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) 
				{
					e.printStackTrace();
				}
				dm.fireTableDataChanged();
			}
			else if(del == 2)
			{
				//Display message: VIN Entered doesn't exist in database
				JOptionPane.showMessageDialog(null,
						 "VIN entered is non existant.",
						 "HELP ME TOM CRUISE!",
						 JOptionPane.ERROR_MESSAGE); 
			}
			else if (del == 3)
			{
				//Display message: VIN Needed to delete vehicles
				JOptionPane.showMessageDialog(null,
						 "VIN needed to delete vehicles.",
						 "HELP ME OPRAH WINFREY!",
						 JOptionPane.ERROR_MESSAGE); 
			}
		}
	}
	//Update
	private class Button4Clicked implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0)
		{
			int er = 0;
			try 
			{	
				er = ci.Update(tf1.getText(), tf2.getText(), tf3.getText(),
						tf4.getText(), tf5.getText(), tf6.getText(), tf7.getText(), 
						rb1.isSelected(), rb2.isSelected());	
			} 
			catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) 
			{
				e.printStackTrace();
			}
			dm.fireTableDataChanged();		
			
			//Display Updated Vehicle
			if(er == 0)
			{
				try 
				{	
					dm.setDataVector(ci.getTable(tf1.getText(), tf2.getText(), tf3.getText(),
						tf4.getText(), tf5.getText(), tf6.getText(), tf7.getText(), 
						rb1.isSelected(), rb2.isSelected()), columnNames);	
				} 
				catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) 
				{
					e.printStackTrace();
				}
				dm.fireTableDataChanged();
			}
		}
	}
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException 
	{
		new HW_4();
	}

}
