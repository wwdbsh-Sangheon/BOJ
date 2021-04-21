#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

vector<vector<int>> info;
int parent[10001];
int v, e;

int find_parent(int x){
    if(parent[x] != x){
        return parent[x] = find_parent(parent[x]);
    }
    return parent[x];
}

void unite(int a, int b){
    a = find_parent(a);
    b = find_parent(b);
    b > a ? parent[b] = a : parent[a] = b;
}

int main(void){
    cin >> v >> e;
    for(int i = 1; i <= v; i++){
        parent[i] = i;
    }
    for(int i = 0; i < e; i++){
        int a, b, c;
        cin >> a >> b >> c;
        info.push_back({c, a, b});
    }
    sort(info.begin(), info.end());
    long long ans = 0;
    for(int i = 0; i < e; i++){
        int c = info[i][0];
        int a = info[i][1];
        int b = info[i][2];
        if(find_parent(a) != find_parent(b)){
            ans += c;
            unite(a, b);
        }
    }
    cout << ans << "\n";
}