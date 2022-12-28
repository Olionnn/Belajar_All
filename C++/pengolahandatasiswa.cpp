#include <iostream>
#include <string>

using namespace std;


// data siswa
string siswa[13] = {"Kevin Jonatan","Jordi Albino","Dwi Erlanga","Daniel Mustofa","Ian Ramadhan","Riski Juniawan","Muhammad Kristian","Indri Leamord","Agus Mendo"
,"Angga Puspita","Joni","Ardi","Fitri"};
int kelas[13] = {6,6,6,6,6,6,6,6,6,6,6,6,6};
int agama[13],mtk[13],pkn[13],bhsig[13],bhsind[13];
int size = sizeof(kelas) / sizeof(int);
float rt[13];
string rank[13];


int disnilai() {
    for (int i=0; i<size; i++){
        cout << "Nama Siswa : " << siswa[i] << endl;
        cout << "Kelas : " << kelas[i] << endl;
        cout << "============================" << endl;
        cout << "Agama\tMatematika\tPKN\tBahasa Inggris\tBahasa Indonesia\tRata-Rata" << endl;        
        cout << agama[i]<<"\t"<<mtk[i]<<"\t\t"<<pkn[i]<<"\t\t"<<bhsig[i]<<"\t\t"<<bhsind[i]<<"\t\t"<<rt[i]<<"\t\t"<<endl;
    
    }
}

void hlm() {
    cout << "1. Daftar Siswa" << endl;
    cout << "2. Halaman Nilai" << endl;
    cout << "3. Laporan Hasil" << endl;
}

void dftsiswa(){
    // array Data siswa
    for (int i=0; i<size; i++){
        cout << "============================" << endl;
        cout << "NO :" << i+1<<endl;
        cout << "Nama Siswa : "<< siswa[i]<< endl;
        cout << "Kelas : " << kelas[i]<< endl;
    }
}

void inptnsiswa() {
    int jum[13];

    for (int i=0; i<size; i++) {
        cout << "NO :" << i+1<<endl;
        cout << "Nama Siswa : "<< siswa[i]<< endl;
        cout << "=====================================" << endl;
        cout << "Masukan Nilai Agama : ";
        cin >> agama[i];
        cout << endl;        
        cout << "Masukan Nilai mtk : ";
        cin >> mtk[i];
        cout << endl;        
        cout << "Masukan Nilai pkn : ";
        cin >> pkn[i];
        cout << endl;        
        cout << "Masukan Nilai bahasa inggris : ";
        cin >> bhsig[i];
        cout << endl;        
        cout << "Masukan Nilai bahasa indonesia : ";
        cin >> bhsind[i];
        cout << endl;

        
        jum[i] = agama[i]+mtk[i]+pkn[i]+bhsig[i]+bhsind[i];
        rt[i] = jum[i] / 5;

    }
    disnilai();
}






int main() {
int pilih=0;
string konfirm;

    do {
        hlm();

        cout << "pilih Halaman Tujuan";
        cin >>pilih;
        cout << endl;

        switch (pilih)
        {
        case 1: dftsiswa();  break;
        case 2: inptnsiswa();  break;
        case 3: disnilai(); break;
        
        default: cout << "Halaman Yang Anda Tuju Tidak Ada";
            break;
        }

        cout << "Kembali Ke Menu Awal ? Tekan Y";
        cin >>konfirm;
        cout << endl;
    }while (konfirm == "y" || konfirm == "y");
}

