#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

vector<vector<int>> x, y, z, edge;
int parent[100001];
int n;

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
    cin >> n;
    for(int i = 1; i < 100001; i++){
        parent[i] = i;
    }
    for(int i = 1; i <= n; i++){
        int _x, _y, _z;
        cin >> _x >> _y >> _z;
        x.push_back({_x, i});
        y.push_back({_y, i});
        z.push_back({_z, i});
    }
    
    sort(x.begin(), x.end());
    sort(y.begin(), y.end());
    sort(z.begin(), z.end());

    for(int i = 0; i < n-1; i++){
        edge.push_back({x[i+1][0]-x[i][0], x[i][1], x[i+1][1]});
        edge.push_back({y[i+1][0]-y[i][0], y[i][1], y[i+1][1]});
        edge.push_back({z[i+1][0]-z[i][0], z[i][1], z[i+1][1]});
    }
    
    sort(edge.begin(), edge.end());

    int min_cost = 0;
    for(int i = 0; i < edge.size(); i++){
        int a = edge[i][1];
        int b = edge[i][2];
        if(find_parent(a) != find_parent(b)){
            unite(a, b);
            min_cost += edge[i][0];
        }
    }
    cout << min_cost << "\n";
}