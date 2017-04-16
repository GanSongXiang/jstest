package com.itcast.oa.base.util;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class XmlUtils {

    /**
     * 获取根元素 
     * @param filePath 
     * @param clazz
     * @return 
     * @create: 2014-3-28 下午4:59:41 zhouqs07071
     * @history:
     */
    public static Element getRootElement(String filePath) {
        InputStream stream = null;
        try {
            stream = XmlUtils.class.getResourceAsStream(filePath);
            return new SAXReader().read(stream).getRootElement();
        } catch (DocumentException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stream != null)
                    stream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }

    /**
     * 获取根元素
     * @param fileURI
     * @param clazz
     * @return 
     * @create: 2014-3-28 下午4:59:41 zhouqs07071
     * @history:
     */
    public static Element getRootElement(Reader reader) {
        try {
            return new SAXReader().read(reader).getRootElement();
        } catch (DocumentException e) {
            e.printStackTrace();
        } finally {
            if (null != reader) {
                try {
                    reader.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return null;
    }

    /**
     * 获取根元素
     * @param stream
     * @return 
     * @create: 2014-3-28 下午5:00:49 zhouqs07071
     * @history:
     */
    public static Element getRootElement(InputStream stream) {
        try {
            return new SAXReader().read(stream).getRootElement();
        } catch (DocumentException e) {
            e.printStackTrace();
        } finally {
            if (null != stream) {
                try {
                    stream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return null;
    }

    /**
     * 解析元素,返回List，每一个子元素为一对象
     * @param element
     * @param clazz
     * @return 
     * @create: 2014-3-27 下午5:58:01 zhouqs07071
     * @history:
     */
    @SuppressWarnings("unchecked")
    public static <T> List<T> parseForList(Element element, Class<T> clazz) {
        List<T> list = new ArrayList<T>();
        Iterator<Element> iter = element.elementIterator();
        while (iter.hasNext()) {
            Element child = iter.next();
            T t = null;
            try {
                t = clazz.newInstance();
                parseElement(child, t, clazz);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

            list.add(t);
        }
        return list;
    }

    /**
     * 解析元素，返回对象
     * @param element
     * @param clazz
     * @return 
     * @create: 2014-3-27 下午5:58:01 zhouqs07071
     * @history:
     */
    @SuppressWarnings("unchecked")
    public static <T> T parse(Element element, Class<T> clazz) {
        T t = null;
        try {
            t = clazz.newInstance();
            parseElement(element, t, clazz);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return t;
    }

    /**
     * 解析Element，返回对象，每个属性为对象属性
     * @param node
     * @param result
     * @param clazz 
     * @create: 2014-3-27 下午5:58:17 zhouqs07071
     * @history:
     */
    @SuppressWarnings("unchecked")
    private static <T> void parseElement(Element node, T result, Class<T> clazz) {
        Iterator<Attribute> attributeNodes = node.attributeIterator();
        while (attributeNodes.hasNext()) {
            Attribute attribute = attributeNodes.next();
            // 获取列名
            String filedName = attribute.getName();
            Field field = getClassField(clazz, filedName);
            if (null != field) {
                PropertyDescriptor pd;
                try {
                    pd = new PropertyDescriptor(field.getName(), clazz);
                    pd.getWriteMethod().invoke(
                        result,
                        new Object[] { cast(attribute.getValue(),
                            field.getType()) });
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }// 转换成对象数据类型再复制
                catch (IllegalArgumentException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (IntrospectionException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static Field getClassField(Class<?> clazz, String fieldName) {
        Field[] fields = clazz.getDeclaredFields();
        for (int i = 0, len = fields.length; i < len; ++i) {
            Field field = fields[i];
            if (field.getName().equals(fieldName)) {
                return field;
            }
        }
        Class<?> supClz = clazz.getSuperclass();
        if (null != supClz) {
            return getClassField(supClz, fieldName);
        }
        return null;
    }

    /**
     * 数据处理
     * @param value
     * @param clazz
     * @return 
     * @create: 2014-10-17 下午3:08:23 zhouqs07071
     * @history:
     */
    private static Object cast(String value, Class<?> clazz) {
        if (int.class == clazz || Integer.class == clazz) {
            return Integer.valueOf(value);
        }
        if (boolean.class == clazz || Boolean.class == clazz) {
            if ("1".equals(value)) {
                return true;
            }
            if ("0".equals(value)) {
                return false;
            }
            return Boolean.parseBoolean(value);
        }
        if (float.class == clazz || Float.class == clazz) {
            return Float.parseFloat(value);
        }
        if (double.class == clazz || Double.class == clazz) {
            return Double.parseDouble(value);
        }
        if (long.class == clazz || Long.class == clazz) {
            return Long.parseLong(value);
        }
        if (byte.class == clazz || Byte.class == clazz) {
            return Byte.parseByte(value);
        }
        if (char.class == clazz || Character.class == clazz) {
            return value.charAt(1);
        }
        if (short.class == clazz || Short.class == clazz) {
            return Short.parseShort(value);
        }
        if (String.class == clazz) {
            return value;
        }
        if (clazz.isArray() == true) {
            String[] temp = value.split(",");
            Class<?> cla = clazz.getComponentType();
            if (int.class == cla || Integer.class == cla) {
                int[] result = new int[temp.length];
                for (int i = 0; i < temp.length; i++) {
                    result[i] = Integer.valueOf(temp[i]);
                }
                return result;
            }
            if (boolean.class == cla || Boolean.class == cla) {
                boolean[] result = new boolean[temp.length];
                for (int i = 0; i < temp.length; i++) {
                    if ("1".equals(value)) {
                        result[i] = true;
                    } else if ("0".equals(value)) {
                        result[i] = false;
                    } else {
                        result[i] = Boolean.parseBoolean(temp[i]);
                    }
                }
                return result;
            }
            if (float.class == cla || Float.class == cla) {
                float[] result = new float[temp.length];
                for (int i = 0; i < temp.length; i++) {
                    result[i] = Float.parseFloat(temp[i]);
                }
                return result;
            }
            if (double.class == cla || Double.class == cla) {
                double[] result = new double[temp.length];
                for (int i = 0; i < temp.length; i++) {
                    result[i] = Double.parseDouble(temp[i]);
                }
                return result;
            }
            if (long.class == cla || Long.class == cla) {
                long[] result = new long[temp.length];
                for (int i = 0; i < temp.length; i++) {
                    result[i] = Integer.valueOf(temp[i]);
                }
                return result;
            }
            if (byte.class == cla || Byte.class == cla) {
                byte[] result = value.getBytes();
                return result;
            }
            if (char.class == cla || Character.class == cla) {
                char[] result = new char[temp.length];
                for (int i = 0; i < temp.length; i++) {
                    result[i] = temp[i].charAt(1);
                }
                return result;
            }
            if (short.class == cla || Short.class == cla) {
                short[] result = new short[temp.length];
                for (int i = 0; i < temp.length; i++) {
                    result[i] = Short.parseShort(temp[i]);
                }
                return result;
            }
            return temp;
        }
        return null;
    }

}
