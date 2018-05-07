package org.biacode.biacentric.biap2p.configuration

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.context.annotation.{Bean, Configuration}

/**
  * Created by Arthur Asatryan.
  * Date: 5/6/18
  * Time: 6:10 PM
  */
@Configuration
class ObjectMapperConfiguration {
  @Bean
  def objectMapper: ObjectMapper = {
    new ObjectMapper
  }
}
