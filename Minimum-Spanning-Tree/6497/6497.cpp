#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

vector<vector<int>> graph;
int parent[200000];
int m, n;

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
    while(true){
        cin >> m >> n;
        if(m == 0 && n == 0){
            break;
        }
        for(int i = 0; i < m; i++){
            parent[i] = i;
        }
        int tot = 0;
        for(int i = 0; i < n; i++){
            int x, y, z;
            cin >> x >> y >> z;
            graph.push_back({z, x, y});
            tot += z;
        }
        sort(graph.begin(), graph.end());
        int cost = 0;
        for(int i = 0; i < n; i++){
            int c = graph[i][0];
            int a = graph[i][1];
            int b = graph[i][2];
            if(find_parent(a) != find_parent(b)){
                unite(a, b);
                cost += c;
            }
        }
        cout << tot - cost << "\n";
        graph.clear();
    }
}