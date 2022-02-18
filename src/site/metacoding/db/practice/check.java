package site.metacoding.db.practice;

import java.util.List;

import site.metacoding.db.practice.HospitalDto.Response.Body.Items.Item;

public class check {
    public static void main(String[] args) {
        List<Item> items = DownloadItem.Download();
        // System.out.println(items);
    }
}
