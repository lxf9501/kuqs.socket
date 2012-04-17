package kuqs.tool

/**
 * @author alan
 * @date 12-4-17
 * @history
 */
class SocketUtils {

    public static void sendBlock(OutputStream outputStream, byte[] data, int offset,
                                 int count) throws IOException {
        outputStream.write(data, offset, count);
    }

    public static void recvBlock(InputStream inputStream, byte[] buffer, int offset,
                                 int count) throws IOException {
        while (count > 0) {
            int recv = inputStream.read(buffer, offset, count);
            if (recv == -1) {
                throw new IOException("连接意外断开");
            }
            count -= recv;
            offset += recv;
        }
    }

    public static void sendInteger(OutputStream outputStream, int data) throws IOException {
        byte[] buffer = new byte[4];
        buffer[3] = (byte) (data >>> 24);
        buffer[2] = (byte) (data >>> 16);
        buffer[1] = (byte) (data >>> 8);
        buffer[0] = (byte) (data >>> 0);
        sendBlock(outputStream, buffer, 0, 4);
    }

    public static int recvInteger(InputStream inputStream) throws IOException {
        byte[] buffer = new byte[4];
        recvBlock(inputStream, buffer, 0, 4);
        int value = ((buffer[3] & 0xFF) << 24) + ((buffer[2] & 0xFF) << 16) + ((buffer[1] & 0xFF) << 8) + ((buffer[0] & 0xFF) << 0);
        return value;
    }

    public static int recvByte(InputStream inputStream) throws IOException {
        byte[] buffer = new byte[1];
        recvBlock(inputStream, buffer, 0, 1);
        int value = (buffer[0] & 0xFF) << 0;
        return value;
    }
}
