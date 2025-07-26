package models;

import java.sql.*; 
import models.JavaFuns;
import services.DBConnector;

import java.util.*;

public class ProductsList {
	
	private String type; 
	
	 

	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public List<ProductsList> getProdTypeList(){
		
		Connection con;
		Statement st;
		DBConnector gc = new DBConnector();
		ResultSet rs;
		ProductsList bl=new ProductsList();
		
		List<ProductsList> lst= new ArrayList<ProductsList>();
		
		try {
			con=gc.connect();
			st=con.createStatement();
			
			rs=st.executeQuery("select * from categories");
			
			while(rs.next()) {
				
				bl=new ProductsList();
				bl.setType(rs.getString("category"));	
				lst.add(bl);
				
			}			
				
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return (lst);
	}

	public String RegCategory()
	{
		DBConnector gc = new DBConnector();
		int y=0;
		
		Connection con;
		String st="";
		try {
		con=gc.connect();
		PreparedStatement pst;
		 
		JavaFuns jf=new JavaFuns();
		Vector v=jf.getValue("select ifnull(max(cateId),1000)+1 from categories", 1);
		pst=con.prepareStatement("insert into categories values(?,?);");

		pst.setInt(1,Integer.parseInt(v.elementAt(0).toString().trim()));
		pst.setString(2,type);
	 
		

		int x=pst.executeUpdate(); 
		
		if(x>0)
			st="success";
		else
			st="failure";
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return st;
		
		
	}
	
}
