import java.io.*;
import java.util.*;

public class Main{

	private static char[] alphabets = {'A', 'B', 'C', 'D', 'E', 'F', 'G',
										'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
										'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
										'X', 'Y', 'Z'};

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String name = br.readLine();
		char[] palindrome = new char[name.length()];
		int[] count = new int[26];
		int odd = 0;
		for(int idx = 0; idx < name.length(); idx++){
			count[(int)(name.charAt(idx)) - 65]++; // 이름에 포함된 각각의 알파벳 숫자 카운트.
		}
		for(int i = 0; i < 26; i++){
			// 포함된 특정 알파벳의 수가 홀수일때 펠린드롬의 정중앙에 알파벳 위치시키고, 카운트는 감소시키며, 홀수개의 알파벳 종류 개수 증가.
			if(count[i] % 2 == 1){
				palindrome[name.length()/2] = alphabets[i];
				count[i]--;
				odd++;
			}
		}

		// 홀수개의 알파벳 수가 2개 이상이면 펠린드롬 만들 수 없음.
		if(odd > 1){
			System.out.println("I'm Sorry Hansoo");
		}else{

			// left: 펠린드롬 왼쪽 포인터, right: 펠린드롬 오른쪽 포인터, idx: 알페벳의 종류를 정해줄 색인.
			int left = 0, right = name.length()-1, idx = 0;

			// 왼쪽 포인터가 오른쪽 포인터 보다 크거나 같아지면 반복문 탈출.
			while(left < right){

				// 사용할 수 있는 알페벳이 남아있지 않다면 스킵 후, idx 증가(idx가 0부터 시작하기 때문에 사전순으로 진행된다).
				if(count[idx] == 0){
					idx++;
					continue;
				}

				// 왼쪽, 오른쪽 알파벳 삽입.
				palindrome[left++] = alphabets[idx];
				palindrome[right--] = alphabets[idx];
				count[idx] -= 2; // 사용한 2개의 알파벳 수 빼주기.
			}

			StringBuilder sb = new StringBuilder();
			for(char c : palindrome) sb.append(c); // 정답 도출.
			System.out.println(sb.toString());
		}
		br.close();
	}
}