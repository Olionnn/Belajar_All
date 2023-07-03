package uas.java;

// iki dicopy ngisor e pakage
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 1. hapus kabeh seng public class seng pakage karo autor ditokne
 * 
 */

 // iki kabeh dicopy
 // uasqueue iki dihanti karo jeneng file mu contone BinaryTree kemau gede cilik e podo
public class uasqueue {
    static Queue<String> antrian = new LinkedList<>();

    public static void main(String[] args) {
        int hall = 0;
        do {
            System.out.println("Dapur Masak Pesanan Makan");
            inQueue();
            System.out.println();
            System.out.print("Menu: 1.Tambah Antrian, 2.Antrian Sudah Selesai, 3.Hapus Semua Antrian, 4. Mengakhiri Program: ");
            Scanner scanner = new Scanner(System.in);
            hall = scanner.nextInt();

            switch (hall) {
                case 1:
                    tmbQueue();
                    break;
                case 2:
                    Dequeue();
                    break;
                case 3:
                    Clear();
                    break;
                case 4:
                    System.out.println("Terima Kasih!");
                    return;
                default:
                    System.out.println("Pilihan tidak valid!");
                    break;
            }
        } while (true);        
    }

    public static void inQueue() {
        if (!antrian.isEmpty()) {
            System.out.println("Dalam antrian : ");
            int i = 1;
            for (String pesanan : antrian) {
                System.out.println(i + " " + pesanan);
                i++;
            }
        } else {
            System.out.println("Antrian Kosong");
        }

        if (antrian.size() >= 10) {
            System.out.println("Antrian Sedang Penuh");
        }
    }

    public static void tmbQueue() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nama Pesanan : ");
        String antri = scanner.nextLine();
        if (antrian.size() < 10) {
            antrian.offer(antri);
            System.out.println("Antrian ditambah");
        } else {
            System.out.println("Antrian sudah penuh! Tidak dapat menambahkan pesanan.");
        }
    }

    public static void Dequeue() {
        if (!antrian.isEmpty()) {
            String pesanan = antrian.poll();
            System.out.println("Pesanan " + pesanan + " selesai");
        } else {
            System.out.println("Antrian kosong! Tidak ada pesanan yang selesai.");
        }
    }

    public static void Clear() {
        if (!antrian.isEmpty()) {
            antrian.clear();
            System.out.println("Semua antrian telah dihapus");
        } else {
            System.out.println("Antrian sudah kosong");
        }
    }
    
}
