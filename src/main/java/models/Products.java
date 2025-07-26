package models;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;
 
import services.DBConnector;
public class Products {
	Connection con;
    CallableStatement csmt;
    ResultSet rs;
    private List<Products> lstprod;
    private String title,unit,prodType,path,userType,usernm,userid,dt,tm,desc,coverphoto;
    private double quantity,price;
    private String availsts,edt;
    private MultipartFile file;
    public MultipartFile getFile() {
		return file;
	}



	public String getPath() {
		return path;
	}



	public void setPath(String path) {
		this.path = path;
	}



	public String getEdt() {
		return edt;
	}



	public void setEdt(String edt) {
		this.edt = edt;
	}



	public String getAvailsts() {
		return availsts;
	}



	public void setAvailsts(String availsts) {
		this.availsts = availsts;
	}



	public String getUnit() {
		return unit;
	}



	public void setUnit(String unit) {
		this.unit = unit;
	}



	public String getProdType() {
		return prodType;
	}



	public void setProdType(String prodType) {
		this.prodType = prodType;
	}



	public String getUserType() {
		return userType;
	}



	public void setUserType(String userType) {
		this.userType = userType;
	}



	public String getUsernm() {
		return usernm;
	}



	public void setUsernm(String usernm) {
		this.usernm = usernm;
	}

 

 


	public void setFile(MultipartFile file) {
		this.file = file;
	}

	private int prodId;
   public int getProdId() {
		return prodId;
	}



	public void setProdId(int prodId) {
		this.prodId = prodId;
	}



public Products() {}
      
      

