#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

vector<string> ans;
string board[5][5];
int dx[4] = {0, 0, 1, -1};
int dy[4] = {1, -1, 0, 0};

void dfs(string number, int x, int y, int count){
    if(count == 6){
        if(find(ans.begin(), ans.end(), number) == ans.end()){
            ans.push_back(number);
        }
        return;
    }
    for(int i = 0; i < 4; i++){
        int nx = x + dx[i];
        int ny = y + dy[i];
        if(nx >= 0 && nx < 5 && ny >= 0 && ny < 5){
            dfs(number+board[nx][ny], nx, ny, count+1);
        }
    }
}

int main(void){
    for(int i = 0; i < 5; i++){
        for(int j = 0; j < 5; j++){
            cin >> board[i][j];
        }
    }   
    for(int i = 0; i < 5; i++){
        for(int j = 0; j < 5; j++){
            dfs(board[i][j], i, j, 1);
        }
    }
    cout << ans.size() << "\n";
}