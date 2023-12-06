import javax.swing.*;
import java.awt.*;

public class borderlayout {
    public static void main(String[] args) {
        // Membuat jendela utama
        JFrame frame = new JFrame("Contoh BorderLayout");

        // Mengatur operasi standar saat jendela ditutup
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Membuat tombol untuk masing-masing wilayah BorderLayout
        JButton buttonNorth = new JButton("Utara");
        JButton buttonSouth = new JButton("Selatan");
        JButton buttonWest = new JButton("Barat");
        JButton buttonEast = new JButton("Timur");
        JButton buttonCenter = new JButton("Tengah");

        // Mengatur tata letak BorderLayout pada jendela
        frame.setLayout(new BorderLayout());

        // Menambahkan tombol ke wilayah-wilayah BorderLayout
        frame.add(buttonNorth, BorderLayout.NORTH);
        frame.add(buttonSouth, BorderLayout.SOUTH);
        frame.add(buttonWest, BorderLayout.WEST);
        frame.add(buttonEast, BorderLayout.EAST);
        frame.add(buttonCenter, BorderLayout.CENTER);

        // Mengatur ukuran jendela
        frame.setSize(400, 300);

        // Menampilkan jendela
        frame.setVisible(true);
    }
}
