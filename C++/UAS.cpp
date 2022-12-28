#include <iostream>
#include <cstdlib>
#include <ctime>
#include <string>

using namespace std;

void mpage() {
    
    cout << "-[] Anjai Slot Gacor []-" << "\n";
    cout << "==================" << "\n";
    cout << "----Menu Program----" << "\n";
    cout << "1. Bikin Akun" << "\n";
    cout << "2. Demo Games" << "\n";
    // cout << "3. " << "\n";
    cout << "\n";
}

void tambah(){
    int b;
    string a,konfirmasi;
    cout << "Masukan Nama Anda : ";
    cin >> a; // nama
    cout << "\n";
    do {
        cout << "Deposit UANG ANDA SEGERA  (MIN : Rp.10,000) : ";
        cin >> b; // uang
        cout << "\n";

            if (b<10000) {
                cout << "Uang Anda Tidak Melebihi Batas Minimal Deposit";
            } else {
                cout << "Dengan Atas Nama " << a << "Deposit Uang Sebesar " << b << "\n";         
            }
        

        cout <<"" << endl;
        cout <<"Atau ketik apa saja untuk keluar :";
        cin >> konfirmasi;
        cout << endl;
    }while(konfirmasi == "y" || konfirmasi == "Y");

    cout << a;
    cout << b;
} 

void daftar() {
    string nama;
    int deposit,uang,bid,sisa;

    cout << "Ikutilah Anjai Slot" << "\n" ;
    
    cout << "Masukan Nama Anda : ";
    // tambah(nama, deposit);
    cout << "Deposit UANG ANDA SEGERA  (MIN : Rp.10,000) : ";

    cout << nama;
    cout << deposit;
}



void produk(){

    // cout << "=====================================" << "\n";
    // cout << "[]\t Daftar Menu Barang \t[]" << "\n";
    // cout << "1. Pepsoden   \t  \t Rp. 4000" << "\n";
    // cout << "2. Rokok Surya     \t Rp. 12000" << "\n";
    // cout << "3. Nabati    \t   \t Rp. 1000" << "\n";
    // cout << "4. Susu Indomilk   \t Rp. 5000" << "\n";
    // cout << "5. Bang Bang  \t  \t Rp. 2000" << "\n";
    // cout << "6. Torabika Susu\t Rp. 1500" << "\n";
    // cout << "7. Tumulawak \t   \t Rp. 3000" << "\n";
    // cout << "8. Kopi Hitam \t  \t Rp. 2000" << "\n";
    // cout << "\n";

    
}

int main() {
    tambah();
}