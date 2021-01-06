#include <iostream>
#include <algorithm>

using namespace std;

int n;
int seq[500];

void print_seq(){
    for(int i = 0; i < n; i++){
        cout << seq[i] << " ";
    }
    cout << "\n";
}

int compare(int a, int b){
    return a > b;
}

int main(void){
    cin >> n;
    for(int i = 0; i < n; i++){
        cin >> seq[i];
    }
    sort(seq, seq+n, compare);
    print_seq();
}