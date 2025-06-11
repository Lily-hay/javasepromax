package com.lily.d7_common_io;

import org.apache.commons.io.FileUtils;

import java.io.File;

public class CommonIOTest {
    public static void main(String[] args) throws Exception {
        //用IO框架实现
        FileUtils.copyFile(new File("day10-io/src/com/lily/aka.txt"),new File("day10-io/src/com/lily/aka-new.txt"));
        //FileUtils.copyDirectory();复制文件夹
        //FileUtils.deleteDirectory();删除文件夹

        //Java完成文件的复制
        //Files.copy(Path.of("day10-io/src/com/lily/aka.txt"),Path.of("day10-io/src/com/lily/aka-new.txt"));
    }
}
