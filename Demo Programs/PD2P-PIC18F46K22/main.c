/*
 * File:   main.c
 *
 * Created on August 16, 2010, 12:09 PM
 */


//#include <htc.h>
#include <p18f46k22.h>

#pragma config FOSC = INTIO67

int delay();
int doMath();

int delay()
{
    int counter = 0;
    int clock = 0;
    for (counter = 0; counter < 10000; counter++) {
        clock++;
    }
    return clock;
}

int doMath()
{
    int a = 1;
    int b = 2;
    int c = 3;
    int result = 0;
    result = a + b * c;
    return result;
}

void main(void)
{
    int result = 0;
    TRISB = 0;
    PORTB = 0x00;
    while (1)
    {
        PORTB = 0x0F;
        delay();
        PORTB = 0x00;
        delay();
        result = doMath();
    }
}
