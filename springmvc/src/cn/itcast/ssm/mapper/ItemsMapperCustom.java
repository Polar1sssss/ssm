package cn.itcast.ssm.mapper;

import cn.itcast.ssm.po.ItemsQueryVo;
import cn.itcast.ssm.po.ItemsCustom;

import java.util.List;

public interface ItemsMapperCustom {
    public List<ItemsCustom> selectItems(ItemsQueryVo itemsQueryVo) throws Exception;
    public void deleteItems(Integer[] id) throws Exception;
}