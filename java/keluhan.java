
import java.util.Scanner;



public class keluhan {
    final static String ANSI_CLS = "\u001b[2J";
    final static String ANSI_HOME = "\u001b[H";
    static Scanner scan = new Scanner(System.in);
    static String[] mainMenuList = {"Kesalahan Syntax dan Kesulitan Pemahaman", "Permasalahan Tipe Data Dan Variable", "Aspek Penggunaan Logika dan Pengoptimalan Kode"};
    static String[] menuKSNLP = {"Kesalahan Sintaksis dalam Kode", "Kesulitan dalam Memahami Konsep Dasar Pemrograman", "Kesulitan dalam Memahami Penggunaan Package", "Kesalahan dalam Pemilihan Tipe Data"};
    static String[] menuPTDNV = {"Permasalahan Terkait Fungsi dan Variabel", "Persamaan antara Tipe Data If-Else dan Switch-Case", "Pertanyaan tentang Modul yang Kurang Jelas"};
    static String[] menuAPLNPK = {"Pertanyaan tentang Penggunaan Logika Informatika", "Pertanyaan tentang Penggunaan Logika Informatika"};
    static String[] jawaban = {"a", "b", "c", "d", "e", "f", "g"};
    static String[] pertanyaan5 = {"a", "b", "c", "d", "e", "f", "g"};
    static String[] pertanyaan6 = {"a", "b", "c", "d", "e", "f", "g"};

    static void mainMenu() {
        System.out.print(ANSI_CLS + ANSI_HOME);
        System.out.flush();
        System.out.println("----------------------------------------------------------------");
        System.out.println("---------------[ Halaman Kategori Permasalahan ]----------------");
        System.out.println("----------------------------------------------------------------");

        for(int i = 0; i < mainMenuList.length; i++){
            System.out.println(i+1 +"."+ mainMenuList[i]);
        }
    }

    static void menuSatu() {
        do {
            System.out.print(ANSI_CLS + ANSI_HOME);
            System.out.flush();
            System.out.println("----------------------------------------------------------------");
            System.out.println("---------[ Kesalahan Syntax dan Kesulitan Pemahaman ]-----------");
            System.out.println("----------------------------------------------------------------");
            int pilih1 = 0;
            for(int i = 0; i < menuKSNLP.length; i++){
                System.out.println(i+1 +"."+ menuKSNLP[i]);
            }
            System.out.print("Masukan Nomor Permasalahan : ");
            pilih1 = scan.nextInt();
            switch (pilih1) {
                case 1: halamanSatuA(); break;
                default: System.out.println("ASOD"); break;
            }

        } while(true);
    }

    static void menuDua() {
        do {
            System.out.println("----------------------------------------------------------------");
            System.out.println("------------[ Permasalahan Tipe Data Dan Variable ]-------------");
            System.out.println("----------------------------------------------------------------");
            for(int i = 0; i < menuPTDNV.length; i++){
            System.out.println(i+1 +"."+ menuPTDNV[i]);
        }
        } while(true);



    }
    static void halamanSatuB() {
        System.out.println("----------------------------------------------------------------");
        System.out.println("-----------------------Halaman Pertamana B----------------------");
        System.out.println("----------------------------------------------------------------");

        for(int i = 0; i < pertanyaan.length; i++){
            System.out.println(i+1 +"."+ pertanyaan[i]);
        }
    }
    
    static void halamanSatuC() {
        System.out.println("----------------------------------------------------------------");
        System.out.println("-----------------------Halaman Pertamana C----------------------");
        System.out.println("----------------------------------------------------------------");

        for(int i = 0; i < pertanyaan.length; i++){
            System.out.println(i+1 +"."+ pertanyaan[i]);
        }
    }


    // List Masalah
    //Syntax wilo, gedi cilik e huruf kan kerep eror e kan kdng i Ro looping
    //Pemahaman syntax, looping/perulangan, package ( ap itu package,fungsi package, ngaruh nda misal ada ato ngga nya package)
    //Banyak nya tipe data yg dapat memuat var berupa angka
    //Tipe data double dan float, apa yg membedalan
    //Fungsi serta dri variabel e
    //Ap persamaan terhadap tipe data if else dan switch case, serta kondisi apa saja yg memungkinkan menggunakan tipe data tsb, lebih efisien penggunaan if else atau switch case?
    // Penjelasan modul sih aku senk kureng i
    //Harus memerhatikan Huruf Yang awalan e kapital
    //banyakya tipe data
    //opo penggunaan logika informatika senk angel di nalar



    /**
     * @param args
     */
    public static void main(String[] args) {

        do {
            int pilih = 0;
            mainMenu();
            System.out.print("Masukan Nomor Halaman Yang Ingin Dituju : ");
            pilih = scan.nextInt();
            switch (pilih) { 
                case 1: menuSatu(); break;
                case 2: halamanSatuB(); break;
                case 3: halamanSatuC(); break;
                default: System.out.println("Halaman Tidak Ada"); break;
            } 
        } while (true);
    }
}