package com.learningjava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Messaging extends Thread{

    Socket clientSocket;

    Messaging(Socket socket)throws  IOException{
        this.clientSocket=socket;
    }
    @Override
    public void run() {
        BufferedReader in = null;
        try {
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            while (true) {
                String msg = null;
                msg = in.readLine();
                out.println("Server acknowledges the message: " + msg+" in thread: "+currentThread().getName());
                System.out.println(msg);
                if (msg.equals("exit")) break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
