package site.metacoding.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBEx01 {

	public static void main(String[] args) {
		try {
			// 1. connection 연결 (세션생성) port, ip, id password, protocol
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SCOTT", "TIGER");
			// conn = socket, 순서 : @ip:port,sid,id,password
			System.out.println("DB연결완료");

			// 2. 버퍼 달아서 통신 (SELECT * FROM emp)
			String sql = "SELECT empno, ename FROM emp"; // 끝에 ; 안달아도됨!!!
			PreparedStatement pstmt = conn.prepareStatement(sql); // 버퍼를 다는것
			pstmt.executeQuery(); // SELECT할때 사용 // 버퍼 전송
			ResultSet rs = pstmt.executeQuery(); // 전송한 결과를 받아옴.
			// pstmt.executeUpdate(); // INSERT, UPDATE, DELETE할때 사용 => 자동 commit
			// System.out.println(rs.next());// 커서 한칸 내리기
			while (rs.next()) {
				System.out.println("empno : " + rs.getInt("empno"));
				System.out.println("ename : " + rs.getString("ename"));
				System.out.println("=========================");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
