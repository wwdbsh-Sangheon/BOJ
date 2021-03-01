#include <iostream>
#include <algorithm>
#define INF 1e9

using namespace std;

int graph[501][501];
int n, m;

int main(void){
    cin >> n >> m;
    for(int i = 1; i <= n; i++){
        fill(graph[i], graph[i]+501, INF);
    }
    for(int i = 0; i < m; i++){
        int a, b;
        cin >> a >> b;
        graph[a][b] = 1;
    }
    for(int mid = 1; mid <= n; mid++){
        for(int a = 1; a <= n; a++){
            for(int b = 1; b <= n; b++){
                if(a == b) graph[a][b] = 0;
                graph[a][b] = min(graph[a][b], graph[a][mid]+graph[mid][b]);
            }
        }
    }
    int ans = 0;
    for(int i = 1; i <= n; i++){
        int count = 0;
        for(int j = 1; j <= n; j++){
            if(graph[i][j] != INF || graph[j][i] != INF){
                count++;
            }
        }
        if(count == n){
            ans++;
        }
    }
    cout << ans << "\n";
}