/**
* @author Christopher Lillthors
* @version 2.0
*/
interface Set<T> {
	public boolean add(T element);
	public boolean contains(T data);
	public int numberOfElements();
	public int getHeight();
	public int getNumberOfLeafs();
	public String toString();
}