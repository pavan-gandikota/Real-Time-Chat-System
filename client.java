import java.io.*;
import java.net.*;

public class client{
    public static void main(String[] args){
        try{
            Socket socket=new Socket("localhost", 12345);
        System.out.println("Client connected");

        DataInputStream input=new DataInputStream(socket.getInputStream());
        DataOutputStream output=new DataOutputStream(socket.getOutputStream());

          String message = "";
            while (!message.equals("exit")) {
                // getting input from the user
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                System.out.print("Client: ");
                message = reader.readLine();
                output.writeUTF(message);

                // If the user types "exit", end the chat
                if (!message.equals("exit")) {
                    // Reading and displaying the server's response
                    String response = input.readUTF();
                    System.out.println("Server: " + response);
                }
            }

            System.out.println("Chat ended. Closing client...");

        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}