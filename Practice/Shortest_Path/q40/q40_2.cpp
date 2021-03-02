#include <iostream>
#include <algorithm>
#include <queue>
#include <vector>
#define INF 1e9

using namespace std;

vector<int> graph[20001];
int dist[20001];
int n, m;

void dijkstra(){
    priority_queue<vector<int>> pq;
    pq.push({0, 1});
    dist[1] = 0;
    while(!pq.empty()){
        int d = -pq.top()[0], now = pq.top()[1]; pq.pop();
        if(d > dist[now]){
            continue;
        }
        for(int i = 0; i < graph[now].size(); i++){
            int cost = d + 1;
            int barn = graph[now][i];
            if(cost < dist[barn]){
                dist[barn] = cost;
                pq.push({-cost, barn});
            }
        }
    }
}

int main(void){
    cin >> n >> m;
    fill(dist, dist+20001, INF);
    for(int i = 0; i < m; i++){
        int a, b;
        cin >> a >> b;
        graph[a].push_back(b);
        graph[b].push_back(a);
    }
    dijkstra();
    int dest = 0;
    int max_dist = 0;
    int count = 0;
    for(int i = 1; i <= n; i++){
        if(max_dist < dist[i]){
            dest = i;
            max_dist = dist[i];
            count = 1;
        }else if(max_dist == dist[i]){
            count++;
        }
    }
    cout << dest << " " << max_dist << " " << count << "\n";
}