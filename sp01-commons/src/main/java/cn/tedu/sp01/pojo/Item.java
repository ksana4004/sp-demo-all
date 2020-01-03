package cn.tedu.sp01.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {
	
	private Integer id;  //商品ID
	private String name;  //商品名字
	private Integer number;  //商品编号

}
