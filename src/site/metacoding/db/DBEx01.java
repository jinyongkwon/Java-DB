package site.metacoding.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBEx01 {

	public static void main(String[] args) {
		try {
			// 1. connection ���� (���ǻ���) port, ip, id password, protocol
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SCOTT", "TIGER");
			// conn = socket, ���� : @ip:port,sid,id,password
			System.out.println("DB����Ϸ�");

			// 2. ���� �޾Ƽ� ��� (SELECT * FROM emp)
			String sql = "SELECT empno, ename FROM emp"; // ���� ; �ȴ޾Ƶ���!!!
			PreparedStatement pstmt = conn.prepareStatement(sql); // ���۸� �ٴ°�
			pstmt.executeQuery(); // SELECT�Ҷ� ��� // ���� ����
			ResultSet rs = pstmt.executeQuery(); // ������ ����� �޾ƿ�.
			// pstmt.executeUpdate(); // INSERT, UPDATE, DELETE�Ҷ� ��� => �ڵ� commit
			// System.out.println(rs.next());// Ŀ�� ��ĭ ������
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
