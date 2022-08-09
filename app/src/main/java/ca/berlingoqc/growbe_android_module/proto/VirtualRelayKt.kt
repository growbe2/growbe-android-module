//Generated by the protocol buffer compiler. DO NOT EDIT!
// source: module.proto

package ca.berlingoqc.growbe_android_module.proto;

@kotlin.jvm.JvmName("-initializevirtualRelay")
inline fun virtualRelay(block: ca.berlingoqc.growbe_android_module.proto.VirtualRelayKt.Dsl.() -> kotlin.Unit): ca.berlingoqc.growbe_android_module.proto.Module.VirtualRelay =
  ca.berlingoqc.growbe_android_module.proto.VirtualRelayKt.Dsl._create(ca.berlingoqc.growbe_android_module.proto.Module.VirtualRelay.newBuilder()).apply { block() }._build()
object VirtualRelayKt {
  @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
  @com.google.protobuf.kotlin.ProtoDslMarker
  class Dsl private constructor(
    private val _builder: ca.berlingoqc.growbe_android_module.proto.Module.VirtualRelay.Builder
  ) {
    companion object {
      @kotlin.jvm.JvmSynthetic
      @kotlin.PublishedApi
      internal fun _create(builder: ca.berlingoqc.growbe_android_module.proto.Module.VirtualRelay.Builder): Dsl = Dsl(builder)
    }

    @kotlin.jvm.JvmSynthetic
    @kotlin.PublishedApi
    internal fun _build(): ca.berlingoqc.growbe_android_module.proto.Module.VirtualRelay = _builder.build()

    /**
     * <code>string name = 1;</code>
     */
    var name: kotlin.String
      @JvmName("getName")
      get() = _builder.getName()
      @JvmName("setName")
      set(value) {
        _builder.setName(value)
      }
    /**
     * <code>string name = 1;</code>
     */
    fun clearName() {
      _builder.clearName()
    }

    /**
     * An uninstantiable, behaviorless type to represent the field in
     * generics.
     */
    @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
    class RelaysProxy private constructor() : com.google.protobuf.kotlin.DslProxy()
    /**
     * <code>map&lt;string, .VirtualRelayItem&gt; relays = 2;</code>
     */
     val relays: com.google.protobuf.kotlin.DslMap<kotlin.String, ca.berlingoqc.growbe_android_module.proto.Module.VirtualRelayItem, RelaysProxy>
      @kotlin.jvm.JvmSynthetic
      @JvmName("getRelaysMap")
      get() = com.google.protobuf.kotlin.DslMap(
        _builder.getRelaysMap()
      )
    /**
     * <code>map&lt;string, .VirtualRelayItem&gt; relays = 2;</code>
     */
    @JvmName("putRelays")
    fun com.google.protobuf.kotlin.DslMap<kotlin.String, ca.berlingoqc.growbe_android_module.proto.Module.VirtualRelayItem, RelaysProxy>
      .put(key: kotlin.String, value: ca.berlingoqc.growbe_android_module.proto.Module.VirtualRelayItem) {
         _builder.putRelays(key, value)
       }
    /**
     * <code>map&lt;string, .VirtualRelayItem&gt; relays = 2;</code>
     */
    @kotlin.jvm.JvmSynthetic
    @JvmName("setRelays")
    @Suppress("NOTHING_TO_INLINE")
    inline operator fun com.google.protobuf.kotlin.DslMap<kotlin.String, ca.berlingoqc.growbe_android_module.proto.Module.VirtualRelayItem, RelaysProxy>
      .set(key: kotlin.String, value: ca.berlingoqc.growbe_android_module.proto.Module.VirtualRelayItem) {
         put(key, value)
       }
    /**
     * <code>map&lt;string, .VirtualRelayItem&gt; relays = 2;</code>
     */
    @kotlin.jvm.JvmSynthetic
    @JvmName("removeRelays")
    fun com.google.protobuf.kotlin.DslMap<kotlin.String, ca.berlingoqc.growbe_android_module.proto.Module.VirtualRelayItem, RelaysProxy>
      .remove(key: kotlin.String) {
         _builder.removeRelays(key)
       }
    /**
     * <code>map&lt;string, .VirtualRelayItem&gt; relays = 2;</code>
     */
    @kotlin.jvm.JvmSynthetic
    @JvmName("putAllRelays")
    fun com.google.protobuf.kotlin.DslMap<kotlin.String, ca.berlingoqc.growbe_android_module.proto.Module.VirtualRelayItem, RelaysProxy>
      .putAll(map: kotlin.collections.Map<kotlin.String, ca.berlingoqc.growbe_android_module.proto.Module.VirtualRelayItem>) {
         _builder.putAllRelays(map)
       }
    /**
     * <code>map&lt;string, .VirtualRelayItem&gt; relays = 2;</code>
     */
    @kotlin.jvm.JvmSynthetic
    @JvmName("clearRelays")
    fun com.google.protobuf.kotlin.DslMap<kotlin.String, ca.berlingoqc.growbe_android_module.proto.Module.VirtualRelayItem, RelaysProxy>
      .clear() {
         _builder.clearRelays()
       }
  }
}
@kotlin.jvm.JvmSynthetic
inline fun ca.berlingoqc.growbe_android_module.proto.Module.VirtualRelay.copy(block: ca.berlingoqc.growbe_android_module.proto.VirtualRelayKt.Dsl.() -> kotlin.Unit): ca.berlingoqc.growbe_android_module.proto.Module.VirtualRelay =
  ca.berlingoqc.growbe_android_module.proto.VirtualRelayKt.Dsl._create(this.toBuilder()).apply { block() }._build()
