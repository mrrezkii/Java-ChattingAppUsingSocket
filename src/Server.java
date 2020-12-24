import javax.swing.*;
import java.awt.*;

public class Server extends JFrame {

    JPanel jPanel1;

    public Server(){
        jPanel1 = new JPanel();
        jPanel1.setLayout(null);
        jPanel1.setBackground(new Color(51,107,135));
        jPanel1.setBounds(0, 0, 350, 50);
        add(jPanel1);

        ImageIcon srcBackArrow = new ImageIcon(ClassLoader.getSystemResource("Drawable/leftarrow.png"));
        Image imgBackArrow = srcBackArrow.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon mImgBackArrow = new ImageIcon(imgBackArrow);
        JLabel lImageBackArrow = new JLabel(mImgBackArrow);
        lImageBackArrow.setBounds(5, 10, 30, 30);
        jPanel1.add(lImageBackArrow);


        getContentPane().setBackground(Color.white);
        setLayout(null);
        setSize(350, 600);
        setLocation(200, 100);
    }

    public static void main(String[] args) {
        new Server().setVisible(true);
    }
}
