package com.learningjava;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiThreadedServer {

    public static void main(String[] args) {
        try{
            ServerSocket socket=new ServerSocket(4001);
            while(true) {
                System.out.println("Waiting for client to connect");
                Socket client = socket.accept();
                System.out.println("Client is connected");
                Messaging obj = new Messaging(client);
                obj.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
