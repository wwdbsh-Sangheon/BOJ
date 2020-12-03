import java.io.*;
import java.util.*;

public class Main{

	private static long[] ab, cd;
	private static int n, right;

	public static void main(String[] args) throws IOException{

		StringTokenizer st;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		long[][] abcd = new long[4][n];
		for(int i = 0; i < n; i++){
			st = new StringTokenizer(br.readLine());
			abcd[0][i] = Integer.parseInt(st.nextToken());
			abcd[1][i] = Integer.parseInt(st.nextToken());
			abcd[2][i] = Integer.parseInt(st.nextToken());
			abcd[3][i] = Integer.parseInt(st.nextToken());
		}
		
		ab = new long[n*n];
		cd = new long[n*n];

		/*
		수행시간을 줄이기 위해 2개 배열로 나눈다.
		4개의 배열을 4중 for문으로 완전탐색하면 4000^4번 루프를 돌기 때문에 시간초과가 난다.
		배열을 2개로 나누고 이분탐색을 통해 시간복잡도를 o(n^2lgn^2)으로 줄일 수 있다.
		*/
		for(int i = 0, idx = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				ab[idx] = abcd[0][i] + abcd[1][j];
				cd[idx] = abcd[2][i] + abcd[3][j];
				idx++;
			}
		}

		// 이분탐색을 위해 정렬.
		Arrays.sort(ab);
		Arrays.sort(cd);

		right = n*n; // 이분탐색의 upper_bound로 사용되어질 변수.
		long count = 0, ans = 0;

		for(int i = 0; i < n*n; i++){
			if(i > 0 && ab[i-1] == ab[i]){ // 이전 값과 같을 경우 이전 값에서 더해준 count값을 더해준다.
				ans += count;			   // 이전 루프에서의 이분탐색으로 처리해준 값과 동일하기 때문에 
			}else{						   // 중복을 피함으로써 시간을 줄인다.
				count = binarySearch(-ab[i]); // 이분탐색.
				ans += count;
			}
		}
		System.out.println(ans);
		br.close();
	}

	/*
	중복되는 값들을 카운트하기 위한 메소드.
	idx: 값의 기준이 되는 색인, plus: 1 or -1(진행방향)
	*/
	private static int getCount(int idx, int plus){

		int ret = 0, index = idx + plus; // index: idx 옆(왼쪽 혹은 오른쪽)을 가리킬 색인.

		// index가 배열의 범위를 벗어나거나, 새로 가리키는 값과 기준 값이 같지 않을 때 까지 반복문 진행.
		while(index >= 0 && index < n*n && cd[idx] == cd[index]){
			if(right > index) right = index; // upper_bound가 index보다 크다면 index로 갱신.(이미 지나쳐온 값은 앞으로 고려할 필요가 없기 때문에)
			index += plus;
			ret++;
		}

		return ret;
	}

	// 이분탐색. ab_v: 비교할 값
	private static int binarySearch(long ab_v){

		int lower = 0, upper = right;

		while(lower <= upper){

			int mid = (lower + upper) / 2;
			if(mid < 0 || mid >= n*n) break; // 배열의 범위를 벗어날 경우 예외처리.

			if(ab_v == cd[mid]){ // 두 값이 같다면, upper_bound 갱신 후 mid를 기준으로 앞뒤 같은 값들의 수를 반환.
				right = mid;
				return getCount(mid, 1) + getCount(mid, -1) + 1;
			}else if(ab_v < cd[mid]){
				upper = mid - 1;
			}else{
				lower = mid + 1;
			}
		}

		return 0;
	}
}