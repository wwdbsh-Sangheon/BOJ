#include <iostream>

using namespace std;

int n, m;
int board[1000][1000];
int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, 1, 0, -1};

void dfs(int x, int y){    
    if(board[x][y] == 1) return;
    board[x][y] = 1;
    for(int i = 0; i < 4; i++){
        int nx = x + dx[i];
        int ny = y + dy[i];
        if(nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny] == 0){
            dfs(nx, ny);
        }
    }
}

int main(void){
    cin >> n >> m;
    for(int i = 0; i < n; i++){
        string line;
        cin >> line;
        for(int j = 0; j < m; j++){
            board[i][j] = line[j] - '0';
        }
    }

    int count = 0;

    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            if(board[i][j] == 0){
                count++;
                dfs(i, j);
            }
        }
    }
    cout << count << "\n";
}