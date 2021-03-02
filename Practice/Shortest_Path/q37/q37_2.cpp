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
    for(int k = 1; k <= n; k++){
        for(int a = 1; a <= n; a++){
            for(int b = 1; b <= n; b++){
                if(a == b) graph[a][b] = 0;
                graph[a][b] = min(graph[a][b], graph[a][k]+graph[k][b]);
            }
        }
    }
    for(int a = 1; a <= n; a++){
        for(int b = 1; b <= n; b++){
            if(graph[a][b] == INF){
                graph[a][b] = 0;
            }
            cout << graph[a][b] << " ";
        }
        cout << "\n";
    }
}