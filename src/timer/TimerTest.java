/**
 * 
 */
package timer;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.*;
/**
 * @author b1014246
 *
 */
@SuppressWarnings("serial")
public class TimerTest extends JFrame implements ActionListener{

  Timer timer;
  JLabel label;
  int sec;
  int in;
  int h, m, s, k;

  public static void main(String[] args){
    TimerTest frame = new TimerTest();

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setBounds(10, 10, 300, 200);
    frame.setTitle("タイトル");
    frame.setVisible(true);
  }

  TimerTest(){
    sec = 5400;
    in = sec;
    h = 0;
	m = 0;
	s = 0;
	k = 0;
    label = new JLabel();

    JPanel labelPanel = new JPanel();
    labelPanel.add(label);
       
    timer = new Timer(1000 , this);

    getContentPane().add(labelPanel, BorderLayout.CENTER);

    timer.start();
  }

  public void actionPerformed(ActionEvent e){
	  label.setText(String.format("%02d", h) + " : " + String.format("%02d", m) + " : " + String.format("%02d", s));
	  
	if (sec <= 0){
	  timer.stop();
	}else{
		sec--;
		in = sec;
		h = sec / 3600;
		k = sec % 3600;
		m = k / 60;
		s = k % 60;
		System.out.println(h);
	}
  }
}
