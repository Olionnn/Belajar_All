import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class boxlayout {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Contoh horizontal dan vertical dalam box layout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        JPanel panelv = new JPanel();
        JPanel panelh = new JPanel();

        panelv.setLayout(new BoxLayout(panelv, BoxLayout.Y_AXIS));
        panelh.setLayout(new BoxLayout(panelh, BoxLayout.X_AXIS));

        for (int i = 1; i <= 5; i++) {
            JButton buttonv = new JButton("Vertical " + i);
            panelv.add(buttonv);
        }

        for (int i = 1; i <= 5; i++) {
            JButton buttonh = new JButton("Horizontal " + i);
            panelh.add(buttonh);
        }

        panel.add(panelv);
        panel.add(panelh); 

        frame.add(panel);
        frame.setSize(500, 500);
        frame.setVisible(true);
    }
}
