import javax.swing.*;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class tugasgui {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowInputForm();
        });
    }

    private static void createAndShowInputForm() {
        JFrame inputFrame = new JFrame("Penghitungan");
        inputFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inputFrame.setSize(350, 150);

        JPanel inputPanel = new JPanel();
        // inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));

        JTextField form1 = new JTextField(10);
        JTextField form2 = new JTextField(10);
        JTextField form3 = new JTextField(10);
        JTextField form4 = new JTextField(10);
        JTextField form5 = new JTextField(10);
        JTextField form6 = new JTextField(10);
        JTextPane hasil1 = new JTextPane();
        JTextPane hasil2 = new JTextPane();
        JTextPane hasil3 = new JTextPane();
        JButton hasilTambah = new JButton("=");
        JButton hasilKurang = new JButton("=");
        JButton hasilKali = new JButton("=");

        hasilTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String num1 = form1.getText();
                String num2 = form2.getText();
                double result = Double.parseDouble(num1) + Double.parseDouble(num2);
                hasil1.setText(Double.toString(result));
            }
        });

        hasilKurang.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String num1 = form3.getText();
                String num2 = form4.getText();
                double result = Double.parseDouble(num1) - Double.parseDouble(num2);
                hasil2.setText(Double.toString(result));
            }
        });

        hasilKali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String num1 = form5.getText();
                String num2 = form6.getText();
                double result = Double.parseDouble(num1) * Double.parseDouble(num2);
                hasil3.setText(Double.toString(result));
            }
        });

        inputPanel.add(new JLabel());
        inputPanel.add(form1);
        inputPanel.add(new JLabel("+"));
        inputPanel.add(form2);
        inputPanel.add(hasilTambah);
        inputPanel.add(hasil1);

        inputPanel.add(new JLabel("\n"));

        inputPanel.add(form3);
        inputPanel.add(new JLabel("-"));
        inputPanel.add(form4);
        inputPanel.add(hasilKurang);
        inputPanel.add(hasil2);

        inputPanel.add(new JLabel("\n"));

        inputPanel.add(form5);
        inputPanel.add(new JLabel("x"));
        inputPanel.add(form6);
        inputPanel.add(hasilKali);
        inputPanel.add(hasil3);


        inputFrame.getContentPane().add(inputPanel);
        inputFrame.setVisible(true);
    }

}
