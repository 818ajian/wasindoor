package com.waspring.wasservice.net.busii.msg;

import com.aiyc.framework.annotation.Requestable;
import com.aiyc.framework.utils.StringUtils;
import com.aiyc.server.standalone.json.GsonFactory;
import com.aiyc.server.standalone.net.IHandler;
import com.aiyc.server.standalone.net.Response;
import com.aiyc.server.standalone.net.Response.Status;
import com.google.gson.JsonElement;
import com.waspring.wasservice.net.dao.msg.MsgDao;
import com.waspring.wasservice.net.model.CommonRepMessage;
import com.waspring.wasservice.net.model.msg.SendGroupMsgReqMessage;

/**
 * 5.1.7.2.3 Ⱥ����Ϣ���� �������� SET_GROUPMSG_REQ/Ⱥ����Ϣ��������
 * 
 * 
 * @author felly
 * 
 */
@Requestable(serverName = "SET_GROUPMSG_REQ")
public class SendGroupMsgHander implements IHandler {
	private MsgDao dao = new MsgDao();

	public Response handle(JsonElement data) throws Exception {
		SendGroupMsgReqMessage model = GsonFactory.getGsonInstance().fromJson(
				data, SendGroupMsgReqMessage.class);
		CommonRepMessage rm = new CommonRepMessage();
		if (StringUtils.isNullOrBank(model.MESSAGE.SENDER_NO)) {
			rm.RTN_FLAG = "0";
			rm.RTN_MSG = "�����˱��봫�룡";
			return new Response(Status.failed, rm.RTN_MSG, rm.toJson());
		}
		if (StringUtils.isNullOrBank(model.MESSAGE.GROUP_ID)) {
			rm.RTN_FLAG = "0";
			rm.RTN_MSG = "���봫��Ⱥ���ţ�";
			return new Response(Status.failed, rm.RTN_MSG, rm.toJson());
		}

		if (StringUtils.isNullOrBank(model.MESSAGE.CONTENT_MSG)) {
			rm.RTN_FLAG = "0";
			rm.RTN_MSG = "��Ϣ���ݱ��봫�룡";
			return new Response(Status.failed, rm.RTN_MSG, rm.toJson());
		}

		String id = dao.saveGroupMsg(model);
		dao.saveGroupMsgStatus(id, model);
		rm.RTN_FLAG = "1";
		rm.RTN_MSG = "���ͳɹ���";

		return new Response(Status.ok, rm.RTN_MSG, rm.toJson());

	}

}
