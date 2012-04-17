package kuqs.tool

import groovy.io.FileType

/**
 * @author alan
 * @date 12-4-17
 * @history
 */
class BatchRenameFile {

    def doing(String path, String preName) {
        File dir = new File(path)
        int count = 1
        dir.traverse(
                type: FileType.FILES,
                nameFilter: ~/.*\.jpg/,
                maxDepth: 0
        ) {
            it.renameTo(new File(path + File.separator + preName + String.format("%03d", count) + '.jpg'))
            count++
        }
    }

    static void main(args) {
        ((new BatchRenameFile()).doing('H:/Images/照相摄像/201204/201204A0/', '20120415'))
    }
}
