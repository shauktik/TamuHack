package com.tamuhack.classes;

import java.io.IOException;
//import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ConnectFromUI")
public class ConnectFromUI extends HttpServlet{

	private static final long serialVersionUID = 102831973239L;
	public ConnectFromUI() {
        super();
    }
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException  {

			     String userId = req.getParameter("uName");
			     String password = req.getParameter("passwd");
			     System.out.println("User id: "+userId);
			     System.out.println("Password: "+password);
			     res.setContentType("text/plain");
			     //PrintWriter out = res.getWriter();
		           // out.println("Success");
		            //out.close();
			}

}
