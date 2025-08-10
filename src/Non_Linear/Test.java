package Non_Linear;

public class Test {

	public static void main(String[] args) {
		//int i = 0;
		for(int i=0;i<10;i++) {
			if(i%2==0) {
				continue;				
			}
			System.out.println(i);
		}
		System.out.println();
		
		for(int i=0;i<5;i++) {
			System.out.println(i++);
		}
		System.out.println();
		int i=100;
		for(;i>50;) {
			i-=10;
			System.out.println(i+" ");
		}
		System.out.println();
//		for(;;) {
//			System.out.println("HI"); //output = infinity HI...........
//		}
//		System.out.println();
//		int a=0,b=5;
//		while(b--) {
//			System.out.println(a++);// OP = Error
//		}
//		System.out.println();
//		int a=0,b=10;
//		while(a+2<b) {
//			System.out.println(a);// OP = Infinity 0...........
//		}
//		System.out.println();
		int a=0,b=5;
		while(b-- > a++) {
			System.out.println(a);
		}
		System.out.println();
		
		int c=0,d=10;
		while(--d > c) {
			System.out.println(c);
			c++;
		}
		System.out.println();
		
		
		
//2956.1470.520.1480.1748.349.1464.3005.2011.2942		

	}

}


