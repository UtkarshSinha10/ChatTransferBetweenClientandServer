package com.learningjava;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws InterruptedException, IOException {

        ServerSocket socket=new ServerSocket(4000);

        System.out.println("Waiting for client to connect");

        Socket clientSocket=socket.accept();

        System.out.println("Client is connected");

        BufferedReader in=new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        PrintWriter out=new PrintWriter(clientSocket.getOutputStream(),true);

        while(true){
            String msg=in.readLine();
            out.println("Server acknowledges the message: " +msg);
            System.out.println(msg);
            if(msg.equals("exit"))break;
        }
    }
}
