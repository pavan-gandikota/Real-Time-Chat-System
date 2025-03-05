import java.net.*;
import java.io.*;

public class project{
    public static void main(String[] args){
        try{
            ServerSocket Serversocket = new ServerSocket(12345);
        System.out.println("Server is created");

        Socket clientSocket = Serversocket.accept();
        System.out.println("Client connected: " + clientSocket.getInetAddress());


        DataInputStream input=new DataInputStream(clientSocket.getInputStream());
        DataOutputStream output=new DataOutputStream(clientSocket.getOutputStream());

        String message = "";
            while (!message.equals("exit")) {
                // Reading message from the  client
                message = input.readUTF();
                System.out.println("Client: " + message);

                // If the client types "exit" end the chat
                if (!message.equals("exit")) {
                    // Sending a response to the client
                    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                    System.out.print("Server: ");
                    String response = reader.readLine();
                    output.writeUTF(response);
                }
            }

            System.out.println("Chat ended. Closing server...");

        }

        catch(IOException e){
            e.printStackTrace();
        }
    }
}