/**
 * 
 */
package timer;

import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.BorderLayout;
import java.awt.event.*;
/**
 * @author b1014246
 *
 */
@SuppressWarnings("serial")
class Test extends JFrame implements ActionListener {
	int flag = 0;
	int sec;
	int in;
	int h, m, s, k;
	JButton btn;
	Timer timer;
	JLabel label_time2;
	
	public static void main(String[] args) {
		Test frame = new Test("Test");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 300, 120);
		frame.setTitle("Test");
		frame.setVisible(true);

	}
	
	Test(String title) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 120);
		setTitle(title);
		setVisible(true);
		JPanel p = new JPanel();
		p.setBackground(new Color(255, 255, 255));
		GridBagLayout layout = new GridBagLayout();
		p.setLayout(layout);
		
		GridBagConstraints gbc = new GridBagConstraints();
				
		JLabel label_2Fleet = new JLabel("第2艦隊");
		label_2Fleet.setFont(new Font("游ゴシック", Font.PLAIN, 20));
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 0.3d;
		gbc.weighty = 0.5d;
		gbc.anchor = GridBagConstraints.CENTER;
		layout.setConstraints(label_2Fleet, gbc);
				
		JLabel label_operation2 = new JLabel("囮機動部隊支援作戦");
		label_operation2.setFont(new Font("游ゴシック", Font.PLAIN, 20));
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.weightx = 0.7d;
		gbc.weighty = 0.5d;
		gbc.anchor = GridBagConstraints.CENTER;
		layout.setConstraints(label_operation2, gbc);
		
		sec = 5400;
		in = sec;
	    h = 0;
		m = 0;
		s = 0;
		k = 0;
		
		label_time2 = new JLabel("01 : 30 : 00");
		label_time2.setFont(new Font("游ゴシック", Font.PLAIN, 20));
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.weightx = 0.7d;
		gbc.weighty = 0.5d;
		gbc.anchor = GridBagConstraints.CENTER;
		layout.setConstraints(label_time2, gbc);
				
		btn = new JButton("出撃");
		btn.addActionListener(this);
		btn.setFont(new Font("游ゴシック", Font.PLAIN, 15));
		btn.setForeground(Color.BLUE);
		btn.setBorderPainted(false);
		btn.setBackground(new Color(255, 255, 255));
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 0.3d;
		gbc.weighty = 0.5d;
		gbc.fill = GridBagConstraints.BOTH;
		layout.setConstraints(btn, gbc);
						
		p.add(label_2Fleet);		
		p.add(label_operation2);
		p.add(label_time2);
		p.add(btn);
		
		timer = new Timer(1000, this);
		System.out.println(flag);
		getContentPane().add(p, BorderLayout.CENTER);
	}
	
	public void actionPerformed(ActionEvent e){
		if(sec > 0) timer.start();  
		else if(sec <= 0) timer.stop();
		if(flag == 0) {
			  btn.setText("撤退");
			  btn.setForeground(Color.RED);
			  flag = 1;
		  }
		  else if(flag == 1) {
			  btn.setText("出撃");
			  btn.setForeground(Color.BLUE);
			  flag = 0;
		  }
		  
		  label_time2.setText(String.format("%02d", h) + " : " + String.format("%02d", m) + " : " + String.format("%02d", s));
		  
			if (sec <= 0){
			  timer.stop();
			}else{
				sec--;
				in = sec;
				h = sec / 3600;
				k = sec % 3600;
				m = k / 60;
				s = k % 60;
				System.out.println(flag);
			}
		  
	  } 
}
