package site.metacoding.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

// update
public class DBEx08 {

	public static void main(String[] args) {
		try {
			// 1. connection 연결 (세션생성) port, ip, id password, protocol
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SCOTT", "TIGER");
			// conn = socket, 순서 : @ip:port,sid,id,password
			System.out.println("DB연결완료");

			// 2. 버퍼 달아서 통신 (SELECT * FROM emp)
			// id 1의 username을 coding으로 변경
			String sql = "UPDATE userTbl SET username = ? WHERE id = ?"; // 끝에 ; 안달아도됨!!!
			PreparedStatement pstmt = conn.prepareStatement(sql); // 버퍼를 다는것
			pstmt.setString(1, "coding"); // 물음표의 순서 값
			pstmt.setInt(2, 1);
			// 에러 -1, 성공된(생성,수정,삭제) row 개수, 변화가 없으면 0
			int result = pstmt.executeUpdate(); // INSERT, UPDATE, DELETE할때 사용 => 자동 commit // 전송한 결과를 받아옴.

			if (result > 0) {
				System.out.println("성공"); // 1
			} else {
				System.out.println("실패"); // 0
			} // -1은 무조건 catch로 넘어감
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
