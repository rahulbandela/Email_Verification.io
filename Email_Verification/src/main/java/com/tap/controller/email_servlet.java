package com.tap.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.user.User;
import com.tap.verification.Verification;

@WebServlet("/email_servlet")
public class email_servlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	
	String email = req.getParameter("email");
	String pass = req.getParameter("pass");
	
	Verification ver =new Verification();
	String code =ver.getRandom();
	User user=new User();
	
	boolean test =ver.getRandom(user);
	
	if(test)
	{
		HttpSession session = req.getSession();
		session.setAttribute("authcode", user);
		resp.sendRedirect("verify.jsp");
	}
	
	
	
	
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}

	
}
