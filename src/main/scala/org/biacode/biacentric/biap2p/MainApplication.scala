package org.biacode.biacentric.biap2p

import org.biacode.biacentric.biap2p.configuration.Biap2pAnnotationDrivenConfiguration
import org.springframework.context.annotation.AnnotationConfigApplicationContext

/**
  * Created by Arthur Asatryan.
  * Date: 5/6/18
  * Time: 4:56 PM
  */
object MainApplication {
  def main(args: Array[String]): Unit = {
    new AnnotationConfigApplicationContext(classOf[Biap2pAnnotationDrivenConfiguration])
  }
}
