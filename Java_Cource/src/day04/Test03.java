package day04;

public class Test03 {

	public static void main(String[] args) {
		/*
		 * 	Sudden Mission!!
		 * 		- print GuGuDan!
		 * 
		 * 	after...
		 * 		continue, break, return	*****
		 * 
		 */
		
		// GuGudan
		for ( int i=1 ; i<10 ; i++ ) {
			for ( int j=2 ; j<10 ; j++ ) {
//				if(j==5) break;
				if(j==5) continue;			// 5단만 제외
				System.out.printf(" %d x %d = %2d |", j, i, j*i );
			}
			System.out.println();
		}
		
		// break point 'A'
		A: for ( int i=1 ; i<10 ; i++ ) {
			for ( int j=2 ; j<10 ; j++ ) {
				if(j==5) break A;			// labeling : break point 'A'
				System.out.printf(" %d x %d = %2d |", j, i, j*i );
			}
			System.out.println();
		}
		
	}

}
