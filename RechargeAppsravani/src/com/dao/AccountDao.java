package com.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.model.Account;
import com.model.Transaction;
public class AccountDao {
	
	Connection con=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	CallableStatement stmt = null;
	public static int tid=0;
	public Connection myConnection()
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","12345");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return con;
	}
	public int saveData(List<Account> lst)
	{
		System.out.println("dbsave1");
		int i=0;
		//Account a=lst.get(0);
		Account a=null;
		con=myConnection();
		try
		{
			System.out.println("d1");
			a=lst.get(0);
			System.out.println("hiii");
				ps=con.prepareStatement("insert into Account values(?,?,?,?,?)");
				System.out.println("d2");
				ps.setInt(1,a.getMobileno());
				ps.setString(2,a.getPass());
				ps.setString(3,a.getUname());
				ps.setString(4,a.getType_accno());
				ps.setDouble(5,a.getAmt());
				i = ps.executeUpdate();
				System.out.println("d3");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally
		{
			try
			{
				con.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		return i;
	}
	public int getBal(int mob)
	{
		int r=0;
		con=myConnection();
		try {
			ps=con.prepareStatement("select amnt from Account where mob=?");
			ps.setInt(1, mob);
			rs=ps.executeQuery();
			rs.next();
			r=rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return r;
	}
	
	public int savetran(List<Transaction> lst)
	{
		int i=0;
		//Account a=lst.get(0);
		Transaction a=null;
		tid++;
		con=myConnection();
		try
		
		
		{
			System.out.println("d11");
			a=lst.get(0);
			System.out.println("hii");
				ps=con.prepareStatement("insert into Transcation values(?,?,?,?)");
				System.out.println("d22");
				ps.setInt(1,tid);
				ps.setInt(2, a.getMobno());;
				ps.setInt(3,a.getMoney());
				ps.setString(4,a.getServicenam());
				i = ps.executeUpdate();
				System.out.println("d33");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally
		{
			try
			{
				con.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		return i;

	}
	
	public boolean alterAcc(int mob,int money)
	{
		boolean b=false;
		con=myConnection();
		try {
			stmt = con.prepareCall("{call updateTranscation(?,?)}");
			stmt.setInt(1,mob);
			stmt.setInt(2,money);
			b= stmt.execute();
			System.out.println(b);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return b;
		
		
	}
	public List<Transaction> show()
	{
	con =myConnection();
	List<Transaction> alst=null;
	
	try{
		PreparedStatement ps=con.prepareStatement("select * from Transcation ");
		ResultSet rs=ps.executeQuery();
		alst=new ArrayList<>();
		while(rs.next())
		{
			System.out.println("d1");
			System.out.println(rs.getInt(1)+"\t"+rs.getInt(2)+"\t"+rs.getInt(3)+"\t"+rs.getString(4));
			Transaction u = new Transaction();
			u.setTid(rs.getInt(1));
			u.setMobno(rs.getInt(2));
			u.setMoney(rs.getInt(3));
			u.setServicenam(rs.getString(4));
			alst.add(u);
			System.out.println("d2");
		}
	}
		catch(SQLException e){
			
			
		}
		return alst;
	
}
	
	

}
