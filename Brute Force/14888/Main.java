import java.io.*;
import java.util.*;

public class Main{

	private static HashMap<Integer,Integer> ops = new HashMap<Integer,Integer>();
	private static int[] seq;
	private static int n, max = -1000000000, min = 1000000000;

	public static void main(String[] args) throws IOException{

		StringTokenizer st;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		seq = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) seq[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 4; i++) ops.put(i, Integer.parseInt(st.nextToken()));
		
		solve(seq[0], 0, 0);
		System.out.println(max + "\n" + min);
		br.close();
	}

	// sum: 누적합, idx: 수열의 색인, c: 사용된 연산자의 수
	private static void solve(int sum, int idx, int c){

		// 모든 연산자를 사용했을 경우 최댓값, 최솟값 비교 후 메소드 탈출.
		if(c == n - 1){

			max = Math.max(max, sum);
			min = Math.min(min, sum);
			return ;
		}

		// 반복문을 통한 연산자 사용.
		for(int i = 0; i < 4; i++){

			// 사용할수 있는 연산자가 남아있지 않다면 스킵.
			if(ops.get(i) == 0) continue;
			ops.put(i, ops.get(i)-1); // 연산자 사용. 남은 갯수 감소.
			operate(i, sum, idx+1, c+1);
			ops.put(i, ops.get(i)+1); // 갯수 복구.
		}
	}
	
	// op: 연산자 종류, sum: 누적합, idx: 수열의 색인, c: 사용된 연산자의 수
	private static void operate(int op, int sum, int idx, int c){

		// 연산자별 계산.
		switch(op){
			// '+'
			case 0 :
				solve(sum + seq[idx], idx, c);
				break;
				
			// '-'
			case 1 :
				solve(sum - seq[idx], idx, c);
				break;

			// '*'
			case 2 :
				solve(sum * seq[idx], idx, c);
				break;

			// '/'
			case 3 :
				if(sum < 0){ // 누적합이 음수일 경우.
					sum = -sum / seq[idx];
					solve(-sum, idx, c);
				} else {
					solve(sum / seq[idx], idx, c);
				}
		}
	}
}