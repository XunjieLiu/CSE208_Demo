package org.file.dao.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.file.dao.IFileDao;

public class FileDaoImpl implements IFileDao{
	private static final String URL = "jdbc:mysql://localhost:3306/test1";
	private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";

	private static final String USER = "root";
	private static final String PASSWORD = "liuxunjie1997";

	Connection conn = null;
	PreparedStatement statement = null;
	
	public void add() {
		
	}
	
	public void blobDemo() {
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			File file = null;
			InputStream in = null;
			Reader reader = null;
			String testFile = "INSERT INTO file VALUES(?, ?, ?, ?, ?, ? , ?);";
			String query = "Select * FROM mymusic WHERE name=?";

			statement = conn.prepareStatement(testFile);

			file = new File("D:\\CloudMusic\\Adele - Set Fire to the Rain.mp3");
			in = new FileInputStream(file);
			reader = new InputStreamReader(in, "UTF-8");
			statement.setInt(1, 1);
			statement.setString(3, "Set Fire to the Rain");
			statement.setBinaryStream(2, in, (int)file.length() / 3);
			statement.setInt(4, 2);
			statement.setString(5, "mp3");
			statement.setString(6, "2019");
			statement.setString(7, "url");
			statement.executeUpdate();


		} catch (ClassNotFoundException ex) {
			System.out.println("Error: unable to load driver class!");
			System.exit(1);
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (statement != null)
					statement.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	public void textDemo() {
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			File file = null;
			InputStream in = null;
			Reader reader = null;
			String text = "INSERT INTO mynovel VALUES(?, ?, ?);";
			String query = "Select * FROM mynovel WHERE name=?";
			String name = "µÁÄ¹±Ê¼Ç";

			statement = conn.prepareStatement(query);
			statement.setString(1, name);

//			file = new File("D:\\Downloads\\all.txt");
//			in = new FileInputStream("D:\\Downloads\\all.txt");
//			reader = new InputStreamReader(in, "UTF-8");
//			statement.setCharacterStream(3, reader, (int)file.length()/2);
			
			ResultSet result = statement.executeQuery();
			
			if(result.next()) {
				Reader novel = result.getCharacterStream("novel");
				Writer writer = new FileWriter("D:\\µÁÄ¹±Ê¼Ç.txt");
				
				char[] chs = new char[100]; //»º´æ
				int len = -1;
				
				while((len = novel.read(chs)) != -1) {
					writer.write(chs, 0, len);
				}
				
				writer.close();
				novel.close();
				reader.close();
				
			}

		} catch (ClassNotFoundException ex) {
			System.out.println("Error: unable to load driver class!");
			System.exit(1);
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (statement != null)
					statement.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) {
		FileDaoImpl fileDao = new FileDaoImpl();
		
		fileDao.blobDemo();
		System.out.println("Done");

	}

	@Override
	public boolean addFile(org.user.entity.File file) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteFile(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<org.user.entity.File> queryAllFile() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<org.user.entity.File> queryFileByName() {
		// TODO Auto-generated method stub
		return null;
	}
}
