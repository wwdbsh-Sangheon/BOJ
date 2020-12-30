#include <iostream>
#include <queue>
#include <vector>
#include <cstring>

using namespace std;

int n, l, r;
int board[50][50];
int chk[50][50];
int dx[4] = {0, 0, 1, -1};
int dy[4] = {1, -1, 0, 0};
vector<pair<int, int>> u;

bool check_diff(int diff){
    return diff >= l && diff <= r;
}

int bfs(int x, int y){
    int population = 0, count = 0;
    queue<pair<int,int>> q;
    q.push(make_pair(x, y));
    chk[x][y] = 1;
    while(!q.empty()){
        pair<int,int> root = q.front();
        u.push_back(make_pair(root.first, root.second));
        population += board[root.first][root.second];
        count++;
        q.pop();
        for(int i = 0; i < 4; i++){
            int nx = root.first + dx[i];
            int ny = root.second + dy[i];
            if(nx >= 0 && nx < n && ny >= 0 && ny < n && chk[nx][ny] == 0){
                int diff = abs(board[root.first][root.second]-board[nx][ny]);
                if(check_diff(diff)){
                    q.push(make_pair(nx, ny));
                    u.push_back(make_pair(nx, ny));
                    chk[nx][ny] = 1;
                }
            }
        }
    }
    return population/count;
}

bool update_population(int population){
    int num = u.size();
    for(int i = 0; i < num; i++){
        int x = u[i].first;
        int y = u[i].second;
        board[x][y] = population;
    }
    u.clear();
    return num != 1;
}

int set_union(){
    int count = 0;
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            if(chk[i][j] == 0){
                if(update_population(bfs(i, j))){
                    count++;
                }
            }
        }
    }
    memset(chk, 0, sizeof(chk));
    return count;
}

int main(void){
    cin >> n >> l >> r;
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            cin >> board[i][j];
        }
    }
    int ans = 0;
    while(set_union() != 0) ans++;
    cout << ans << "\n";
}