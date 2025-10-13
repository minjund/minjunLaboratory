package com.minjun.minjunlaboratory.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

import static org.springframework.util.FileCopyUtils.BUFFER_SIZE;

public class Socket {

    public static void main(String[] args) throws IOException {
        // 1. 서버 소켓 채널 생성
        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        serverChannel.bind(new InetSocketAddress(8080));

        while (true) {
            // 2. 클라이언트 연결 대기 (Blocking)
            SocketChannel clientChannel = serverChannel.accept();
            System.out.println("✅ 클라이언트 연결됨: " + clientChannel.getRemoteAddress());

            // 3. 클라이언트 처리
            handleClient(clientChannel);
        }
    }

    private static void handleClient(SocketChannel clientChannel) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(BUFFER_SIZE);

        try {
            while (true) {
                // 1. 버퍼 초기화
                buffer.clear();

                // 2. 클라이언트로부터 데이터 읽기
                int bytesRead = clientChannel.read(buffer);

                if (bytesRead == -1) {
                    // 클라이언트가 연결을 끊음
                    System.out.println("❌ 클라이언트 연결 종료");
                    break;
                }

                // 3. 읽은 데이터 출력
                buffer.flip();
                byte[] data = new byte[buffer.remaining()];
                buffer.get(data);
                String message = new String(data);
                System.out.println("📩 받은 메시지: " + message.trim());

                // 4. Echo: 받은 데이터를 그대로 돌려보냄
                buffer.rewind(); // position을 0으로
                clientChannel.write(buffer);
                System.out.println("📤 Echo 완료!");
            }
        } finally {
            clientChannel.close();
        }
    }
}
