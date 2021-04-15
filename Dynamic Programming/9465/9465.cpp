#include <iostream>
#include <algorithm>

using namespace std;

int dp[2][100000];
int scores[2][100000];
int t, n;

int main(void){
    cin >> t;
    while(t-- > 0){
        cin >> n;
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < n; j++){
                cin >> scores[i][j];
            }
        }
        dp[0][0] = scores[0][0]; dp[1][0] = scores[1][0];
        dp[0][1] = scores[1][0] + scores[0][1];
        dp[1][1] = scores[0][0] + scores[1][1];
        for(int col = 2; col < n; col++){
            dp[0][col] = max(dp[1][col-1], dp[1][col-2]) + scores[0][col];
            dp[1][col] = max(dp[0][col-1], dp[0][col-2]) + scores[1][col];
        }
        cout << max(dp[0][n-1], dp[1][n-1]) << "\n";
    }
}