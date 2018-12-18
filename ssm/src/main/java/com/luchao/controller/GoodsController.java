package com.luchao.controller;

import com.luchao.pojo.Goods;
import com.luchao.service.GoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/goods")
public class GoodsController {
    private Logger log = LoggerFactory.getLogger(getClass());
    @Autowired
    private GoodsService goodsService;

    @RequestMapping("/list")
    public String list(Model model, @RequestParam(required = false, defaultValue = "5") int size, @RequestParam(required = false, defaultValue = "1") int pageno) {
        System.out.println("================Controller:/goods/list");
        log.debug("================Controller:/goods/list");
        int beginnum = (pageno - 1) * size;
        int count = goodsService.getGoodsCount();
        int pagecount = (count + size - 1) / size;
        model.addAttribute("size", size);
        model.addAttribute("pageno", pageno);
        model.addAttribute("count", count);
        model.addAttribute("pagecount", pagecount);
        model.addAttribute("goods", goodsService.getAllGoodsPager(beginnum, size));
        log.error("====测试：这是error");
        log.info("==info===");
        if(log.isDebugEnabled()){
            log.debug("===========debug is open==========");
        }
        if(log.isErrorEnabled()){
            log.error("===========error is open==========");
        }
        //System.out.println(model.toString());
        //return "forward:/WEB-INF/views/list.jsp";
        return "list";
    }

    @RequestMapping(value = "/delete/{id}/{pageno}")
    public String delete(@PathVariable int id, @PathVariable int pageno, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("====id参数：" + id);
        int i = goodsService.deleteGoodsById(id);
        System.out.println("执行" + i + "条");
//        return "list";
        return "redirect:/goods/list?pageno=" + pageno;
    }

    @RequestMapping("/toadd")
    public String toadd() {
        return "add";
    }

    @RequestMapping("/toedit/{id}")
    public String toedit(Model model, @PathVariable int id) {
        model.addAttribute("goods", goodsService.getGoodsById(id));
        return "add";
    }

    @RequestMapping(value = "/edit")
    public String edit(@RequestParam String name, @RequestParam double price, @RequestParam(required = false) MultipartFile picture, HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        System.out.println("===edit:" + id + "--" + name + "--" + price);
        System.out.println(picture.getSize());
        int i = 0;
        Goods goods = new Goods();
        goods.setName(name);
        goods.setPrice(price);
        //如果选择了文件
        if (picture != null) {
            //文件大小不为0
            if (picture.getSize() > 0) {
                //获得上传位置
//                String path = request.getServletContext().getRealPath("/images");
                //需在tomcat中配置虚拟路径
                String path = "C:\\Workspaces\\images\\";
                //生成文件名
                String filename = UUID.randomUUID().toString() + picture.getOriginalFilename().substring(picture.getOriginalFilename().lastIndexOf("."));
                File tempFile = new File(path, filename);
                try {
                    //保存文件
                    picture.transferTo(tempFile);
                    System.out.println("=文件存储成功，路径："+path+filename);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                goods.setPicture(filename);
            }
        }
        if (StringUtils.isEmpty(id) || id.equals(0)) {
            i = goodsService.addGoods(goods);
        } else {
            int intid = Integer.parseInt(id);
            goods.setId(intid);
            i = goodsService.updateGoods(goods);
        }
        System.out.println("执行" + i + "条");
        return "redirect:/goods/list";
    }

    @RequestMapping("/searchgoodslist")
    public String searchgoodslist(Model model, @RequestParam(required = false) String sname, @RequestParam(required = false, defaultValue = "5") int size, @RequestParam(required = false, defaultValue = "1") int pageno) {
        System.out.println("================Controller:/goods/searchgoodslist");
        int beginnum = (pageno - 1) * size;
        model.addAttribute("sname", sname);
        sname = "%" + sname + "%";
        List<Goods> list = goodsService.searchGoodsPager(sname, beginnum, size);
        int count = list.size();
        int pagecount = (count + size - 1) / size;
        model.addAttribute("size", size);
        model.addAttribute("pageno", pageno);
        model.addAttribute("count", count);
        model.addAttribute("pagecount", pagecount);
        model.addAttribute("goods", list);
        log.debug("======"+beginnum+"======"+sname);
        //System.out.println(model.toString());
        //return "forward:/WEB-INF/views/list.jsp";
        return "list";
    }

    public static void main(String[] args) {
        System.out.println((14 + 5 - 1) / 5);
    }
}
