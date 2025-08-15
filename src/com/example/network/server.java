package com.example.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
    public static void main(String[] args) {
        int port = 8081;

        System.out.println("Starting server on port " + port);
        try (ServerSocket serverSocket = new ServerSocket(port)){
            while (true){
                try (Socket clientSocket = serverSocket.accept()){
                    String clientIP = clientSocket.getInetAddress().getHostAddress();
                    int clientPort = clientSocket.getPort();
                    System.out.println("New connection accepted");
                    System.out.println("client IP: " + clientIP);
                    System.out.println("client Port: " + clientPort);

                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(clientSocket.getInputStream()));

                    PrintWriter out = new PrintWriter(
                            clientSocket.getOutputStream(), true);

                    out.println("Hello! What's your name?");
                    final String name = in.readLine();
                    System.out.println("Hello! " + name);

                    out.println(String.format(
                            "Hi %s, your port is %d", name, clientSocket.getPort()));

                } catch (IOException e){
                    System.out.println(e.getMessage());
                }
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }
}
