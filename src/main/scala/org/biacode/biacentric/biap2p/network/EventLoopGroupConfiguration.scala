package org.biacode.biacentric.biap2p.network

import io.netty.channel.nio.NioEventLoopGroup
import org.slf4j.{Logger, LoggerFactory}
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.{Bean, Configuration}

/**
  * Created by Arthur Asatryan.
  * Date: 5/6/18
  * Time: 5:28 PM
  */
@Configuration
class EventLoopGroupConfiguration {
  private val LOGGER: Logger = LoggerFactory.getLogger(classOf[EventLoopGroupConfiguration])

  @Value("${netty.boss.thread.size}")
  private val bossGroupThreadSize: Int = 0

  @Value("${netty.worker.thread.size}")
  private val workerGroupThreadSize: Int = 0

  @Bean(name = Array("bossGroup"), destroyMethod = "shutdownGracefully")
  def bossGroup: NioEventLoopGroup = {
    LOGGER.debug("Creating boss loop group with boss thread count - {}", bossGroupThreadSize)
    new NioEventLoopGroup(bossGroupThreadSize)
  }

  @Bean(name = Array("workerGroup"), destroyMethod = "shutdownGracefully")
  def workerGroup: NioEventLoopGroup = {
    LOGGER.debug("Creating worker loop group with worker thread count - {}", bossGroupThreadSize)
    new NioEventLoopGroup(workerGroupThreadSize)
  }
}
