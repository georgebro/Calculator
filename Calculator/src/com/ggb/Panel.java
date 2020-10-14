package com.ggb;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
/*import java.awt.event.KeyListener;*/

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Panel extends JPanel {

	private Font font = new Font("SanSerif",Font.BOLD,20);// ����� ��� ������� 
	private JButton numButton[] = new JButton[10]; 
	private JTextField textOutput = new JTextField(); // ��������� ����  
	private JButton backspace = new JButton("<"); // ������ ������� � ���� �����
	private JButton equalse = new JButton("="); // ������ ����� 
	private JButton plus = new JButton("+");
	private JButton minus = new JButton("-");
	private JButton mult= new JButton("*");
	private JButton div = new JButton("/");


	//Set elements in the frame-window 
	// ��������� �������� � ����� ��� ��� ���� (����� �������)
	public Panel() { 
		setLayout(null);
		setFocusable(true); // ���� ����� �������� �� ���� �����
		grabFocus();// ������ ������

		// ������ ����
		plus.setBounds(190, 70, 50, 50);
		plus.setFont(font);
		add(plus);

		// ������ �����
		minus.setBounds(190, 130, 50, 50);
		minus.setFont(font);
		add(minus);

		// ������ ��������
		mult.setBounds(190, 190, 50, 50);
		mult.setFont(font);
		add(mult);

		// ������ ���������
		div.setBounds(190, 250, 50, 50);
		div.setFont(font);
		add(div);


		// ������ �����
		equalse.setBounds(130, 250, 50, 50);
		equalse.setFont(font);
		add(equalse);


		// ������ �������
		backspace.setBounds(10, 250, 50, 50);
		backspace.setFont(font);
		add(backspace);


		// ������� ��� ������ ���� 0
		numButton[0] = new JButton("0");
		numButton[0].setBounds(70, 250, 50, 50);
		numButton[0].setFont(font);
		add(numButton[0]);


		// ���������� ����� �� ������ 
		for(int x=0; x<3; x++) {
			for(int y=0; y<3; y++) {
				numButton[x*3+y+1] = new JButton((x*3+y+1)+"");
				numButton[x*3+y+1].setBounds(x*(50+10)+10, y*(50+10)+70, 50, 50);
				numButton[x*3+y+1].setFont(font);
				add(numButton[x*3+y+1]);
			}
		}


		textOutput.setBounds(10, 10, 230, 50); //����������/������ �������
		textOutput.setFont(font); // ������ �����
		textOutput.setEditable(false); //����������/������ ��������������� = ���
		add(textOutput);



		// lambda expression 
		// output digit text to the textfield
		ActionListener l = (ActionEvent e)->{
			JButton b = (JButton)e.getSource();
			textOutput.setText(textOutput.getText()+b.getText());
		};

		//��������� ���������� ������� 
		for(JButton b : numButton) {
			b.addActionListener(l);
		}

		// ��������� ����� � ����������
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent event) {
				char symbol = event.getKeyChar();
				if(!Character.isDigit(symbol)) // ���� ��������� �� ����� �� ��� �������
					return;	
				textOutput.setText(textOutput.getText()+symbol); // ���� ����� ������� �� �����
			}
		});
	}
}