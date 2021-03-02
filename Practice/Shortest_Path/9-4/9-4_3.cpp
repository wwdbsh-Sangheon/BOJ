#include <iostream>
#include <algorithm>
#define INF 1e9

using namespace std;

int graph[101][101];
int n, m, x, k;

int main(void){
    cin >> n >> m;
    for(int i = 1; i < 101; i++){
        fill(graph[i], graph[i]+101, INF);
    }
    for(int i = 0; i < m; i++){
        int a, b;
        cin >> a >> b;
        graph[a][b] = 1;
        graph[b][a] = 1;
    }
    cin >> x >> k;
    for(int mid = 1; mid <= n; mid++){
        for(int a = 1; a <= n; a++){
            for(int b = 1; b <= n; b++){
                if(a == b) graph[a][b] = 0;
                graph[a][b] = min(graph[a][b], graph[a][mid]+graph[mid][b]);
            }
        }
    }
    int cost = graph[1][k] + graph[k][x];
    cost >= INF ? cout << -1 << "\n" : cout << cost << "\n";
}