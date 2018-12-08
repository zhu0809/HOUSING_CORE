package com.bs.housing.core.config.xml;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * <p> @类描述：	 外部xml配置      </p>
 * <p> @创建人：ZhuRongguo	    </p>
 * <p> @创建时间：2018/12/6 9:23</p>
 */
@Configuration
@ImportResource(locations = {"classpath:application-bean.xml"})
public class SpringImport {

}
