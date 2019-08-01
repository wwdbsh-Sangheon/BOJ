import java.util.*;
import java.math.*;
// 팁을 많이 주는 사람을 앞에 배치.
public class Main{

	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Integer[] guests = new Integer[n];
		for(int i = 0; i < n; i++){
			guests[i] = sc.nextInt();
		}

		Arrays.sort(guests, new Comparator<Integer>(){
			public int compare(Integer g1, Integer g2){
				return g1 > g2 ? -1 : (g1 == g2 ? 0 : 1);
			}
		});

		BigInteger ans = new BigInteger("0");

		for(int i = 0; i < n; i++){
			int tip = guests[i] - i;
			if(tip < 0) break;
			ans = ans.add(BigInteger.valueOf(tip));
		}
		System.out.println(ans.toString());
		sc.close();
	}
}