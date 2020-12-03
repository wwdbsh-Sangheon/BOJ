import java.io.*;
import java.util.*;

public class Main{

	private static StringBuilder sb = new StringBuilder();
	private static String[] channel;
	private static int n;

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		channel = new String[n];
		for(int i = 0; i < n; i++){
			channel[i] = br.readLine();
		}
		setChannel();
		System.out.println(sb.toString());
		br.close();
	}

	private static void setChannel(){

		int idx = 0;

		// kbs1 위치를 찾을 때 까지 화살표 내리기.
		while(!channel[idx].equals("KBS1")){
			sb.append(1);
			idx++;
		}
		// kbs1을 첫 번째로 올려 놓을 때 까지 스왑.
		while(!channel[0].equals("KBS1")){
			String temp = channel[idx-1];
			channel[idx-1] = channel[idx];
			channel[idx] = temp;
			sb.append(4);
			idx--;
		}
		// kbs2가 2번째 위치에 있다면 종료.
		if(channel[1].equals("KBS2")) return ;
		// kbs2 위치를 찾을 때 까지 화살표 내리기.
		while(!channel[idx].equals("KBS2")){
			sb.append(1);
			idx++;
		}
		// kbs2을 첫 번째로 올려 놓을 때 까지 스왑.
		while(!channel[1].equals("KBS2")){
			String temp = channel[idx-1];
			channel[idx-1] = channel[idx];
			channel[idx] = temp;
			sb.append(4);
			idx--;
		}		
	}
}