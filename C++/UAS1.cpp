#include <iostream>
#include <string>

using namespace std;


// database
struct produk {
    string nama;
    int no,harga,stock;
}lp[1000];

// struct keranjang{
//     int idbrg;
//     int bijis;
// }cart[1000];
int jproduk=0;

// kumpulan text
string  namatoko= "KOPRASI UHUY BERSAMA ",
        halaman1= "Kasir Koprasi",
        halaman2= "Daftar Stock Koprasi",
        halaman3= "Report Penghasilan Koprasi",
        isiulang= "Halaman Tambah Stock",
        tmbstk= "Halaman Tambah Stock Baru",
        hps= "Mau Menghapus Material?",
        tdkad= "Halaman Tidak ada",
        krnj= "Isi Keranjang",
        dngr=  "Peringatan!!!!\nToko Anda Masih Tidak Ada Stock\nSilahkan Isi Stock Prudok Dihalaman 2. "   
        ;

// penghitungan (prototype)
int gudbrng(int a, int b); // menambahkan ke gudang

int tmbhstock(int a,int b);

int addtcart(int a, int b, int c); // menambahkan ke keranjang

int krngstockbeli(int a, int b);

int rmdub(int size, int rj, int ri);


// meanpilkan data array
void arraystruck(int size) {
    if (jproduk != 0) {
        for (int i=0; i<size; i++) {
            cout << "Barang KE- " << lp[i].no << endl;
            cout << "Nama Product : " << lp[i].nama << endl;
            cout << "Harga Product : "<< lp[i].harga << endl;
            cout << "Sisa Stock : "<< lp[i].stock << endl;
            cout << endl;
        }
    }else {
        cout << dngr << endl;
    }
}


void mpage() {
    cout << "========================================" << endl;
    cout << "[]\t"<< namatoko <<"\t[]" << endl;
    cout << "========================================" << endl;
    cout << "[] Halaman Program Koprasi\t[]" << endl;
    cout << "[] 1. "<< halaman1 <<"\t[]" << endl;
    cout << "[] 2. "<< halaman2 <<"\t[]" << endl;
    cout << "[] 3. "<< halaman3 <<"\t[]" << endl;
    cout << "=========================================" << endl;
        if (jproduk == 0){
            cout << dngr << endl;
        }
            cout << jproduk << endl;

}




void kasir() {

    // keranjang tetap
        int idbrg[100];
        int bijis[100];
    int inv = 0;

    int pesan=0;
    // konfirmasi looping
    string confirm;

    cout << "============================================" << endl;
    cout << "   Selamat Datang Di Program "<< halaman1 << endl;
    cout << "============================================" << endl;
    cout << "Catatan : " << endl;
    cout << "============================================" << endl;

    // Menampilkan Barang Apa Saja Yang Dijual Dari Gudang
    arraystruck(jproduk);

    // Melakukan Looping Pembelian
     do{
        cout << krnj << " : " << inv << "\n";
        cout << "Mau Memesan Beberapa Barang?";
        cin >> pesan;
        cout << endl;

            // updating pesanan ke keranjang dengan validasi jika barang id sama
            for (int i=0; i<pesan; i++ ) {
                cout << "Barang Ke-" << 
                cout << "Mau Berbelanja Apa? :";
                cin >> nbrng[i+inv];
                cout << endl;


                cout << "Nama Produk :"<< lp[i].nama << endl;
                cout << "Berapa Biji Anda Mau beli : ";
                cin >> biji[i+inv];
                cout << endl; 

            }

        cout << "Apakah Mau Menambahkan Barang Lagi?";
        cin >> confirm;
        cout << endl;

        //menghitung cart yang sudah ditentukan /fiks
        inv = pesan + inv;
    }while (confirm == "y" || confirm == "Y");

        // find dublicate number
                cout <<  " inv" <<inv;

    // detail
    cout << "Jadi Barang Yang Anda Pilih Adalah" << endl;
        for (int i=0; i<inv; i++ ) {
            // validasi jika barang tidak dibeli
            if (idbrg[i] != 0) {
                cout << idbrg[i];
                cout << "Nama Produk :"<< lp[i].nama << endl;
                cout << "Berapa Biji Anda Mau beli : ";
                cout << bijis[i];
                cout << endl;
            }
        // arraystruck();
        }
    
    



}


void addstock() {
    string confirm;
    int addprk=0;
    do{
        cout << "Mau Memasukan Barang Berapa?";
        cin >> addprk;
        cout << endl;

        for (int i=0; i<addprk; i++){
            cout << "Barang Ke-" << i+1 << endl;
            lp[i].no = i+1;

            cout << "Masukan Nama Barang : ";
            cin >> lp[i+jproduk].nama;
            cout << endl; 

            cout << "Masukan Harga Barang : ";
            cin >> lp[i+jproduk].harga;
            cout << endl;  

            cout << "Masukan Stock Barang : ";
            cin >> lp[i+jproduk].stock;
            cout << endl;  
        }

        cout << "mau isi lagi?";
        cin >> confirm;
        cout << endl;
    gudbrng(addprk,jproduk);
    }while (confirm == "y" || confirm == "Y");
}

void shwstock(){
    arraystruck(jproduk);
}



void stock() {
    int page=0;
    cout << "============================================" << endl;
    cout << "Selamat Datang Di Program "<< halaman2 << endl;
    cout << "============================================" << endl;
    cout << "[] 1. Tambah Barang Baru\t[]" << endl;
    cout << "[] 2. Lihat Daftar Barang\t[]" << endl;
    // cout << "[] 3. Hapus Stock Yang Tidak Diproduksi lagi\t[]" << endl;

    cout << "Pilih Tujuan Anda : ";
    cin >> page;
    cout << endl;

    switch (page)
    {
    case 1: addstock(); break;
    case 2: shwstock(); break;
    // case 3: isiulng(); break;
    
    default: cout << tdkad;   break;
    }
}





int main() {
    int page;
    string confirm;
    do {
        mpage();
         
        cout << "Pilih Tujuan Anda";
        cin >> page;
        cout << endl;

        switch (page) {

            case 1: kasir(); break;
            case 2: stock(); break;
            // case 3: report(); break;
            
            default: cout << tdkad << endl; break;
        }

        cout << "kembali ke menu?";
        cin >> confirm;
        
    }while(confirm == "y");

    
}





// penghitungan
int krngstockbeli(int a, int b) {
    
//     return trx;
}

int gudbrng(int a,int b) {
    cout << a;
    jproduk = a + b;
    return jproduk;
}

// int rmdub(int size, int rj, int ri,int inv) {
//     for(int i=0; i<size; i++) {
//         for (int a=i+1; a<inv; a++) {
//             if (idbrg[i] == idbrg[a]) {
//                 bijis[i] = bijis[i] + bijis[i];
//                 while (i<inv) {
//                     idbrg[a] = idbrg[a+1];
//                     a++;
//                 }
//                 --i;
//             } else {
//                 continue;
//             }
//         }
//     }
// }