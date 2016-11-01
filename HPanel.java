import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.awt.event.*;

public class HPanel extends JPanel implements KeyListener
{
	MyStack<Integer> stack1=new MyStack();
	MyStack<Integer> stack2=new MyStack();
	MyStack<Integer> stack3=new MyStack();
	private int numBricks;
	private int status;
	int source=-1;
	int destination=-1;
	int moves=0;
	public static final int WON=2;
	public static final int PLAYING=0;
	
	public HPanel(int z)
	{
		setSize(600,600);
		addKeyListener(this);
		numBricks=z;
		for(int x=0;x<numBricks;x++)
		{
			stack1.push(numBricks-x);
		}
		System.out.println(stack1.toString());
		status=0;
	}
	public void paint(Graphics g)
	{
		g.setColor(Color.WHITE);
		g.fillRect(0,0,600,600);
		for(int x=0;x<3;x++)
		{
			if(source-1==x)
			{
				g.setColor(Color.YELLOW);
				g.fillRect((x*175)+90,100,25,450);
			}
			else
			{
				g.setColor(Color.BLACK);
				g.fillRect((x*175)+90,100,25,450);
			}
			
		}
		for(int y=0;y<=stack1.size()-1;y++)
		{
			int w=stack1.get(y)*30+30;
			int x=90-(w-25)/2;
			int h=20;
			int y1=530-(y)*h;
			g.setColor(Color.BLUE);
			g.fillRect(x,y1,w,h);
			
		}
		g.setColor(Color.RED);
		g.fillRect(65,550,75,50);
		for(int y=0;y<stack2.size();y++)
		{
			int w=stack2.get(y)*30+30;
			int x=265-(w-25)/2;
			int h=20;
			int y1=530-(y)*h;
			g.setColor(Color.BLUE);
			g.fillRect(x,y1,w,h);
			
		}
		g.setColor(Color.RED);
		g.fillRect(240,550,75,50);
		for(int y=0;y<stack3.size();y++)
		{
			int w=stack3.get(y)*30+30;
			int x=440-(w-25)/2;
			int h=20;
			int y1=530-(y)*h;
			g.setColor(Color.BLUE);
			g.fillRect(x,y1,w,h);
			
		}
		g.setColor(Color.RED);
		g.fillRect(415,550,75,50);
		if(stack1.empty()==true&&stack2.empty()==true)
		{
			g.setColor(Color.BLACK);
			g.drawString("YOU WIN!",300,300);
			g.drawString("YOU TOOK "+moves+" moves!",50,50);
			status=2;
		}
		
	}
	public void keyPressed(KeyEvent e)
	{
		
	}
	public void keyTyped(KeyEvent e)
	{
		int key=(int)e.getKeyChar()-48;
		System.out.println(key);
		if(status==2)
		{
			repaint();
		}
		else
		{
			if(source==-1)
			{
				if(key==1)
				{
					if(stack1.empty()==false)
					{
						source=key;
					}
				}
				if(key==2)
				{
					if(stack2.empty()==false)
					{
						source=key;
					}
				}
				if(key==3)
				{
					if(stack3.empty()==false)
					{
						source=key;
					}
				}
				System.out.println(source);
				
			}
			else
			{
				moves++;
				destination=key;
				System.out.println(destination);
				if(destination==1)
				{
						if(source==2)
						{
							if(stack1.empty()==true)
							{
								int x=stack2.pop();
								stack1.push(x);
							}
							else if(stack2.get(stack2.size()-1)<stack1.get(stack1.size()-1))
							{
								int x=stack2.pop();
								stack1.push(x);
							}
							
						}
						if(source==3)
						{
							if(stack1.empty()==true)
							{
								int x=stack3.pop();
								stack1.push(x);
							}
							else if(stack3.get(stack3.size()-1)<stack1.get(stack1.size()-1))
							{
								int x=stack3.pop();
								stack1.push(x);
							}
						}
					source=-1;
				}
				if(destination==2)
				{
						if(source==1)
						{
							if(stack2.empty()==true)
							{
								int x=stack1.pop();
								stack2.push(x);
							}
							else if(stack1.get(stack1.size()-1)<stack2.get(stack2.size()-1))
							{
								int x=stack1.pop();
								stack2.push(x);
							}
						}
						if(source==3)
						{
							if(stack2.empty()==true)
							{
								int x=stack3.pop();
								stack2.push(x);
							}
							else if(stack3.get(stack3.size()-1)<stack2.get(stack2.size()-1))
							{
								int x=stack3.pop();
								stack2.push(x);
							}
						}
					
				}
				if(destination==3)
				{
					
						if(source==1)
						{
							if(stack3.empty()==true)
							{
								int x=stack1.pop();
								stack3.push(x);
							}
							else if(stack1.get(stack1.size()-1)<stack3.get(stack3.size()-1))
							{
								int x=stack1.pop();
								stack3.push(x);
							}
						}
						if(source==2)
						{
							if(stack3.empty()==true)
							{
								int x=stack2.pop();
								stack3.push(x);
							}
							else if(stack2.get(stack2.size()-1)<stack3.get(stack3.size()-1))
							{
								int x=stack2.pop();
								stack3.push(x);
							}
						}
					
				}
				source=-1;
			}
		}
		
		repaint();
	}
	public void keyReleased(KeyEvent e)
	{
		
	}
	public void setBricks(int numBricks)
	{
		this.numBricks=numBricks;
	}
	public int getNumBricks()
	{
		return numBricks;
	}
	public void addNotify()
	{
		super.addNotify();
		requestFocus();
	}
}