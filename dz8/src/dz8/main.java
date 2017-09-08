package dz8;

public class main {

	public static void main(String[] args) {

		Matrix mat = new Matrix();
		mat.create();
		mat.fillrandom();
		mat.show();
		mat.showElem(mat.n-1, mat.m-1);
		
		Stroki str = new Stroki();
		str.create();
		str.show();
		
	}

}
