
import java.util.ArrayList;
public class MyStack<E> implements StackInterface<E>
{
	private ArrayList<E> data=new ArrayList<E>();
	public String toString()
	{
		return ""+data;
	}
	public E push(E o)
	{
		data.add(o);
		return o;
	}
	public E peek()
	{
		return data.get(data.size()-1);
	}
	public E pop()
	{
		if(data.size()==0)
		{
			return null;
		}
		else
		{
			E x=data.get(data.size()-1);
			data.remove(data.size()-1);
			return x;
		}
		
	}
	public boolean empty()
	{
		if(data.isEmpty()==true)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public int size()
	{
		return data.size();
	}
	public E get(int x)
	{
		if(x<0||x>data.size()-1)
		{
			return null;
		}
		return data.get(x);
	}
}