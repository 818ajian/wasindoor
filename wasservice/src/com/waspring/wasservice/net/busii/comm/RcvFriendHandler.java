package com.waspring.wasservice.net.busii.comm;

import java.sql.ResultSet;

import com.aiyc.framework.annotation.Requestable;
import com.aiyc.framework.utils.StringUtils;
import com.aiyc.server.standalone.json.GsonFactory;
import com.aiyc.server.standalone.net.IHandler;
import com.aiyc.server.standalone.net.Response;
import com.aiyc.server.standalone.net.Response.Status;
import com.google.gson.JsonElement;
import com.waspring.wasservice.net.dao.comm.CommDao;
import com.waspring.wasservice.net.model.CommonRepMessage;
import com.waspring.wasservice.net.model.comm.AddFriendReqMessage;
import com.waspring.wasservice.net.model.comm.RcvFriendReqMessage;

/**
 * 
 * @author felly
 * 
 *
 */
@Requestable(serverName = "RCV_FREND_REQ")
public class RcvFriendHandler implements IHandler {
	private CommDao dao = new CommDao();

	public Response handle(JsonElement data) throws Exception {
		RcvFriendReqMessage model = GsonFactory.getGsonInstance().fromJson(
				data, RcvFriendReqMessage.class);
		CommonRepMessage rep = new CommonRepMessage();
		String reqNo = model.MESSAGE.REQ_NO;
		String rlt = model.MESSAGE.CONFIRM_RSLT;
		if ("".equals(StringUtils.nullToEmpty(reqNo))) {
			rep.RTN_FLAG = "0";
			rep.RTN_MSG = "������Ϊ�գ�";
			return new Response(Status.failed, rep.RTN_MSG, rep.toJson());
		}
		if ("".equals(StringUtils.nullToEmpty(rlt))) {
			rep.RTN_FLAG = "0";
			rep.RTN_MSG = "������Ϊ�գ�";
			return new Response(Status.failed, rep.RTN_MSG, rep.toJson());
		}

		// ////����������
		dao.rcvFriend(reqNo, rlt, model.MESSAGE.CONFU_RESON);
		// 02���ԣ�03ͬ�⣬04���ܾ�,05,ͬ�Ⲣ��ӶԷ�
		ResultSet rs = dao.queryAddFriendReq(reqNo);
		// //����������
		if ("05".equals(rlt)) {

			while (rs.next()) {
				AddFriendReqMessage add = new AddFriendReqMessage();
				add.MESSAGE.CONTENT_MSG = "";
				add.MESSAGE.RCVER_NO = rs.getString("SEND_USER_NO");
				add.MESSAGE.SEND_USER_NO = rs.getString("RCVER_NO");
				dao.addFriend(add);
			}
		}

		if ("05".equals(rlt) || "03".equals(rlt)) {
			rs.beforeFirst();
			while (rs.next()) {
				dao.addFreind(rs.getString("SEND_USER_NO"), rs
						.getString("RCVER_NO"));

				dao.addSysMsg(rs.getString("SEND_USER_NO"), rs
						.getString("RCVER_NO"), "��Ӻ���"
						+ rs.getString("RCV_NAME") + "�ɹ���");
			}

		}
		if ("04".equals(rlt)) {
			rs.beforeFirst();
			while (rs.next()) {
			dao.addSysMsg(rs.getString("SEND_USER_NO"), rs
					.getString("RCVER_NO"), "�û�" + rs.getString("RCV_NAME")
					+ "�ܾ����ܾ�ԭ��:" + rs.getString("CONFU_RESON"));
			}
		}

		rep.RTN_FLAG = "1";
		rep.RTN_MSG = "����ɹ���";

		return new Response(Status.ok, rep.RTN_MSG, rep.toJson());
	}

}
