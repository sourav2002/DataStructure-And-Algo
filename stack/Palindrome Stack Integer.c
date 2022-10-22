//code

#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<math.h>
#define SIZE 100

struct stack
{
    int data[SIZE];
    int top;
};
void push(struct stack *sptr, int num);
void check(struct stack *sptr,int no);
int pop(struct stack *sptr);

void push(struct stack *sptr, int num)
{
    if(sptr->top==SIZE-1)
    {
        printf("Stack Overflow\n");
    }
    else
    {
        sptr->top++;
        sptr->data[sptr->top]=num;
    }
}
int pop(struct stack *sptr)
{
    int num;
    num=sptr->data[sptr->top];
    sptr->top--;
    return num;
}

void check(struct stack *sptr,int no)
{
    int temp,num=no,copy,c=0,stat=1;
    while(no!=0)
    {
        temp=no%10;
        push(sptr,temp);
        c++;
        no=no/10;
    }
    copy=num;
    while(copy!=0)
    {
        temp=copy%10;
        if(temp!=pop(sptr))
        {
            stat=0;
            break;
        }
        copy=copy/10;
    }
    if(stat==1)
    {
        printf("%d is a palindrome number",num);
    }
    else
    {
        printf("%d is not a palindrome number",num);
    }
    
    
}
int main()
{
    struct stack * sptr;
    struct stack s;
    int no;
    sptr=&s;
    sptr->top=-1;
    scanf("%d",&no);
    if(no>0)
    {
        check(sptr,no);
    }
    else
    {
        printf("Invalid number ");
        exit(0);
    }
    return 0;
}


/*Execution

121

Your Output (stdout)
121 is a palindrome number
