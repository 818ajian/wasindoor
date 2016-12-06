package com.waspring.wasservice.net.model.seller;

import java.util.ArrayList;
import java.util.List;

import com.waspring.wasservice.net.model.CommonRepMessage;

public class SearchSjRepMessage extends CommonRepMessage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public List<DataList> DATA_LIST = new ArrayList<DataList>();

	public static class DataList {
		public String avg_price;// �˾��۸� int �˾��۸񣬵�λ:Ԫ����û���˾�������-1
		public String review_count;// �������� int ��������
		public String review_list_url;// ����ҳ��URL���� list ����ҳ��URL����
		public String distance;// �̻����������ľ��� int
		// �̻����������ľ��룬��λΪ�ף��粻���뾭γ�����꣬���Ϊ-1
		public String business_url;// �̻�ҳ������ string �̻�ҳ������
		public String photo_url;// ��Ƭ���� string ��Ƭ���ӣ���Ƭ���ߴ�700��700
		public String s_photo_url;// С�ߴ���Ƭ���� string С�ߴ���Ƭ���ӣ���Ƭ���ߴ�278��200
		public String photo_count;// ��Ƭ���� int ��Ƭ����
		public String photo_list_url;// ��Ƭҳ��URL���� list ��Ƭҳ��URL����
		public String has_coupon;// �Ƿ����Ż�ȯ int �Ƿ����Ż�ȯ��0:û�У�1:��
		public String coupon_id;// �Ż�ȯID int �Ż�ȯID
		public String coupon_description;// �Ż�ȯ���� string �Ż�ȯ����
		public String coupon_url;// �Ż�ȯҳ������ string �Ż�ȯҳ������
		public String has_deal;// �Ƿ����Ź� int �Ƿ����Ź���0:û�У�1:��
		public String deal_count;// �̻���ǰ�����Ź����� int �̻���ǰ�����Ź�����
		public List<Deal> deals = new ArrayList<Deal>(); // �Ź��б� list �Ź��б�

		public String has_online_reservation;// �Ƿ�������Ԥ�� int �Ƿ�������Ԥ����0:û�У�1:��
		public String online_reservation_url;// ����Ԥ��ҳ������ string
		// ����Ԥ��ҳ�����ӣ�Ŀǰ������HTML5վ������
		public String business_id;// �̻�ID int �̻�ID
		public String name;// �̻��� string �̻���
		public String branch_name;// �ֵ��� string �ֵ���
		public String address;// ��ַ string ��ַ
		public String telephone;// �����ŵĵ绰 string �����ŵĵ绰
		public String city;// ���ڳ��� string ���ڳ���
		public String regions;// ����������Ϣ�б� list ����������Ϣ�б���[���������һ�]
		public String categories;// ����������Ϣ�б� list ����������Ϣ�б���[�����ˣ�����Ƶ�]
		public String latitude;// γ������ float γ������
		public String longitude;// �������� float ��������
		public String avg_rating;// �Ǽ����� float �Ǽ����֣�5.0�������ǣ�4.5�������ǰ룬��������
		public String rating_img_url;// �Ǽ�ͼƬ���� string �Ǽ�ͼƬ����
		public String rating_s_img_url;// С�ߴ��Ǽ�ͼƬ���� string С�ߴ��Ǽ�ͼƬ����
		public String product_grade;// ��Ʒ/ʳƷ��ζ���� int
		// ��Ʒ/ʳƷ��ζ���ۣ�1:һ�㣬2:�пɣ�3:�ã�4:�ܺã�5:�ǳ���
		public String decoration_grade;// �������� int
		// �������ۣ�1:һ�㣬2:�пɣ�3:�ã�4:�ܺã�5:�ǳ���
		public String service_grade;// �������� int �������ۣ�1:һ�㣬2:�пɣ�3:�ã�4:�ܺã�5:�ǳ���
		public String product_score;// ��Ʒ/ʳƷ��ζ���۵���� float
		// ��Ʒ/ʳƷ��ζ���۵���֣���ȷ��С�����һλ��ʮ���ƣ�
		public String decoration_score;// �������۵���� float �������۵���֣���ȷ��С�����һλ��ʮ���ƣ�
		public String service_score;// �������۵���� float �������۵���֣���ȷ��С�����һλ��ʮ���ƣ�
		public String area_no;// ������ string ������
		public String build_no;// ������� string �������
		public String floor_no;// ¥���� string ¥����
		public String door_no;// ������ string ������

		public static class Deal {
			public String id;// /�Ź�ID string �Ź�ID
			public String description;// �Ź����� string �Ź�����
			public String url;// �Ź�ҳ������ string �Ź�ҳ������
		}

	}
}
