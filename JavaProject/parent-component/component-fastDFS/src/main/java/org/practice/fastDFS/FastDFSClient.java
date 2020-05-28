package org.practice.fastDFS;

import java.io.File;
import java.io.FileInputStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;

/**
 * @Desc Spring集成FastDFS
 * https://www.cnblogs.com/zixiaoguan/p/7456116.html
 * http://www.cnblogs.com/jiafuwei/p/5777622.html
 * <p>
 * @Author 20180112002
 * <p>
 * @Date 2018年8月3日
 * <p>
 * @Version 1.0
 */
@ContextConfiguration(locations = {"classpath:fastdfs.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class FastDFSClient {

    @Autowired
    FastFileStorageClient fastFileStorageClient;

    @Test
    public void uploadFile() throws Exception {
        System.out.println("uploadFile Start......");
        File file = new File("E:\\MyWork\\Image\\20180410-loanApplyNode.jpg");
        StorePath storePath = fastFileStorageClient.uploadFile(null, new FileInputStream(file), file.length(), "jpg");
        System.out.println(storePath);
        System.out.println("uploadFile Finished......");
    }

}
