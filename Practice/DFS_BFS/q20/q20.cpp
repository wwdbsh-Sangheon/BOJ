#include <iostream>
#include <vector>

using namespace std;

vector<pair<int,int>> teacher;
int board[6][6];
int dx[4] = {0, 0, 1, -1};
int dy[4] = {1, -1, 0, 0};
int n;

bool watch(int x, int y, int d){
    while(true){
        x = x + dx[d];
        y = y + dy[d];
        if(x < 0 || x >= n || y < 0 || y >= n || board[x][y] == 'O'){
            break;
        }
        if(board[x][y] == 'S'){
            return true;
        }
    }
    return false;
}

bool check_hide(){
    for(int i = 0; i < teacher.size(); i++){
        for(int j = 0; j < 4; j++){
            if(watch(teacher[i].first, teacher[i].second, j)){
               return false; 
            }
        }
    }
    return true;
}

bool set_obstacles(int count){
    if(count == 3){
        return check_hide();
    }
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            if(board[i][j] == 'X'){
                board[i][j] = 'O';
                if(set_obstacles(count+1)) return true;
                board[i][j] = 'X';
            }
        }
    }
    return false;
}

int main(void){
    cin >> n;
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            char c;
            cin >> c;
            board[i][j] = c;
            if(c == 'T'){
                teacher.push_back(make_pair(i, j));
            }
        }
    }
    set_obstacles(0) ? cout << "YES" << "\n" : cout << "NO" << "\n";
}