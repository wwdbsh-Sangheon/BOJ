#include <iostream>
#include <algorithm>

using namespace std;

int graph[501][501];
int n, m;

int main(void){
    cin >> n >> m;
    for(int i = 1; i <= n; i++){
        for(int j = 1; j <= n; j++){
            cin >> graph[i][j];
        }
    }
    for(int mid = 1; mid <= n; mid++){
        for(int a = 1; a <= n; a++){
            for(int b = 1; b <= n; b++){
                graph[a][b] = min(graph[a][b], graph[a][mid]+graph[mid][b]);
            }
        }
    }
    for(int i = 0; i < m; i++){
        int a, b, c;
        cin >> a >> b >> c;
        if(c >= graph[a][b]){
            cout << "Enjoy other party\n";
        }else{
            cout << "Stay here\n";
        }
    }
}