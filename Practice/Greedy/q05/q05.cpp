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
    
    for(int i = 0; i <= m; i++){
        n -= w[i];
        count += w[i] * n;
    }
    cout << count << "\n";
}
