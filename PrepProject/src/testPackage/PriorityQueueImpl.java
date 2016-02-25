package testPackage;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;



public class PriorityQueueImpl {
	
	public static void main(String[] args)
	{
		/*Comparator<Item> cmp = new Comparator<PriorityQueueImpl.Item>() {

			@Override
			public int compare(Item o1, Item o2) {
				// TODO Auto-generated method stub
				return o1.name.compareTo(o2.name);
			}
		};*/
		
		Comparator<Item> cmp1 = new Comparator<PriorityQueueImpl.Item>() {

			@Override
			public int compare(Item o1, Item o2) {
				// TODO Auto-generated method stub
				System.out.println("Compairing Price:"+o1.price+" Name:"+o1.name+" with Price:"+o2.price+" Name:"+o2.name);
				
				if((o1.price - o2.price) > 0)
				{
					return 1;
				}
				
				else if((o1.price - o2.price) < 0)
				{
					return -1;
				}
				else
				{
					return 0;
				}
			}
		};
		
		System.out.println("Sorting based on value: ");
		Queue<Item> queue = new PriorityQueue<Item>(cmp1);
		queue.add(new Item("BlackBerry",1400));
		
		queue.add(new Item("Lumia", 1000));
		
		queue.add(new Item("Nokia", 300));
		
		queue.add(new Item("Microsoft", 800));
		
		queue.add(new Item("Get",500));
		
		while(!queue.isEmpty())
		{
			Item item = queue.poll();
			System.out.println(item.name +" "+item.price);	
		}
		
		/*System.out.println("\nItem sorted based on name: ");
		Queue<Item> queue1 = new PriorityQueue<Item>(cmp);
		queue1.add(new Item("BlackBerry",1400));
		queue1.add(new Item("Nokia",300));
		queue1.add(new Item("Microsoft",800));
		queue1.add(new Item("Lumia",1000));
		
		for(Item item : queue1)
		{
			System.out.println(item.name +" "+item.price);	
		}*/
	}
	
	
	private static class Item /*implements Comparable<Item>*/
	{
		private String name;
		private int price;
		
		Item(String name, int price)
		{
			this.name = name;
			this.price = price;
		}

		/*@Override
		public int compareTo(Item o) {
			// TODO Auto-generated method stub
			
			System.out.println("Compairing Price:"+this.price+" Name:"+this.name+" with Price:"+o.price+" Name:"+o.name);
			
			if((this.price - o.price) > 0)
			{
				return 1;
			}
			
			else if((this.price - o.price) < 0)
			{
				return -1;
			}
			else
			{
				return 0;
			}
		}*/
	}
}
