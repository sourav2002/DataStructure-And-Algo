    #include<stdio.h>
    #define MAX 5
    typedef struct
    {
	    int top1;
	    int top2;
	    int ele[MAX];
    }DStack;
    void init( DStack *s )
    {
	    s->top1 = -1;
	    s->top2 = MAX;
    }
    void pushA( DStack *s, int item )
    {
	    if( s->top2 == s->top1 + 1 )
	    {
		    printf("\nStack Overflow Stack1");
		    return;
	    }

	    s->top1++;
	    s->ele[s->top1] = item;

	    printf("\nInserted item in Stack1 : %d",item);
    }
    void pushB( DStack *s, int item )
    {
	    if( s->top2 == s->top1 + 1 )
	    {
		    printf("\nStack Overflow Stack2");
		    return;
	    }
	    s->top2--;
	    s->ele[s->top2] = item;

	    printf("\nInserted item in Stack2 : %d",item);
    }
    int popA( DStack *s, int *item )
    {
	    if( s->top1 == -1 )
	    {
		    printf("\nStack Underflow Stack1");
		    return -1;
	    }
	    *item = s->ele[s->top1--];
	    return 0;
    }
    int popB( DStack *s, int *item )
    {
	    if( s->top2 == MAX )
	    {
		    printf("\nStack Underflow Stack2");
		    return -1;
	    }
	    *item = s->ele[s->top2++];
	    return 0;
    }
    int main()
    {
	    int item = 0;
	    DStack s;
	    init(&s);
	    pushA( &s, 10);
	    pushA( &s, 20);
	    pushA( &s, 30);
	    pushB( &s, 40);
	    pushB( &s, 50);
	    pushB( &s, 60);
	    if( popA(&s, &item) == 0 )
		    printf("\nDeleted item From Stack1 : %d",item);
	    if( popA(&s, &item) == 0 )
		    printf("\nDeleted item From Stack1 : %d",item);
	    if( popA(&s, &item) == 0 )
		    printf("\nDeleted item From Stack1 : %d",item);
	    if( popB(&s, &item) == 0 )
		    printf("\nDeleted item From Stack2 : %d",item);
	    if( popB(&s, &item) == 0 )
		    printf("\nDeleted item From Stack2 : %d",item);
	    if( popB(&s, &item) == 0 )
		    printf("\nDeleted item From Stack2 : %d",item);
	    printf("\n");
	    return 0;
    }
