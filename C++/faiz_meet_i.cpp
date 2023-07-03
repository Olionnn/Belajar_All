#include <iostream> 
#include <conio.h> 
#include <string.h> 
#include <stdio.h> 

using namespace std;

int main() {
    char nama[50] = "Logika Algoritma"; 
    char kosong[50] = "";
    system("cls");

    cout << "jumlah karakter dari nama adalah " << strlen(nama) << endl; 
    cout << "jumlah karakter dari kosong adalah " << strlen(kosong) << endl;

    getch();
}

void cobastrcpy() {

    char nama[50] = "Logika Algoritma"; 
    char kosong[50] = "";
    system("cls");

    cout << "jumlah karakter dari nama adalah " << strlen(nama) << endl; 
    cout << "jumlah karakter dari kosong adalah " << strlen(kosong) << endl;

    getch();
}

void cobastrct() {
    char string1 [] ="Belajar";
    char string2 [] ="Logika Algortima"; 

    cout<<"Menggabungkan String"<<endl; 
    cout<<" --------------------"<<endl;
    cout<<"string1 : "<<string1<<endl; 
    cout<<"string2 : "<<string2<<endl; 

    strcat(string1, string2);

    cout<<"\nSetelah digabung, string1 sekarang menjadi:"<< string1<<endl;
    getche(); 
}
void cobastrcmp() {

    char sa[]="Logika";
    char sb[]="Logika Algoritma";
    char sc[]="Logika Algoritma & Pemprograman";

    printf("Nilai Yang dibandingkan sa,sb : %d\n",strcmp(sa,sb)); 
    printf("Nilai Yang dibandingkan sa,sc : %d\n",strcmp(sa,sc)); 
    printf("Nilai Yang dibandingkan sb,sa : %d\n",strcmp(sb,sa)); 

    getch();
}

void cobastrlen() {

    char nama[50] = "Logika Algoritma"; 
    char kosong[50] = "";
    system("cls");

    cout << "jumlah karakter dari nama adalah " << strlen(nama) << endl; 
    cout << "jumlah karakter dari kosong adalah " << strlen(kosong) << endl;

    getch();
}

void cobastrchr(void) {
    char str [100]="Aisyah Zahra"; 
    char karakter='Z';
    char *hasil; 

    hasil=strchr(str,karakter); 

    printf("Hasil Peubah :%s\n",hasil);
    printf("Karakter %c ditemukan pada indeks ke-%d",karakter,(hasil-str));
    getch(); 

}

void dimensi() {
    int bil [5]; 
    system("cls");

    cout<<"Masukkan 5 bilangan genap : "<<endl; 

    for (int i = 0; i < 5; i++) { 
        cout<<"Bilangan "; 
        cout<< i + 1 <<" : "; 
        cin>> bil[i]; 
        cout<<endl;
    }

    cout<<endl;

    cout<<"5 bilangan genap yang dimasukkan " <<endl;

    for (int i = 0; i < 5; i++)
    cout<<" "<<bil[i]; 

    getch();

}

void duadimensi() {
    int a[3][5];
    for (int i=0;i<3;i++) {
        for (int j=0;j<5;j++) {
            printf("%x ",&a[j][i]);
        }
        printf("\n");
    }
    getch();
}