package kuqs

/**
 * @author alan
 * @date 12-4-19
 * @history
 */
class Versions {
    private static final String versionID = "00.00.01";
    private static final String versionDate = "2012-04-19";
    /**
     * <P>
     * 版本编号{Major}.{Minor}.{Revision}* <P>
     * 编号变化规则：Major表示大的版本变动，Minor表示功能有所增修，Revision也表示功能有局部修改但是不会全面影响所有客户。
     *
     * <P>
     * Change history:
     *
     * <P>
     * Ver 00.00.01
     * <LI>(2012-04-19) socket测试代码<br>
     */

    public static String getVersion() {
        return "KS " + versionID;// + versionDate;
    }

    public static String getVersionID() {
        return versionID;
    }

    public static String getVersionDate() {
        return versionDate;
    }

    public static void main(String[] args) {
        System.out.println(getVersion());
    }
}