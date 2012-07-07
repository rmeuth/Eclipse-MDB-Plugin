/*
 * File:   main.c
 *
 * Created on August 16, 2010, 12:09 PM
 */


#include <htc.h>

//#if defined(WDTE_OFF)
//__CONFIG(WDTE_OFF & LVP_OFF);
//#elif defined (WDTDIS)
//__CONFIG(WDTDIS & LVPDIS);
//#endif

int delay() {
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

int main(void) {
    int result = 0;
    TRISB = 0;
    while (1)
    {
        PORTB = 0x0F;
        delay();
        PORTB = 0x00;
        delay();
        result = doMath();
    }
    return 0;
}
