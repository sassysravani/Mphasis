package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.ha.backend.Sender;

import com.dao.AccountDao;
import com.model.Transaction;

/**
 * Servlet implementation class CheckBalControl
 */
@WebServlet("/CheckBalControl")
public class CheckBalControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckBalControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String s=request.getParameter("mob");
		int mob=Integer.parseInt(s);
		PrintWriter pw=response.getWriter();
		String option=request.getParameter("S");
		String selected=null;
		if(option.equalsIgnoreCase("AIRTEL"))
		{
			selected=option;
			//pw.println(selected);
		}
		else if(option.equalsIgnoreCase("BSNL"))
		{
			selected=option;
			//pw.println(selected);
		}
		else if(option.equalsIgnoreCase("IDEA"))
		{
			selected=option;
			//pw.println(selected);
		}
		else if(option.equalsIgnoreCase("JIO"))
		{
			selected=option;
			//pw.println(selected);
		}
		else if(option.equalsIgnoreCase("VODAFONE"))
		{
			selected=option;
			//pw.println(selected);
		}
		int amnt=Integer.parseInt(request.getParameter("amnt"));
		AccountDao ad=new AccountDao();
		int acBal=ad.getBal(mob);
		Transaction t=new Transaction();
		t.setMobno(mob);
		t.setMoney(amnt);
		t.setServicenam(selected);
		List<Transaction> lst=new ArrayList<>();
		List<Transaction> alst=new ArrayList<>();
		lst.add(t);
		int i=0;
		boolean b=false;
		if(amnt<acBal)
		{
			b=ad.alterAcc(mob, amnt);
			if(!b)
			{
				i=ad.savetran(lst);
				if(i>0)
				{
					//response.sendRedirect("Success.jsp");
					HttpSession session = request.getSession(true);
					alst=ad.show();
					if(lst!=null)
					{
						for(Transaction a:alst)
						//pw.println(a.getMobno()+""+a.getMoney()+""+a.getServicenam());
						session.setAttribute("data",alst);
						response.sendRedirect("ConformRecharge.jsp");
						//b=true;
					}	
					
					/*request.setAttribute("empList",lst);
					RequestDispatcher view = request.getRequestDispatcher("ConformRecharge.jsp");
					view.forward(request, response);*/
				}
				else
					pw.print("Invalid : Not saved in transaction table");
			}
			else
				pw.print("Balance is not updated");

			//response.sendRedirect("Continue.jsp");
			//RequestDispatcher rd=request.getRequestDispatcher("Continue.jsp");
			//rd.forward(request, response);
		}
		else
		{
			pw.print("Insufficient Balance");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
