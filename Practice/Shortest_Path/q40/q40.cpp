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
    priority_queue<pair<int,int>> pq;
    pq.push({0, 1});
    dist[1] = 0;
    while(!pq.empty()){
        int d = -pq.top().first, barn = pq.top().second; pq.pop();
        if(d > dist[barn]){
            continue;
        }
        for(int i = 0; i < graph[barn].size(); i++){
            int cost = d + 1;
            if(cost < dist[graph[barn][i]]){
                dist[graph[barn][i]] = cost;
                pq.push({-cost, graph[barn][i]});
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
            max_dist = dist[i];
            dest = i;
            count = 1;
        }else if(max_dist == dist[i]){
            count++;
        }
    }
    cout << dest << " " << max_dist << " " << count << "\n";
}