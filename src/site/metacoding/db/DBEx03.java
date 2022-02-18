package site.metacoding.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// PrepareStatement 변수 바인딩 하기
public class DBEx03 {

	public static void login(String username, String password) {
		try {
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SCOTT", "TIGER");
			System.out.println("DB연결완료");

			String sql = "SELECT * FROM usertbl WHERE username = ? AND password = ?"; // 변수 자리에 ?를 넣음
			PreparedStatement pstmt = conn.prepareStatement(sql);
			// ?의 시작번지는 1이다.
			pstmt.setString(1, username); // ? 첫번째 자리에 username을 넣음
			pstmt.setString(2, password); // ? 두번째 자리에 password를 넣음
			pstmt.executeQuery();
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Session.isLogin = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		login("ssar", "ssar1234");
		System.out.println(Session.isLogin);
	}

}
