#include <iostream>

using namespace std;

int dp[1000];
int n;

int main(void){
    cin >> n;
    dp[0] = 1;
    dp[1] = 3;
    for(int i = 2; i < 1000; i++){
        dp[i] = (dp[i-1] + dp[i-2]*2)%796796;
    }
    cout << dp[n-1] << "\n";
}