#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

vector<vector<int>> e;
int parent[1001];
int n, m;

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
    cin >> n >> m;
    for(int i = 1; i <= n; i++){
        parent[i] = i;
    }
    for(int i = 0; i < m; i++){
        int a, b, c;
        cin >> a >> b >> c;
        e.push_back({c, a, b});
    }
    sort(e.begin(), e.end());
    long long cost = 0;
    for(int i = 0; i < m; i++){
        int c = e[i][0];
        int a = e[i][1];
        int b = e[i][2];
        if(find_parent(a) != find_parent(b)){
            unite(a, b);
            cost += c;
        }
    }
    cout << cost << "\n";
}