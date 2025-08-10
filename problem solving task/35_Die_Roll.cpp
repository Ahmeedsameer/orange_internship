// Online C++ compiler to run C++ program online
#include <iostream>
#include<cmath>
#include <cstdlib> 
#include <algorithm>
using namespace std;
int main() {
    // Write C++ code here
    int y,w;
    
    cin>>y>>w;
    int rest;
    int m = max(y,w);
    
   
    rest = 6-m+1;
    
    if(6%rest == 0){
        cout<<1<<"/"<<6/rest;
    }else if (rest%2 == 0)
    {
        cout<<rest/2<<"/"<<3; 
    }
    else
    {
        cout<<rest<<"/"<<6;
    }
    
    
  

    return 0;
}



////////////////////////////////////////
//another solution 
#include <iostream>
        #include <algorithm>
        #include   <set>
        #include <cctype>
        #include<numeric>
        using namespace std;
        int gcd(int a ,int b){
        return b==0?a:gcd(b,a%b);
        }
        int main()
        {
            int y,w;
            cin>>y>>w;
            int need=max(y,w);
            int win =6-need+1;
            int g=gcd(win,6);
            cout<<win/g<<"/"<<6/g;
        }