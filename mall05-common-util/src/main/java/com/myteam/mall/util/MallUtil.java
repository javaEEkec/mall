package com.myteam.mall.util;

import com.myteam.mall.constant.MallConstant;
import com.obs.services.ObsClient;
import com.obs.services.exception.ObsException;
import com.obs.services.model.PutObjectResult;

import javax.servlet.http.HttpServletRequest;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

/**
 * 通用的工具方法类
 * @author ljs
 */
public class MallUtil {

    /**
     * 对明文字符串进行MD5加密
     * @param source 传入的明文字符串
     * @return 加密的结果
     */
    public static String md5(String source){
        // 1.判断source是否有效
        if (source == null || source.length() == 0){
            // 2.如果不是有效数据则抛异常
            throw new NullPointerException(MallConstant.MESSAGE_STRING_INVALIDATE);
        }

        //获取MessageDigest对象
        try {
            String algorithm = "md5";
            MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
            // 4.获取明文字符串对应的字节数组
            byte[] input = source.getBytes();
            // 5.执行加密
            byte[] output = messageDigest.digest(input);
            // 6.创建BigInteger对象
            int signum = 1;
            BigInteger bigInteger = new BigInteger(signum,output);
            // 7.按照16进制将bigInteger的值转换为字符串
            int radix = 16;
            return bigInteger.toString(radix).toUpperCase();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 判断当前请求是否为ajax请求
     * @param request 请求对象
     * @return true:当前请求是ajax请求 false：当前请求不是ajax请求
     */
    public static boolean judgeRequestType(HttpServletRequest request){
        //1.获取请求头
        String acceptHeader = request.getHeader("Accept");
        String xRequestHeader = request.getHeader("X-Request-With");

        //2.判断
        return (acceptHeader != null && acceptHeader.contains("application/json"))
                || (xRequestHeader != null && xRequestHeader.equals("XMLHttpRequest"));
    }

    /**
     * 专门负责上传文件到OSS服务器的工具方法
     * @param endpoint			OSS参数
     * @param accessKeyId		OSS参数
     * @param accessKeySecret	OSS参数
     * @param inputStream		要上传的文件的输入流
     * @param bucketName		OSS参数
     * @param bucketDomain		OSS参数
     * @param originalName		要上传的文件的原始文件名
     * @return	包含上传结果以及上传的文件在OSS上的访问路径
     */
    public static ResultEntity<String> uploadFileToObs(String endpoint,
                                                       String accessKeyId,
                                                       String accessKeySecret,
                                                       InputStream inputStream,
                                                       String bucketName,
                                                       String bucketDomain,
                                                       String originalName){

        // 创建ObsClient实例。
        ObsClient obsClient = new ObsClient(accessKeyId,accessKeySecret,endpoint);
        // 生成上传文件的目录
        String folderName = new SimpleDateFormat("yyyyMMdd").format(new Date());

        // 生成上传文件在OBS服务器上保存时的文件名
        // 原始文件名：beautfulgirl.jpg
        // 生成文件名：wer234234efwer235346457dfswet346235.jpg
        // 使用UUID生成文件主体名称
        String fileMainName = UUID.randomUUID().toString().replace("-", "");
        // 从原始文件名中获取文件扩展名
        String extensionName = originalName.substring(originalName.lastIndexOf("."));

        // 使用目录、文件主体名称、文件扩展名称拼接得到对象名称
        String objectName = folderName + "/" + fileMainName + extensionName;
        try {
            obsClient.putObject(bucketName, objectName, inputStream);
            // 拼接访问刚刚上传的文件的路径
            String ossFileAccessPath = bucketDomain + "/" + objectName;
            // 当前方法返回成功
            return ResultEntity.successWithData(ossFileAccessPath);

        }catch (ObsException e){
            e.printStackTrace();
            return ResultEntity.failed("当前响应状态码="+e.getResponseCode()+"错误消息="+e.getErrorMessage());
        }finally {
            try {
                obsClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("mall05-common-util/头像01.jpg");
        ResultEntity<String> resultEntity = uploadFileToObs("https://obs.cn-south-1.myhuaweicloud.com",
                "C7MSZTKHGOAYXSVXQGZL",
                "0xh9SuIfOGDYzJgI8paIvywkojpWblgS2ijsuHll",
                fileInputStream,
                "myteam001",
                "https://myteam001.obs.cn-south-1.myhuaweicloud.com",
                "头像01.jpg");
        System.out.println(resultEntity);
    }


}
