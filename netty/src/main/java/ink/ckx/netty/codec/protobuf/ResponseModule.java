package ink.ckx.netty.codec.protobuf;

/**
 * @author chenkaixin
 * @description
 * @since 2021/11/30
 */
public final class ResponseModule {
    private static final com.google.protobuf.Descriptors.Descriptor
            internal_static_Response_descriptor;
    private static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_Response_fieldAccessorTable;
    private static com.google.protobuf.Descriptors.FileDescriptor
            descriptor;

    static {
        java.lang.String[] descriptorData = {
                "\n\024proto/response.proto\"2\n\010Response\022\n\n\002id" +
                        "\030\001 \001(\t\022\014\n\004code\030\002 \001(\005\022\014\n\004desc\030\003 \001(\tB)\n\027co" +
                        "m.bfxy.netty.protobufB\016ResponseModuleb\006p" +
                        "roto3"
        };
        com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
                new com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner() {
                    public com.google.protobuf.ExtensionRegistry assignDescriptors(
                            com.google.protobuf.Descriptors.FileDescriptor root) {
                        descriptor = root;
                        return null;
                    }
                };
        com.google.protobuf.Descriptors.FileDescriptor
                .internalBuildGeneratedFileFrom(descriptorData,
                        new com.google.protobuf.Descriptors.FileDescriptor[]{
                        }, assigner);
        internal_static_Response_descriptor =
                getDescriptor().getMessageTypes().get(0);
        internal_static_Response_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_Response_descriptor,
                new java.lang.String[]{"Id", "Code", "Desc",});
    }

    private ResponseModule() {
    }

    public static void registerAllExtensions(
            com.google.protobuf.ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(
            com.google.protobuf.ExtensionRegistry registry) {
        registerAllExtensions(
                (com.google.protobuf.ExtensionRegistryLite) registry);
    }

    public static com.google.protobuf.Descriptors.FileDescriptor
    getDescriptor() {
        return descriptor;
    }

    public interface ResponseOrBuilder extends
            // @@protoc_insertion_point(interface_extends:Response)
            com.google.protobuf.MessageOrBuilder {

        /**
         * <code>string id = 1;</code>
         */
        java.lang.String getId();

        /**
         * <code>string id = 1;</code>
         */
        com.google.protobuf.ByteString
        getIdBytes();

        /**
         * <code>int32 code = 2;</code>
         */
        int getCode();

        /**
         * <code>string desc = 3;</code>
         */
        java.lang.String getDesc();

        /**
         * <code>string desc = 3;</code>
         */
        com.google.protobuf.ByteString
        getDescBytes();
    }

    /**
     * Protobuf type {@code Response}
     */
    public static final class Response extends
            com.google.protobuf.GeneratedMessageV3 implements
            // @@protoc_insertion_point(message_implements:Response)
            ResponseOrBuilder {
        public static final int ID_FIELD_NUMBER = 1;
        public static final int CODE_FIELD_NUMBER = 2;
        public static final int DESC_FIELD_NUMBER = 3;
        private static final long serialVersionUID = 0L;
        // @@protoc_insertion_point(class_scope:Response)
        private static final ResponseModule.Response DEFAULT_INSTANCE;
        private static final com.google.protobuf.Parser<Response>
                PARSER = new com.google.protobuf.AbstractParser<Response>() {
            @java.lang.Override
            public Response parsePartialFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws com.google.protobuf.InvalidProtocolBufferException {
                return new Response(input, extensionRegistry);
            }
        };

        static {
            DEFAULT_INSTANCE = new ResponseModule.Response();
        }

        private volatile java.lang.Object id_;
        private int code_;
        private volatile java.lang.Object desc_;
        private byte memoizedIsInitialized = -1;

        // Use Response.newBuilder() to construct.
        private Response(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
            super(builder);
        }

        private Response() {
            id_ = "";
            desc_ = "";
        }

        private Response(
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
                        case 10: {
                            java.lang.String s = input.readStringRequireUtf8();

                            id_ = s;
                            break;
                        }
                        case 16: {

                            code_ = input.readInt32();
                            break;
                        }
                        case 26: {
                            java.lang.String s = input.readStringRequireUtf8();

                            desc_ = s;
                            break;
                        }
                        default: {
                            if (!parseUnknownField(
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
            return ResponseModule.internal_static_Response_descriptor;
        }

        public static ResponseModule.Response parseFrom(
                java.nio.ByteBuffer data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ResponseModule.Response parseFrom(
                java.nio.ByteBuffer data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ResponseModule.Response parseFrom(
                com.google.protobuf.ByteString data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ResponseModule.Response parseFrom(
                com.google.protobuf.ByteString data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ResponseModule.Response parseFrom(byte[] data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ResponseModule.Response parseFrom(
                byte[] data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ResponseModule.Response parseFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }

        public static ResponseModule.Response parseFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static ResponseModule.Response parseDelimitedFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input);
        }

        public static ResponseModule.Response parseDelimitedFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static ResponseModule.Response parseFrom(
                com.google.protobuf.CodedInputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }

        public static ResponseModule.Response parseFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ResponseModule.Response prototype) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
        }

        public static ResponseModule.Response getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static com.google.protobuf.Parser<Response> parser() {
            return PARSER;
        }

        @java.lang.Override
        public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
            return this.unknownFields;
        }

        @java.lang.Override
        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
            return ResponseModule.internal_static_Response_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            ResponseModule.Response.class, ResponseModule.Response.Builder.class);
        }

        /**
         * <code>string id = 1;</code>
         */
        public java.lang.String getId() {
            java.lang.Object ref = id_;
            if (ref instanceof java.lang.String) {
                return (java.lang.String) ref;
            } else {
                com.google.protobuf.ByteString bs =
                        (com.google.protobuf.ByteString) ref;
                java.lang.String s = bs.toStringUtf8();
                id_ = s;
                return s;
            }
        }

        /**
         * <code>string id = 1;</code>
         */
        public com.google.protobuf.ByteString
        getIdBytes() {
            java.lang.Object ref = id_;
            if (ref instanceof java.lang.String) {
                com.google.protobuf.ByteString b =
                        com.google.protobuf.ByteString.copyFromUtf8(
                                (java.lang.String) ref);
                id_ = b;
                return b;
            } else {
                return (com.google.protobuf.ByteString) ref;
            }
        }

        /**
         * <code>int32 code = 2;</code>
         */
        public int getCode() {
            return code_;
        }

        /**
         * <code>string desc = 3;</code>
         */
        public java.lang.String getDesc() {
            java.lang.Object ref = desc_;
            if (ref instanceof java.lang.String) {
                return (java.lang.String) ref;
            } else {
                com.google.protobuf.ByteString bs =
                        (com.google.protobuf.ByteString) ref;
                java.lang.String s = bs.toStringUtf8();
                desc_ = s;
                return s;
            }
        }

        /**
         * <code>string desc = 3;</code>
         */
        public com.google.protobuf.ByteString
        getDescBytes() {
            java.lang.Object ref = desc_;
            if (ref instanceof java.lang.String) {
                com.google.protobuf.ByteString b =
                        com.google.protobuf.ByteString.copyFromUtf8(
                                (java.lang.String) ref);
                desc_ = b;
                return b;
            } else {
                return (com.google.protobuf.ByteString) ref;
            }
        }

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
            if (!getIdBytes().isEmpty()) {
                com.google.protobuf.GeneratedMessageV3.writeString(output, 1, id_);
            }
            if (code_ != 0) {
                output.writeInt32(2, code_);
            }
            if (!getDescBytes().isEmpty()) {
                com.google.protobuf.GeneratedMessageV3.writeString(output, 3, desc_);
            }
            unknownFields.writeTo(output);
        }

        @java.lang.Override
        public int getSerializedSize() {
            int size = memoizedSize;
            if (size != -1) return size;

            size = 0;
            if (!getIdBytes().isEmpty()) {
                size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, id_);
            }
            if (code_ != 0) {
                size += com.google.protobuf.CodedOutputStream
                        .computeInt32Size(2, code_);
            }
            if (!getDescBytes().isEmpty()) {
                size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, desc_);
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
            if (!(obj instanceof ResponseModule.Response)) {
                return super.equals(obj);
            }
            ResponseModule.Response other = (ResponseModule.Response) obj;

            if (!getId()
                    .equals(other.getId())) return false;
            if (getCode()
                    != other.getCode()) return false;
            if (!getDesc()
                    .equals(other.getDesc())) return false;
            return unknownFields.equals(other.unknownFields);
        }

        @java.lang.Override
        public int hashCode() {
            if (memoizedHashCode != 0) {
                return memoizedHashCode;
            }
            int hash = 41;
            hash = (19 * hash) + getDescriptor().hashCode();
            hash = (37 * hash) + ID_FIELD_NUMBER;
            hash = (53 * hash) + getId().hashCode();
            hash = (37 * hash) + CODE_FIELD_NUMBER;
            hash = (53 * hash) + getCode();
            hash = (37 * hash) + DESC_FIELD_NUMBER;
            hash = (53 * hash) + getDesc().hashCode();
            hash = (29 * hash) + unknownFields.hashCode();
            memoizedHashCode = hash;
            return hash;
        }

        @java.lang.Override
        public Builder newBuilderForType() {
            return newBuilder();
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

        @java.lang.Override
        public com.google.protobuf.Parser<Response> getParserForType() {
            return PARSER;
        }

        @java.lang.Override
        public ResponseModule.Response getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        /**
         * Protobuf type {@code Response}
         */
        public static final class Builder extends
                com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
                // @@protoc_insertion_point(builder_implements:Response)
                ResponseModule.ResponseOrBuilder {
            private java.lang.Object id_ = "";
            private int code_;
            private java.lang.Object desc_ = "";

            // Construct using   ResponseModule.Response.newBuilder()
            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(
                    com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            public static final com.google.protobuf.Descriptors.Descriptor
            getDescriptor() {
                return ResponseModule.internal_static_Response_descriptor;
            }

            @java.lang.Override
            protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internalGetFieldAccessorTable() {
                return ResponseModule.internal_static_Response_fieldAccessorTable
                        .ensureFieldAccessorsInitialized(
                                ResponseModule.Response.class, ResponseModule.Response.Builder.class);
            }

            private void maybeForceBuilderInitialization() {
                if (com.google.protobuf.GeneratedMessageV3
                        .alwaysUseFieldBuilders) {
                }
            }

            @java.lang.Override
            public Builder clear() {
                super.clear();
                id_ = "";

                code_ = 0;

                desc_ = "";

                return this;
            }

            @java.lang.Override
            public com.google.protobuf.Descriptors.Descriptor
            getDescriptorForType() {
                return ResponseModule.internal_static_Response_descriptor;
            }

            @java.lang.Override
            public ResponseModule.Response getDefaultInstanceForType() {
                return ResponseModule.Response.getDefaultInstance();
            }

            @java.lang.Override
            public ResponseModule.Response build() {
                ResponseModule.Response result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            @java.lang.Override
            public ResponseModule.Response buildPartial() {
                ResponseModule.Response result = new ResponseModule.Response(this);
                result.id_ = id_;
                result.code_ = code_;
                result.desc_ = desc_;
                onBuilt();
                return result;
            }

            @java.lang.Override
            public Builder clone() {
                return super.clone();
            }

            @java.lang.Override
            public Builder setField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return super.setField(field, value);
            }

            @java.lang.Override
            public Builder clearField(
                    com.google.protobuf.Descriptors.FieldDescriptor field) {
                return super.clearField(field);
            }

            @java.lang.Override
            public Builder clearOneof(
                    com.google.protobuf.Descriptors.OneofDescriptor oneof) {
                return super.clearOneof(oneof);
            }

            @java.lang.Override
            public Builder setRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    int index, java.lang.Object value) {
                return super.setRepeatedField(field, index, value);
            }

            @java.lang.Override
            public Builder addRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return super.addRepeatedField(field, value);
            }

            @java.lang.Override
            public Builder mergeFrom(com.google.protobuf.Message other) {
                if (other instanceof ResponseModule.Response) {
                    return mergeFrom((ResponseModule.Response) other);
                } else {
                    super.mergeFrom(other);
                    return this;
                }
            }

            public Builder mergeFrom(ResponseModule.Response other) {
                if (other == ResponseModule.Response.getDefaultInstance()) return this;
                if (!other.getId().isEmpty()) {
                    id_ = other.id_;
                    onChanged();
                }
                if (other.getCode() != 0) {
                    setCode(other.getCode());
                }
                if (!other.getDesc().isEmpty()) {
                    desc_ = other.desc_;
                    onChanged();
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
                ResponseModule.Response parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                    parsedMessage = (ResponseModule.Response) e.getUnfinishedMessage();
                    throw e.unwrapIOException();
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            /**
             * <code>string id = 1;</code>
             */
            public java.lang.String getId() {
                java.lang.Object ref = id_;
                if (!(ref instanceof java.lang.String)) {
                    com.google.protobuf.ByteString bs =
                            (com.google.protobuf.ByteString) ref;
                    java.lang.String s = bs.toStringUtf8();
                    id_ = s;
                    return s;
                } else {
                    return (java.lang.String) ref;
                }
            }

            /**
             * <code>string id = 1;</code>
             */
            public Builder setId(
                    java.lang.String value) {
                if (value == null) {
                    throw new NullPointerException();
                }

                id_ = value;
                onChanged();
                return this;
            }

            /**
             * <code>string id = 1;</code>
             */
            public com.google.protobuf.ByteString
            getIdBytes() {
                java.lang.Object ref = id_;
                if (ref instanceof String) {
                    com.google.protobuf.ByteString b =
                            com.google.protobuf.ByteString.copyFromUtf8(
                                    (java.lang.String) ref);
                    id_ = b;
                    return b;
                } else {
                    return (com.google.protobuf.ByteString) ref;
                }
            }

            /**
             * <code>string id = 1;</code>
             */
            public Builder setIdBytes(
                    com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                checkByteStringIsUtf8(value);

                id_ = value;
                onChanged();
                return this;
            }

            /**
             * <code>string id = 1;</code>
             */
            public Builder clearId() {

                id_ = getDefaultInstance().getId();
                onChanged();
                return this;
            }

            /**
             * <code>int32 code = 2;</code>
             */
            public int getCode() {
                return code_;
            }

            /**
             * <code>int32 code = 2;</code>
             */
            public Builder setCode(int value) {

                code_ = value;
                onChanged();
                return this;
            }

            /**
             * <code>int32 code = 2;</code>
             */
            public Builder clearCode() {

                code_ = 0;
                onChanged();
                return this;
            }

            /**
             * <code>string desc = 3;</code>
             */
            public java.lang.String getDesc() {
                java.lang.Object ref = desc_;
                if (!(ref instanceof java.lang.String)) {
                    com.google.protobuf.ByteString bs =
                            (com.google.protobuf.ByteString) ref;
                    java.lang.String s = bs.toStringUtf8();
                    desc_ = s;
                    return s;
                } else {
                    return (java.lang.String) ref;
                }
            }

            /**
             * <code>string desc = 3;</code>
             */
            public Builder setDesc(
                    java.lang.String value) {
                if (value == null) {
                    throw new NullPointerException();
                }

                desc_ = value;
                onChanged();
                return this;
            }

            /**
             * <code>string desc = 3;</code>
             */
            public com.google.protobuf.ByteString
            getDescBytes() {
                java.lang.Object ref = desc_;
                if (ref instanceof String) {
                    com.google.protobuf.ByteString b =
                            com.google.protobuf.ByteString.copyFromUtf8(
                                    (java.lang.String) ref);
                    desc_ = b;
                    return b;
                } else {
                    return (com.google.protobuf.ByteString) ref;
                }
            }

            /**
             * <code>string desc = 3;</code>
             */
            public Builder setDescBytes(
                    com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                checkByteStringIsUtf8(value);

                desc_ = value;
                onChanged();
                return this;
            }

            /**
             * <code>string desc = 3;</code>
             */
            public Builder clearDesc() {

                desc_ = getDefaultInstance().getDesc();
                onChanged();
                return this;
            }

            @java.lang.Override
            public final Builder setUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.setUnknownFields(unknownFields);
            }

            @java.lang.Override
            public final Builder mergeUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.mergeUnknownFields(unknownFields);
            }


            // @@protoc_insertion_point(builder_scope:Response)
        }

    }

    // @@protoc_insertion_point(outer_class_scope)
}