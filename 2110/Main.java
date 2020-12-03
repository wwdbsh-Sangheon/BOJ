import java.util.*;
import java.io.*;

public class Main{

    private static int n, c, ans = 0;
    private static int[] coordinates;
    
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        coordinates = new int[n];
        for(int i = 0; i < n; i++){
            coordinates[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(coordinates);

        for(int i : coordinates){
            System.out.print(i + " ");
        }
        System.out.println();
    }
}