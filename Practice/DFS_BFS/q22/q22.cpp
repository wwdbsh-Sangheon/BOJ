#include <iostream>
#include <queue>
#include <vector>

using namespace std;

class Pos{
    public:
    int s_x, s_y, e_x, e_y, sec;
    Pos(int x1, int y1, int x2, int y2, int _sec){
        this->s_x = x1;
        this->s_y = y1;
        this->e_x = x2;
        this->e_y = y2;
        this->sec = _sec;
    }
};

int n;
int dx[4] = {0, 0, 1, -1};
int dy[4] = {1, -1, 0, 0};

vector<Pos> visited;

bool check(Pos next){
    for(int i = 0; i < visited.size(); i++){
        Pos r = visited[i];
        if(next.s_x == r.s_x && next.s_y == r.s_y && next.e_x == r.e_x && next.e_y == r.e_y){
            return true;
        }
    }
    return false;
}

vector<Pos> get_next_pos(vector<vector<int>> board, Pos p){
    vector<Pos> rt;
    for(int i = 0; i < 4; i++){
        int nx1 = p.s_x + dx[i];
        int ny1 = p.s_y + dy[i];
        int nx2 = p.e_x + dx[i];
        int ny2 = p.e_y + dy[i];
        if(board[nx1][ny1] == 0 && board[nx2][ny2] == 0){
            rt.push_back(Pos(nx1, ny1, nx2, ny2, p.sec+1));
        }
    }
    int pm[2] = {-1, 1};
    for(int i = 0; i < 2; i++){
        if(p.s_x == p.e_x){
            if(board[p.s_x+pm[i]][p.s_y] == 0 && board[p.e_x+pm[i]][p.e_y] == 0){
                rt.push_back(Pos(p.s_x, p.s_y, p.s_x+pm[i], p.s_y, p.sec+1));
                rt.push_back(Pos(p.e_x, p.e_y, p.e_x+pm[i], p.e_y, p.sec+1));
            }
        }else{
            if(board[p.s_x][p.s_y+pm[i]] == 0 && board[p.e_x][p.e_y+pm[i]] == 0){
                rt.push_back(Pos(p.s_x, p.s_y, p.s_x, p.s_y+pm[i], p.sec+1));
                rt.push_back(Pos(p.e_x, p.e_y, p.e_x, p.e_y+pm[i], p.sec+1));
            }
        }
    }
    return rt;
}

int bfs(vector<vector<int>> board){
    queue<Pos> q;
    Pos root = Pos(1, 1, 1, 2, 0);
    q.push(root);
    visited.push_back(root);
    while(!q.empty()){
        Pos cur_p = q.front();
        if((cur_p.e_x == n && cur_p.e_y == n) || (cur_p.s_x == n && cur_p.s_y == n)){
            return cur_p.sec;
        }
        vector<Pos> next = get_next_pos(board, cur_p);
        q.pop();
        for(int i = 0; i < next.size(); i++){
            if(!check(next[i])){
                q.push(next[i]);
                visited.push_back(next[i]);
            }
        }
    }
    return 0;
}

int solution(vector<vector<int>> board) {
    n = board.size();
    vector<vector<int>> b(n+2, vector<int>(n+2, 1));
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            b[i+1][j+1] = board[i][j];
        }
    }
    return bfs(b);
}

int main(void){
    cout << solution({{0, 0, 0, 1, 1},{0, 0, 0, 1, 0},{0, 1, 0, 1, 1},{1, 1, 0, 0, 1},{0, 0, 0, 0, 0}}) << "\n";
}
