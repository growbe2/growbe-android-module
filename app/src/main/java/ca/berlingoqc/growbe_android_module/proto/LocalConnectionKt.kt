//Generated by the protocol buffer compiler. DO NOT EDIT!
// source: board.proto

package ca.berlingoqc.growbe_android_module.proto;

@kotlin.jvm.JvmName("-initializelocalConnection")
inline fun localConnection(block: ca.berlingoqc.growbe_android_module.proto.LocalConnectionKt.Dsl.() -> kotlin.Unit): ca.berlingoqc.growbe_android_module.proto.Board.LocalConnection =
  ca.berlingoqc.growbe_android_module.proto.LocalConnectionKt.Dsl._create(ca.berlingoqc.growbe_android_module.proto.Board.LocalConnection.newBuilder()).apply { block() }._build()
object LocalConnectionKt {
  @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
  @com.google.protobuf.kotlin.ProtoDslMarker
  class Dsl private constructor(
    private val _builder: ca.berlingoqc.growbe_android_module.proto.Board.LocalConnection.Builder
  ) {
    companion object {
      @kotlin.jvm.JvmSynthetic
      @kotlin.PublishedApi
      internal fun _create(builder: ca.berlingoqc.growbe_android_module.proto.Board.LocalConnection.Builder): Dsl = Dsl(builder)
    }

    @kotlin.jvm.JvmSynthetic
    @kotlin.PublishedApi
    internal fun _build(): ca.berlingoqc.growbe_android_module.proto.Board.LocalConnection = _builder.build()

    /**
     * <code>string ssid = 1;</code>
     */
    var ssid: kotlin.String
      @JvmName("getSsid")
      get() = _builder.getSsid()
      @JvmName("setSsid")
      set(value) {
        _builder.setSsid(value)
      }
    /**
     * <code>string ssid = 1;</code>
     */
    fun clearSsid() {
      _builder.clearSsid()
    }

    /**
     * <code>int32 signalLevel = 2;</code>
     */
    var signalLevel: kotlin.Int
      @JvmName("getSignalLevel")
      get() = _builder.getSignalLevel()
      @JvmName("setSignalLevel")
      set(value) {
        _builder.setSignalLevel(value)
      }
    /**
     * <code>int32 signalLevel = 2;</code>
     */
    fun clearSignalLevel() {
      _builder.clearSignalLevel()
    }

    /**
     * <code>string ipAddr = 3;</code>
     */
    var ipAddr: kotlin.String
      @JvmName("getIpAddr")
      get() = _builder.getIpAddr()
      @JvmName("setIpAddr")
      set(value) {
        _builder.setIpAddr(value)
      }
    /**
     * <code>string ipAddr = 3;</code>
     */
    fun clearIpAddr() {
      _builder.clearIpAddr()
    }
  }
}
@kotlin.jvm.JvmSynthetic
inline fun ca.berlingoqc.growbe_android_module.proto.Board.LocalConnection.copy(block: ca.berlingoqc.growbe_android_module.proto.LocalConnectionKt.Dsl.() -> kotlin.Unit): ca.berlingoqc.growbe_android_module.proto.Board.LocalConnection =
  ca.berlingoqc.growbe_android_module.proto.LocalConnectionKt.Dsl._create(this.toBuilder()).apply { block() }._build()

