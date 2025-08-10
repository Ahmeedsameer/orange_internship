#include <iostream>
    #include <algorithm>
    #include   <set>
    #include <cctype>
    using namespace std;

    int main()
    {
    string word ;
    cin>>word;
    int uppercase=0;
    int lowercase=0;
    for(char c:word){
        if(isupper(c)){
            uppercase++;
        }
        else{
            lowercase++;
        }
    }
    if(uppercase>lowercase)
    for(char&c:word){
        c=toupper(c);
        cout<<c;
        }
    else{
        for(char&c:word){
            c=towlower(c);
             cout<<c;
        }
    }
    }