//Generated by the protocol buffer compiler. DO NOT EDIT!
// source: alarm.proto

package ca.berlingoqc.growbe_android_module.proto;

@kotlin.jvm.JvmName("-initializefieldAlarmEvent")
inline fun fieldAlarmEvent(block: ca.berlingoqc.growbe_android_module.proto.FieldAlarmEventKt.Dsl.() -> kotlin.Unit): ca.berlingoqc.growbe_android_module.proto.Alarm.FieldAlarmEvent =
  ca.berlingoqc.growbe_android_module.proto.FieldAlarmEventKt.Dsl._create(ca.berlingoqc.growbe_android_module.proto.Alarm.FieldAlarmEvent.newBuilder()).apply { block() }._build()
object FieldAlarmEventKt {
  @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
  @com.google.protobuf.kotlin.ProtoDslMarker
  class Dsl private constructor(
    private val _builder: ca.berlingoqc.growbe_android_module.proto.Alarm.FieldAlarmEvent.Builder
  ) {
    companion object {
      @kotlin.jvm.JvmSynthetic
      @kotlin.PublishedApi
      internal fun _create(builder: ca.berlingoqc.growbe_android_module.proto.Alarm.FieldAlarmEvent.Builder): Dsl = Dsl(builder)
    }

    @kotlin.jvm.JvmSynthetic
    @kotlin.PublishedApi
    internal fun _build(): ca.berlingoqc.growbe_android_module.proto.Alarm.FieldAlarmEvent = _builder.build()

    /**
     * <code>string moduleId = 1;</code>
     */
    var moduleId: kotlin.String
      @JvmName("getModuleId")
      get() = _builder.getModuleId()
      @JvmName("setModuleId")
      set(value) {
        _builder.setModuleId(value)
      }
    /**
     * <code>string moduleId = 1;</code>
     */
    fun clearModuleId() {
      _builder.clearModuleId()
    }

    /**
     * <code>string property = 2;</code>
     */
    var property: kotlin.String
      @JvmName("getProperty")
      get() = _builder.getProperty()
      @JvmName("setProperty")
      set(value) {
        _builder.setProperty(value)
      }
    /**
     * <code>string property = 2;</code>
     */
    fun clearProperty() {
      _builder.clearProperty()
    }

    /**
     * <code>.AlarmZone previousZone = 3;</code>
     */
     var previousZone: ca.berlingoqc.growbe_android_module.proto.Alarm.AlarmZone
      @JvmName("getPreviousZone")
      get() = _builder.getPreviousZone()
      @JvmName("setPreviousZone")
      set(value) {
        _builder.setPreviousZone(value)
      }
    /**
     * <code>.AlarmZone previousZone = 3;</code>
     */
    fun clearPreviousZone() {
      _builder.clearPreviousZone()
    }

    /**
     * <code>.AlarmZone currentZone = 4;</code>
     */
     var currentZone: ca.berlingoqc.growbe_android_module.proto.Alarm.AlarmZone
      @JvmName("getCurrentZone")
      get() = _builder.getCurrentZone()
      @JvmName("setCurrentZone")
      set(value) {
        _builder.setCurrentZone(value)
      }
    /**
     * <code>.AlarmZone currentZone = 4;</code>
     */
    fun clearCurrentZone() {
      _builder.clearCurrentZone()
    }

    /**
     * <code>uint32 currentValue = 5;</code>
     */
    var currentValue: kotlin.Int
      @JvmName("getCurrentValue")
      get() = _builder.getCurrentValue()
      @JvmName("setCurrentValue")
      set(value) {
        _builder.setCurrentValue(value)
      }
    /**
     * <code>uint32 currentValue = 5;</code>
     */
    fun clearCurrentValue() {
      _builder.clearCurrentValue()
    }

    /**
     * <code>uint32 previousValue = 6;</code>
     */
    var previousValue: kotlin.Int
      @JvmName("getPreviousValue")
      get() = _builder.getPreviousValue()
      @JvmName("setPreviousValue")
      set(value) {
        _builder.setPreviousValue(value)
      }
    /**
     * <code>uint32 previousValue = 6;</code>
     */
    fun clearPreviousValue() {
      _builder.clearPreviousValue()
    }
  }
}
@kotlin.jvm.JvmSynthetic
inline fun ca.berlingoqc.growbe_android_module.proto.Alarm.FieldAlarmEvent.copy(block: ca.berlingoqc.growbe_android_module.proto.FieldAlarmEventKt.Dsl.() -> kotlin.Unit): ca.berlingoqc.growbe_android_module.proto.Alarm.FieldAlarmEvent =
  ca.berlingoqc.growbe_android_module.proto.FieldAlarmEventKt.Dsl._create(this.toBuilder()).apply { block() }._build()

