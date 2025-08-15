package com.example.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {


    public static void main(String[] args) {

        try(Socket clientSocket = new Socket("netology.homework", Server.PORT)){
            System.out.println("Connected to server");
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));

            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            Scanner scanner = new Scanner(System.in);
            System.out.println(in.readLine());
            out.println(scanner.nextLine());
            System.out.println(in.readLine());
            out.println(scanner.nextLine());
            System.out.println(in.readLine());


        } catch (IOException e) {
            System.out.println(e.getMessage());;
        }



    }
}