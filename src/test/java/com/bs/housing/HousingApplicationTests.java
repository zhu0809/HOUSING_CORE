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
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.Table;
import java.util.List;
import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HousingApplicationTests {

    @Autowired
    RedisConnectionFactory factory;

    @Autowired

    MenuDAO menuDAO;

    @Test
    public void contextLoads() {
        int pageNumber = 1;
        int pageSize = 10;
        Sort sort = new Sort(Sort.Direction.DESC, "parentID"); //创建时间降序排序
        Pageable pageable = new PageRequest(pageNumber - 1, pageSize, sort);
//        this.depositRecordRepository.findAllByUserIdIn(userIds,pageable);
        Page<MenuPO> all = menuDAO.findAll(pageable);
        long totalElements = all.getTotalElements();
        System.out.println("long:" + totalElements);
//        Stream<MenuPO> menuPOStream = all.get().collect();

        System.out.println(all);
    }

}
