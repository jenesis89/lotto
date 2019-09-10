import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Remove extends JFrame {
	int x = 30; 
	int y = 65; 
	int name = 0; 
	int count = 0; 

	JCheckBox[] jcbarr = new JCheckBox[45];
	JButton btn1 = new JButton("초기화");
	JButton btn2 = new JButton("확인");

	public Remove(String title) {
		super(title);
		getContentPane().setLayout(null);

		JLabel la_title = new JLabel("제외할 번호를 선택하세요.");
		la_title.setFont(new Font("HY견고딕", Font.PLAIN, 17));
		la_title.setBounds(30, 10, 210, 43);
		getContentPane().add(la_title);

		for (int i = 0; i < jcbarr.length; i++) {
			jcbarr[i] = new JCheckBox((name + 1) + "");
			jcbarr[i].setBounds(x, y, 50, 50);
			jcbarr[i].setFont(new Font("HY견고딕", Font.PLAIN, 16));
			jcbarr[i].setBorderPainted(true);
			x += 50;
			name++;
			if (name % 5 == 0) {
				x = 30;
				y += 50;
			}
			getContentPane().add(jcbarr[i]);
			jcbarr[i].addItemListener(new ItemListener() {
				@Override
				public void itemStateChanged(ItemEvent e) {
					int result = e.getStateChange() == 1 ? count++ : count--;
					for (int i = 0; i < 45; i++) {
						if (jcbarr[i].isSelected() == true) {
							jcbarr[i].setBackground(Color.GREEN);
						} else {
							jcbarr[i].setBackground(null);
						}
					}

					if (count > 39) {
						for (int i = 0; i < 45; i++) {
							if (e.getItem() == jcbarr[i])
								jcbarr[i].setSelected(false);
							if(count == 40)
								JOptionPane.showMessageDialog(null,"39개 이하로만 선택하시오.");
						}
					}

				}
			});

			btn1.setBounds(30, 530, 250, 30);
			btn1.setFont(new Font("HY견고딕", Font.PLAIN, 20));
			getContentPane().add(btn1);
			btn1.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					for(int i=0;i<45;i++)
						jcbarr[i].setSelected(false); 
				}
			});
			
			btn2.setBounds(30, 570, 250, 30);
			btn2.setFont(new Font("HY견고딕",Font.PLAIN,20));
			getContentPane().add(btn2);
			btn2.addActionListener(new ActionListener() {		
				@Override
				public void actionPerformed(ActionEvent e) {
					for(int i=0;i<45;i++)
						setVisible(false);
				}
			}); 
		}
		setSize(330, 670);
		setVisible(false);
		setLocation(400,0);
	}

}
