package kuqs.socket

/**
 * @author alan
 * @date 12-4-17
 * @history
 */
class TestMain {
    Socket socket;
    TestMain(String host, int port) {
        println "start to connect server ${host}--${port}"
        socket = new Socket(host, port)
        println 'connected...'
    }

    void sentCommand() {
        socket.withStreams {
            input, output ->
            println 'sent command 1'
            def commands = [0x00, 0x01, 0x53]
            commands.each {
                output << it
            }
            output.flush()

            byte[] buffers = new byte[3]
            input.read(buffers)
            println buffers

            println 'sent command 2'
            commands = [0x00, 0x02, 0x00, 0x00]
            commands.each {
                output << it
            }
            output.flush()
            byte[] buffers_1 = new byte[768]
            input.read(buffers_1)
            println buffers_1

            println 'receive 3'
            byte[] buffers_2 = new byte[1024]
            input.read(buffers_2)
            println buffers_1

            println 'finish '
        }
    }

    static void main(args) {
        if (args.length < 2) {
            println 'ks [host] [port]'
            println '  -- ex: ks 127.0.0.1 2533'
            System.exit(0)
        }
        TestMain tm = new TestMain(args[0], Integer.parseInt(args[1]))
        tm.sentCommand()
    }
}
