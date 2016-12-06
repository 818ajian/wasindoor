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
import com.waspring.wasservice.net.model.area.SetAreaReqMessage;

@Requestable(serverName = "SET_AREA_REQ")
public class SetAreaHandler implements IHandler {
	private GraphDao dao = new GraphDao();

	public Response handle(JsonElement data) throws Exception {
		SetAreaReqMessage model = GsonFactory.getGsonInstance().fromJson(data,
				SetAreaReqMessage.class);

		CommonRepMessage rep = new CommonRepMessage();
		if (StringUtils.isNullOrBank(model.MESSAGE.AREA_NO)) {
			rep.RTN_FLAG = "0";
			rep.RTN_MSG = "������Ϊ��";
			return new Response(Status.ok, rep.RTN_MSG, rep.toJson());
		}
		if (StringUtils.isNullOrBank(model.MESSAGE.AREA_NAME)) {
			rep.RTN_FLAG = "0";
			rep.RTN_MSG = "��������Ϊ��";
			return new Response(Status.ok, rep.RTN_MSG, rep.toJson());
		}
		if (StringUtils.isNullOrBank(model.MESSAGE.AREA_TYPE)) {
			rep.RTN_FLAG = "0";
			rep.RTN_MSG = "��������Ϊ��";
			return new Response(Status.ok, rep.RTN_MSG, rep.toJson());
		}
		ResultSet rs = dao.getAreaInfo(model.MESSAGE.AREA_NO);
		if (rs.next()) {
			dao.delArea(model.MESSAGE.AREA_NO, false);
		}
		dao.saveAreaInfo(model);

		rep.RTN_FLAG = "1";
		rep.RTN_MSG = "�����ɹ���";
		return new Response(Status.ok, rep.RTN_MSG, rep.toJson());

	}
}
