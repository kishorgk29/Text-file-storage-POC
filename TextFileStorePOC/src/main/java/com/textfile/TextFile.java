package com.textfile;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig
public class TextFile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TextFile() {
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
			
			String uploadPath = getServletContext().getRealPath("") + "uploads";
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			Part file = request.getPart("file");
			String filename = file.getSubmittedFileName();
			InputStream fileContent = file.getInputStream();

			String sql = "INSERT INTO filedata VALUES (?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, username);
			statement.setString(2, password);
			statement.setString(3, filename);
			statement.setBlob(4, fileContent);
			statement.setString(5, uploadPath);
			
			int Inserted = statement.executeUpdate();
			if (Inserted > 0) {
				response.sendRedirect("./readFileData.jsp");
			} else {
				response.getWriter().println("Failed to upload file.");
			}
			statement.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().println("Error: " + e.getMessage());
		}

	}

}
