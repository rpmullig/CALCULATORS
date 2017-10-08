/*Filename: Harmonic.c *
*Created by: Robert Mulligan*
*Created on: 9/11/2014 *
*Last Modified by: Robert Mulligan *
*Last Modified on: 9/11/2014 *
*/

/*   This program uses a number to create a harmonic series
**   The program catches any negative numbers
 */ 

/*  adds the library  */
#include <stdio.h>

/*  will look for an int return and adds no parameters  */
int main() { 

/*  declares the number which will be inputed in the scanf  */
  int  number;

/*  inputs the variable for the harmnoic series and outputs user instruction  */
  printf("Enter a value to calculate the value of this harmonic series: \n");
  scanf("%d", &number);

/* an if statement to catch the negative numbers  */
  if(number < 0 ) { 
    printf("Please enter a POSITIVE number: \n");
    scanf("%d", &number);
  }

/* declares the variables for the for loop   */
  float sum, i, series;
  sum = 0;

/* a for loop  that goes until the number */
  for( i = 1; i < number; i++ ) {
  
/*  adds the numbers together  */
    series = (1/i);
    sum = sum + series;

  }

/* outputs the return of the for loop  */
  printf(" The value for the series is: %f \n", sum);
  return(0);

}
