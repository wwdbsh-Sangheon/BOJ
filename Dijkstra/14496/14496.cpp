#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#define INF 1e9

using namespace std;

vector<vector<int>> graph(1001, vector<int>());
int dist[1001];
int a, b, n, m;

void dijkstra(){
    priority_queue<vector<int>> pq;
    pq.push({0, a});
    dist[a] = 0;
    while(!pq.empty()){
        int d = -pq.top()[0];
        int c = pq.top()[1];
        pq.pop();
        if(d > dist[c]){
            continue;
        }
        for(int i = 0; i < graph[c].size(); i++){
            int cost = d + 1;
            int dest = graph[c][i];
            if(cost < dist[dest]){
                dist[dest] = cost;
                pq.push({-cost, dest});
            }
        }
    }
}

int main(void){
    cin >> a >> b >> n >> m;
    fill(dist, dist+n+1, INF);
    for(int i = 0; i < m; i++){
        int x, y;
        cin >> x >> y;
        graph[x].push_back(y);
        graph[y].push_back(x);
    }
    dijkstra();
    dist[b] != INF ? cout << dist[b] << "\n" : cout << "-1\n";
}