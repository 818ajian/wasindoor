package com.waspring.wasservice.net.busii.comm;

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
/**
 * 
 * @author felly
 *
 */
@Requestable(serverName = "ADD_FREND_REQ")
public class AddFriendHandler implements IHandler {
	private CommDao dao = new CommDao();

	
	/**
	 * 
	 */
	public Response handle(JsonElement data) throws Exception {
		AddFriendReqMessage model = GsonFactory.getGsonInstance().fromJson(
				data, AddFriendReqMessage.class);
		CommonRepMessage rep = new CommonRepMessage();
        String sendNo=model.MESSAGE.SEND_USER_NO;
        String rcvNo=model.MESSAGE.RCVER_NO;
        if(StringUtils.isNullOrBank(sendNo)){
        	rep.RTN_FLAG = "0";
    		rep.RTN_MSG = "�����˲���Ϊ�գ�";
    		return new Response(Status.failed, rep.RTN_MSG, rep.toJson());
        }
        if(StringUtils.isNullOrBank(rcvNo)){
        	rep.RTN_FLAG = "0";
    		rep.RTN_MSG = "����������û�Ŷ";
    		return new Response(Status.failed, rep.RTN_MSG, rep.toJson());
        }
        
        /////�жϷ������Ƿ�Ϸ��û�
        
        if(!dao.haveUser(sendNo)){
        	rep.RTN_FLAG = "0";
    		rep.RTN_MSG = "�����˲��Ϸ���";
    		return new Response(Status.failed, rep.RTN_MSG, rep.toJson());
        }
        if(!dao.haveUser(rcvNo)){
        	rep.RTN_FLAG = "0";
    		rep.RTN_MSG = "���Ѳ����ڣ�";
    		return new Response(Status.failed, rep.RTN_MSG, rep.toJson());
        }
        /**
         * �ж��Ƿ��Ѿ��Ǻ�����
         */
        
        if(dao.isFriend(sendNo, rcvNo)){
        	rep.RTN_FLAG = "0";
    		rep.RTN_MSG = "�����Ѿ��Ǻ����ˣ�";
    		return new Response(Status.failed, rep.RTN_MSG, rep.toJson());
        }
        
		dao.addFriend(model);
	
		rep.RTN_FLAG = "1";
		rep.RTN_MSG = "�����ɹ���";
		return new Response(Status.ok, rep.RTN_MSG, rep.toJson());
	}

}
