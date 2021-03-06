package ink.ckx.netty.codec.protobuf;

/**
 * @author chenkaixin
 * @description
 * @since 2021/11/30
 */
public final class RequestModule {

    private static final com.google.protobuf.Descriptors.Descriptor
            internal_static_Request_descriptor;
    private static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_Request_fieldAccessorTable;
    private static com.google.protobuf.Descriptors.FileDescriptor
            descriptor;

    static {
        java.lang.String[] descriptorData = {
                "\n\023proto/request.proto\"5\n\007Request\022\n\n\002id\030\001" +
                        " \001(\t\022\020\n\010sequence\030\002 \001(\005\022\014\n\004data\030\003 \001(\tB(\n\027" +
                        "com.bfxy.netty.protobufB\rRequestModuleb\006" +
                        "proto3"
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
        internal_static_Request_descriptor =
                getDescriptor().getMessageTypes().get(0);
        internal_static_Request_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_Request_descriptor,
                new java.lang.String[]{"Id", "Sequence", "Data",});
    }

    private RequestModule() {
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

    public interface RequestOrBuilder extends
            // @@protoc_insertion_point(interface_extends:Request)
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
         * <code>int32 sequence = 2;</code>
         */
        int getSequence();

        /**
         * <code>string data = 3;</code>
         */
        java.lang.String getData();

        /**
         * <code>string data = 3;</code>
         */
        com.google.protobuf.ByteString
        getDataBytes();
    }

