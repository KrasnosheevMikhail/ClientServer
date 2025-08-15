package com.example.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    static final int PORT = 8080;
    public static void main(String[] args) {

        System.out.println("Starting server on port " + PORT);
        try (ServerSocket serverSocket = new ServerSocket(PORT)){
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
                    out.println("Server: Hello! What's your name?");
                    final String username = in.readLine();
                    System.out.println("Server: Hello! " + username);
                    out.println("Server: Are you child? (yes/no)");
                    String responce = in.readLine();
                    System.out.println("Client: " + responce);
                    if (responce.toLowerCase().equals("yes")){
                        out.println(String.format("Server: Welcome to the kids area, %s! Let's play!", username));
                    } else {
                        out.println(String.format(
                                "Server: Welcome to the adult zone, " +
                                        "%s! Have a good rest, or a good working day!", username));
                    }
                } catch (IOException e){
                    System.out.println(e.getMessage());
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
