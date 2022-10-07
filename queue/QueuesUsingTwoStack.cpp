// using classes
// optimisation needed
#include <iostream>
#include <stack>
using namespace std;

class myqueue{
	stack<int> st1;
	stack<int> st2;
public:
	void poping()
	{
		if(st1.empty())
          cout<<"THE STACK IS EMPTY!"<<endl;
      else {
      	while(!st1.empty())
      	{
      		st2.push(st1.top());
      		st1.pop();
      	}

      	st2.pop();

      	while(!st2.empty())
      	{
      		st1.push(st2.top());
      		st2.pop();
      	}
      }
	}


	void pushing(int ele)
	{
	    st1.push(ele);
	}

	void print()
	{
		// we need to push all the elements from st1 to st2 and then print elements of st2 so as to maintain 
		// the order of queue
        if(st1.empty())
          cout<<"THE STACK IS EMPTY!"<<endl;
      else {
      	while(!st1.empty())
      	{
      		st2.push(st1.top());
      		st1.pop();
      	}


      	while(!st2.empty())
      	{
      	cout<<st2.top()<<" ";    
      	st2.pop();  	
      }

	}
}
};
int main()
{

    myqueue mq;
    mq.pushing(1);
    mq.pushing(2);
    mq.pushing(3);
    mq.pushing(4);
    mq.pushing(5);
    mq.pushing(6);
    mq.poping();
    mq.poping();
    mq.poping();
    mq.pushing(7);
    mq.pushing(8);
    mq.pushing(9);
    mq.print();	
	return 0;
}
