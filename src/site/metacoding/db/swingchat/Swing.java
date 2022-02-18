package site.metacoding.db.swingchat;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Swing extends MyFrame {
	private Swing mContext = this;
	private String username;
	private String sendText;

	public String getsendText() {
		return sendText;
	}

	public String getUsername() {
		return username;
	}

	public Swing() {
		super(600, 600);
		JPanel panel = (JPanel) getContentPane();
		JPanel southpanel = new JPanel();
		JPanel northpanel = new JPanel();
		JPanel centerpanel = new JPanel();
		Client client = new Client(mContext);

		JTextField text = new JTextField(41);
		JTextField ip = new JTextField(41);

		JButton btnConnect = new JButton("����");
		JButton btnSend = new JButton("������");

		JTextArea ta = new JTextArea(15, 20);
		JScrollPane scrollPane = new JScrollPane(ta);

		panel.setLayout(new BorderLayout()); // ��������!! ����Ʈ�� BorderLayout �̴ϱ�!!
		southpanel.setLayout(new FlowLayout());
		northpanel.setLayout(new FlowLayout());
		centerpanel.setLayout(new BorderLayout());

		centerpanel.add(scrollPane);
		panel.add(scrollPane, BorderLayout.CENTER);
		panel.add(northpanel, BorderLayout.NORTH);
		northpanel.add(ip, BorderLayout.WEST);
		northpanel.add(btnConnect, BorderLayout.EAST);

		panel.add(southpanel, BorderLayout.SOUTH);
		southpanel.add(text, BorderLayout.WEST);
		southpanel.add(btnSend, BorderLayout.EAST);

		btnSend.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sendText = text.getText() + "\n";
				text.setText("");
			}
		});
		ta.append(text.getText() + "\n");
		text.setText("");
		username = JOptionPane.showInputDialog("���̵� �Է����ּ���");

		setVisible(true); // paint �޼���

	}

	public static void main(String[] args) {
		new Swing();

	}

}
