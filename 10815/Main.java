import java.util.*;
import java.io.*;

public class Main{

    private static StringBuilder sb = new StringBuilder();
    private static int n, m;
    private static int[] cards;
    public static void main(String[] args) throws IOException{

        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        cards = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            cards[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cards);

        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++){
            int num = Integer.parseInt(st.nextToken());
            sb.append(binarySearch(num) + " ");
        }
        System.out.println(sb.toString());
        br.close();
    }

    private static int binarySearch(int num){

        int left = 0;
        int right = n - 1;

        while(left <= right){
            int mid = (left + right) / 2;
            if(num < cards[mid]){
                right = mid - 1;
            }else if(num > cards[mid]){
                left = mid + 1;
            }else{
                return 1;
            }
        }
        return 0;
    }
}