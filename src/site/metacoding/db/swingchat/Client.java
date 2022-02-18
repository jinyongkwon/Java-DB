package site.metacoding.db.swingchat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	private Swing swing;
	String username; // ������ �̸�.

	Socket socket;

	// �����͸� �޾Ƽ� ���� ������
	BufferedReader reader;

	// Ű����� ���� �޾Ƽ� �ٷ� �� ������
	BufferedWriter writer;
	Scanner sc;

	public Client(Swing swing) {
		this.swing = swing;
		try {
			socket = new Socket("localhost", 2000);
			sc = new Scanner(System.in);
			writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			// ���ο� ������ (�б� ����)
			new Thread(new �б����㽺����()).start();

			// ���� username ���� ��������
			username = swing.getName();
			writer.write(username + "\n");
			writer.flush(); // ���ۿ� ��� ���� stream���� ���������

			// ���� ������ (���� ����)
			while (true) {
				String keyboardInputData = swing.getsendText();
				writer.write(keyboardInputData + "\n");
				writer.flush(); // ���ۿ� ��� ���� stream���� ���������
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	class �б����㽺���� implements Runnable {

		@Override
		public void run() {
			try {
				while (true) {
					String inputdata = reader.readLine();
					System.out.println(inputdata);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}
