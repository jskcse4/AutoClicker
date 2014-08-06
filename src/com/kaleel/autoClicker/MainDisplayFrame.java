package com.kaleel.autoClicker;

import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainDisplayFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JComboBox<?> linkBox1;
	protected JComboBox<?> listBox1;
	private JButton runButton;
	private JButton aboutButton;
	private static JFrame display;
	
	public MainDisplayFrame()
	 {
		setTitle("AutoClicker by JSK");
		
		Box box = Box.createVerticalBox();
	    JPanel panel1 = new JPanel();
	    
	    String link[] = {
	    		"http://affiliates.mozilla.org/referral/57480/", 
	    		"http://affiliates.mozilla.org/link/banner/42069" };
	    linkBox1 = new JComboBox<Object>(link);
		
		String times[] = {"10", "100", "200", "300", "400", "500" };
		listBox1 = new JComboBox<Object>(times);
		
		runButton = new JButton("Run");
		aboutButton = new JButton("About");
		panel1.add(linkBox1);
		linkBox1.setPreferredSize(new Dimension(330, 30));
		panel1.add(runButton);
		runButton.setPreferredSize(new Dimension(110, 30));
		panel1.add(listBox1);
		listBox1.setPreferredSize(new Dimension(100, 30));
		panel1.add(aboutButton);
		aboutButton.setPreferredSize(new Dimension(110, 30));
		
		box.add(panel1);
		add(box);
		pack();
		
		runButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae)
			{
				int number = Integer.valueOf((String)listBox1.getSelectedItem());
				String url = (String) linkBox1.getSelectedItem();
				for(int j = 1; j <= number; j++)
					{
						try {
							Desktop desktop = Desktop.getDesktop();
							 if (Desktop.isDesktopSupported()
						               && desktop.isSupported(Desktop.Action.BROWSE))
							 {
								 desktop.browse(new URI(url));
							 }
							 Thread.sleep(1200);
							 } catch (Exception e) {
								 e.printStackTrace();
							 }
					}
			}
		});
		
		aboutButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae)
			{
				new About(MainDisplayFrame.display);
			}
		});		
	 }
}
