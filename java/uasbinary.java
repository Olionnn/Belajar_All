package uas.java;

// iki dicopy ngisor e pakage
import java.util.Scanner;

/**
 * 1. hapus kabeh seng public class seng pakage karo autor ditokne
 * 
 */

 // iki kabeh dicopy
class Node {
    String data;
    Node left, right;

    Node(String item) {
        data = item;
        left = null;
        right = null;
    }
}

class SilsilahKeluarga {
    private Node root;

    public SilsilahKeluarga() {
        root = null;
    }

    void tambah(String induk, String anak, String hubungan) {
        if (root == null) {
            root = new Node(induk);
            System.out.println("Induk Utama : " + induk);
        }

        Node nodeBaru = new Node(anak);
        if (hubungan.equals("kiri")) {
            Node indukNode = cariNode(root, induk);
            if (indukNode != null) {
                if (indukNode.left == null) {
                    indukNode.left = nodeBaru;
                    System.out.println(anak + " Adalah Anak Kiri Dari " + induk );
                } else {
                    System.out.println("Anak Kiri Dari " + induk + " Sudah Ada");
                }
            } else {
                System.out.println(induk + " Tidak Ditemukan Dalam Silsilah Keluarga");
            } 
        } else if (hubungan.equals("kanan")) {
            Node indukNode = cariNode(root, induk);
            if (indukNode != null) {
                if (indukNode.right == null) {
                    indukNode.right = nodeBaru;
                    System.out.println(anak + " Adalah Anak Kanan Dari " + induk );
                } else {
                    System.out.println("Anak Kanan Dari " + induk + " Sudah Ada");
                }
            } else {
                System.out.println(induk + " Tidak Ditemukan Dalam Silsilah Keluarga");
            } 
        } else {
            System.out.println("Hubungan Tidak Valid");
        }
    }

    public void tampilkanSilsilahKeluarga() {
        System.out.println("Silsilah Keluarga : ");
        tampilkanNode(root, 0);
    }

    private Node cariNode(Node nodeSkrg, String item) {
        if (nodeSkrg == null) {
            return null;
        }

        if (nodeSkrg.data.equals(item)) {
            return nodeSkrg;
        }

        Node hasilKiri = cariNode(nodeSkrg.left, item);
        if (hasilKiri != null) {
            return hasilKiri;
        }

        Node hasilKanan = cariNode(nodeSkrg.right, item);
        if (hasilKanan != null) {
            return hasilKanan;
        }

        return null;
    }


    public void tampilkanNode(Node nodeSkrg, int level){
        if (nodeSkrg == null) {
            return;
        }

        tampilkanNode(nodeSkrg.right, level + 1);

        for (int i = 0; i < level; i++) {
            System.out.print("    ");
                      
        }
        System.out.println(nodeSkrg.data);

        tampilkanNode(nodeSkrg.left, level+1);
    }
}
// uasbinary iki dihanti karo jeneng file mu contone BinaryTree kemau gede cilik e podo
public class uasbinary {
   public static void main(String[] args) {
    SilsilahKeluarga silsilah = new SilsilahKeluarga();
    int pilihan;
    String induk, anak, hubungan;

    Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Menu Silsilah Keluarga:");
            System.out.println("1. Tambah anggota keluarga");
            System.out.println("2. Tampilkan silsilah keluarga");
            System.out.println("3. Keluar");
            System.out.print("Masukkan pilihan Anda: ");
            pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan nama induk: ");
                    induk = scanner.next();
                    System.out.print("Masukkan nama anak: ");
                    anak = scanner.next();
                    System.out.print("Masukkan hubungan (kiri/kanan): ");
                    hubungan = scanner.next();
                    silsilah.tambah(induk, anak, hubungan);
                    break;
                case 2:
                    silsilah.tampilkanSilsilahKeluarga();
                    break;
                case 3:
                    System.out.println("Terimakasih!!");
                    break;
                default:
                    System.out.println("Pilihan tidak Ada");
            }

            System.out.println();
        } while (pilihan != 3);
    }
}
