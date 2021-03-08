#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

vector<vector<int>> graph;
int parent[100001];
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
    for(int i = 1; i < 100001; i++){
        parent[i] = i;
    }
    cin >> n >> m;
    for(int i = 0; i < m; i++){
        int a, b, c;
        cin >> a >> b >> c;
        graph.push_back({c, a, b});
    }
    sort(graph.begin(), graph.end());
    
    int result = 0, max_cost = 0;
    for(int i = 0; i < m; i++){
        int a = graph[i][1];
        int b = graph[i][2];
        if(find_parent(a) != find_parent(b)){
            unite(a, b);
            result += graph[i][0];
            max_cost = max(max_cost, graph[i][0]);
        }
    }
    cout << result - max_cost << "\n";
}