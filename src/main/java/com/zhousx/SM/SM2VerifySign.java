package com.zhousx.SM;

import com.zhousx.util.HmacMD5;
import com.zhousx.util.HmacMD5;
import org.bouncycastle.asn1.*;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECPoint;

import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.util.Enumeration;


/**
 * 国密算法的签名、验签
 * @author 小帅丶
 * @类名称  SM2VerifySign
 * @remark 
 * @date  2017-8-16
 */
public class SM2VerifySign {
	/**
	 * 默认USERID
	 */
	public static String USER_ID = "1234567812345678";
	/**
	 * 私钥签名
	 * 使用SM3进行对明文数据计算一个摘要值
	 * @param privatekey 私钥
	 * @param sourceData 明文数据
	 * @return 签名后的值
	 * @throws Exception
	 */
	public static SM2SignVO Sign2SM2(byte[] privatekey,byte[] sourceData) throws Exception{
		SM2SignVO sm2SignVO = new SM2SignVO();
		sm2SignVO.setSm2_type("sign");
		SM2Factory factory = SM2Factory.getInstance();
		BigInteger userD = new  BigInteger(privatekey);
		System.out.println("userD:"+userD.toString(16));
		sm2SignVO.setSm2_userd(userD.toString(16));
		
		ECPoint userKey = factory.ecc_point_g.multiply(userD);
		System.out.println("椭圆曲线点X: "+ userKey.getXCoord().toBigInteger().toString(16));
		System.out.println("椭圆曲线点Y: "+ userKey.getYCoord().toBigInteger().toString(16));
		sm2SignVO.setX_coord(userKey.getXCoord().toBigInteger().toString(16));
		sm2SignVO.setY_coord(userKey.getYCoord().toBigInteger().toString(16));
		
		SM3Digest sm3Digest = new SM3Digest();
		byte [] z = factory.sm2GetZ(USER_ID.getBytes(), userKey);
		System.out.println("SM3摘要Z: " + Util.getHexString(z));
		System.out.println("被加密数据的16进制: " + Util.getHexString(sourceData));
		sm2SignVO.setSm3_z(Util.getHexString(z));
		sm2SignVO.setSign_express(Util.getHexString(sourceData));
		
		sm3Digest.update(z, 0, z.length);
		sm3Digest.update(sourceData,0,sourceData.length);
		byte [] md = new byte[32];
		sm3Digest.doFinal(md, 0);
		System.out.println("SM3摘要值: " + Util.getHexString(md));
		sm2SignVO.setSm3_digest(Util.getHexString(md));
		
		SM2Result sm2Result = new SM2Result();
		factory.sm2Sign(md, userD, userKey, sm2Result);
		System.out.println("r: " + sm2Result.r.toString(16));
		System.out.println("s: " + sm2Result.s.toString(16));
		sm2SignVO.setSign_r(sm2Result.r.toString(16));
		sm2SignVO.setSign_s(sm2Result.s.toString(16));
		
		ASN1Integer d_r = new ASN1Integer(sm2Result.r);
		ASN1Integer d_s = new ASN1Integer(sm2Result.s);
		ASN1EncodableVector v2 = new ASN1EncodableVector();
		v2.add(d_r);
		v2.add(d_s);
		DERSequence sign = new DERSequence(v2);
		String result = Util4Hex.bytesToHexString(sign.getEncoded());
		sm2SignVO.setSm2_sign(result);
		return sm2SignVO;
	}
	/**
	 * 验证签名
	 * @param publicKey 公钥信息
	 * @param sourceData 密文信息
	 * @param signData 签名信息
	 * @return 验签的对象 包含了相关参数和验签结果
	 */
	@SuppressWarnings("unchecked")
	public static SM2SignVO VerifySignSM2(byte[] publicKey,byte[] sourceData,byte[] signData){
		try {
		byte[] formatedPubKey;
		SM2SignVO verifyVo = new SM2SignVO();
		verifyVo.setSm2_type("verify");
		if (publicKey.length == 64) {
			// 添加一字节标识，用于ECPoint解析
			formatedPubKey = new byte[65];
			formatedPubKey[0] = 0x04;
			System.arraycopy(publicKey, 0, formatedPubKey, 1, publicKey.length);
		} else{
			formatedPubKey = publicKey;
		}
		SM2Factory factory = SM2Factory.getInstance();
		ECPoint userKey = factory.ecc_curve.decodePoint(formatedPubKey);
		
		SM3Digest sm3Digest = new SM3Digest();
		byte [] z = factory.sm2GetZ(USER_ID.getBytes(), userKey);
		System.out.println("SM3摘要Z: " + Util.getHexString(z));
		verifyVo.setSm3_z(Util.getHexString(z));
		sm3Digest.update(z,0,z.length);
		sm3Digest.update(sourceData,0,sourceData.length);
		byte [] md = new byte[32];
		sm3Digest.doFinal(md, 0);
		System.out.println("SM3摘要值: " + Util.getHexString(md));
		verifyVo.setSm3_digest(Util.getHexString(md));
		ByteArrayInputStream bis = new ByteArrayInputStream(signData);
		ASN1InputStream dis = new ASN1InputStream(bis);
		SM2Result sm2Result = null;
			ASN1Primitive derObj = dis.readObject();
			Enumeration<ASN1Integer> e = ((ASN1Sequence)derObj).getObjects();
			BigInteger r = ((ASN1Integer) e.nextElement()).getValue();
			BigInteger s = ((ASN1Integer) e.nextElement()).getValue();
			sm2Result = new SM2Result();
			sm2Result.r = r;
			sm2Result.s = s;
			System.out.println("vr: " + sm2Result.r.toString(16).toUpperCase());
			System.out.println("vs: " + sm2Result.s.toString(16).toUpperCase());
			verifyVo.setVerify_r(sm2Result.r.toString(16).toUpperCase());
			verifyVo.setVerify_s(sm2Result.s.toString(16).toUpperCase());
			factory.sm2Verify(md, userKey, sm2Result.r, sm2Result.s, sm2Result);
			boolean verifyFlag = sm2Result.r.equals(sm2Result.R);
			verifyVo.setVerify(verifyFlag);
			return  verifyVo;
		} catch (IllegalArgumentException e) {
			return null;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static SM2SignVO VerifySignSM22(byte[] publicKey,byte[] sourceData,String signData){
		try {
			byte[] formatedPubKey;
			SM2SignVO verifyVo = new SM2SignVO();
			verifyVo.setSm2_type("verify");
			if (publicKey.length == 64) {
				// 添加一字节标识，用于ECPoint解析
				formatedPubKey = new byte[65];
				formatedPubKey[0] = 0x04;
				System.arraycopy(publicKey, 0, formatedPubKey, 1, publicKey.length);
			} else{
				formatedPubKey = publicKey;
			}
			SM2Factory factory = SM2Factory.getInstance();
			ECPoint userKey = factory.ecc_curve.decodePoint(formatedPubKey);

			SM3Digest sm3Digest = new SM3Digest();
			byte [] z = factory.sm2GetZ(USER_ID.getBytes(), userKey);
//			System.out.println("SM3摘要Z: " + Util.getHexString(z));
			verifyVo.setSm3_z(Util.getHexString(z));
			sm3Digest.update(z,0,z.length);
			sm3Digest.update(sourceData,0,sourceData.length);
			byte [] md = new byte[32];
			sm3Digest.doFinal(md, 0);
//			System.out.println("SM3摘要值: " + Util.getHexString(md));
			verifyVo.setSm3_digest(Util.getHexString(md));


			SM2Result sm2Result = new SM2Result();
			sm2Result.r = new BigInteger(signData.substring(0,64),16);
			sm2Result.s = new BigInteger(signData.substring(64),16);
//			System.out.println("vr: " + sm2Result.r.toString(16).toUpperCase());
//			System.out.println("vs: " + sm2Result.s.toString(16).toUpperCase());
			verifyVo.setVerify_r(sm2Result.r.toString(16).toUpperCase());
			verifyVo.setVerify_s(sm2Result.s.toString(16).toUpperCase());
			factory.sm2Verify(md, userKey, sm2Result.r, sm2Result.s, sm2Result);
			boolean verifyFlag = sm2Result.r.equals(sm2Result.R);
			verifyVo.setVerify(verifyFlag);
			return  verifyVo;
		} catch (IllegalArgumentException e) {
			return null;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}




	public static String[] ecc_param = { "FFFFFFFEFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF00000000FFFFFFFFFFFFFFFF",
			"FFFFFFFEFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF00000000FFFFFFFFFFFFFFFC",
			"28E9FA9E9D9F5E344D5A9E4BCF6509A7F39789F515AB8F92DDBCBD414D940E93",
			"FFFFFFFEFFFFFFFFFFFFFFFFFFFFFFFF7203DF6B21C6052B53BBF40939D54123",
			"32C4AE2C1F1981195F9904466A39C9948FE30BBFF2660BE1715A4589334C74C7",
			"BC3736A2F4F6779C59BDCEE36B692153D0A9877CC62A474002DF32E52139F0A0" };

	public static String FromXGetY(String key){
		BigInteger ecc_p = new BigInteger(ecc_param[0], 16);// p
		BigInteger ecc_a = new BigInteger(ecc_param[1], 16);// a
		BigInteger ecc_b = new BigInteger(ecc_param[2], 16);// b
		ECCurve ecc_curve = new ECCurve.Fp(ecc_p, ecc_a, ecc_b);
		// 完整的公钥1B62C2D3CB8109EA6A29AF2BBD4F4FC0423F8D3C4C38342F10681C266E31852F266725C743B9373660549A8A0C64C7507457D8913A18D65404ECE27C1BF930F2
		// 压缩后的公钥
//		String key = "021B62C2D3CB8109EA6A29AF2BBD4F4FC0423F8D3C4C38342F10681C266E31852F";
		// 根据X恢复点Y，
		ECPoint point = ecc_curve.decodePoint(
				HmacMD5.hexToBytes(key));
		String y = point.getY().toBigInteger().toString(16).toUpperCase();
		// 原始公钥
//		System.out.println("原始公钥：" + key.substring(2, key.length()) + y);

		return key.substring(2, key.length()) + y;
	}
}
