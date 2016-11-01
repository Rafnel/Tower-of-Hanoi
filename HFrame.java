import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class HFrame extends JFrame
{
	public HFrame(int x)
	{
		//creates the frame with the given
		//title
		super("Tower of Hanoi");
		 //makes the x kill program
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
		 //makes the window not able to be resized by user
		 setResizable(false);
		 
		 //creates the window
		 pack();
		 
		 //creates panel
		 HPanel p=new HPanel(x);
		 
		 
		 //gets the frames insets
		 //the size of title bar and framing is insets
		 Insets in = getInsets();
		 
		 //calculates the size needed
		 //for the frame and its panel
		 int frameWidth=p.getWidth()+in.left+in.right;
		 int frameHeight=p.getHeight()+in.top+in.bottom;
		 
		 //sets the desired siZe for frame
		 setPreferredSize(new Dimension(frameWidth, frameHeight));
		 
		 //turns off the layout options
		 setLayout(null);
		 
		 //add the panel to the frame
		 add(p);
		 //adjust the size ogf the frame to the preferredSize
		 pack();
		 
		 //make the frame visible
		 setVisible(true);
	}
}