package com.gridweaver.backend.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class SocketServer {
	
	private static final int PORT = 9090;

    @PostConstruct
    public void startServer() {

        Thread.startVirtualThread(() -> {

            try (ServerSocket serverSocket = new ServerSocket(PORT)) {

                System.out.println("Socket Server started on port " + PORT);

                while (true) {

                    Socket clientSocket = serverSocket.accept();

                    Thread.startVirtualThread(() -> handleClient(clientSocket));
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        });
        
    }

    private void handleClient(Socket socket) {

        try {
            System.out.println("Connected : " + socket.getInetAddress());

            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
