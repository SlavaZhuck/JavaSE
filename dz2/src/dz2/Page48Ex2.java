package dz2;

public class Page48Ex2 {

	public static void main(String[] args) {

		int i = 1 , sum = 0, umn = 1, count = 0;
		
		while (umn <= 300 && sum <= 200){
			//System.out.println(i);			
			umn=umn*i;
			sum+=i;
			i+=3;
			count++;			
		}
		
		System.out.println(count);
	}

}
