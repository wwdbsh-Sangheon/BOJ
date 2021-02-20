#include <iostream>
#include <algorithm>
#include <cstring>

using namespace std;

int board[22][20];
int dp[22][20];
int t, n, m;

int main(void){
    cin >> t;
    while(t-- > 0){
        cin >> n >> m;
        int x, y;
        for(int i = 1; i <= n; i++){
            for(int j = 0; j < m; j++){
                cin >> board[i][j];                
                if(j == 0){
                    dp[i][j] = board[i][j];
                }
            }
        }
        
        for(int col = 1; col < m; col++){
            for(int row = 1; row < n+1; row++){
                dp[row][col] =
                 max(dp[row-1][col],
                  max(board[row][col]+dp[row-1][col-1],
                   max(board[row][col]+dp[row][col-1], board[row][col]+dp[row+1][col-1])));
            }
        }
        cout << dp[n][m-1] << "\n";
        memset(dp, 0, sizeof(dp));
    }
}