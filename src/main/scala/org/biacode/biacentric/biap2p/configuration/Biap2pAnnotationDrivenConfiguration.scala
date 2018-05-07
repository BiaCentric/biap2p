package org.biacode.biacentric.biap2p.configuration

import org.springframework.context.annotation.{ComponentScan, Configuration, PropertySource}

/**
  * Created by Arthur Asatryan.
  * Date: 5/6/18
  * Time: 5:17 PM
  */
@Configuration
@ComponentScan(Array("org.biacode.biacentric.biap2p"))
@PropertySource(value = Array(
  "classpath:netty-default.properties",
  "classpath:netty-custom.properties"
), ignoreResourceNotFound = true)
class Biap2pAnnotationDrivenConfiguration
