package gui;

import cliente.tcp.ClienteEnviaTCP;
import cliente.tcp.ClienteTCP;
import servidor.tcp.ServidorTCP;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ajustesScreen extends JFrame{
    private JTextField serverIP;
    private JPanel mainPanel;
    private JLabel label;
    private JButton botonGuardar;

    public ajustesScreen() throws Exception{
        setContentPane(mainPanel);
        setTitle("Chat");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(200, 150);
        setLocationRelativeTo(null);
        setVisible(true);


        label.setText("Dirección IP del Server:");

        botonGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String dir = serverIP.getText();
                int count = dir.length() - dir.replace(".", "").length();

                if(count == 3) {
                    System.out.println("Formato de Dirección IP correcto: " + dir);
                    ClienteEnviaTCP clienteTCP = null;
                    try {
                        clienteTCP = new ClienteEnviaTCP(dir,60000);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                    chatScreen chat = new chatScreen(clienteTCP);

                    ServidorTCP servidorTCP=new ServidorTCP(60000, chat);

                    try {
                        clienteTCP = new ClienteEnviaTCP(dir,60000);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                    try{
                        servidorTCP.inicia();
                    } catch (Exception exp){
                        exp.printStackTrace();
                    }

                    setVisible(false);
                    chat.setVisible(true);

                }
            }
        });
    }
}
