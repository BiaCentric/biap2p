package org.biacode.biacentric.biap2p

import io.netty.channel.nio.NioEventLoopGroup
import org.biacode.biacentric.biap2p.configuration.Biap2pAnnotationDrivenConfiguration
import org.biacode.biacentric.biap2p.service.HelloWorldService
import org.springframework.context.annotation.AnnotationConfigApplicationContext

/**
  * Created by Arthur Asatryan.
  * Date: 5/6/18
  * Time: 4:56 PM
  */
object MainApplication {
  def main(args: Array[String]): Unit = {
    val context = new AnnotationConfigApplicationContext(classOf[Biap2pAnnotationDrivenConfiguration])
    val helloWorldService = context.getBean(classOf[HelloWorldService])
    helloWorldService.hello()
    val workerGroup = context.getBean("workerGroup", classOf[NioEventLoopGroup])
    assert(workerGroup != null)
  }
}
