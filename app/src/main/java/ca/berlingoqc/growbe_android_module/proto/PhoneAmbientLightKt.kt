//Generated by the protocol buffer compiler. DO NOT EDIT!
// source: module.proto

package ca.berlingoqc.growbe_android_module.proto;

@kotlin.jvm.JvmName("-initializephoneAmbientLight")
inline fun phoneAmbientLight(block: ca.berlingoqc.growbe_android_module.proto.PhoneAmbientLightKt.Dsl.() -> kotlin.Unit): ca.berlingoqc.growbe_android_module.proto.Module.PhoneAmbientLight =
  ca.berlingoqc.growbe_android_module.proto.PhoneAmbientLightKt.Dsl._create(ca.berlingoqc.growbe_android_module.proto.Module.PhoneAmbientLight.newBuilder()).apply { block() }._build()
object PhoneAmbientLightKt {
  @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
  @com.google.protobuf.kotlin.ProtoDslMarker
  class Dsl private constructor(
    private val _builder: ca.berlingoqc.growbe_android_module.proto.Module.PhoneAmbientLight.Builder
  ) {
    companion object {
      @kotlin.jvm.JvmSynthetic
      @kotlin.PublishedApi
      internal fun _create(builder: ca.berlingoqc.growbe_android_module.proto.Module.PhoneAmbientLight.Builder): Dsl = Dsl(builder)
    }

    @kotlin.jvm.JvmSynthetic
    @kotlin.PublishedApi
    internal fun _build(): ca.berlingoqc.growbe_android_module.proto.Module.PhoneAmbientLight = _builder.build()

    /**
     * <code>float si_lux = 1;</code>
     */
    var siLux: kotlin.Float
      @JvmName("getSiLux")
      get() = _builder.getSiLux()
      @JvmName("setSiLux")
      set(value) {
        _builder.setSiLux(value)
      }
    /**
     * <code>float si_lux = 1;</code>
     */
    fun clearSiLux() {
      _builder.clearSiLux()
    }
  }
}
@kotlin.jvm.JvmSynthetic
inline fun ca.berlingoqc.growbe_android_module.proto.Module.PhoneAmbientLight.copy(block: ca.berlingoqc.growbe_android_module.proto.PhoneAmbientLightKt.Dsl.() -> kotlin.Unit): ca.berlingoqc.growbe_android_module.proto.Module.PhoneAmbientLight =
  ca.berlingoqc.growbe_android_module.proto.PhoneAmbientLightKt.Dsl._create(this.toBuilder()).apply { block() }._build()
