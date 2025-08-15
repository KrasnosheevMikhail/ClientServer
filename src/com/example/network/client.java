package com.example.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class client {
    public static void main(String[] args) {
        String serverIP = "localhost";
        int severPort = 8081;
        try(Socket socket = new Socket(serverIP, severPort)){
            System.out.println("Connected to server");
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            String greeting = "Hello! ";
            System.out.println("Server: " + greeting);
            String name = "My name is Michail";
            out.println(name);
            String responce = in.readLine();
            System.out.println("Server: " + responce);

        } catch (IOException e) {
            System.out.println(e.getMessage());;
        }



    }
}