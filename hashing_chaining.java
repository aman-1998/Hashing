import java.util.*;
import java.lang.*;
import java.io.*;

class HASH
{
	int h(int x,int m)
	{
		return x%m;
	}
	node[] insert(node[] HT,int m,int data)
	{
		node temp;
		int i=h(data,m);
		if(HT[i]==null)
		{
			temp=new node(data,null);
			HT[i]=temp;
			return HT;
		}
		temp=new node(data,HT[i]);
		HT[i]=temp;
		return HT;
	}
	int search(node[] HT,int m,int data)
	{
		int i=h(data,m);
		node t=HT[i];
		while(t!=null)
		{
			if(t.key==data)
				return i;
			t=t.link;
		}
		return -1;
	}
	node[] delete(node[] HT,int m,int data)
	{
		int i=h(data,m);
		node t=HT[i];
		if(t==null)
		{
			System.out.print("\n"+data+" not found\n");
			return HT;
		}
		if(t.key==data)
		{
			HT[i]=t.link;
			System.out.print("\n"+data+" is deleted\n");
			return HT;
		}
		while(t.link!=null)
		{
			if(t.link.key==data)
			{
				t.link=t.link.link;
				System.out.print("\n"+data+" is deleted\n");
				return HT;
			}
			t=t.link;
		}
		System.out.print("\n"+data+" not found\n");
		return HT;
	}
	void display(node[] HT,int m)
	{
		node t;
		for(int i=0;i<=m-1;i++)
		{
			if(HT[i]==null)
				System.out.print("null");
			else
			{
				t=HT[i];
				while(t!=null)
				{
					System.out.print(t.key+" ");
					t=t.link;
				}
			}
			System.out.println();
		}
	}
	public static void main(String args[])
	{
		int data,index,ch,i;
		Scanner in=new Scanner(System.in);
		System.out.print("Enter size of hash table: ");
		int m=in.nextInt();
		node[] HT=new node[m];
		for(i=0;i<=m-1;i++)
			HT[i]=null;
		HASH x=new HASH();
		while(true)
		{
			System.out.print("\n1.insert\n2.search\n3.delete\n4.display\n5.quit\n");
			System.out.print("Enter your choice: ");
			ch=in.nextInt();
			switch(ch)
			{
				case 1:
					System.out.print("\nEnter the key to be inserted: ");
					data=in.nextInt();
					HT=x.insert(HT,m,data);
					System.out.print("\n"+data+" is inserted\n");
					break;
				case 2:
					System.out.print("\nEnter the key to be searched: ");
					data=in.nextInt();
					index=x.search(HT,m,data);
					if(index!=-1)
						System.out.print("\n"+data+" is found at index "+index+"\n");
					else
						System.out.print("\n"+data+" is not found\n");
					break;
				case 3:
					System.out.print("Enter the key to be deleted: ");
					data=in.nextInt();
					HT=x.delete(HT,m,data);
					break;
				case 4:
					System.out.println("\nHash Table: ");
					x.display(HT,m);
					break;
				case 5:
					System.out.print("\n----------End of Program----------\n");
					System.exit(0);
				default:
					System.out.print("\nInvalid Input\n");
					break;
			}
		}
	}
}
class node
{
	int key;
	node link=null;
	node(int key,node link)
	{
		this.key=key;
		this.link=link;
	}
}