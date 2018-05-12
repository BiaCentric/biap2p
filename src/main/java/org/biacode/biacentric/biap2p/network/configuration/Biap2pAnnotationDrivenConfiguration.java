package org.biacode.biacentric.biap2p.network.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by Arthur Asatryan.
 * Date: 5/12/18
 * Time: 5:29 PM
 */
@Configuration
@ComponentScan("org.biacode.biacentric.biap2p")
@PropertySource(value = {
        "classpath:netty-default.properties",
        "classpath:netty-custom.properties"
}, ignoreResourceNotFound = true)
public class Biap2pAnnotationDrivenConfiguration {
}
