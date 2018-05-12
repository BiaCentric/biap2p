package org.biacode.biacentric.biap2p.network.codec;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufInputStream;
import io.netty.buffer.ByteBufOutputStream;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageCodec;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

/**
 * Created by Arthur Asatryan.
 * Date: 5/12/18
 * Time: 5:07 PM
 */
public class BasicJacksonCodec<T> extends ByteToMessageCodec<T> {

    //region Dependencies
    private final Class<T> clazz;
    private final ObjectMapper objectMapper;
    //endregion

    //region Constructors
    public BasicJacksonCodec(Class<T> clazz, ObjectMapper objectMapper) {
        super(clazz);
        this.clazz = clazz;
        this.objectMapper = objectMapper;
    }
    //endregion

    //region Public methods
    @Override
    protected void encode(final ChannelHandlerContext ctx, T msg, ByteBuf out) throws Exception {
        final ByteBufOutputStream byteBufOutputStream = new ByteBufOutputStream(out);
        objectMapper.writeValue((OutputStream) byteBufOutputStream, msg);
    }

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        ByteBufInputStream byteBufInputStream = new ByteBufInputStream(in);
        out.add(objectMapper.readValue((InputStream) byteBufInputStream, clazz));
    }
    //endregion
}