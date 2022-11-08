import java.util.ArrayList;
import java.util.Scanner;
public class BSTsum {
	ArrayList<Integer>nodelist=new ArrayList<>();
	public static Node newNode(int Z)
	{
		Node temp=new Node();
		temp.left=null;
		temp.data=Z;
		temp.right=null;
		return temp;
		
	}
	
	public void insert(Node root,Node nn) 
	{
		if(nn.data < root.data) 
		{
			if(root.left==null) 
			{
				root.left=nn;
			}
			else 
			{
				insert(root.left,nn);
			}
		}
			
		else 
		{
			if(root.right==null) 
			{
				root.right=nn;
			}
			else 
			{
				insert(root.right,nn);
			}
			
		}
	}
	private void traverse(Node root) 
	{
		if(root!=null) 
		{
			traverse(root.left);
			nodelist.add(root.data);
			traverse(root.right);
			
		}
		
	}
			
	public static void main(String args[]) 
	{
		BSTsum bst=new BSTsum();
		Node root =null;
		Node nn =null;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Number of Nodes");
		int k=sc.nextInt();
		int i;
		for (i=1;i<=k;i++) {
			System.out.println("Enter Data for the Node");
			int n=sc.nextInt();
			nn=newNode(n);
			if(root==null) 
			{
				root=nn;
				
			}
			else 
			{
				bst.insert(root,nn);
			}
			
		}
		bst.traverse(root);
		System.out.println("Enter the Sum");
		int sum=sc.nextInt();
		int flag=0;
		
		for(i=0;i<bst.nodelist.size();i++) {
			if(bst.nodelist.contains(sum-bst.nodelist.get(i))) 
			{
				int a=bst.nodelist.get(i);
				int b=sum-bst.nodelist.get(i);
				
				System.out.println("Pair Found ["+a+","+b+"]");
				flag=1;
				break;
			}
		}
		if(flag==0) 
		{
			System.out.println("No Pair Found");

		}
		
	}

}
