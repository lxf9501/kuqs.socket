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
        Socket s = new Socket("localhost", 4444);
        s.withStreams { input, output ->
            output << "echo testing ...\n"
            def buffer = input.newReader().readLine()
            println "response = $buffer"
        }

    }
}
