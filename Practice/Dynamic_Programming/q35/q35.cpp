#include <iostream>
#include <algorithm>

using namespace std;

int ugly[1000];
int n, i2, i3, i5;

int main(void){
    cin >> n;
    ugly[0] = 1;
    int next2 = 2, next3 = 3, next5 = 5;
    for(int i = 1; i < n; i++){
        ugly[i] = min(next2, min(next3, next5));
        if(ugly[i] == next2){
            i2++;
            next2 = ugly[i2]*2;
        }
        if(ugly[i] == next3){
            i3++;
            next3 = ugly[i3]*3;
        }
        if(ugly[i] == next5){
            i5++;
            next5 = ugly[i5]*5;
        }
    }
    cout << ugly[n-1] << "\n";
}