package assignment3;

public class Node <T>
{
	private T data;
	private Node next;
	
	//Constructor
	public Node(T d)
	{
		next = null;
		data = d;
	}
	
	//Overloaded constructor
	public Node(T d, Node n)
	{
		next = n;
		data = d;
	}
	
	//Return data
	public T getData()
	{
		return data;
	}
	
	//Set data
	public void setData(T d)
	{
		data = d;
	}
	
	//Set the next variable to a node
	public void setNext(Node n)
	{
		next = n;
	}
	
	//Return next
	public Node getNext()
	{
		return next;
	}
}
