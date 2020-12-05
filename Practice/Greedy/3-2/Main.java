// 큰 수의 법칙 92p
import java.io.*;
import java.util.*;

public class Main{

    private static int n, m, k;
    private static int[] array;

    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        array = new int[n];
        for(int i = 0; i < n; i++) array[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(array);
        int first_big = array[n-1];
        int second_big = array[n-2];
        
        int result = 0;
        
        /////////// 1st soulution ///////////
        // for(int i = 0, j = 1; i < m; i++, j++){
        //     if(first_big == second_big){
        //         result = m * first_big;
        //         break;
        //     }
        //     result += first_big;
        //     if(j % k == 0){
        //         result += second_big;
        //         i++;
        //     }
        // }
        ////////////////////////////////////

        /////////// 2nd soulution ///////////
        int count = (m/(k+1))*k + m%(k + 1);
        result = count*first_big + (m-count)*second_big;
        ////////////////////////////////////
        System.out.println(result);
        br.close();
    }
}