#include <iostream>

using namespace std;

int n, k, result;

int main(void){
    cin >> n >> k;
    while(true){
        int target = (n/k)*k;
        result += (n - target);
        n = target;
        if(n < k) break;
        n /= k;
        result++;
    }
    printf("%d\n", result+n-1);
}