//Generated by the protocol buffer compiler. DO NOT EDIT!
// source: board.proto

package ca.berlingoqc.growbe_android_module.proto;

@kotlin.jvm.JvmName("-initializegrowbeMainboardConfig")
inline fun growbeMainboardConfig(block: ca.berlingoqc.growbe_android_module.proto.GrowbeMainboardConfigKt.Dsl.() -> kotlin.Unit): ca.berlingoqc.growbe_android_module.proto.Board.GrowbeMainboardConfig =
  ca.berlingoqc.growbe_android_module.proto.GrowbeMainboardConfigKt.Dsl._create(ca.berlingoqc.growbe_android_module.proto.Board.GrowbeMainboardConfig.newBuilder()).apply { block() }._build()
object GrowbeMainboardConfigKt {
  @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
  @com.google.protobuf.kotlin.ProtoDslMarker
  class Dsl private constructor(
    private val _builder: ca.berlingoqc.growbe_android_module.proto.Board.GrowbeMainboardConfig.Builder
  ) {
    companion object {
      @kotlin.jvm.JvmSynthetic
      @kotlin.PublishedApi
      internal fun _create(builder: ca.berlingoqc.growbe_android_module.proto.Board.GrowbeMainboardConfig.Builder): Dsl = Dsl(builder)
    }

    @kotlin.jvm.JvmSynthetic
    @kotlin.PublishedApi
    internal fun _build(): ca.berlingoqc.growbe_android_module.proto.Board.GrowbeMainboardConfig = _builder.build()

    /**
     * <code>int32 hearthBeath = 1;</code>
     */
    var hearthBeath: kotlin.Int
      @JvmName("getHearthBeath")
      get() = _builder.getHearthBeath()
      @JvmName("setHearthBeath")
      set(value) {
        _builder.setHearthBeath(value)
      }
    /**
     * <code>int32 hearthBeath = 1;</code>
     */
    fun clearHearthBeath() {
      _builder.clearHearthBeath()
    }
  }
}
@kotlin.jvm.JvmSynthetic
inline fun ca.berlingoqc.growbe_android_module.proto.Board.GrowbeMainboardConfig.copy(block: ca.berlingoqc.growbe_android_module.proto.GrowbeMainboardConfigKt.Dsl.() -> kotlin.Unit): ca.berlingoqc.growbe_android_module.proto.Board.GrowbeMainboardConfig =
  ca.berlingoqc.growbe_android_module.proto.GrowbeMainboardConfigKt.Dsl._create(this.toBuilder()).apply { block() }._build()
