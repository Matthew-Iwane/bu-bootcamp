#include <stdio.h>

/* Takes the addresses of the two variables, so it reads and writes
   the caller's memory directly. The exchange is visible in main. */
void swap(int *a, int *b) {
    int temp = *a;
    *a = *b;
    *b = temp;
}

/* Takes the values, so a and b are copies made when the function is
   called. Swapping them rearranges only these local copies, which are
   discarded on return. main's variables never change, because the
   function received copies, not addresses. */
void broken_swap(int a, int b) {
    int temp = a;
    a = b;
    b = temp;
}

int main(void) {
    int x = 10;
    int y = 20;

    printf("Before swap: x = %d, y = %d\n", x, y);
    swap(&x, &y);
    printf("After swap:  x = %d, y = %d\n", x, y);

    int p = 10;
    int q = 20;

    printf("\nBefore broken_swap: p = %d, q = %d\n", p, q);
    broken_swap(p, q);
    printf("After broken_swap:  p = %d, q = %d\n", p, q);

    return 0;
}