package com.waspring.wasservice.net.busii;

import com.aiyc.framework.annotation.Requestable;
import com.aiyc.server.standalone.json.GsonFactory;
import com.aiyc.server.standalone.net.IHandler;
import com.aiyc.server.standalone.net.Response;
import com.aiyc.server.standalone.net.Response.Status;
import com.google.gson.JsonElement;
import com.waspring.wasservice.net.dao.ModifyPassDao;
import com.waspring.wasservice.net.model.CommonRepMessage;
import com.waspring.wasservice.net.model.ModifyPassReqMessage;

/**
 * �޸�����
 * 
 * @author felly
 * 
 */
@Requestable(serverName = "MODIFY_PASSWORD_REQ")
public class ModifyPassHandler implements IHandler {
	private ModifyPassDao dao = new ModifyPassDao();

	public Response handle(JsonElement data) throws Exception {
		Response res;

		ModifyPassReqMessage loc = GsonFactory.getGsonInstance().fromJson(data,
				ModifyPassReqMessage.class);
		CommonRepMessage rm = new CommonRepMessage();

		if (!dao.oldPassOK(loc.MESSAGE.USER_NO, loc.MESSAGE.OLD_PWD)) {

			rm.RTN_FLAG = "0";
			rm.RTN_MSG = "�޸�ʧ�ܣ��������������";
		res = new Response(Status.failed, rm.RTN_MSG, rm.toJson());

		}

		else {

			dao.modifyPass(loc.MESSAGE.USER_NO, loc.MESSAGE.NEW_PWD);
			rm.RTN_FLAG = "1";
			rm.RTN_MSG = "�����ɹ���";
		res = new Response(Status.ok, rm.RTN_MSG, rm.toJson());
		}



		return res;
	}

}
