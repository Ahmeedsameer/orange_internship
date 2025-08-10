#include <iostream>
#include<cmath>
#include <cstdlib> 
using namespace std;
int main() {
    
    string stones,inst;
    int n = 0;
    
    cin>>stones;
    cin>>inst;
    
    for(int i = 0;i<inst.size();i++){
        if(stones[n] == inst[i])
            n++;
    }
    
    cout<<n+1;

    return 0;
}