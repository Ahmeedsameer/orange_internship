#include <iostream>
using namespace std;
int main() {
   int n;
   int result = 0;
   char x;
   cin>>n;
   
   for(int i = 0;i<n;i++){
       cin>>x;
        result+= (x == 'A')?1:-1;
   }
   
   if(result > 0)
    cout << "Anton";
    else if(result < 0)
    cout<<"Danik";
   else
    cout<<"Friendship";
   
    

    return 0;
}