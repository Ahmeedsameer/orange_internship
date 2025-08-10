#include <iostream>
using namespace std;
int main() {
   short x,y,steps = 0,flage = 0;
   char temp; 
   
   
   
   
   for(int i = 0;i<5;i++){
      
       for(int j = 0;j<5;j++){
         cin>>temp;
         if(temp == '1'){
             x = i+1;
             y= j+1;
            
         }
          
       }
   }
   
   while(x != 3){
       if(x < 3)
        x++;
        else
        x--;
        
        steps++;
   }
   
    while(y != 3){
       if(y < 3)
        y++;
        else
        y--;
        
        steps++;
   }
    
    cout<<steps;
   
  
   
    

    return 0;
}