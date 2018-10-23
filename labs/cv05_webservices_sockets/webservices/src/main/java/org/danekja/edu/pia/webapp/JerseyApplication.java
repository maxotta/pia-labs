package org.danekja.edu.pia.webapp;

import org.danekja.edu.pia.webapp.service.PostServiceJAXRS;
import org.glassfish.jersey.server.ResourceConfig;

/**
 * Date: 6.12.16
 *
 * @author Jakub Danek
 */
public class JerseyApplication extends ResourceConfig {

    public JerseyApplication() {

        register(PostServiceJAXRS.class);
    }
}
