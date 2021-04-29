#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

vector<int> censors;
vector<int> dist;
int n, k;

int main(void){
    cin >> n >> k;
    for(int i = 0; i < n; i++){
        int c;
        cin >> c;
        censors.push_back(c);
    }
    sort(censors.begin(), censors.end());
    for(int i = 1; i < n; i++){
        dist.push_back(censors[i]-censors[i-1]);
    }
    sort(dist.begin(), dist.end());
    int tot = 0;
    for(int i = 0; i < n-k; i++){
        tot += dist[i];
    }
    cout << tot << "\n";
}