#include <iostream>
#include <queue>
#include <vector>

using namespace std;

vector<vector<int>> graph(501);
bool chk[501];
int n, m;

int bfs(){
    int cnt = 0;
    queue<vector<int>> q;
    q.push({1, 0});
    chk[1] = true;
    while(!q.empty()){
        int now = q.front()[0];
        int f_count = q.front()[1]; q.pop();
        for(int i = 0; i < graph[now].size(); i++){
            if(!chk[graph[now][i]] && f_count < 2){
                chk[graph[now][i]] = true;
                q.push({graph[now][i], f_count+1});
                cnt++;
            }
        }
    }
    return cnt;
}

int main(void){
    cin >> n >> m;
    for(int i = 0; i < m; i++){
        int a, b;
        cin >> a >> b;
        graph[a].push_back(b);
        graph[b].push_back(a);
    }
    cout << bfs() << "\n";
}