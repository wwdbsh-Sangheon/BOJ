#include <iostream>
#include <algorithm>
#include <vector>
#include <cmath>

using namespace std;

vector<pair<double, pair<int,int>>> edges;
vector<pair<int, int>> pos;
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
        int x, y;
        cin >> x >> y;
        pos.push_back({x, y});
    }
    for(int i = 0; i < n; i++){
        for(int j = 0; j < i; j++){
            double x = pos[i].first - pos[j].first;
            double y = pos[i].second - pos[j].second;
            double dist = sqrt(x*x+y*y);
            edges.push_back({dist, {i+1, j+1}});
        }
    }
    sort(edges.begin(), edges.end());
    for(int i = 0; i < m; i++){
        int a, b;
        cin >> a >> b;
        unite(a, b);
    }
    double cost = 0.0;
    for(int i = 0; i < edges.size(); i++){
        double c = edges[i].first;
        int a = edges[i].second.first;
        int b = edges[i].second.second;
        if(find_parent(a) != find_parent(b)){
            unite(a, b);
            cost += c;
        }
    }
    cout << fixed;
    cout.precision(2);
    cout << cost << "\n";
}