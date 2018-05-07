package org.biacode.biacentric.biap2p.network

import io.netty.bootstrap.ServerBootstrap
import io.netty.channel.nio.NioEventLoopGroup
import io.netty.channel.socket.SocketChannel
import io.netty.channel.socket.nio.NioServerSocketChannel
import io.netty.channel.{ChannelInitializer, ChannelOption}
import io.netty.handler.logging.{LogLevel, LoggingHandler}
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.{Bean, Configuration}

/**
  * Created by Arthur Asatryan.
  * Date: 5/6/18
  * Time: 5:39 PM
  */
@Configuration
class ServerBootstrapConfiguration {

  private val LOGGER = LoggerFactory.getLogger(classOf[ServerBootstrapConfiguration])

  @Autowired
  private val bossGroup: NioEventLoopGroup = null

  @Autowired
  private val workerGroup: NioEventLoopGroup = null

  @Autowired
  private val channelInitializer: ChannelInitializer[SocketChannel] = null

  @Bean
  def serverBootstrap: ServerBootstrap = {
    LOGGER.debug("Bootstrapping server...")
    new ServerBootstrap()
      .group(bossGroup, workerGroup)
      .channel(classOf[NioServerSocketChannel])
      .handler(new LoggingHandler(LogLevel.DEBUG))
      .childHandler(channelInitializer)
      .option[Integer](ChannelOption.SO_BACKLOG, 128)
      .childOption[java.lang.Boolean](ChannelOption.SO_KEEPALIVE, true)
  }
}
