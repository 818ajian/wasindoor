package com.waspring.wasservice.net.busii;

import com.aiyc.framework.annotation.Requestable;
import com.aiyc.server.standalone.json.GsonFactory;
import com.aiyc.server.standalone.net.IHandler;
import com.aiyc.server.standalone.net.Response;
import com.aiyc.server.standalone.net.Response.Status;
import com.google.gson.JsonElement;
import com.waspring.wasservice.net.dao.UserDao;
import com.waspring.wasservice.net.model.GetUserRepMessage;
import com.waspring.wasservice.net.model.GetUserReqMessage;

/**
 * ��ȡ�û���Ϣ
 * 
 * @author felly
 * 
 */
@Requestable(serverName = "GET_USERINFO_REQ")
public class GetUserHandler implements IHandler {
	private UserDao dao = new UserDao();

	public Response handle(JsonElement data) throws Exception {
		Response res;

		GetUserReqMessage loc = GsonFactory.getGsonInstance().fromJson(data,
				GetUserReqMessage.class);
		GetUserRepMessage rm = dao.getUser(loc.MESSAGE.USER_NO);

		res = new Response(Status.ok, rm.RTN_MSG, rm.toJson());

		return res;
	}
	
	

}
