package org.user.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.user.dao.IStudentDao;
import org.user.entity.Student;
import org.user.util.UserUtil;

public class StudentDaoImpl implements IStudentDao {

	private static final String URL = "jdbc:mysql://localhost:3306/test1?serverTimezone=GMT%2B8&useSSL=false";
	private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";

	private static final String USER = "root";
	private static final String PASSWORD = "liuxunjie1997";

	static Connection conn = null;
	static PreparedStatement statement = null;
	static ResultSet result = null;

	public boolean isExist(String name) {
		return queryStudentByName(name) == null ? false : true;
	}

	private Object queryStudentByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean updatePasswordByName(Student student) {
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);

			String sql = "UPDATE student SET spwd=? WHERE sname = ?";
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, student.getSpwd());
			statement.setString(2, student.getSname());

			System.out.println();

			int count = statement.executeUpdate();

			System.out.println(count);

			if (count > 0) {
				return true;
			} else {
				return false;
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (statement != null)
					statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public Student queryAllInfoByStudent(Student student) {
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			String sql = "SELECT * FROM student where sname = ? and spwd = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, student.getSname());
			statement.setString(2, student.getSpwd());

			result = statement.executeQuery(); // never null

			Student stu = null;

			HashMap<String, String> questions = new HashMap<String, String>();

			while (result.next()) {

				// String sqna = result.getString("sqna");

				String sname = result.getString("sname");
				String spwd = result.getString("spwd");
				int sidentity = Integer.parseInt(result.getString("sidentity"));
				String suniv = result.getString("suniv");
				int syear = Integer.parseInt(result.getString("syear"));
				String smajor = result.getString("smajor");
				String smodule = result.getString("smodule");
				String semail = result.getString("semail");

				String questionAndValue = result.getString("sqna");
				String[] question = questionAndValue.split("=");
//				String[] question = questionAndValue.substring(1, questionAndValue.length() - 1).split("=");
				System.out.println(question[0]);
				questions.put(question[0], question[1]);
				// Map<String, String> question;
				int sgender = Integer.parseInt(result.getString("sgender"));

				stu = new Student(sname, spwd, sidentity, suniv, syear, smajor, smodule, semail, questions, sgender);

			}

			if (stu == null) {
				return null; // ����Ϊ��
			} else {
				return stu; // ���˴���

			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (statement != null)
					statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public boolean updateStudentByName(String name, Student student) {
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);

			String sql = "UPDATE student SET sid = ?, sname = ?, sage = ?, saddress = ? WHERE sid = ?";

			PreparedStatement statement = conn.prepareStatement(sql);
			//
			// statement.setInt(1, student.getSno());
			// statement.setString(2, student.getName());
			// statement.setInt(3, student.getAge());
			// statement.setString(4, student.getAddress());

			int count = statement.executeUpdate();

			if (count > 0) {
				return true;
			} else {
				return false;
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (statement != null)
					statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public boolean deleteStudentByName(String id) {
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);

			String sql = "DELETE FROM student WHERE sid = ?";

			PreparedStatement statement = conn.prepareStatement(sql);
			//
			// statement.setInt(1, id);

			int count = statement.executeUpdate();

			if (count > 0) {
				return true;
			} else {
				return false;
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (statement != null)
					statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public boolean addStudent(Student student) {
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);

			String sql = "INSERT INTO student(sname, spwd, sgender, suniv, smajor, syear, smodule, semail, sqna, sidentity) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, student.getSname());
			statement.setString(2, student.getSpwd());
			statement.setInt(3, student.getSgender());
			statement.setString(4, student.getSuniv());
			statement.setString(5, student.getSmajor());
			statement.setInt(6, student.getSyear());
			statement.setString(7, student.getSmodule());
			statement.setString(8, student.getSemail());
			statement.setString(9, student.getQuestions().toString());
			statement.setString(10, String.valueOf(student.getSidentity()));

			int count = statement.executeUpdate();

			if (count > 0) {
				return true;
			} else {
				System.out.println("addStudent--count<0");
				return false;
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (statement != null)
					statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public List<Student> queryAllStudent() {
		ArrayList<Student> all = new ArrayList<>();
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);

			String sql = "SELECT * FROM student";
			PreparedStatement statement = conn.prepareStatement(sql);

			result = statement.executeQuery();

			while (result.next()) {
				String name = result.getString("sname");
				int sid = result.getInt("sid");
				int age = result.getInt("sage");
				String address = result.getString("saddress");

				// all.add(new Student(sid, name, age, address));
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (statement != null)
					statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return all;
	}

	public boolean queryByNameAndPassword(Student student) {

		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);

			String sql = "SELECT * FROM student where sname = ? and spwd = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, student.getSname());
			statement.setString(2, student.getSpwd());
			result = statement.executeQuery(); // never null

			Student stu = null;
			while (result.next()) {
				String name = result.getString("sname");
				String pwd = result.getString("spwd");
				stu = new Student(name, pwd);
			}

			if (stu == null) {
				return false; // ����Ϊ��
			} else {
				return true; // ���˴���

			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (statement != null)
					statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	 public static void main(String[] args) {
	 Student student = new Student("KD", "12345");
	 StudentDaoImpl dao = new StudentDaoImpl();
	 
	 Student newOne = dao.queryAllInfoByStudent(student);
	 System.out.println(newOne.toString());
	
	 }

	@Override
	public boolean updateAllInfoByName(Student student) {
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("==================10");
			String sql = "UPDATE student SET suniv=?,syear=?,smajor=? WHERE sname = ?";
		
			PreparedStatement statement = conn.prepareStatement(sql);			
			statement.setString(1, student.getSuniv());	
			statement.setInt(2, student.getSyear());
			statement.setString(3, student.getSmajor());
			statement.setString(4, student.getSname());
					
			int count = statement.executeUpdate();
			if(count > 0) {
				return true;
			}else {
				return false;
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
			try {
				if(conn != null) conn.close();
				if(statement != null) statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
