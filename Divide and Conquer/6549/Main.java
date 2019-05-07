import java.io.*;
import java.util.*;

public class Main{

	private static long[] h; // 입력 값이 최대 10억이기 때문에 int형은 값을 담지 못한다.
	private static int n;

	public static void main(String[] args) throws IOException{

		StringTokenizer st;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while(true){

			String input = br.readLine();

			if(input.equals("0")) break;

			st = new StringTokenizer(input);
			n = Integer.parseInt(st.nextToken());
			h = new long[n];

			for(int i = 0; i < n; i++){

				h[i] = Long.parseLong(st.nextToken());
			}
			System.out.println(getMaxArea(0, n-1));
		}
		br.close();
	}

	private static long getMaxArea(int left, int right){

		// 왼쪽 포인터와 오른쪽 포인터의 위치가 같다면 1*h[left] 반환.
		if(left == right){

			return h[left];
		}

		int mid = (left + right) / 2; // 범위를 반으로 나눠줄 중앙값.
		long area = Math.max(getMaxArea(left, mid), getMaxArea(mid+1, right)); // 중앙을 기점으로 왼쪽 구간 최대 넓이와 오른쪽 구간 최대 넓이 중 큰 값 도출.
		// 중앙에 걸쳐 있는 사각형 최대 넓이 구하기.
		int lo = mid, hi = mid+1;
		long height = Math.min(h[lo], h[hi]);
		area = Math.max(area, height*2); // 중앙에 걸쳐있는 가장 첫 번째 경우(너비 2)

		// lo와 hi가 주어진 범위를 넘지 않을 때 좌,우 중 높이가 큰 쪽으로 확장해 나간다.
		while(lo > left || hi < right){

			if(hi < right && (lo == left || h[lo-1] < h[hi+1])){

				hi++;
				height = Math.min(height, h[hi]);
			}else{

				lo--;
				height = Math.min(height, h[lo]);
			}
			area = Math.max(area, (hi-lo+1)*height); // 확장한 범위에서 구한 넓이와 기존 넓이 중 큰 값 도출.
		}

		return area;
	}
}