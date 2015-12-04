package org.danekja.edu.pia.webapp;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;
import org.danekja.edu.pia.webapp.pages.HomePage;
import org.danekja.edu.pia.webapp.pages.PostPages;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * Application object for your web application.
 * If you want to run this application without deploying, run the Start class.
 *
 * @see cz.kiv.zcu.pia.Start#main(String[])
 */
public class WicketApplication extends WebApplication {
    /**
     * @see org.apache.wicket.Application#getHomePage()
     */
    @Override
    public Class<? extends WebPage> getHomePage() {
        return HomePage.class;
    }

    /**
     * @see org.apache.wicket.Application#init()
     */
    @Override
    public void init() {
        super.init();

        // add your configuration here

        //make Spring injection work
        getComponentInstantiationListeners().add(new SpringComponentInjector(this, getContext(), true));
        mountPages();
    }

    /**
     * Mounts Wicket pages to pretty URLs
     */
    private void mountPages() {
        mountPage("/posts", PostPages.class);
    }

    protected ApplicationContext getContext() {
        return WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
    }
}
