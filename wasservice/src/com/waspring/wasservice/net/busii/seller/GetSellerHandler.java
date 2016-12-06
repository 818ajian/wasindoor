package com.waspring.wasservice.net.busii.seller;

import java.util.List;

import com.aiyc.framework.annotation.Requestable;
import com.aiyc.framework.utils.ResultToObject;
import com.aiyc.framework.utils.StringUtils;
import com.aiyc.server.standalone.json.GsonFactory;
import com.aiyc.server.standalone.net.IHandler;
import com.aiyc.server.standalone.net.Response;
import com.aiyc.server.standalone.net.Response.Status;
import com.google.gson.JsonElement;
import com.waspring.wasservice.net.dao.sell.SellerDao;
import com.waspring.wasservice.net.model.seller.GetSellerListRepMessage;
import com.waspring.wasservice.net.model.seller.GetSellerRepMessage;
import com.waspring.wasservice.net.model.seller.GetSellerReqMessage;

/**
 * ��ȡ�̼���Ϣ
 * 
 * @author felly
 * 
 */
@Requestable(serverName = "GET_SJ_REQ")
public class GetSellerHandler implements IHandler {
	private SellerDao dao = new SellerDao();

	public Response handle(JsonElement data) throws Exception {
		Response res;

		GetSellerReqMessage model = GsonFactory.getGsonInstance().fromJson(
				data, GetSellerReqMessage.class);
		GetSellerListRepMessage rm = new GetSellerListRepMessage();
		System.out.println(model.MESSAGE.KEY+":"+model.MESSAGE.SJ_NO);
		if (StringUtils.isNullOrBank(model.MESSAGE.KEY)
				&& StringUtils.isNullOrBank(model.MESSAGE.SJ_NO)) {
			rm.RTN_FLAG = "0";
			rm.RTN_MSG = "�ؼ��ֺ��̼ұ�ű�����������һ�";
			return new Response(Status.failed, rm.RTN_MSG, rm.toJson());
		}
		
		List<GetSellerRepMessage> rst=ResultToObject.resultToBase(GetSellerRepMessage.class
				, dao.getSeller(model.MESSAGE.SJ_NO, model.MESSAGE.KEY));
		
		if(rst.size()>0){
        rm.SJ_LIST=rst;
		rm.RTN_FLAG = "1";
		rm.RTN_MSG = "��ѯ�ɹ���";
		return new Response(Status.ok, rm.RTN_MSG, rm.toJson());
		}
		else{
			rm.RTN_FLAG = "0";
			rm.RTN_MSG = "��ѯʧ��,�̼Ҳ����ڣ�";
			return new Response(Status.failed, rm.RTN_MSG, rm.toJson());
		}

	}

}
