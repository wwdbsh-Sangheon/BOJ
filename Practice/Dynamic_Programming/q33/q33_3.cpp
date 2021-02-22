#include <iostream>
#include <algorithm>

using namespace std;

int dp[16], t[16], p[16];
int n;

int main(void){
    cin >> n;
    for(int i = 1; i <= n; i++){
        cin >> t[i] >> p[i];
    }
    int max_v = 0;
    for(int i = n; i >= 1; i--){
        int time = t[i] + i;
        if(time <= n+1){
            dp[i] = max(max_v, dp[time]+p[i]);
            max_v = dp[i];
        }else{
            dp[i] = max_v;
        }
    }
    cout << max_v << "\n";
}