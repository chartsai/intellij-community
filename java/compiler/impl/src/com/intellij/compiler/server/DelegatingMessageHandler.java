package com.intellij.compiler.server;

import io.netty.channel.Channel;
import org.jetbrains.jps.api.CmdlineRemoteProto;

import java.util.UUID;

/**
* @author Eugene Zhuravlev
*/
abstract class DelegatingMessageHandler implements BuilderMessageHandler {

  protected abstract BuilderMessageHandler getDelegateHandler();

  @Override
  public void buildStarted(UUID sessionId) {
    getDelegateHandler().buildStarted(sessionId);
  }

  @Override
  public void handleBuildMessage(Channel channel, UUID sessionId, CmdlineRemoteProto.Message.BuilderMessage msg) {
    getDelegateHandler().handleBuildMessage(channel, sessionId, msg);
  }

  @Override
  public void handleFailure(UUID sessionId, CmdlineRemoteProto.Message.Failure failure) {
    getDelegateHandler().handleFailure(sessionId, failure);
  }

  @Override
  public void sessionTerminated(UUID sessionId) {
    getDelegateHandler().sessionTerminated(sessionId);
  }
}
