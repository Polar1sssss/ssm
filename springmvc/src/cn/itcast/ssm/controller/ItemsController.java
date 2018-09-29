package cn.itcast.ssm.controller;

import cn.itcast.ssm.po.ItemsCustom;
import cn.itcast.ssm.po.ItemsQueryVo;
import cn.itcast.ssm.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author hujtb
 * @create on 2018-09-14-11:02
 */

@Controller
//Ϊ�˶�url���з���������������ﶨ���·�������ʵ�urlΪ��·��+��·��
@RequestMapping("/items")
public class ItemsController {

    @Autowired
    private ItemsService itemsService;

    //��Ʒ��ѯ
    @RequestMapping("/queryItems")
    public ModelAndView queryItems(ItemsQueryVo itemsQueryVo) throws Exception {
        List<ItemsCustom> itemsList = itemsService.selectItems(itemsQueryVo);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("items", itemsList);
        modelAndView.setViewName("items/itemsList");

        return modelAndView;
    }

    //RESTful���url����
    @RequestMapping("itemsView/{id}")
    public @ResponseBody ItemsCustom itemsView(@PathVariable("id")  Integer id) throws Exception{
        ItemsCustom itemsCustom = itemsService.selectItemById(id);
        return itemsCustom;
    }

    /*@RequestMapping(value = "/editItems", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView editItems() throws Exception{
        ItemsCustom itemsCustom = itemsService.selectItemById(2);

        //����modelandview
        ModelAndView modelAndView = new ModelAndView();

        //����Ʒ��Ϣ�ŵ�model
        modelAndView.addObject("itemsCustom", itemsCustom);

        //��Ʒ�޸�ҳ��
        modelAndView.setViewName("items/editItems");
        return modelAndView;
    }*/

    //����String
    @RequestMapping(value = "/editItems", method = {RequestMethod.POST, RequestMethod.GET})
    //@RequestParam��ָ��request�����������βν��а󶨣�required��ʾ�˲����Ƿ����Ҫ����
    public String editItems(Model model, @RequestParam(value = "id", required = true, defaultValue = "1") Integer item_id) throws Exception {
        ItemsCustom itemsCustom = itemsService.selectItemById(item_id);
        model.addAttribute("itemsCustom", itemsCustom);
        return "items/editItems";
    }

    /*@RequestMapping("/editItemsSubmit")
    public ModelAndView editItemsSubmit() throws Exception{
        ItemsCustom item = new ItemsCustom();
        itemsService.updateItem(1,item);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("success");
        return modelAndView;
    }*/

    //�ض���
    /*@RequestMapping("/editItemsSubmit")
    public String editItemsSubmit() throws Exception{
        *//*ItemsCustom item = new ItemsCustom();
        itemsService.updateItem(1,item);*//*
        return "redirect:queryItems.action";
    }*/

    //����ת��forward
    @RequestMapping("/editItemsSubmit")
    public String editItemsSubmit(HttpServletRequest request, Integer id, ItemsCustom itemsCustom) throws Exception{
        itemsService.updateItem(id, itemsCustom);
        return "success";
    }

    @RequestMapping("/deleteItems")
    public String deleteItems(Integer[] items_id) throws Exception {
        itemsService.deleteItems(items_id);
        return "success";
    }
}
