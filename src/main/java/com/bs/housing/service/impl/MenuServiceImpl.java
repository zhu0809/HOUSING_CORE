package com.bs.housing.service.impl;

import com.bs.housing.base.BaseServiceImpl;
import com.bs.housing.core.WebUtils;
import com.bs.housing.core.mapper.DozerMapper;
import com.bs.housing.dao.MenuDAO;
import com.bs.housing.dto.JsTreeDto;
import com.bs.housing.dto.MenuDTO;
import com.bs.housing.po.MenuPO;
import com.bs.housing.service.MenuService;
import com.bs.housing.utils.TreeUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * <p> @类描述：	                </p>
 * <p> @创建人：ZhuRongguo	    </p>
 * <p> @创建时间：2018/11/29 21:14</p>
 */
@Service
public class MenuServiceImpl extends BaseServiceImpl<MenuDAO, MenuDTO> implements MenuService {
    /**
     * <p> @方法描述： 获取属性菜单        </p>
     * <p> @创建人：	ZhuRongguo	        </p>
     * <p> @创建时间：2018/11/29 23:18   	</p>
     * <p> @修改人：	ZhuRongguo	        </p>
     * <p> @修改时间：2018/11/29 23:18	</p>
     * <p> @修改说明：	                </p>
     *
     * @param modelMap
     * @return void
     */
    @Override
    public void menuTree(ModelMap modelMap) {
        List<MenuPO> all = super.dao.findAll();

        JSONArray jsonArray = new JSONArray();
        for (MenuPO po : all) {
            JsTreeDto jsonObject = new JsTreeDto();
            jsonObject.setPid((po.getParentID()));
            if (StringUtils.isBlank(po.getAccessPath())) {
                jsonObject.setIcon("/images/icon/lib.png");
            } else {
                jsonObject.setIcon("/images/icon/file.png");
            }

            jsonObject.setId(po.getResourceID());

            jsonObject.setText(po.getResourceName());
            jsonArray.add(jsonObject);
        }

        modelMap.put(WebUtils.DATA, TreeUtil.treeMenuList(jsonArray, 1));
    }


}
