package cifrarioHill;

public class CifrarioHill {


	private int[][] mString(String s) {
		if(s.length()%3!=0) {
		for (int i =s.length() % 3;i<=3 ; i++) {
			s += "x";
		}}

		int col = s.length() / 3;
		int[][] matrice = new int[3][col];

		int c = 0;
		for (int i = 0; i < col; i++) {
			for (int j = 0; j < 3; j++) {
				matrice[j][i] = (int) s.charAt(c) - 65;
				c++;
			}
		}
//		System.out.println(matrice.length+ " "+matrice[1].length);
		return matrice;
		
		
		
	}
	
	private int[][] kString(String s) {
		if(s.length()%3!=0) {
		for (int i =s.length() % 3;i<=3 ; i++) {
			s += "x";
		}}

		int col = s.length() / 3;
		int[][] matrice = new int[3][col];

		int c = 0;
		for (int i = 0; i < col; i++) {
			for (int j = 0; j < 3; j++) {
				matrice[i][j] = (int) s.charAt(c) - 65;
				c++;
			}
		}
		
		return matrice;
		
		
		
	}
	
	
	private int deter(int[][] mk) {
		
		
		
			
		int d=	mk[0][0]*(mk[1][1]*mk[2][2]-mk[1][2]*mk[2][1])-mk[0][1]*(mk[1][0]*mk[2][2]-mk[1][2]*mk[2][0])+mk[0][2]*(mk[1][0]*mk[2][1]-mk[1][1]*mk[2][0]);
		
		if((d%26)<0){
			return (d%26)+26;
		}
		else {
		return Math.abs(d%26);}
		
		
	}
	
	private int[][] inversa(int[][] m){
		
		int[] minore=new int[4];
		int[][] m1=new int[3][3];
		int c;
		int d;
		
		for(int i=0;i<m.length;i++) {
			for(int j=0;j<m[i].length;j++) {
				m1[i][j]=m[j][i];
			}
		}
		
//		for(int i=0;i<m.length;i++) {
//			for(int j=0;j<m[i].length;j++) {
//				System.out.print(m1[i][j]+" ");
//			}
//			System.out.println();
//		}
		int[][] mi=new int[3][3];
		int inversa1=0;
		int ris=0;
		int l=0;
		while(ris!=1) {
			l=deter(m)*inversa1;
			ris=l%26;
			if(ris!=1)
				inversa1++;
		}
//		System.out.println("\n\n"+inversa1+" "+deter(m));
		for(int i=0;i<m.length;i++) {
			for(int j=0;j<m[i].length;j++) {
//				matrice minore
				c=0;
				for(int ii=0;ii<m.length;ii++) {
					for(int jj=0;jj<m[ii].length;jj++) {
						if(ii!=i&&jj!=j) {
							minore[c]=m1[ii][jj];
							
//							System.out.print(minore[c]+" ");
							c++;
						}
						
					}
				}//
				//determinate minore
				d=(minore[0]*minore[3])-(minore[1]*minore[2]);
				mi[i][j]=d;
				
//				System.out.print(mi[i][j]+" ");
				
			}
		}
		mi[0][1]*=(-1);
		mi[1][0]*=(-1);
		mi[1][2]*=(-1);
		mi[2][1]*=(-1);
		
		for(int i=0;i<m.length;i++) {
			for(int j=0;j<m[i].length;j++) {
				mi[i][j]*=inversa1;
			}
		}
		
		for(int i=0;i<m.length;i++) {
			for(int j=0;j<m[i].length;j++) {
				mi[i][j]=mi[i][j]%26;
				if(mi[i][j]<0) {
					mi[i][j]+=26;
				}
			}
		}
		
		return mi;
		
	}
	
	public String cifrattura(String ms, String ks) {
		ks=ks.toUpperCase();
		int [][]k=kString(ks);
		if(isInvertibile(k)&&deter(k)%2!=0&&deter(k)%13!=0) {
		ms=ms.toUpperCase();
		int [][]m= mString(ms);
		int[] intC = new int[m.length*m[0].length];
//		System.out.println(intC.length);

		for (int f = 0; f < (m.length) * (m[0].length); f++) {
			intC[f] = 0;
		}
		
		int mr;
		int c = 0;
		for (int mcol = 0; mcol < m[0].length; mcol++) {
			for (int kr = 0; kr < k.length; kr++) {
				for (int kcol = 0; kcol < k[kr].length; kcol++) {
					mr = kcol;
					intC[c]+=(m[mr][mcol]*k[kr][kcol]);
					
				}
				c++;
			}
			
		
		}
//		System.out.println(c);
		return fine(intC);
		}
		else {
			System.out.println("chiave impossibile");
			return null;
		}
		
	}

	public String deci(String ms, String ks) {
		int [][]k=kString(ks);
		if(isInvertibile(k)&&deter(k)%2!=0&&deter(k)%13!=0) {
		int[][] ik=inversa(k);
		
		
		
		int[] vk=new int[9];
		int c=0;
			for (int kr = 0; kr < k.length; kr++) {
				for (int kcol = 0; kcol < k[kr].length; kcol++) {
					vk[c]+=ik[kr][kcol];
					c++;
				}
				
			
		
		}
			
		ks=fine(vk);
		
		
		return cifrattura(ms,ks);}
		else {
			System.out.println("chiave impossibile");
			return null;
		}

		
		
		
	}

	private String fine(int[] intC) {
		String s="";
//		System.out.println(intC.length);
		
		for (int f = 0; f <intC.length; f++) {
			s+=(char)((intC[f]%26)+65);
//			System.out.println("s");
		}
		
		return s;
	}
	
	private boolean isInvertibile(int[][] m) {
		if(deter(m)==0) {
			return false;
		}
		else {
			return true;
		}
	}
}

