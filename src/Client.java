import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Client extends JFrame {

    JPanel jPanel1;
    JButton btnSend;
    JTextField tfMsg;
    JTextArea taChat;

    public Client(){
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

        lImageBackArrow.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
                System.exit(0);
            }
        });

        JLabel jLabel1 = new JLabel("Client");
        jLabel1.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        jLabel1.setForeground(Color.white);
        jLabel1.setBounds(125, 15, 100, 20);
        jPanel1.add(jLabel1);

        taChat = new JTextArea();
        taChat.setBounds(5, 70, 335, 400);
        taChat.setEnabled(false);
        add(taChat);

        tfMsg = new JTextField();
        tfMsg.setBounds(5, 525, 260, 30);
        tfMsg.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(tfMsg);

        btnSend = new JButton("Send");
        btnSend.setBounds(270, 525, 70, 30);
        btnSend.setBackground(new Color(51,107,135));
        btnSend.setForeground(Color.WHITE);
        add(btnSend);
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setSize(350, 600);
        setLocation(200, 100);
    }

    public static void main(String[] args) {
        new Client().setVisible(true);
    }
}
