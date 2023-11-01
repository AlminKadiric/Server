import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("We do not have configured port number");
            System.exit(1);
        }
        int portNumber = Integer.parseInt(args[0]);
        System.out.println("Server has started!. It listened on the port: " + portNumber);
        try(ServerSocket serverSocket = new ServerSocket(portNumber);
            Socket clientSocket = serverSocket.accept();
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))){
            System.out.println("Client sent me : ");
            String inputLine = null;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("I've got the message : " + inputLine);
                out.println("Servus. I am sending you back your message: " + inputLine);
            }

        }catch (IOException exception){
            System.err.println(exception.getMessage());


        }
    }
}
