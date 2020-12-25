import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

@SuppressWarnings("ALL")
public class Client extends JFrame implements ActionListener {

    private JTextField tfMsg;
    private static JTextArea taChat;

    private static DataOutputStream dout;

    public Client(){
        initComponent();
    }

    private void initComponent(){
        JPanel jPanel1 = new JPanel();
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
        taChat.setBounds(5, 50, 335, 400);
        taChat.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        taChat.setEditable(false);
        add(taChat);


        tfMsg = new JTextField();
        tfMsg.setBounds(5, 525, 260, 30);
        tfMsg.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(tfMsg);

        JButton btnSend = new JButton("Send");
        btnSend.setBounds(270, 525, 70, 30);
        btnSend.setBackground(new Color(51,107,135));
        btnSend.setForeground(Color.WHITE);
        btnSend.addActionListener(this);
        add(btnSend);

        getContentPane().setBackground(Color.white);
        setLayout(null);
        setSize(350, 600);
        setLocation(800, 100);
    }

    public static void main(String[] args) {
        new Client().setVisible(true);

        try{
            Socket s = new Socket("127.0.0.1", 6001);
            DataInputStream din = new DataInputStream(s.getInputStream());
            dout = new DataOutputStream(s.getOutputStream());

            String msginput;

            while(true){
                msginput = din.readUTF();
                taChat.setText(taChat.getText() + "\nServer \t: " + msginput);
                System.out.println();

            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        try {
            String out = tfMsg.getText();
            taChat.setText(taChat.getText() + "\nClient \t: " + out);
            dout.writeUTF(out);
            tfMsg.setText("");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
