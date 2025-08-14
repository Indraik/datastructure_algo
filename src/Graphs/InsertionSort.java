package Graphs;

public class InsertionSort {

	public static void main(String[] args) {
		int[] arr = {2,14,5,3,6};
		int current = 0,j;
		for(int i=1;i<arr.length;i++) {
			current = arr[i];
			j=i-1;
			
			while(j>0 && arr[i]>current) {
				arr[j+1]=arr[j];
				j--;
			}
			arr[j+1] = current;
		}
		PrintArray(arr);
		

	}
	public static void PrintArray(int[] arr) {
		for(int num:arr) {
			System.out.print(num+" ");
		}
		System.out.println();
		
	}

}
