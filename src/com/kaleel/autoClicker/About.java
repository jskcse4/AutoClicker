package com.kaleel.autoClicker;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class About extends JDialog implements ActionListener {

/**
 * @author JSK
 *
 */
	private static final long serialVersionUID = 1L;
	private Font font,bfont;
	public About(JFrame display) 
	{
		setTitle("About");
		buildFrame();
		setSize(200,200);
		setVisible(true);
        setResizable(false);
        //pack();
		
	}

	private void buildFrame() {
		font = new Font("Ariel",Font.PLAIN,12);
		bfont = new Font("Ariel",Font.BOLD,12);
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH; // components grow in both dimensions
        c.insets = new Insets(0, 0, 2, 0);

        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.weighty = 1.0;
        c.weightx = 0.0;
        JPanel panel = new JPanel();
        Dimension d = new Dimension(100,100);
        panel.setPreferredSize(d);
        panel.setMinimumSize(d);
        panel.setMaximumSize(d);
        //this.add(panel, c);        
        c.gridy = 1;
        JLabel author = new JLabel("Author:");
        author.setForeground(Color.MAGENTA);
        author.setFont(bfont);
        this.add(author,c);

        c.gridy = 2;
        JLabel name = new JLabel("Name : SyedKhaleel");
        name.setForeground(Color.RED);
        name.setFont(bfont);
        this.add(name,c);
        
        c.gridy = 3;
        JLabel email=new JLabel("EMail : jskcse4@gmail.com");
        email.setForeground(Color.BLUE);
        email.setFont(font);
        this.add(email,c);
        
        c.gridy = 4;
        JLabel fb=new JLabel("Add me in Facebook");
        fb.setForeground(Color.BLUE);
        {
        fb.setFont(bfont);
        fb.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        fb.addMouseListener(new MouseAdapter() {
          public void mouseClicked(MouseEvent e) {
             if (e.getClickCount() > 0) {
                 if (Desktop.isDesktopSupported()) {
                       Desktop desktop = Desktop.getDesktop();
                       try {
                           URI uri = new URI("https://www.facebook.com/syed.khaleel1");
                           desktop.browse(uri);
                       } catch (IOException ex) {
                           ex.printStackTrace();
                       } catch (URISyntaxException ex) {
                           ex.printStackTrace();
                       }
                 	  }
             		}
          		}
        	});
        }
        this.add(fb,c);
        
        c.gridy = 5;
        JButton exit = new JButton("Close");
        exit.setPreferredSize(new Dimension(200, 10));
        exit.addActionListener(this);
        exit.setFont(font);
        this.add(exit,c);
        
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().compareTo("Close")==0){
            this.dispose();
        }
    }
		
	}


