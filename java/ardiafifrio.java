import java.util.Thread;
import java.util.Random;
import java.util.Scanner;



/*
 * Tugas Program Java
 * Nama Kelompok :
 * - Rio Prasetyo Ashari (2255201058)
 * - M. Rodjil Afif (2255201027)
 * - Ardiansyah (2255201056)
 * 
 */

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


public class keluhan {
    final static String ANSI_CLS = "\u001b[2J";
    final static String ANSI_HOME = "\u001b[H";
    static Scanner scan = new Scanner(System.in);

    static String[] mainMenuList = {
        "Kesalahan Syntax dan Kesulitan Pemahaman", 
        "Permasalahan Tipe Data Dan Variable"

    };
    static String[] menuKSNLP = {
        "Kesalahan Sintaksis dalam Kode", 
        "Kesulitan dalam Memahami Konsep Dasar Pemrograman", 
        "Kesulitan dalam Memahami Penggunaan Package", 
        "Kesalahan dalam Pemilihan Tipe Data"
    };
    static String[] menuPTDNV = {
        "Permasalahan Terkait Fungsi dan Variabel", 
        "Persamaan antara Tipe Data If-Else dan Switch-Case", 
        "Pertanyaan tentang Modul yang Kurang Jelas"
    };
    static String[] jawabanKSNLP1 = {
        "Solusi yang paling sederhana adalah memeriksa kode secara cermat untuk memastikan bahwa semua tanda baca dan karakter khusus digunakan dengan benar dan tidak ada kesalahan penulisan yang mencolok.", 
        "Pastikan bahwa setiap kurung kurawal dan kurung siku dibuka dan ditutup dengan benar. Jika Anda memiliki blok kode, pastikan bahwa setiap kurung kurawal terbuka dan ditutup dengan benar. Kesalahan seperti kurung kurawal yang tidak seimbang atau tertutup tidak akan menghasilkan kesalahan kompilasi.",
        "Tanda titik koma digunakan untuk mengakhiri pernyataan dalam Java. Pastikan bahwa setiap pernyataan diakhiri dengan tanda titik koma. Kesalahan umum adalah penghilangan tanda titik koma atau penempatan yang salah. Ini dapat menyebabkan kesalahan sintaksis.",
        "Pastikan bahwa nama variabel, kelas, dan metode ditulis dengan benar sesuai dengan aturan Java. Nama-nama ini harus dimulai dengan huruf, dapat mengandung huruf, angka, dan garis bawah, serta harus mematuhi konvensi penamaan Java. Kesalahan penulisan nama dapat menyebabkan kesalahan sintaksis.",
        "Menyusun struktur kode dengan baik merupakan salah satu aspek penting dalam pengembangan perangkat lunak. Struktur yang baik akan memudahkan pengembang dalam memahami dan mengelola kode program. Beberapa langkah yang dapat diambil untuk menyusun struktur kode dengan baik antara lain adalah menggunakan indentasi yang konsisten, memberikan nama variabel dan fungsi yang jelas dan deskriptif, mengelompokkan kode ke dalam modul atau kelas yang terorganisir, serta menghindari penggunaan kode yang berlebihan atau redundan.", 
        "Sering Berlatih Dan Membaca Dokumentasi Atau Melihat Tutorial Dari Platfrom Yang Ada", 
    };
    static String[] jawabanKSNLP2 = {
        "Cobalah untuk memahami konsep dasar pemrograman dalam bahasa Java terlebih dahulu, termasuk sintaksis dasar, variabel, tipe data, struktur kontrol, dan perulangan.",
        "Pilih Integrated Development Environment (IDE) yang nyaman untuk digunakan. IDE seperti Eclipse, IntelliJ IDEA, atau NetBeans dilengkapi dengan fitur-fitur yang membantu dalam mengeksekusi, men-debug, dan memahami kode Java dengan lebih baik.",
        "Luangkan waktu untuk memahami sintaksis dasar Java, termasuk cara mendeklarasikan variabel, membuat kelas, dan menggunakan pernyataan if, while, dan for.",
        "Praktek adalah kunci untuk memahami konsep pemrograman. Cobalah menulis kode Java sederhana untuk mengaplikasikan konsep yang Anda pelajari.",
        "Java adalah bahasa pemrograman berorientasi objek. Memahami konsep dasar OOP seperti kelas, objek, pewarisan, dan enkapsulasi adalah penting."
    };
    static String[] jawabanKSNLP3 = {
        "Praktikkan konsep package dalam proyek-proyek kecil. Buat beberapa package, definisikan kelas-kelas di dalamnya, dan pelajari bagaimana mengimpor kelas antara package. Praktek akan memperkuat pemahaman Anda.",
        "Package membantu dalam mengorganisasi kode Anda menjadi unit yang lebih terkelola. Kelas-kelas yang terkait sebaiknya ditempatkan dalam package yang sesuai. Package dalam Java memiliki struktur hirarki seperti direktori di sistem file. Ini memungkinkan Anda untuk menyusun package dalam subpackage dan memahami hubungan antara mereka.",
        "Untuk mengakses kelas dari package lain, Anda perlu menggunakan pernyataan import. Ini memungkinkan Anda mengimpor kelas dari package lain ke dalam kode Anda. Nama package harus mengikuti konvensi penamaan Java. Biasanya, nama package diawali dengan huruf kecil. Hindari penggunaan huruf besar atau karakter khusus. Java menyediakan package bawaan seperti java.util, java.io, dan banyak lagi. Pelajari penggunaan package bawaan ini untuk mengakses berbagai kelas dan fungsi bawaan Java."
    };
    static String[] jawabanKSNLP4 = {
        "Mulailah dengan memahami tipe data dasar dalam Java seperti int, double, char, dan boolean. Ketahui rentang nilainya dan penggunaan yang tepat.",
        "Pastikan Anda menggunakan tipe data yang sesuai dengan data yang akan Anda simpan. Misalnya, gunakan int untuk bilangan bulat, double untuk bilangan desimal, dan char untuk karakter.",
        "Hindari menggunakan tipe data seperti long atau double jika Anda tahu bahwa data Anda tidak akan mencapai rentang yang diperlukan. Menggunakan tipe data yang lebih besar dapat memboroskan memori.",
        "Pilih tipe data yang tepat untuk representasi data Anda. Misalnya, gunakan String untuk teks, Date untuk tanggal, atau enum untuk jenis data tertentu."
    };


