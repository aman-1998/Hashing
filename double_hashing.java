import java.util.*;
import java.lang.*;
import java.io.*;

class DH
{
	int h(int k,int m)
	{
		return k%m;
	}
	int h2(int k,int m)
	{
		return 1+((k/m)%(m-1));
	}
	int[] insert(int[] HT,int m,int k)
	{
		int index1=h(k,m);
		if(HT[index1]==0 || HT[index1]==-1)
		{
			HT[index1]=k;
			System.out.println("\n"+k+" is inserted");
			return HT;
		}
		int index2;
		for(int i=0;i<=m-1;i++)
		{
			index2=h(index1+i*h2(k,m),m);
			if(HT[index2]==0 || HT[index2]==-1)
			{
				HT[index2]=k;
				System.out.println("\n"+k+" is inserted");
				return HT;
			}
		}
		System.out.print("\nThere is no empty space in the hash table\n");
		return HT;
	}
	int search(int[] HT,int m,int k)
	{
		int index1=h(k,m);
		if(HT[index1]==0)
			return -1;
		if(HT[index1]==k)
			return index1;
		int index2;
		for(int i=0;i<=m-1;i++)
		{
			index2=h(index1+i*h2(k,m),m);
			if(HT[index2]==0)
				return -1;
			if(HT[index2]==k)
				return index2;
		}
		return -1;
	}
	int[] delete(int[] HT,int m,int k)
	{
		int index1=h(k,m);
		if(HT[index1]==0)
		{
			System.out.print("\n"+k+" is not found\n");
			return HT;
		}
		if(HT[index1]==k)
		{
			HT[index1]=-1;
			System.out.print("\n"+k+" is deleted from index "+index1+"\n");
			return HT;
		}
		int index2;
		for(int i=0;i<=m-1;i++)
		{
			index2=h(index1+i*h2(k,m),m);
			if(HT[index2]==0)
			{
				System.out.print("\n"+k+" is not found\n");
				return HT;
			}
			if(HT[index2]==k)
			{
				HT[index2]=-1;
				System.out.print("\n"+k+" is deleted from index "+index2+"\n");
				return HT;
			}
		}
		System.out.print("\n"+k+" is not found\n");
		return HT;
	}
	void display(int[] HT,int m)
	{
		for(int i=0;i<=m-1;i++)
		{
			if(HT[i]==0 || HT[i]==-1)
				System.out.println("-empty-");
			else
				System.out.println(HT[i]);
		}
	}
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		int m,data,index,ch;
		System.out.print("Enter the size of hash table: ");
		m=in.nextInt();
		int[] HT=new int[m];
		DH x=new DH();
		while(true)
		{
			System.out.print("\n1.insert\n2.search\n3.delete\n4.display\n5.quit\n");
			System.out.print("\nEnter your choice: ");
			ch=in.nextInt();
			switch(ch)
			{
				case 1:
					System.out.print("\nEnter the key to be inserted: ");
					data=in.nextInt();
					HT=x.insert(HT,m,data);
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