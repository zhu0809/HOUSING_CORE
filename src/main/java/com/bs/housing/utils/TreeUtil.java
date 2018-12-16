package com.bs.housing.utils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * <p> @类描述：	                </p>
 * <p> @创建人：ZhuRongguo	    </p>
 * <p> @创建时间：2018/11/30 16:54</p>
 */
public class TreeUtil {
    /**
     * <p> @方法描述：json树构建            </p>
     * <p> @创建人：	ZhuRongguo	        </p>
     * <p> @创建时间：2018/11/30 10:54   	</p>
     * <p> @修改人：	ZhuRongguo	        </p>
     * <p> @修改时间：2018/11/30 10:54	</p>
     * <p> @修改说明：	                </p>
     *
     * @param menuList 数据集合
     * @param parentId 最上层关键点
     * @return net.sf.json.JSONArray 结果集
     */
    public static JSONArray treeMenuList(JSONArray menuList, int parentId,
                                         String parentName,
                                         String childrenName,
                                         String thisName) {
        JSONArray childMenu = new JSONArray();
        for (Object object : menuList) {
            JSONObject jsonMenu = JSONObject.fromObject(object);
            int menuId = jsonMenu.getInt(thisName);
            int pid = jsonMenu.getInt(parentName);
            if (parentId == pid) {
                JSONArray c_node = treeMenuList(menuList, menuId, parentName, childrenName, thisName);
                if (c_node.size() == 0) {
                    c_node = null;
                }
                jsonMenu.put(childrenName, c_node);
                childMenu.add(jsonMenu);
            }
        }
        return childMenu;
    }
}
