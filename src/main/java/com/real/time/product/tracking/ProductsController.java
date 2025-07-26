package com.real.time.product.tracking;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import jakarta.servlet.ServletRequest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
 
import models.Cart;
import models.JavaFuns;
import models.Login;
import models.MyOrders;
import models.Orders;
import models.Pass;
import models.Products;
import models.ProductsList;
import models.PurchasedProducts; 
import models.Transactions;
import models.Transactions1;
import models.UserReg; 
import services.Mail; 
import services.RandomString;

@Controller
public class ProductsController {
	@RequestMapping("/home")
	public String myspring()
	{
		return "index.jsp";
	}
	@RequestMapping("/admin")
	public String admin()
	{
		return "admin.jsp";
	}
	@RequestMapping("/frompython1")
	public ModelAndView frompython1(HttpServletRequest request) {
		ModelAndView mv=new ModelAndView();
	 	String sts=request.getParameter("sts").toString().trim() ;
		if(sts.equals("success"))
			 mv.setViewName("Success.jsp?type=DsTrained");
		else
			 mv.setViewName("Failure.jsp");
		mv.addObject("activity","DsTrained");
		 return mv;
	}
	@RequestMapping("/retailer")
	public String retailer()
	{
		return "retailer.jsp";
	}
	@RequestMapping("/FromPythonPred")
	public ModelAndView FromPythonPred(HttpServletRequest request) {
		ModelAndView mv=new ModelAndView();
	 	String sts=request.getParameter("sts").toString().trim() ;
		if(sts.equals("success"))
		{
			String cate=request.getParameter("cate").toString().trim() ;
			mv.setViewName("viewRetailer11?cate="+cate);
		}
		else
			 mv.setViewName("Failure.jsp");
		mv.addObject("activity","prodMoreReg");
		 return mv;
	}
	@RequestMapping("/forgot")
	public String forgot()
	{
		return "Forgot.jsp";
	}
	@RequestMapping("/ChangePass")
	public String ChangePass()
	{
		return "ChangePass.jsp";
	}
	@RequestMapping("/viewCategories")
	@SessionScope
	public ModelAndView viewCategories() {
		
		List<ProductsList> lst = new ArrayList<ProductsList>();
		ProductsList vs = new ProductsList();
		lst=vs.getProdTypeList();
		ModelAndView mv=new ModelAndView();
		mv.addObject("std",lst);
		mv.setViewName("ViewProductsList.jsp");
		return mv;
	}
	@RequestMapping("/RegCategory")
	public ModelAndView RegCategory(ProductsList stu,ServletRequest request)
	{
		ModelAndView mv=new ModelAndView();
		 
		 try {
			  
		 
			 String st=stu.RegCategory();
				if(st.equals("success"))
					mv.setViewName("Success.jsp?type=CateReg");
				else
					mv.setViewName("Failure.jsp?type=CateReg");
		 }
		 catch (Exception e) {
			// TODO: handle exception
			 mv.setViewName("Failure.jsp");
		} 
		 mv.addObject("activity","CateReg");
		 return mv;
		
	}	
	@RequestMapping("/uploadPart")
	public String uploadPart()
	{
		return "UploadProd.jsp";
	}
	@RequestMapping("/passRecoveryOTPAuth")
	public ModelAndView passRecoveryOTPAuth(UserReg user)
	{
		ModelAndView mv=new ModelAndView();
		try {
			if(user.getSentOTP().equals(user.getOtp()))
			{
				String pass=RandomString.getAlphaNumericString(8);
				user.setPass(pass);
				if(user.updatePass())
				{
					
				}
				
				
			    mv.setViewName("Success.jsp?type=passEmail");
			    
			    Mail mail=new Mail();
			    String msg="Dear "+user.getName()+" \n Your password has been reset to "+pass;
			    System.out.println("pass="+pass);
			    try
			    {
			    	if(mail.sendMail(msg,user.getEmail(), "New password"))
			    	{
			    		
			    	}
			    }
			    catch (Exception e) {
					// TODO: handle exception
				}
			}
			else
			{
				mv.setViewName("Failure.jsp?type=passEmail");
			}
			
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
	    return mv;
	}
	@RequestMapping("/passRecovery")
	public ModelAndView passRecovery(UserReg user)
	{
		ModelAndView mv=new ModelAndView();
		try {
			if(user.useridAuth())
			{
				String otp=RandomString.getAlphaNumericString(4);
				
			    mv.setViewName("ForgotOTP.jsp");
			    mv.addObject("userid",user.getUserid());
			    mv.addObject("otp",otp);
			    mv.addObject("email",user.getEmail());
			    Mail mail=new Mail();
			    String msg="Dear "+user.getName()+" \n Your one time password is "+otp;
			    System.out.println("otp="+otp);
			    try
			    {
			    	if(mail.sendMail(msg,user.getEmail(), "One Time Password"))
			    	{
			    		
			    	}
			    }
			    catch (Exception e) {
					// TODO: handle exception
				}
			}
			else
			{
				mv.setViewName("Failure.jsp?type=Auth");
			}
			
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
	    return mv;
	}
	 
	@RequestMapping("/ChangePassService")
	public String ChangePassService(Pass eobj,HttpSession ses)
	{ 
		 try
		 { 
			 JavaFuns jf=new JavaFuns();
			 Vector v=jf.getValue("select userid from users where userid='"+ses.getAttribute("userid").toString().trim()+"' and pass='"+eobj.getCurrentpass()+"'", 1);
			 if(v.size()>0)
			 {
			 eobj.setUserid(ses.getAttribute("userid").toString().trim());
			 if(eobj.changePassword())
			 { 
				 return "Success.jsp?type=ChangePass";
			 }
			 else
			 { 
				 return "Failure.jsp?type=ChangePass";
			 }
			 }
			 else
			 {
				 return "Failure.jsp?type=ChangePass";
			 }
		 }
		 catch (Exception e) {
			// TODO: handle exception
			 System.out.println("err="+e.getMessage());
			 return("Failure.jsp?type=Auth");
		}
		 
	}
	@RequestMapping("/user")
	public String user()
	{
		return "UploadProdImg.jsp";
	}
	@RequestMapping("/customer")
	public String customer()
	{
		return "UploadProdImg.jsp";
	}
	@RequestMapping("/registration")
	public String registration()
	{
		return "Registration.jsp";
	}
	@RequestMapping("/Cities")
	public String cities()
	{
		return "Cities.jsp";
	}
	@RequestMapping("/regProdPer")
	public String regProdPer()
	{
		return "regProdPer.jsp";
	}
	@RequestMapping("/RegProductPer")
	public String RegProductPer(HttpServletRequest request)
	{
		try
		{
			JavaFuns jf=new JavaFuns();
			Vector v=jf.getValue("select ifnull(max(pid),1000)+1 as mxid from prodPercent", 1);
			if(jf.execute("delete from prodPercent where utype='"+request.getParameter("utype").trim()+"'"))
			{
				
			}
			
			if(jf.execute("insert into prodPercent values("+Integer.parseInt(v.elementAt(0).toString().trim())+",'"+request.getParameter("utype").trim()+"',"+request.getParameter("percent").trim()+")"))
			{
				
			}
			
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return "Success.jsp?type=ProdPerReg";
	}
	@RequestMapping("/ProcessOrder")
	public String ProcessOrder(HttpServletRequest request,HttpSession ses)
	{
    	 
    	try {
    	  JavaFuns jf=new JavaFuns();
    	  if(jf.execute("update orders set orderstatus='processed' where orderno="+request.getParameter("orderNo").trim()))
    	  {
    		  
    	  }
    	  
    	}
    	catch (Exception e) {
    		System.out.println("err in place order="+e.getMessage());
			// TODO: handle exception
		}
    	return "Success.jsp?type=OrderProcess";
	}
	 @RequestMapping("/PaidOrder")
	public String PaidOrder(Orders ord,HttpServletRequest request,HttpSession ses)
	{
    	 
    	try {
    	  JavaFuns jf=new JavaFuns();
    	 
    		  
    		  Transactions obj=new Transactions();
    		  obj.setUserid(request.getParameter("userid").trim());
    		  obj.setSellerUserid(ord.getSellerUserid());
    		  obj.setSellerName(ord.getSellerUsernm());
    		  //CallMinnerAPI miner=new CallMinnerAPI();
    		 // APIManager1 miner=new  APIManager1();
    		  Vector v=jf.getValue("select productid,productname,quantity,price,date,userid from orderedprods where orderno="+ord.getOrderno() , 6);
    		  String transids="";
    		  for(int i=0;i<v.size();i=i+6)
    		  {
    			 obj.setProdId(Integer.parseInt(v.elementAt(i).toString().trim()));
    			 obj.setProdName(v.elementAt(i+1).toString().trim());
    			 obj.setPrice(Double.parseDouble(v.elementAt(i+3).toString().trim()));
    			 obj.setDt(v.elementAt(i+4).toString().trim());
    			 obj.setUserid(v.elementAt(i+5).toString().trim());
    			//  String result=miner.insertTrans(obj);
    			  PurchasedProducts purchase=new PurchasedProducts();
        		  purchase.setProdId(obj.getProdId());
        		  purchase.setUserid(obj.getUserid());
        		 // Vector v1=jf.getValue("select transId from products where prodId="+obj.getProdId(), 1);
        		//  System.out.println("trans="+v1.elementAt(0).toString().trim());
 purchase.setTransid("0");
        		  purchase.setTransid("0" );
        		  purchase.setProdName(obj.getProdName());
        		  if(purchase.registration())
        		  {
        			  
        		  }
    			 // System.out.println("result="+result);
    			  
    		  }
    		  System.out.println("transids="+transids);
    		  
    		  if(jf.execute("update orders set orderstatus='paid', paymentsts='paid' where orderno="+request.getParameter("orderno").trim()))
        	  {   
        	  }
    	  
    	}
    	catch (Exception e) {
    		System.out.println("err in place order="+e.getMessage());
			// TODO: handle exception
		}
    	return "Success.jsp?type=OrderProcess";
	} 
	@RequestMapping("/MyOrders")
	public ModelAndView MyOrders(HttpServletRequest request,HttpSession ses)
	{
    	ModelAndView mv=new ModelAndView();
    	
    	try {
    	 MyOrders order=new MyOrders();
    	 order.setUserid(ses.getAttribute("userid").toString().trim());
    	 order.getMyOrders("all");
    	 List<MyOrders> lstorder=new ArrayList<MyOrders>();
    	 lstorder=order.getLstorders();
    	 mv.setViewName("orders.jsp");
    	 mv.addObject("lst",lstorder);
    	}
    	catch (Exception e) {
    		System.out.println("err in place order="+e.getMessage());
			// TODO: handle exception
		}
    	return mv;
	}
	@RequestMapping("/RegProduct")
	public ModelAndView RegProduct(Products stu,ServletRequest request)
	{
		ModelAndView mv=new ModelAndView();
		 try
		 {MultipartFile file=stu.getFile();
		 String filepath=request.getServletContext().getRealPath("/")+"/Uploads/";
		 
		 
		 System.out.println("path="+filepath);
		 File f=new File(filepath);
		 f.mkdir();
		  
		 try {
			 JavaFuns jf=new JavaFuns();
		
			  int pid=jf.FetchMax("prodId", "products");
			  stu.setProdId(pid);
			 String fileName=pid+"."+ file.getOriginalFilename().split("\\.")[1];
			 file.transferTo(new File(filepath+"/"+fileName));
			 stu.setPath(fileName);
			  
				if(stu.registration())
					mv.setViewName("Success.jsp?type=ProdReg");
				else
					mv.setViewName("Failure.jsp");
		 }
		 catch (Exception e) {
			// TODO: handle exception
			 mv.setViewName("Failure.jsp");
		}}
		 catch (Exception e) {
				// TODO: handle exception
			 mv.setViewName("Failure.jsp");
			}
		 mv.addObject("activity","ProdReg");
		 return mv;
		
	}
	@RequestMapping("/viewOrderDetails")
	public ModelAndView viewOrderDetails(HttpServletRequest request,HttpSession ses)
	{
    	ModelAndView mv=new ModelAndView();
    	
    	try {
    	  Orders order=new  Orders();
    	  order.getOrderDetails(Integer.parseInt(request.getParameter("orderNo").trim()));
    	 List<Orders> lstorder=new ArrayList<Orders>();
    	 lstorder=order.getLstorders();
    	 mv.setViewName("OrderDetails.jsp");
    	 mv.addObject("lst",lstorder);
    	}
    	catch (Exception e) {
    		System.out.println("err in place order="+e.getMessage());
			// TODO: handle exception
		}
    	return mv;
	}
	@RequestMapping("/PendingOrders")
	public ModelAndView PendingOrders(HttpServletRequest request,HttpSession ses)
	{
    	ModelAndView mv=new ModelAndView();
    	
    	try {
    	  MyOrders order=new  MyOrders();
    	  order.getPendingOrders(ses.getAttribute("userid").toString().trim());
    	 List<MyOrders> lstorder=new ArrayList<MyOrders>();
    	 lstorder=order.getLstorders();
    	 mv.setViewName("PendingOrders.jsp");
    	 mv.addObject("lst",lstorder);
    	}
    	catch (Exception e) {
    		System.out.println("err in place order="+e.getMessage());
			// TODO: handle exception
		}
    	return mv;
	}
	@RequestMapping("/ProcessedOrders")
	public ModelAndView ProcessedOrders(HttpServletRequest request,HttpSession ses)
	{
    	ModelAndView mv=new ModelAndView();
    	
    	try {
    	  MyOrders order=new  MyOrders();
    	  order.getProcessedOrders(ses.getAttribute("userid").toString().trim());
    	 List<MyOrders> lstorder=new ArrayList<MyOrders>();
    	 lstorder=order.getLstorders();
    	 mv.setViewName("ProcessedOrders.jsp");
    	 mv.addObject("lst",lstorder);
    	}
    	catch (Exception e) {
    		System.out.println("err in place order="+e.getMessage());
			// TODO: handle exception
		}
    	return mv;
	}
	@RequestMapping("/PaidOrders")
	public ModelAndView PaidOrders(HttpServletRequest request,HttpSession ses)
	{
    	ModelAndView mv=new ModelAndView();
    	
    	try {
    	  MyOrders order=new  MyOrders();
    	  order.getPaidOrders(ses.getAttribute("userid").toString().trim());
    	 List<MyOrders> lstorder=new ArrayList<MyOrders>();
    	 lstorder=order.getLstorders();
    	 mv.setViewName("PaidOrders.jsp");
    	 mv.addObject("lst",lstorder);
    	}
    	catch (Exception e) {
    		System.out.println("err in place order="+e.getMessage());
			// TODO: handle exception
		}
    	return mv;
	}
	@RequestMapping("/UploadProduct")
	public ModelAndView UploadProduct(HttpServletRequest request)
	{
		ModelAndView mv=new ModelAndView();
		String transid=request.getParameter("transid").trim();
		mv.setViewName("UploadProduct.jsp");
		mv.addObject("transid",transid.trim());
		return mv;
	}
	@RequestMapping("viewRetailer")
	public ModelAndView viewRetailer(HttpSession ses)
	{
		
		List<UserReg> lst = new ArrayList<UserReg>();
		UserReg obj=new UserReg();
		obj.setUtype("retailer");
		 obj.getUsers();
		 lst=obj.getLstuser();

		ModelAndView mv = new ModelAndView();

		mv.setViewName("viewRetailer.jsp");
		mv.addObject("lst", lst); 
		return mv;
		 
	}
	@RequestMapping("viewRetailer12")
	public ModelAndView viewRetailer12(HttpSession ses,HttpServletRequest request)
	{
		
		List<UserReg> lst = new ArrayList<UserReg>();
		UserReg obj=new UserReg();
		obj.setUserid(request.getParameter("userid"));
		obj.setUtype("retailer");
		 obj.getUsers1();
		 lst=obj.getLstuser();

		ModelAndView mv = new ModelAndView();

		mv.setViewName("viewRetailer.jsp");
		mv.addObject("lst", lst); 
		return mv;
		 
	}
	@RequestMapping("viewRetailer11")
	public ModelAndView viewRetailer11(HttpServletRequest request)
	{
		
		List<Products> lst = new ArrayList<Products>();
		Products obj=new Products();
		//obj.setUtype("retailer");
		 obj.getRetailers(request.getParameter("cate").toString().trim());
		 lst=obj.getLstprod();

		ModelAndView mv = new ModelAndView();

		mv.setViewName("viewRetailer11.jsp");
		mv.addObject("lst", lst); 
		return mv;
		 
	}
	@RequestMapping("viewRetailer1")
	public ModelAndView viewRetailer1(HttpSession ses)
	{
		
		List<UserReg> lst = new ArrayList<UserReg>();
		UserReg obj=new UserReg();
		obj.setUtype("retailer");
		 obj.getUsers();
		 lst=obj.getLstuser();

		ModelAndView mv = new ModelAndView();

		mv.setViewName("viewRetailer1.jsp");
		mv.addObject("lst", lst); 
		return mv;
		 
	}
	@RequestMapping("/viewCustomers")
	public ModelAndView viewCustomer(HttpSession ses)
	{
		
		List<UserReg> lst = new ArrayList<UserReg>();
		UserReg obj=new UserReg();
		obj.setUtype("user");
		 obj.getUsers();
		 lst=obj.getLstuser();

		ModelAndView mv = new ModelAndView();

		mv.setViewName("viewCust.jsp");
		mv.addObject("lst", lst); 
		return mv;
		 
	}
	@RequestMapping("/ChangeQuantity")
	public ModelAndView ChangeQuantity(HttpSession ses,Products obj)
	{
		
		List<Products> lst = new ArrayList<Products>();
		obj.updateQuan(); 
		 
		ModelAndView mv = new ModelAndView();

		mv.setViewName("Success.jsp?type=ProdUpdate");
		 
		return mv;
		 
	}
	@RequestMapping("/ChangePrice")
	public ModelAndView ChangePrice(HttpSession ses,Products obj)
	{
		
		List<Products> lst = new ArrayList<Products>();
		obj.updatePrice(); 
		 
		ModelAndView mv = new ModelAndView();

		mv.setViewName("Success.jsp?type=ProdUpdate");
		 
		return mv;
		 
	}
	 @RequestMapping("/datasetInsrtPython")
		public ModelAndView datasetInsrtPython(HttpServletRequest request) {
			ModelAndView mv=new ModelAndView();
		 	String sts=request.getParameter("sts").toString().trim() ;
			if(sts.equals("success"))
				 mv.setViewName("Success.jsp?type=prodReg");
			else
				 mv.setViewName("Failure.jsp?type=prodReg");
			mv.addObject("activity","prodReg");
			 return mv;
		}
	@RequestMapping("/viewProducts")
	public ModelAndView viewFarmerProducts(HttpSession ses)
	{
		
		List<Products> lst = new ArrayList<Products>();
		Products obj=new Products();
		obj.setUserid(ses.getAttribute("userid").toString().trim());
		 obj.getProducts();
		 lst=obj.getLstprod();

		ModelAndView mv = new ModelAndView();

		mv.setViewName("ViewProducts.jsp");
		mv.addObject("lst", lst); 
		return mv;
		 
	}
	@RequestMapping("/ShowCart")
	public ModelAndView ShowCart(Cart cart,HttpSession ses)
	{
		ModelAndView mv=new ModelAndView(); 
		cart.setUserid(ses.getAttribute("userid").toString().trim());
		 cart.getCartDetails();
			List<Cart> lstcart=cart.getLstcart();
			mv.addObject("lst",lstcart);
			mv.setViewName("Cart.jsp");
		 
	//mv.addObject("branch",request.getParameter("branch").toString().trim());
			return mv;
		 
	}
	@RequestMapping("/AddToCart")
	public ModelAndView addToCart(Cart cart,HttpSession ses,HttpServletRequest request)
	{
		ModelAndView mv=new ModelAndView(); 
		cart.setUserid(ses.getAttribute("userid").toString().trim());
		
		if(!cart.checkProductInCartORNOT(cart.getProdId(), ses.getAttribute("userid").toString().trim()))
		{
			if(cart.addToCart())
			{
				// JavaFuns jf=new JavaFuns();
		    	 // if(jf.execute("update products set searchCount=searchCount+1 where id="+cart.getProdId()))
		    	//  {
		    		  
		    	//  }
				
			}	
			List<Products> lst = new ArrayList<Products>();
			Products obj=new Products();
			obj.setUserid(request.getParameter("userid1").toString().trim());
			 obj.getProducts();
			 lst=obj.getLstprod();

		 
			mv.addObject("lst", lst);
				 System.out.println("list size="+lst.size());
				mv.addObject("stf",lst);
				mv.addObject("subcategory","NA");
				mv.addObject("category","NA");
				mv.addObject("availquan",request.getParameter("availquan").toString().trim());
				mv.setViewName(cart.getPage());
		}
		else
		{
			
			cart.getCartDetails();
			List<Cart> lstcart=cart.getLstcart();
			mv.addObject("lst",lstcart);
			mv.setViewName("Cart.jsp");
		}
	//mv.addObject("branch",request.getParameter("branch").toString().trim());
			return mv;
		 
	}
	@RequestMapping("/PlaceOrder")
	public String PlaceOrder(HttpServletRequest request,HttpSession ses)
	{
    	try {
    		JavaFuns jf=new JavaFuns();
    	 Orders order=new Orders();
    	 Vector v1=jf.getValue("select prodId,quantity from cart where userid='"+ses.getAttribute("userid").toString().trim()+"'",2);
    	 for(int i=0;i<v1.size();i=i+2)
    	 {
    		 if(jf.execute("update products set availQuantity=availQuantity-"+v1.elementAt(i+1).toString().trim()+" where prodId="+v1.elementAt(i).toString().trim()))
     	    {}
    	 }
    	 Vector v=jf.getValue("select distinct(sellerUserid),sellerUserName,sellerType  from cart where userid='"+ses.getAttribute("userid").toString().trim()+"'",3);
    	 for(int i=0;i<v.size();i=i+3)
    	 {
    		 order.setUserid(ses.getAttribute("userid").toString().trim());
    		 order.setSellerUserid(v.elementAt(i).toString().trim());
    		 order.setSellerUsernm(v.elementAt(i+1).toString().trim());
    		 order.setSellerUtype(v.elementAt(i+2).toString().trim());
    	   	 if(order.placeOrder()) {}
    	    	 
    	    	}
    	 }
    	 
    	catch (Exception e) {
    		System.out.println("err in place order="+e.getMessage());
			// TODO: handle exception
		}
    	return "Success.jsp?type=placeOrder";
	}
	/*
	@RequestMapping("/viewDetails")
	public ModelAndView viewDetails(HttpSession ses,HttpServletRequest request)
	{
		JavaFuns jf=new JavaFuns();
		List<Transactions> lst = new ArrayList<Transactions>();
		   
		Vector v=jf.getValue("select transid from products where prodId="+Integer.parseInt(request.getParameter("prodId").toString().trim()),1);
		//CallMinnerAPI api=new CallMinnerAPI();
		APIManager1 api=new APIManager1();
		Param param=new Param();
		param.setIds(v.elementAt(0).toString().trim());
		Transactions obj= api.getTransactions(param);
		Transactions1 obj1=new Transactions1();
		ModelAndView mv = new ModelAndView();
		List<Transactions1> lst1 = new ArrayList<Transactions1>();
		lst1=obj1.getTransactions(obj.getLsttrans());	

		mv.setViewName("viewProdHistory.jsp");
		mv.addObject("lst", lst1); 
		mv.addObject("prodId",Integer.parseInt(request.getParameter("prodId").toString().trim()));
		return mv;
		 
	}*/
	@RequestMapping("/viewProducts11")
	public ModelAndView viewProducts11(HttpSession ses,HttpServletRequest request)
	{
		
		List<Products> lst = new ArrayList<Products>();
		Products obj=new Products();
		//obj.setUserid(request.getParameter("userid").toString().trim());
		//obj.setProdType(request.getParameter("category").toString().trim());
		 obj.getProducts11();
		 lst=obj.getLstprod();

		ModelAndView mv = new ModelAndView();

		mv.setViewName("viewProd11.jsp");
		mv.addObject("lst", lst); 
		return mv;
		 
	}
	@RequestMapping("/GetProds")
	public ModelAndView GetProds(HttpSession ses,HttpServletRequest request)
	{
		
		List<Products> lst = new ArrayList<Products>();
		Products obj=new Products();
		//obj.setUserid(request.getParameter("userid").toString().trim());
		//obj.setProdType(request.getParameter("category").toString().trim());
		 obj.getProducts12(request.getParameter("searchText").toString().trim());
		 lst=obj.getLstprod();

		ModelAndView mv = new ModelAndView();

		mv.setViewName("viewProd12.jsp");
		mv.addObject("lst", lst); 
		return mv;
		 
	}

	@RequestMapping("/ViewProducts1")
	public ModelAndView ViewProducts1(HttpSession ses,HttpServletRequest request)
	{
		
		List<Products> lst = new ArrayList<Products>();
		Products obj=new Products();
		obj.setUserid(request.getParameter("userid").toString().trim());
		obj.setProdType(request.getParameter("category").toString().trim());
		 obj.getProducts1();
		 lst=obj.getLstprod();

		ModelAndView mv = new ModelAndView();

		mv.setViewName("viewProd1.jsp");
		mv.addObject("lst", lst); 
		return mv;
		 
	}
	@RequestMapping("/RemoveItem")
	public ModelAndView RemoveItem(Cart cart,HttpSession ses)
	{
		ModelAndView mv=new ModelAndView(); 
		if(cart.removeItems())
		{
			
		}
		cart.setUserid(ses.getAttribute("userid").toString().trim());
		 cart.getCartDetails();
			List<Cart> lstcart=cart.getLstcart();
			mv.addObject("lst",lstcart);
			mv.setViewName("Cart.jsp");
		 
	//mv.addObject("branch",request.getParameter("branch").toString().trim());
			return mv;
		 
	}
	@RequestMapping("/updateCart")
	public ModelAndView updateCart(HttpServletRequest request, HttpSession ses)
	{
		Cart cart=new Cart();
		int cartid=Integer.parseInt(request.getParameter("cartid").toString());
		int quant=Integer.parseInt(request.getParameter("quan").toString());
		cart.setCartid(cartid);
		cart.setQuantity(quant);
		ModelAndView mv=new ModelAndView(); 
		if(cart.updateItems())
		{
			
		}
		cart.setUserid(ses.getAttribute("userid").toString().trim());
		 cart.getCartDetails();
			List<Cart> lstcart=cart.getLstcart();
			mv.addObject("lst",lstcart);
			mv.setViewName("cartAjax.jsp");
		 System.out.println("in cart ajax");
	//mv.addObject("branch",request.getParameter("branch").toString().trim());
			return mv;
		 
	}
	@RequestMapping("/datasetMorePhotosPython")
	public ModelAndView datasetMorePhotosPython(HttpServletRequest request) {
		ModelAndView mv=new ModelAndView();
	 	String sts=request.getParameter("sts").toString().trim() ;
		if(sts.equals("success"))
			 mv.setViewName("Success.jsp?type=prodMoreReg");
		else
			 mv.setViewName("Failure.jsp");
		mv.addObject("activity","prodMoreReg?type=prodMoreReg");
		 return mv;
	}
	@RequestMapping("/viewMoreParts")
	@SessionScope
	public ModelAndView viewMorePartsviewMoreParts(HttpSession ses,HttpServletRequest req) {
		int partId=Integer.parseInt(req.getParameter("partId"));
		List<Products> lst = new ArrayList<Products>();
		Products vs = new Products();
		lst=vs.getMoreProdPhotosList(partId);
		ModelAndView mv=new ModelAndView();
		mv.addObject("std",lst);
		System.out.println("lst="+lst.size());
		mv.setViewName("ViewMoreProdPhotos.jsp");
		return mv;
	}
	@RequestMapping("/uploadMoreParts")
	public ModelAndView uploadMoreParts(HttpSession ses,HttpServletRequest request)
	{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("UploadMoreParts.jsp");
		mv.addObject("partId",request.getParameter("partId").toString().trim());
		mv.addObject("title",request.getParameter("title").toString().trim());
		mv.addObject("category",request.getParameter("category").toString().trim());
		return mv;
		
	}
	@RequestMapping("RegUser")
	public String RegUser(UserReg obj)
	{
		 try
		 {
			 if(obj.registration() )
			 {
				 
				 return "Success.jsp?type=RegUser";
			 }
			 else
			 { 
				 return "Failure.jsp?type=RegUser";
			 }
		 }
		 catch (Exception e) {
			// TODO: handle exception
			 System.out.println("err="+e.getMessage());
			 return("Failure.jsp?type=RegUser");
		}
	}
	@RequestMapping("/login")
	public String login(HttpServletRequest request)
	{
		 Login obj=new Login();
		 try
		 {
			 jakarta.servlet.http.HttpSession ses=request.getSession(true);
			 
			 if(obj.chkAuthentication(request.getParameter("txtuserid").trim(), request.getParameter("txtpass").trim()))
			 {
				 ses.setAttribute("userid", obj.getUserid());
				 System.out.println("userid="+obj.getUserid());
				 System.out.println("userid="+obj.getuType());
				 System.out.println("userid="+obj.getUserName());
				 ses.setAttribute("utype", obj.getuType());
				 ses.setAttribute("email", obj.getEmail());
				 ses.setAttribute("username", obj.getUserName());
				 return obj.getuType()+".jsp";
			 }
			 else
			 { 
				 return "Failure.jsp?type=Auth";
			 }
		 }
		 catch (Exception e) {
			// TODO: handle exception
			 System.out.println("err="+e.getMessage());
			 return("Failure.jsp?type=Auth");
		}
		 
	}
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
        session.invalidate();
		return "Logout.jsp";
	}
}
