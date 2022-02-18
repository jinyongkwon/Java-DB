package site.metacoding.db.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.google.gson.Gson;

public class DownloadTotalcount {
    public static int Download() {
        try {
            URL url = new URL(
                    "http://apis.data.go.kr/B551182/rprtHospService/getRprtHospService?serviceKey=wJmmW29e3AEUjwLioQR22CpmqS645ep4S8TSlqtSbEsxvnkZFoNe7YG1weEWQHYZ229eNLidnI2Yt5EZ3Stv7g%3D%3D&pageNo=1&numOfRows=5190&_type=json");
            // conn -> Byte Stream ��!!
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            // ���� default 1Byte �ѱ��� �о��� ������ �ѱ��� ������.
            // utf-8 �ѱ��� 3Byte�� ���� �аڴ�.
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(), "utf-8"));

            String responseJson = br.readLine();
            Gson gson = new Gson();
            HospitalDto responseDto = gson.fromJson(responseJson, HospitalDto.class);
            int totalCount = responseDto.getResponse().getBody().getTotalCount();
            System.out.println("�ߴ���");
            return totalCount;
        } catch (Exception e) {
            System.out.println("���� ��ȸ�� ������ �߻��߽��ϴ�.");
        }
        return 0;
    }
}