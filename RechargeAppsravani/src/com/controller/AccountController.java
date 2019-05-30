package com.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.AccountDao;
import com.model.Account;


/**
 * Servlet implementation class AccountController
 */
@WebServlet("/AccountController")
public class AccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/*
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  System.out.println("s1");
	    String s1=request.getParameter("mobileno");
		System.out.println("s1");
		String s2=request.getParameter("pass");
		String s3=request.getParameter("uname");
		String s4=request.getParameter("type_accno");
		String s5=request.getParameter("amt");
		int r=Integer.parseInt(s1);
		int acc=Integer.parseInt(s5);
		System.out.println("s1");
		Account a= new Account();
		a.setMobileno(r);
		a.setPass(s2);
		a.setUname(s3);
		a.setType_accno(s4);
		a.setAmt(acc);

	AccountDao db=new AccountDao();
	List<Account> lst=new LinkedList<Account>();
      
	lst.add(a);
	int i=db.saveData(lst);
	
	if(i>0)
	{

		response.sendRedirect("Success.jsp");
	}
	
	
}
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
