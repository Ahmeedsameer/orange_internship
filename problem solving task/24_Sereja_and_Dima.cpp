#include <iostream>
    #include <algorithm>
    #include   <set>
    #include <cctype>
    using namespace std;

    int main()
    {
    int n,l,r;
    cin>>n;
    int cards[n],sreja,dima;
    sreja=0;
    dima=0;
    l=0;
    r =n-1;
    bool turn =true;
    for(int i =0 ;i<n;i++){
        cin>>cards[i];
    }
    while(l<=r){
        int pick;
        if(cards[l]>cards[r]){
            pick=cards[l];
            l++;
        }
        else{
            pick=cards[r];
            r--;
        }
        if(turn){
            sreja+=pick;
        }
        else{
            dima+=pick;
        }
        turn=!turn;

    }
    cout << sreja << " " << dima << endl;
    }