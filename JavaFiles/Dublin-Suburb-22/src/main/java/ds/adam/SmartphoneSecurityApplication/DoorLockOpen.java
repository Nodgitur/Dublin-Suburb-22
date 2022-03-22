// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: SmartphoneSecurityApplication.proto

package ds.adam.SmartphoneSecurityApplication;

/**
 * Protobuf type {@code SmartphoneSecurityApplication.DoorLockOpen}
 */
public  final class DoorLockOpen extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:SmartphoneSecurityApplication.DoorLockOpen)
    DoorLockOpenOrBuilder {
private static final long serialVersionUID = 0L;
  // Use DoorLockOpen.newBuilder() to construct.
  private DoorLockOpen(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private DoorLockOpen() {
    passCode_ = 0;
    userAccept_ = 0;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private DoorLockOpen(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 8: {
            int rawValue = input.readEnum();

            passCode_ = rawValue;
            break;
          }
          case 16: {

            userAccept_ = input.readInt32();
            break;
          }
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return ds.adam.SmartphoneSecurityApplication.SmartphoneSecurityApplicationServiceImpl.internal_static_SmartphoneSecurityApplication_DoorLockOpen_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return ds.adam.SmartphoneSecurityApplication.SmartphoneSecurityApplicationServiceImpl.internal_static_SmartphoneSecurityApplication_DoorLockOpen_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            ds.adam.SmartphoneSecurityApplication.DoorLockOpen.class, ds.adam.SmartphoneSecurityApplication.DoorLockOpen.Builder.class);
  }

  /**
   * Protobuf enum {@code SmartphoneSecurityApplication.DoorLockOpen.PassCode}
   */
  public enum PassCode
      implements com.google.protobuf.ProtocolMessageEnum {
    /**
     * <code>error = 0;</code>
     */
    error(0),
    /**
     * <code>failure = 1;</code>
     */
    failure(1),
    /**
     * <code>success = 2;</code>
     */
    success(2),
    UNRECOGNIZED(-1),
    ;

    /**
     * <code>error = 0;</code>
     */
    public static final int error_VALUE = 0;
    /**
     * <code>failure = 1;</code>
     */
    public static final int failure_VALUE = 1;
    /**
     * <code>success = 2;</code>
     */
    public static final int success_VALUE = 2;


    public final int getNumber() {
      if (this == UNRECOGNIZED) {
        throw new java.lang.IllegalArgumentException(
            "Can't get the number of an unknown enum value.");
      }
      return value;
    }

    /**
     * @deprecated Use {@link #forNumber(int)} instead.
     */
    @java.lang.Deprecated
    public static PassCode valueOf(int value) {
      return forNumber(value);
    }

    public static PassCode forNumber(int value) {
      switch (value) {
        case 0: return error;
        case 1: return failure;
        case 2: return success;
        default: return null;
      }
    }

    public static com.google.protobuf.Internal.EnumLiteMap<PassCode>
        internalGetValueMap() {
      return internalValueMap;
    }
    private static final com.google.protobuf.Internal.EnumLiteMap<
        PassCode> internalValueMap =
          new com.google.protobuf.Internal.EnumLiteMap<PassCode>() {
            public PassCode findValueByNumber(int number) {
              return PassCode.forNumber(number);
            }
          };

    public final com.google.protobuf.Descriptors.EnumValueDescriptor
        getValueDescriptor() {
      return getDescriptor().getValues().get(ordinal());
    }
    public final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptorForType() {
      return getDescriptor();
    }
    public static final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptor() {
      return ds.adam.SmartphoneSecurityApplication.DoorLockOpen.getDescriptor().getEnumTypes().get(0);
    }

    private static final PassCode[] VALUES = values();

    public static PassCode valueOf(
        com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
      if (desc.getType() != getDescriptor()) {
        throw new java.lang.IllegalArgumentException(
          "EnumValueDescriptor is not for this type.");
      }
      if (desc.getIndex() == -1) {
        return UNRECOGNIZED;
      }
      return VALUES[desc.getIndex()];
    }

    private final int value;

    private PassCode(int value) {
      this.value = value;
    }

    // @@protoc_insertion_point(enum_scope:SmartphoneSecurityApplication.DoorLockOpen.PassCode)
  }

  public static final int PASSCODE_FIELD_NUMBER = 1;
  private int passCode_;
  /**
   * <code>.SmartphoneSecurityApplication.DoorLockOpen.PassCode passCode = 1;</code>
   */
  public int getPassCodeValue() {
    return passCode_;
  }
  /**
   * <code>.SmartphoneSecurityApplication.DoorLockOpen.PassCode passCode = 1;</code>
   */
  public ds.adam.SmartphoneSecurityApplication.DoorLockOpen.PassCode getPassCode() {
    @SuppressWarnings("deprecation")
    ds.adam.SmartphoneSecurityApplication.DoorLockOpen.PassCode result = ds.adam.SmartphoneSecurityApplication.DoorLockOpen.PassCode.valueOf(passCode_);
    return result == null ? ds.adam.SmartphoneSecurityApplication.DoorLockOpen.PassCode.UNRECOGNIZED : result;
  }

  public static final int USERACCEPT_FIELD_NUMBER = 2;
  private int userAccept_;
  /**
   * <code>int32 userAccept = 2;</code>
   */
  public int getUserAccept() {
    return userAccept_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (passCode_ != ds.adam.SmartphoneSecurityApplication.DoorLockOpen.PassCode.error.getNumber()) {
      output.writeEnum(1, passCode_);
    }
    if (userAccept_ != 0) {
      output.writeInt32(2, userAccept_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (passCode_ != ds.adam.SmartphoneSecurityApplication.DoorLockOpen.PassCode.error.getNumber()) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(1, passCode_);
    }
    if (userAccept_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(2, userAccept_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof ds.adam.SmartphoneSecurityApplication.DoorLockOpen)) {
      return super.equals(obj);
    }
    ds.adam.SmartphoneSecurityApplication.DoorLockOpen other = (ds.adam.SmartphoneSecurityApplication.DoorLockOpen) obj;

    boolean result = true;
    result = result && passCode_ == other.passCode_;
    result = result && (getUserAccept()
        == other.getUserAccept());
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + PASSCODE_FIELD_NUMBER;
    hash = (53 * hash) + passCode_;
    hash = (37 * hash) + USERACCEPT_FIELD_NUMBER;
    hash = (53 * hash) + getUserAccept();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static ds.adam.SmartphoneSecurityApplication.DoorLockOpen parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ds.adam.SmartphoneSecurityApplication.DoorLockOpen parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ds.adam.SmartphoneSecurityApplication.DoorLockOpen parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ds.adam.SmartphoneSecurityApplication.DoorLockOpen parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ds.adam.SmartphoneSecurityApplication.DoorLockOpen parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ds.adam.SmartphoneSecurityApplication.DoorLockOpen parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ds.adam.SmartphoneSecurityApplication.DoorLockOpen parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ds.adam.SmartphoneSecurityApplication.DoorLockOpen parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static ds.adam.SmartphoneSecurityApplication.DoorLockOpen parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static ds.adam.SmartphoneSecurityApplication.DoorLockOpen parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static ds.adam.SmartphoneSecurityApplication.DoorLockOpen parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ds.adam.SmartphoneSecurityApplication.DoorLockOpen parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(ds.adam.SmartphoneSecurityApplication.DoorLockOpen prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code SmartphoneSecurityApplication.DoorLockOpen}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:SmartphoneSecurityApplication.DoorLockOpen)
      ds.adam.SmartphoneSecurityApplication.DoorLockOpenOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return ds.adam.SmartphoneSecurityApplication.SmartphoneSecurityApplicationServiceImpl.internal_static_SmartphoneSecurityApplication_DoorLockOpen_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return ds.adam.SmartphoneSecurityApplication.SmartphoneSecurityApplicationServiceImpl.internal_static_SmartphoneSecurityApplication_DoorLockOpen_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              ds.adam.SmartphoneSecurityApplication.DoorLockOpen.class, ds.adam.SmartphoneSecurityApplication.DoorLockOpen.Builder.class);
    }

    // Construct using ds.adam.SmartphoneSecurityApplication.DoorLockOpen.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      passCode_ = 0;

      userAccept_ = 0;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return ds.adam.SmartphoneSecurityApplication.SmartphoneSecurityApplicationServiceImpl.internal_static_SmartphoneSecurityApplication_DoorLockOpen_descriptor;
    }

    @java.lang.Override
    public ds.adam.SmartphoneSecurityApplication.DoorLockOpen getDefaultInstanceForType() {
      return ds.adam.SmartphoneSecurityApplication.DoorLockOpen.getDefaultInstance();
    }

    @java.lang.Override
    public ds.adam.SmartphoneSecurityApplication.DoorLockOpen build() {
      ds.adam.SmartphoneSecurityApplication.DoorLockOpen result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public ds.adam.SmartphoneSecurityApplication.DoorLockOpen buildPartial() {
      ds.adam.SmartphoneSecurityApplication.DoorLockOpen result = new ds.adam.SmartphoneSecurityApplication.DoorLockOpen(this);
      result.passCode_ = passCode_;
      result.userAccept_ = userAccept_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return (Builder) super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof ds.adam.SmartphoneSecurityApplication.DoorLockOpen) {
        return mergeFrom((ds.adam.SmartphoneSecurityApplication.DoorLockOpen)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(ds.adam.SmartphoneSecurityApplication.DoorLockOpen other) {
      if (other == ds.adam.SmartphoneSecurityApplication.DoorLockOpen.getDefaultInstance()) return this;
      if (other.passCode_ != 0) {
        setPassCodeValue(other.getPassCodeValue());
      }
      if (other.getUserAccept() != 0) {
        setUserAccept(other.getUserAccept());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      ds.adam.SmartphoneSecurityApplication.DoorLockOpen parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (ds.adam.SmartphoneSecurityApplication.DoorLockOpen) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int passCode_ = 0;
    /**
     * <code>.SmartphoneSecurityApplication.DoorLockOpen.PassCode passCode = 1;</code>
     */
    public int getPassCodeValue() {
      return passCode_;
    }
    /**
     * <code>.SmartphoneSecurityApplication.DoorLockOpen.PassCode passCode = 1;</code>
     */
    public Builder setPassCodeValue(int value) {
      passCode_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>.SmartphoneSecurityApplication.DoorLockOpen.PassCode passCode = 1;</code>
     */
    public ds.adam.SmartphoneSecurityApplication.DoorLockOpen.PassCode getPassCode() {
      @SuppressWarnings("deprecation")
      ds.adam.SmartphoneSecurityApplication.DoorLockOpen.PassCode result = ds.adam.SmartphoneSecurityApplication.DoorLockOpen.PassCode.valueOf(passCode_);
      return result == null ? ds.adam.SmartphoneSecurityApplication.DoorLockOpen.PassCode.UNRECOGNIZED : result;
    }
    /**
     * <code>.SmartphoneSecurityApplication.DoorLockOpen.PassCode passCode = 1;</code>
     */
    public Builder setPassCode(ds.adam.SmartphoneSecurityApplication.DoorLockOpen.PassCode value) {
      if (value == null) {
        throw new NullPointerException();
      }
      
      passCode_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <code>.SmartphoneSecurityApplication.DoorLockOpen.PassCode passCode = 1;</code>
     */
    public Builder clearPassCode() {
      
      passCode_ = 0;
      onChanged();
      return this;
    }

    private int userAccept_ ;
    /**
     * <code>int32 userAccept = 2;</code>
     */
    public int getUserAccept() {
      return userAccept_;
    }
    /**
     * <code>int32 userAccept = 2;</code>
     */
    public Builder setUserAccept(int value) {
      
      userAccept_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 userAccept = 2;</code>
     */
    public Builder clearUserAccept() {
      
      userAccept_ = 0;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:SmartphoneSecurityApplication.DoorLockOpen)
  }

  // @@protoc_insertion_point(class_scope:SmartphoneSecurityApplication.DoorLockOpen)
  private static final ds.adam.SmartphoneSecurityApplication.DoorLockOpen DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new ds.adam.SmartphoneSecurityApplication.DoorLockOpen();
  }

  public static ds.adam.SmartphoneSecurityApplication.DoorLockOpen getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<DoorLockOpen>
      PARSER = new com.google.protobuf.AbstractParser<DoorLockOpen>() {
    @java.lang.Override
    public DoorLockOpen parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new DoorLockOpen(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<DoorLockOpen> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<DoorLockOpen> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public ds.adam.SmartphoneSecurityApplication.DoorLockOpen getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

