import java.util.*;
public class merge{
	public static int[] b;
	
	public static void merge(int a[], int low, int high) {
		if(low < high){
			int mid = (low+high)/2;
			merge(a,low,mid);
			merge(a,mid+1,high);
			merge(a,low,mid,high);
		}
	}
	
	public static void merge(int a[],int low, int mid, int high) {
		int i = low, j = mid+1, k = low;
		while(i<= mid && j<= high){
			if(a[i] <= a[j])
				b[k++] = a[i++];
			else
				b[k++] = a[j++];
		}
		while (i <= mid)
			b[k++] = a[i++];
		while (j <= high)
			b[k++] = a[j++];
		for (int h=low; h<=high; h++)
			a[h] = b[h];
	}

	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter array size: ");
		int n = sc.nextInt();
		int arr[] = new int[n];
		b = new int[n];
		System.out.println("Enter array Elements: ");	
		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}
		merge(arr, 0, arr.length-1);
		System.out.println("Sorted Array: ");
		for(int num : arr)
			System.out.println(num + " ");
		sc.close();
	}
}
