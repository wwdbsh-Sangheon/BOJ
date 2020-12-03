import java.io.*;
import java.util.*;

public class Main{

	public static void main(String[] args) throws IOException{

		StringTokenizer st;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Integer[][] meeting = new Integer[n][2];
		for(int i = 0; i < n; i++){
			st = new StringTokenizer(br.readLine());
			meeting[i][0] = Integer.parseInt(st.nextToken());
			meeting[i][1] = Integer.parseInt(st.nextToken());
		}

		// 시작시간을 기준으로 오름차순 정렬.
		Arrays.sort(meeting, new Comparator<Integer[]>(){
			@Override
			public int compare(Integer[] m1, Integer[] m2){
				if(m1[0] < m2[0]) return -1;
				else if(m1[0] == m2[0]) return 0;
				else return 1;
			}
		});

		int start = meeting[0][0];
		int end = meeting[0][1];
		int count = 1;

		for(int i = 1; i < n; i++){
			// 새로운 미팅의 시작과 끝 시간이 기존 시작과 끝 시간 범위 안에 있으면 시작과 끝 시간 갱신.
			if(meeting[i][0] >= start && meeting[i][1] < end){
				start = meeting[i][0];
				end = meeting[i][1];
			// 새로운 미팅의 시작 시간이 기존의 끝나는 시간 보다 크거나 같다면 갱신 후 개수 1증가.
			}else if(meeting[i][0] >= end){
				start = meeting[i][0];
				end = meeting[i][1];
				count++;
			}
		}
		System.out.println(count);
		br.close();
	}
}