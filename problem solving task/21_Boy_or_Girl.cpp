#include <iostream>
    #include<algorithm>
    #include<set>
    using namespace std;

    int main()
    {
    string user_name;
    cin>>user_name;
   set<char>words(user_name.begin(),user_name.end());
   if(words.size()%2==0){
    cout<<"CHAT WITH HER!"<<endl;
   }
   else {
    cout<<"IGNORE HIM!";
   }


    }