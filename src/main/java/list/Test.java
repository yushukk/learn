package list;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;

/**
 * @author wandong.cwd
 * @version 1.0
 * @date 2020/12/24
 **/
public class Test {
    //@org.junit.Test
    //public void testAggObject() {
    //    //agg 里面支持运算 基本运算支持数组
    //    Map<String,Object> map = new HashMap<>();
    //    EnhanceArrayList<Person> personList = new EnhanceArrayList<>();
    //    personList.add(new Person(4,7));
    //    personList.add(new Person(8,9));
    //    map.put("person",personList);
    //    RuleEngine ruleEngine = new RuleEngine();
    //    ruleEngine.init();
    //    Boolean result = (Boolean)ruleEngine.evalExpression("sum(person.age + person.height) > 33", t -> map.get(t));
    //    Assert.assertFalse(result);
    //
    //    Object o = ruleEngine.evalExpression("sum(person.age + person.height)", map::get);
    //    System.out.println(o);
    //}
    //
    //@org.junit.Test
    //public void testAggMap() {
    //    Map<String,Object> map = new HashMap<>();
    //    EnhanceArrayList<Map<String,Object>> personList = new EnhanceArrayList<>();
    //    Map<String,Object> zhangsan = new HashMap<>();
    //    zhangsan.put("age",4L);
    //    personList.add(zhangsan);
    //
    //    Map<String,Object> lisi = new HashMap<>();
    //    lisi.put("age",2L);
    //    personList.add(lisi);
    //
    //    map.put("person",personList);
    //    RuleEngine ruleEngine = new RuleEngine();
    //    ruleEngine.init();
    //    Boolean result = (Boolean)ruleEngine.evalExpression("sum(person.age) > 9", map::get);
    //    Assert.assertFalse(result);
    //
    //    Boolean result2 = (Boolean)ruleEngine.evalExpression("sum(person.age) > 3", map::get);
    //    Assert.assertTrue(result2);
    //
    //    //String ruleConfig = "{\"conditions\":[{\"isEnter\":true,\"id\":1,\"left\":{\"type\":2,\"value\":\"po"
    //    //    + ".status\"},\"right\":{\"type\":1,\"value\":\"15,20,30,40\"},\"operator\":\"inSet\"},"
    //    //    + "{\"isEnter\":false,\"id\":2,\"left\":{\"type\":2,\"value\":\"po_item.confirm_qty\"},"
    //    //    + "\"right\":{\"type\":3,\"tokens\":[\"onway_inv_log_agg.gmt_earliest_add_303_qty\",\"+\","
    //    //    + "\"onway_inv_log_agg.gmt_earliest_add_305_qty\"]},\"operator\":\"notEquals\"},{\"left\":{\"type\":2,"
    //    //    + "\"value\":\"po.ascp_no1_write_aic_mode\"},\"right\":{\"type\":1,"
    //    //    + "\"value\":\"ascpNo1WriteAICMode_by_po\"},\"id\":3,\"operator\":\"equals\",\"isEnter\":true}],"
    //    //    + "\"logic\":\"3&1&2\"}\n";
    //    //Rule rule = JSON.parseObject(ruleConfig, Rule.class);
    //    //
    //}
}
