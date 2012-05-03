package kuqs.tool

import groovy.io.FileType

/**
 * @author alan
 * @date 12-4-23
 * @history
 */
class FileEncodeChange {
    void change(path) {
        File dir = new File(path)
        int count = 1
        dir.traverse(
                type: FileType.FILES,
                nameFilter: ~/.*\.java/
        ) {
            try {
                InputStream inf = new FileInputStream(it);
                BufferedReader br = new BufferedReader(new InputStreamReader(inf, "gb2312"));
                File temp = new File(it.getPath() + ".txt");
                OutputStream out = new FileOutputStream(temp);
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out, "utf-8"));
                String line = null;
                while ((line = br.readLine()) != null) {
                    bw.write(line+"\r\n");
                }
                br.close();
                inf.close();
                bw.close();
                out.close();
                it.delete();
                temp.renameTo(it);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(args) {
//        String path = 'E:/projects/cvs/cvs_specialty_store/04.程序代码/src/com/totapps/cvs/'
//        String path = 'E:/projects/cvs/cvs_specialty_store/04.程序代码/src/entity'
//        String path = 'E:/projects/cvs/cvs_specialty_store/04.程序代码/src/awt_swing'
//        String path = 'E:/projects/cvs/cvs_specialty_store/04.程序代码/src/com/totapps'
//        String path = 'E:/projects/cvs/cvs_specialty_store/04.程序代码/dlsrc'
//        String path = 'E:/projects/cvs/cvs_specialty_store/04.程序代码/src/com/totapps/release'
//        String path = 'E:/projects/cvs/MyTotapps.CVS HQS v3.0/04.程序代码/dlsrc/com/totapps/cvs/trans/templates'
//        String path = 'E:/projects/cvs/MyTotapps.CVS HQS v3.0/04.程序代码/dlsrc/com/totapps/cvs/trans'
        String path = 'E:/projects/cvs/MyTotapps.CVS HQS v3.0/04.程序代码/src/entity'
        (new FileEncodeChange()).change(path)
    }
}
