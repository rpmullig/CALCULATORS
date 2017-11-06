/* Bit_Calculations.c
**
** Author: Robert Mulligan
** Date Created: 10/08/2014
** Last Modified by: Robert Mulligan
** Date Last Modified: 10/08/2014
*/

//any librarys that may appear
#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string.h>


//calling function
int main(){

  //input variable, operation
 int operation;

 //infinite loop, until broke by case 7
 while(1) {

   //calls a function that prints out the instructions
Main_Menu();

   //user input of the operation
  scanf("%d", &operation);

  //a case operation using the inputed operation and sends off to the functions
switch(operation) {
    case 1:
        leftBitShift();
        break;
    case 2:
        rightBitShift();
        break;
    case 3:
        andOperation();
        break;
    case 4:
        orOperation();
        break;
    case 5:
        onesComplement();
        break;
    case 6:
        XOROperation();
        break;
    case 7:
      return(0);//will end the program and end the loop
    default:
      printf("Error"); //garbage can to collect anything and end program
         return(0);
        }//end of switch

    }//end of while loop

}//end of main


//prints the main menu when called
int Main_Menu(void) {


 printf("\t\t\tMAIN MENU\n");
 printf("\t\t\t---------\n");
 printf("1. Perform Left Bit Shift Operation (one value)\n");
 printf("2. Perform Right Bit Shift Operation (one value)\n");
 printf("3. Perform Binary AND Operation (two values)\n");
 printf("4. Perform Binary OR Operation (two values)\n");
 printf("5. Perform Binary One's Complement (~) Operation (one value)\n");
 printf("6. Perform Binary XOR Operation (two values)\n");
 printf("7. Quit\n");

 return(0);
}

//shifts bits left
int leftBitShift(void){

  //variables for the "fore loop" and the input scanf and shift value
  int  input, shift;

//user input and instructions
printf("Enter a base 10 Integer: ");
scanf("%d", &input);
printf("\nEnter number of places to shift bit: ");
scanf("%d", &shift);
printf("\n");

//prints the original value
printf("Entered Integer: ");
 printBits(input);// a function called to showBits 
printf("(base 10 %d)\n",input);

//preforms a shift left on the input for the inputed shift amount
input = (input << shift);

//prints the shifted varialbe
printf("Left Shifted   : ");
 printBits(input);
printf("(base 10 %d)\n",input);


return(0);
}

//shifts bits right
 int rightBitShift(void){

   //variables for input
int input, shift;


printf("Enter a base 10 Integer: ");
scanf("%d", &input);
printf("\nEnter number of places to shift bit: ");
scanf("%d", &shift);

//prints input in bits
printf("\nEntered Integer: ");
 printBits(input);
printf("(base 10 %d)\n",input);

//shifts right on the input varialbe for the shift amount
input = (input >> shift);

//prints shifted amount
printf("Right Shifted  : ");
 printBits(input);
printf("(base 10 %d)\n",input);

return(0);
}

//preforms an AND operation on two binary numbers
int andOperation(void) {
    int input1, input2, answer;

    //takes in user inputs
printf("Enter two base 10 Integers, separated by a space: ");
scanf("%d %d", &input1, &input2);

//prints the varialbes
printf("\nEntered Integer 1: ");
 printBits(input1);
printf("(base 10 %d)\n",input1);


printf("Entered Integer 2: ");
 printBits(input2);
printf("(base 10 %d)\n",input2);

//AND operation on the inputs
answer = (input1 & input2);

//prints answer after the AND operation
printf("AND'ed           : ");
 printBits(answer);
printf("(base 10 %d)\n",answer);


return(0);
}

//preforms the OR operation on two bits
int orOperation(void) {

  //declares variables for input and output variable
    int input1, input2, answer;

    //takes in inputs
printf("Enter two base 10 Integers, separated by a space: ");
scanf("%d %d", &input1, &input2);

//prints the inputs in binary
printf("\nEntered Integer 1: ");
 printBits(input1);
printf("(base 10 %d)\n",input1);

printf("Entered Integer 2: ");
 printBits(input2);
printf("(base 10 %d)\n",input2);

//OR's the inputs and stores as an answer
answer = (input1 | input2);

//prints the answer result
printf("OR'ed            : ");
 printBits(answer);
printf("(base 10 %d)\n",answer);


return(0);
}

//flips the bits
int onesComplement(void){

  //takes in an input
int input;

//asks for user input
printf("Enter a base 10 Integer: ");
scanf("%d", &input);

//returns the number in binary
printf("\nEntered Integer: ");
 printBits(input);
printf("(base 10 %d)\n",input);

//flips bits
input = (~input);

//shows input in binary flipped bits
printf("~'ed           : ");
 printBits(input);
printf("(base 10 %d)\n",input);


return(0);
}

//XOR's two user inputs
int XOROperation() {

  //declares variables for input and output
  int  input1, input2, answer;

  //takes in two inputs
printf("Enter two base 10 Integers, separated by a space: ");
scanf("%d %d", &input1, &input2);

//prints inputs in binary
printf("\nEntered Integer 1: ");
 printBits(input1);
printf("(base 10 %d)",input1);

printf("\nEntered Integer 2: ");
 printBits(input2);
printf("(base 10 %d)\n",input2);

//XOR's the inputs
answer = (input1 ^ input2);

//prints result
printf("XOR'ed           : ");
 printBits(answer);
printf("(base 10 %d)",answer);



printf("\n");
return(0);
}

//prints the bits for given value
int printBits(int bits) {

  //variable 
  int i; 
  //goes through a loop and prints each bit by series of operation and shifting
  for(i=24; i>=0; i--) {
    printf("%d ",(bits&(1<<i)) >> i);
  }

  return(0);

}
