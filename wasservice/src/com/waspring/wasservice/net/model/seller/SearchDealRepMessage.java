package com.waspring.wasservice.net.model.seller;

import java.util.ArrayList;
import java.util.List;

import com.waspring.wasservice.net.model.CommonRepMessage;

public class SearchDealRepMessage extends CommonRepMessage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public List<DataList> DATA_LIST = new ArrayList<DataList>();

	public static class DataList {
		public String deal_id;// �Ź���ID string �Ź���ID
		public String title;// �Ź����� string �Ź�����
		public String description;// �Ź����� string �Ź�����
		public String list_price;// �Ź�������Ʒԭ��ֵ float �Ź�������Ʒԭ��ֵ
		public String current_price;// �Ź��۸� float �Ź��۸�
		public String regions;// �Ź������̻����������� list �Ź������̻�����������
		public String categories;// �Ź��������� list �Ź���������
		public String purchase_count;// �Ź���ǰ�ѹ����� int �Ź���ǰ�ѹ�����
		public String publish_date;// �Ź������������� string �Ź�������������
		public String purchase_deadline;// �Ź����Ľ�ֹ�������� string �Ź����Ľ�ֹ��������
		public String distance;// �Ź����������̻��о����������������һ���������ľ��� int
								// �Ź����������̻��о����������������һ���������ľ��룬��λΪ�ף��粻���뾭γ�����꣬���Ϊ-1�����Ź����޹����̻������ΪMAXINT
		public String image_url;// �Ź�ͼƬ���� string �Ź�ͼƬ���ӣ����ͼƬ�ߴ�450��280
		public String s_image_url;// С�ߴ��Ź�ͼƬ���� string С�ߴ��Ź�ͼƬ���ӣ����ͼƬ�ߴ�160��100
		public String deal_url;// �Ź�Webҳ������ string �Ź�Webҳ�����ӣ���������ҳӦ��
		public String deal_h5_url;// �Ź�HTML5ҳ������ string
									// �Ź�HTML5ҳ�����ӣ��������ƶ�Ӧ�ú���������Ӧ��
		public String commission_ratio;// ��ǰ�ŵ���Ӷ����� float ��ǰ�ŵ���Ӷ�����
		public String area_no;// ������ string ������
		public String build_no;// ������� string �������
		public String floor_no;// ¥���� string ¥����
		public String door_no;// ������ string ������
		
		public String business_id;// �̻�ID int �̻�ID
		public String business_name;// �̻��� string �̻���
		
		public String latitude;// γ������ float γ�����꣬ 
		public String longitude;// �������� float �������꣬ 
		
		

	}
}
