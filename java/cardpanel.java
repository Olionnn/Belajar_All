import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class cardpanel {


    public static void main(String[] args) {
        JFrame frame = new JFrame("Contoh CardLayout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel cardPanel = new JPanel();
        CardLayout cardLayout = new CardLayout();
        cardPanel.setLayout(cardLayout);

        // Panel 1
        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.RED);
        JButton nextButton = new JButton("Selanjutnya");
        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "panel2");
            }
        });
        panel1.add(nextButton);

        // Panel 2
        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.BLUE);
        JButton backButton = new JButton("Sebelumnya");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "panel1");
            }
        });
        panel2.add(backButton);

        cardPanel.add(panel1, "panel1");
        cardPanel.add(panel2, "panel2");

        frame.add(cardPanel);
        frame.setVisible(true);
    }

}
