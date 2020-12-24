import javax.swing.*;
import java.awt.*;

public class Server extends JFrame {

    public Server(){
        ImageIcon srcBackArrow = new ImageIcon(ClassLoader.getSystemResource("Drawable/leftarrow.png"));
        Image imgBackArrow = srcBackArrow.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon mImgBackArrow = new ImageIcon(imgBackArrow);
        JLabel lImageBackArrow = new JLabel(mImgBackArrow);
        lImageBackArrow.setBounds(600, 0, 0, 0);
        add(lImageBackArrow);


        getContentPane().setBackground(Color.cyan);
        setSize(350, 600);
        setLocation(200, 100);
    }

    public static void main(String[] args) {
        new Server().setVisible(true);
    }
}
