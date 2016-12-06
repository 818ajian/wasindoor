package com.waspring.wasservice.net.model.seller;

import java.util.ArrayList;
import java.util.List;

import com.waspring.wasservice.net.model.CommonRepMessage;

public class SearchCouponRepMessage extends CommonRepMessage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public List<DataList> DATA_LIST = new ArrayList<DataList>();

	public static class DataList {
		public String coupon_id;// �Ż�ȯID int
		public String title;// �Ż�ȯ���� string
		public String description;// �Ż�ȯ���� string
		public String regions;// �Ż�ȯ�����̻����������� list
		public String categories;// �Ż�ȯ�������� list
		public String download_count;// �Ż�ȯ��ǰ�������� int
		public String publish_date;// �Ż�ȯ������������ string
		public String expiration_date;// �Ż�ȯ�Ľ�ֹʹ������ string
		public String distance;// �Ż�ȯ�������̻��о����������������һ���������ľ��� int
		public String logo_img_url;// �Ż�ȯ��ͼ�� string
		public String coupon_url;// �Ż�ȯWebҳ������ string
		public String coupon_h5_url;// �Ż�ȯHTML5ҳ������ string
		public String area_no;// ������ string ������
		public String build_no;// ������� string �������
		public String floor_no;// ¥���� string ¥����
		public String door_no;// ������ string ������

		public String business_id;// �̻�ID int �̻�ID
		public String business_name;// �̻��� string �̻���

	}
}
