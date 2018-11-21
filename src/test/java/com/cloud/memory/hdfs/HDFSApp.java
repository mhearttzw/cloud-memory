package com.cloud.memory.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.util.Progressable;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URI;

/**
 * Hadoop HDFS Java API操作
 */
public class HDFSApp {

    public static final String HDFS_PATH = "hdfs://139.199.183.115:8020";

    FileSystem fileSystem = null;
    Configuration conf = null;


    /**
     * 创建HDFS目录
     * @throws Exception
     */
    @Test
    public void mkdir() throws Exception {
        fileSystem.mkdirs(new Path("/hdfsapi/test"));
    }

    /**
     * 创建文件
     * @throws Exception
     */
    @Test
    public void create() throws Exception {
        FSDataOutputStream outputStream = fileSystem.create(new Path("/hdfsapi/test/a.txt"));
        outputStream.write("hello hadoop".getBytes());
        outputStream.close();

    }

    /**
     * 查看hdfs文件的内容
     * @throws Exception
     */
    @Test
    public void cat() throws Exception {
        FSDataInputStream in = fileSystem.open(new Path("/hdfsapi/test/ContentBody.txt"));
        IOUtils.copyBytes(in, System.out, 1024);
        in.close();

    }

    /**
     * 重命名文件
     * @throws Exception
     */
    @Test
    public void rename() throws Exception {
        Path newPath = new Path("/hdfsapi/test/b.txt");
        Path oldPath = new Path("/hdfsapi/test/a.txt");
        fileSystem.rename(oldPath, newPath);
    }

    /**
     * 上传文件到hdfs
     * @throws Exception
     */
    @Test
    public void copayFromLocalFile() throws Exception {
        Path localPath = new Path("C:\\ContentBody.txt");
        Path hdfsPath = new Path("/hdfsapi/test");
        fileSystem.copyFromLocalFile(localPath, hdfsPath);
    }

    /**
     * 上传文件到hdfs
     * @throws Exception
     */
    @Test
    public void copayFromLocalFileWithProgress() throws Exception {

        InputStream in = new BufferedInputStream(new FileInputStream(new File("E:\\学习资料\\MySQL数据库\\高性能mysql第三版.pdf")));
        FSDataOutputStream outputStream = fileSystem.create(new Path("/hdfsapi/test/高性能mysql第三版.pdf"), new Progressable() {
            @Override
            public void progress() {
                System.out.print(".");
            }
        });
        IOUtils.copyBytes(in, outputStream, 4096);

    }

    /**
     * 下载hdfs文件
     * @throws Exception
     */
    @Test
    public void copyToLocalFile() throws Exception {
/*        InputStream in = fileSystem.open(new Path("/hdfsapi/test/ContentBody.txt"));
        FileOutputStream outputStream = new FileOutputStream(new File("E:\\学习资料\\h.txt"));

        IOUtils.copyBytes(in, outputStream, 4096, true);*/

        Path hdfsPath = new Path("/hdfsapi/test/ContentBody.txt");
        Path localPath = new Path("E:\\学习资料\\h.txt");
        fileSystem.copyToLocalFile(false, hdfsPath, localPath, true);
    }


    @Test
    public void listFiles() throws Exception {
        FileStatus[] fileStatuses = fileSystem.listStatus(new Path("/hdfsapi/test"));
        for (FileStatus fileStatus : fileStatuses) {
            fileStatus.isDirectory();
        }
    }



    @Before
    public void setUp() throws Exception {
        conf = new Configuration();
        conf.set("dfs.client.use.datanode.hostname", "true");
        fileSystem = FileSystem.get(new URI(HDFS_PATH), conf, "root");

        System.out.println("HDFSApp setUp.");
    }


    @After
    public void tearDown() throws Exception {
        conf = null;
        fileSystem = null;

        System.out.println("HDFSApp tearDown.");
    }

}
