//Generated by the protocol buffer compiler. DO NOT EDIT!
// source: module.proto

package ca.berlingoqc.growbe_android_module.proto;

@kotlin.jvm.JvmName("-initializephoneStreamingConfig")
inline fun phoneStreamingConfig(block: ca.berlingoqc.growbe_android_module.proto.PhoneStreamingConfigKt.Dsl.() -> kotlin.Unit): ca.berlingoqc.growbe_android_module.proto.Module.PhoneStreamingConfig =
  ca.berlingoqc.growbe_android_module.proto.PhoneStreamingConfigKt.Dsl._create(ca.berlingoqc.growbe_android_module.proto.Module.PhoneStreamingConfig.newBuilder()).apply { block() }._build()
object PhoneStreamingConfigKt {
  @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
  @com.google.protobuf.kotlin.ProtoDslMarker
  class Dsl private constructor(
    private val _builder: ca.berlingoqc.growbe_android_module.proto.Module.PhoneStreamingConfig.Builder
  ) {
    companion object {
      @kotlin.jvm.JvmSynthetic
      @kotlin.PublishedApi
      internal fun _create(builder: ca.berlingoqc.growbe_android_module.proto.Module.PhoneStreamingConfig.Builder): Dsl = Dsl(builder)
    }

    @kotlin.jvm.JvmSynthetic
    @kotlin.PublishedApi
    internal fun _build(): ca.berlingoqc.growbe_android_module.proto.Module.PhoneStreamingConfig = _builder.build()

    /**
     * <code>bool activated = 1;</code>
     */
    var activated: kotlin.Boolean
      @JvmName("getActivated")
      get() = _builder.getActivated()
      @JvmName("setActivated")
      set(value) {
        _builder.setActivated(value)
      }
    /**
     * <code>bool activated = 1;</code>
     */
    fun clearActivated() {
      _builder.clearActivated()
    }

    /**
     * <code>.PhoneStreamingOutput output = 2;</code>
     */
     var output: ca.berlingoqc.growbe_android_module.proto.Module.PhoneStreamingOutput
      @JvmName("getOutput")
      get() = _builder.getOutput()
      @JvmName("setOutput")
      set(value) {
        _builder.setOutput(value)
      }
    /**
     * <code>.PhoneStreamingOutput output = 2;</code>
     */
    fun clearOutput() {
      _builder.clearOutput()
    }

    /**
     * <code>string url = 3;</code>
     */
    var url: kotlin.String
      @JvmName("getUrl")
      get() = _builder.getUrl()
      @JvmName("setUrl")
      set(value) {
        _builder.setUrl(value)
      }
    /**
     * <code>string url = 3;</code>
     */
    fun clearUrl() {
      _builder.clearUrl()
    }

    /**
     * <code>.PhoneStreamingCamera camera = 4;</code>
     */
     var camera: ca.berlingoqc.growbe_android_module.proto.Module.PhoneStreamingCamera
      @JvmName("getCamera")
      get() = _builder.getCamera()
      @JvmName("setCamera")
      set(value) {
        _builder.setCamera(value)
      }
    /**
     * <code>.PhoneStreamingCamera camera = 4;</code>
     */
    fun clearCamera() {
      _builder.clearCamera()
    }

    /**
     * <code>bool light = 5;</code>
     */
    var light: kotlin.Boolean
      @JvmName("getLight")
      get() = _builder.getLight()
      @JvmName("setLight")
      set(value) {
        _builder.setLight(value)
      }
    /**
     * <code>bool light = 5;</code>
     */
    fun clearLight() {
      _builder.clearLight()
    }

    /**
     * <code>bool audio = 6;</code>
     */
    var audio: kotlin.Boolean
      @JvmName("getAudio")
      get() = _builder.getAudio()
      @JvmName("setAudio")
      set(value) {
        _builder.setAudio(value)
      }
    /**
     * <code>bool audio = 6;</code>
     */
    fun clearAudio() {
      _builder.clearAudio()
    }

    /**
     * <code>bool autoFocus = 7;</code>
     */
    var autoFocus: kotlin.Boolean
      @JvmName("getAutoFocus")
      get() = _builder.getAutoFocus()
      @JvmName("setAutoFocus")
      set(value) {
        _builder.setAutoFocus(value)
      }
    /**
     * <code>bool autoFocus = 7;</code>
     */
    fun clearAutoFocus() {
      _builder.clearAutoFocus()
    }

    /**
     * <code>bool stabilization = 8;</code>
     */
    var stabilization: kotlin.Boolean
      @JvmName("getStabilization")
      get() = _builder.getStabilization()
      @JvmName("setStabilization")
      set(value) {
        _builder.setStabilization(value)
      }
    /**
     * <code>bool stabilization = 8;</code>
     */
    fun clearStabilization() {
      _builder.clearStabilization()
    }

    /**
     * <code>bool faceDetection = 9;</code>
     */
    var faceDetection: kotlin.Boolean
      @JvmName("getFaceDetection")
      get() = _builder.getFaceDetection()
      @JvmName("setFaceDetection")
      set(value) {
        _builder.setFaceDetection(value)
      }
    /**
     * <code>bool faceDetection = 9;</code>
     */
    fun clearFaceDetection() {
      _builder.clearFaceDetection()
    }

    /**
     * <code>int32 zoom = 10;</code>
     */
    var zoom: kotlin.Int
      @JvmName("getZoom")
      get() = _builder.getZoom()
      @JvmName("setZoom")
      set(value) {
        _builder.setZoom(value)
      }
    /**
     * <code>int32 zoom = 10;</code>
     */
    fun clearZoom() {
      _builder.clearZoom()
    }
  }
}
@kotlin.jvm.JvmSynthetic
inline fun ca.berlingoqc.growbe_android_module.proto.Module.PhoneStreamingConfig.copy(block: ca.berlingoqc.growbe_android_module.proto.PhoneStreamingConfigKt.Dsl.() -> kotlin.Unit): ca.berlingoqc.growbe_android_module.proto.Module.PhoneStreamingConfig =
  ca.berlingoqc.growbe_android_module.proto.PhoneStreamingConfigKt.Dsl._create(this.toBuilder()).apply { block() }._build()

