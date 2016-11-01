import java.util.Scanner;
public class MainFile
{
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		int x=0;
		do
		{
			System.out.println("How many bricks?");
			x=keyboard.nextInt();
		}while(x<3||x>7);
		new HFrame(x);
	}
}