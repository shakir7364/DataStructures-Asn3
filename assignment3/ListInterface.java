package assignment3;

public interface ListInterface<T> 
{
	public void add(T item) throws ListException;
	public void add(T item, int position) throws ListException;
	public T get(int pos) throws ListException;
	public T set(T item, int pos) throws ListException;
	public int find(T item, int startPos, int endPos) throws ListException;
	public void remove(int pos)throws ListException;
	public void clear();
	public T[] toArray();
	public boolean isEmpty();
}
