//Generated by the protocol buffer compiler. DO NOT EDIT!
// source: module.proto

package ca.berlingoqc.growbe_android_module.proto;

@kotlin.jvm.JvmName("-initializevirtualRelayPropertyConfig")
inline fun virtualRelayPropertyConfig(block: ca.berlingoqc.growbe_android_module.proto.VirtualRelayPropertyConfigKt.Dsl.() -> kotlin.Unit): ca.berlingoqc.growbe_android_module.proto.Module.VirtualRelayPropertyConfig =
  ca.berlingoqc.growbe_android_module.proto.VirtualRelayPropertyConfigKt.Dsl._create(ca.berlingoqc.growbe_android_module.proto.Module.VirtualRelayPropertyConfig.newBuilder()).apply { block() }._build()
object VirtualRelayPropertyConfigKt {
  @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
  @com.google.protobuf.kotlin.ProtoDslMarker
  class Dsl private constructor(
    private val _builder: ca.berlingoqc.growbe_android_module.proto.Module.VirtualRelayPropertyConfig.Builder
  ) {
    companion object {
      @kotlin.jvm.JvmSynthetic
      @kotlin.PublishedApi
      internal fun _create(builder: ca.berlingoqc.growbe_android_module.proto.Module.VirtualRelayPropertyConfig.Builder): Dsl = Dsl(builder)
    }

    @kotlin.jvm.JvmSynthetic
    @kotlin.PublishedApi
    internal fun _build(): ca.berlingoqc.growbe_android_module.proto.Module.VirtualRelayPropertyConfig = _builder.build()

    /**
     * <code>int32 property = 1;</code>
     */
    var property: kotlin.Int
      @JvmName("getProperty")
      get() = _builder.getProperty()
      @JvmName("setProperty")
      set(value) {
        _builder.setProperty(value)
      }
    /**
     * <code>int32 property = 1;</code>
     */
    fun clearProperty() {
      _builder.clearProperty()
    }

    /**
     * <code>bool falseState = 2;</code>
     */
    var falseState: kotlin.Boolean
      @JvmName("getFalseState")
      get() = _builder.getFalseState()
      @JvmName("setFalseState")
      set(value) {
        _builder.setFalseState(value)
      }
    /**
     * <code>bool falseState = 2;</code>
     */
    fun clearFalseState() {
      _builder.clearFalseState()
    }

    /**
     * <code>bool trueState = 3;</code>
     */
    var trueState: kotlin.Boolean
      @JvmName("getTrueState")
      get() = _builder.getTrueState()
      @JvmName("setTrueState")
      set(value) {
        _builder.setTrueState(value)
      }
    /**
     * <code>bool trueState = 3;</code>
     */
    fun clearTrueState() {
      _builder.clearTrueState()
    }
  }
}
@kotlin.jvm.JvmSynthetic
inline fun ca.berlingoqc.growbe_android_module.proto.Module.VirtualRelayPropertyConfig.copy(block: ca.berlingoqc.growbe_android_module.proto.VirtualRelayPropertyConfigKt.Dsl.() -> kotlin.Unit): ca.berlingoqc.growbe_android_module.proto.Module.VirtualRelayPropertyConfig =
  ca.berlingoqc.growbe_android_module.proto.VirtualRelayPropertyConfigKt.Dsl._create(this.toBuilder()).apply { block() }._build()
