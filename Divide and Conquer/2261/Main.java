import java.io.*;
import java.util.*;

public class Main{

	private static Point[] points;
	private static int n;

	public static void main(String[] args) throws IOException{

		StringTokenizer st;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		points = new Point[n];

		for(int i = 0; i < n; i++){

			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			points[i] = new Point(x, y);
		}

		// x좌표 기준 오름차순 정렬.
		Arrays.sort(points, new Comparator<Point>(){

			public int compare(Point p1, Point p2){

				if(p1.x < p2.x) return -1;
				else if(p1.x == p2.x) return 0;
				else return 1;
			}
		});
		System.out.println(getMinDist(0, n-1));
		br.close();
	}

	// left: 왼쪽 끝 포인터, right: 오른쪽 끝 포인터
	private static int getMinDist(int left, int right){

		// 좌우 포인터 위치가 같다면 최대 입력값에 따른 최대 출력값인 8억 반환.
		if(left == right) return 800000000;

		int mid = (left + right) / 2; // 주어진 범위 내 중간지점.
		int dist = Math.min(getMinDist(left, mid), getMinDist(mid+1, right)); // 중간을 기점으로 좌우 분할 메소드 호출 후 그에 따른 최솟값 도출.
		int lo = mid, hi = mid+1; // 왼쪽 포인터 변수, 오른쪽 포인터 변수.
		
		// 거리를 비교할 후보군(점들).
		ArrayList<Point> candidates = new ArrayList<Point>();

		 while(true){

			if(hi <= right && Math.abs(points[hi].x - points[mid].x) <= dist){ // hi가 주어진 범위 안이고 hi번째 점의 x좌표와 중간지점의 x좌표 사이 거리가 dist 이하라면 후보군에 hi번째 점 추가.

				candidates.add(points[hi]);
				hi++;
			}else if(lo >= left && Math.abs(points[lo].x - points[mid].x) <= dist){ // lo가 주어진 범위 안이고 lo번째 점의 x좌표와 중간지점의 x좌표 사이 거리가 dist 이하라면 후보군에 lo번째 점 추가.

				candidates.add(points[lo]);
				lo--;
			}else{

				break;
			}
		}

		// y좌표 기준 오름차순 정렬.
		Collections.sort(candidates, new Comparator<Point>(){

			public int compare(Point p1, Point p2){

				if(p1.y < p2.y) return -1;
				else if(p1.y == p2.y) return 0;
				else return 1;
			}
		});

		int size = candidates.size();

		for(int i = 0; i < size; i++){

			Point p = candidates.get(i); // 거리 비교를 위한 기준점.

			for(int j = i+1; j < size; j++){

				int temp_dist = p.y - candidates.get(j).y; // p와 p보다 높은 위치에 있는 점 사이 y좌표 거리.
				if(temp_dist*temp_dist >= dist) break; // 두 점 사이 y좌표 거리가 dist 보다 크거나 같다면 스킵.
				dist = Math.min(dist, getDist(p, candidates.get(j))); // 기존 dist와 새로운 거리 중 최솟값 도출(dist 갱신).
			}
		}

		return dist;
	}

	// 두 점 거리를 구하기 위한 메소드.
	private static int getDist(Point a, Point b){

		return (a.x-b.x)*(a.x-b.x) + (a.y-b.y)*(a.y-b.y);
	}

	// 점 객체를 표현하는 클래스.
	private static class Point{

		private int x, y;

		private Point(int x, int y){

			this.x = x;
			this.y = y;
		}
	}
}