/*import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class CarInventory 
{
	public Object[][] getTable0() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		Connection connection = DriverManager.getConnection("");//mysql ip?
		Statement statement = (Statement) connection.createStatement();
		ResultSet rs = statement.executeQuery("select * from cars");
		
		
		object[][] data = new Object[100][8];
		int count = 0;
		while(rs.next())
		{
			data[count][0] = rs.getString("VIN");
			data[count][1] = rs.getString("Brand");
			data[count][2] = rs.getString("Model");
			data[count][3] = rs.getString("Year");
			data[count][4] = rs.getString("Mileage");
			data[count][5] = rs.getString("Price");
			data[count][6] = rs.getString("Color");
			data[count][7] = rs.getString(8);
			count++;
		}
		
		connection.close();
		
		return data;
	}
	public Object[][] getTable1(String brandKey) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection connection = DriverManager.getConnection("");//mysql ip?
		Statement statement = (Statement) connection.createStatement();
		
		String sql = "Select * from cars where brand = '"+brandKey+ "';";
		
		ResultSet rs = statement.executeQuery("select * from cars");
		
		
		object[][] data = new Object[100][8];
		int count = 0;
		while(rs.next())
		{
			data[count][0] = rs.getString("VIN");
			data[count][1] = rs.getString("Brand");
			data[count][2] = rs.getString("Model");
			data[count][3] = rs.getString("Year");
			data[count][4] = rs.getString("Mileage");
			data[count][5] = rs.getString("Price");
			data[count][6] = rs.getString("Color");
			data[count][7] = rs.getString(8);
			count++;
		}
		
		connection.close();
		
		return data;
	}

	
}
*/


import java.sql.*;

import javax.swing.JOptionPane;

import com.mysql.jdbc.StringUtils;


