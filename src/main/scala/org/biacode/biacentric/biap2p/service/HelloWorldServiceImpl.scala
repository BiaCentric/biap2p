package org.biacode.biacentric.biap2p.service

import org.springframework.stereotype.Service

/**
  * Created by Arthur Asatryan.
  * Date: 5/6/18
  * Time: 5:18 PM
  */
@Service
class HelloWorldServiceImpl extends HelloWorldService {
  override def hello(): Unit = {
    println("Hello, World!")
  }
}
