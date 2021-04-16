#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#define INF 1e9

using namespace std;

typedef long long ll;

vector<vector<pair<int,int>>> graph(1001, vector<pair<int,int>>());
ll dist[1001];
int n, m, from, to;

void dijkstra(){
    priority_queue<pair<ll,int>> pq;
    pq.push({0, from});
    dist[from] = 0;
    while(!pq.empty()){
        ll d = -pq.top().first;
        int now = pq.top().second;
        pq.pop();
        if(d > dist[now]){
            continue;
        }
        for(int i = 0; i < graph[now].size(); i++){
            ll cost = d + graph[now][i].second;
            if(cost < dist[graph[now][i].first]){
                dist[graph[now][i].first] = cost;
                pq.push({-cost, graph[now][i].first});
            }
        }
    }
}

int main(void){
    cin >> n >> m;
    fill(dist, dist+1+n, INF);
    for(int i = 0; i < m; i++){
        int u, v, w;
        cin >> u >> v >> w;
        graph[u].push_back({v, w});
    }
    cin >> from >> to;
    dijkstra();
    cout << dist[to] << "\n";
}