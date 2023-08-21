package assignment3;

public class AList <T> implements ListInterface<T>
{
	private T[] list;
	private int counter;
	
	//Constructor
	public AList()
	{
		counter = 0;
		list = (T[])(new Object[20]);
	}
	
	//Resize array
	private void resize()
	{
		T[] temp = (T[])(new Object[list.length + 10]);
		for(int i = 0; i < counter; i++)
			temp[i] = list[i];
		list = temp;
	}
	
	//Return size of the array
	public int getCapacity()
	{
		return list.length;
	}
	
	//Compare two array lists
	public boolean equals(T[] item)
	{
		boolean temp = true;
		for(int i = 0; i < list.length; i++)
			if(!list[i].equals(item[i]))
				temp = false;
		if(temp)
			return true;
		else
			return false;
	}
	
	//Add single item to the end of the list
	public void add(T item) throws ListException
	{
		if(item == null)
			throw new ListException("Error. Unable to add. Cannot add null entries.");
		else
		{
			if(counter == list.length)
				resize();
			list[counter] = item;
			counter++;
		}
	}
	
	//Insert single item in a specific position in the list
	public void add(T item, int position) throws ListException
	{
		position--;
		if(item == null)
			throw new ListException("Error. Unable to insert. Attempt to insert null object.");
		else if(counter == 0)
			throw new ListException("Error. Unable to insert. List is empty.");
		else if(position > list.length || position < 0 || position >= counter)
			throw new ListException("Error. Unable to insert. Bad position.");
		else
		{
			if(counter == list.length)
				resize();
			for(int i = (counter - 1); i >= position; i--)
				list[i + 1] = list[i];
			list[position] = item;
			counter++;
		}
	}
	
	//Return item at a given position
	public T get(int pos) throws ListException
	{
		pos--;
		if(pos < 0 || pos >= counter)
			throw new ListException("Error. Unable to get. Bad position.");
		else if(isEmpty())
			throw new ListException("Error. Unable to get. List is empty.");
		else
			return list[pos];
	}
	
	//Replace an item at a given position and return the item that was in that position
	public T set(T item, int pos) throws ListException
	{
		pos--;
		if(item == null)
			throw new ListException("Error. Unable to replace. Replacement can not be null.");
		else if(pos < 0 || pos >= counter)
			throw new ListException("Error. Unable to replace. Bad postion.");
		else if(isEmpty())
			throw new ListException("Error. Unable to replace. List is empty.");
		else
		{
			T temp = list[pos];
			list[pos] = item;
			return temp;
		}
	}
	
	//Return the index of the entered item or -1 if item not found
	public int find(T item, int startPos, int endPos) throws ListException
	{
		startPos--;
		endPos--;
		if(startPos < 0 || startPos >= counter)
			throw new ListException("Error. Unable to find. Start and/or end position bad.");
		else if(endPos < 0 || endPos >= counter)
			throw new ListException("Error. Unable to find. Start and/or end position bad.");
		else if(startPos > endPos)
			return -1;
		else
		{
			for(int i = startPos; i <= endPos; i++)
			{
				if(list[i].equals(item))
					return i + 1;
			}
			return -1;
		}
	}
	
	//Remove an item in this list at a given position
	public void remove(int pos)throws ListException
	{
		pos--;
		if(pos < 0 || pos >= counter)
			throw new ListException("Error. Unable to remove. Bad position.");
		else if(isEmpty())
			throw new ListException("Error. Unable to remove. List is empty.");
		else
		{
			for(int i = pos; i < counter; i++)
				list[i] = list[i + 1];
			counter--;
		}
	}
	
	//Clear list and set counter to 0
	public void clear()
	{
		for(int i = 0; i < counter; i++)
			list[i] = null;
		counter = 0;
	}
	
	//Return the array of items
	public T[] toArray()
	{
		if(isEmpty())
			return (T[])(new Object[20]);
		else
			return list;
	}
	
	//Check if array is empty
	public boolean isEmpty()
	{
		if(counter == 0)
			return true;
		else
			return false;
	}
	
	//Return the contents of the array
	public String toString()
	{
		String msg = "";
		if(isEmpty())
			return "The list is empty.\n";
		else
		{
			for(int i = 0; i < counter; i++)
				msg += list[i] + "\n";
			return msg;
		}
	}
}
