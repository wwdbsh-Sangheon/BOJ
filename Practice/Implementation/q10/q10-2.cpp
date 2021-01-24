#include <iostream>
#include <vector>

using namespace std;

int key_len, lock_len;

vector<vector<int>> rotate(vector<vector<int>> key){
    vector<vector<int>> r_key(key_len, vector<int>(key_len, 0));
    for(int i = 0; i < key_len; i++){
        for(int j = 0; j < key_len; j++){
            r_key[j][key_len-1-i] = key[i][j];
        }
    }
    return r_key;
}

bool check(vector<vector<int>> lock){
    for(int i = key_len-1; i < key_len-1+lock_len; i++){
        for(int j = key_len-1; j < key_len-1+lock_len; j++){
            if(lock[i][j] != 1){
                return false;
            }
        }
    }
    return true;
}

bool solution(vector<vector<int>> key, vector<vector<int>> lock) {
    
    key_len = key.size(); lock_len = lock.size();
    vector<vector<int>> e_lock(lock_len + 2*(key_len-1), vector<int>(lock_len + 2*(key_len-1), 0));
    for(int i = 0; i < lock_len; i++){
        for(int j = 0; j < lock_len; j++){
            e_lock[i+key_len-1][j+key_len-1] = lock[i][j];
        }
    }

    for(int r_idx = 0; r_idx < 4; r_idx++){
        for(int start_x = 0; start_x <= e_lock.size()-key_len; start_x++){
            for(int start_y = 0; start_y <= e_lock.size()-key_len; start_y++){
                for(int i = 0; i < key_len; i++){
                    for(int j = 0; j < key_len; j++){
                        e_lock[start_x+i][start_y+j] += key[i][j];
                    }
                }
                if(check(e_lock)) return true;
                for(int i = 0; i < key_len; i++){
                    for(int j = 0; j < key_len; j++){
                        e_lock[start_x+i][start_y+j] -= key[i][j];
                    }
                }
            }
        }
        key = rotate(key);
    }
    return false;
}

int main(void){
    cout << solution({{0, 0, 0}, {1, 0, 0}, {0, 1, 1}}, {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}}) << "\n";
}