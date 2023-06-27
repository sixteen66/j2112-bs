package com.qf.j2112;

import com.qf.j2112.mapper.OrderMapper;
import com.qf.j2112.po.Company;
import com.qf.j2112.po.Goods;
import com.qf.j2112.po.Order;
import com.qf.j2112.po.Site;
import com.qf.j2112.service.*;
import com.qf.j2112.vo.OrderInfo;
import com.qf.j2112.vo.UserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class J2112BsApplicationTests {

    @Autowired
    OrderService orderService;
    @Autowired
    CompanyService companyService;
    @Resource
    OrderMapper orderMapper;
    @Autowired
    GoodsService goodsService;
    @Autowired
    SiteService siteService;
    @Autowired
    BsUserService bsUserService;
    @Test
    public void contextLoads() throws ParseException {
        String state="未发货";
//        List<Goods> byState = goodsService.findByState(state);
//        System.out.println(byState);

        Date date = new Date();
//        String format = new SimpleDateFormat("yyyy-MM-dd").format(date);
//        Date parse = new SimpleDateFormat("yyyy-MM-dd").parse(format);
//        System.out.println(format+"====="+parse);
        /*Goods goods=new Goods();goods.setGoodsstate(state);
        List<Goods> byState = goodsService.findByState(goods);
        for (Goods good:byState){
            System.out.println(good.getSendtime());
            if (good.getSendtime()!=null) {
                String format = new SimpleDateFormat("yyyy-MM-dd").format(good.getSendtime());
                Date parse = new SimpleDateFormat("yyyy-MM-dd").parse(format);
                System.out.println(format + "=====" + parse);
            }
        }*/
        Site site=new Site();
        site.setSiteId(5);
        List<Site> bySite = siteService.findBySite(site);
        List<UserInfo> all = bsUserService.findAll();
        for (UserInfo a:all){
            System.out.println(a);
        }
    }

}
