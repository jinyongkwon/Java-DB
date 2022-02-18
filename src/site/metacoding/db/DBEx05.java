package site.metacoding.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

// dept 테이블의 모든 내용을 출력하시오
// SELECT deptno, dname, loc FROM dept

public class DBEx05 {

	public static void main(String[] args) {
		try {
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SCOTT", "TIGER");
			String sql = "SELECT deptno, dname, loc FROM dept";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.executeQuery();
			ResultSet rs = pstmt.executeQuery();

			List<Dept> depts = new ArrayList<>();
			while (rs.next()) {
				Dept dept = new Dept(rs.getInt("deptno"), rs.getString("dname"), rs.getString("loc"));
				depts.add(dept);
			}

			for (Dept d : depts) {
				System.out.println(d.getDeptno());
				System.out.println(d.getDname());
				System.out.println(d.getLoc());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
