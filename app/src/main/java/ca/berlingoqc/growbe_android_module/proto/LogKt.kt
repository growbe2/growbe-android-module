//Generated by the protocol buffer compiler. DO NOT EDIT!
// source: message.proto

package ca.berlingoqc.growbe_android_module.proto;

@kotlin.jvm.JvmName("-initializelog")
inline fun log(block: ca.berlingoqc.growbe_android_module.proto.LogKt.Dsl.() -> kotlin.Unit): ca.berlingoqc.growbe_android_module.proto.Message.Log =
  ca.berlingoqc.growbe_android_module.proto.LogKt.Dsl._create(ca.berlingoqc.growbe_android_module.proto.Message.Log.newBuilder()).apply { block() }._build()
object LogKt {
  @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
  @com.google.protobuf.kotlin.ProtoDslMarker
  class Dsl private constructor(
    private val _builder: ca.berlingoqc.growbe_android_module.proto.Message.Log.Builder
  ) {
    companion object {
      @kotlin.jvm.JvmSynthetic
      @kotlin.PublishedApi
      internal fun _create(builder: ca.berlingoqc.growbe_android_module.proto.Message.Log.Builder): Dsl = Dsl(builder)
    }

    @kotlin.jvm.JvmSynthetic
    @kotlin.PublishedApi
    internal fun _build(): ca.berlingoqc.growbe_android_module.proto.Message.Log = _builder.build()

    /**
     * <code>int32 timestamp = 1;</code>
     */
    var timestamp: kotlin.Int
      @JvmName("getTimestamp")
      get() = _builder.getTimestamp()
      @JvmName("setTimestamp")
      set(value) {
        _builder.setTimestamp(value)
      }
    /**
     * <code>int32 timestamp = 1;</code>
     */
    fun clearTimestamp() {
      _builder.clearTimestamp()
    }

    /**
     * <code>string log = 2;</code>
     */
    var log: kotlin.String
      @JvmName("getLog")
      get() = _builder.getLog()
      @JvmName("setLog")
      set(value) {
        _builder.setLog(value)
      }
    /**
     * <code>string log = 2;</code>
     */
    fun clearLog() {
      _builder.clearLog()
    }
  }
}
@kotlin.jvm.JvmSynthetic
inline fun ca.berlingoqc.growbe_android_module.proto.Message.Log.copy(block: ca.berlingoqc.growbe_android_module.proto.LogKt.Dsl.() -> kotlin.Unit): ca.berlingoqc.growbe_android_module.proto.Message.Log =
  ca.berlingoqc.growbe_android_module.proto.LogKt.Dsl._create(this.toBuilder()).apply { block() }._build()

