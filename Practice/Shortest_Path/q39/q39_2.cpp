#include <iostream>
#include <algorithm>
#include <queue>
#include <vector>
#define INF 1e9

using namespace std;

int graph[126][126];
int dist[126][126];
int dx[4] = {0, 0, 1, -1};
int dy[4] = {1, -1, 0, 0};
int t, n;

void dijkstra(){
    priority_queue<vector<int>> pq;
    pq.push({-graph[1][1], 1, 1});
    dist[1][1] = graph[1][1];
    while(!pq.empty()){
        int d = -pq.top()[0];
        int cur_x = pq.top()[1];
        int cur_y = pq.top()[2];
        pq.pop();
        if(d > dist[cur_x][cur_y]){
            continue;
        }
        for(int i = 0; i < 4; i++){
            int nx = cur_x + dx[i];
            int ny = cur_y + dy[i];
            if(nx >= 1 && nx <= n && ny >= 1 && ny <= n){
                int cost = d + graph[nx][ny];
                if(cost < dist[nx][ny]){
                    dist[nx][ny] = cost;
                    pq.push({-cost, nx, ny});
                }
            }
        }
    }
}

int main(void){
    cin >> t;
    while(t-- > 0){
        cin >> n;
        for(int i = 1; i < 126; i++){
            fill(dist[i], dist[i]+126, INF);
        }
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                cin >> graph[i][j];
            }
        }
        dijkstra();
        cout << dist[n][n] << "\n";
    }
}