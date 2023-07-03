#include <iostream>
#include <stdio.h>
#include <conio.h>
using namespace std;

    struct TNode{
        int data;
        TNode *next;
    };
    TNode *head, *tail;

    void init(){ 
        head = NULL; 
        tail = NULL;
    }

    int isEmpty(){
        if(tail == NULL) return 1; 
        else return 0;
    }

    void tmbDepan(int a) {
        TNode *baru;
        baru = new TNode;
        baru->data = a;
        baru->next = NULL;

        if (isEmpty() == 1) {  
            head=tail=baru;
            tail->next = NULL;
        } else {
            baru->next = head;
            head = baru;
        }
        printf("Data Depan Masuk\n");
    }

    void tmbBlkg(int a) {
        TNode *baru;
        baru = new TNode;
        baru->data = a;
        baru->next = NULL;

        if (isEmpty() == 1) {  
            head=baru;
            tail=baru;
            tail->next = NULL;
        } else {
            tail->next = head;
            tail = baru;
        }
        printf("Data Belakang Masuk\n");
    }

    void hpsDepan(){
        TNode *hapus;
        int d;
        if (isEmpty()==0) {
            if (head != tail) {
                hapus = head;
                d= hapus->data;
                head = head->next;
                delete hapus;
            }else {
                d = tail->data;
                head = tail = NULL;
            }
            printf("%d Data Depan Terhapus\n ",d);
        } else {
            cout <<"Data Masih Kosong \n";
        }  
    }

    void hpsBlkg(){
        TNode *bantu, *hapus;
        int d;
        if (isEmpty()==0) {
            bantu = head;
            if (head != tail) {
                while (bantu->next != tail) {
                    bantu = bantu-> next;
                    break;
                }
                hapus = tail;
                tail = bantu;
                d= hapus->data;
                delete hapus;
                tail->next= NULL;
            }else {
                d = tail->data;
                head = tail = NULL;
            }
            cout << d << " "<<("Data Belakang Terhapus\n ");
        } else {
            cout <<"Data Masih Kosong \n";
        }  
    }
    
    void clear() {
        TNode *bantu,*hapus; 
        bantu = head; 
        while(bantu!=NULL) {
            hapus = bantu; bantu =  bantu->next; 
            delete hapus;
        }
        head = NULL; tail = NULL;
    }

int main () {
    int a = 12;
    int b = 20;
    while (true)
    {
        tmbDepan(a);
        tmbBlkg(b);
        hpsBlkg();
        hpsDepan();
        break;
    }
    
    return 0;
}