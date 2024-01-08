package com.textfile;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@MultipartConfig
public class RetriveFile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RetriveFile() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String dbURL = "jdbc:mysql://localhost:3306/user_data";
		String dbUser = "root";
		String dbPassword = "root";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(dbURL, dbUser, dbPassword);

			String username = request.getParameter("username");
			String password = request.getParameter("password");

			String sql = "Select filecontent from filedata where username=? and password=?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, username);
			statement.setString(2, password);

			ResultSet Inserted = statement.executeQuery();
			if (Inserted != null) {
				while (Inserted.next()) {
					response.getWriter().println(Inserted.getString(1));
				}
			} else {
				response.getWriter().println("Failed");
			}
			statement.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().println("Error: " + e.getMessage());
		}
	}
}
