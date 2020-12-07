// 만들 수 없는 금액 315p 510p
import java.io.*;
import java.util.*;

public class Q04{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] coins = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) coins[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(coins);

        ///////////sol1////////////
//        int min_num = 0;
// con:    while(true){
//             min_num++;
//             int temp = min_num;
//             for(int idx = n-1; idx >= 0; idx--){
//                 if(temp < coins[idx]) continue;
//                 temp -= coins[idx];
//                 if(temp == 0) continue con;
//             }
//             break;
//         }
        ///////////////////////////

        ///////////sol2////////////
        int min_num = 1;
        for(int idx = 0; idx < n; idx++){
            if(min_num < coins[idx]) break;
            min_num += coins[idx];
        }
        ///////////////////////////
        System.out.println(min_num);
        br.close();
    }
}