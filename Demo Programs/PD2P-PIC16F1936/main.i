#line 1 "main.c"
#line 1 "main.c"

#line 5 "main.c"
 










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
