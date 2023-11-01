package request;

import java.io.*;
import java.net.Socket;


// dobije socket
// kreira in i out
// cita poruke i salje potvrdu nazad klijentu



public class RequestHandler implements Runnable {


    private final Socket clientSocket;

    public RequestHandler(Socket clientSocket){
        this.clientSocket=clientSocket;
    }
    @Override
    public void run() {
        try(BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),true)){
            System.out.println("This request handles worker with name: " + Thread.currentThread().getName());
            String inputLine = null;
            while ((inputLine=in.readLine())!=null){
                System.out.println("Accepted on server side " + inputLine);
            out.println("I wont send you back your message!");
            }

        }catch (IOException exception){
            System.err.println(exception.getMessage());

        }

    }
}
