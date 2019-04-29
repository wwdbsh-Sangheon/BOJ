import java.io.*;
import java.util.*;

public class Main{

	private static HashMap<Integer,Boolean> alpha = new HashMap<>();
	private static String[] words;
	private static int n, k, ans = 0;

	public static void main(String[] args) throws IOException{

		StringTokenizer st;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		words = new String[n];
		
		// 남극의 단어는 모두 anta로 시작 그리고 tica로 끝난다. 즉, a,c,i,n,t 다섯 글자를 가르칠 수 없다면 읽을 수 있는 단어의 개수는 0개이다.
		if(k < 5){
			System.out.println(ans);
			return ;
		}

		// 글자를 가르쳤는지 확인해주는 해쉬맵을 생성한다.
		for(int i = 0; i < 26; i++){
			alpha.put(i, false);
		}

		// 기본적으로 배워야하는 a,c,i,n,t는 모두 가르친 것으로 체크한다.
		alpha.put('a' - 97, true);
		alpha.put('c' - 97, true);
		alpha.put('i' - 97, true);
		alpha.put('n' - 97, true);
		alpha.put('t' - 97, true);

		// 단어 배열을 형성한다. 단, 처음 anta와 끝 tica는 잘라내준다(수행속도를 줄이기 위해).
		for(int i = 0; i < n; i++){
			String word = br.readLine();
			words[i] = word.substring(4, word.length()-4);
		}
		teach(1, 5); // a는 이미 가르쳤기 때문에 start는 1(b)로 설정하고, 기본적으로 5개의 글자를 가르쳤기 때문에 count는 5로 설정한다.
		System.out.println(ans);
		br.close();
	}

	// start: 가르칠 알파벳 순서의 시작을 나타내는 변수, count: 가르친 알파벳의 개수.
	private static void teach(int start, int count){

		// k개의 알파벳을 가르쳤다면 읽을 수 있는 단어의 개수를 체크한뒤 재귀를 탈출한다.
		if(count == k){

			int ret = 0;

next_word:	for(String word : words){
				for(int i = 0; i < word.length(); i++){
					// 글자를 읽을 수 없다면 다음 단어로 넘어간다.
					if(!alpha.get(word.charAt(i) - 97)){
						continue next_word;
					}
				}
				ret++; // 읽을 수 있는 단어 개수를 늘려준다.
			}
			ans = Math.max(ans, ret);
			return ;
		}

		for(int i = start; i < 26; i++){
			// 배우지 않은 알파벳인 경우 가르친다.
			if(!alpha.get(i)){
				alpha.put(i, true);
				teach(i+1, count+1);
				alpha.put(i, false);
			}
		}
	}
}