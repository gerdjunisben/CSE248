package p1;

import java.util.ArrayList;

public class ItemStore {
	private ArrayList<Item> list;
	
	public ItemStore()
	{
		list = new ArrayList<>();
	}
	
	public void add(Item item)
	{
		list.add(item);
	}
	
	public void displayItems()
	{
		list.forEach((i)->{
			System.out.println(i);
		});
	}
}
