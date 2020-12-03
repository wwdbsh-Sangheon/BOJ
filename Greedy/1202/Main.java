import java.io.*;
import java.util.*;

public class Main{

  public static void main(String[] args) throws IOException{

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    int[] bp = new int[k];
    Jewel[] jew = new Jewel[n];
    for(int i = 0; i < n; i++){
      st = new StringTokenizer(br.readLine());
      int m = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      jew[i] = new Jewel(m, v);
    }
    for(int i = 0; i < k; i++){
      bp[i] = Integer.parseInt(br.readLine());
    }

    Arrays.sort(jew);
    Arrays.sort(bp);

    long ans = 0;
    PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

    for(int i = 0, j = 0; i < k; i++){
      // 이전에 담은 보석은 제외.
      while(j < n && jew[j].m <= bp[i]) pq.add(-jew[j++].v);
      // 반복 한 번에 보석 하나만 추가.
      if(!pq.isEmpty()) ans += Math.abs(pq.poll());
    }
    System.out.println(ans);
    br.close();
  }

  private static class Jewel implements Comparable<Jewel>{

    int m, v;

    private Jewel(int m, int v){

      this.m = m;
      this.v = v;
    }

    @Override
    public int compareTo(Jewel o){
      return this.m - o.m;
    }
  }
}
