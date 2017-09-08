package dz2;

public class Page50Ex5 {

	public static void main(String[] args) {
	
		int count_div = 0;
		for(int i = 1 ; i <= 100 ; i++){
			for(int j = 1 ; j <= i ; j++){
				if(i % j == 0){
					count_div++;					
				}
			}
		if(count_div<3){
			System.out.println(i);				
		}	
		count_div = 0;
		}
	}

}
