package model;
/**
 * A simple bag made to hold strings with an array
 * @author Benjamin Gerdjunis
 *
 */
public class StringBag {
	private String[] arr;
	private int nElems;
	
	/**
	 * Constructor for the StringBag
	 * @param int maxSize
	 */
	public StringBag(int maxSize)
	{
		arr = new String[maxSize];
		nElems = 0;
	}
	
	/**
	 * Takes a string and inserts it into the next available array slot
	 * @param str
	 */
	public void insert(String str)
	{
		arr[nElems++] = str;
	}
	
	public int getNElems()
	{
		return nElems;
	}
	
	public String get(int n)
	{
		return arr[n];
	}
}
