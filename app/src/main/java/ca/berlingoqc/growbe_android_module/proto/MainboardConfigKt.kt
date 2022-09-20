//Generated by the protocol buffer compiler. DO NOT EDIT!
// source: board.proto

package ca.berlingoqc.growbe_android_module.proto;

@kotlin.jvm.JvmName("-initializemainboardConfig")
inline fun mainboardConfig(block: ca.berlingoqc.growbe_android_module.proto.MainboardConfigKt.Dsl.() -> kotlin.Unit): ca.berlingoqc.growbe_android_module.proto.Board.MainboardConfig =
  ca.berlingoqc.growbe_android_module.proto.MainboardConfigKt.Dsl._create(ca.berlingoqc.growbe_android_module.proto.Board.MainboardConfig.newBuilder()).apply { block() }._build()
object MainboardConfigKt {
  @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
  @com.google.protobuf.kotlin.ProtoDslMarker
  class Dsl private constructor(
    private val _builder: ca.berlingoqc.growbe_android_module.proto.Board.MainboardConfig.Builder
  ) {
    companion object {
      @kotlin.jvm.JvmSynthetic
      @kotlin.PublishedApi
      internal fun _create(builder: ca.berlingoqc.growbe_android_module.proto.Board.MainboardConfig.Builder): Dsl = Dsl(builder)
    }

    @kotlin.jvm.JvmSynthetic
    @kotlin.PublishedApi
    internal fun _build(): ca.berlingoqc.growbe_android_module.proto.Board.MainboardConfig = _builder.build()

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
     * <code>.MQTTConfig mqtt = 2;</code>
     */
    var mqtt: ca.berlingoqc.growbe_android_module.proto.Board.MQTTConfig
      @JvmName("getMqtt")
      get() = _builder.getMqtt()
      @JvmName("setMqtt")
      set(value) {
        _builder.setMqtt(value)
      }
    /**
     * <code>.MQTTConfig mqtt = 2;</code>
     */
    fun clearMqtt() {
      _builder.clearMqtt()
    }
    /**
     * <code>.MQTTConfig mqtt = 2;</code>
     * @return Whether the mqtt field is set.
     */
    fun hasMqtt(): kotlin.Boolean {
      return _builder.hasMqtt()
    }

    /**
     * <code>.ComboardConfig comboard = 3;</code>
     */
    var comboard: ca.berlingoqc.growbe_android_module.proto.Board.ComboardConfig
      @JvmName("getComboard")
      get() = _builder.getComboard()
      @JvmName("setComboard")
      set(value) {
        _builder.setComboard(value)
      }
    /**
     * <code>.ComboardConfig comboard = 3;</code>
     */
    fun clearComboard() {
      _builder.clearComboard()
    }
    /**
     * <code>.ComboardConfig comboard = 3;</code>
     * @return Whether the comboard field is set.
     */
    fun hasComboard(): kotlin.Boolean {
      return _builder.hasComboard()
    }

    /**
     * An uninstantiable, behaviorless type to represent the field in
     * generics.
     */
    @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
    class ComboardsProxy private constructor() : com.google.protobuf.kotlin.DslProxy()
    /**
     * <code>repeated .ComboardConfig comboards = 7;</code>
     */
     val comboards: com.google.protobuf.kotlin.DslList<ca.berlingoqc.growbe_android_module.proto.Board.ComboardConfig, ComboardsProxy>
      @kotlin.jvm.JvmSynthetic
      get() = com.google.protobuf.kotlin.DslList(
        _builder.getComboardsList()
      )
    /**
     * <code>repeated .ComboardConfig comboards = 7;</code>
     * @param value The comboards to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("addComboards")
    fun com.google.protobuf.kotlin.DslList<ca.berlingoqc.growbe_android_module.proto.Board.ComboardConfig, ComboardsProxy>.add(value: ca.berlingoqc.growbe_android_module.proto.Board.ComboardConfig) {
      _builder.addComboards(value)
    }
    /**
     * <code>repeated .ComboardConfig comboards = 7;</code>
     * @param value The comboards to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("plusAssignComboards")
    @Suppress("NOTHING_TO_INLINE")
    inline operator fun com.google.protobuf.kotlin.DslList<ca.berlingoqc.growbe_android_module.proto.Board.ComboardConfig, ComboardsProxy>.plusAssign(value: ca.berlingoqc.growbe_android_module.proto.Board.ComboardConfig) {
      add(value)
    }
    /**
     * <code>repeated .ComboardConfig comboards = 7;</code>
     * @param values The comboards to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("addAllComboards")
    fun com.google.protobuf.kotlin.DslList<ca.berlingoqc.growbe_android_module.proto.Board.ComboardConfig, ComboardsProxy>.addAll(values: kotlin.collections.Iterable<ca.berlingoqc.growbe_android_module.proto.Board.ComboardConfig>) {
      _builder.addAllComboards(values)
    }
    /**
     * <code>repeated .ComboardConfig comboards = 7;</code>
     * @param values The comboards to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("plusAssignAllComboards")
    @Suppress("NOTHING_TO_INLINE")
    inline operator fun com.google.protobuf.kotlin.DslList<ca.berlingoqc.growbe_android_module.proto.Board.ComboardConfig, ComboardsProxy>.plusAssign(values: kotlin.collections.Iterable<ca.berlingoqc.growbe_android_module.proto.Board.ComboardConfig>) {
      addAll(values)
    }
    /**
     * <code>repeated .ComboardConfig comboards = 7;</code>
     * @param index The index to set the value at.
     * @param value The comboards to set.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("setComboards")
    operator fun com.google.protobuf.kotlin.DslList<ca.berlingoqc.growbe_android_module.proto.Board.ComboardConfig, ComboardsProxy>.set(index: kotlin.Int, value: ca.berlingoqc.growbe_android_module.proto.Board.ComboardConfig) {
      _builder.setComboards(index, value)
    }
    /**
     * <code>repeated .ComboardConfig comboards = 7;</code>
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("clearComboards")
    fun com.google.protobuf.kotlin.DslList<ca.berlingoqc.growbe_android_module.proto.Board.ComboardConfig, ComboardsProxy>.clear() {
      _builder.clearComboards()
    }


    /**
     * <code>.HttpServerConfig server = 4;</code>
     */
    var server: ca.berlingoqc.growbe_android_module.proto.Board.HttpServerConfig
      @JvmName("getServer")
      get() = _builder.getServer()
      @JvmName("setServer")
      set(value) {
        _builder.setServer(value)
      }
    /**
     * <code>.HttpServerConfig server = 4;</code>
     */
    fun clearServer() {
      _builder.clearServer()
    }
    /**
     * <code>.HttpServerConfig server = 4;</code>
     * @return Whether the server field is set.
     */
    fun hasServer(): kotlin.Boolean {
      return _builder.hasServer()
    }

    /**
     * <code>.LoggerConfig logger = 5;</code>
     */
    var logger: ca.berlingoqc.growbe_android_module.proto.Board.LoggerConfig
      @JvmName("getLogger")
      get() = _builder.getLogger()
      @JvmName("setLogger")
      set(value) {
        _builder.setLogger(value)
      }
    /**
     * <code>.LoggerConfig logger = 5;</code>
     */
    fun clearLogger() {
      _builder.clearLogger()
    }
    /**
     * <code>.LoggerConfig logger = 5;</code>
     * @return Whether the logger field is set.
     */
    fun hasLogger(): kotlin.Boolean {
      return _builder.hasLogger()
    }

    /**
     * <code>.UpdaterConfig update = 6;</code>
     */
    var update: ca.berlingoqc.growbe_android_module.proto.Board.UpdaterConfig
      @JvmName("getUpdate")
      get() = _builder.getUpdate()
      @JvmName("setUpdate")
      set(value) {
        _builder.setUpdate(value)
      }
    /**
     * <code>.UpdaterConfig update = 6;</code>
     */
    fun clearUpdate() {
      _builder.clearUpdate()
    }
    /**
     * <code>.UpdaterConfig update = 6;</code>
     * @return Whether the update field is set.
     */
    fun hasUpdate(): kotlin.Boolean {
      return _builder.hasUpdate()
    }
  }
}
@kotlin.jvm.JvmSynthetic
inline fun ca.berlingoqc.growbe_android_module.proto.Board.MainboardConfig.copy(block: ca.berlingoqc.growbe_android_module.proto.MainboardConfigKt.Dsl.() -> kotlin.Unit): ca.berlingoqc.growbe_android_module.proto.Board.MainboardConfig =
  ca.berlingoqc.growbe_android_module.proto.MainboardConfigKt.Dsl._create(this.toBuilder()).apply { block() }._build()

val ca.berlingoqc.growbe_android_module.proto.Board.MainboardConfigOrBuilder.mqttOrNull: ca.berlingoqc.growbe_android_module.proto.Board.MQTTConfig?
  get() = if (hasMqtt()) getMqtt() else null

val ca.berlingoqc.growbe_android_module.proto.Board.MainboardConfigOrBuilder.comboardOrNull: ca.berlingoqc.growbe_android_module.proto.Board.ComboardConfig?
  get() = if (hasComboard()) getComboard() else null

val ca.berlingoqc.growbe_android_module.proto.Board.MainboardConfigOrBuilder.serverOrNull: ca.berlingoqc.growbe_android_module.proto.Board.HttpServerConfig?
  get() = if (hasServer()) getServer() else null

val ca.berlingoqc.growbe_android_module.proto.Board.MainboardConfigOrBuilder.loggerOrNull: ca.berlingoqc.growbe_android_module.proto.Board.LoggerConfig?
  get() = if (hasLogger()) getLogger() else null

val ca.berlingoqc.growbe_android_module.proto.Board.MainboardConfigOrBuilder.updateOrNull: ca.berlingoqc.growbe_android_module.proto.Board.UpdaterConfig?
  get() = if (hasUpdate()) getUpdate() else null

