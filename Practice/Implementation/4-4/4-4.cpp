#include <iostream>

using namespace std;

int board[50][50];
int dx[4] = {-1, 0, 1, 0};
int dy[4] = {0, 1, 0, -1};
int n, m, a, b, dir;

int move(int x, int y, int dir, int count){
    if(board[x][y] == 1){
        return count;
    }
    for(int i = 0; i < 4; i++){
        dir--;
        if(dir == -1){
            dir = 3;
        }
        int nx = x + dx[dir];
        int ny = y + dy[dir];
        if(board[nx][ny] == 0){
            board[nx][ny] = 2;
            return move(nx, ny, dir, count+1);
        }
    }
    return move(x + dx[dir]*(-1), y + dy[dir]*(-1), dir, count);
}

int main(void){
    cin >> n >> m >> a >> b >> dir;
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            cin >> board[i][j];
        }
    }
    board[a][b] = 2;
    cout << move(a, b, dir, 1) << "\n";
}