package cifrarioHill;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
	
		CifrarioHill cif=new CifrarioHill();
		
		
//		System.out.println(cif.kString("YYPRZWIZJ"));
//		int[][] m=cif.kString("XZWETYGHF");
//		for(int i=0;i<m.length;i++) {
//			for(int j=0;j<m[i].length;j++) {
//				System.out.print(m[i][j]+" ");
//			}
//			System.out.println();
//		}
//		
//		
//		System.out.println(cif.deter(m));
//		int[][] mi=cif.inversa(m);
//		System.out.println("");
//				for(int i=0;i<mi.length;i++) {
//					for(int j=0;j<mi[i].length;j++) {
//						System.out.print(mi[i][j]+" ");
//					}
//					System.out.println();
//				}
		
//		System.out.println(cif.cifrattura("TUO", "YYPRZWIZJ"));
//		System.out.println(cif.deci("CNY", "YYPRZWIZJ"));
		Scanner s=new Scanner(System.in);
		int n;
		do {
		do {
			System.out.println("1.cifrattura"
				+ "\n2.decifratura"
				+ "\n0.esci");
			n=s.nextInt();
		}while(n<0||n>2);
		String st;
		String k;
		switch(n) {
		case 1:
			System.out.println("inserisci il messaggio");
			st=s.next();
			System.out.println("inserisci la chiave");
			k=s.next();
			System.out.println(cif.cifrattura(st, k));
			break;
		case 2:
			System.out.println("inserisci il messaggio");
			st=s.next();
			System.out.println("inserisci la chiave");
			k=s.next();
			System.out.println(cif.deci(st, k));
			break;
		
		}
		}while(n!=0);

	}

}
