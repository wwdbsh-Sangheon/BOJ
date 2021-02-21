#include <iostream>
#include <algorithm>

using namespace std;

int dp[500][500];
int n;

int main(void){
    cin >> n;
    for(int i = 0; i < n; i++){
        for(int j = 0; j <= i; j++){
            cin >> dp[i][j];
        }
    }
    for(int row = n-2; row >= 0; row--){
        for(int col = 0; col <= row; col++){
            dp[row][col] += max(dp[row+1][col], dp[row+1][col+1]);
        }
    }
    cout << dp[0][0] << "\n";
}