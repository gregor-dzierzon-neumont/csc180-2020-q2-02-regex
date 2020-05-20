package edu.neumont;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientDemo
{

    public static void main(String[] args)
    {
        ClientDemo program = new ClientDemo();
        program.requestGoogle();
    }

    public void run()
    {
        String serverAddress = "127.0.0.1";
        int port = 9999;

        try(Socket socket = new Socket(serverAddress, port))
        {

            System.out.println("Connected");

            //used to send a message to the server
            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output);

            //used to receive a message from the server
            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));


            // this is just so the user can send messages
            Scanner userInput = new Scanner(System.in);
            System.out.print("> ");
            String message = userInput.nextLine();

            //this is where I send the message/ command to the server
            writer.println(message);
            writer.flush(); //flush is what actually sends the stream

            //wait for server response
            String line = reader.readLine();
            while(!line.equals("hangup"))
            {
                System.out.println(line);

                System.out.print("> ");
                writer.println(userInput.nextLine());
                writer.flush();

                line = reader.readLine();
            }

            System.out.println("Game over");

            reader.close();
            writer.close();


        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void requestGoogle()
    {
        String hostname = "www.google.com";
        int port = 80;

        try (Socket socket = new Socket(hostname, port)) {

            //where I write my request
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(output));

            // where I get the response
            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            writer.println("GET / HTTP/1.1");
            writer.println("User-Agent: Mozilla/4.0 (compatible; MSIE5.01; Windows NT)");
            writer.println("Host: www.google.com");
            writer.println();
            writer.flush();

            String line;
            while ((line = reader.readLine()) != null && !line.trim().isEmpty()) System.out.println(line);

            input.close();
            output.close();
            socket.close();



        } catch (UnknownHostException ex) {

            System.out.println("Server not found: " + ex.getMessage());

        } catch (IOException ex) {

            System.out.println("I/O error: " + ex.getMessage());
        }
    }
}
