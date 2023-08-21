package assignment3;

public class LList <T> implements ListInterface<T>
{
	private Node head;
	private Node tail;
	private int counter;
	
	//Constructor
	public LList()
	{
		head = null;
		tail = null;
		counter = 0;
	}
	
	//Add an item at the end of the list
	public void add(T item) throws ListException
	{
		try
		{
			if(item == null)
				throw new ListException("Error. Unable to add. Cannot add null entries.");
			else if(isEmpty())
			{
				head = new Node(item);
				tail = head;
				counter++;
			}
			else
			{
				tail.setNext(new Node(item));
				tail = tail.getNext();
				counter++;
			}
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	//Add an item at a given position
	public void add(T item, int position) throws ListException
	{
		position--;
		try
		{
			if(item == null)
				throw new ListException("Error. Unable to insert. Attempt to insert null objects.");
			else if(isEmpty())
				throw new ListException("Error. Unable to insert. List is empty.");
			else if(position >= counter || position < 0)
				throw new ListException("Error. Unable to insert. Bad position.");
			else
			{
				Node prev = head;
				Node temp = head.getNext();
				for(int i = 0; i < position; i++)
				{
					temp = temp.getNext();
					prev = prev.getNext();
				}
				prev.setNext(new Node(item, temp));
				counter++;
			}
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	//Get item at a given position
	public T get(int pos) throws ListException
	{
		pos--;
		try
		{
			if(pos < 0 || pos >= counter)
				throw new ListException("Error. Unable to get. Bad position.");
			else if(isEmpty())
				throw new ListException("Error. Unable to get. List is empty.");
			else
			{
				Node temp = head;
				for(int i = 0; i <= pos; i++)
					temp = temp.getNext();
				return (T)temp.getData();
			}
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	//Replace an item at a given position and return the item that was in that position
	public T set(T item, int pos) throws ListException
	{
		pos--;
		try
		{
			if(item == null)
				throw new ListException("Error. Unable to replace. Cannot add null entries.");
			else if(isEmpty())
				throw new ListException("Error. Unable to replace. List is empty.");
			else if(pos >= counter || pos < 0)
				throw new ListException("Error. Unable to replace. Bad position.");
			else
			{
				T tempData;
				Node temp = head;
				for(int i = 0; i <= pos; i++)
					temp = temp.getNext();
				tempData = (T)temp.getData();
				temp.setData(item);
				return tempData;
			}
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	//Return the index of the entered item or -1 if item not found
	public int find(T item, int startPos, int endPos) throws ListException
	{
		startPos--;
		endPos--;
		
		try
		{
			if(startPos < 0 || startPos >= counter)
				throw new ListException("Error. Unable to find. Start and/or end position bad.");
			else if(endPos < 0 || endPos >= counter)
				throw new ListException("Error. Unable to find. Start and/or end position bad.");
			else if(startPos > endPos)
				return -1;
			else
			{
				int index = 1;
				Node temp = head;
				for(int i = 0; i <= startPos; i++)
				{
					temp = temp.getNext();
					index++;
				}
				
				for(int i = startPos; i <= endPos; i++)
					if(temp.getData().equals(item))
						return i;
				return -1;
			}
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	//Remove an item in this list at a given position
	public void remove(int pos)throws ListException
	{
		pos--;
		
		try
		{
			if(pos < 0 || pos >= counter)
				throw new ListException("Error. Unable to remove. Bad position.");
			else if(isEmpty())
				throw new ListException("Error. Unable to remove. List is empty.");
			else
			{
				Node temp = head;
				for(int i = 0; i < pos; i++)
					temp = temp.getNext();
				temp.setNext(temp.getNext().getNext());
			}
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	//Clear list and set counter to 0
	public void clear()
	{
		head = null;
		tail = null;
		counter = 0;
	}
	
	//Return the array of items
	public T[] toArray()
	{
		try
		{
			if(isEmpty())
				return (T[])(new Object[20]);
			else
			{
				T[] list = (T[])(new Object[counter]);
				Node temp = head;
				for(int i = 0; i < counter; i++)
				{
					list[i] = (T)temp.getData();
					temp = temp.getNext();
				}
				return list;
			}
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	//Check if list is empty
	public boolean isEmpty()
	{
		if(counter == 0)
			return true;
		else
			return false;
	}
}
