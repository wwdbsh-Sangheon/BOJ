#include <iostream>
#include <queue>

using namespace std;

int board[1000][1000];
int dx[4] = {0, 0, 1, -1};
int dy[4] = {1, -1, 0, 0};
int n, m;

void bfs(int x, int y){
    queue<pair<int,int>> q;
    q.push(make_pair(x, y));
    board[x][y] = 1;
    while(!q.empty()){
        pair<int,int> cur = q.front();
        q.pop();
        for(int i = 0; i < 4; i++){
            int nx = cur.first + dx[i];
            int ny = cur.second + dy[i];
            if(nx >= 0 && ny >= 0 && nx < n && ny < m && board[nx][ny] == 0){
                q.push(make_pair(nx, ny));
                board[nx][ny] = 1;
            }
        }
    }
}

int main(void){
    cin >> n >> m;
    for(int i = 0; i < n; i++){
        string line;
        cin >> line;
        for(int j = 0; j < m; j++){
            board[i][j] = (int)(line[j] - '0');
        }
    }
    int count = 0;
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            if(board[i][j] == 0){
                bfs(i, j);
                count++;   
            }
        }
    }
    cout << count << "\n";
}