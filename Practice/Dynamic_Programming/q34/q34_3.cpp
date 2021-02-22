#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

vector<int> dp(2000, 1);
int soldiers[2000];
int n;

int main(void){
    cin >> n;
    for(int i = n-1; i >= 0; i--){
        cin >> soldiers[i];
    }
    for(int i = 0; i < n; i++){
        for(int j = 0; j < i; j++){
            if(soldiers[i] > soldiers[j]){
                dp[i] = max(dp[i], dp[j]+1);
            }
        }
    }
    int count = 0;
    for(int i = 0; i < n; i++){
        count = max(count, dp[i]);
    }
    cout << n-count << "\n";
}