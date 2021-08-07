package com.rs.fer.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rs.fer.bean.Address;
import com.rs.fer.bean.User;
import com.rs.fer.service.impl.FERServiceImpl;
import com.rs.fer.service1.FERService;
import com.rs.fer.util.LayoutUtil;

@WebServlet("/displayAddressInfo")
public class DisplayAddressInfoServlet extends HttpServlet{
	FERService ferService = null;
	@Override
	public void init() throws ServletException {
		ferService = new FERServiceImpl();

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		int userId = Integer.parseInt(session.getAttribute("userId").toString());

		User user=(User)session.getAttribute("user");
		
		user.setEmail(request.getParameter("email"));
		user.setMobile(request.getParameter("mobile"));
		
		//session.setAttribute("user", user);
		Address address=user.getAddress();


		PrintWriter out = response.getWriter();

		LayoutUtil.displayHeaderAndLeftFrame(request, response, out, session.getAttribute("username"));
		
		out.println("<table border='1' align='center' height='50px' width=60px>");
		out.println("<tr>");

		out.println("<td colspan='6' align='center'>Address Info</td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td>Line1</td>");
		out.println("<td><input type='text' name='line1' value='"+address.getLine1()+"'></td>");
		out.println("</tr>");


		out.println("<tr>");
		out.println("<td>Line2</td>");
		out.println("<td><input type='text' name='line2' value='"+address.getLine2()+"'></td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td>City</td>");
		out.println("<td><input type='text' name='city' value='"+address.getCity()+"'></td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td>State</td>");
		out.println("<td><input type='text' name='state' value='"+address.getState()+"'></td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td>Pincode</td>");
		out.println("<td><input type='text' name='pincode' value='"+address.getPincode()+"'></td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td>Country</td>");
		out.println("<td><input type='text' name='country' value='"+address.getCountry()+"'></td>");
		out.println("</tr>");
		
		
		

		out.println("<tr>");
		out.println("<input type=\"submit\"value=\"Review\"onclick=\"javascript: submitForm('displayReviewInfo')\">");

			out.println("</td>");
			out.println("</tr>");
		out.println("</tr>");
		out.println("</table>");
		LayoutUtil.displayFooter(request, response);

	}

	@Override
	public void destroy() {
		ferService = null;
	}
}
