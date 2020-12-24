#include <iostream>
#include <algorithm>

using namespace std;

int n, m, ans;
int dx[4] = {0, 0, 1, -1};
int dy[4] = {1, -1, 0, 0};
int board[8][8], clone[8][8];

int get_safe_count(){
    int count = 0;
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            if(clone[i][j] == 0){
                count++;
            }
        }
    }
    return count;
}

void virus(int x, int y){
    for(int i = 0; i < 4; i++){
        int nx = x + dx[i];
        int ny = y + dy[i];
        if(nx >= 0 && nx < n && ny >= 0 && ny < m && clone[nx][ny] == 0){
            clone[nx][ny] = 2;
            virus(nx, ny);
        }
    }
}

void copy_board(){
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            clone[i][j] = board[i][j];
        }
    }
}

int build(int count){
    
    int rt = 0;

    if(count == 3){
        copy_board();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(clone[i][j] == 2){
                    virus(i, j);
                }
            }
        }
        return get_safe_count();
    }

    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            if(board[i][j] == 0){
                board[i][j] = 1;
                rt = max(rt, build(count+1));
                board[i][j] = 0;
            }
        }
    }
    return rt;
}

int main(void){
    cin >> n >> m;
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            cin >> board[i][j];
        }
    }
    cout << build(0) << "\n";
}