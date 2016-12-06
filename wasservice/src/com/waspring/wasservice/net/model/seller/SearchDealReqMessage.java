package com.waspring.wasservice.net.model.seller;

import com.waspring.wasservice.net.model.BaseObject;

public class SearchDealReqMessage extends BaseObject {

	public Message MESSAGE = new Message();

	public static class Message {
		public String deal_id;//
		public String latitude;// γ������ float γ�����꣬���뾭������ͬʱ���룬��������ƶ��߱�ѡ��һ����
		public String longitude;// �������� float �������꣬����γ������ͬʱ���룬��������ƶ��߱�ѡ��һ����
		public String radius;// �����뾶 int �����뾶����λΪ�ף���Сֵ1�����ֵ5000���粻����Ĭ��Ϊ1000
		public String area_no;// ������ string ������(��γ��û�д��������±��봫��)
		public String build_no;// ������� string �������
		public String floor_no;// ¥���� string ¥����
		public String door_no;// ������ string ������
		public String region;// ���������� string
		// ��������������ѡ��Χ�����API���ؽ�����������ؽ���а����ĳ���������Ϣ�����紫���������������������Ʊ��봫��
		public String category;// ������ string
		// ����������ѡ��Χ�����API���ؽ����֧��ͬʱ���������࣬�Զ��ŷָ�����󲻳���5����
		public String keyword;// �ؼ��� string �ؼ��ʣ�������Χ�����̻�������ַ����ǩ��
		public String is_local;// �Ƿ��Ǳ��ص���ɸѡ int �����Ƿ��Ǳ��ص���ɸѡ���ص��Ź���1:�ǣ�0:����

		public String sort;// ������� int
		// �������1:Ĭ�ϣ�2:�Ǽ������ȣ�3:��Ʒ���۸����ȣ�4:�������۸����ȣ�5:�������۸����ȣ�6:�������������ȣ�7:�봫�뾭γ�������������ȣ�8:�˾��۸�����ȣ�9���˾��۸������
		public String limit;// �����Ŀ������ int ÿҳ���ص��̻������Ŀ�����ޣ���Сֵ1�����ֵ40���粻����Ĭ��Ϊ20
		public String page;// ҳ�� int ҳ�룬�粻����Ĭ��Ϊ1������һҳ

	}

}
