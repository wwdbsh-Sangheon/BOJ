#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

vector<vector<int>> graph;
int parent[200001];
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
    a < b ? parent[b] = a : parent[a] = b;
}

int main(void){
    cin >> n >> m;
    for(int i = 1; i < 200001; i++){
        parent[i] = i;
    }
    for(int i = 0; i < m; i++){
        int x, y, z;
        cin >> x >> y >> z;
        graph.push_back({z, x, y});
    }
    sort(graph.begin(), graph.end());
    int ans = 0;
    for(int i = 0; i < m; i++){
        int cost = graph[i][0];
        int a = graph[i][1];
        int b = graph[i][2];
        if(find_parent(a) != find_parent(b)){
            unite(a, b);
        }else{
            ans += cost;
        }
    }
    cout << ans << "\n";
}