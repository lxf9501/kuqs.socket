package kuqs.socket

/**
 * @author alan
 * @date 12-4-17
 * @history
 */
class Test {

   static void main(args) {
       short[] bs = [0, 1, 2]
       println bs
       bs = [0x00, 0x01, 0x02]
       short b = (short) 0x00
       println b

       println 0x01

       println Integer.valueOf("0000",16)
   }
}
