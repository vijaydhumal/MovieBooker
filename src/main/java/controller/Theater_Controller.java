package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Theater_DAO;
import model.Theater_DTO;

@WebServlet("/theaterlink")
public class Theater_Controller extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String movie=req.getParameter("movie");
		String tickets=req.getParameter("tickets");
		
		int tickets1=Integer.parseInt(tickets);
		
		Theater_DAO dao=new Theater_DAO();
		Theater_DTO dto=new Theater_DTO();
		
		dto.setMovie(movie);
		dto.setTickets(tickets1);
		dao.calculation(dto);
		double total_bill=dto.getBill();
		req.setAttribute("bill", total_bill);
		
	    RequestDispatcher rd=req.getRequestDispatcher("display_bill.jsp");
		rd.include(req, resp);
	    
	}
}
