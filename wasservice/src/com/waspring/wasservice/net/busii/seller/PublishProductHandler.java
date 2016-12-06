package com.waspring.wasservice.net.busii.seller;

import java.sql.ResultSet;
import java.util.Iterator;

import com.aiyc.framework.annotation.Requestable;
import com.aiyc.framework.utils.StringUtils;
import com.aiyc.server.standalone.json.GsonFactory;
import com.aiyc.server.standalone.net.IHandler;
import com.aiyc.server.standalone.net.Response;
import com.aiyc.server.standalone.net.Response.Status;
import com.google.gson.JsonElement;
import com.waspring.wasservice.net.dao.sell.SellerDao;
import com.waspring.wasservice.net.model.CommonRepMessage;
import com.waspring.wasservice.net.model.seller.GetProductRepMessage;
import com.waspring.wasservice.net.model.seller.PublishProductReqMessage;

@Requestable(serverName = "PUBULISH_PRODUCT_REQ")
public class PublishProductHandler implements IHandler {
	private SellerDao dao = new SellerDao();

	public Response handle(JsonElement data) throws Exception {
		PublishProductReqMessage model = GsonFactory.getGsonInstance()
				.fromJson(data, PublishProductReqMessage.class);

		CommonRepMessage rep = new CommonRepMessage();

		if (StringUtils.isNullOrBank(model.MESSAGE.SJ_NO)) {
			rep.RTN_FLAG = "0";
			rep.RTN_MSG = "�̼ұ�ű��봫�룡";
			return new Response(Status.failed, rep.RTN_MSG, rep.toJson());

		}

		ResultSet rs = dao.getSeller(model.MESSAGE.SJ_NO, null);
		if (rs != null && rs.next()) {

		} else {
			rep.RTN_FLAG = "0";
			rep.RTN_MSG = "�̼Ҳ����ڣ�";
			return new Response(Status.failed, rep.RTN_MSG, rep.toJson());

		}

		if (model.MESSAGE.CP_LIST.size() == 0) {
			rep.RTN_FLAG = "0";
			rep.RTN_MSG = "���봫���Ʒ��Ϣ��";
			return new Response(Status.failed, rep.RTN_MSG, rep.toJson());

		}

		Iterator<GetProductRepMessage> it = model.MESSAGE.CP_LIST.iterator();
		int  index=1;
		while (it.hasNext()) {
			GetProductRepMessage next = it.next();
			 if(StringUtils.isNullOrBank(next.CP_NAME)){
					rep.RTN_FLAG = "0";
					rep.RTN_MSG = "��Ʒ��Ϣ��"+index+"�У����봫���Ʒ���ƣ�";
					return new Response(Status.failed, rep.RTN_MSG, rep.toJson());
			 }
			 if(StringUtils.isNullOrBank(next.CP_DES)){
					rep.RTN_FLAG = "0";
					rep.RTN_MSG = "��Ʒ��Ϣ��"+index+"�У����봫���Ʒ������";
					return new Response(Status.failed, rep.RTN_MSG, rep.toJson());
			 }
			 if(StringUtils.isNullOrBank(next.CP_KEY)){
					rep.RTN_FLAG = "0";
					rep.RTN_MSG = "��Ʒ��Ϣ��"+index+"�У����봫���Ʒ�ؼ���CP_KEY��";
					return new Response(Status.failed, rep.RTN_MSG, rep.toJson());
			 }
			 
		 
			 
			index++;
		}
		
		
		dao.saveProduct(model);

		rep.RTN_FLAG = "1";
		rep.RTN_MSG = "�����ɹ���";
		return new Response(Status.ok, rep.RTN_MSG, rep.toJson());
	}

}
