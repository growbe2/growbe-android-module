//Generated by the protocol buffer compiler. DO NOT EDIT!
// source: module.proto

package ca.berlingoqc.growbe_android_module.proto;

@kotlin.jvm.JvmName("-initializecameraFace")
inline fun cameraFace(block: ca.berlingoqc.growbe_android_module.proto.CameraFaceKt.Dsl.() -> kotlin.Unit): ca.berlingoqc.growbe_android_module.proto.Module.CameraFace =
  ca.berlingoqc.growbe_android_module.proto.CameraFaceKt.Dsl._create(ca.berlingoqc.growbe_android_module.proto.Module.CameraFace.newBuilder()).apply { block() }._build()
object CameraFaceKt {
  @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
  @com.google.protobuf.kotlin.ProtoDslMarker
  class Dsl private constructor(
    private val _builder: ca.berlingoqc.growbe_android_module.proto.Module.CameraFace.Builder
  ) {
    companion object {
      @kotlin.jvm.JvmSynthetic
      @kotlin.PublishedApi
      internal fun _create(builder: ca.berlingoqc.growbe_android_module.proto.Module.CameraFace.Builder): Dsl = Dsl(builder)
    }

    @kotlin.jvm.JvmSynthetic
    @kotlin.PublishedApi
    internal fun _build(): ca.berlingoqc.growbe_android_module.proto.Module.CameraFace = _builder.build()

    /**
     * <code>int32 id = 1;</code>
     */
    var id: kotlin.Int
      @JvmName("getId")
      get() = _builder.getId()
      @JvmName("setId")
      set(value) {
        _builder.setId(value)
      }
    /**
     * <code>int32 id = 1;</code>
     */
    fun clearId() {
      _builder.clearId()
    }

    /**
     * <code>int32 score = 2;</code>
     */
    var score: kotlin.Int
      @JvmName("getScore")
      get() = _builder.getScore()
      @JvmName("setScore")
      set(value) {
        _builder.setScore(value)
      }
    /**
     * <code>int32 score = 2;</code>
     */
    fun clearScore() {
      _builder.clearScore()
    }

    /**
     * <code>.Rect rect = 3;</code>
     */
    var rect: ca.berlingoqc.growbe_android_module.proto.Module.Rect
      @JvmName("getRect")
      get() = _builder.getRect()
      @JvmName("setRect")
      set(value) {
        _builder.setRect(value)
      }
    /**
     * <code>.Rect rect = 3;</code>
     */
    fun clearRect() {
      _builder.clearRect()
    }
    /**
     * <code>.Rect rect = 3;</code>
     * @return Whether the rect field is set.
     */
    fun hasRect(): kotlin.Boolean {
      return _builder.hasRect()
    }

    /**
     * <code>.Point mouth = 4;</code>
     */
    var mouth: ca.berlingoqc.growbe_android_module.proto.Module.Point
      @JvmName("getMouth")
      get() = _builder.getMouth()
      @JvmName("setMouth")
      set(value) {
        _builder.setMouth(value)
      }
    /**
     * <code>.Point mouth = 4;</code>
     */
    fun clearMouth() {
      _builder.clearMouth()
    }
    /**
     * <code>.Point mouth = 4;</code>
     * @return Whether the mouth field is set.
     */
    fun hasMouth(): kotlin.Boolean {
      return _builder.hasMouth()
    }

    /**
     * <code>.Point leftEye = 5;</code>
     */
    var leftEye: ca.berlingoqc.growbe_android_module.proto.Module.Point
      @JvmName("getLeftEye")
      get() = _builder.getLeftEye()
      @JvmName("setLeftEye")
      set(value) {
        _builder.setLeftEye(value)
      }
    /**
     * <code>.Point leftEye = 5;</code>
     */
    fun clearLeftEye() {
      _builder.clearLeftEye()
    }
    /**
     * <code>.Point leftEye = 5;</code>
     * @return Whether the leftEye field is set.
     */
    fun hasLeftEye(): kotlin.Boolean {
      return _builder.hasLeftEye()
    }

    /**
     * <code>.Point rightEye = 6;</code>
     */
    var rightEye: ca.berlingoqc.growbe_android_module.proto.Module.Point
      @JvmName("getRightEye")
      get() = _builder.getRightEye()
      @JvmName("setRightEye")
      set(value) {
        _builder.setRightEye(value)
      }
    /**
     * <code>.Point rightEye = 6;</code>
     */
    fun clearRightEye() {
      _builder.clearRightEye()
    }
    /**
     * <code>.Point rightEye = 6;</code>
     * @return Whether the rightEye field is set.
     */
    fun hasRightEye(): kotlin.Boolean {
      return _builder.hasRightEye()
    }
  }
}
@kotlin.jvm.JvmSynthetic
inline fun ca.berlingoqc.growbe_android_module.proto.Module.CameraFace.copy(block: ca.berlingoqc.growbe_android_module.proto.CameraFaceKt.Dsl.() -> kotlin.Unit): ca.berlingoqc.growbe_android_module.proto.Module.CameraFace =
  ca.berlingoqc.growbe_android_module.proto.CameraFaceKt.Dsl._create(this.toBuilder()).apply { block() }._build()

val ca.berlingoqc.growbe_android_module.proto.Module.CameraFaceOrBuilder.rectOrNull: ca.berlingoqc.growbe_android_module.proto.Module.Rect?
  get() = if (hasRect()) getRect() else null

val ca.berlingoqc.growbe_android_module.proto.Module.CameraFaceOrBuilder.mouthOrNull: ca.berlingoqc.growbe_android_module.proto.Module.Point?
  get() = if (hasMouth()) getMouth() else null

val ca.berlingoqc.growbe_android_module.proto.Module.CameraFaceOrBuilder.leftEyeOrNull: ca.berlingoqc.growbe_android_module.proto.Module.Point?
  get() = if (hasLeftEye()) getLeftEye() else null

val ca.berlingoqc.growbe_android_module.proto.Module.CameraFaceOrBuilder.rightEyeOrNull: ca.berlingoqc.growbe_android_module.proto.Module.Point?
  get() = if (hasRightEye()) getRightEye() else null
