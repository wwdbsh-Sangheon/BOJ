#include <iostream>
#include <vector>

using namespace std;

vector<pair<int,int>> pos;
int board[100][100];
int chk[100][100];
int n, l;

bool possible(int x, int y, int dx, int dy){
    int cur_height = board[x][y];
    if(abs(board[x+dx][y+dy]-cur_height) != 1){
        return false;
    }
    if(cur_height < board[x+dx][y+dy]){
        if(chk[x][y] == 1){
            return false;
        }
        chk[x][y] = 1;
        pos.push_back(make_pair(x, y));
        for(int i = 0; i < l-1; i++){
            int nx = x+(dx*(-1));
            int ny = y+(dy*(-1));
            if(nx < 0 || nx >= n || ny < 0 || ny >= n || chk[nx][ny] == 1 || cur_height != board[nx][ny]){
                return false;
            }
            x = nx; y = ny;
            pos.push_back(make_pair(x, y));
            chk[x][y] = 1;
        }
    }else{
        cur_height = board[x+dx][y+dy];
        for(int i = 0; i < l; i++){
            int nx = x+dx;
            int ny = y+dy;
            if(nx < 0 || nx >= n || ny < 0 || ny >= n || chk[nx][ny] == 1 || cur_height != board[nx][ny]){
                return false;
            }
            x = nx; y = ny;
            pos.push_back(make_pair(x, y));
            chk[x][y] = 1;
        }
    }
    return true;
}

int cross_path(int x, int y, int dx, int dy){
    if(dx == 0){
        for(int i = 0; i < n-1; i++){
            if(board[x][y+(dy*i)] != board[x][y+(dy*i)+dy]){
                if(!possible(x, y+(dy*i), dx, dy)){
                    return 0;
                }
            }
        }
    }else{
        for(int i = 0; i < n-1; i++){
            if(board[x+(dx*i)][y] != board[x+(dx*i)+dx][y]){
                if(!possible(x+(dx*i), y, dx, dy)){
                    return 0;
                }
            }
        }
    }
    return 1;
}

void clear_chk(){
    for(int i = 0; i < pos.size(); i++){
        chk[pos[i].first][pos[i].second] = 0;
    }
    pos.clear();
}

int main(void){
    cin >> n >> l;
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            cin >> board[i][j];
        }
    }
    int ans = 0;
    for(int i = 0; i < n; i++){
        int path1 = cross_path(0, i, 1, 0);
        clear_chk();
        int path2 = cross_path(i, 0, 0, 1);
        clear_chk();
        ans += (path1+path2);
        
    }
    cout << ans << "\n";
}