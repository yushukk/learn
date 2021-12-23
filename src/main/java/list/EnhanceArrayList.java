//package list;
//
//import java.beans.PropertyDescriptor;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.beanutils.DynaBean;
//import org.apache.commons.beanutils.DynaClass;
//import org.apache.commons.beanutils.DynaProperty;
//import org.apache.commons.beanutils.PropertyUtils;
//
///**
// * @author wandong.cwd
// * @version 1.0
// * @date 2020/12/10
// **/
//@Slf4j
//public class EnhanceArrayList<E> extends ArrayList<E> implements DynaBean {
//
//    private EnhanceBasicDynaClass basicDynaClass = new EnhanceBasicDynaClass("test",null);;
//
//    private DynaBean basicDynaBean;
//
//    Map<String, List<Object>> map = new HashMap<>();
//
//    public EnhanceArrayList() {
//        try {
//            basicDynaBean = basicDynaClass.newInstance();
//        } catch (Exception e) {
//            log.error("init EnhanceArrayList error",e);
//        }
//    }
//
//    private void calProperty() {
//        try {
//            Map<String,DynaProperty> propertyMap = new HashMap<>();
//            map.keySet().stream().forEach(k -> propertyMap.put(k,new DynaProperty(k)));
//            basicDynaClass.setProperties(propertyMap.values().toArray(new DynaProperty[0]));
//        } catch (Exception e) {
//            log.error("init EnhanceArrayList error",e);
//        }
//    }
//
//    @Override
//    public boolean add(E e) {
//        if(e instanceof Map){
//            Map<String,Object> map = (Map<String, Object>)e;
//            for (String k : map.keySet()) {
//                this.map.computeIfAbsent(k,t -> new ArrayList<>()).add(map.get(k));
//            }
//        }else{
//            PropertyDescriptor[] propertyDescriptors = PropertyUtils.getPropertyDescriptors(e);
//            for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
//                String name = propertyDescriptor.getName();
//                if("class".equals(name)){
//                    continue;
//                }
//                try {
//                    this.map.computeIfAbsent(name,t -> new ArrayList<>())
//                        .add(PropertyUtils.getProperty(e,name));
//                } catch (Exception exception) {
//                    log.error("add key error",e);
//                }
//            }
//        }
//        calProperty();
//        return super.add(e);
//    }
//
//    @Override
//    public boolean contains(String name, String key) {
//        return basicDynaBean.contains(name,key);
//    }
//
//    @Override
//    public Object get(String name) {
//        return map.get(name);
//    }
//
//    @Override
//    public Object get(String name, int index) {
//        return basicDynaBean.get(name,index);
//    }
//
//    @Override
//    public Object get(String name, String key) {
//        return basicDynaBean.get(name,key);
//    }
//
//    @Override
//    public DynaClass getDynaClass() {
//        return basicDynaClass;
//    }
//
//    @Override
//    public void remove(String name, String key) {
//        basicDynaBean.remove(name,key);
//    }
//
//    @Override
//    public void set(String name, Object value) {
//        basicDynaBean.set(name,value);
//    }
//
//    @Override
//    public void set(String name, int index, Object value) {
//        basicDynaBean.set(name,index,value);
//    }
//
//    @Override
//    public void set(String name, String key, Object value) {
//        basicDynaBean.set(name,key,value);
//    }
//}
