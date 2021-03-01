#include <iostream>
#include <algorithm>
#define INF 1e9

using namespace std;

int graph[101][101];
int n, m;

int main(void){
    cin >> n >> m;
    for(int i = 1; i < 101; i++){
        fill(graph[i], graph[i]+101, INF);
    }
    for(int i = 0; i < m; i++){
        int a, b, c;
        cin >> a >> b >> c;
        graph[a][b] = min(graph[a][b], c);
    }
    for(int mid = 1; mid <= n; mid++){
        for(int a = 1; a <= n; a++){
            for(int b = 1; b <= n; b++){
                if(a == b) graph[a][b] = 0;
                graph[a][b] = min(graph[a][b], graph[a][mid]+graph[mid][b]);
            }
        }
    }
    for(int i = 1; i <= n; i++){
        for(int j = 1; j <= n; j++){
            if(graph[i][j] == INF) graph[i][j] = 0;
            cout << graph[i][j] << " ";
        }
        cout << "\n";
    }
}