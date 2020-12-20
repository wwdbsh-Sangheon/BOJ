#include <iostream>
#include <algorithm>
#include <queue>
#include <vector>

using namespace std;

class Node{
    public:
        int x;
        int y;
        int count;
        Node(int _x, int _y, int _count){
            x = _x;
            y = _y;
            count = _count;
        }
};

int n, m;
char board[200][200];

int dx[4] = {0, 0, 1, -1};
int dy[4] = {1, -1, 0, 0};

int dfs(int x, int y, int count){
    int rt = 1e9;
    if(x == n-1 && y == m-1){
        return count;
    }
    for(int i = 0; i < 4; i++){
        int nx = x + dx[i];
        int ny = y + dy[i];
        if(nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny] == '1'){
            board[nx][ny] = '2';
            rt = min(rt, dfs(nx, ny, count+1));
            board[nx][ny] = '1';
        }
    }
    return rt;
}

int bfs(int x, int y){
    int rt = 1e9;
    queue<Node> q;
    board[x][y] = '2';
    q.push(Node(x, y, 1));
    while(!q.empty()){
        Node node = q.front(); q.pop();
        if(node.x == n-1 && node.y == m-1){
            rt = min(rt, node.count);
            break;
        }
        for(int i = 0; i < 4; i++){
            int nx = node.x + dx[i];
            int ny = node.y + dy[i];
            if(nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny] == '1'){
                board[nx][ny] = '2';
                q.push(Node(nx, ny, node.count+1));
            }
        }

    }
    return rt;
}

int main(void){
    cin >> n >> m;
    for(int i = 0; i < n; i++){
        string line;
        cin >> line;
        for(int j = 0; j < m; j++){
            board[i][j] = line[j];
        }
    }
    board[0][0] = '2';
    cout << dfs(0, 0, 1) << "\n";
    cout << bfs(0, 0) << "\n";
}