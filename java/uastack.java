package uas.java;

// iki dicopy ngisor e pakage
import java.util.Scanner;

/**
 * 1. hapus kabeh seng public class seng pakage karo autor ditokne
 * 
 */

 // iki kabeh dicopy
class Stack {
    int top;
    String[] data;

    public Stack() {
        top = -1;
        data = new String[10];
    }
}

// uastack iki dihanti karo jeneng file mu contone BinaryTree kemau gede cilik e podo
public class uastack { 
    static Stack piringBersih;
    static Stack piringKotor;

    public static void init() {
        piringBersih = new Stack();
        piringKotor = new Stack();
    }

    public static boolean isEmpty(Stack stack) {
        return stack.top == -1;
    }

    public static boolean isFull(Stack stack) {
        return stack.top == 9;
    }

    public static void DataPiringBersih() {
        for (int i = 0; i < 5; i++) {
            piringBersih.data[i] = "Piring Bersih " + (i + 1);
            piringBersih.top++;
        }
    }

    public static void Push(Stack stack) {
        if (!isFull(stack)) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Masukkan Piring : ");
            String piring = scanner.nextLine();
            stack.data[++stack.top] = piring;
            System.out.println();
        } else {
            System.out.println("Tumpukan Penuh!");
        }
    }

    public static void Pop(Stack stack1, Stack stack2) {
        if (!isEmpty(stack1)) {
            String topPiring = stack1.data[stack1.top];
            stack1.top--;
            if (!isFull(stack2)) {
                stack2.data[++stack2.top] = topPiring;
                System.out.println("Piring " + topPiring + " dipindahkan ke tumpukan piring kotor.");
            } else {
                System.out.println("Tumpukan piring kotor penuh!");
            }
        } else {
            System.out.println("Tumpukan piring bersih kosong!");
        }
    }

    public static void Clear(Stack stack) {
        if (!isEmpty(stack)) {
            stack.top = -1;
            System.out.println("Tumpukan telah dikosongkan!");
        } else {
            System.out.println("Tumpukan sudah kosong!");
        }
    }


    public static void Display(Stack stack, String namaStack) {
        if (!isEmpty(stack)) {
            System.out.println("Isi " + namaStack + ": ");
            for (int i = 0; i <= stack.top; i++) {
                System.out.println(stack.data[i]);
            }
        } else {
            System.out.println(namaStack + " Kosong");
        }

        if (isFull(stack)) {
            System.out.println(namaStack + " Penuh");
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pilih;
        init();
        DataPiringBersih();

        do {
            System.out.println("Stock Piring Bersih Dan Kotor");
            Display(piringBersih, "Piring Bersih");
            System.out.println();
            Display(piringKotor, "Piring Kotor");
            System.out.println();
            System.out.println("Menu :");
            System.out.println("1. Masukkan piring bersih");
            System.out.println("2. Masukkan piring kotor");
            System.out.println("3. Ambil piring bersih");
            System.out.println("4. Ambil piring kotor");
            System.out.println("5. Clear tumpukan piring bersih");
            System.out.println("6. Clear tumpukan piring kotor");
            System.out.println("7. Keluar");
            System.out.print("Pilihan:");
            pilih = scanner.nextInt();

            switch (pilih) {
                case 1:
                    Push(piringBersih);
                    break;
                case 2:
                    Push(piringKotor);
                    break;
                case 3:
                    Pop(piringBersih, piringKotor);
                    break;
                case 4:
                    Pop(piringKotor, piringBersih);
                    break;
                case 5:
                    Clear(piringBersih);
                    break;
                case 6:
                    Clear(piringKotor);
                    break;
                case 7:
                    System.out.println("Terima kasih!");
                    return;
                default:
                    System.out.println("Pilihan tidak ada!");
                    break;
            }
        } while (true);
    }
}
