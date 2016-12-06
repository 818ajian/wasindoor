package com.waspring.wasservice.net.busii.area;

import java.sql.ResultSet;

import com.aiyc.framework.annotation.Requestable;
import com.aiyc.framework.utils.StringUtils;
import com.aiyc.server.standalone.json.GsonFactory;
import com.aiyc.server.standalone.net.IHandler;
import com.aiyc.server.standalone.net.Response;
import com.aiyc.server.standalone.net.Response.Status;
import com.google.gson.JsonElement;
import com.waspring.wasservice.net.dao.area.GraphDao;
import com.waspring.wasservice.net.model.CommonRepMessage;
import com.waspring.wasservice.net.model.area.SetGraphReqMessage;

@Requestable(serverName = "SET_GRAPH_REQ")
public class SetGraphHandler implements IHandler {
	private GraphDao dao = new GraphDao();

	public Response handle(JsonElement data) throws Exception {

		SetGraphReqMessage model = GsonFactory.getGsonInstance().fromJson(data,
				SetGraphReqMessage.class);
		CommonRepMessage rep = new CommonRepMessage();
		if (StringUtils.isNullOrBank(model.MESSAGE.MAP_NO)) {
			rep.RTN_FLAG = "0";
			rep.RTN_MSG = "��ͼ��ű��봫�룡";
			return new Response(Status.failed, rep.RTN_MSG, rep.toJson());
		}

		if (StringUtils.isNullOrBank(model.MESSAGE.MAP_URL)) {
			rep.RTN_FLAG = "0";
			rep.RTN_MSG = "��ͼURL���봫�룡";
			return new Response(Status.failed, rep.RTN_MSG, rep.toJson());
		}
		if (StringUtils.isNullOrBank(model.MESSAGE.MAP_BOUNDS)) {
			rep.RTN_FLAG = "0";
			rep.RTN_MSG = "��ͼ��Χ���봫�룡";
			return new Response(Status.failed, rep.RTN_MSG, rep.toJson());
		}
		
		if (StringUtils.isNullOrBank(model.MESSAGE.MAP_CENTER)) {
			rep.RTN_FLAG = "0";
			rep.RTN_MSG = "��ͼ����������봫�룡";
			return new Response(Status.failed, rep.RTN_MSG, rep.toJson());
		}
		
		if (model.MESSAGE.MAP_BOUNDS.split(",").length!=4) {
			rep.RTN_FLAG = "0";
			rep.RTN_MSG = "��ͼ��Χ�����д���";
			return new Response(Status.failed, rep.RTN_MSG, rep.toJson());
		}
		if (model.MESSAGE.MAP_CENTER.split(",").length!=4) {
			rep.RTN_FLAG = "0";
			rep.RTN_MSG = "��ͼ���������д���";
			return new Response(Status.failed, rep.RTN_MSG, rep.toJson());
		}
		ResultSet rs = dao.getGraph(model.MESSAGE.MAP_NO);
		if (rs.next()) {
			dao.delGraph(model.MESSAGE.MAP_NO);
		}

		dao.saveGraph(model);
		rep.RTN_FLAG = "1";
		rep.RTN_MSG = "�����ɹ���";
		return new Response(Status.ok, rep.RTN_MSG, rep.toJson());

	}

}
