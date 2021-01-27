#include <iostream>
#include <deque>

using namespace std;

deque<pair<int,int>> snake;
deque<pair<int, char>> plans;
int board[100][100];
int dx[4] = {0, 1, 0, -1};
int dy[4] = {1, 0, -1, 0};
int n, k, l, direction;

bool check(int x, int y){
    if(x < 0 || x >= n  || y < 0 || y >= n){
        return true;
    }
    for(int i = 0; i < snake.size(); i++){
        if(x == snake[i].first && y == snake[i].second){
            return true;
        }
    }
    return false;
}

int move(int x, int y, int sec){
    if(check(x, y)) return sec;

    snake.push_front(make_pair(x, y));
    if(board[x][y] == 1){
        board[x][y] = 0;
    }else{
        snake.pop_back();
    }
    if(!plans.empty() && sec == plans.front().first){
        direction = plans.front().second == 'D' ? direction + 1 : direction - 1;
        if(direction == 4){
            direction = 0;
        }else if(direction == -1){
            direction = 3;
        }
        plans.pop_front();
    }
    return move(x+dx[direction], y+dy[direction], sec+1);
}

int main(void){
    cin >> n >> k;
    for(int i = 0; i < k; i++){
        int x, y;
        cin >> x >> y;
        board[x-1][y-1] = 1;
    }
    cin >> l;
    for(int i = 0; i < l; i++){
        int sec;
        char d;
        cin >> sec >> d;
        plans.push_back(make_pair(sec, d));
    }
    snake.push_front(make_pair(0, 0));
    cout << move(0, 1, 1) << "\n";
}