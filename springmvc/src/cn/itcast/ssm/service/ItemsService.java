package cn.itcast.ssm.service;

import cn.itcast.ssm.po.ItemsQueryVo;
import cn.itcast.ssm.po.ItemsCustom;

import java.util.List;

/**
 * @author hujtb
 * @create on 2018-09-14-10:01
 */
public interface ItemsService {

    //��Ʒ��ѯ�б�
    public List<ItemsCustom> selectItems(ItemsQueryVo itemsQueryVo) throws Exception;

    //����id��ѯ��Ʒ��Ϣ
    public ItemsCustom selectItemById(Integer id) throws Exception;

    //�޸���Ʒ��Ϣ
    public void updateItem(Integer id, ItemsCustom itemsCustom) throws Exception;

    //ɾ����Ʒ��Ϣ
    public void deleteItems(Integer[] id) throws Exception;
}
