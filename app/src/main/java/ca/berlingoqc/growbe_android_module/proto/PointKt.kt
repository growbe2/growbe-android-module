//Generated by the protocol buffer compiler. DO NOT EDIT!
// source: module.proto

package ca.berlingoqc.growbe_android_module.proto;

@kotlin.jvm.JvmName("-initializepoint")
inline fun point(block: ca.berlingoqc.growbe_android_module.proto.PointKt.Dsl.() -> kotlin.Unit): ca.berlingoqc.growbe_android_module.proto.Module.Point =
  ca.berlingoqc.growbe_android_module.proto.PointKt.Dsl._create(ca.berlingoqc.growbe_android_module.proto.Module.Point.newBuilder()).apply { block() }._build()
object PointKt {
  @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
  @com.google.protobuf.kotlin.ProtoDslMarker
  class Dsl private constructor(
    private val _builder: ca.berlingoqc.growbe_android_module.proto.Module.Point.Builder
  ) {
    companion object {
      @kotlin.jvm.JvmSynthetic
      @kotlin.PublishedApi
      internal fun _create(builder: ca.berlingoqc.growbe_android_module.proto.Module.Point.Builder): Dsl = Dsl(builder)
    }

    @kotlin.jvm.JvmSynthetic
    @kotlin.PublishedApi
    internal fun _build(): ca.berlingoqc.growbe_android_module.proto.Module.Point = _builder.build()

    /**
     * <code>int32 x = 1;</code>
     */
    var x: kotlin.Int
      @JvmName("getX")
      get() = _builder.getX()
      @JvmName("setX")
      set(value) {
        _builder.setX(value)
      }
    /**
     * <code>int32 x = 1;</code>
     */
    fun clearX() {
      _builder.clearX()
    }

    /**
     * <code>int32 y = 2;</code>
     */
    var y: kotlin.Int
      @JvmName("getY")
      get() = _builder.getY()
      @JvmName("setY")
      set(value) {
        _builder.setY(value)
      }
    /**
     * <code>int32 y = 2;</code>
     */
    fun clearY() {
      _builder.clearY()
    }
  }
}
@kotlin.jvm.JvmSynthetic
inline fun ca.berlingoqc.growbe_android_module.proto.Module.Point.copy(block: ca.berlingoqc.growbe_android_module.proto.PointKt.Dsl.() -> kotlin.Unit): ca.berlingoqc.growbe_android_module.proto.Module.Point =
  ca.berlingoqc.growbe_android_module.proto.PointKt.Dsl._create(this.toBuilder()).apply { block() }._build()
