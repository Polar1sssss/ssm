package cn.itcast.ssm.service;

import cn.itcast.ssm.mapper.ItemsMapper;
import cn.itcast.ssm.mapper.ItemsMapperCustom;
import cn.itcast.ssm.po.Items;
import cn.itcast.ssm.po.ItemsCustom;
import cn.itcast.ssm.po.ItemsQueryVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * ItemsService µœ÷¿‡
 * @author hujtb
 * @create on 2018-09-14-10:05
 */
public class ItemsServiceImpl implements ItemsService {

    @Autowired
    private ItemsMapperCustom itemsMapperCustom;

    @Autowired
    private ItemsMapper itemsMapper;

    @Override
    public List<ItemsCustom> selectItems(ItemsQueryVo itemsQueryVo) throws Exception {
        List<ItemsCustom> itemsCustomList = itemsMapperCustom.selectItems(itemsQueryVo);
        return itemsCustomList;
    }

    @Override
    public ItemsCustom selectItemById(Integer id) throws Exception {
        Items items = itemsMapper.selectByPrimaryKey(id);
        ItemsCustom itemsCustom = new ItemsCustom();
        BeanUtils.copyProperties(items, itemsCustom);
        return itemsCustom;
    }

    @Override
    public void updateItem(Integer id, ItemsCustom itemsCustom) throws Exception {
        itemsCustom.setId(id);
        itemsMapper.updateByPrimaryKeyWithBLOBs(itemsCustom);
    }

    @Override
    public void deleteItems(Integer[] id) throws Exception {
        itemsMapperCustom.deleteItems(id);
    }
}
