import java.io.*;
import java.util.*;

public class Q5585 {
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int amount = 1000 - Integer.parseInt(br.readLine());
        int[] coins = {500, 100, 50, 10, 5};
        int result = 0;

        for(int c : coins){
            result += (amount / c);
            amount -= (amount / c) * c;
        }
        System.out.println(result+amount);
        br.close();
    }
}
