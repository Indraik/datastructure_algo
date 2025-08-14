package Graphs;

public class BubbleSort {

	public static void main(String[] args) {
//		int[] arr = {5, 24, 4, 27, 12, 23, 10, 15};
//		int[] arr = {8,3,6,4,6};
		int[] arr = {11,22,33,44,55,8,7,6,5,4,3,2,1};
		System.out.print("Original Array : ");
		PrintArray(arr);
		System.out.println("Array Length : "+arr.length);		
		boolean swap = false;
		for(int i=0;i < arr.length;i++) {
			for(int j=0;j<arr.length-1-i;j++) {
				if(arr[j]>arr[j+1]) {
					int temp=arr[j]; 
					arr[j]=arr[j+1];
					arr[j+1]=temp;
					swap = true;
				}				
			}
			if(!swap) {
				break;
			}
		}
		System.out.print("Sorted Array : ");
		PrintArray(arr);

	}
	public static void PrintArray(int[] arr) {
		for(int num:arr) {
			System.out.print(num+" ");
		}
		System.out.println();
		
	}

}
