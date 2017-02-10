/**
 * 
 */
package timer;

/**
 * @author b1014246
 *
 */
public class CalcTest {
	
	public static void main(String[] args) {
		int sec;
		int h = 0;
		int m = 0;
		int s = 0;
		int k = 0;
				
		sec = 5399;
		
		h = sec / 3600;
		k = sec % 3600;
		m = k / 60;
		s = k % 60;
		
		String a = h + ":" + m + ":" + s;
		System.out.println(a);
	}
}
