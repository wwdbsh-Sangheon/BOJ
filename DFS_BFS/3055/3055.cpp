#include <iostream>
#include <queue>
#include <vector>

using namespace std;

vector<pair<int,int>> water;
char board[50][50];
int board_c[50][50];
int dx[4] = {1, -1, 0, 0};
int dy[4] = {0, 0, 1, -1};
int r, c, s_r, s_c;

void water_bfs(int x, int y){
    queue<vector<int>> q;
    q.push({x, y, 0});
    while(!q.empty()){
        vector<int> cur = q.front(); q.pop();
        for(int i = 0; i < 4; i++){
            int nx = cur[0] + dx[i];
            int ny = cur[1] + dy[i];
            if(nx >= 0 && nx < r && ny >= 0 && ny < c && board_c[nx][ny] != -1 && (board_c[nx][ny] == 0 || cur[2]+1 < board_c[nx][ny])){
                board_c[nx][ny] = cur[2] + 1;
                q.push({nx, ny, cur[2]+1});
            }    
        }
    }
}

int bfs(int x, int y){
    queue<vector<int>> q;
    q.push({x, y, 0});
    while(!q.empty()){
        vector<int> cur = q.front(); q.pop();
        for(int i = 0; i < 4; i++){
            int nx = cur[0] + dx[i];
            int ny = cur[1] + dy[i];
            if(nx >= 0 && nx < r && ny >= 0 && ny < c){
                if(board[nx][ny] == '.' && (cur[2]+1 < board_c[nx][ny] || board_c[nx][ny] == 0)){
                    board[nx][ny] = 'S';
                    q.push({nx, ny, cur[2]+1});
                }
                if(board[nx][ny] == 'D'){
                    return cur[2]+1;
                }
            }
        }
    }
    return -1;
}

int main(void){
    cin >> r >> c;
    for(int i = 0; i < r; i++){
        for(int j = 0; j < c; j++){
            char c;
            cin >> c;
            board[i][j] = c;
            if(c == 'D' || c == 'S' || c == 'X' || c == '*') board_c[i][j] = -1;
            if(c == '*') water.push_back({i, j});
            if(c == 'S') s_r = i; s_c = j;
        }
    }
    for(int i = 0; i < water.size(); i++){
        water_bfs(water[i].first, water[i].second);
    }
    int t = bfs(s_r, s_c);
    t != -1 ? cout << t << "\n" : cout << "KAKTUS\n";
}