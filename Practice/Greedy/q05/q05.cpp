// 볼링공 고르기 315p 513p
#include <iostream>
#include <algorithm>

using namespace std;

int n, m;
int w[11];

int main(void){
    cin >> n;
    cin >> m;
    for(int i = 0; i < n; i++){
        int x;
        cin >> x;
        w[x]++;
    }

    int count = 0;
    // sol1
    // sort(w, w+11);

    // for(int i = 10; i >= 0; i--){
    //     if(w[i] == 0) break;
    //     int sum = 0;
    //     for(int j = i-1; j >= 0; j--){
    //         if(w[j] == 0) break;
    //         sum += w[j];
    //     }
    //     sum *= w[i];
    //     count += sum;
    // }
    //
    
    // sol2
    for(int i = 0; i <= m; i++){
        n -= w[i];
        count += w[i] * n;
    }
    //
    cout << count << "\n";
}
