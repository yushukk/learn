package mybatis;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.session.*;
import org.apache.ibatis.transaction.Transaction;
import org.apache.ibatis.transaction.TransactionFactory;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by wandong.cwd on 2014/10/8.
 */
public class FirstDemo {
    public static void main(String[] args) throws IOException, SQLException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //´´½¨SqlSession
        SqlSession session = sqlSessionFactory.openSession();
        try {
            Person person = (Person) session.selectOne("org.erik.PersonMapper.selectBlog", 2);
            System.out.println(person.getName());
        } finally {
            session.close();
        }

        Configuration configuration = sqlSessionFactory.getConfiguration();
        MappedStatement mappedStatement = configuration.getMappedStatement("org.erik.PersonMapper.selectBlog");
        BoundSql boundSql = mappedStatement.getBoundSql(2);


        Environment environment = configuration.getEnvironment();
        TransactionFactory transactionFactory = environment.getTransactionFactory();
        Transaction tx = transactionFactory.newTransaction(environment.getDataSource(), null, false);
        Executor executor = configuration.newExecutor(tx);
        List<Person> persons = executor.query(mappedStatement, 2, RowBounds.DEFAULT, Executor.NO_RESULT_HANDLER);


        System.out.println(boundSql.getSql());

    }
}
