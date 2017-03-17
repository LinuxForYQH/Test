package Test;


import com.github.springtestdbunit.DbUnitTestExecutionListener;



import org.dbunit.DatabaseUnitException;
import org.dbunit.dataset.DataSetException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.orm.hibernate4.SessionHolder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import util.AbstractDbUnitTestCase;

import javax.inject.Inject;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;


/**
 * Created by Administrator on 2016/8/12.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
@TestExecutionListeners({DbUnitTestExecutionListener.class,
        DependencyInjectionTestExecutionListener.class})
public class Test02 extends AbstractDbUnitTestCase {

    @Inject
    private SessionFactory sessionFactory;






    @Before
    public void setUp() throws DataSetException, SQLException, IOException {
        Session s = sessionFactory.openSession();
        TransactionSynchronizationManager.bindResource(sessionFactory, new SessionHolder(s));
        //this.backupAllTable();
    }








    @After
    public void tearDown() throws FileNotFoundException, DatabaseUnitException, SQLException {
        SessionHolder holder = (SessionHolder) TransactionSynchronizationManager.getResource(sessionFactory);
        Session s = holder.getSession();
        s.flush();
        TransactionSynchronizationManager.unbindResource(sessionFactory);
        //this.resumeTable();
    }

}
