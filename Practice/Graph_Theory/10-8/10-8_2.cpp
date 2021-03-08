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
    cin >> n >> m;
    for(int i = 1; i < 100001; i++){
        parent[i] = i;
    }
    for(int i = 0; i < m; i++){
        int a, b, c;
        cin >> a >> b >> c;
        graph.push_back({c, a, b});
    }
    sort(graph.begin(), graph.end());
    int result = 0, max_v = 0;
    for(int i = 0; i < graph.size(); i++){
        int a = graph[i][1];
        int b = graph[i][2];
        int c = graph[i][0];
        if(find_parent(a) != find_parent(b)){
            unite(a, b);
            result += c;
            max_v = max(max_v, c);
        }
    }
    cout << result - max_v << "\n";
}