public class CarInventory 
{
	public Object[][] getTable0() throws SQLException,IllegalAccessException, InstantiationException 
	{
	
		Connection c = DriverManager.getConnection("jdbc:mysql://35.226.60.138:3306/carmax","root","1234qwer");
		Statement s = c.createStatement();
		ResultSet rs = s.executeQuery("select * from cars;");
		Object[][] data = new Object[100][8];
		int count = 0;
		while (rs.next()) 
		{
			data[count][0]= rs.getString(1);
			data[count][1]= rs.getString(2);
			data[count][2]= rs.getString(3);
			data[count][3]= rs.getString(4);
			data[count][4]= rs.getString(5);
			data[count][5]= rs.getString(6);
			data[count][6]= rs.getString(7);
			data[count][7]= rs.getString(8);
			count++;
		}
		c.close();
		
		return data;
	}
	//Search
	public Object[][] getTable(String Vin, String Brand, String Model, 
			String Year, String Mileage, String Price, String Color, 
			boolean rb1, boolean rb2) 
					throws ClassNotFoundException,SQLException,
					IllegalAccessException, InstantiationException 
	{
	
		int params = 0;
		Connection 
		c = DriverManager.getConnection("jdbc:mysql://35.226.60.138:3306/carmax","root","1234qwer");
		Statement s = c.createStatement();
	
		String sql = "select * from cars where";// brand = '"+Brand+"'";
		if(Vin.compareTo("") != 0)
		{
			params++;
			if(params == 1)
				sql = sql+" vin = '"+Vin+"'";
			else
				sql = sql+" and vin = '"+Vin+"'";
		}
		if(Brand.compareTo("") != 0)
		{
			params++;
			if(params == 1)
				sql = sql+" Brand = '"+Brand+"'";
			else
				sql = sql+" and Brand = '"+Brand+"'";
		}
		if(Model.compareTo("") != 0)
		{
			params++;
			if(params == 1)
				sql = sql+" Model = '"+Model+"'";
			else
				sql = sql+" and Model = '"+Model+"'";
		}
		if(Year.compareTo("") != 0)
		{
			params++;
			if(params == 1)
				sql = sql+" Year = '"+Year+"'";
			else
				sql = sql+" and Year = '"+Year+"'";
		}
		if(Mileage.compareTo("") != 0)
		{
			params++;
			if(params == 1)
				sql = sql+" Mileage = '"+Mileage+"'";
			else
				sql = sql+" and Mileage = '"+Mileage+"'";
		}
		if(Price.compareTo("") != 0)
		{
			params++;
			if(params == 1)
				sql = sql+" Price = '"+Price+"'";
			else
				sql = sql+" and Price = '"+Price+"'";
		}
		if(Color.compareTo("") != 0)
		{
			params++;
			if(params == 1)
				sql = sql+" Color = '"+Color+"'";
			else
				sql = sql+" and Color = '"+Color+"'";
		}
		if(rb1 == true)
		{
			params++;
			if(params == 1)
				sql = sql + " BrandNew = 'Y'";
			else
				sql = sql+" and BrandNew = 'Y'";
		}
		else if(rb2 == true)
		{
			params++;
			if(params == 1)
				sql = sql + " BrandNew = 'N'";
			else
				sql = sql+" and BrandNew = 'N'";
		}
		if(params == 0)
			sql = "select * from cars;";
		else
			sql = sql + ";";
		//System.out.println(sql);
	
		ResultSet rs = s.executeQuery(sql);
		Object[][] data = new Object[100][8];
		int count = 0;
		if(rs.next())
		{
			data[count][0]= rs.getString(1);
			data[count][1]= rs.getString(2);
			data[count][2]= rs.getString(3);
			data[count][3]= rs.getString(4);
			data[count][4]= rs.getString(5);
			data[count][5]= rs.getString(6);
			data[count][6]= rs.getString(7);
			data[count][7]= rs.getString(8);
			count++;
			
			while (rs.next()) 
			{
				data[count][0]= rs.getString(1);
				data[count][1]= rs.getString(2);
				data[count][2]= rs.getString(3);
				data[count][3]= rs.getString(4);
				data[count][4]= rs.getString(5);
				data[count][5]= rs.getString(6);
				data[count][6]= rs.getString(7);
				data[count][7]= rs.getString(8);
				count++;
			}
			c.close();
		}
		else
		{
			JOptionPane.showMessageDialog(null,
					 "No vehicles match search criteria.",
					 "Don't put that evil on me!",
					 JOptionPane.INFORMATION_MESSAGE);
		}
	
		return data;
	}
	//Add Car
	public int AddCar(String Vin, String Brand, String Model, 
			String Year, String Mileage, String Price, String Color, 
			boolean rb1, boolean rb2) 
					throws ClassNotFoundException,SQLException,
					IllegalAccessException, InstantiationException 
	{
	
		int params = 0;
		Connection c = DriverManager.getConnection("jdbc:mysql://35.226.60.138:3306/carmax","root","1234qwer");
		Statement s = c.createStatement();
		ResultSet rs;
	
		String sql = "select * from cars where";// brand = '"+Brand+"'";
		if(Vin.compareTo("") != 0)
		{
			params++;
			Vin = Vin.toUpperCase().substring(0, Math.min(Vin.length(), 5));
			sql = sql+" vin = '"+Vin+"';";
			rs = s.executeQuery(sql);
			if(rs.next())
			{
				JOptionPane.showMessageDialog(null,
						 "Duplicate VIN entered.",
						 "Can't clone cars!",
						 JOptionPane.ERROR_MESSAGE);
				return 1;
			}
			else
				sql = "insert into cars values ('"+ Vin;
		}
		if(Brand.compareTo("") != 0)
		{
			params++;
				
			sql = sql+"','"+Brand;
		}
		if(Model.compareTo("") != 0)
		{
			params++;
			
			sql = sql+"','"+Model;
		}
		if(Year.compareTo("") != 0)
		{
			params++;
			if(Year.length() != 4 || !StringUtils.isStrictlyNumeric(Year))
			{
				JOptionPane.showMessageDialog(null,
						 "Only 4 numeric digits accepted for Year.",
						 "Numbers are hard!",
						 JOptionPane.ERROR_MESSAGE);
				return 1;
			}
			sql = sql+"','"+Year;
		}
		if(Mileage.compareTo("") != 0)
		{
			params++;
			if(!StringUtils.isStrictlyNumeric(Mileage))
			{
				JOptionPane.showMessageDialog(null,
						 "Only numeric digits accepted for Mileage.",
						 "Numbers are hard!",
						 JOptionPane.ERROR_MESSAGE);
				return 1;
			}
			sql = sql+"','"+Mileage;
		}
		if(Price.compareTo("") != 0)
		{
			params++;
			if(!StringUtils.isStrictlyNumeric(Price))
			{
				JOptionPane.showMessageDialog(null,
						 "Only numeric digits accepted for Price.",
						 "Numbers are hard!",
						 JOptionPane.ERROR_MESSAGE);
				return 1;
			}
			sql = sql+"','"+Price;
		}
		if(Color.compareTo("") != 0)
		{
			params++;
			sql = sql+"','"+Color;
		}
		if(rb1 == true)
		{
			if(Year.compareTo("") != 0)
			{
				if(Integer.parseInt(Year) < 2017)
				{
					JOptionPane.showMessageDialog(null,
						 "Vehicle too old to be considered New.",
						 "Years are hard!",
						 JOptionPane.ERROR_MESSAGE);
					return 1;
				}	
			}
			params++;
			sql = sql+"','Y'";
		}
		else if(rb2 == true)
		{
			params++;
			sql = sql+"','N'";
		}
		if(params == 8)
		{
			sql = sql + ");";
			s.execute(sql);
		}
		else
		{
			JOptionPane.showMessageDialog(null,
					 "Fill every field and select New or Used.",
					 "It puts the lotion in the basket!",
					 JOptionPane.INFORMATION_MESSAGE);
			return 1;
		}
		
		c.close();	
		return 0;
	}
	//Delete Car
	public int DelCar(String Vin, int del) throws ClassNotFoundException,SQLException,IllegalAccessException, InstantiationException 
	{
	
		del = 0;
		
		Connection c = DriverManager.getConnection("jdbc:mysql://35.226.60.138:3306/carmax","root","1234qwer");
		Statement s = c.createStatement();
		ResultSet rs;
		
		String sql = "select * from cars where";// brand = '"+Brand+"'";
		if(Vin.compareTo("") != 0)
		{
			sql = sql+" vin = '"+Vin+"'";
			rs = s.executeQuery(sql);
			if(rs.next())
			{
				s.execute("DELETE FROM cars WHERE VIN = '"+Vin+"';");
				del = 1;
			}
			else
			{
				//Display window: VIN Entered does not exist in database.
				del = 2;
			}
		}
		else
		{
			//Display window: VIN needed to delete vehicles.
			del = 3;
		}
	
		c.close();
		return del;
	}
	//Update
	public int Update(String Vin, String Brand, String Model, 
			String Year, String Mileage, String Price, String Color, 
			boolean rb1, boolean rb2) 
					throws ClassNotFoundException,SQLException,
					IllegalAccessException, InstantiationException 
	{
	
		int params = 0;
		Connection c = DriverManager.getConnection("jdbc:mysql://35.226.60.138:3306/carmax","root","1234qwer");
		Statement s = c.createStatement();
		ResultSet rs;
	
		String sql = "Update cars set";// brand = '"+Brand+"'";
		if(Vin.compareTo("") == 0)
		{
			JOptionPane.showMessageDialog(null,
					 "VIN needed to update vehicle.",
					 "It puts the lotion in the basket!",
					 JOptionPane.INFORMATION_MESSAGE);
			
			return 1;
		}
		else
		{
			rs = s.executeQuery("select * from cars where VIN = '"+Vin+"';");
			if(!rs.next())
			{
				JOptionPane.showMessageDialog(null,
						 "VIN entered is non existant.",
						 "HELP ME TOM CRUISE!",
						 JOptionPane.ERROR_MESSAGE); 
				return 1;
			}
		}
		if(Brand.compareTo("") != 0)
		{
			params++;
			if(params == 1)
				sql = sql+" Brand = '"+Brand+"'";
			else
				sql = sql+" and Brand = '"+Brand+"'";
		}
		if(Model.compareTo("") != 0)
		{
			params++;
			if(params == 1)
				sql = sql+" Model = '"+Model+"'";
			else
				sql = sql+" and Model = '"+Model+"'";
		}
		if(Year.compareTo("") != 0)
		{
			if(Year.length() != 4 || !StringUtils.isStrictlyNumeric(Year))
			{
				JOptionPane.showMessageDialog(null,
						 "Only 4 numeric digits accepted for Year.",
						 "Numbers are hard!",
						 JOptionPane.ERROR_MESSAGE);
				return 1;
			}
			params++;
			if(params == 1)
				sql = sql+" Year = '"+Year+"'";
			else
				sql = sql+" and Year = '"+Year+"'";
		}
		if(Mileage.compareTo("") != 0)
		{
			if(!StringUtils.isStrictlyNumeric(Mileage))
			{
				JOptionPane.showMessageDialog(null,
						 "Only numeric digits accepted for Mileage.",
						 "Numbers are hard!",
						 JOptionPane.ERROR_MESSAGE);
				return 1;
			}
			params++;
			if(params == 1)
				sql = sql+" Mileage = '"+Mileage+"'";
			else
				sql = sql+" and Mileage = '"+Mileage+"'";
		}
		if(Price.compareTo("") != 0)
		{
			if(!StringUtils.isStrictlyNumeric(Price))
			{
				JOptionPane.showMessageDialog(null,
						 "Only numeric digits accepted for Price.",
						 "Numbers are hard!",
						 JOptionPane.ERROR_MESSAGE);
				return 1;
			}
			params++;
			if(params == 1)
				sql = sql+" Price = '"+Price+"'";
			else
				sql = sql+" and Price = '"+Price+"'";
		}
		if(Color.compareTo("") != 0)
		{
			params++;
			if(params == 1)
				sql = sql+" Color = '"+Color+"'";
			else
				sql = sql+" and Color = '"+Color+"'";
		}
		if(rb1 == true)
		{
			if(Integer.parseInt(Year) < 2017)
			{
				JOptionPane.showMessageDialog(null,
						 "Vehicle too old to be considered New.",
						 "Years are hard!",
						 JOptionPane.ERROR_MESSAGE);
				return 1;
			}
			params++;
			if(params == 1)
				sql = sql + " BrandNew = 'Y';";
			else
				sql = sql+" and BrandNew = 'Y';";
		}
		else if(rb2 == true)
		{
			params++;
			if(params == 1)
				sql = sql + " BrandNew = 'N';";
			else
				sql = sql+" and BrandNew = 'N';";
		}
		if(params == 0)
			return 1;
		else
			sql = sql + " where VIN = '" +Vin + "';";
		//System.out.println(sql);
	
		rs = s.executeQuery(sql);
	
		return 0;
	}
}
