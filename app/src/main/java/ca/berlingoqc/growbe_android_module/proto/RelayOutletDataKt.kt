//Generated by the protocol buffer compiler. DO NOT EDIT!
// source: module.proto

package ca.berlingoqc.growbe_android_module.proto;

@kotlin.jvm.JvmName("-initializerelayOutletData")
inline fun relayOutletData(block: ca.berlingoqc.growbe_android_module.proto.RelayOutletDataKt.Dsl.() -> kotlin.Unit): ca.berlingoqc.growbe_android_module.proto.Module.RelayOutletData =
  ca.berlingoqc.growbe_android_module.proto.RelayOutletDataKt.Dsl._create(ca.berlingoqc.growbe_android_module.proto.Module.RelayOutletData.newBuilder()).apply { block() }._build()
object RelayOutletDataKt {
  @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
  @com.google.protobuf.kotlin.ProtoDslMarker
  class Dsl private constructor(
    private val _builder: ca.berlingoqc.growbe_android_module.proto.Module.RelayOutletData.Builder
  ) {
    companion object {
      @kotlin.jvm.JvmSynthetic
      @kotlin.PublishedApi
      internal fun _create(builder: ca.berlingoqc.growbe_android_module.proto.Module.RelayOutletData.Builder): Dsl = Dsl(builder)
    }

    @kotlin.jvm.JvmSynthetic
    @kotlin.PublishedApi
    internal fun _build(): ca.berlingoqc.growbe_android_module.proto.Module.RelayOutletData = _builder.build()

    /**
     * <code>bool state = 1;</code>
     */
    var state: kotlin.Boolean
      @JvmName("getState")
      get() = _builder.getState()
      @JvmName("setState")
      set(value) {
        _builder.setState(value)
      }
    /**
     * <code>bool state = 1;</code>
     */
    fun clearState() {
      _builder.clearState()
    }
  }
}
@kotlin.jvm.JvmSynthetic
inline fun ca.berlingoqc.growbe_android_module.proto.Module.RelayOutletData.copy(block: ca.berlingoqc.growbe_android_module.proto.RelayOutletDataKt.Dsl.() -> kotlin.Unit): ca.berlingoqc.growbe_android_module.proto.Module.RelayOutletData =
  ca.berlingoqc.growbe_android_module.proto.RelayOutletDataKt.Dsl._create(this.toBuilder()).apply { block() }._build()
