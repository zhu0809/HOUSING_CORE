package com.bs.housing.utils;

/**
 * <p> @类描述：	                </p>
 * <p> @创建人：ZhuRongguo	    </p>
 * <p> @创建时间：2019/5/28 10:36</p>
 */
public interface RegExUtils {
    /*
     * 验证IPV4 ip地址的正则表达式
     */
    String IPV4 = "(?=(\\b|\\D))(((\\d{1,2})|(1\\d{1,2})|(2[0-4]\\d)|(25[0-5]))\\.){3}((\\d{1,2})|(1\\d{1,2})|(2[0-4]\\d)|(25[0-5]))(?=(\\b|\\D))";

    /*
     * 验证IPV6 ip地址的正则表达式
     */
    String IPV6 = "^([\\\\da-fA-F]{1,4}:){7}([\\\\da-fA-F]{1,4})$\n";

    /*
     * 验证身份证号码的正则表达式
     */
    String ID_CARD_NUMBER = "/^[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$/";

    /*
     * 验证日期的正则表达式
     */
    String REGDATE = "((^((1[8-9]/d{2})|([2-9]/d{3}))([-///._])(10|12|0?[13578])([-///._])(3[01]|[12][0-9]|0?[1-9])$)|(^((1[8-9]/d{2})|([2-9]/d{3}))([-///._])(11|0?[469])([-///._])(30|[12][0-9]|0?[1-9])$)|(^((1[8-9]/d{2})|([2-9]/d{3}))([-///._])(0?2)([-///._])(2[0-8]|1[0-9]|0?[1-9])$)|(^([2468][048]00)([-///._])(0?2)([-///._])(29)$)|(^([3579][26]00)([-///._])(0?2)([-///._])(29)$)|(^([1][89][0][48])([-///._])(0?2)([-///._])(29)$)|(^([2-9][0-9][0][48])([-///._])(0?2)([-///._])(29)$)|(^([1][89][2468][048])([-///._])(0?2)([-///._])(29)$)|(^([2-9][0-9][2468][048])([-///._])(0?2)([-///._])(29)$)|(^([1][89][13579][26])([-///._])(0?2)([-///._])(29)$)|(^([2-9][0-9][13579][26])([-///._])(0?2)([-///._])(29)$))";


    /*
     * 验证邮箱的正则表达式
     */
    String MAIL = "^[A-Za-z\\d]+([-_.][A-Za-z\\d]+)*@([A-Za-z\\d]+[-.])+[A-Za-z\\d]{2,4}$";
}
