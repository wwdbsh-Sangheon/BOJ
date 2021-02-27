#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#define INF 1e9

using namespace std;

priority_queue<pair<int,int>> pq;
vector<pair<int,int>> cities[30001];
int dist[30001];
int n, m, c;

void dijkstra(){
    pq.push(make_pair(0, c));
    dist[c] = 0;
    while(!pq.empty()){
        int d = pq.top().first*(-1);
        int now = pq.top().second;
        pq.pop();
        if(dist[now] < d){
            continue;
        }
        for(int i = 0; i < cities[now].size(); i++){
            int cost = d + cities[now][i].second;
            if(cost < dist[cities[now][i].first]){
                dist[cities[now][i].first] = cost;
                pq.push(make_pair(cost*(-1), cities[now][i].first));
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
        cities[x].push_back(make_pair(y, z));
    }
    dijkstra();
    int count = 0;
    int max_dist = 0;
    for(int i = 1; i <= n; i++){
        if(dist[i] != INF){
            count++;
            max_dist = max(max_dist, dist[i]);
        }
    }
    cout << count-1 << " " << max_dist << "\n";
}