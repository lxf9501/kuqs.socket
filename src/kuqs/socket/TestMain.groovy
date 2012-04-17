package kuqs.socket

/**
 * @author alan
 * @date 12-4-17
 * @history
 */
class TestMain {

    static void main(args) {
        if (args.length > 0 && args[0].equals('-s')) {
            new ServerSocket(2533)
        } else {
            ListenerServer ls = new ListenerServer('localhost')
            ls.sentCommand([0x00, 0x01, 0x53] as byte[])
            ls.release()
        }
    }
}
