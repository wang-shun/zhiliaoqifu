package com.ebeijia.zl.service.account.utils;
import java.security.MessageDigest;
import java.util.UUID;

import org.apache.commons.codec.binary.Hex;
 
/**
 * 
* 
* @ClassName: CodeEncryUtils.java
* @Description: 金额加密工具类
*
* @version: v1.0.0
* @author: zhuqi
* @date: 2018年11月30日 下午9:33:36 
*
* Modification History:
* Date         Author          Version
*-------------------------------------*
* 2018年11月30日     zhuqi           v1.0.0
 */
public class CodeEncryUtils {
	
	  public static String generate(String code,String salt) {  
		  code = md5Hex(code + salt);  
          char[] cs = new char[48];  
          for (int i = 0; i < 48; i += 3) {  
              cs[i] = code.charAt(i / 3 * 2);  
              char c = salt.charAt(i / 3);  
              cs[i + 1] = c;  
              cs[i + 2] = code.charAt(i / 3 * 2 + 1);  
          }  
          return new String(cs);  
      }  
	  /**  
       * 获取十六进制字符串形式的MD5摘要  
       */  
      private static String md5Hex(String src) {  
          try {  
              MessageDigest md5 = MessageDigest.getInstance("MD5");  
              byte[] bs = md5.digest(src.getBytes());  
              return new String(new Hex().encode(bs));  
          } catch (Exception e) {  
              return null;  
          }  
      } 
      public static boolean verify(String code,String salt, String md5Str) {  
          char[] cs1 = new char[32];  
          for (int i = 0; i < 48; i += 3) {  
              cs1[i / 3 * 2] = md5Str.charAt(i);  
              cs1[i / 3 * 2 + 1] = md5Str.charAt(i + 2);  
          }  
          return md5Hex(code + salt).equals(new String(cs1));  
      }  
      
      public static void main(String[] args) {
    	  	String uuid="1be66f49-b204-47d7-a805-c83c2c1f2685";
    	    String ss = CodeEncryUtils.generate("-10000000.0000",uuid);
            System.out.println(ss);
		    System.out.println("是否是同一字符串："+CodeEncryUtils.verify("-20.0000",uuid,ss));
	}
	 
}