    /**
     * Protobuf type {@code Request}
     */
    public static final class Request extends
            com.google.protobuf.GeneratedMessageV3 implements
            // @@protoc_insertion_point(message_implements:Request)
            RequestOrBuilder {
        public static final int ID_FIELD_NUMBER = 1;
        public static final int SEQUENCE_FIELD_NUMBER = 2;
        public static final int DATA_FIELD_NUMBER = 3;
        private static final long serialVersionUID = 0L;
        // @@protoc_insertion_point(class_scope:Request)
        private static final RequestModule.Request DEFAULT_INSTANCE;
        private static final com.google.protobuf.Parser<Request>
                PARSER = new com.google.protobuf.AbstractParser<Request>() {
            @java.lang.Override
            public Request parsePartialFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws com.google.protobuf.InvalidProtocolBufferException {
                return new Request(input, extensionRegistry);
            }
        };

        static {
            DEFAULT_INSTANCE = new RequestModule.Request();
        }

        private volatile java.lang.Object id_;
        private int sequence_;
        private volatile java.lang.Object data_;
        private byte memoizedIsInitialized = -1;

        // Use Request.newBuilder() to construct.
        private Request(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
            super(builder);
        }
        private Request() {
            id_ = "";
            data_ = "";
        }

        private Request(
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

                            sequence_ = input.readInt32();
                            break;
                        }
                        case 26: {
                            java.lang.String s = input.readStringRequireUtf8();

                            data_ = s;
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
            return RequestModule.internal_static_Request_descriptor;
        }

        public static RequestModule.Request parseFrom(
                java.nio.ByteBuffer data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static RequestModule.Request parseFrom(
                java.nio.ByteBuffer data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static RequestModule.Request parseFrom(
                com.google.protobuf.ByteString data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static RequestModule.Request parseFrom(
                com.google.protobuf.ByteString data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static RequestModule.Request parseFrom(byte[] data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static RequestModule.Request parseFrom(
                byte[] data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static RequestModule.Request parseFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }

        public static RequestModule.Request parseFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static RequestModule.Request parseDelimitedFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input);
        }

        public static RequestModule.Request parseDelimitedFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static RequestModule.Request parseFrom(
                com.google.protobuf.CodedInputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }

        public static RequestModule.Request parseFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(RequestModule.Request prototype) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
        }

        public static RequestModule.Request getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static com.google.protobuf.Parser<Request> parser() {
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
            return RequestModule.internal_static_Request_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            RequestModule.Request.class, RequestModule.Request.Builder.class);
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
         * <code>int32 sequence = 2;</code>
         */
        public int getSequence() {
            return sequence_;
        }

        /**
         * <code>string data = 3;</code>
         */
        public java.lang.String getData() {
            java.lang.Object ref = data_;
            if (ref instanceof java.lang.String) {
                return (java.lang.String) ref;
            } else {
                com.google.protobuf.ByteString bs =
                        (com.google.protobuf.ByteString) ref;
                java.lang.String s = bs.toStringUtf8();
                data_ = s;
                return s;
            }
        }

        /**
         * <code>string data = 3;</code>
         */
        public com.google.protobuf.ByteString
        getDataBytes() {
            java.lang.Object ref = data_;
            if (ref instanceof java.lang.String) {
                com.google.protobuf.ByteString b =
                        com.google.protobuf.ByteString.copyFromUtf8(
                                (java.lang.String) ref);
                data_ = b;
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
            if (sequence_ != 0) {
                output.writeInt32(2, sequence_);
            }
            if (!getDataBytes().isEmpty()) {
                com.google.protobuf.GeneratedMessageV3.writeString(output, 3, data_);
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
            if (sequence_ != 0) {
                size += com.google.protobuf.CodedOutputStream
                        .computeInt32Size(2, sequence_);
            }
            if (!getDataBytes().isEmpty()) {
                size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, data_);
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
            if (!(obj instanceof RequestModule.Request)) {
                return super.equals(obj);
            }
            RequestModule.Request other = (RequestModule.Request) obj;

            if (!getId()
                    .equals(other.getId())) return false;
            if (getSequence()
                    != other.getSequence()) return false;
            if (!getData()
                    .equals(other.getData())) return false;
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
            hash = (37 * hash) + SEQUENCE_FIELD_NUMBER;
            hash = (53 * hash) + getSequence();
            hash = (37 * hash) + DATA_FIELD_NUMBER;
            hash = (53 * hash) + getData().hashCode();
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
        public com.google.protobuf.Parser<Request> getParserForType() {
            return PARSER;
        }

        @java.lang.Override
        public RequestModule.Request getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        /**
         * Protobuf type {@code Request}
         */
        public static final class Builder extends
                com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
                // @@protoc_insertion_point(builder_implements:Request)
                RequestModule.RequestOrBuilder {
            private java.lang.Object id_ = "";
            private int sequence_;
            private java.lang.Object data_ = "";

            // Construct using   RequestModule.Request.newBuilder()
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
                return RequestModule.internal_static_Request_descriptor;
            }

            @java.lang.Override
            protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internalGetFieldAccessorTable() {
                return RequestModule.internal_static_Request_fieldAccessorTable
                        .ensureFieldAccessorsInitialized(
                                RequestModule.Request.class, RequestModule.Request.Builder.class);
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

                sequence_ = 0;

                data_ = "";

                return this;
            }

            @java.lang.Override
            public com.google.protobuf.Descriptors.Descriptor
            getDescriptorForType() {
                return RequestModule.internal_static_Request_descriptor;
            }

            @java.lang.Override
            public RequestModule.Request getDefaultInstanceForType() {
                return RequestModule.Request.getDefaultInstance();
            }

            @java.lang.Override
            public RequestModule.Request build() {
                RequestModule.Request result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            @java.lang.Override
            public RequestModule.Request buildPartial() {
                RequestModule.Request result = new RequestModule.Request(this);
                result.id_ = id_;
                result.sequence_ = sequence_;
                result.data_ = data_;
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
                if (other instanceof RequestModule.Request) {
                    return mergeFrom((RequestModule.Request) other);
                } else {
                    super.mergeFrom(other);
                    return this;
                }
            }

            public Builder mergeFrom(RequestModule.Request other) {
                if (other == RequestModule.Request.getDefaultInstance()) return this;
                if (!other.getId().isEmpty()) {
                    id_ = other.id_;
                    onChanged();
                }
                if (other.getSequence() != 0) {
                    setSequence(other.getSequence());
                }
                if (!other.getData().isEmpty()) {
                    data_ = other.data_;
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
                RequestModule.Request parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                    parsedMessage = (RequestModule.Request) e.getUnfinishedMessage();
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
             * <code>int32 sequence = 2;</code>
             */
            public int getSequence() {
                return sequence_;
            }

            /**
             * <code>int32 sequence = 2;</code>
             */
            public Builder setSequence(int value) {

                sequence_ = value;
                onChanged();
                return this;
            }

            /**
             * <code>int32 sequence = 2;</code>
             */
            public Builder clearSequence() {

                sequence_ = 0;
                onChanged();
                return this;
            }

            /**
             * <code>string data = 3;</code>
             */
            public java.lang.String getData() {
                java.lang.Object ref = data_;
                if (!(ref instanceof java.lang.String)) {
                    com.google.protobuf.ByteString bs =
                            (com.google.protobuf.ByteString) ref;
                    java.lang.String s = bs.toStringUtf8();
                    data_ = s;
                    return s;
                } else {
                    return (java.lang.String) ref;
                }
            }

            /**
             * <code>string data = 3;</code>
             */
            public Builder setData(
                    java.lang.String value) {
                if (value == null) {
                    throw new NullPointerException();
                }

                data_ = value;
                onChanged();
                return this;
            }

            /**
             * <code>string data = 3;</code>
             */
            public com.google.protobuf.ByteString
            getDataBytes() {
                java.lang.Object ref = data_;
                if (ref instanceof String) {
                    com.google.protobuf.ByteString b =
                            com.google.protobuf.ByteString.copyFromUtf8(
                                    (java.lang.String) ref);
                    data_ = b;
                    return b;
                } else {
                    return (com.google.protobuf.ByteString) ref;
                }
            }

            /**
             * <code>string data = 3;</code>
             */
            public Builder setDataBytes(
                    com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                checkByteStringIsUtf8(value);

                data_ = value;
                onChanged();
                return this;
            }

            /**
             * <code>string data = 3;</code>
             */
            public Builder clearData() {

                data_ = getDefaultInstance().getData();
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


            // @@protoc_insertion_point(builder_scope:Request)
        }

    }

    // @@protoc_insertion_point(outer_class_scope)
}