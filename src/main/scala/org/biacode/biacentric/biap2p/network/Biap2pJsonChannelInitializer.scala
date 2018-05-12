package org.biacode.biacentric.biap2p.network

import io.netty.channel.ChannelInitializer
import io.netty.channel.socket.SocketChannel
import org.biacode.biacentric.biap2p.network.codec.BasicJacksonCodec
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

/**
  * Created by Arthur Asatryan.
  * Date: 5/12/18
  * Time: 5:03 PM
  */
@Component
class Biap2pJsonChannelInitializer extends ChannelInitializer[SocketChannel] {

  private val LOGGER = LoggerFactory.getLogger(classOf[Biap2pWebsocketChannelInitializer])

  override def initChannel(ch: SocketChannel): Unit = {
    LOGGER.debug("Creating channel pipeline")
    ch.pipeline
      .addLast("jsonEncoder", new BasicJacksonCodec())
    LOGGER.debug("Channel pipeline successfully created")
  }
}
