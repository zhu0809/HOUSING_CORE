package com.bs.housing.service.impl;

import com.bs.housing.base.BaseServiceImpl;
import com.bs.housing.utils.WebUtils;
import com.bs.housing.core.exception.ServiceException;
import com.bs.housing.core.mapper.DozerMapper;
import com.bs.housing.dao.MenuDAO;
import com.bs.housing.dto.JsTreeDto;
import com.bs.housing.dto.MenuDTO;
import com.bs.housing.po.MenuPO;
import com.bs.housing.service.MenuService;
import com.bs.housing.utils.TreeUtil;
import net.sf.json.JSONArray;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.List;

/**
 * <p> @类描述：	                </p>
 * <p> @创建人：ZhuRongguo	    </p>
 * <p> @创建时间：2018/11/29 21:14</p>
 */
@Service
public class MenuServiceImpl extends BaseServiceImpl<MenuPO, MenuDAO, MenuDTO> implements MenuService {
    @Cacheable(cacheNames = {"getMenuTree"}, key = "'menuTree'")
    @Override
    public List<MenuPO> menuTree() {
        return dao.findAll();
    }

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
            JsTreeDto dto = new JsTreeDto();
            dto.setPid((po.getParentID()));
            if (po.getResourceName().equals("房源管理")) {
                System.out.println();
            }
            if (StringUtils.isBlank(po.getAccessPath()) || "#".equals(po.getAccessPath())) {
                dto.setResource(false);
                dto.setIcon("/images/icon/lib.png");
            } else {
                dto.setResource(true);
                dto.setIcon("/images/icon/file.png");
            }
            dto.setResourceGrade(po.getResourceGrade());
            dto.setId(po.getResourceID());
            dto.setText(po.getResourceName());
            jsonArray.add(dto);
        }

        modelMap.put(WebUtils.DATA, TreeUtil.treeMenuList(jsonArray, 1));
    }

    @Override
    public void save(boolean isResource, MenuDTO dto) throws ServiceException {
        if (isResource) {
            if (StringUtils.isBlank(dto.getAccessPath())) {
                throw new ServiceException("该目录为资源目录，资源地址为空");
            }
        } else {
            dto.setAccessPath("#");
        }
        if (null == dto.getResourceID()) {

        }
        MenuPO po = DozerMapper.mapper(dto, MenuPO.class);
        super.dao.save(po);
    }
}
