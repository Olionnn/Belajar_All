#include <iostream>
using namespace std;

void mpage() {
    cout << "=======================================================" << endl;
    cout << "===|               Melengkapi Tugas 2              |===" << endl;
    cout << "===|   Ardiansyah Al Cahya Maulana (2255201056)    |===" << endl;
    cout << "===|                   Ilkom 1B                    |===" << endl;
    cout << "=======================================================" << endl;

    cout << "1. Program Tugas Praktikum Masalah 1" << endl; 
    cout << "2. Program Tugas Rumah Tugas 1" << endl; 
    cout << endl;
}

void praktikumm1() {
    string namakasir, namapembeli, labletoko = "TOKO BERKAH SEJAHTERA";
    float totalpembelian, diskon = 0;

    while(true) {
        cout << "=================================================" << endl;
        cout << "===| SELAMAT DATANG DI " << labletoko << " |===" << endl;
        cout << "=================================================" << endl;
        cout << endl;

        cout << "Masukan Nama Pembeli : ";
        cin >> namapembeli;
        cout << endl;
        

        cout << "Masukan Jumlah Pembelian Pembeli : ";
        cin >> totalpembelian;
        cout << endl; 

        cout << "Nama Operator Kasir : ";
        cin >> namakasir;
        cout << endl;

        cout << "=================================================" << endl;
        cout << "Total Harga Pembelian : Rp." << totalpembelian  << endl;
        if(totalpembelian > 100000, diskon = 30) {
            cout << "Dapat Potongan Diskon Sebesar : "<< diskon << "%" << endl; 
            cout << "Harga Keseluruhan : Rp." << totalpembelian - (totalpembelian * diskon / 100) << endl;

        }  else if (totalpembelian >= 75000 && totalpembelian <= 100000, diskon = 20) {
            cout << "Dapat Potongan Diskon Sebesar : "<< diskon << "%" << endl; 
            cout << "Harga Keseluruhan : Rp." << totalpembelian - (totalpembelian * diskon / 100) << endl;

        }  else if (totalpembelian < 75000, diskon = 10){
            cout << "Dapat Potongan Diskon Sebesar : "<< diskon << "%" << endl; 
            cout << "Harga Keseluruhan : Rp." << totalpembelian - (totalpembelian * diskon / 100) << endl;

        }

        cout << "===================================================================" << endl;
        cout << "[] Nama Pembeli : " << namapembeli << "                                            []" << endl; 
        cout << "[] Nama Kasir : " << namakasir << "                                              []" << endl; 
        cout << "===================================================================" << endl;
        cout << "[] Terima Kasih Telah Berbelanja Di " << labletoko << "        []" << endl; 
        cout << "===================================================================" << endl;

    }
}

void tugas1() {
    
    while(true) {
        string k1 = "\"Maaf, Anda belum dapat diluluskan. Tingkatkan terus belajar Anda.\"", 
            k2 = "\"Anda lulus, tingkatkan lagi pencapaian Anda.\"",
            k3 = "\"Anda lulus dengan baik, tingkatkan terus prestasi Anda.\"", 
            k4 = "\"Selamat! Anda lulus dengan nilai yang EXCELLENT!\"",
            k5 = "Nilai Anda : ";
        float nilaim, nilait, nilaiu, nilaia;
        
        cout << "======================================================" << endl;
        cout << "===| Penilaian Akhir Mahasiswa Teknik Elektro UM  |===" << endl;
        cout << "======================================================" << endl;
        cout << endl;

        cout << "Masukan Nilai Murni Keaktivan : ";
        cin >> nilaim;
        nilaim = nilaim * 20 / 100;
        cout << endl;

        cout << "Masukan Nilai Murni Tugas : ";
        cin >> nilait;
        nilait = nilait * 30 / 100;
        cout << endl;

        cout << "Masukan Nilai Ujian : ";
        cin >> nilaiu;
        nilaiu = nilaiu * 50 / 100;
        cout << endl;

        nilaia = nilaiu + nilait + nilaim;
        cout << "Hasil Nilai Akhirnya Adalah : " << nilaia << endl;
        cout << endl;

        if (nilaia > 100) {
            cout << "Nilai Tidak Valid" << endl;
        } else if (nilaia >= 91 && nilaia <= 100) {
            cout << k5 <<"A" << endl;
        } else if (nilaia <= 90 && nilaia >= 86) {
            cout << k5 << "A-" << endl;
        } else if (nilaia <= 85 && nilaia >= 81) {
            cout << k5 << "B+" << endl;
        } else if (nilaia <= 80 && nilaia >= 76) {
            cout << k5 << "B" << endl;
        } else if (nilaia <= 75 && nilaia >= 66) {
            cout << k5 << "B-" << endl;
        } else if (nilaia <= 65 && nilaia >= 56) {
            cout << k5 << "C" << endl;
        } else if (nilaia <= 55 && nilaia >= 45) {
            cout << k5 << "D" << endl;
        } else if (nilaia <= 44 && nilaia >= 0) {
            cout << k5 << "E" << endl;
        } 

        if (nilaia >= 86 && nilaia <= 100) {
            cout << k4 << endl;
        } else if (nilaia >= 66 && nilaia <= 85) {
            cout << k3 << endl;
        } else if (nilaia >= 56 && nilaia <= 65) {
            cout << k2 << endl;
        } else if (nilaia >= 0 && nilaia <= 55) {
            cout << k1 << endl;
        }   
    }   

}

int main(){
    string pg[5];

    mpage();
    int pilih;
    string konfirm;
    
    cout << "Halaman Mana Yang Ingin Dituju : ";
    cin >> pilih;
    cout << endl;
    
    switch (pilih) {
        case 1: praktikumm1(); break;
        case 2: tugas1(); break;

    default:
        cout << "Halaman tidak ada" << endl;
    }

}


