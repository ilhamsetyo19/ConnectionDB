package ConnectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Insert {
	private static final String DB_DRIVER="com.mysql.cj.jdbc.Driver";
	private static final String DB_CONNECTION="jdbc:mysql://localhost:3306/mahasiswa";
	private static final String DB_USER="root";
	private static final String DB_PASSWORD="";
	
	public static void main(String[]args) {
		try {
			insertTable();
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public static void insertTable()throws SQLException{
		Connection connection=null;
		Statement statement=null;
		int count=0;
		
		String insertTableSQL=
			"INSERT INTO BIODATA" + "(id,nama,nim,prodi)"
			+ "VALUES" + "('1','M. ILHAM','211552018','INFORMATIKA'"+")";
		
		try {
			connection=getDatabaseConnection();
			statement=connection.createStatement();
			System.out.println(insertTableSQL);
			statement.executeUpdate(insertTableSQL);
			count=statement.getUpdateCount();
				
			System.out.println(count + " Record Berhasil Dimasukkan");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if(statement !=null) {
				statement.close();
			} else if(connection !=null) {
				connection.close();
			}
		}
	}
	
	public static Connection getDatabaseConnection() {
		Connection connection=null;
		
		try {
			Class.forName(DB_DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		try {
			connection=DriverManager.getConnection(DB_CONNECTION,DB_USER,DB_PASSWORD);
			return connection;
		} catch (SQLException e){
			System.out.println(e.getMessage());
		}
		return connection;
	}
}