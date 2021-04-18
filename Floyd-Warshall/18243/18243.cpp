#include <iostream>
#include <algorithm>
#define INF 1e9

using namespace std;

int graph[1001][1001];
int n, k;

int main(void){
    cin >> n >> k;
    for(int i = 1; i <= n; i++){
        fill(graph[i], graph[i]+1+n, INF);
    }
    for(int i = 0; i < k; i++){
        int a, b;
        cin >> a >> b;
        graph[a][b] = 1;
        graph[b][a] = 1;
    }
    for(int mid = 1; mid <= n; mid++){
        for(int a = 1; a <= n; a++){
            for(int b = 1; b <= n; b++){
                if(a == b) graph[a][b] = 0;
                graph[a][b] = min(graph[a][b], graph[a][mid]+graph[mid][b]);
            }
        }
    }
    for(int a = 1; a <= n; a++){
        for(int b = 1; b <= n; b++){
            if(graph[a][b] > 6){
                cout << "Big World!\n";
                return 0;
            }
        }
    }
    cout << "Small World!\n";
}