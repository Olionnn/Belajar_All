import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

// Membuat Class Anggota Kelompok
class Kelompok {
    private String nama;

    public Kelompok(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    @Override
    public String toString() {
        return nama;
    }
}

// Membuat Kelas utama Anggota Kelompok
class AnggotaKelompok extends JFrame {

    private List<Kelompok> anggotaList;
    private DefaultListModel<Kelompok> listModel;
    private JList<Kelompok> kelompokJList;
    private JTextField namaField;

    public AnggotaKelompok() {
        super("Anggota Kelompok 5");

        anggotaList = new ArrayList<>();
        listModel = new DefaultListModel<>();
        kelompokJList = new JList<>(listModel);

        namaField = new JTextField(20);
        JButton tambahButton = new JButton("Tambah");
        JButton editButton = new JButton("Edit");
        JButton hapusButton = new JButton("Hapus");

        // Menambahkan anggota kelompok baru
        tambahButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nama = namaField.getText();
                Kelompok kelompok = new Kelompok(nama);
                anggotaList.add(kelompok);
                listModel.addElement(kelompok);
                namaField.setText("");
            }
        });

        // Mengedit anggota kelompok yang dipilih
        editButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = kelompokJList.getSelectedIndex();
                if (selectedIndex != -1) {
                    String namaBaru = namaField.getText();
                    Kelompok kelompok = anggotaList.get(selectedIndex);
                    kelompok.setNama(namaBaru);
                    listModel.set(selectedIndex, kelompok);
                    namaField.setText("");
                }
            }
        });

        // Menghapus anggota kelompok yang dipilih
        hapusButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = kelompokJList.getSelectedIndex();
                if (selectedIndex != -1) {
                    anggotaList.remove(selectedIndex);
                    listModel.remove(selectedIndex);
                    namaField.setText("");
                }
            }
        });

        // Mengatur tata letak (layout)
        setLayout(new BorderLayout());
        JPanel inputPanel = new JPanel();
        inputPanel.add(namaField);
        inputPanel.add(tambahButton);
        inputPanel.add(editButton);
        inputPanel.add(hapusButton);
        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(kelompokJList), BorderLayout.CENTER);

        // Mengatur ukuran jendela
        setSize(600, 300);
    }
}

public class gui {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                AnggotaKelompok app = new AnggotaKelompok();
                app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                app.setVisible(true);
            }
        });
    }
}
