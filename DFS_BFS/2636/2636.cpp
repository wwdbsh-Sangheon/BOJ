#include <iostream>
#include <algorithm>
#include <queue>
#include <vector>

using namespace std;

vector<pair<int,int>> candidates;
int board[100][100];
bool chk[100][100];
int dx[4] = {0, 0, 1, -1};
int dy[4] = {1, -1, 0, 0};
int m, n, cheese_count;

void bfs(){
    queue<pair<int,int>> q;
    q.push({0, 0});
    chk[0][0] = true;
    while(!q.empty()){
        int x = q.front().first;
        int y = q.front().second;
        q.pop();
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < m && ny >= 0 && ny < n && !chk[nx][ny]){
                if(board[nx][ny] == 1){
                    candidates.push_back({nx, ny});
                    cheese_count--;
                }else{
                    q.push({nx, ny});
                }
                chk[nx][ny] = true;
            }
        }
    }
    for(int i = 0; i < m; i++){
        fill(chk[i], chk[i]+n, false);
    }
}

void melt(){
    if(candidates.size() != 0){
        for(int i = 0; i < candidates.size(); i++){
            board[candidates[i].first][candidates[i].second] = 0;
        }
        candidates.clear();
    }
}

int main(void){
    cin >> m >> n;
    for(int i = 0; i < m; i++){
        for(int j = 0; j < n; j++){
            cin >> board[i][j];
            if(board[i][j] == 1){
                cheese_count++;
            }
        }
    }
    int t = 0;
    while(cheese_count != 0){
        melt();
        bfs();
        t++;
    }
    cout << t << "\n" << candidates.size() << "\n";
    candidates.clear();
}