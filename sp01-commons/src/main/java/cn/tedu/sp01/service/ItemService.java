package cn.tedu.sp01.service;

import java.util.List;

import cn.tedu.sp01.pojo.Item;

public interface ItemService {
	//���ݶ���ID��ȡ������Ʒ��Ϣ
	List<Item> getItems(String orderId);
	//����
	//������Ʒ�б�  ���ٿ��
	void decreaseNumbers(List<Item> list);

}
