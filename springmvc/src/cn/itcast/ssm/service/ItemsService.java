package cn.itcast.ssm.service;

import cn.itcast.ssm.po.ItemsQueryVo;
import cn.itcast.ssm.po.ItemsCustom;

import java.util.List;

/**
 * @author hujtb
 * @create on 2018-09-14-10:01
 */
public interface ItemsService {

    //商品查询列表
    public List<ItemsCustom> selectItems(ItemsQueryVo itemsQueryVo) throws Exception;

    //根据id查询商品信息
    public ItemsCustom selectItemById(Integer id) throws Exception;

    //修改商品信息
    public void updateItem(Integer id, ItemsCustom itemsCustom) throws Exception;

    //删除商品信息
    public void deleteItems(Integer[] id) throws Exception;
}
