//Generated by the protocol buffer compiler. DO NOT EDIT!
// source: module.proto

package ca.berlingoqc.growbe_android_module.proto;

@kotlin.jvm.JvmName("-initializephonePositionData")
inline fun phonePositionData(block: ca.berlingoqc.growbe_android_module.proto.PhonePositionDataKt.Dsl.() -> kotlin.Unit): ca.berlingoqc.growbe_android_module.proto.Module.PhonePositionData =
  ca.berlingoqc.growbe_android_module.proto.PhonePositionDataKt.Dsl._create(ca.berlingoqc.growbe_android_module.proto.Module.PhonePositionData.newBuilder()).apply { block() }._build()
object PhonePositionDataKt {
  @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
  @com.google.protobuf.kotlin.ProtoDslMarker
  class Dsl private constructor(
    private val _builder: ca.berlingoqc.growbe_android_module.proto.Module.PhonePositionData.Builder
  ) {
    companion object {
      @kotlin.jvm.JvmSynthetic
      @kotlin.PublishedApi
      internal fun _create(builder: ca.berlingoqc.growbe_android_module.proto.Module.PhonePositionData.Builder): Dsl = Dsl(builder)
    }

    @kotlin.jvm.JvmSynthetic
    @kotlin.PublishedApi
    internal fun _build(): ca.berlingoqc.growbe_android_module.proto.Module.PhonePositionData = _builder.build()

    /**
     * <code>float lat = 1;</code>
     */
    var lat: kotlin.Float
      @JvmName("getLat")
      get() = _builder.getLat()
      @JvmName("setLat")
      set(value) {
        _builder.setLat(value)
      }
    /**
     * <code>float lat = 1;</code>
     */
    fun clearLat() {
      _builder.clearLat()
    }

    /**
     * <code>float log = 2;</code>
     */
    var log: kotlin.Float
      @JvmName("getLog")
      get() = _builder.getLog()
      @JvmName("setLog")
      set(value) {
        _builder.setLog(value)
      }
    /**
     * <code>float log = 2;</code>
     */
    fun clearLog() {
      _builder.clearLog()
    }
  }
}
@kotlin.jvm.JvmSynthetic
inline fun ca.berlingoqc.growbe_android_module.proto.Module.PhonePositionData.copy(block: ca.berlingoqc.growbe_android_module.proto.PhonePositionDataKt.Dsl.() -> kotlin.Unit): ca.berlingoqc.growbe_android_module.proto.Module.PhonePositionData =
  ca.berlingoqc.growbe_android_module.proto.PhonePositionDataKt.Dsl._create(this.toBuilder()).apply { block() }._build()
