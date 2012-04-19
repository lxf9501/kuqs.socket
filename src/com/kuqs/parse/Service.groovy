package com.kuqs.parse

/**
 * Created by IntelliJ IDEA.
 * @author alan
 * @date 12-4-16
 * @history
 */
class Service {
    def server = new ServerSocket(4444)
    def service() {
        server.accept { socket ->
            println "processing new connection..."
            socket.withStreams { input, output ->
                def reader = input.newReader()
                def buffer = reader.readLine()
                println "server received: $buffer"
                Date now = new Date()
                output << "echo-response($now): " + buffer + "\n"
            }
            println "processing/thread complete."
        }
    }

    def client() {
        Socket s = new Socket("localhost", 3490);
        s.withStreams { input, output ->
//            output << "echo testing ...\n"
            DataOutputStream dos = new DataOutputStream(output)
            byte[] sents = [0x00, 0x01, 0x88] as byte[]
//            dos.write(0x00)
//            dos.write(0x01)
//            dos.write(0x88)
            dos.write(sents)
            dos.flush()
            byte[] buffers = new byte[3]
            def buffer = input.read(buffers)
            println "response = $buffer"
            println buffers
        }

    }

    static void main(args) throws Exception {
        ((new Service()).client())
    }
}
