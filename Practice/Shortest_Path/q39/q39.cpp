#include <iostream>
#include <algorithm>
#include <queue>

using namespace std;

int graph[125][125];
int dx[4] = {0, 0, 1, -1};
int dy[4] = {1, -1, 0, 0};
int n;

int dijkstra_bfs(){
    priority_queue<pair<int, vector<int>>> pq;
    pq.push({-graph[0][0], {0, 0}});
    int dist = 1e9;
    graph[0][0] = -1;
    while(!pq.empty()){
        vector<int> pos = pq.top().second;
        int d = -pq.top().first; pq.pop();
        if(pos[0] == n-1 && pos[1] == n-1){
            dist = min(dist, d);
        }
        for(int i = 0; i < 4; i++){
            int nx = pos[0] + dx[i];
            int ny = pos[1] + dy[i];
            if(nx >= 0 && nx < n && ny >= 0 && ny < n && graph[nx][ny] != -1){
                int cost = d + graph[nx][ny];
                pq.push({-cost, {nx, ny}});
                graph[nx][ny] = -1;
            }
        }
    }
    return dist;
}

int main(void){
    int t;
    cin >> t;
    while(t-- > 0){
        cin >> n;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                cin >> graph[i][j];
            }
        }
        cout << dijkstra_bfs() << "\n";
    }
}