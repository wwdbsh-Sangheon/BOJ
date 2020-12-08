#include <iostream>

using namespace std;

int n, k, result;
int coin[11];

int main(void){
    
    cin >> n;
    cin >> k;

    for(int i = n-1; i >= 0; i--){
        int x;
        cin >> x;
        coin[i] = x;
    }

    for(int i = 0; i < n; i++){
        int c = coin[i];
        result += (k/c);
        k -= (k/c)*c;
    }
    cout << result << "\n";
}