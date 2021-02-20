#include <iostream>
#include <algorithm>

using namespace std;

int dp[500][502];
int n;

int main(void){
    cin >> n;
    for(int i = 0; i < n; i++){
        for(int j = 1; j <= i+1; j++){
            cin >> dp[i][j];
        }
    }
    for(int row = n-2; row >= 0; row--){
        for(int col = 1; col <= n; col++){
            dp[row][col] = max(dp[row][col]+dp[row+1][col], dp[row][col]+dp[row+1][col+1]);
        }
    }
    cout << dp[0][1] << "\n";
}