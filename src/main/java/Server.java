import request.RequestHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {

        if(args.length <1){
            System.err.println("Server port is not configured!");
        System.exit(1);

        }
        int portNumber = Integer.parseInt(args[0]);
        System.out.println("Server has started on the port: " + portNumber);
        try(ServerSocket serverSocket = new ServerSocket(portNumber);)
        {
            while (true){
                Socket clientSocket = serverSocket.accept();
                Runnable requestHandler = new RequestHandler(clientSocket);
                new Thread(requestHandler).start();



            }

        }catch (IOException exception){
            System.err.println(exception.getMessage());
        }

    }
}
