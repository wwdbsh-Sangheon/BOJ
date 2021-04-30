#include <iostream>

using namespace std;

int board[50][50];
int dx[] = {-1, 0, 1, 0};
int dy[] = {0, 1, 0, -1};
int n, m, r, c, d;

bool check(int x, int y){
    for(int i = 0; i < 4; i++){
        int nx = x + dx[i];
        int ny = y + dy[i];
        if(board[nx][ny] == 0){
            return false;
        }
    }
    return true;
}

int op(int x, int y, int cnt){
    if(check(x, y)){
        if(board[x+dx[(d+2)%4]][y+dy[(d+2)%4]] == 1){
            return cnt;
        }else{
            return op(x+dx[(d+2)%4], y+dy[(d+2)%4], cnt);
        }
    }
    d = d-1 < 0 ? 3 : d-1;
    int nx = x + dx[d];
    int ny = y + dy[d];
    if(board[nx][ny] == 0){
        board[nx][ny] = 2;
        return op(nx, ny, cnt+1);
    }else{
        return op(x, y, cnt);
    }
}

int main(void){
    cin >> n >> m;
    cin >> r >> c >> d;
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            cin >> board[i][j];
        }
    }
    board[r][c] = 2;
    cout << op(r, c, 1);
}