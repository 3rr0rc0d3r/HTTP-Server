import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.*;

public class HttpServer {
    public static void main(String args[]) throws Exception
    {

        final ServerSocket server = new ServerSocket(8080);

        System.out.println("Server is runing on port 8080");

        //while(true)
        {

            //spin forever
            final Socket socket = server.accept();
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String msg = br.readLine();

            while (!msg.isEmpty())
            {
                System.out.println(msg);
                msg = br.readLine();
            }

            Date todaysdate = new Date();
            String httpResponse = "HTTP/1.1 200 OK\r\n\r\n" + todaysdate;
            socket.getOutputStream().write(httpResponse.getBytes("UTF-8"));
        }

    }

}
