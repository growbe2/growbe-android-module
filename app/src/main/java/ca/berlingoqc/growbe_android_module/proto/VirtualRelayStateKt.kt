//Generated by the protocol buffer compiler. DO NOT EDIT!
// source: module.proto

package ca.berlingoqc.growbe_android_module.proto;

@kotlin.jvm.JvmName("-initializevirtualRelayState")
inline fun virtualRelayState(block: ca.berlingoqc.growbe_android_module.proto.VirtualRelayStateKt.Dsl.() -> kotlin.Unit): ca.berlingoqc.growbe_android_module.proto.Module.VirtualRelayState =
  ca.berlingoqc.growbe_android_module.proto.VirtualRelayStateKt.Dsl._create(ca.berlingoqc.growbe_android_module.proto.Module.VirtualRelayState.newBuilder()).apply { block() }._build()
object VirtualRelayStateKt {
  @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
  @com.google.protobuf.kotlin.ProtoDslMarker
  class Dsl private constructor(
    private val _builder: ca.berlingoqc.growbe_android_module.proto.Module.VirtualRelayState.Builder
  ) {
    companion object {
      @kotlin.jvm.JvmSynthetic
      @kotlin.PublishedApi
      internal fun _create(builder: ca.berlingoqc.growbe_android_module.proto.Module.VirtualRelayState.Builder): Dsl = Dsl(builder)
    }

    @kotlin.jvm.JvmSynthetic
    @kotlin.PublishedApi
    internal fun _build(): ca.berlingoqc.growbe_android_module.proto.Module.VirtualRelayState = _builder.build()

    /**
     * <code>string id = 1;</code>
     */
    var id: kotlin.String
      @JvmName("getId")
      get() = _builder.getId()
      @JvmName("setId")
      set(value) {
        _builder.setId(value)
      }
    /**
     * <code>string id = 1;</code>
     */
    fun clearId() {
      _builder.clearId()
    }

    /**
     * <code>bool state = 2;</code>
     */
    var state: kotlin.Boolean
      @JvmName("getState")
      get() = _builder.getState()
      @JvmName("setState")
      set(value) {
        _builder.setState(value)
      }
    /**
     * <code>bool state = 2;</code>
     */
    fun clearState() {
      _builder.clearState()
    }

    /**
     * <code>string message = 3;</code>
     */
    var message: kotlin.String
      @JvmName("getMessage")
      get() = _builder.getMessage()
      @JvmName("setMessage")
      set(value) {
        _builder.setMessage(value)
      }
    /**
     * <code>string message = 3;</code>
     */
    fun clearMessage() {
      _builder.clearMessage()
    }
  }
}
@kotlin.jvm.JvmSynthetic
inline fun ca.berlingoqc.growbe_android_module.proto.Module.VirtualRelayState.copy(block: ca.berlingoqc.growbe_android_module.proto.VirtualRelayStateKt.Dsl.() -> kotlin.Unit): ca.berlingoqc.growbe_android_module.proto.Module.VirtualRelayState =
  ca.berlingoqc.growbe_android_module.proto.VirtualRelayStateKt.Dsl._create(this.toBuilder()).apply { block() }._build()

