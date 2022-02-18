package site.metacoding.db.swingchat;

import javax.swing.JFrame;

// Ctrl + Shift + O : import가져오기
// Ctrl + Shift + F : 자동정렬
public class MyFrame extends JFrame {
	public MyFrame() {
		setSize(600, 400); // w,h
		System.out.println("MyFrame 디폴트");
		setLocationRelativeTo(null); // 프레임 화면 중앙 배치
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x버튼 클릭시 main 종료
	}

	// 오버로딩을 하여 원하는 크기를 정할수있음.
	public MyFrame(int w, int h) {
		setSize(w, h); // w,h
		System.out.println("MyFrame 오버로딩된 생성자");
		setLocationRelativeTo(null); // 프레임 화면 중앙 배치
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x버튼 클릭시 main 종료
	}
}
