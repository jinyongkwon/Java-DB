package site.metacoding.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

// SQL 인젝션 개념잡기 = (SQL 주입공격)
public class DBEx04 {

	public static void login(String username, String password) {
		try {
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SCOTT", "TIGER");
			System.out.println("DB연결완료");

			String sql = "SELECT * FROM userTbl WHERE username =  " + username + " AND password = " + password;
			// 비밀번호 뒤에 OR을 붙여서 로그인을 성공함.
			Statement pstmt = conn.createStatement();
			ResultSet rs = pstmt.executeQuery(sql); // 변수를 집어 넣기 때문에 공격 당함.
			while (rs.next()) {
				Session.isLogin = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		login("'ssar'", "'12345333' OR 1=1");
		System.out.println(Session.isLogin);
	}

}
