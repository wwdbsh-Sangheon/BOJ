import java.io.*;
import java.util.*;

public class Main{

  public static void main(String[] args) throws IOException{

    StringTokenizer st;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[][] dist = new int[n][n];
    int[][] road = new int[n][n];
    boolean[][] chk = new boolean[n][n];
    for(int i = 0; i < n; i++){
      st = new StringTokenizer(br.readLine());
      for(int j = 0; j < n; j++){
        dist[i][j] = Integer.parseInt(st.nextToken());
        road[i][j] = dist[i][j];
      }
    }

    for(int k = 0; k < n; k++){
      for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
          // 자기 자신과의 거리를 나타내는 경우 넘어가기.
          if(i == k || j == k) continue;
          // 두 도시 사이의 거리가 한개의 도시를 경유해서 가는 거리 보다 길다면 문제 조건을 충족하지 못함.
          if(dist[i][j] > dist[i][k] + dist[k][j]){
            System.out.println(-1);
            return ;
          }
          // 두 도시 사이의 거리가 한개의 도시를 경유해서 가는 거리와 같다면 두 도시 사이 직접 연결된 도로는 없다는 것을 의미.
          if(dist[i][j] == dist[i][k] + dist[k][j]){
            road[i][j] = 0;
          }
        }
      }
    }

    int ans = 0;

    for(int i = 0; i < n; i++){
      for(int j = 0; j < n; j++){
        // 두 도시 사이에 도로가 있고 경유하지 않았다면 더해주기.
        if(!chk[i][j] && road[i][j] != 0){
          ans += road[i][j];
          chk[i][j] = true;
          chk[j][i] = true;
        }
      }
    }
    System.out.println(ans);
    br.close();
  }
}
