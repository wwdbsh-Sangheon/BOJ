#include <iostream>
#include <queue>

using namespace std;

char board[250][250];
int dx[4] = {0, 0, 1, -1};
int dy[4] = {1, -1, 0, 0};
int wolves, sheeps, r, c;

void bfs(int x, int y){ // space:0 sheep:1 wolf:2
    int s_tot = 0, w_tot = 0;
    queue<vector<int>> q;
    if(board[x][y] == 'o'){
        q.push({x, y, 1});
    }else if(board[x][y] == 'v'){
        q.push({x, y, 2});
    }else{
        q.push({x, y, 0});
    }
    board[x][y] = '#';
    while(!q.empty()){
        vector<int> now = q.front(); q.pop();
        if(now[2] == 1) s_tot++;
        if(now[2] == 2) w_tot++;
        for(int i = 0; i < 4; i++){
            int nx = now[0] + dx[i];
            int ny = now[1] + dy[i];
            if(nx >= 0 && nx < r && ny >= 0 && ny < c && board[nx][ny] != '#'){
                if(board[nx][ny] == 'o'){
                    q.push({nx, ny, 1});
                }else if(board[nx][ny] == 'v'){
                    q.push({nx, ny, 2});
                }else{
                    q.push({nx, ny, 0});
                }
                board[nx][ny] = '#';
            }
        }
    }
    if(s_tot != 0 && w_tot != 0){
        if(s_tot > w_tot){
            wolves -= w_tot;
        }else{
            sheeps -= s_tot;
        }
    }
}

int main(void){
    cin >> r >> c;
    for(int i = 0; i < r; i++){
        for(int j = 0; j < c; j++){
            char c;
            cin >> c;
            board[i][j] = c;
            if(c == 'o') sheeps++;
            if(c == 'v') wolves++;
        }
    }

    for(int i = 0; i < r; i++){
        for(int j = 0; j < c; j++){
            if(board[i][j] != '#'){
                bfs(i, j);
            }
        }
    }
    cout << sheeps << " " << wolves << "\n";
}