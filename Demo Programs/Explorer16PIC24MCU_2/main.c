/* 
 * File:   main.c
 *
 * Created on February 9, 2010, 10:53 AM
 */

#include <stdio.h>
#include <stdlib.h>
#include <p24Fxxxx.h>

//Check the config bits for debugging
_CONFIG1(
    WDTPS_PS32768 &      // Watchdog Timer Postscaler (1:32,768)
    FWPSA_PR128 &        // WDT Prescaler (Prescaler ratio of 1:128)
    WINDIS_ON &          // Watchdog Timer Window (Standard Watchdog
                         //   Timer enabled,(Windowed-mode is disabled))
    FWDTEN_OFF &         // Watchdog Timer Enable (Watchdog Timer is
                         //   disabled)
    ICS_PGx1 &           // Comm Channel Select (Emulator EMUC2/EMUD2
                         //   pins are shared with PGC2/PGD2)
    GWRP_OFF &           // General Code Segment Write Protect (Writes
                         //   to program memory are allowed)
    GCP_OFF &            // General Code Segment Code Protect (Code
                         //   protection is disabled)
    JTAGEN_OFF           // JTAG Port Enable (JTAG port is disabled)
);

_CONFIG2(
    POSCMOD_NONE &       // Primary Oscillator Select (Primary
                         //   oscillator disabled)
    I2C1SEL_PRI &        // I2C1 Pin Location Select (Use default
                         //   SCL1/SDA1 pins)
    IOL1WAY_ON &         // IOLOCK Protection (Once IOLOCK is set,
                         //   cannot be changed)
    OSCIOFNC_OFF &       // Primary Oscillator Output Function
                         //(OSC2/CLKO/RC15 functions as CLKO (FOSC/2))
    FCKSM_CSDCMD &       // Clock Switching and Monitor (Clock switching
                         //   and Fail-Safe Clock Monitor are disabled)
    FNOSC_FRC &          // Oscillator Select (Fast RC Oscillator (FRC))
    SOSCSEL_SOSC &       // Sec Oscillator Select (Default Secondary
                         //   Oscillator (SOSC))
    WUTSEL_LEG &         // Wake-up timer Select (Legacy Wake-up Timer)
    IESO_OFF             // Internal External Switch Over Mode (IESO
                         //   mode (Two-Speed Start-up) enabled)
);
/*
 * 
 */

//RA0 - RA10
//RA1 - RA7
//RA2 - RB8
//RA3 - RB9
//RA4 - RA9
//RA5 - RA8
//RA6 - RB12
//RA7 - RC6

void delay(void) {
    long i = 65535;
    while(i--)
        ;
}


int main(int argc, char** argv) {
    int ALEDsOn = 0x0780;
    int BLEDsOn = 0x1300;
    int CLEDsOn = 0x0040;

    TRISA = !ALEDsOn;
    TRISB = !BLEDsOn;
    TRISC = !CLEDsOn;
    
    // Setup PortA IOs as digital
    AD1PCFG = 0xffff;

    while(1) {
        LATA = !ALEDsOn;
        LATB = !BLEDsOn;
        LATC = !CLEDsOn;
        delay();
        LATA = ALEDsOn;
        LATB = BLEDsOn;
        LATC = CLEDsOn;
        delay();
    }
    return (EXIT_SUCCESS);
}
