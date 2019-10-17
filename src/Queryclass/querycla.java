package Queryclass;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jdbccon.jdbcclass;

public class querycla {
	
	private Connection con=jdbcclass.getConection();
	private PreparedStatement st=null;
    private ResultSet rs=null;
    RequestDispatcher rd= null;
    
	public querycla() {
		// TODO Auto-generated constructor stub
	}
	
	
	public void sessioncreatcus(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException{
		String username=  request.getParameter("username");
		
		//String query1= "Select  customer_id from customer where email=?";
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//out.print("<br><br><br><br><br><br><br><br>"+username);
		HttpSession session = request.getSession();
		session.setAttribute("session1",username);
		String uname=(String)session.getAttribute("session1");
		
		//st=con.prepareStatement(query1);
		//st.setString(1, username);
		//rs = st.executeQuery();
		//while(rs.next())
		//{
			//session.setAttribute("session",rs.getInt(1));
			
		//}
		//String uid=(String)(session.getAttribute("sess"));
		//int ID =(String)session.getAttribute("id");
		//out.print("<br><br><br><br><br><br>"+ ID);
		
	}
	public void sessioncreatadmin(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException{
	String username=  request.getParameter("username");
		


	//String query1= "Select  customer_id from customer where email=?";
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
	//out.print("<br><br><br><br><br><br><br><br>"+username);
	HttpSession session = request.getSession();
	session.setAttribute("session1",username);
	String uname=(String)session.getAttribute("session1");

	//st=con.prepareStatement(query1);
	//st.setString(1, username);
	//rs = st.executeQuery();
	//while(rs.next())
	//{
		//session.setAttribute("session",rs.getInt(1));
		
	//}
	//String uid=(String)(session.getAttribute("sess"));
	//int ID =(String)session.getAttribute("id");
	//out.print("<br><br><br><br><br><br>"+ ID);
		
	}
	public void sessioncreatope(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException{
	     String username=  request.getParameter("username");
		
		//String query1= "Select  customer_id from customer where email=?";
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//out.print("<br><br><br><br><br><br><br><br>"+username);
		HttpSession session = request.getSession();
		session.setAttribute("session1",username);
		String uname=(String)session.getAttribute("session1");
		
		//st=con.prepareStatement(query1);
		//st.setString(1, username);
		//rs = st.executeQuery();
		//while(rs.next())
		//{
			//session.setAttribute("session",rs.getInt(1));
			
		//}
		//String uid=(String)(session.getAttribute("sess"));
		//int ID =(String)session.getAttribute("id");
		//out.print("<br><br><br><br><br><br>"+ ID); 
		
	}
	

	
	
	public void login_insert(HttpServletRequest request) throws ClassNotFoundException, SQLException{
		
		
		
		String username=  request.getParameter("username");
		String pwd=  request.getParameter("password");
		String role=  request.getParameter("Role");
		String query = "insert into login values(?,?,?) ";
		
		
		st = con.prepareStatement(query);
		st.setString(1, username);
		st.setString(2, pwd);
		st.setString(3, role);
		
		
		rs = st.executeQuery();

	}
public void validate_login(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException{
		
		
		String username=  request.getParameter("username");
		String pwd=  request.getParameter("password");
		String role=  request.getParameter("Role");
		String query = "select * from login where USERNAME=? and PASSWORD=? and ROLE=?";
		//PrintWriter pw= response.getWriter(); 
		
		st = con.prepareStatement(query);
        st.setString(1, username);
	    st.setString(2, pwd);
		st.setString(3, role);
		rs = st.executeQuery();
		
		 if(rs.next()) {
		    
		 
	   		if(role.equals("Admin")) {
		    		rd=request.getRequestDispatcher("Adminhomepage.jsp");
	  				rd.include(request, response);
		    	}
		    	else if (role.equals("Operator")) {
		    		rd=request.getRequestDispatcher("OperatorHomePage.jsp");
	  				rd.include(request, response);
		    	}
		    	else if(role.equals("Customer")){
		    		System.out.println("in customer");
		    		rd=request.getRequestDispatcher("CustomerHomePage.jsp");
	  				rd.include(request, response);
		    	}
		 }    
		 else {
				System.out.println("Login failed");	
				//pw.println("Please enter valid credentials");
				rd=request.getRequestDispatcher("invalidlogin.jsp");
				rd.include(request, response);
			      }
	
}
	
	
	
	/*------------ All the sql methods --------------*/
public void create_operator(HttpServletRequest request,HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException{
	
	String First_Name =  request.getParameter("firstname");
	String Last_Name =  request.getParameter("lastname");
	String Email =  request.getParameter("email");
	String Phone_No =  request.getParameter("phonenum");
	String Shift_Time_Start =  request.getParameter("shift start time");
	String Shift_Time_End =  request.getParameter("shift end time");
	String Max_No_of_Customers =  request.getParameter("max no of customers");
	String Creation_Date =  request.getParameter("creationdate");
	String query = "insert into operator values(operator_id_seq.nextVal,?,?,?,?,?,?,?,?)";
	
	
	
	st = con.prepareStatement(query);
	st.setString(1, First_Name);
	st.setString(2, Last_Name);
	st.setString(3, Email);
	st.setString(4, Phone_No);
	st.setString(5, Shift_Time_Start);
	st.setString(6, Shift_Time_End);
	st.setInt(7, Integer.parseInt(Max_No_of_Customers));
	st.setString(8, Creation_Date );
	
	int i = st.executeUpdate();
	
	if(i>0) {
		rd=request.getRequestDispatcher("Adminhomepage.jsp");
		rd.include(request, response);
	}
	else
		System.out.println("operator not created");
	
  
	}
public void search_operator(HttpServletRequest request,HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException, ServletException{
	
	
	
	String Operator_Id =  request.getParameter("operatorid");
	String query = "select * from operator where operator_id =?";
	PrintWriter out = response.getWriter();
	
	
	st = con.prepareStatement(query);
	st.setInt(1, Integer.parseInt(Operator_Id));
	
	rs = st.executeQuery();
	
	if (rs.next()) {
		
		rd=request.getRequestDispatcher("viewoperator.jsp");
		rd.include(request, response);
		out.println("<hr><br><br>");
		out.print("<div align=\"center\"><table border=\"5\"> <table width=\"30%\"><tr><td>Operator_Id</td><td>" + rs.getInt(1)
        + "</td></tr>");
out.print("<tr><td>FirstName</th><td>	" + rs.getString(2) + "</td></tr>");
out.print("<tr><td>Last Name</td><td>   " + rs.getString(3) + "</td></tr>");
out.print("<tr><td>Email</td><td>    " + rs.getString(4) + "</td></tr>");
out.print("<tr><td>Phone No</td><td>   " + rs.getString(5) + "</td></tr>");
out.print("<tr><td>Shift Time Start</td><td>	" + rs.getString(6) + "</td></tr>");
out.print("<tr><td>Shift Time End</td><td>	" + rs.getString(7) + "</td></tr>");
out.print("<tr><td>Max no of Customers</td><td>	" + rs.getInt(8) + "</td></tr>");
out.print("<tr><td>Creation Date</td><td>	" + rs.getString(9));
		
	}
	
		
		
	

	
}
		
	public void update_operator(HttpServletRequest request,HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException{
			
		
			
			String Operator_Id =  request.getParameter("Operator_Id");
			String First_Name =  request.getParameter("first_name");
			String Last_Name =  request.getParameter("last_name");
			String Email =  request.getParameter("email");
			String Phone_No =  request.getParameter("contact");
			String Shift_Time_Start =  request.getParameter("start time");
			String Shift_Time_End =  request.getParameter("End time");
			String Max_No_of_Customers =  request.getParameter("max customers");
			String Creation_Date =  request.getParameter("creation date");
			String query = "update operator set first_name =?, last_name =?, "
					+ "email =?,phone_no =?,Shift_Time_Start=?,Shift_Time_End=?, Max_No_of_Customers=?"
					+ ",Creation_Date=? where operator_id =?";
			
			
			st = con.prepareStatement(query);
			
			st.setString(1, First_Name);
			st.setString(2, Last_Name);
			st.setString(3, Email);
			st.setString(4, Phone_No);
			st.setString(5, Shift_Time_Start);
			st.setString(6, Shift_Time_End);
			st.setString(7, Max_No_of_Customers);
			st.setString(8, Creation_Date);
			st.setInt(9, Integer.parseInt( Operator_Id));
			
			int i = st.executeUpdate();
			if(i>0) {
				rd=request.getRequestDispatcher("Adminhomepage.jsp");
				rd.include(request, response);
			}
			else
				System.out.println("operator not update");
			
		}

	public void delete_operator(HttpServletRequest request,HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException{
		
		
		
		String Operator_Id =  request.getParameter("retid");
		
		String query = "delete operator where operator_id =?";
		
		
		st = con.prepareStatement(query);
		st.setString(1, Operator_Id);
		
		int i = st.executeUpdate();
		
		if(i>0) {
			rd=request.getRequestDispatcher("Deletion_success_page.jsp");
			rd.include(request, response);
		}
		else
			System.out.println("operator not deleted");
		

	}
	
	public void customer_registration(HttpServletRequest request,HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException{
		String First_Name =  request.getParameter("firstname");
		String Last_Name =  request.getParameter("lastname");
		String Email =  request.getParameter("email");
		String Phone_No =  request.getParameter("phonenum");
		String Address =  request.getParameter("address");
		String Landmark =request.getParameter("landmark");
		String State =  request.getParameter("state");
		String City =  request.getParameter("city");
		String ZipCode =  request.getParameter("zipcode");
		String Creation_Date =  request.getParameter("creationdate");
	    String query = "insert into customer values(customer_id_seq.nextval,?,?,?,?,?,?,?,?,?,?,?,?)";

	    

	    
	    st = con.prepareStatement(query);
	   
	    st.setNull(1, java.sql.Types.INTEGER);
	    st.setString(2, First_Name);
	    st.setString(3, Last_Name);
	    st.setString(4, Email);
	    st.setString(5, Phone_No);
	    st.setString(6, Address);
	    st.setString(7, Landmark);
	    st.setString(8, State); 
	    st.setString(9, City);
	    st.setString(10, ZipCode);
	    st.setString(11, Creation_Date);
	    st.setNull(12, java.sql.Types.INTEGER);
	   
	    int i = st.executeUpdate();
	    
		if(i>0) {
			rd=request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
		else
			System.out.println("customer not created");
	}
	
	public void customer_create(HttpServletRequest request,HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException
	{
		
		String First_Name =  request.getParameter("firstname");
		String Last_Name =  request.getParameter("lastname");
		String Email =  request.getParameter("email");
		String Phone_No =  request.getParameter("phonenum");
		String Address =  request.getParameter("address");
		String Landmark =request.getParameter("landmark");
		String State =  request.getParameter("state");
		String City =  request.getParameter("city");
		String ZipCode =  request.getParameter("zipcode");
		String Creation_Date =  request.getParameter("creationdate");
	    String query = "insert into customer values(customer_id_seq.nextval,?,?,?,?,?,?,?,?,?,?,?,?)";

	    

	    
	    st = con.prepareStatement(query);
	   
	    st.setNull(1, java.sql.Types.INTEGER);
	    st.setString(2, First_Name);
	    st.setString(3, Last_Name);
	    st.setString(4, Email);
	    st.setString(5,Phone_No);
	    st.setString(6, Address);
	    st.setString(7, Landmark);
	    st.setString(8, State); 
	    st.setString(9, City);
	    st.setString(10, ZipCode);
	    st.setString(11, Creation_Date);
	    st.setNull(12, java.sql.Types.INTEGER);
	   
	    int i = st.executeUpdate();
	    
		if(i>0) {
			rd=request.getRequestDispatcher("Adminhomepage.jsp");
			rd.include(request, response);
		}
		else
			System.out.println("customer not created");
	    
	    
	}
	
	public void customer_create_operator(HttpServletRequest request,HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException
	{
		
		String First_Name =  request.getParameter("firstname");
		String Last_Name =  request.getParameter("lastname");
		String Email =  request.getParameter("email");
		String Phone_No =  request.getParameter("phonenum");
		String Address =  request.getParameter("address");
		String Landmark =request.getParameter("landmark");
		String State =  request.getParameter("state");
		String City =  request.getParameter("city");
		String ZipCode =  request.getParameter("zipcode");
		String Creation_Date =  request.getParameter("creationdate");
	    String query = "insert into customer values(customer_id_seq.nextval,?,?,?,?,?,?,?,?,?,?,?,?)";

	    

	    
	    st = con.prepareStatement(query);
	   
	    st.setNull(1, java.sql.Types.INTEGER);
	    st.setString(2, First_Name);
	    st.setString(3, Last_Name);
	    st.setString(4, Email);
	    st.setString(5,Phone_No);
	    st.setString(6, Address);
	    st.setString(7, Landmark);
	    st.setString(8, State); 
	    st.setString(9, City);
	    st.setString(10, ZipCode);
	    st.setString(11, Creation_Date);
	    st.setNull(12, java.sql.Types.INTEGER);
	   
	    int i = st.executeUpdate();
	    
		if(i>0) {
			rd=request.getRequestDispatcher("OperatorHomePage.jsp");
			rd.include(request, response);
		}
		else
			System.out.println("customer not created");
	    
	    
	}


	public void customer_search(HttpServletRequest request,HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException, ServletException
	{
		String Customer_Id =  request.getParameter("custId");
		
	    String query = "select * from customer where Customer_Id= ?";
	    PrintWriter out = response.getWriter();

	    

	    
	    st = con.prepareStatement(query);
	    st.setInt(1,Integer.parseInt(Customer_Id));
	    
	    rs=st.executeQuery();
	    if (rs.next()) {
			
			rd=request.getRequestDispatcher("customerview.jsp");
			rd.include(request, response);
			out.println("<hr><br><br>");
			out.print("<div align=\"center\"><table border=\"5\"> <table width=\"30%\"><tr><td>Customer_Id</td><td>" + rs.getInt(1)
            + "</td></tr>");
			out.print("<tr><td>Operator_Id</th><td>	" + rs.getInt(2) + "</td></tr>");
    out.print("<tr><td>FirstName</th><td>	" + rs.getString(3) + "</td></tr>");
    out.print("<tr><td>Last Name</td><td>   " + rs.getString(4) + "</td></tr>");
    out.print("<tr><td>Email</td><td>    " + rs.getString(5) + "</td></tr>");
    out.print("<tr><td>Phone No</td><td>   " + rs.getString(6) + "</td></tr>");
    out.print("<tr><td>Address</td><td>	" + rs.getString(7) + "</td></tr>");
    out.print("<tr><td>Landmark</td><td>	" + rs.getString(8) + "</td></tr>");
    out.print("<tr><td>State</td><td>	" + rs.getString(9) + "</td></tr>");
    out.print("<tr><td>City</td><td>	" + rs.getString(10) + "</td></tr>");
    out.print("<tr><td>ZipCode</td><td>	" + rs.getInt(11) + "</td></tr>");
    out.print("<tr><td>Creation Date</td><td>	" + rs.getString(12));
    out.print("<tr><td>Retailer_Id</td><td>	" + rs.getInt(13) + "</td></tr>");
			
		}
	  
	   
	}
	
	public void customer_search_operator(HttpServletRequest request,HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException, ServletException
	{
		String Customer_Id =  request.getParameter("custId");
		
	    String query = "select * from customer where Customer_Id= ?";
	    PrintWriter out = response.getWriter();

	    

	    
	    st = con.prepareStatement(query);
	    st.setInt(1,Integer.parseInt(Customer_Id));
	    
	    rs=st.executeQuery();
	    if (rs.next()) {
			
			rd=request.getRequestDispatcher("customerview.jsp");
			rd.include(request, response);
			out.println("<hr><br><br>");
			out.print("<div align=\"center\"><table border=\"5\"> <table width=\"30%\"><tr><td>Customer_Id</td><td>" + rs.getInt(1)
            + "</td></tr>");
			out.print("<tr><td>Operator_Id</th><td>	" + rs.getInt(2) + "</td></tr>");
    out.print("<tr><td>FirstName</th><td>	" + rs.getString(3) + "</td></tr>");
    out.print("<tr><td>Last Name</td><td>   " + rs.getString(4) + "</td></tr>");
    out.print("<tr><td>Email</td><td>    " + rs.getString(5) + "</td></tr>");
    out.print("<tr><td>Phone No</td><td>   " + rs.getString(6) + "</td></tr>");
    out.print("<tr><td>Address</td><td>	" + rs.getString(7) + "</td></tr>");
    out.print("<tr><td>Landmark</td><td>	" + rs.getString(8) + "</td></tr>");
    out.print("<tr><td>State</td><td>	" + rs.getString(9) + "</td></tr>");
    out.print("<tr><td>City</td><td>	" + rs.getString(10) + "</td></tr>");
    out.print("<tr><td>ZipCode</td><td>	" + rs.getInt(11) + "</td></tr>");
    out.print("<tr><td>Creation Date</td><td>	" + rs.getString(12));
    out.print("<tr><td>Retailer_Id</td><td>	" + rs.getInt(13) + "</td></tr>");
			
		}
	  
	   
	}
	
	public void customer_update(HttpServletRequest request,HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException
	{
		String Customer_Id =  request.getParameter("customerId");
		String Operator_Id =  request.getParameter("operatorId");
		String First_Name =  request.getParameter("firstname");
		String Last_Name =  request.getParameter("lastname");
		String Email =  request.getParameter("email");
		String Phone_No =  request.getParameter("phonenum");
		String Address =  request.getParameter("address");
		String Landmark = request.getParameter("landmark");
		String State =  request.getParameter("state");
		String City =  request.getParameter("city");
		String ZipCode =  request.getParameter("zipcode");
		String Creation_Date =  request.getParameter("creationdate");
		String Retailor_Id =  request.getParameter("retailerId");
	    String query = "update customer set Operator_Id= ?,First_Name=?,Last_Name=?,Email=?,Phone_No=?,Address=?,Landmark=?,State=?,City=?,Zipcode=?,Creation_Date=?, Retailer_Id=?"
	    		+ "where customer_id =?	";

	    

	    
	    st = con.prepareStatement(query);
	    
	    
	    st.setInt(1, Integer.parseInt(Operator_Id));
	    st.setString(2, First_Name);
	    st.setString(3, Last_Name);
	    st.setString(4, Email);
	    st.setString(5, Phone_No);
	    st.setString(6, Address);
	    st.setString(7, Landmark);
	    st.setString(8, State); 
	    st.setString(9, City);
	    st.setString(10, ZipCode);
	    st.setString(11, Creation_Date);
	    st.setInt(12, Integer.parseInt(Retailor_Id));
	    st.setInt(13, Integer.parseInt(Customer_Id));
	    
	    
	    int i = st.executeUpdate();
		if(i>0) {
			rd=request.getRequestDispatcher("Adminhomepage.jsp");
			rd.include(request, response);
		}
		else
			System.out.println("customer not update");
		
	}
	
	public void customer_update_operator(HttpServletRequest request,HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException
	{
		String Customer_Id =  request.getParameter("customerId");
		String Operator_Id =  request.getParameter("operatorId");
		String First_Name =  request.getParameter("firstname");
		String Last_Name =  request.getParameter("lastname");
		String Email =  request.getParameter("email");
		String Phone_No =  request.getParameter("phonenum");
		String Address =  request.getParameter("address");
		String Landmark = request.getParameter("landmark");
		String State =  request.getParameter("state");
		String City =  request.getParameter("city");
		String ZipCode =  request.getParameter("zipcode");
		String Creation_Date =  request.getParameter("creationdate");
		String Retailor_Id =  request.getParameter("retailerId");
	    String query = "update customer set Operator_Id= ?,First_Name=?,Last_Name=?,Email=?,Phone_No=?,Address=?,Landmark=?,State=?,City=?,Zipcode=?,Creation_Date=?, Retailer_Id=?"
	    		+ "where customer_id =?	";

	    

	    
	    st = con.prepareStatement(query);
	    
	    
	    st.setInt(1, Integer.parseInt(Operator_Id));
	    st.setString(2, First_Name);
	    st.setString(3, Last_Name);
	    st.setString(4, Email);
	    st.setString(5, Phone_No);
	    st.setString(6, Address);
	    st.setString(7, Landmark);
	    st.setString(8, State); 
	    st.setString(9, City);
	    st.setString(10, ZipCode);
	    st.setString(11, Creation_Date);
	    st.setInt(12, Integer.parseInt(Retailor_Id));
	    st.setInt(13, Integer.parseInt(Customer_Id));
	    
	    
	    int i = st.executeUpdate();
		if(i>0) {
			rd=request.getRequestDispatcher("OperatorHomePage.jsp");
			rd.include(request, response);
		}
		else
			System.out.println("customer not update");
		
	}


	public void customer_delete(HttpServletRequest request,HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException
	{
	String Customer_Id =  request.getParameter("custId");
		
		String query = "delete customer where Customer_Id =?";
		
		
		st = con.prepareStatement(query);
		st.setString(1, Customer_Id);
		
		int i = st.executeUpdate();
	    
		
		if(i>0) {
			rd=request.getRequestDispatcher("Deletion_success_page.jsp");
			rd.include(request, response);
		}
		else
			System.out.println("customer not deleted");
	}


	
	
	/*-----------------------------------------------*/
	
	

}
