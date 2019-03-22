package graphics;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

import hres.Hresources;

public class Main_win extends JFrame implements ActionListener, Runnable{
	
	//prvky containeru deklaracia
	private JButton ok=new JButton("OK");
	private JButton cancel=new JButton("Cancel");
	private JLabel user=new JLabel("Username");
	private JLabel pw=new JLabel("Password");
	private	JTextField u=new JTextField(10);
	private	JTextField p=new JTextField(10);
	Checker c;
	//private boolean success=false;
	
	public Main_win(Checker c)
	{
		this.c=c;
		new Thread(this,"Graphics").start();
	}
	public void run()
	{
		//if(this.c.success!=true)
		//{
			this.loginScreen();
			this.setVisible(true);
		//}
	}
	public void loginScreen()
	{
		//parametre okna
		this.setTitle("Login");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(300, 200);
		this.setVisible(true);
		
		//container a layout v okne
		Container c=getContentPane();
		GridBagLayout gbc=new GridBagLayout();
		GridBagConstraints gbs=new GridBagConstraints();
		
		
		//tvorba
		c.setBackground(Color.cyan);
		c.setLayout(gbc);
		//user.setBounds(100,100,100,50);
		
		gbs.gridx=0;
		gbs.gridy=0;
		gbs.gridwidth=1;
		gbs.gridheight=1;
		gbs.weighty=1;
		gbs.weightx=0;
		gbc.setConstraints(this.user, gbs);
		gbs.anchor=GridBagConstraints.NORTH;
		c.add(this.user);
		
		
		gbs.gridy=GridBagConstraints.RELATIVE;
		gbs.gridheight=1;
		gbs.gridwidth=1;
		gbs.anchor=GridBagConstraints.NORTH;
		gbc.setConstraints(this.u, gbs);
		c.add(this.u);
		
		
		gbs.gridx=0;
		gbs.gridy=GridBagConstraints.RELATIVE;
		gbs.gridheight=1;
		gbs.gridwidth=1;
		gbs.anchor=GridBagConstraints.NORTH;
		gbc.setConstraints(this.pw, gbs);
		c.add(this.pw);
		
		gbs.gridx=0;
		gbs.gridy=GridBagConstraints.RELATIVE;
		gbs.gridheight=1;
		gbs.gridwidth=1;
		gbs.anchor=GridBagConstraints.NORTH;
		gbc.setConstraints(this.p,  gbs);
		c.add(this.p);
		
		gbs.gridx=1;
		gbs.gridy=GridBagConstraints.PAGE_END;
		gbs.gridheight=1;
		gbs.gridwidth=2;
		gbs.fill=GridBagConstraints.HORIZONTAL;
		//gbs.anchor=GridBagConstraints.PAGE_END;
		//gbc.setConstraints(this.ok,  gbs);
		this.ok.addActionListener(this);
		c.add(this.ok, gbs);
		
		gbs.gridx=GridBagConstraints.RELATIVE;;
		gbs.gridy=GridBagConstraints.PAGE_END;;
		this.cancel.addActionListener(this);
		c.add(this.cancel, gbs);
		
		this.setContentPane(c);
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
	
		if(event.getSource()==this.ok)
		{
			//System.out.println(this.p.getText());
			
		this.c.check(this.u.getText(), this.p.getText(), this);
		//this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
	
		}
		else if(event.getSource()==this.cancel)//zavriet a nic neurobit
		{
			this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
			System.exit(0);
		}
		
	}
	
	
	/*private void hideWin()
	{
		this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
	}*/
	/*public boolean getSuccess()
	{
		return this.success;
	}*/
	
}
