import java.io.*;
import java.util.*;

public class Main{

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int j = Integer.parseInt(br.readLine());
		int[] apple = new int[j];
		for(int i = 0; i < j; i++){
			apple[i] = Integer.parseInt(br.readLine());
		}

		int ans = 0;
		LinkedList<Integer> basket = new LinkedList<Integer>();
		// 바구니가 차지하고 있는 영역 넣어주기.
		for(int i = 1; i <= m; i++) basket.add(i);
		if(basket.size() == 1) basket.add(basket.peek());

		// 바구니가 차지하는 가장 앞과 뒤만 비교.
		for(int i = 0; i < j; i++){
			if(basket.peekLast() < apple[i]){
				int move = apple[i] - basket.pollLast();
				basket.addFirst(basket.pollFirst() + move);
				basket.addLast(apple[i]);
				ans += move;
			}else if(basket.peekFirst() > apple[i]){
				int move = basket.pollFirst() - apple[i];
				basket.addFirst(apple[i]);
				basket.addLast(basket.pollLast() - move);
				ans += move;
			}
		}
		System.out.println(ans);
		br.close();
	}
}