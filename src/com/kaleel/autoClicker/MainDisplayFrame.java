package com.kaleel.autoClicker;

import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.net.URI;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainDisplayFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JTextField textBox1;
	protected JTextField textBox2;
	private JButton runButton;
	private JButton resetButton;
	private JButton aboutButton;
	private static JFrame display;
	
	public MainDisplayFrame()
	 {
		setTitle("AutoClicker by JSK");
		
		Box box = Box.createVerticalBox();
	    JPanel panel1 = new JPanel();
	    
		textBox1 = new JTextField(34);
		textBox1.setHorizontalAlignment(JTextField.CENTER);
		textBox2 = new JTextField(15);
		textBox2.setText("No. of Times");
		textBox2.setHorizontalAlignment(JTextField.CENTER);
		
		runButton = new JButton("Run");
		resetButton = new JButton("Reset");
		aboutButton = new JButton("About");
		panel1.add(textBox1);
		textBox1.setPreferredSize(new Dimension(60, 30));
		panel1.add(runButton);
		runButton.setPreferredSize(new Dimension(100, 30));
		panel1.add(textBox2);
		textBox2.setPreferredSize(new Dimension(20, 30));
		panel1.add(resetButton);
		resetButton.setPreferredSize(new Dimension(100, 30));
		panel1.add(aboutButton);
		aboutButton.setPreferredSize(new Dimension(380, 30));
		
		box.add(panel1);
		add(box);
		pack();
		
		runButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae)
			{
				
				int number = Integer.parseInt(textBox2.getText().toString());
				String url = textBox1.getText().toString();
				if(number<0 || url.equals(null)) {
					System.exit(0);
				}
				else {
					int split = (int) Math.ceil(number / 5);
					for(int i=0; i < 5; i++)
					{
						for(int j=0; j < split; j++)
						{
							try {
							  Desktop desktop = Desktop.getDesktop();
							  if (Desktop.isDesktopSupported()
						                && desktop.isSupported(Desktop.Action.BROWSE))
								  {
								  desktop.browse(new URI(url));
								  }
							  Thread.sleep(500);
							} catch (Exception e) {
							  e.printStackTrace();
							}
						}
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		});
		
		resetButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae)
			{
				textBox1.setText(null);
				textBox2.setText(null);
			}
		});
		
		aboutButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae)
			{
				new About(MainDisplayFrame.display);
			}
		});
		
		textBox1.addFocusListener(new FocusListener() {
		    public void focusGained(FocusEvent e) {
		        textBox1.setText("");
		    }

		    public void focusLost(FocusEvent e) {
		        // nothing
		    }
		});
		
		textBox2.addFocusListener(new FocusListener() {
		    public void focusGained(FocusEvent e) {
		        textBox2.setText(null);
		    }

		    public void focusLost(FocusEvent e) {
		        // nothing
		    }
		});
		
	 }
}
