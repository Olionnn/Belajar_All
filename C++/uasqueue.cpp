#include <iostream>
#include <string>
#define MAX_Q 10
using namespace std;

struct Queue {
   string data[MAX_Q];
   int head;
   int tail;
};
Queue antrian;

void create() {
    antrian.head= antrian.tail = -1;
}

int isEmpty() {
    if (antrian.tail == -1){
        return 1;
    } else {
        return 0;
    }
}

int isFull() {
    if (antrian.tail == MAX_Q-1){
        return 1;
    } else {
        return 0;
    }
}

void Enqueue(string data) {
    if(isEmpty()==1){
        antrian.head=antrian.tail=0;
        antrian.data[antrian.tail]=data;
        cout << "Antrian Masuk" << antrian.data[antrian.tail];
    } else if(isFull()==0){
            antrian.tail++;
            antrian.data[antrian.tail]=data;
            cout << "Antrian Masuk" << antrian.data[antrian.tail];
    }
}

string Dequeue() {
    int i;
    string e = antrian.data[antrian.head];
    for(i=antrian.head; i<=antrian.tail-1; i++){
        antrian.data[i] = antrian.data[i+1];
    }
    antrian.tail--;
    return e;
}

void Clear(){
    antrian.head=antrian.tail=0;
    cout << "Antrian Sudah Dihapus Semua" << endl;
}
void inQueue(){
    if (!isEmpty()) {
        cout << "Dalam Antrian : " << endl;
        for (int i = 0; i < antrian.tail; i++) {
            cout << i+1 << " " << antrian.data[i+1] << endl;
        }
    }else {
        cout << "Antrian Kosong" << endl;
    }

    if(isFull()) {
        cout << "Antrian Sedang Penuh" << endl;
    }
}

void tmbQueue(){
    string antri;
    cout << "Nama Pesanan : ";
    cin.ignore();
    getline(cin, antri);
    Enqueue(antri);
    cout<<"Antrian ditambah"<< endl;
}

int main(){ 
    int hall=0;
    do {
        system("cls");
        cout << "Dapur Masak Pesanan Makan" << endl;
        inQueue();
        cout << endl;
        cout << "Menu: 1.Tambah Antrian, 2.Antrian Sudah Selesai, 3.Hapus Semua Antrian 4. Mengakhiri Program : ";
        cin >> hall;   
        switch (hall)  {
            case 1: tmbQueue(); break;
            case 2: Dequeue();  break;
            case 3: Clear(); break;
            case 4: cout << "Terima Kasih!" << endl; return 0;
            default: cout << "null" << endl; break;
        }
    }
    while (true);
}
