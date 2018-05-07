package org.biacode.biacentric.biap2p.network

import io.netty.bootstrap.ServerBootstrap
import io.netty.channel.Channel
import io.netty.channel.nio.NioEventLoopGroup
import javax.annotation.PreDestroy
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.{Autowired, Value}
import org.springframework.context.annotation.{Bean, Configuration}

/**
  * Created by Arthur Asatryan.
  * Date: 5/6/18
  * Time: 5:42 PM
  */
@Configuration
class ServerConfiguration {

  private val LOGGER = LoggerFactory.getLogger(classOf[ServerConfiguration])

  @Value("${netty.server.port}")
  private val tcpPort: Int = 0

  @Autowired
  private val serverBootstrap: ServerBootstrap = null

  @Autowired
  private val bossGroup: NioEventLoopGroup = null

  @Autowired
  private val workerGroup: NioEventLoopGroup = null

  @Bean
  @throws[InterruptedException]
  def startedServer: Channel = {
    LOGGER.debug("Starting server on port - {}", tcpPort)
    serverBootstrap.bind(tcpPort).sync.channel.closeFuture.channel
  }

  @PreDestroy
  @throws[InterruptedException]
  def stop(): Unit = {
    LOGGER.debug("Closing server channel")
    startedServer.close
    LOGGER.debug("Closing server channel's parent")
    startedServer.parent.close
    LOGGER.debug("Shutting down boss group")
    bossGroup.shutdownGracefully()
    LOGGER.debug("Shutting down worker group")
    workerGroup.shutdownGracefully()
  }
}