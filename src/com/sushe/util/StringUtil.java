/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sushe.util;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.UUID;

//import org.apache.log4j.Logger;

/**
 * 
 * @author tanhui,linsitao
 */
public class StringUtil {

	// private static Logger logger = Logger.getLogger(StringUtil.class);
	/**
	 * 获取UUID字符串
	 * 
	 * @return
	 * @throws Exception
	 */
	public static final String getUUID() throws Exception {
		String str = UUID.randomUUID().toString();
		final String NEW_UUID = str.substring(0, 8) + str.substring(9, 13) + str.substring(14, 18) + str.substring(19, 23) + str.substring(24);
		return NEW_UUID;
	}

	/**
	 * @Title: getMD5
	 * @Description: (MD5加密静态方法)
	 * @param @param source
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @author
	 */
	public static String getMD5(String source) {
		String s = null;
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };// 用来将字节转换成16进制表示的字符
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(source.getBytes());
			// MD5 的计算结果是一个 128 位的长整数，
			byte tmp[] = md.digest();
			// 用字节表示就是 16 个字节
			// 每个字节用 16 进制表示的话，使用两个字符， 所以表示成 16
			char str[] = new char[16 * 2];
			// 进制需要 32 个字符
			// 表示转换结果中对应的字符位置
			int k = 0;
			// 从第一个字节开始，对 MD5 的每一个字节// 转换成 16
			for (int i = 0; i < 16; i++) {
				// 进制字符的转换
				// 取第 i 个字节
				byte byte0 = tmp[i];
				// 取字节中高 4 位的数字转换,// >>>
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				// 为逻辑右移，将符号位一起右移
				// 取字节中低 4 位的数字转换
				str[k++] = hexDigits[byte0 & 0xf];

			}
			// 换后的结果转换为字符串
			s = new String(str);

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			throw new RuntimeException("MD5加密失败!", e);
		}
		return s;
	}

	/**
	 * 生成AES加密密钥(key)
	 *
	 * @param str
	 * @return String
	 * @throws Exception
	 */
	public static String createAESKey(String str) {
		String s = null;
		char hexDigits[] = { '0', '1', 'A', '2', '3', '4', 'B', '5', 'C', '6', '7', 'D', '8', 'E', '9', 'F' };// 用来将字节转换成16进制表示的字符
		try {
			// str 转换成byte数组
			byte tmp[] = str.getBytes();
			// 用字节表示就是 16 个字节
			// 每个字节用 16 进制表示的话，使用两个字符， 所以表示成 16
			char strArr[] = new char[16];
			// 进制需要 32 个字符
			// 表示转换结果中对应的字符位置
			int k = 0;
			int j = 0;
			// 从第一个字节开始，对STR的每一个字节// 转换成 8
			for (int i = 0; i < 8; i++) {
				// 进制字符的转换
				// 取第 i 个字节
				if ((i + 1) >= tmp.length) {
					if ((i + 1) % tmp.length == 0) {
						j = 0;
					}
				}
				byte byte0 = tmp[j++];
				// 取字节中高 4 位的数字转换,// >>>
				strArr[k++] = hexDigits[byte0 >>> 4 & 0xf];
				// 为逻辑右移，将符号位一起右移
				// 取字节中低 4 位的数字转换
				strArr[k++] = hexDigits[byte0 & 0xf];

			}
			// 换后的结果转换为字符串
			s = new String(strArr);

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("生成AES加密密钥!", e);
		}
		return s;
	}

	/**
	 * AES加密程序
	 *
	 * @param sSrc
	 * @param sKey
	 * @return
	 * @throws Exception
	 */
	public static String encryptAES(String sSrc, String sKey) throws Exception {
		if (sKey == null) {
			// logger.error("AES加密,Key为空null");
			return null;
		}
		// 判断Key是否为16位
		if (sKey.length() != 16) {
			// logger.error("AES加密,Key长度不是16位");
			return null;
		}
		byte[] raw = sKey.getBytes("ASCII");
		SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
		byte[] encrypted = cipher.doFinal(sSrc.getBytes());
		return byte2hex(encrypted).toLowerCase();
	}

	/**
	 * AES解密程序
	 *
	 * @param sSrc
	 * @param sKey
	 * @return
	 * @throws Exception
	 */
	public static String decryptAES(String sSrc, String sKey) throws Exception {
		try {
			// 判断Key是否正确
			if (sKey == null) {
				// logger.error("AES加密,Key为空null");
				return null;
			}
			// 判断Key是否为16位
			if (sKey.length() != 16) {
				// logger.error("AES加密,Key长度不是16位");
				return null;
			}
			byte[] raw = sKey.getBytes("ASCII");
			SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.DECRYPT_MODE, skeySpec);
			byte[] encrypted1 = hex2byte(sSrc);
			try {
				byte[] original = cipher.doFinal(encrypted1);
				String originalString = new String(original);
				return originalString;
			} catch (Exception e) {
				System.out.println(e.toString());
				// logger.error("AES加密失败，消息："+e.getMessage());
				return null;
			}
		} catch (Exception ex) {
			System.out.println(ex.toString());
			// logger.error("AES加密失败，消息："+ex.getMessage());
			return null;
		}
	}

	/**
	 * SHA加密(SHA-256)
	 *
	 * @param plainText
	 *            需要加密的字符串
	 * @param algorithm
	 *            加密长度.默认设置为 SHA-256
	 * @return
	 */
	public static String encryptSHA(String plainText, String algorithm) throws NoSuchAlgorithmException, UnsupportedEncodingException {

		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance(algorithm);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		md.update(plainText.getBytes());
		byte[] b = md.digest();
		StringBuilder output = new StringBuilder(32);
		for (int i = 0; i < b.length; i++) {
			String temp = Integer.toHexString(b[i] & 0xff);
			if (temp.length() < 2) {
				output.append("0");
			}
			output.append(temp);
		}
		return output.toString();
	}

	/**
	 * 16位字符串转byte数组
	 *
	 * @param strhex
	 * @return
	 */
	public static byte[] hex2byte(String strhex) {
		if (strhex == null) {
			return null;
		}
		int l = strhex.length();
		if (l % 2 == 1) {
			return null;
		}
		byte[] b = new byte[l / 2];

		for (int i = 0; i != l / 2; i++) {
			b[i] = (byte) Integer.parseInt(strhex.substring(i * 2, i * 2 + 2), 16);
		}

		return b;
	}

	/**
	 * byte数组转16位字符串
	 *
	 * @param b
	 * @return
	 */
	public static String byte2hex(byte[] b) {
		String hs = "";
		String stmp = "";
		for (int n = 0; n < b.length; n++) {
			stmp = (Integer.toHexString(b[n] & 0XFF));
			if (stmp.length() == 1) {
				hs = hs + "0" + stmp;
			} else {
				hs = hs + stmp;
			}
		}
		return hs.toUpperCase();
	}

	/**
	 * 获取告警信息(按一定格式组织)
	 * 
	 * @param content
	 * @param user
	 * @param time
	 * @return
	 */
	public static String getAlert(String content, String user, String time) {
		StringBuffer msg = new StringBuffer();

		msg.append("<b>·提示信息：</b>");
		msg.append(content);
		msg.append("<br />");
		msg.append("<b>·操作人员：</b>");
		msg.append(user);
		msg.append("<br />");
		msg.append("<b>·操作时间：</b>");
		msg.append(time);

		return msg.toString();
	}

	public static Integer toInteger(String str) {
		return Integer.parseInt(str);

	}

	public static Long toLong(String str) {
		return Long.parseLong(str);
	}

	/**
	 * 创建密匙
	 * 
	 * @param algorithm
	 *            加密算法,可用 DES,DESede,Blowfish
	 * @return SecretKey 秘密（对称）密钥
	 */
	public static SecretKey createSecretKey(String algorithm) {
		// 声明KeyGenerator对象
		KeyGenerator keygen;
		// 声明 密钥对象
		SecretKey deskey = null;
		try {
			// 返回生成指定算法的秘密密钥的 KeyGenerator 对象
			keygen = KeyGenerator.getInstance(algorithm);
			// 生成一个密钥
			deskey = keygen.generateKey();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		// 返回密匙
		return deskey;
	}

	/**
	 * 根据密匙进行DES加密
	 * 
	 * @param key
	 *            密匙
	 * @param info
	 *            要加密的信息
	 * @return String 加密后的信息
	 */
	public static String encryptDES(SecretKey key, String info) {
		// 定义 加密算法,可用 DES,DESede,Blowfish
		String Algorithm = "DES";
		// 加密随机数生成器 (RNG),(可以不写)
		SecureRandom sr = new SecureRandom();
		// 定义要生成的密文
		byte[] cipherByte = null;
		try {
			// 得到加密/解密器
			Cipher c1 = Cipher.getInstance(Algorithm);
			// 用指定的密钥和模式初始化Cipher对象
			// 参数:(ENCRYPT_MODE, DECRYPT_MODE, WRAP_MODE,UNWRAP_MODE)
			c1.init(Cipher.ENCRYPT_MODE, key, sr);
			// 对要加密的内容进行编码处理,
			cipherByte = c1.doFinal(info.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 返回密文的十六进制形式
		return byte2hex(cipherByte);
	}

	/**
	 * 根据密匙进行DES解密
	 * 
	 * @param key
	 *            密匙
	 * @param sInfo
	 *            要解密的密文
	 * @return String 返回解密后信息
	 */
	public static String decryptDES(SecretKey key, String sInfo) {
		// 定义 加密算法,
		String Algorithm = "DES";
		// 加密随机数生成器 (RNG)
		SecureRandom sr = new SecureRandom();
		byte[] cipherByte = null;
		try {
			// 得到加密/解密器
			Cipher c1 = Cipher.getInstance(Algorithm);
			// 用指定的密钥和模式初始化Cipher对象
			c1.init(Cipher.DECRYPT_MODE, key, sr);
			// 对要解密的内容进行编码处理
			cipherByte = c1.doFinal(hex2byte(sInfo));
		} catch (Exception e) {
			e.printStackTrace();
		}
		// return byte2hex(cipherByte);
		return new String(cipherByte);
	}

	/***
	 * 获取对称数
	 * 
	 * @param s
	 * @return
	 */
	public static String getSymmetrical(String s) {
		int len = s.length();
		String str = "";
		for (int i = 0; i < len / 2; i++) {
			if (s.charAt(i) == s.charAt(len - i - 1)) {
				str = str + s.charAt(i);
				if (str.length() == 16) {
					break;
				}
			}

		}
		return str;
	}

	// 获取客户端IP地址
	public static String getIpAddr(HttpServletRequest req) {
		String ip = req.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = req.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = req.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = req.getRemoteAddr();
		}
		return ip;

	}

	// 测试程序
	public static void main(String args[]) {
		try {
			/*
			 * String str=
			 * "45efc33e4c8cf828836dfa1af02bf3f427d34591fc40f2a1150701d9e7927b8d|503a3dc79b04afa72f60a51420e9aeb4106e5a230ef463a780a8a065ca13a7b6fb12275de1cef5add5ffb597eac964908ef73b8c7f03371394bc9e9d40499f9c32fdb09e9aaeffb38858e6c68076bdf617b71d95aa5da165717c1dba4a805bd6d097be697c6dbcc9f6e46e086ba3cdcab79ae4ac72373163d9b20c40497da22bf9adcd5beaad8d9c6ebe1c7d3ee8347083edeb6279c8bffad66dc821fbc13ea3c2f943601af443c5e522fe66b95592b8ffb3b4d7a12c5a33a99ad724b979c4121f68b5470378e8469b396d4a00204bc2238dc40e8222fd21a325b08f7c97b6f9cc1aa24253dec323716eeb1d902617ce2a95f83abc5ca90ac21c6b5e246a7e1dcd80b8f02d626d5c824159b9b094713001d35d4db4196ccc23bfbb5b9031ce2109639dfaab46b304f42e1c49bbe19b7074a612a1c7d25424f89d36127a5b8ed624c6b525a19b9843bdc6d8ced0db595b48885f21a86c33744b7d057ef13189483664d0a3f9bf3373e317c595f88107e3123a886a5d1e443676a53c9911676924bfb104db73227f9d5626cc04f5715a688c9fb97e11a71c15a92139561a76e6160e44474a3b7ce788ac0997d54ce0a8fefb6f8c76822e83bda2df36f4ee794bff597aa9de96534a4215117705f98b15757c730263bb33dcb0c9f6515646c5e373cd80b8f02d626d5c824159b9b094713001d35d4db4196ccc23bfbb5b9031ce21659be119aa6493af27ccc85e87620c60dc0fa6a9d2b8e483d4e424b7f098ac7b49de670ce9e2a54df64e7f3c90fe925fcd80b8f02d626d5c824159b9b094713001d35d4db4196ccc23bfbb5b9031ce21659be119aa6493af27ccc85e87620c60575ea51b05a6b5026f7a7190645aa4431a7b8d249340364e55c6495ce56d72a55a49904cdcfca4d4e7ebc4fc54ef934a"
			 * ; String rs=getSymmetrical(str); System.out.println("rs_:" + rs);
			 * String name=encryptAES("Name2",rs); System.out.println("enName:"
			 * + name); String intr=StringUtil.encryptAES("简介",rs);
			 * System.out.println("enIntr:" + intr); //getEnPassword("简介",
			 * "E:\\CHENYAPENG\\workspace\\project\\src\\scdt\\WebContent")
			 */
			// System.out.println(getUUID());
			String decryptAES = decryptAES("173eed048c236c046d3c5a2b4cf3f47da5ab3c1b70e8c0b26a4425696bb672e366a9d670ec88e6cdce1eba2200e06ab7fdf282c6256347d55b767cfdc8374fa75f556f29927c394f69c6ac1345b24ecf0465db42e16f0624674ce0ea4b204b2887307dbe7989f447152ea22a4a9fbd43ec31d07b3c26d6c543734728fb0f9c44",
					createAESKey("1"));
			System.out.println("----decryptAES---- " + decryptAES);
			String[] split = decryptAES.split("&");
			System.out.println(split[3]);
		} catch (Exception e) {

		}
	}

}
