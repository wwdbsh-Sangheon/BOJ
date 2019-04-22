import java.io.*;
import java.util.*;

public class Main{

	private static Queue<String> queue = new LinkedList<String>();
	private static int n, count = 0;

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		if(n == 0){ // 0번째 감소하는 수 -> 0
			System.out.println(0);
			br.close();
			return ;
		}

		// 한자릿수 수들. 큐에 삽입한다.
		for(int i = 1; i < 10; i++){
			if(n == i){ // n번째 감소하는 수 -> i
				System.out.println(i);
				br.close();
				return ;
			}
			queue.offer(String.valueOf(i));
		}
		descendingNumber(queue.poll(), 1);
		br.close();
	}

	// head: 큐의 머리. count번째 감소하는 수, count: 감소하는 수의 순서.
	private static void descendingNumber(String head, int count){
		
		// count가 n과 같을 때 head 출력 후 재귀 탈출.
		if(count == n){
			System.out.println(head);
			return ;
		}

		/*
		큐가 비었을 때 재귀 탈출.(감소하는 수가 없음을 의미)
		하지만, 가장 마지막 감소하는 수인 9876543210은 예외처리해준다.
		왜냐하면, 가장 마지막 전 감소하는 수인 987654321이 이미 큐에서 나온 상태라
		큐가 비어있기 때문이다.
		*/
		if(queue.isEmpty())
		{
			if(n == 1022) System.out.println("9876543210");
			else System.out.println(-1); // n번째 감소하는 수가 존재하지 않을시 -1 출력.
			return ;
		}

		// head의 일의 자리 숫자.
		int digit = Integer.parseInt(head.substring(head.length()-1));

		// digit 보다 작은 수들은 head에 붙여서 차례대로 큐에 삽입한다.
		for(int new_digit = 0; new_digit < digit; new_digit++){
			queue.offer(head + String.valueOf(new_digit));
		}
		descendingNumber(queue.poll(), count+1); // 큐의 head를 꺼내고, count를 증가시킨다..
	}
}