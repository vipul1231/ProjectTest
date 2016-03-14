package complexityQuestions;

public class BinarySearchTree {
	
	class Node
	{
		int key;
		Node left, right;
		
		public Node(int item)
		{
			this.key = item;
			left = right = null;
		}
	}
	
	Node rootBST;
	
	
	void insertData(int key)
	{
		Node node = insertDataRec(rootBST, key);
		
		if(rootBST == null)
		{
			rootBST = node;
		}
	}
	
	Node insertDataRec(Node rootBST, int key)
	{
		if(rootBST == null)
		{
			Node firstNode = new Node(key);
			return firstNode;
		}
		else
		{
			Node newNode = new Node(key);		
			Node traverse = rootBST;
			Node nextNode = null;
			while(true)
			{
				if(traverse.key > key)
				{
					if(traverse.left == null)
					{
						break;
					}
					else
					{
						traverse = traverse.right;
					}
				}
				
				else if(traverse.key < key)
				{
					
				}
			}
		}
		
		
		return null;
	}
	
	public BinarySearchTree() {
		// TODO Auto-generated constructor stub
		rootBST = null;
	}
	
	public static void main(String[] args)
	{
		
	}

}
