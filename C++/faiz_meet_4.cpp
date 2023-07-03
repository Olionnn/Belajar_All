#include <stdio.h>
#include <conio.h>

int main() {
    char h=64, nama[5][4][22] ={
        "AC Milan", "Barcelona","Porto",
        "Monaco", "Liverpool", "Real Madrid",
        "CSK Moskow","PSG","Inter Milan",
        "Arsenal","Atletico Madrid","Ajax",
        "AS Roma","Manchester Unitid","Dortmund",
        "Valencia","Manchester City","Bayern Munich",
        "Napoli","Vilareal"
    };

    printf("Liga Champions : \n \n");
    for (int i=0; i<5; i++) {
        ++h;
        printf("Group %c \n",h);
        for(int w=0; w<4; w++) {
            printf("%d. %s \n",w+1, nama[i][w]);
        }
        printf("\n");
    }

    getch();

}
