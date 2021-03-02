#include <iostream>
#include <algorithm>
#define INF 1e9

using namespace std;

int graph[501][501];
int n, m;

int main(void){
    cin >> n >> m;
    for(int i = 1; i < 501; i++){
        fill(graph[i], graph[i]+501, INF);
    }
    for(int i = 0; i < m; i++){
        int a, b;
        cin >> a >> b;
        graph[a][b] = 1;
    }
    for(int k = 1; k <= n; k++){
        for(int a = 1; a <= n; a++){
            for(int b= 1; b <= n; b++){
                if(a == b) graph[a][b] = 0;
                graph[a][b] = min(graph[a][b], graph[a][k]+graph[k][b]);
            }
        }
    }
    int result = 0;
    for(int a = 1; a <= n; a++){
        int count = 0;
        for(int b= 1; b <= n; b++){
            if(graph[a][b] != INF || graph[b][a] != INF){
                count++;
            }
        }
        if(count == n){
            result++;
        }
    }
    cout << result << "\n";
}