package cn.itcast.ssm.po;

import java.util.List;

/**
 * 商品包装对象
 * @author hujtb
 * @create on 2018-09-13-18:15
 */
public class ItemsQueryVo {
    private List<Integer> ids;
    private Items items;
    //为了系统的可拓展性，对原始生成的po进行拓展
    private ItemsCustom itemsCustom;

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    public ItemsCustom getItemsCustom() {
        return itemsCustom;
    }

    public void setItemsCustom(ItemsCustom itemsCustom) {
        this.itemsCustom = itemsCustom;
    }

    public Items getItems() {
        return items;
    }

    public void setItems(Items items) {
        this.items = items;
    }
}
