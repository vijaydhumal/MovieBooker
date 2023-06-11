package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Theater_DAO {
	static Connection con;
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja7","root","sql123");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void calculation(Theater_DTO dto) {
		PreparedStatement pstmt;
		ResultSet rs;
		
		String movie=dto.getMovie();
		int tickets=dto.getTickets();
		
		Theater_DTO dto1=new Theater_DTO();
		Theater_DAO dao=new Theater_DAO();
		double price=0.0;
		double bill;
		double total_bill=0.0;
		int no_of_tickets=0;
		int updated_tickets=0;
		String query="select no_of_tickets_available,price_per_ticket from theater where movie_name=?";
		try {
			pstmt=con.prepareStatement(query);
			pstmt.setString(1, movie);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				no_of_tickets=rs.getInt(1);
			    price=rs.getInt(2);
			    if(tickets<=no_of_tickets) {
			    	bill=tickets*price;
			    	total_bill=bill+bill*0.18;
			    	
			    	dto.setBill(total_bill);
				    updated_tickets=no_of_tickets-tickets;
				    //dao.update_tickets(movie,no_of_tickets);
				    String query1="update theater set no_of_tickets_available=? where movie_name=?";
					try {
						pstmt=con.prepareStatement(query1);
						pstmt.setInt(1, updated_tickets);
						pstmt.setString(2, movie);
						int count=pstmt.executeUpdate();
						
					}catch (SQLException e) {
						e.printStackTrace();
					}
			    	
			    }else {
			    	total_bill=0.0;
			    }
			    
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
}
