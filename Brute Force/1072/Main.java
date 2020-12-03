import java.io.*;
import java.util.*;

public class Main{

	public static void main(String[] args) throws IOException{

		StringTokenizer st;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		long x = Long.parseLong(st.nextToken());
		long y = Long.parseLong(st.nextToken());
		long z = y*100/x;
		if(z >= 99){ // 확률이 99%면 확률은 더 이상 변하지 않음(100%가 되려면 패한 게임이 하나도 없어야 하기 때문에)
			System.out.println(-1);
			return ;
		}

		long left = 0; // 하한
		long right = 1000000000; // 상한

		// 입력값이 1000000000까지고 98%->99% 시간이 오래 걸리기 때문에 이진탐색으로 시행(시간초과 방지)
		while(left <= right){ // 하한과 상한이 같아질때까지 반복문이 실행(확률이 변하는 순간의 횟수로 수렴한다.)
			long mid = (left + right) / 2;
			long z2 = (y + mid) * 100 / (x + mid); // 새로운 확률.
			if(z < z2){ // 확률이 변한 경우 상한 값 조정.
				right = mid - 1;
			}else{ // 확률이 변하지 않은 경우 하한 값 조정.
				left = mid + 1;
			}
		}
		System.out.println(left);
		br.close();
	}
}