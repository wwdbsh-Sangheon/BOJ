#include <iostream>
#include <queue>

using namespace std;

int board[200][200];
int dx[4] = {0, 0, 1, -1};
int dy[4] = {1, -1, 0, 0};
int n, m;

class Pos{
    public:
    int x, y, count;
    Pos(int _x, int _y, int _count){
        this->x = _x;
        this->y = _y;
        this->count = _count;
    }
};

int bfs(int x, int y){
    queue<Pos> q;
    q.push(Pos(x, y, 1));
    board[x][y] = 0;
    while(!q.empty()){
        Pos cur = q.front(); q.pop();
        if(cur.x == n-1 && cur.y == m-1){
            return cur.count;
        }
        for(int i = 0; i < 4; i++){
            int nx = cur.x + dx[i];
            int ny = cur.y + dy[i];
            if(nx >= 0 && ny >= 0 && nx < n && ny < m && board[nx][ny] == 1){
                board[nx][ny] = 0;
                q.push(Pos(nx, ny, cur.count+1));
            }
        }
    }
    return -1;
}

int main(void){
    cin >> n >> m;
    for(int i = 0; i < n; i++){
        string line;
        cin >> line;
        for(int j = 0; j < m; j++){
            board[i][j] = (int)(line[j] - '0');
        }
    }
    cout << bfs(0, 0) << "\n";
}