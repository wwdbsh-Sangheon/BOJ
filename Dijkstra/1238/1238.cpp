#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#define INF 1e9

using namespace std;

vector<vector<vector<int>>> graph(1001, vector<vector<int>>());
int dist[1001];
int n, m, x;

void dijkstra(int start){
    priority_queue<vector<int>> pq;
    pq.push({0, start});
    dist[start] = 0;
    while(!pq.empty()){
        int d = -pq.top()[0];
        int now = pq.top()[1];
        pq.pop();
        if(d > dist[now]){
            continue;
        }
        for(int i = 0; i < graph[now].size(); i++){
            int cost = d + graph[now][i][1];
            if(cost < dist[graph[now][i][0]]){
                dist[graph[now][i][0]] = cost;
                pq.push({-cost, graph[now][i][0]});
            }
        }
    }
}

int main(void){
    cin >> n >> m >> x;
    for(int i = 0; i < m; i++){
        int u, v, w;
        cin >> u >> v >> w;
        graph[u].push_back({v, w});
    }
    int ans = 0;
    for(int i = 1; i <= n; i++){
        fill(dist, dist+1+n, INF);
        dijkstra(i);
        int temp = dist[x];
        fill(dist, dist+1+n, INF);
        dijkstra(x);
        temp += dist[i];
        ans = max(ans, temp);
    }
    cout << ans << "\n";
}