#include <iostream>

using namespace std;

int digit[11];
int t, n;

int main(void){
    cin >> t;
    digit[1] = 1; digit[2] = 2; digit[3] = 4;
    for(int i = 4; i < 11; i++){
        digit[i] = digit[i-1] + digit[i-2] + digit[i-3];
    }
    while(t-- > 0){
        cin >> n;
        cout << digit[n] << "\n";
    }
}