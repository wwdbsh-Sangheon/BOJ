#include <iostream>
#include <algorithm>
#include <vector>
#include <cmath>

using namespace std;

vector<pair<double,double>> pos;
vector<pair<double, pair<int,int>>> edge;
int parent[100];
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
    b > a ? parent[b] = a : parent[a] = b;
}

int compare(pair<double, pair<int,int>> a, pair<double, pair<int,int>> b){
    return a.first < b.first;
}

int main(void){
    cin >> n;
    for(int i = 0; i < n; i++){
        parent[i] = i;
    }
    for(int i = 0; i < n; i++){
        double a, b;
        cin >> a >> b;
        pos.push_back({a, b});
    }
    for(int i = 0; i < n; i++){
        for(int j = 0; j < i; j++){
            double x = pos[i].first - pos[j].first;
            double y = pos[i].second - pos[j].second;
            double dist = sqrt(x*x+y*y);
            edge.push_back({dist, {i, j}});
        }
    }
    sort(edge.begin(), edge.end(), compare);
    double cost = 0.0;
    for(int i = 0; i < edge.size(); i++){
        double c = edge[i].first;
        int a = edge[i].second.first;
        int b = edge[i].second.second;
        if(find_parent(a) != find_parent(b)){
            unite(a, b);
            cost += c;
        }
    }
    cout << fixed;
    cout.precision(2);
    cout << cost << "\n";
}