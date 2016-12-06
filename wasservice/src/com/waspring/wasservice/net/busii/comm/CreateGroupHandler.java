package com.waspring.wasservice.net.busii.comm;

import com.aiyc.framework.annotation.Requestable;
import com.aiyc.framework.utils.StringUtils;
import com.aiyc.server.standalone.json.GsonFactory;
import com.aiyc.server.standalone.net.IHandler;
import com.aiyc.server.standalone.net.Response;
import com.aiyc.server.standalone.net.Response.Status;
import com.google.gson.JsonElement;
import com.waspring.wasservice.net.dao.comm.GroupDao;
import com.waspring.wasservice.net.model.comm.CreateGroupRepMessage;
import com.waspring.wasservice.net.model.comm.CreateGroupReqMessage;

/**
 * ��Ⱥ
 * 
 * @author felly
 * 
 */
@Requestable(serverName = "CREATE_GROUP_REQ")
public class CreateGroupHandler implements IHandler {
	private GroupDao dao = new GroupDao();

	public Response handle(JsonElement data) throws Exception {
		CreateGroupReqMessage model =GsonFactory.getGsonInstance().fromJson(
				data, CreateGroupReqMessage.class);
		CreateGroupRepMessage rep = new CreateGroupRepMessage();
		if ("".equals(StringUtils.nullToEmpty(model.MESSAGE.GROUP_NO))) {
			rep.RTN_FLAG = "0";
			rep.RTN_MSG = "��Ⱥ�˱��봫�룡";
			return new Response(Status.failed, rep.RTN_MSG, rep.toJson());
		}
		if ("".equals(StringUtils.nullToEmpty(model.MESSAGE.GROUP_NAME))) {
			rep.RTN_FLAG = "0";
			rep.RTN_MSG = "Ⱥ�����Ʊ��봫�룡";
			return new Response(Status.failed, rep.RTN_MSG, rep.toJson());
		}

		String groupId = dao.createGroup(model);
		rep.RTN_FLAG = "1";
		rep.RTN_MSG = "�����ɹ���";
		rep.GROUP_ID = groupId;
		return new Response(Status.ok, rep.RTN_MSG, rep.toJson());
	}

}
