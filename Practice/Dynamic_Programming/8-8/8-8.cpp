#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int money[100];
int n, m;

int main(void){
    cin >> n >> m;
    for(int i = 0; i < n; i++){
        cin >> money[i];
    }
    vector<int> dp(m+1, 10001);
    dp[0] = 0;
    for(int i = 0; i < n; i++){
        for(int j = money[i]; j <= m; j++){
            if(dp[j-money[i]] != 10001){
                dp[j] = min(dp[j], dp[j-money[i]]+1);
            }
        }
    }
    dp[m] != 10001 ? cout << dp[m] << "\n" : cout << -1 << "\n";
}