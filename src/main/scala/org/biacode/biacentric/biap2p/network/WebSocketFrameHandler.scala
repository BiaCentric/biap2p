package org.biacode.biacentric.biap2p.network

import com.fasterxml.jackson.databind.{JsonNode, ObjectMapper}
import io.netty.channel.{ChannelHandler, ChannelHandlerContext, SimpleChannelInboundHandler}
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

/**
  * Created by Arthur Asatryan.
  * Date: 5/6/18
  * Time: 6:02 PM
  */
@Component
@ChannelHandler.Sharable
class WebSocketFrameHandler extends SimpleChannelInboundHandler[TextWebSocketFrame] {

  private val LOGGER = LoggerFactory.getLogger(classOf[WebSocketFrameHandler])

  @Autowired
  private val jacksonObjectMapper: ObjectMapper = null

  override protected def channelRead0(ctx: ChannelHandlerContext, frame: TextWebSocketFrame): Unit = {
    val request: String = frame.text
    val jsonNode: JsonNode = jacksonObjectMapper.readTree(request)
    val command: JsonNode = jsonNode.get("command")
    if (command != null) {
      val commandText: String = command.asText
      println(commandText)
    }
    //TODO: This write to socket is experimental, and will be removed in future
    ctx.channel.writeAndFlush(new TextWebSocketFrame(request))
  }

  override def channelActive(ctx: ChannelHandlerContext): Unit = {
    super.channelActive(ctx)
  }

  override def channelInactive(ctx: ChannelHandlerContext): Unit = {
    super.channelInactive(ctx)
  }

  override def userEventTriggered(ctx: ChannelHandlerContext, evt: scala.Any): Unit = {
    super.userEventTriggered(ctx, evt)
  }
}