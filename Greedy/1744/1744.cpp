#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

vector<int> positive, negative;
int n;

int main(void){
    cin >> n;
    for(int i = 0; i < n; i++){
        int val;
        cin >> val;
        if(val > 0){
            positive.push_back(val);
        }else{
            negative.push_back(val);
        }
    }
    sort(positive.begin(), positive.end());
    sort(negative.begin(), negative.end());
    int max_tot = 0, pair1 = 0, pair2 = 0;
    for(int i = positive.size()-1, j = 0; i >= 0; i--, j++){
        if(j%2 == 0){
            pair1 = positive[i];
            pair2 = positive[i];
        }else{
            pair1 *= positive[i];
            pair2 += positive[i];
            max_tot += max(pair1, pair2);
            pair1 = 0;
        }
    }
    max_tot += pair1;
    pair1 = 0;
    for(int i = 0; i < negative.size(); i++){
        if(i%2 == 0){
            pair1 = negative[i];
        }else{
            pair1 *= negative[i];
            max_tot += pair1;
            pair1 = 0;
        }
    }
    max_tot += pair1;
    cout << max_tot << "\n";
}