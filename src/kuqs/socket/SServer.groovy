package kuqs.socket

/**
 * @author alan
 * @date 12-4-17
 * @history
 */
class SServer {

    void doing() {
        def server = new ServerSocket(2533)

        while (true) {
            server.accept { socket ->
                println "processing new connection..."
                socket.withStreams { input, output ->
                    DataOutputStream dos = new DataOutputStream(output)
                    DataInputStream dis = new DataInputStream(input)

                    byte[] buffers = new byte[3]
                    println dis.read
//                    println "server received: $buffer"
                    if (buffers[0] == 0x00 && buffers[1] == 0x01 && buffers[2] == 0x53) {
                        dos << 0x00
                        dos << 0x01
                        dos << 0x50
                    } else {
                        dos << 0x00
                        dos << 0x00
                        dos << 0x00
                    }

                }
                println "processing/thread complete."
            }
        }
    }

    static void main(args) {
        ((new SServer()).doing())
    }
}
