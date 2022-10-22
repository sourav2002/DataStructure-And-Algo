//CODE:

#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<math.h>
#define SIZE 100 
struct stack
{
    int coin[SIZE];
    int top;
};
void push(struct stack *sptr, int num);
void pop_count_display(struct stack *sptr);
int main()
{
    struct stack * sptr;
    struct stack s;
    sptr=&s;
    sptr->top=-1;
    int c,n,i;
    scanf("%d",&n);
    if(n<0)
    {
        printf("Invalid number of coins");
        exit(0);
    }
    for(i=0;i<n;i++) 
{ 
scanf("%d",&c); 
push(sptr,c); 
} 
pop_count_display(sptr);
 } 
void push(struct stack *sptr, int num)
 { 
if(sptr->top==SIZE-1)
    {
        printf("Stack Overflow\n");
    }
    else
    {
        sptr->top++;
        sptr->coin[sptr->top]=num;
    }
}
void pop_count_display(struct stack *sptr)
{
        int i,c1=0,c2=0,c5=0,c10=0,c=0;
        for(i=sptr->top;i>=0;i--)
        {
            if(sptr->coin[i]==1)
            {
               c1++;
            }

            else if(sptr->coin[i]==2)
            {
               c2++;
            }
            else if(sptr->coin[i]==5)
            {
               c5++;
            }
            else if(sptr->coin[i]==10)
            {
               c10++;
            }
            else
            {
                c++;
            }
            sptr->top--;
        }
        printf("Coins of 1 re = %d\n",c1);
        printf("Coins of 2 rs = %d\n",c2);
        printf("Coins of 5 rs = %d\n",c5);
        printf("Coins of 10 rs = %d\n",c10);
    printf("Coins of invalid denominations = %d",c);
}


/*OUTPUT:

Input (stdin)
5
1 2 5 10 1

Your Output (stdout)
Coins of 1 re = 2
Coins of 2 rs = 1
Coins of 5 rs = 1
Coins of 10 rs = 1
Coins of invalid denominations = 0  */
