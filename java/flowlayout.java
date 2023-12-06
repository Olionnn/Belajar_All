import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class flowlayout {
    public static void main(String[] args) {
        // Membuat jendela utama
        JFrame frame = new JFrame("Contoh FlowLayout");
        // JTextArea textArea = new JTextArea();
        JTextArea textArea = new JTextArea(2, 20);
        textArea.setEditable(false);

        // Mengatur operasi standar saat jendela ditutup
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Membuat panel
        JPanel panel = new JPanel();
        panel.add(textArea);
        
        // Hubungkan FlowLayout Ke Panel 
        panel.setLayout(new FlowLayout());

        for (int i = 1; i <= 10; i++) {
            JButton button = new JButton("Tombol " + i);
            panel.add(button);
            final int nomer = i; 
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    textArea.setText(Integer.toString(nomer));
                }
            });

            panel.add(button);
        }


        // Menambahkan panel ke dalam jendela
        frame.add(panel);

        // Mengatur ukuran jendela
        frame.setSize(300, 300);

        // Menampilkan jendela
        frame.setVisible(true);
    }
}
