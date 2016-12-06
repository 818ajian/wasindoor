package com.waspring.wasservice.net.busii.comm;

import com.aiyc.framework.annotation.Requestable;
import com.aiyc.server.standalone.json.GsonFactory;
import com.aiyc.server.standalone.net.IHandler;
import com.aiyc.server.standalone.net.Response;
import com.aiyc.server.standalone.net.Response.Status;
import com.google.gson.JsonElement;
import com.waspring.wasservice.net.dao.comm.CommDao;
import com.waspring.wasservice.net.model.CommonRepMessage;
import com.waspring.wasservice.net.model.comm.DelFriendReqMessage;

/**
 * 
 * @author felly
 * 
 */
@Requestable(serverName = "DEL_FREND_REQ")
public class DelFriendHandler implements IHandler {
	private CommDao dao = new CommDao();

	/**
	 * 
	 */
	public Response handle(JsonElement data) throws Exception {
		DelFriendReqMessage model = GsonFactory.getGsonInstance().fromJson(
				data, DelFriendReqMessage.class);
		// /////��������ϵ

		dao.delFreind(model.MESSAGE.SEND_USER_NO, model.MESSAGE.DEL_USER_NO,
				model.MESSAGE.DEL_REASON);

		CommonRepMessage rep = new CommonRepMessage();
		rep.RTN_FLAG = "1";
		rep.RTN_MSG = "�����ɹ���";
		return new Response(Status.ok, rep.RTN_MSG, rep.toJson());
	}

}
