#include<stdio.h>
#include<stdlib.h>
struct stack{
    int size;
    int top;
    int * arr;//integer pointer
};
int isFull(struct stack * ptr){
    if(ptr->top == ptr->size-1){
        return 1;
    }
    return 0;
}
int isEmpty(struct stack * ptr){
    if(ptr->top == -1){
        return 1;
    }
    return 0;
}
void push(struct stack * ptr, int value){
    if(isFull(ptr)){
        printf("Stack overflow \n");
    }
    else{
        ptr->top++;
        ptr->arr[ptr->top]  = value;
    }
}
void pop(struct stack * ptr){
    if(isEmpty(ptr)){
        printf("Stack underflow \n");
    }
    else{
        int val = ptr->arr[ptr->top];
        ptr->top = ptr->top-1;
        return val;
    }
}
int peek(struct stack * sp, int index){
        if(sp->top-index+1<0){
            printf("not a valid position");
            return -1;
        }
        else{
            return sp->arr[sp->top-index+1];
        }
}
int stack_top(struct stack * ptr){
    return ptr->arr[ptr->top];
}
int stack_bottom(struct stack * ptr){
    return ptr->arr[0];
}
int main(){
    struct stack * sp = (struct stack * )malloc(sizeof(struct stack));
    sp->size = 50;
    sp->top = -1;
    sp->arr = (int *)malloc(sp->size*sizeof(int));
    printf("STACK CRETION SUCCESSFULL : \n");
    printf("%d\n", isEmpty(sp));
    printf("%d\n", isFull(sp));
    push(sp, 12);
    push(sp, 22);
    push(sp, 2);
    printf("AFTER PUSHING : \n\n");
    printf("%d\n", isEmpty(sp));
    printf("%d\n", isFull(sp));
    pop(sp);//element 8 is popped out
    printf("%d\n", isEmpty(sp));
    printf("%d\n", isFull(sp));
    for(int i = 1;i<=sp->top+1;i++){
        printf("THE VALUE AT POSITION %d is  : %d\n",i,peek(sp, i));
    }
    printf("%d", stack_top(sp));
    printf("%d", stack_bottom(sp));
    return 0;

}