	public List<Products> getLstprod() {
	return lstprod;
}



public void setLstprod(List<Products> lstprod) {
	this.lstprod = lstprod;
}



public String getTitle() {
	return title;
}



public void setTitle(String title) {
	this.title = title;
}



public String getUserid() {
	return userid;
}



public void setUserid(String userid) {
	this.userid = userid;
}



public String getDt() {
	return dt;
}



public void setDt(String dt) {
	this.dt = dt;
}



public String getTm() {
	return tm;
}



public void setTm(String tm) {
	this.tm = tm;
}



public String getDesc() {
	return desc;
}



public void setDesc(String desc) {
	this.desc = desc;
}



public String getCoverphoto() {
	return coverphoto;
}



public void setCoverphoto(String coverphoto) {
	this.coverphoto = coverphoto;
}



public double getQuantity() {
	return quantity;
}



public void setQuantity(double quantity) {
	this.quantity = quantity;
}



public double getPrice() {
	return price;
}



public void setPrice(double price) {
	this.price = price;
}


public void getRetailers(String cate)
{
	
    try
    {
         DBConnector obj=new  DBConnector();
        con=obj.connect();
        csmt=con.prepareCall("{call getRetailers(?)}");
        csmt.setString(1, cate);
         
        lstprod=new ArrayList<Products>();
         
         csmt.execute();
         rs=csmt.getResultSet();
                     
        while(rs.next())
        { System.out.println("true");
        lstprod.add(new Products(rs));
              
        }
    }
       
     
    catch(Exception ex)
    {
        System.out.println("err="+ex.getMessage());
         
    }
}
	public Products(ResultSet rs)
	{
		try
		{
		title=rs.getString("title").toString().trim();
		desc=rs.getString("prodDesc").toString().trim();
		dt=rs.getString("dt").toString().trim();
		tm=rs.getString("tm").toString().trim();
		userid=rs.getString("userid").toString().trim();
		quantity=Double.parseDouble(rs.getString("stock").toString().trim());
		price=Double.parseDouble(rs.getString("price").toString().trim());
		userid=rs.getString("userid").toString().trim();
		availsts=rs.getString("availsts").toString().trim();
		 
		prodType=rs.getString("category").toString().trim();
		prodId=Integer.parseInt(rs.getString("prodId").toString().trim());
		 coverphoto=rs.getString("photo").toString().trim();
		System.out.println("cover="+coverphoto);
		 
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("err="+e.getMessage());
		}
	}
public List<Products> getMoreProdPhotosList(int partId1){
		
		Connection con;
		Statement st;
		DBConnector gc = new DBConnector();
		ResultSet rs;
		Products bl=new Products();
		
		List<Products> lst= new ArrayList<Products>();
		
		try {
			con=gc.connect();
			st=con.createStatement();
			System.out.println("select * from prod_photos where prodId="+partId1);
			rs=st.executeQuery("select * from prod_photos where prodId="+partId1);
			
			while(rs.next()) {
				
				bl=new Products();
				bl.setTitle(rs.getString("title"));
				bl.setProdType(rs.getString("category"));
 
				bl.setCoverphoto(rs.getString("photo"));
				 bl.setProdId(rs.getInt("prodId"));
				lst.add(bl);
				
			}			
				
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return (lst);
	}
	public void getProducts()
	{
	    try
	    {
	         DBConnector obj=new  DBConnector();
	        con=obj.connect();
	        csmt=con.prepareCall("{call getProducts(?)}");
	        csmt.setString(1, userid);
	         
	        lstprod=new ArrayList<Products>();
	         
	         csmt.execute();
	         rs=csmt.getResultSet();
	                     
	        while(rs.next())
	        { System.out.println("true");
	        lstprod.add(new Products(rs));
	              
	        }
	    }
	       
	     
	    catch(Exception ex)
	    {
	        System.out.println("err="+ex.getMessage());
	         
	    }
	}
	public void getProducts12(String searchText)
	{
	    try
	    {
	         DBConnector obj=new  DBConnector();
	        con=obj.connect();
	        csmt=con.prepareCall("{call getAllProdSearch(?)}");
	        csmt.setString(1, searchText); 
	        lstprod=new ArrayList<Products>();
	         
	         csmt.execute();
	         rs=csmt.getResultSet();
	                     
	        while(rs.next())
	        { System.out.println("true");
	        lstprod.add(new Products(rs));
	              
	        }
	    }
	       
	     
	    catch(Exception ex)
	    {
	        System.out.println("err="+ex.getMessage());
	         
	    }
	}
	public void getProducts1()
	{
	    try
	    {
	         DBConnector obj=new  DBConnector();
	        con=obj.connect();
	        csmt=con.prepareCall("{call getProducts1(?,?)}");
	        csmt.setString(1, userid);
	        csmt.setString(2, prodType); 
	        lstprod=new ArrayList<Products>();
	         
	         csmt.execute();
	         rs=csmt.getResultSet();
	                     
	        while(rs.next())
	        { System.out.println("true");
	        lstprod.add(new Products(rs));
	              
	        }
	    }
	       
	     
	    catch(Exception ex)
	    {
	        System.out.println("err="+ex.getMessage());
	         
	    }
	}
	public void getProducts11()
	{
	    try
	    {
	         DBConnector obj=new  DBConnector();
	        con=obj.connect();
	        csmt=con.prepareCall("{call getProducts11()}");
 
	        lstprod=new ArrayList<Products>();
	         
	         csmt.execute();
	         rs=csmt.getResultSet();
	                     
	        while(rs.next())
	        { System.out.println("true");
	        lstprod.add(new Products(rs));
	              
	        }
	    }
	       
	     
	    catch(Exception ex)
	    {
	        System.out.println("err="+ex.getMessage());
	         
	    }
	}
	public void getId()
	{
	    try
	    {
	         DBConnector obj=new  DBConnector();
	        con=obj.connect();
	        csmt=con.prepareCall("{call getMaxIdProd()}");
	       
	         csmt.execute();
	         rs=csmt.getResultSet();
	                    
	        boolean auth=false;
	        while(rs.next())
	        { System.out.println("true");
	            auth=true;
	            
	            prodId=rs.getInt("mxid");
	            if(prodId==0 || prodId==1000)
	            	prodId=1001;
	            else
	            	prodId+=1;
	              
	        }
	    }
	       
	     
	    catch(Exception ex)
	    {
	        System.out.println("err="+ex.getMessage());
	         
	    }
	}

	/*public void getId()
	    {
	        try
	        {
	             DBConnector obj=new  DBConnector();
	            con=obj.connect();
	            csmt=con.prepareCall("{call getMaxIdUsers()}");
	           
	             csmt.execute();
	             rs=csmt.getResultSet();
	                        
	            boolean auth=false;
	            while(rs.next())
	            { System.out.println("true");
	                auth=true;
	                
	                mxid=rs.getInt("mxid");
	                  
	            }
	        }
	           
	         
	        catch(Exception ex)
	        {
	            System.out.println("err="+ex.getMessage());
	             
	        }
	    }*/
	public boolean registration()
	    {
	        try
	        { 
	             DBConnector obj=new  DBConnector();
	            con=obj.connect();
	            csmt=con.prepareCall("{call insertProd(?,?,?,?,?,?,?,?,?,?,?,?)}");
	            csmt.setInt(1, prodId);
	            csmt.setString(2, title);
	            csmt.setString(3, desc);
	            csmt.setString(4, userid);
	            csmt.setString(5, coverphoto);
	            csmt.setString(6, dt);
	            csmt.setString(7, tm);
	            csmt.setString(8, prodType);
	            csmt.setString(9, availsts);
	            csmt.setDouble(10, quantity);
	            csmt.setDouble(11, price);
	            csmt.setString(12, edt);
	            
	             int n=csmt.executeUpdate();
	             
	             JavaFuns jf=new JavaFuns();          
	           
	            if(n>0)
	            {
	            	 
	            	
	                try{con.close();}catch(Exception ex){}
	                System.out.println("true");
	                return true;
	            }
	            else
	                return false;

	            } 
	        catch(Exception ex)
	        {
	            System.out.println("err="+ex.getMessage());
	            return false;
	        }
	    }
	
	public boolean updateQuan()
    {
        try
        { 
             DBConnector obj=new  DBConnector();
            con=obj.connect();
            csmt=con.prepareCall("{call updateProducts(?,?)}");
            csmt.setInt(1, prodId);
            csmt.setDouble(2, quantity);
              
             int n=csmt.executeUpdate(); 
            
            if(n>0)
            {
                try{con.close();}catch(Exception ex){}
                System.out.println("true");
                return true;
            }
            else
                return false;

            }
           
         
        catch(Exception ex)
        {
            System.out.println("err="+ex.getMessage());
            return false;
        }
    }
	public boolean updatePrice()
    {
        try
        { 
             DBConnector obj=new  DBConnector();
            con=obj.connect();
            csmt=con.prepareCall("{call updateProductPrice(?,?)}");
            csmt.setInt(1, prodId);
            csmt.setDouble(2, price);
              
             int n=csmt.executeUpdate(); 
            
            if(n>0)
            {
                try{con.close();}catch(Exception ex){}
                System.out.println("true");
                return true;
            }
            else
                return false;

            }
           
         
        catch(Exception ex)
        {
            System.out.println("err="+ex.getMessage());
            return false;
        }
    }
	public boolean deleteProd()
    {
        try
        { 
             DBConnector obj=new  DBConnector();
            con=obj.connect();
            csmt=con.prepareCall("{call deleteProducts(?)}");
            csmt.setInt(1, prodId); 
             int n=csmt.executeUpdate(); 
            
            if(n>0)
            {
                try{con.close();}catch(Exception ex){}
                System.out.println("true");
                return true;
            }
            else
                return false;

            }
           
         
        catch(Exception ex)
        {
            System.out.println("err="+ex.getMessage());
            return false;
        }
    }
}
