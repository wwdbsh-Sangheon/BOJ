#include <iostream>
#include <algorithm>

using namespace std;

int dp[5001][5001];
string A, B;

int main(void){
    cin >> A >> B;
    int n = A.length();
    int m = B.length();
    for(int row = 0; row <= n; row++){
        for(int col = 0; col <= m; col++){
            if(row == 0 && col == 0) continue;
            if(row == 0){
                dp[row][col] = col;
                continue;
            }
            if(col == 0){
                dp[row][col] = row;
                continue;
            }
            if(A[row] == B[col]){
                dp[row][col] = dp[row-1][col-1];
            }else{
                dp[row][col] = 1 + min(dp[row-1][col], min(dp[row-1][col-1], dp[row][col-1]));
            }
        }
    }
    cout << dp[n][m] << "\n";
}