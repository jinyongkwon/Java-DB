package site.metacoding.db.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import site.metacoding.db.practice.HospitalDto.Response.Body.Items.Item;

// INSERT
public class PcrHospital {

	public static void main(String[] args) {
		try {
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SCOTT", "TIGER");
			System.out.println("DB����Ϸ�");
			List<Item> items = DownloadItem.Download();
			List<Hospital> hospitalList = new ArrayList<>();
			for (int i = 0; i < items.size(); i++) {
				Hospital hospital = new Hospital(items.get(i).getAddr(), items.get(i).getMgtStaDd(),
						items.get(i).getPcrPsblYn(), items.get(i).getRatPsblYn(),
						items.get(i).getRecuClCd(), items.get(i).getSgguCdNm(), items.get(i).getSidoCdNm(),
						items.get(i).getXPosWgs84(), items.get(i).getYPosWgs84(), items.get(i).getYadmNm(),
						items.get(i).getYkihoEnc());
				hospitalList.add(hospital);
			}

			// 2. ���� �޾Ƽ� ��� (SELECT * FROM emp)

			String sql = "INSERT INTO hospital(addr, mgtStaDd, pcrPsblYn, ratPsblYn,recuClCd,sgguCdNm,sidoCdNm,xPosWgs84,yPosWgs84,yadmNm,ykihoEnc) values(?,?,?,?,?,?,?,?,?,?,?)"; // ����
			PreparedStatement pstmt = conn.prepareStatement(sql); // ���۸� �ٴ°�

			for (int i = 0; i < hospitalList.size(); i++) {
				pstmt.setString(1, hospitalList.get(i).getAddr());
				pstmt.setInt(2, hospitalList.get(i).getMgtStaDd());
				pstmt.setString(3, hospitalList.get(i).getPcrPsblYn());
				pstmt.setString(4, hospitalList.get(i).getRatPsblYn());
				pstmt.setInt(5, hospitalList.get(i).getRecuClCd());
				pstmt.setString(6, hospitalList.get(i).getSgguCdNm());
				pstmt.setString(7, hospitalList.get(i).getSidoCdNm());
				pstmt.setString(8, hospitalList.get(i).getXPosWgs84());
				pstmt.setString(9, hospitalList.get(i).getYPosWgs84());
				pstmt.setString(10, hospitalList.get(i).getYadmNm());
				pstmt.setString(11, hospitalList.get(i).getYkihoEnc());
				// ���� -1, ������(����,����,����) row ����, ��ȭ�� ������ 0
				pstmt.executeUpdate(); // INSERT, UPDATE, DELETE�Ҷ� ��� => �ڵ� commit // ������ ����� �޾ƿ�.
			}
			if (pstmt.executeUpdate() > 0) {
				System.out.println("����"); // 1
			} else {
				System.out.println("����"); // 0
			} // -1�� ������ catch�� �Ѿ

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
