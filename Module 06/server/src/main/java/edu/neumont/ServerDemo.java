package edu.neumont;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo
{

    public static void main(String[] args)
    {
        ServerDemo program  = new ServerDemo();
        program.run();
    }

    public void run()
    {

        try {

            //setup
            //define the socket
            ServerSocket serverSocket = new ServerSocket(9999);

            //open socket and listen for connections
            System.out.println("Server is listening on port 9999.");
            Socket socket = serverSocket.accept();

            System.out.println("A new client is connected");
            //end setup


            //use to send a message back to the client
            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output);

            //used to receive a message from the client
            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            // we want to get the request from the client
            String command = reader.readLine();
            while(!command.toLowerCase().equals("quit")) {
                writer.println(command);
                writer.flush();

                command = reader.readLine();
            }

            writer.println("hangup");
            writer.flush();

            reader.close();
            writer.close();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
