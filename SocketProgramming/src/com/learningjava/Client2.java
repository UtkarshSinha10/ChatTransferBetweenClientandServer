package com.learningjava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client2 {
    public static void main(String[] args) throws InterruptedException, IOException {

        Socket socket=new Socket("localhost",4001);
        System.out.println("Client is connected to server");

        BufferedReader in =new BufferedReader(new InputStreamReader(socket.getInputStream()));

        PrintWriter out = new PrintWriter(socket.getOutputStream(),true);

        Scanner scn=new Scanner(System.in);
        String msg;
        do{
            System.out.println("Enter a message to server!");
            msg=scn.nextLine();
            out.println(msg);
            String response=in.readLine();
            System.out.println(response);
        }while(!msg.equals("exit"));
    }
}
