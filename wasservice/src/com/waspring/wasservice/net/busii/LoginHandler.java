package com.waspring.wasservice.net.busii;

import java.math.BigInteger;
import java.sql.ResultSet;

import com.aiyc.framework.annotation.Requestable;
import com.aiyc.server.standalone.json.GsonFactory;
import com.aiyc.server.standalone.net.IHandler;
import com.aiyc.server.standalone.net.Response;
import com.aiyc.server.standalone.net.Response.Status;
import com.google.gson.JsonElement;
import com.waspring.wasservice.net.dao.LoginDao;
import com.waspring.wasservice.net.model.LoginRepMessage;
import com.waspring.wasservice.net.model.LoginReqMessage;

/**
 * ��¼
 * 
 * @author felly
 * 
 */
@Requestable(serverName = "LOGIN_REQ")
public class LoginHandler implements IHandler {

	public static String md5(String userPass) throws Exception {

		java.security.MessageDigest md5 = java.security.MessageDigest
				.getInstance("MD5");
		md5.update(userPass.getBytes());

		byte b[] = md5.digest();

		return new BigInteger(b).toString(16);
	}

 

	private LoginDao dao = new LoginDao();

	public Response handle(JsonElement data) throws Exception {
		Response res;

		LoginReqMessage loc = GsonFactory.getGsonInstance().fromJson(data,
				LoginReqMessage.class);
		String clientNo = "";
		ResultSet rs = dao.queryUser(loc.MESSAGE.USER_NO, loc.MESSAGE.USER_PWD);
		if (rs.next()) {
			clientNo = rs.getString("user_id");
		}

		LoginRepMessage rm = new LoginRepMessage();
		rm.CLIENTNO = clientNo;
		if (clientNo == null || "".equals(clientNo)) {
			rm.RTN_FLAG = "0";
			rm.RTN_MSG="��¼ʧ�ܣ��û��������벻��ȷ��";
			res = new Response(Status.failed, "��¼ʧ�ܣ��û��������벻��ȷ��", null);
		} else {
			rm.RTN_FLAG = "1";
           rm.RTN_MSG="�����ɹ���";
			res = new Response(Status.ok, "��¼�ɹ���", rm.toJson());
		}

		return res;
	}

}
