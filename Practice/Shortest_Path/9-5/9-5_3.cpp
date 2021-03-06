#include <iostream>
#include <algorithm>
#include <queue>
#include <vector>
#define INF 1e9

using namespace std;

vector<pair<int,int>> graph[30001];
int dist[30001];
int n, m, c;

void dijkstra(){
    priority_queue<pair<int,int>> pq;
    pq.push({0, c});
    dist[c] = 0;
    while(!pq.empty()){
        int d = -pq.top().first, now = pq.top().second; pq.pop();
        if(d > dist[now]){
            continue;
        }
        for(int i = 0; i < graph[now].size(); i++){
            int cost = d + graph[now][i].second;
            if(cost < dist[graph[now][i].first]){
                dist[graph[now][i].first] = cost;
                pq.push({-cost, graph[now][i].first});
            }
        }
    }
}

int main(void){
    cin >> n >> m >> c;
    fill(dist, dist+30001, INF);
    for(int i = 0; i < m; i++){
        int x, y, z;
        cin >> x >> y >> z;
        graph[x].push_back({y, z});
    }
    dijkstra();
    int count = 0, max_dist = 0;
    for(int i = 1; i <= n; i++){
        if(dist[i] != INF){
            count++;
            max_dist = max(max_dist, dist[i]);
        }
    }
    cout << count-1 << " " << max_dist << "\n";
}