    static String[] jawabanPTDNV1 = {
        "Pastikan Anda memberikan nama yang jelas dan deskriptif untuk variabel dan fungsi Anda. Ini akan memudahkan pemahaman kode Anda oleh Anda dan orang lain yang membaca kode tersebut. Jika variabel dan fungsi diberi nama dengan baik, Anda akan lebih mudah melacak dan memahami bagaimana data disimpan dan diproses dalam program Anda.",
        "Memahami konsep ruang lingkup variabel dan fungsi sangat penting. Pastikan Anda menggunakan variabel di tempat yang tepat dan menghindari konflik nama dengan variabel yang ada di ruang lingkup yang berbeda. Juga, pastikan Anda memahami apakah variabel lokal atau variabel instance dan apakah fungsi dapat diakses dari tempat yang diperlukan dalam kode Anda.",
        "Jika Anda menghadapi masalah terkait fungsi dan variabel, manfaatkan alat debugging yang disediakan oleh Integrated Development Environment (IDE) Anda. Debugger memungkinkan Anda melacak eksekusi program langkah demi langkah, memeriksa nilai variabel, dan memahami bagaimana fungsi bekerja. Dengan debugging, Anda dapat mengidentifikasi dan memecahkan masalah yang berkaitan dengan variabel atau fungsi dalam kode Anda."
    };
    static String[] jawabanPTDNV2 = {
        "Untuk menghindari kesalahan pemilihan tipe data antara if-else dan switch-case, Anda perlu memahami perbedaan antara keduanya. If-else digunakan untuk kondisi yang lebih kompleks yang memerlukan evaluasi ekspresi boolean (benar atau salah), sedangkan switch-case cocok untuk membandingkan nilai yang sama dengan beberapa opsi yang mungkin. Jika Anda tidak yakin mana yang harus digunakan, pelajari perbedaannya terlebih dahulu.",
        "Jika Anda memiliki beberapa kondisi yang kompleks atau tidak dapat diwakili dengan baik oleh switch-case, maka lebih baik menggunakan if-else. If-else memberi Anda fleksibilitas untuk mengevaluasi ekspresi boolean yang rumit, sedangkan switch-case hanya cocok untuk perbandingan nilai tunggal.",
        "Jika Anda memiliki serangkaian perbandingan yang seragam, misalnya, memeriksa nilai variabel yang sama terhadap beberapa opsi yang berbeda, maka switch-case adalah pilihan yang lebih baik. Ini membuat kode lebih mudah dibaca dan memahami."
    };
    static String[] jawabanPTDNV3 = {
        "Jika Anda merasa ada bagian dari modul yang tidak jelas, jangan ragu untuk bertanya. Anda bisa mengajukan pertanyaan kepada instruktur, teman sekelas, atau melalui forum pembelajaran online. Tidak ada pertanyaan yang bodoh, dan banyak orang mungkin memiliki pertanyaan yang sama dengan Anda. Meminta klarifikasi adalah langkah penting dalam pemahaman materi.",
        "Cari sumber tambahan yang dapat membantu menjelaskan konsep atau topik yang tidak jelas. Ini bisa berupa buku teks alternatif, tutorial online, video pembelajaran, atau artikel yang lebih rinci. Berbeda sumber bisa memberikan sudut pandang yang berbeda dan membantu Anda memahami dengan cara yang lebih baik.",
        "Diskusikan materi dengan rekan sekelas atau teman belajar. Seringkali, berbicara dengan orang lain dapat membantu Anda memproses informasi dengan lebih baik. Anda dapat saling bertukar pemahaman dan mencari solusi bersama-sama."
    };


