//Generated by the protocol buffer compiler. DO NOT EDIT!
// source: board.proto

package ca.berlingoqc.growbe_android_module.proto;

@kotlin.jvm.JvmName("-initializehelloWord")
inline fun helloWord(block: ca.berlingoqc.growbe_android_module.proto.HelloWordKt.Dsl.() -> kotlin.Unit): ca.berlingoqc.growbe_android_module.proto.Board.HelloWord =
  ca.berlingoqc.growbe_android_module.proto.HelloWordKt.Dsl._create(ca.berlingoqc.growbe_android_module.proto.Board.HelloWord.newBuilder()).apply { block() }._build()
object HelloWordKt {
  @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
  @com.google.protobuf.kotlin.ProtoDslMarker
  class Dsl private constructor(
    private val _builder: ca.berlingoqc.growbe_android_module.proto.Board.HelloWord.Builder
  ) {
    companion object {
      @kotlin.jvm.JvmSynthetic
      @kotlin.PublishedApi
      internal fun _create(builder: ca.berlingoqc.growbe_android_module.proto.Board.HelloWord.Builder): Dsl = Dsl(builder)
    }

    @kotlin.jvm.JvmSynthetic
    @kotlin.PublishedApi
    internal fun _build(): ca.berlingoqc.growbe_android_module.proto.Board.HelloWord = _builder.build()

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
     * <code>string cloudVersion = 2;</code>
     */
    var cloudVersion: kotlin.String
      @JvmName("getCloudVersion")
      get() = _builder.getCloudVersion()
      @JvmName("setCloudVersion")
      set(value) {
        _builder.setCloudVersion(value)
      }
    /**
     * <code>string cloudVersion = 2;</code>
     */
    fun clearCloudVersion() {
      _builder.clearCloudVersion()
    }

    /**
     * <code>string RTC = 3;</code>
     */
    var rTC: kotlin.String
      @JvmName("getRTC")
      get() = _builder.getRTC()
      @JvmName("setRTC")
      set(value) {
        _builder.setRTC(value)
      }
    /**
     * <code>string RTC = 3;</code>
     */
    fun clearRTC() {
      _builder.clearRTC()
    }

    /**
     * An uninstantiable, behaviorless type to represent the field in
     * generics.
     */
    @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
    class BoardsProxy private constructor() : com.google.protobuf.kotlin.DslProxy()
    /**
     * <code>repeated .RunningComboard boards = 4;</code>
     */
     val boards: com.google.protobuf.kotlin.DslList<ca.berlingoqc.growbe_android_module.proto.Board.RunningComboard, BoardsProxy>
      @kotlin.jvm.JvmSynthetic
      get() = com.google.protobuf.kotlin.DslList(
        _builder.getBoardsList()
      )
    /**
     * <code>repeated .RunningComboard boards = 4;</code>
     * @param value The boards to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("addBoards")
    fun com.google.protobuf.kotlin.DslList<ca.berlingoqc.growbe_android_module.proto.Board.RunningComboard, BoardsProxy>.add(value: ca.berlingoqc.growbe_android_module.proto.Board.RunningComboard) {
      _builder.addBoards(value)
    }
    /**
     * <code>repeated .RunningComboard boards = 4;</code>
     * @param value The boards to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("plusAssignBoards")
    @Suppress("NOTHING_TO_INLINE")
    inline operator fun com.google.protobuf.kotlin.DslList<ca.berlingoqc.growbe_android_module.proto.Board.RunningComboard, BoardsProxy>.plusAssign(value: ca.berlingoqc.growbe_android_module.proto.Board.RunningComboard) {
      add(value)
    }
    /**
     * <code>repeated .RunningComboard boards = 4;</code>
     * @param values The boards to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("addAllBoards")
    fun com.google.protobuf.kotlin.DslList<ca.berlingoqc.growbe_android_module.proto.Board.RunningComboard, BoardsProxy>.addAll(values: kotlin.collections.Iterable<ca.berlingoqc.growbe_android_module.proto.Board.RunningComboard>) {
      _builder.addAllBoards(values)
    }
    /**
     * <code>repeated .RunningComboard boards = 4;</code>
     * @param values The boards to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("plusAssignAllBoards")
    @Suppress("NOTHING_TO_INLINE")
    inline operator fun com.google.protobuf.kotlin.DslList<ca.berlingoqc.growbe_android_module.proto.Board.RunningComboard, BoardsProxy>.plusAssign(values: kotlin.collections.Iterable<ca.berlingoqc.growbe_android_module.proto.Board.RunningComboard>) {
      addAll(values)
    }
    /**
     * <code>repeated .RunningComboard boards = 4;</code>
     * @param index The index to set the value at.
     * @param value The boards to set.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("setBoards")
    operator fun com.google.protobuf.kotlin.DslList<ca.berlingoqc.growbe_android_module.proto.Board.RunningComboard, BoardsProxy>.set(index: kotlin.Int, value: ca.berlingoqc.growbe_android_module.proto.Board.RunningComboard) {
      _builder.setBoards(index, value)
    }
    /**
     * <code>repeated .RunningComboard boards = 4;</code>
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("clearBoards")
    fun com.google.protobuf.kotlin.DslList<ca.berlingoqc.growbe_android_module.proto.Board.RunningComboard, BoardsProxy>.clear() {
      _builder.clearBoards()
    }

  }
}
@kotlin.jvm.JvmSynthetic
inline fun ca.berlingoqc.growbe_android_module.proto.Board.HelloWord.copy(block: ca.berlingoqc.growbe_android_module.proto.HelloWordKt.Dsl.() -> kotlin.Unit): ca.berlingoqc.growbe_android_module.proto.Board.HelloWord =
  ca.berlingoqc.growbe_android_module.proto.HelloWordKt.Dsl._create(this.toBuilder()).apply { block() }._build()
