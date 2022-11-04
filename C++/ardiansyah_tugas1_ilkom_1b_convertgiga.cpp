#include <iostream>

using namespace std;

void mainmenu() {
    cout << "______________________________________________________________" << endl;
    cout << "[] Konversi Penyimpanan Digital []" << endl;
    cout << "______________________________________________________________" << endl;
    cout << "1. KB Dikonversi ke MB dan GB" << endl; 
    cout << "2. MB Dikonversi ke KB dan GB" << endl; 
    cout << "3. GB Dikonversi ke KB dan MB" << endl; 
    cout << endl; 
}

void konversikb() {
    cout << "______________________________________________________________" << endl;
    cout << "[] Konversi KB (kilobyte) ke MB (megabyte) dan GB (gigabyte) []" << endl;
    cout << "______________________________________________________________" << endl;
    cout << endl;

    long double kb;
    long double mb;
    long double gb;

    cout << "Masukan Berapa KB Yang Anda Mau : ";
    cin >> kb;
    cout << endl;

    mb = kb / 1024;
    gb = kb / (1024 * 1024);


    cout << kb << "KB =" << mb <<" MB" << endl;
    cout << kb << "KB =" << gb <<" GB" << endl;


}

void konversimb() {
    cout << "______________________________________________________________" << endl;
    cout << "[] Konversi MB (megabyte) ke KB (kilobyte) dan GB (gigabyte) []" << endl;
    cout << "______________________________________________________________" << endl;
    cout << endl;

    long double kb;
    long double mb;
    long double gb;

    cout << "Masukan Berapa MB Yang Anda Mau : ";
    cin >> mb;
    cout << endl;

    kb = mb * 1024;
    gb = mb / 1024;


    cout << mb << "MB =" << kb <<" KB" << endl;
    cout << mb << "MB =" << gb <<" GB" << endl;

}

void konversigb() {
    cout << "______________________________________________________________" << endl;
    cout << "[] Konversi GB (gigabyte) ke KB (kilobyte) dan MB (megabyte)  []" << endl;
    cout << "______________________________________________________________" << endl;
    cout << endl;

    long double kb;
    long double mb;
    long double gb;

    cout << "Masukan Berapa GB Yang Anda Mau : "; 
    cin >> gb;
    cout << endl;

    mb = gb * 1024;
    kb = gb * (1024 * 1024);

    cout << gb << "GB =" << kb <<" KB" << endl;
    cout << gb << "GB =" << mb <<" MB" << endl;

}


int main() {
    string st[20];

    mainmenu();
    int pilihan;
    string konfirmasi;

    do {
        cout << "Mau Konversi Mana Yang DiinginKan? ";
        cin >> pilihan;
        cout << endl;

        switch (pilihan) {

        case 1: konversikb(); break;
        case 2: konversimb(); break;
        case 3: konversigb(); break;
        
        default: 
            cout << "pilihan tidak ada" << endl;
         break;
        }

        cout <<"Ketik y atau Y untuk Lanjut" << endl;
        cout <<"Atau ketik apa saja untuk keluar :";
        cin >> konfirmasi;
        cout << endl;
        
            
    }while (konfirmasi == "y" || konfirmasi == "Y");
    return 0;
}