package site.metacoding.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

// INSERT
public class DBEx06 {

	public static void main(String[] args) {
		try {
			// 1. connection ���� (���ǻ���) port, ip, id password, protocol
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SCOTT", "TIGER");
			// conn = socket, ���� : @ip:port,sid,id,password
			System.out.println("DB����Ϸ�");

			// 2. ���� �޾Ƽ� ��� (SELECT * FROM emp)
			String sql = "INSERT INTO usertbl(id, username, password, gender) values(?,?,?,?)"; // ���� ; �ȴ޾Ƶ���!!!
			PreparedStatement pstmt = conn.prepareStatement(sql); // ���۸� �ٴ°�
			pstmt.setInt(1, 4); // ����ǥ�� ���� ��
			pstmt.setString(2, "there");
			pstmt.setString(3, "there1234");
			pstmt.setString(4, "��");
			// ���� -1, ������(����,����,����) row ����, ��ȭ�� ������ 0
			int result = pstmt.executeUpdate(); // INSERT, UPDATE, DELETE�Ҷ� ��� => �ڵ� commit // ������ ����� �޾ƿ�.

			if (result > 0) {
				System.out.println("����"); // 1
			} else {
				System.out.println("����"); // 0
			} // -1�� ������ catch�� �Ѿ
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
