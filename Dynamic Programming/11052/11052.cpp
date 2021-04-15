#include <iostream>
#include <algorithm>

using namespace std;

int p[1001], dp[1001];
int n;

int main(void){
    cin >> n;
    for(int i = 1; i <= n; i++){
        cin >> p[i];
    }
    dp[1] = p[1];
    dp[2] = max(p[2], p[1]*2);
    for(int i = 3; i <= n; i++){
        dp[i] = p[i];
        for(int j = i-1; j >= 1; j--){
            dp[i] = max(dp[i], dp[j]+p[i-j]);
        }
    }
    cout << dp[n] << "\n";
}