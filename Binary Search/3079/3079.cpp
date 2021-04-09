#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

vector<int> avaliable;
long long t[100000];
bool chk[100000];
int n, m;

long long b_search(int start, int end){
    if(start > end){
        
    }
}

int main(void){
    cin >> n >> m;
    for(int i = 0; i < n; i++){
        cin >> t[i];
    }
    sort(t, t+n);
    while(m != 0){
        for(int i = 0; i < n; i++){
            if(!chk[i]){
                chk[i] = true;
                m--;
            }
            if(m == 0){
                break;
            }

        }
    }
}