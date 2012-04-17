package kuqs.socket

import kuqs.tool.SocketUtils

/**
 * @author alan
 * @date 12-4-17
 * @history
 */
class ListenerServer {
    Socket socket;

    ListenerServer(String ip) {
        socket = new Socket(ip, 2533)
    }

    void sentCommand(byte[] bs) {
        socket.withStreams {
            input, output ->
            DataOutputStream dos = new DataOutputStream(output)
            DataInputStream dis = new DataInputStream(input)
            bs.each {
                dos << it
            }
            dos.flush()

            byte[] buffers = new byte[3]
            SocketUtils.re
            dis.read(buffers)
            println buffers
        }
    }

    void release() {
        try {
            socket.inputStream.close()
        } catch (Exception e) {
        }

        try {
            socket.outputStream.close()
        } catch (Exception e) {
        }

        try {
            socket.close()
        } catch (Exception e) {
        }
    }
}
