#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<math.h>
#define SIZE 100

struct stack
{
    char data[SIZE];
    int top;
};
void push(struct stack *sptr, char num);
void check(struct stack *sptr,char no[SIZE]);
char pop(struct stack *sptr);

void push(struct stack *sptr, char num)
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
char pop(struct stack *sptr)
{
    int num;
    num=sptr->data[sptr->top];
    sptr->top--;
    return num;
}

void check(struct stack *sptr,char no[SIZE])
{
    int ch,stat=1;
    int i=0;
    char temp;
    while(no[i]!='\0')
    {
        ch=no[i];
        push(sptr,ch);
        i++;
    }
    i=0;
    while(no[i]!='\0')
    {
        temp=no[i];
        if(temp!=pop(sptr))
        {
            stat=0;
            break;
        }
        i++;
    }
    if(stat==1)
    {
        printf("%s is a palindrome string",no);
    }
    else
    {
        printf("%s is not a palindrome string",no);
    }
    
    
}
int main()
{
    struct stack * sptr;
    struct stack s;
    char pa[SIZE];
    sptr=&s;
    sptr->top=-1;
    scanf("%s",pa);
    check(sptr,pa);
    return 0;
}

/*
OUTPUT:
Input (stdin)
GADAG

Your Output (stdout)
GADAG is a palindrome string