    static String jawabanDriPty(int hall, int mslh) {
        Random random = new Random();
    
        if (hall == 1) {
            if (mslh == 1) {
                return jawabanKSNLP1[random.nextInt(jawabanKSNLP1.length)];
            } else if (mslh == 2) {
                return jawabanKSNLP2[random.nextInt(jawabanKSNLP2.length)];
            } else if (mslh == 3) {
                return jawabanKSNLP3[random.nextInt(jawabanKSNLP3.length)];
            } else if (mslh == 4) {
                return jawabanKSNLP4[random.nextInt(jawabanKSNLP4.length)];
            } else {
                return "Masalah Tidak Ditemukan";
            }
        } else if (mslh == 2) {
            if (mslh == 1) {
                return jawabanPTDNV1[random.nextInt(jawabanPTDNV1.length)];
            } else if (mslh == 2) {
                return jawabanPTDNV2[random.nextInt(jawabanPTDNV2.length)];
            } else if (mslh == 3) {
                return jawabanPTDNV3[random.nextInt(jawabanPTDNV3.length)];
            } else {
                return "Masalah Tidak Ditemukan";
            }
        } else {
            return "Kategori Tidak Ditemukan Tidak Ditemukan";
        }

    }

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
            System.out.println("Ketik (99) Untuk Kemenu Awal");
            System.out.print("Masukan Nomor Permasalahan : ");
            pilih1 = scan.nextInt();

            if(pilih1 == 99) {
                break;
            } else {
                System.out.println("Solusi : " + jawabanDriPty(1, pilih1));
                System.out.println("Tekan Enter Untuk Lanjut...");
                scan.nextLine();
                scan.nextLine();
            }

            

            // switch (pilih1) {
            //     // case 1: halamanSatuB(); break;
            //     case 1: jawabanDriPty(1,1); break;
            //     case 2: jawabanDriPty(1,2); break;
            //     case 3: jawabanDriPty(1,3); break;
            //     case 4: jawabanDriPty(); break;
            //     default: System.out.println("ASOD"); break;
            // }

        } while(true);
    }

    static void menuDua() {
        do {
            System.out.print(ANSI_CLS + ANSI_HOME);
            System.out.flush();
            System.out.println("----------------------------------------------------------------");
            System.out.println("------------[ Permasalahan Tipe Data Dan Variable ]-------------");
            System.out.println("----------------------------------------------------------------");

            int pilih1 = 0;
            for(int i = 0; i < menuPTDNV.length; i++){
                System.out.println(i+1 +"."+ menuPTDNV[i]);
            }

            System.out.println("Ketik (99) Untuk Kemenu Awal : ");
            System.out.print("Masukan Nomor Permasalahan : ");
            pilih1 = scan.nextInt();
            if(pilih1 == 99) {
                break;
            } else {
                System.out.println("Solusi : " + jawabanDriPty( 2, pilih1));
                System.out.println("Tekan Enter Untuk Lanjut...");
                scan.nextLine();
                scan.nextLine();
            }




        } while(true);
    }


    /**
     * @param args
     */
    public static void main(String[] args) {

        do {
            int pilih = 0;
            mainMenu();
            System.out.println("Ketik 0 Untuk Mengakhiri Program" );
            System.out.print("Masukan Nomor Halaman Yang Ingin Dituju : ");
            pilih = scan.nextInt();
            if (pilih == 0 ){
                System.out.println("Program Berakhir...");
                break;
            } else {
                switch (pilih) { 
                    case 1: menuSatu(); break;
                    case 2: menuDua(); break;
                    default: System.out.println("Halaman Tidak Ada"); break;
                } 
            }

        } while (true);

    }
}