package org.erik;

import mybatis.Person;
import org.apache.ibatis.annotations.Param;

/**
 * Created by ³¾¶« on 2015/4/21.
 */
public interface PersonMapper {
    public Person selectBlog(@Param("id") int id,@Param("name")String name);
}
