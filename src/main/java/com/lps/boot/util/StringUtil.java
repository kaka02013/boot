package com.lps.boot.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Collection;

@Slf4j
public class StringUtil extends StringUtils {

    /**
     * * 判断一个对象是否非空
     *
     * @param object Object
     * @return true：非空 false：空
     */
    public static boolean isNotNull(Object object)
    {
        return !isNull(object);
    }

    /**
     * * 判断一个对象是否为空
     *
     * @param object Object
     * @return true：为空 false：非空
     */
    public static boolean isNull(Object object)
    {
        return object == null;
    }

    /**
     * * 判断一个Collection是否为空， 包含List，Set，Queue
     *
     * @param coll 要判断的Collection
     * @return true：为空 false：非空
     */
    public static boolean isEmpty(Collection<?> coll)
    {
        return isNull(coll) || coll.isEmpty();
    }

    /**
     * * 判断一个Collection是否非空，包含List，Set，Queue
     *
     * @param coll 要判断的Collection
     * @return true：非空 false：空
     */
    public static boolean isNotEmpty(Collection<?> coll)
    {
        return !isEmpty(coll);
    }

    /**
     * * 判断一个对象数组是否非空
     *
     * @param objects 要判断的对象数组
     * @return true：非空 false：空
     */
    public static boolean isNotEmpty(Object[] objects)
    {
        return !isEmpty(objects);
    }

    /**
     * * 判断一个对象数组是否为空
     *
     * @param objects 要判断的对象数组
     ** @return true：为空 false：非空
     */
    public static boolean isEmpty(Object[] objects)
    {
        return isNull(objects) || (objects.length == 0);
    }

    /**
     * 判断字符串是否为空(去空格)
     *
     * @param str
     * @return
     */
    public static boolean isNull(String str) {
        if (null == str || "".equals(str)) {
            return true;
        }
        return false;
    }

    /**
     * 判断字符串是否为空(去空格)
     *
     * @param str
     * @return
     */
    public static boolean isNotNull(String str) {
       return !isNull(str);
    }

    /**
     * 字符串首字母转小写
     * */
    public static String toLowerCaseFirstOne(String s){
        if(StringUtils.isBlank(s)){
            return s;
        }
        if(Character.isLowerCase(s.charAt(0))){
            return s;
        }else{
            return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
        }
    }

    public static String getLocalHost() {
        String localHost = "";
        try {
            InetAddress ia = InetAddress.getLocalHost();
            //System.out.println(ia.toString());
            if (ia != null){
                localHost = ia.toString().split("/")[1];
            }

        }catch (UnknownHostException e){
            log.error("StringUtil.getLocalHost",e);
        }
        return localHost;
    }

    public static String getRealIp(HttpServletRequest request) {
        String ip = request.getHeader("X-Real-IP");
        if (isEmpty(ip) || "unknow".equalsIgnoreCase(ip)){
            ip = request.getHeader("X-Forwarded-For");
            if (!isEmpty(ip) && !"unknow".equalsIgnoreCase(ip)){
                int index = ip.indexOf(',');
                if (index != -1) {
                    ip = ip.substring(0,index);
                }
            }else{
                ip = request.getRemoteAddr();
            }
        }
        return ip;
    }

    public static String addZeroForStringLength(String str,int length){
        int strLen=str.length();
        if(strLen<length){
            while(strLen<length){
                StringBuffer sb=new StringBuffer();
                sb.append("0").append(str);
                str=sb.toString();
                strLen=str.length();
            }
        }
        return str;
    }

    /**
     * 字符串转码
     * @param src
     * @return
     */
    public static String escape(String src) {
        int i;
        char j;
        StringBuffer tmp = new StringBuffer();
        if(StringUtil.isNotNull(src)){
            tmp.ensureCapacity(src.length() * 6);
            for (i = 0; i < src.length(); i++) {
                j = src.charAt(i);
                if (Character.isDigit(j) || Character.isLowerCase(j) || Character.isUpperCase(j)) {
                    tmp.append(j);
                } else if (j < 256) {
                    tmp.append("%");
                    if (j < 16) tmp.append("0");
                    tmp.append(Integer.toString(j, 16));
                } else {
                    tmp.append("%u");
                    tmp.append(Integer.toString(j, 16));
                }
            }
        }
        return tmp.toString();
    }

    /**
     * null转空串
     * @param str
     * @return
     */
    public static String nullToString(String str) {
        if (null == str) {
            return "";
        } else {
            return str;
        }
    }
}
