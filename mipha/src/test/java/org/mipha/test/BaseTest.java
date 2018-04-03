package org.mipha.test;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 单元测试的基类.
 * @author 7cat
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("dev")
public abstract class BaseTest {

}
