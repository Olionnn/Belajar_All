#include <iostream>
#include <stdio.h>
#include <conio.h>
using namespace std;

  struct TNode{
    int data;
    TNode *next;
    };
    TNode *head;

    void init(){
        head = NULL;
    }

    int isEmpty(){
        if (head == NULL){
            return 1;
        } else {
            return 0;
        }
    }

    // menambah node di depan
    void tmbDepan(int nwdata) {
        TNode *baru;
        baru = new TNode;
        baru->data = nwdata;
        baru->next = NULL;

        if (isEmpty()==1) {  
            head=baru;
            head->next = NULL;
        } else {
            baru->next = head;
            head = baru;
        }
        printf("Data Depan Masuk\n");
    }
    // menambah node dibelakang
    void tmbBlkg(int nwdata) {
        TNode *baru, *bantu;
        baru = new TNode;
        baru->data = nwdata;
        baru->next = NULL;

        if (isEmpty()==1) {
            head=baru;
            head->next = NULL;
        } else {
            bantu = head;
            while (bantu->next=NULL)
            {
                bantu = bantu->next;
            }
            bantu->next = baru;
        }
        printf("Data Belakang Masuk \n");
    }

    //Menghapus Node di Depan
    void hpsDepan(){
        TNode *hapus;
        int d;
        if (isEmpty()==0)
        {
            if (head->next != NULL)
            {
                hapus = head;
                d= hapus->data;
                head = head->next;
                delete hapus;
            }else {
                d = head->data;
                head = NULL;
            }
            printf("%d Data Depan Terhapus\n ",d);
        } else {
            cout <<"Data Masih Kosong \n";
        }  
    }

    //Menghapus Node di Belakang
    void hpsBlkg(){
        TNode *hapus, *bantu;
        int d;
        if (isEmpty()==0) {
            
            if (head->next != NULL) {
                bantu = head;
                while (bantu->next->next != NULL) {
                    bantu= bantu->next;
                    break;
                }

                hapus = bantu->next;
                d = hapus->data;
                delete hapus;
            }else {
                d = head->data;
                head = NULL;
            }
            printf("%d Data Belakang Terhapus \n ",d);
        } else {
            cout <<"Data Masih Kosong \n";
        }  
    }
    // menghapus semua elemen
    void clear(){
        TNode *bantu,*hapus; 
        bantu = head; 
        while(bantu != NULL) {
            hapus = bantu; 
            bantu = bantu->next; 
            delete hapus;
            break;
        }
        head = NULL;
        printf("Semua Data Terhapus \n");
    }

    void tampil(){ 
        TNode *bantu; 
        bantu = head; 
        if(isEmpty()==0) {
            while(bantu!=NULL){ 
            cout << bantu->data <<" "; 
            bantu=bantu->next;
            }
            printf("\n");
        } else {
            printf("Masih kosong\n");
        } 
    }

int main() {
    int a = 22;
    int b = 43;
    while (true)
    {
        tmbDepan(a);     
        tmbBlkg(b);     
        tampil();       
        hpsBlkg();     
        hpsDepan();     
        clear();        
        tampil();       
        break;
    }
    
    return 0;
}



