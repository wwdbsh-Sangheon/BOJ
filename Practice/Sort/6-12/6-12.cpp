#include <iostream>
#include <algorithm>
#include <numeric>

using namespace std;

int n, k;
int a[100000];
int b[100000];

int compare(int a, int b){
    return a > b;
}

int main(void){
    cin >> n >> k;
    for(int i = 0; i < n; i++){
        cin >> a[i];
    }
    for(int i = 0; i < n; i++){
        cin >> b[i];
    }
    sort(a, a+n);
    sort(b, b+n, compare);
    for(int i = 0; i < k; i++){
        if(b[i] > a[i]){
            a[i] = b[i];
        }else{
            break;
        }
    }
    cout << accumulate(a, a+n, 0) << "\n";
}