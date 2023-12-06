import javax.swing.*;
import java.awt.*;

public class gridlayout {


    public static void main(String[] args) {
        JFrame frame = new JFrame("Contoh GridLayout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(3, 1)); 


        // Membuat Text Angka
        for (int i = 1; i <= 9; i++) {

            JTextArea textAreaJ = new JTextArea("NOMOR KE : " + i);
            JTextArea spasi = new JTextArea("\t");

            frame.add(textAreaJ);
            frame.add(spasi);
        }

        frame.pack(); // Menyesuaikan ukuran jendela dengan kontennya
        frame.setVisible(true);
    }


    




}
