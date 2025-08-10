#include <iostream>
    #include <algorithm>
    #include   <set>
    #include <cctype>
    using namespace std;

    int main()
    {
    int n;
    cin>>n;
    string prmagent,currmagent;
    cin >>prmagent;
    int groub=1;
    for(int i=1;i<n;i++){
    cin>>currmagent;
    if(currmagent!=prmagent){
        groub++;
    }
    prmagent=currmagent;
    }
    cout<<groub;
    }


