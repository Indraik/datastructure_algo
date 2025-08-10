package Non_Linear;

import java.util.LinkedList;
import java.util.List;

public class Array {

	public static void main(String[] args) {
		
		List<Integer> li = new LinkedList<>();
		int[] arr = {14,5,7,23,6};
		int sum=0;
		for(int data:arr) {
			sum=0;
			for(int i=2;i<data/2;i++) {
				if(data%i==0) {
					sum=sum+i;
				}
			}
			if(sum==0) li.add(data);
		}
		System.out.println(li);

		List<Integer> res = new LinkedList<>();
		int fact=0,tsum=0;
		
		for(int data:li) {
			tsum=0;
			for(int j=2;j<data;j++) {
				fact=0;
				for(int k=2;k<data/2;k++) {
					if(j%k==0) {
						fact++;
					}
				}
				if(fact==0) {
					tsum=tsum+j;
				}
				
				if(tsum==data) {
					res.add(data);
				}
				
				
			}
		}
		
		


	}

}
