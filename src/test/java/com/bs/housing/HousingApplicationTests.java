package com.bs.housing;

import com.bs.housing.dao.MenuDAO;
import com.bs.housing.po.MenuPO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HousingApplicationTests {

    @Autowired
    RedisConnectionFactory factory;

    @Autowired

    MenuDAO menuDAO;

    @Test
    public void contextLoads() {
        int pageNumber = 5;
        int pageSize = 6;
        Sort sort = new Sort(Sort.Direction.DESC, "parentID"); //创建时间降序排序
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize, sort);
        Page<MenuPO> all = menuDAO.findAll(pageable);

        System.out.println("getNumber" + all.getNumber());
        System.out.println("getSize" + all.getSize());
        System.out.println("getTotalPages" + all.getTotalPages());
        System.out.println("getNumberOfElements" + all.getNumberOfElements());
        System.out.println("getTotalElements" + all.getTotalElements());

        System.out.println(all);
    }
}

/*
    int getNumber();			//当前第几页   返回当前页的数目。总是非负的
    int getSize();				//返回当前页面的大小。
    int getTotalPages();         //返回分页总数。
    int getNumberOfElements();   //返回当前页上的元素数。
    long getTotalElements();    //返回元素总数。
    boolean hasPreviousPage();  //返回如果有上一页。
    boolean isFirstPage();      //返回当前页是否为第一页。
    boolean hasNextPage();      //返回如果有下一页。
    boolean isLastPage();       //返回当前页是否为最后一页。
    Iterator<T> iterator();
    List<T> getContent();     //将所有数据返回为List
    boolean hasContent();     //返回数据是否有内容。
    Sort getSort();          //返回页的排序参数。
*/
