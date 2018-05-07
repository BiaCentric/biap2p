package org.biacode.biacentric.biap2p.network

import io.netty.channel.ChannelInitializer
import io.netty.channel.socket.SocketChannel
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler
import io.netty.handler.codec.http.websocketx.extensions.compression.WebSocketServerCompressionHandler
import io.netty.handler.codec.http.{HttpObjectAggregator, HttpServerCodec}
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

/**
  * Created by Arthur Asatryan.
  * Date: 5/6/18
  * Time: 5:59 PM
  */
@Component
class Biap2pChannelInitializer extends ChannelInitializer[SocketChannel] {

  private val LOGGER = LoggerFactory.getLogger(classOf[Biap2pChannelInitializer])

  @Autowired
  private val webSocketFrameHandler: WebSocketFrameHandler = null

  override def initChannel(ch: SocketChannel): Unit = {
    LOGGER.debug("Creating channel pipeline")
    ch.pipeline
      .addLast("httpServerCodec", new HttpServerCodec)
      .addLast("httpObjectAggregator", new HttpObjectAggregator(65536))
      .addLast("webSocketServerCompressionHandler", new WebSocketServerCompressionHandler)
      .addLast("webSocketServerProtocolHandler", new WebSocketServerProtocolHandler("/", null, true))
      .addLast("webSocketFrameHandler", webSocketFrameHandler)
    LOGGER.debug("Channel pipeline successfully created")
  }

}
