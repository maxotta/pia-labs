package cz.kiv.zcu.pia.core;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

/**
 * Date: 11.12.14
 *
 * @author Jakub Danek
 */
@ContextConfiguration(locations = {"classpath:applicationContext-test.xml",
                                    "classpath:applicationContext.xml"})
public abstract class BaseTest extends AbstractJUnit4SpringContextTests {
}
