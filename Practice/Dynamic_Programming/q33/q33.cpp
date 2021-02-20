#include <iostream>
#include <algorithm>

using namespace std;

int t[16], p[16], dp[16];
int n, max_v;

int main(void){
    cin >> n;
    for(int i = 0; i < n; i++){
        cin >> t[i] >> p[i];
    }
    for(int i = n-1; i >= 0; i--){
        int time = t[i] + i;
        if(time <= n){
            dp[i] = max(p[i]+dp[time], max_v);
            max_v = dp[i];
        }else{
            dp[i] = max_v;
        }
    }
    cout << max_v << "\n";
}