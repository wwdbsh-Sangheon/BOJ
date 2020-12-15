#include <iostream>
#include <string>
#include <vector>

using namespace std;

vector<vector<int>> pos;

vector<vector<int>> turn_clockwise(vector<vector<int>> key){
    
    int size = key.size();
    vector<vector<int>> rt(size, vector<int>(size, 0));
    
    for(int i = 0; i < size; i++){
        for(int j = 0; j < size; j++){
            rt[j][size-1-i] = key[i][j];
        }
    }
    return rt;
}

bool check(vector<vector<int>>& check_lock, int key_size){
    for(int i = key_size-1; i <= check_lock.size()-key_size; i++){
        for(int j = key_size-1; j <= check_lock.size()-key_size; j++){
            if(check_lock[i][j] == 0){
                return false; 
            }
        }
    }
    return true;
}

void go_back(vector<vector<int>>& check_lock){
    for(int i = 0; i < pos.size(); i++){
        int x = pos[i][0];
        int y = pos[i][1];
        check_lock[x][y] = 0;
    }
    pos.clear();
}

bool open_lock(vector<vector<int>> key, vector<vector<int>>& check_lock){
    
    int flag = 0;
    int key_size = key.size();
    int check_size = check_lock.size();
    
    for(int i = 0; i <= check_size-key_size; i++){
        for(int j = 0; j <= check_size-key_size; j++){
            for(int k = 0; k < key_size; k++){
                for(int l = 0; l < key_size; l++){
                    if(i+k >= key_size-1 && i+k <= check_lock.size()-key_size &&
                     j+l >= key_size-1 && j+l <= check_lock.size()-key_size &&
                     check_lock[i+k][j+l] == 1 && key[k][l] == 1){
                        flag = 1;
                        break;
                    }
                    if(check_lock[i+k][j+l] == 0 && key[k][l] == 1){
                        check_lock[i+k][j+l] = 1;
                        pos.push_back({i+k, j+l});
                        if(check(check_lock, key_size)) return true;
                    }
                }
                if(flag){
                    flag = 0;
                    break;
                }
            }
            go_back(check_lock);
        }
    }
    return false;
}

vector<vector<int>> create_check_lock(vector<vector<int>> key, vector<vector<int>> lock){
    
    vector<vector<int>> check_lock(lock.size()+2*key.size()-2, vector<int>(lock.size()+2*key.size()-2, 1));

    for(int i = 0; i < lock.size(); i++){
        for(int j = 0; j < lock[i].size(); j++){
            if(lock[i][j] == 0){
                int x = i+key.size()-1;
                int y = j+key.size()-1;
                check_lock[x][y] = 0;
            }
        }
    }
    return check_lock;
}

bool solution(vector<vector<int>> key, vector<vector<int>> lock) {
    bool answer = false;
    
    vector<vector<int>> check_lock = create_check_lock(key, lock);
    
    for(int i = 0; i < 4; i++){
        answer = open_lock(key, check_lock);
        if(answer) break;
        key = turn_clockwise(key);
    }
    return answer ? answer : check(check_lock, key.size()); // 자물쇠에 홈이 없을 경우를 처리해주기 위한 로직
}