#include <iostream>
#include <string>
using namespace std;

struct Node {
    string data;
    Node* left;
    Node* right;

    Node(string item) {
        data = item;
        left = nullptr;
        right = nullptr;
    }
};

class SilsilahKeluarga {
    private:
        Node* root;

    public:
        SilsilahKeluarga() {
            root = nullptr;
        }

    void tambah(string induk, string anak, string hubungan) {
        if (root == nullptr) {
            root = new Node(induk);
            cout << "Induk Utama: " << induk << endl;
        }

        Node* nodeBr = new Node(anak);
        if (hubungan == "kiri") {
            Node* indukNode = cariNode(root, induk);
            if (indukNode != nullptr) {
                if (indukNode->left == nullptr) {
                    indukNode->left = nodeBr;
                    cout << anak << " adalah anak kiri dari " << induk << endl;
                } else {
                    cout << "Anak kiri dari " << induk << " sudah ada" << endl;
                }
            } else {
                cout << induk << " tidak ditemukan dalam silsilah keluarga" << endl;
            }
        } else if (hubungan == "kanan") {
            Node* indukNode = cariNode(root, induk);
            if (indukNode != nullptr) {
                if (indukNode->right == nullptr) {
                    indukNode->right = nodeBr;
                    cout << anak << " adalah anak kanan dari " << induk << endl;
                } else {
                    cout << "Anak kanan dari " << induk << " sudah ada" << endl;
                }
            } else {
                cout << induk << " tidak ditemukan dalam silsilah keluarga" << endl;
            }
        } else {
            cout << "Hubungan tidak valid" << endl;
        }
    }

        void tampilkanSilsilahKeluarga() {
            cout << "Silsilah Keluarga:" << endl;
            tampilkanNode(root, 0);
        }

    private:
        Node* cariNode(Node* nodeSkrg, string item) {
            if (nodeSkrg == nullptr) {
                return nullptr;
            }

            if (nodeSkrg->data == item) {
                return nodeSkrg;
            }

            Node* hasilKiri = cariNode(nodeSkrg->left, item);
            if (hasilKiri != nullptr) {
                return hasilKiri;
            }

            Node* hasilKanan = cariNode(nodeSkrg->right, item);
            if (hasilKanan != nullptr) {
                return hasilKanan;
            }

            return nullptr;
        }

    void tampilkanNode(Node* nodeSkrg, int level) {
        if (nodeSkrg == nullptr) {
            return;
        }

        tampilkanNode(nodeSkrg->right, level + 1);

        for (int i = 0; i < level; i++) {
            cout << "    ";
        }
        cout << nodeSkrg->data << endl;

        tampilkanNode(nodeSkrg->left, level + 1);
    }
};

int main() {
    SilsilahKeluarga silsilah;
    int pilihan;
    string induk, anak, hubungan;

    do {
        cout << "Menu Silsilah Keluarga:" << endl;
        cout << "1. Tambah anggota keluarga" << endl;
        cout << "2. Tampilkan silsilah keluarga" << endl;
        cout << "3. Keluar" << endl;
        cout << "Masukkan pilihan Anda: ";
        cin >> pilihan;

        switch (pilihan) {
            case 1:
                cout << "Masukkan nama induk: ";
                cin >> induk;
                cout << "Masukkan nama anak: ";
                cin >> anak;
                cout << "Masukkan hubungan (kiri/kanan): ";
                cin >> hubungan;
                silsilah.tambah(induk, anak, hubungan);
                break;
            case 2:
                silsilah.tampilkanSilsilahKeluarga();
                break;
            case 3:
                cout << "Terimakasih!!" << endl;
                break;
            default:
                cout << "Pilihan tidak Ada" << endl;
        }

        cout << endl;
    } while (pilihan != 3);

    return 0;
}
