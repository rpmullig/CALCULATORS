/* 
**
** This program does 3 functions that mimic
** output given to me by assignment details
**
** Arrays - a function that returns intersection
** and union of 2 arrays given user input for size
** array elements
**
** Matrices - transverse a 2D array/ matrix
**
** calculator - a calculator program with user input
**
** Author: Robert Mulligan
** Date Created: 9/24/2014
** Last Modified by: Robert Mulligan
** Date Last Modified: 9/24/2014

*/

# include <stdio.h>

int main(){

arrays();

    int a[] = {1, 0, 0, 0, 0 };
    int b[] = {0, 2, 0, 0, 0 };
    int c[] = {0, 0, 3, 0, 0 };
    int d[] = {0, 0, 0, 4, 0 };

matrices(a,b,c,d );

calculator();

return(0);
}

int arrays(void){

int size;

printf("Enter the size of the arrays:\n");
scanf("%d", &size);

while(size < 0){
    printf("\nPlease enter a valid, positive size:\n");
    scanf("%d", &size);
}

int arrayA[size], arrayB[size];

//Variables for the for loops to iterate through
int i,j;

printf("\n\nEnter the %d elements in the first array:\n", size);
for(i = 0; i < size; i++){
    scanf("%d", &arrayA[i]);
}

printf("\n\nEnter the %d elements in the second array:\n", size);
for(i = 0; i < size; i++){
    scanf("%d", &arrayB[i]);
}

//I call a helping function sort for easier organizing
sort(arrayA, size);
sort(arrayB, size);


printf("The intersection of two arrays is: ");

int temp;
for(i = 0; i < size; i++){
    for(j = 0; j < size; j++) {
        if(arrayA[i] == arrayB[j] && arrayA[i] != temp) {
            printf("%d",arrayA[i]);
            temp = arrayA[i];
        }
    }
}

printf("\nThe union of the two arrays is: ");

// --- Come back ---

int double_size = (2 * size);
int tempA[double_size];

for(i = 0; i < size; i++) {
    tempA[i] = arrayA[i];
}

for(j = 0; j < size; j++) {
    tempA[(size+j)] = arrayB[j];
}

sort(tempA, double_size );

for(i = 0; i < double_size; i++){
   if(tempA[i] < tempA[i+1]){
        printf("%d", tempA[i]);
   }
}


// also create my own contains function
/*
for(i =0; i < size; i++){
    for(j = 0; j < size; j++ ){
    if(arrayA[i] < arrayB[j]) {
        printf("%d",arrayA[i]);
        i++;
        if(arrayB[i] < arrayA[j]){
            printf("%d", arrayB[j]);
            j++;
        }
    }
    }
}
    */



return(0);
}

int matrices(int a[], int b[], int c[], int d[]){

int original[4][5],row,column;
for(row = 0;  row < 4; row++){
    for(column = 0; column < 5;   column++){
     //!!!! VERY IMPORTANT TO DO n-1 FOR CASES WITH 0-index
        switch(row) {
    case 0: //!! THIS IS 0-INDEX
        original[row][column] = a[column]; break;
    case 1:
        original[row][column] = b[column]; break;
    case 2:
        original[row][column] = c[column]; break;
    case 3:
        original[row][column] = d[column]; break;
    default: break;
        }
    }
}


printf("\n\n\n\nThe original matrix was:\n");

for(row = 0;  row < 4; row++){
    printf("\n");
    for(column = 0; column < 5;   column++){
    printf("%d  ", original[row][column]);
    }
}

printf("\n\nThe transposed matrix is:");


for(row = 0;  row < 5; row++){
    printf("\n");
    for(column = 0; column < 4;   column++){
    printf("%d  ", original[column][row]);
    }
}


return(0);

}


int calculator (void) {
printf("\n\n\nBegin Calculations\n\n");
printf("Initialize your Accumulator with data of the form");
printf(" \"number\" \"S\" \nwhich sets the Accumulator to the value of your number\n");

int  total, current;
char  math;

while(1){
printf("\n");
scanf("%d %c", &current, &math);

        switch(math) {
case 'S':
    total = current;
    printf("Value in the Accumulator = %d", current);
    break;

case '+':
    total =  total + current;
    printf("Value in the Accumulator = %d", total);
    break;

case '-':
    total = total - current;
    printf("Value in the Accumulator = %d", total);
    break;

case '/':
    if( current == 0){
            printf("Cannot divide by 0.\n");
            printf("Value in the Accumulator = %d", total);
            break;}
   else{ total = total / current; }
    printf("Value in the Accumulator = %d", total);
    break;

case '*':
    total = total * current;
    printf("Value in the Accumulator = %d", total);
    break;

case 'E':
    printf("Value in the Accumulator = %d", total);
    printf("\nEnd of Calculations.");
    return(0);

default:
    printf("Unkown operator\n");
    printf("Value in the Accumulator = %d", total);
    break;
        }
    }
}


//Make sure to not that URI!!!
// idea from: http://www.geeksforgeeks.org/union-and-intersection-of-two-sorted-arrays-2/
void sort(int arr[], int size)
{
    int i, j, temp, swap;

    for (i = 1; i < size; i++)
    {
        swap = 0;
        for (j = 0; j < size-i; j++)
        {
            if (arr[j] > arr[j+1])
            {
                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
                swap = 1;
            }
        }
        if (swap == 0)
        {
            break;
        }
    }
}
