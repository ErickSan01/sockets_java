package servidor.tcp;

import gui.chatScreen;
import servidor.tcp.ServidorEscuchaTCP;

public class ServidorTCP{
    protected final int PUERTO_SERVER;
    protected chatScreen chat;
    
    public ServidorTCP(int puertoS, chatScreen chat){
        PUERTO_SERVER=puertoS;
        this.chat = chat;
    }
    
    public void inicia()throws Exception{
        ServidorEscuchaTCP servidorTCP=new ServidorEscuchaTCP(PUERTO_SERVER, chat);
        
        servidorTCP.start();
    }
}
