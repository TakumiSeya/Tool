/**
 * 
 */
package timer;

import javax.swing.*;

import java.awt.event.*;
/**
 * @author b1014246
 *
 */
@SuppressWarnings("serial")
public class EventTest extends JFrame implements ActionListener{
  JLabel label;
  int flag = 0;
  JButton btn;

  public static void main(String[] args){
	EventTest test = new EventTest("SwingTest");

    test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    test.setVisible(true);
  }

  EventTest(String title){
    setTitle(title);
    setBounds( 10, 10, 300, 200);

    label = new JLabel("");

    btn = new JButton("Push");
    btn.addActionListener(this);
    

    JPanel p = new JPanel();
    p.add(label);
    p.add(btn);

    getContentPane().add(p);
  }

  public void actionPerformed(ActionEvent e){
	  if(flag == 0) {
		  btn.setText("Pop");
		  flag = 1;
	  }
	  else if(flag == 1) {
		  btn.setText("Push");
		  flag = 0;
	  }
  }
}
