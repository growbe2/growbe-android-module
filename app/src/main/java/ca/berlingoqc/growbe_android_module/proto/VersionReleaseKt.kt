//Generated by the protocol buffer compiler. DO NOT EDIT!
// source: board.proto

package ca.berlingoqc.growbe_android_module.proto;

@kotlin.jvm.JvmName("-initializeversionRelease")
inline fun versionRelease(block: ca.berlingoqc.growbe_android_module.proto.VersionReleaseKt.Dsl.() -> kotlin.Unit): ca.berlingoqc.growbe_android_module.proto.Board.VersionRelease =
  ca.berlingoqc.growbe_android_module.proto.VersionReleaseKt.Dsl._create(ca.berlingoqc.growbe_android_module.proto.Board.VersionRelease.newBuilder()).apply { block() }._build()
object VersionReleaseKt {
  @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
  @com.google.protobuf.kotlin.ProtoDslMarker
  class Dsl private constructor(
    private val _builder: ca.berlingoqc.growbe_android_module.proto.Board.VersionRelease.Builder
  ) {
    companion object {
      @kotlin.jvm.JvmSynthetic
      @kotlin.PublishedApi
      internal fun _create(builder: ca.berlingoqc.growbe_android_module.proto.Board.VersionRelease.Builder): Dsl = Dsl(builder)
    }

    @kotlin.jvm.JvmSynthetic
    @kotlin.PublishedApi
    internal fun _build(): ca.berlingoqc.growbe_android_module.proto.Board.VersionRelease = _builder.build()

    /**
     * <code>string version = 1;</code>
     */
    var version: kotlin.String
      @JvmName("getVersion")
      get() = _builder.getVersion()
      @JvmName("setVersion")
      set(value) {
        _builder.setVersion(value)
      }
    /**
     * <code>string version = 1;</code>
     */
    fun clearVersion() {
      _builder.clearVersion()
    }

    /**
     * <code>string channel = 2;</code>
     */
    var channel: kotlin.String
      @JvmName("getChannel")
      get() = _builder.getChannel()
      @JvmName("setChannel")
      set(value) {
        _builder.setChannel(value)
      }
    /**
     * <code>string channel = 2;</code>
     */
    fun clearChannel() {
      _builder.clearChannel()
    }
  }
}
@kotlin.jvm.JvmSynthetic
inline fun ca.berlingoqc.growbe_android_module.proto.Board.VersionRelease.copy(block: ca.berlingoqc.growbe_android_module.proto.VersionReleaseKt.Dsl.() -> kotlin.Unit): ca.berlingoqc.growbe_android_module.proto.Board.VersionRelease =
  ca.berlingoqc.growbe_android_module.proto.VersionReleaseKt.Dsl._create(this.toBuilder()).apply { block() }._build()

