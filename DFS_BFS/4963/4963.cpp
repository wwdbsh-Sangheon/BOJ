#include <iostream>

using namespace std;

int board[50][50];
int dx[8] = {0, 0, 1, -1, 1, -1, 1, -1};
int dy[8] = {1, -1, 0, 0, 1, -1, -1, 1};
int w, h;

void dfs(int x, int y){
    board[x][y] = 0;
    for(int i = 0; i < 8; i++){
        int nx = x + dx[i];
        int ny = y + dy[i];
        if(nx >= 0 && nx < h && ny >= 0 && ny < w && board[nx][ny] == 1){
            dfs(nx, ny);
        }
    }
}

int main(void){
    while(true){
        cin >> w >> h;
        if(w == 0 && h == 0){
            break;
        }
        for(int i = 0; i < h; i++){
            for(int j= 0; j < w; j++){
                cin >> board[i][j];
            }
        }
        int ans = 0;
        for(int i = 0; i < h; i++){
            for(int j = 0; j < w; j++){
                if(board[i][j]){
                    dfs(i, j);
                    ans++;
                }
            }
        }
        cout << ans << "\n";
    }
}