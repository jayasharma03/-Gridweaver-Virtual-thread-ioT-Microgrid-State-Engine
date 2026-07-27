package com.gridweaver.backend.socket;

import java.io.IOException;
import java.net.Socket;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MockIoTClient implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {

        Thread.sleep(5000);

        for (int i = 1; i <= 10000; i++) {

            final int clientNo = i;

            Thread.startVirtualThread(() -> {

                try (Socket socket = new Socket("127.0.0.1", 9090)) {

                    System.out.println("Client " + clientNo + " Connected");

                } catch (IOException e) {
                    System.out.println("Client " + clientNo + " Failed");
                }

            });

        }
    }
}