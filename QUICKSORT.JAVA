import java.util.*;
public class quick{
	public static int partition (int a[], int low, int high){
		int pivot = a[low], i = low+1, j = high;
		while(i<=j){
			while(a[i]<=pivot && i<=j)
				i++;
			while(a[j]>=pivot && i<=j)
				j--;
			if(i<j)
				swap(a,i,j);
		}
		swap(a,j,low);
		return j;
	}
	
	public static void swap(int a[], int i, int j){
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public static void quick(int a[], int low, int high){
		if(low<high){
			int j=partition(a,low,high);
			quick(a,low,j-1);
			quick(a,j+1,high);
		}
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter array size: ");
		int n = sc.nextInt();
		int arr[] = new int[n];
		System.out.println("Enter array elements: ");
		for(int i=0; i<n; i++)
			arr[i] = sc.nextInt();
		quick(arr,0,n-1);
		System.out.println("Sorted array: ");
		for(int num: arr)
			System.out.println(num + " ");
	}
}
