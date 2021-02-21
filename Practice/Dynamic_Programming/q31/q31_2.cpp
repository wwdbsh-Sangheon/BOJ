#include <iostream>
#include <algorithm>

using namespace std;

int dp[22][20];
int t, n, m;

int main(void){
    cin >> t;
    while(t-- > 0){
        cin >> n >> m;
        for(int i = 1; i <= n; i++){
            for(int j = 0; j < m; j++){
                cin >> dp[i][j];
            }
        }
        for(int col = 1; col < m; col++){
            for(int row = 1; row <= n; row++){
                dp[row][col] =
                max(dp[row-1][col],
                max(dp[row][col]+dp[row-1][col-1],
                max(dp[row][col]+dp[row][col-1],
                dp[row][col]+dp[row+1][col-1] )));
            }
        }
        cout << dp[n][m-1] << "\n";
    }
}