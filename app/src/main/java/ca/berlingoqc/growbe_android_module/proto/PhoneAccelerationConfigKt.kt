//Generated by the protocol buffer compiler. DO NOT EDIT!
// source: module.proto

package ca.berlingoqc.growbe_android_module.proto;

@kotlin.jvm.JvmName("-initializephoneAccelerationConfig")
inline fun phoneAccelerationConfig(block: ca.berlingoqc.growbe_android_module.proto.PhoneAccelerationConfigKt.Dsl.() -> kotlin.Unit): ca.berlingoqc.growbe_android_module.proto.Module.PhoneAccelerationConfig =
  ca.berlingoqc.growbe_android_module.proto.PhoneAccelerationConfigKt.Dsl._create(ca.berlingoqc.growbe_android_module.proto.Module.PhoneAccelerationConfig.newBuilder()).apply { block() }._build()
object PhoneAccelerationConfigKt {
  @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
  @com.google.protobuf.kotlin.ProtoDslMarker
  class Dsl private constructor(
    private val _builder: ca.berlingoqc.growbe_android_module.proto.Module.PhoneAccelerationConfig.Builder
  ) {
    companion object {
      @kotlin.jvm.JvmSynthetic
      @kotlin.PublishedApi
      internal fun _create(builder: ca.berlingoqc.growbe_android_module.proto.Module.PhoneAccelerationConfig.Builder): Dsl = Dsl(builder)
    }

    @kotlin.jvm.JvmSynthetic
    @kotlin.PublishedApi
    internal fun _build(): ca.berlingoqc.growbe_android_module.proto.Module.PhoneAccelerationConfig = _builder.build()
  }
}
@kotlin.jvm.JvmSynthetic
inline fun ca.berlingoqc.growbe_android_module.proto.Module.PhoneAccelerationConfig.copy(block: ca.berlingoqc.growbe_android_module.proto.PhoneAccelerationConfigKt.Dsl.() -> kotlin.Unit): ca.berlingoqc.growbe_android_module.proto.Module.PhoneAccelerationConfig =
  ca.berlingoqc.growbe_android_module.proto.PhoneAccelerationConfigKt.Dsl._create(this.toBuilder()).apply { block() }._build()
