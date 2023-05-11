package ConnectDB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Koneksi {
	public static void main(String[] args){
		System.out.println("Koneksi JDBC dengan MySQL");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException ex) {
			System.out.println("MySQL JDBC Driver tidak ditemukan");
			ex.printStackTrace();
		}
		System.out.println(">>Berhasil mendaftarkan MYSQL JDBC Driver");
		Connection connection = null;

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mahasiswa","root", "");
		} catch (SQLException ex) {
			System.out.println("Gagal Membuat Koneksi");
			ex.printStackTrace();
		}

		if(connection != null){
			System.out.println("Anda telah berhasil membuat koneksi ke database MySQL");
		} else {
			System.out.println("Anda gagal membuat koneksi");
		}

		try {
			connection.close();
		} catch (SQLException ex) {
			System.out.println("Gagal untuk membuat koneksi");
			ex.printStackTrace();
		}
	}
}
