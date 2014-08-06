package com.kaleel.autoClicker;

import java.awt.EventQueue;

public class MainClass {
	public static void main(String[] args)
	  {
	    EventQueue.invokeLater(new Runnable()
	    {
	      public void run()
	      {
	        MainDisplayFrame MDframe = new MainDisplayFrame();
	        MDframe.setDefaultCloseOperation(3);
	        MDframe.setSize(350, 120);
	        MDframe.setVisible(true);
	        MDframe.setResizable(false);
	      }
	    });
	  }
}
