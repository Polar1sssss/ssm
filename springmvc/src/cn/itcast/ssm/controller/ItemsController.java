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
//为了对url进行分类管理，可以在这里定义根路径，访问的url为根路径+子路径
@RequestMapping("/items")
public class ItemsController {

    @Autowired
    private ItemsService itemsService;

    //商品查询
    @RequestMapping("/queryItems")
    public ModelAndView queryItems(ItemsQueryVo itemsQueryVo) throws Exception {
        List<ItemsCustom> itemsList = itemsService.selectItems(itemsQueryVo);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("items", itemsList);
        modelAndView.setViewName("items/itemsList");

        return modelAndView;
    }

    //RESTful风格url访问
    @RequestMapping("itemsView/{id}")
    public @ResponseBody ItemsCustom itemsView(@PathVariable("id")  Integer id) throws Exception{
        ItemsCustom itemsCustom = itemsService.selectItemById(id);
        return itemsCustom;
    }

    /*@RequestMapping(value = "/editItems", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView editItems() throws Exception{
        ItemsCustom itemsCustom = itemsService.selectItemById(2);

        //返回modelandview
        ModelAndView modelAndView = new ModelAndView();

        //将商品信息放到model
        modelAndView.addObject("itemsCustom", itemsCustom);

        //商品修改页面
        modelAndView.setViewName("items/editItems");
        return modelAndView;
    }*/

    //返回String
    @RequestMapping(value = "/editItems", method = {RequestMethod.POST, RequestMethod.GET})
    //@RequestParam中指定request参数名称与形参进行绑定，required表示此参数是否必须要传入
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

    //重定向
    /*@RequestMapping("/editItemsSubmit")
    public String editItemsSubmit() throws Exception{
        *//*ItemsCustom item = new ItemsCustom();
        itemsService.updateItem(1,item);*//*
        return "redirect:queryItems.action";
    }*/

    //请求转发forward
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
