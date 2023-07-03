#include <iostream>
#include <string>
#define MAX_STACK 10

using namespace std;

struct Stack {
    int top;
    string data[MAX_STACK];
};

Stack piringBersih;
Stack piringKotor;

void init() {
    piringBersih.top = -1;
    piringKotor.top = -1;
}

int isEmpty(Stack stack) {
    return stack.top == -1;
}

int isFull(Stack stack) {
    return stack.top == MAX_STACK - 1;
}

void DataPiringBersih() {
    for (int i = 0; i < 5; i++) {
        piringBersih.data[i] = "Piring Bersih " + to_string(i + 1);
        piringBersih.top++;
    }
}


void push(Stack& stack) {
    if (!isFull(stack)) {
        string piring;
        cout << "Masukkan Piring: ";
        cin.ignore();
        getline(cin, piring);
        stack.data[++stack.top] = piring;
        cout << endl;
    }
    else {
        cout << "Tumpukan penuh!" << endl;
    }
}

void pop(Stack& stack1, Stack& stack2) {
    if (!isEmpty(stack1)) {
        string toppiring = stack1.data[stack1.top];
        stack1.top--;
        if (!isFull(stack2)) {
            stack2.data[++stack2.top] = toppiring;
            cout << "Piring " << toppiring << " dipindahkan ke tumpukan piring kotor." << endl;
        }
        else {
            cout << "Tumpukan piring kotor penuh!" << endl;
        }
    }
    else {
        cout << "Tumpukan piring bersih kosong!" << endl;
    }
}

void clear(Stack& stack) {
    if (!isEmpty(stack)) {
        stack.top = -1;
        cout << "Tumpukan telah dikosongkan" << endl;
    }
    else {
        cout << "Tumpukan sudah kosong" << endl;
    }
}

void display(Stack stack, string namaStack) {
    if (!isEmpty(stack)) {
        cout << "Isi " << namaStack << ": " << endl;
        for (int i = 0; i <= stack.top; i++) {
            cout << stack.data[i] << endl;
        }
    }
    else {
        cout << namaStack << " kosong" << endl;
    }

    if (isFull(stack)) {
        cout << namaStack << " penuh" << endl;
    }
}


int main() {
    int pilih;
    init();
    DataPiringBersih();

    do {
        system("cls");
        cout << "Stock Piring Bersih Dan Kotor" << endl;
        display(piringBersih, "Piring Bersih");
        cout << endl;
        display(piringKotor, "Piring Kotor");
        cout << endl;
        cout << "Menu: " << endl;
        cout << "1. Masukkan piring bersih" << endl;
        cout << "2. Masukkan piring kotor" << endl;
        cout << "3. Ambil piring bersih" << endl;
        cout << "4. Ambil piring kotor" << endl;
        cout << "5. Clear tumpukan piring bersih" << endl;
        cout << "6. Clear tumpukan piring kotor" << endl;
        cout << "7. Keluar" << endl;
        cout << "Pilihan: ";
        cin >> pilih;

        switch (pilih) {
        case 1:
            push(piringBersih);
            break;
        case 2:
            push(piringKotor);
            break;
        case 3:
            pop(piringBersih, piringKotor);
            break;
        case 4:
            pop(piringKotor, piringBersih);
            break;
        case 5:
            clear(piringBersih);
            break;
        case 6:
            clear(piringKotor);
            break;
        case 7:
            cout << "Terima kasih!" << endl;
            return 0;
        default:
            cout << "Pilihan tidak ada!" << endl;
            break;
        }
    } while (true);
}
