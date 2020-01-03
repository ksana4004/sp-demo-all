package cn.tedu.sp01.pojo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
	
	//����id
	private String id;
	//�����û�
	private User user;
	//������Ʒ�б�
	private List<Item> items;

}
