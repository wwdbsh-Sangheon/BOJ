#include <iostream>
#include <algorithm>
#include <cstring>
#include <queue>
#include <vector>

using namespace std;

vector<vector<int>> fish_info;

int board[20][20];
int chk[20][20];
int dx[4] = {0, -1, 1, 0};
int dy[4] = {-1, 0, 0, 1};
int shark_size = 2;
int fish_count = 0;
int time, n, cur_x, cur_y;

bool compare_fish(vector<int> f1, vector<int> f2){
    if(f1[0] == f2[0]){
        if(f1[1] == f2[1]){
            return f1[2] < f2[2];
        }else{
            return f1[1] < f2[1];
        }
    }else{
        return f1[0] < f2[0];
    }
}

void eat_fish(){
    vector<int> fish = fish_info[0];
    cur_x = fish[1];
    cur_y = fish[2];
    time += fish[0];
    board[cur_x][cur_y] = 0;
    fish_count++;
    if(shark_size == fish_count){
        shark_size++;
        fish_count = 0;
    }
    fish_info.clear();
}

void bfs(){
    queue<vector<int>> q;
    q.push({cur_x, cur_y, 0});
    chk[cur_x][cur_y] = 1;
    while(!q.empty()){
        int x = q.front()[0];
        int y = q.front()[1];
        int t = q.front()[2];
        q.pop();
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < n && ny >= 0 && ny < n && chk[nx][ny] == 0){
                if(shark_size >= board[nx][ny]){
                    chk[nx][ny] = 1;
                    q.push({nx, ny, t+1});
                    if(shark_size > board[nx][ny] && board[nx][ny] != 0){
                        fish_info.push_back({t+1, nx, ny});
                    }
                }
            }
        }
    }
    if(fish_info.size() == 0) return;
    sort(fish_info.begin(), fish_info.end(), compare_fish);
    memset(chk, 0, sizeof(chk));
    eat_fish();
    bfs();
}

int main(void){
    cin >> n;
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            int value;
            cin >> value;
            if(value == 9){
                cur_x = i;
                cur_y = j;
            }else{
                board[i][j] = value;
            }
        }
    }
    bfs();
    cout << time << "\n";
}