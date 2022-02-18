package site.metacoding.db.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import com.google.gson.Gson;

import site.metacoding.db.practice.HospitalDto.Response.Body.Items.Item;

public class DownloadItem {
    public static List<Item> Download() {
        try {
            URL url = new URL(
                    "http://apis.data.go.kr/B551182/rprtHospService/getRprtHospService?serviceKey=wJmmW29e3AEUjwLioQR22CpmqS645ep4S8TSlqtSbEsxvnkZFoNe7YG1weEWQHYZ229eNLidnI2Yt5EZ3Stv7g%3D%3D&pageNo=1&numOfRows=5190&_type=json");
            // conn -> Byte Stream 선!!
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            // 원래 default 1Byte 한글을 읽었기 때문에 한글이 깨졌다.
            // utf-8 한글을 3Byte로 끊어 읽겠다.
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(), "utf-8"));

            String responseJson = br.readLine();
            Gson gson = new Gson();
            HospitalDto responseDto = gson.fromJson(responseJson, HospitalDto.class);
            List<Item> result = responseDto.getResponse().getBody().getItems().getItem();
            return result;
        } catch (Exception e) {
            System.out.println("병원 조회중 오류가 발생했습니다.");
        }
        return null;
    }
}