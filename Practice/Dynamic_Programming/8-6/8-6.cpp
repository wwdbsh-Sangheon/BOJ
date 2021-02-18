#include <iostream>
#include <algorithm>

using namespace std;

int dp[100];
int food[100];
int n;

int main(void){
    cin >> n;
    for(int i = 0; i < n; i++){
        cin >> food[i];
    }
    dp[0] = food[0];
    dp[1] = max(food[0], food[1]);
    for(int i = 2; i < n; i++){
        dp[i] = max(dp[i-1], dp[i-2] + food[i]);
    }
    cout << dp[n-1] << "\n";
}