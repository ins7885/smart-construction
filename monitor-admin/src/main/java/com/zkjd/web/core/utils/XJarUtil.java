package com.zkjd.web.core.utils;

import io.xjar.XCryptos;

/**
 * @Author: wangtao
 * @CreateTime: 2022-01-17 15:55
 * @Description: 加密jar
 */
public class XJarUtil {

    //文件地址
    private static final String inPath = "D:\\project\\java\\preparation-project\\intelligent-monitor\\intelligent-monitor-server\\monitor-admin\\target\\monitor-admin.jar";
//    private static final String inPath = "D:\\project\\java\\preparation-project\\intelligent-monitor-platform\\target\\platform-server.jar";

    //输出地址
    private static final String outPath = "D:\\project\\java\\preparation-project\\deploy\\server\\monitor-admin.jar";
//    private static final String outPath = "D:\\project\\java\\preparation-project\\deploy\\platform\\platform-server.jar";

    //加密秘钥
    private static final String secret = "zkjd2022,.";

    public static void main(String[] args) throws Exception {
        hanlderEncryptionJar();
        System.out.println("完成输出");
    }


    /**
     * 加密jar
     *
     * @throws Exception
     */
    private static void hanlderEncryptionJar() throws Exception {
        XCryptos.encryption()
                .from(inPath)
                .use(secret)
                .include("/**.class")
                .include("/**/*.xml")
                .to(outPath);
    }
}
