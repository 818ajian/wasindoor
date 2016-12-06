package com.aiyc.framework.utils;

import java.net.InetAddress;

public class UUIDHexGenerator {

	private String sep = "";
	private static final int IP;
	private static short counter = (short) 0;
	private static final int JVM = (int) (System.currentTimeMillis() >>> 8); // ȡ��jvm
																				// ����ʱ�ĵ�ǰ���������޷�������8λ

	private static UUIDHexGenerator uuidgen = new UUIDHexGenerator();

	static {
		int ipadd;
		try {
			ipadd = toInt(InetAddress.getLocalHost().getAddress());
		} catch (Exception e) {
			ipadd = 0;
		}
		IP = ipadd; // ��ȡ�ͻ��˵�ip��
	}

	public static UUIDHexGenerator getInstance() {
		return uuidgen;
	}

	// �ֽ�ת����int��
	public static int toInt(byte[] bytes) {
		int result = 0;
		for (int i = 0; i < 4; i++) {
			result = (result << 8) - Byte.MIN_VALUE + (int) bytes[i];
		}
		return result;
	}

	// ���ε����ֽ���16���л���Ȼ���ڽ����ַ���ת��
	protected String format(int intval) {
		String formatted = Integer.toHexString(intval);
		StringBuffer buf = new StringBuffer("00000000");
		buf.replace(8 - formatted.length(), 8, formatted);
		return buf.toString();
	}

	// �����ε����ֽ���16���л���Ȼ���ڽ����ַ���ת��
	protected String format(short shortval) {
		String formatted = Integer.toHexString(shortval);
		StringBuffer buf = new StringBuffer("0000");
		buf.replace(4 - formatted.length(), 4, formatted);
		return buf.toString();
	}

	protected int getJVM() {
		return JVM;
	}

	// ��ȡ��������ֵ
	protected synchronized short getCount() {
		if (counter < 0) {
			counter = 0;
		}
		return counter++;
	}

	protected int getIP() {
		return IP;
	}

	// ��ȡ��ǰʱ�������������
	protected short getHiTime() {
		return (short) (System.currentTimeMillis() >>> 32);
	}

	// ��ȡ��ǰʱ�������������
	protected int getLoTime() {
		return (int) System.currentTimeMillis();
	}

	// ��ĸ��ַ��������ϡ�
	public String generate() {
		return new StringBuffer(36).append(format(getIP())).append(sep).append(
				format(getJVM())).append(sep).append(format(getHiTime()))
				.append(sep).append(format(getLoTime())).append(sep).append(
						format(getCount())).toString();
	}
}
