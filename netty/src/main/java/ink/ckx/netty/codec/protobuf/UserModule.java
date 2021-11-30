package ink.ckx.netty.codec.protobuf;

/**
 * @author chenkaixin
 * @description
 * @since 2021/11/30
 */
public final class UserModule {

    private static final com.google.protobuf.Descriptors.Descriptor
            internal_static_User_descriptor;
    private static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_User_fieldAccessorTable;
    private static com.google.protobuf.Descriptors.FileDescriptor
            descriptor;

    static {
        java.lang.String[] descriptorData = {
                "\n\020proto/user.proto\"G\n\004User\022\016\n\006userId\030\001 \001" +
                        "(\t\022\013\n\003age\030\002 \001(\005\022\020\n\010userName\030\003 \001(\t\022\020\n\010fav" +
                        "orite\030\004 \003(\tB%\n\027com.bfxy.netty.protobufB\n" +
                        "UserModuleb\006proto3"
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
        internal_static_User_descriptor =
                getDescriptor().getMessageTypes().get(0);
        internal_static_User_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_User_descriptor,
                new java.lang.String[]{"UserId", "Age", "UserName", "Favorite",});
    }

    private UserModule() {
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

    public interface UserOrBuilder extends
            // @@protoc_insertion_point(interface_extends:User)
            com.google.protobuf.MessageOrBuilder {

        /**
         * <code>string userId = 1;</code>
         */
        java.lang.String getUserId();

        /**
         * <code>string userId = 1;</code>
         */
        com.google.protobuf.ByteString
        getUserIdBytes();

        /**
         * <code>int32 age = 2;</code>
         */
        int getAge();

        /**
         * <code>string userName = 3;</code>
         */
        java.lang.String getUserName();

        /**
         * <code>string userName = 3;</code>
         */
        com.google.protobuf.ByteString
        getUserNameBytes();

        /**
         * <code>repeated string favorite = 4;</code>
         */
        java.util.List<java.lang.String>
        getFavoriteList();

        /**
         * <code>repeated string favorite = 4;</code>
         */
        int getFavoriteCount();

        /**
         * <code>repeated string favorite = 4;</code>
         */
        java.lang.String getFavorite(int index);

        /**
         * <code>repeated string favorite = 4;</code>
         */
        com.google.protobuf.ByteString
        getFavoriteBytes(int index);
    }

    /**
     * Protobuf type {@code User}
     */
    public static final class User extends
            com.google.protobuf.GeneratedMessageV3 implements
            // @@protoc_insertion_point(message_implements:User)
            UserOrBuilder {
        public static final int USERID_FIELD_NUMBER = 1;
        public static final int AGE_FIELD_NUMBER = 2;
        public static final int USERNAME_FIELD_NUMBER = 3;
        public static final int FAVORITE_FIELD_NUMBER = 4;
        private static final long serialVersionUID = 0L;
        // @@protoc_insertion_point(class_scope:User)
        private static final UserModule.User DEFAULT_INSTANCE;
        private static final com.google.protobuf.Parser<User>
                PARSER = new com.google.protobuf.AbstractParser<User>() {
            @java.lang.Override
            public User parsePartialFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws com.google.protobuf.InvalidProtocolBufferException {
                return new User(input, extensionRegistry);
            }
        };

        static {
            DEFAULT_INSTANCE = new UserModule.User();
        }

        private int bitField0_;
        private volatile java.lang.Object userId_;
        private int age_;
        private volatile java.lang.Object userName_;
        private com.google.protobuf.LazyStringList favorite_;
        private byte memoizedIsInitialized = -1;

        // Use User.newBuilder() to construct.
        private User(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
            super(builder);
        }

        private User() {
            userId_ = "";
            userName_ = "";
            favorite_ = com.google.protobuf.LazyStringArrayList.EMPTY;
        }
        private User(
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

                            userId_ = s;
                            break;
                        }
                        case 16: {

                            age_ = input.readInt32();
                            break;
                        }
                        case 26: {
                            java.lang.String s = input.readStringRequireUtf8();

                            userName_ = s;
                            break;
                        }
                        case 34: {
                            java.lang.String s = input.readStringRequireUtf8();
                            if ((mutable_bitField0_ & 0x00000008) == 0) {
                                favorite_ = new com.google.protobuf.LazyStringArrayList();
                                mutable_bitField0_ |= 0x00000008;
                            }
                            favorite_.add(s);
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
                if (((mutable_bitField0_ & 0x00000008) != 0)) {
                    favorite_ = favorite_.getUnmodifiableView();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
            return UserModule.internal_static_User_descriptor;
        }

        public static UserModule.User parseFrom(
                java.nio.ByteBuffer data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static UserModule.User parseFrom(
                java.nio.ByteBuffer data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static UserModule.User parseFrom(
                com.google.protobuf.ByteString data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static UserModule.User parseFrom(
                com.google.protobuf.ByteString data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static UserModule.User parseFrom(byte[] data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static UserModule.User parseFrom(
                byte[] data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static UserModule.User parseFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }

        public static UserModule.User parseFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static UserModule.User parseDelimitedFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input);
        }

        public static UserModule.User parseDelimitedFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static UserModule.User parseFrom(
                com.google.protobuf.CodedInputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }

        public static UserModule.User parseFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(UserModule.User prototype) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
        }

        public static UserModule.User getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static com.google.protobuf.Parser<User> parser() {
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
            return UserModule.internal_static_User_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            UserModule.User.class, UserModule.User.Builder.class);
        }

        /**
         * <code>string userId = 1;</code>
         */
        public java.lang.String getUserId() {
            java.lang.Object ref = userId_;
            if (ref instanceof java.lang.String) {
                return (java.lang.String) ref;
            } else {
                com.google.protobuf.ByteString bs =
                        (com.google.protobuf.ByteString) ref;
                java.lang.String s = bs.toStringUtf8();
                userId_ = s;
                return s;
            }
        }

        /**
         * <code>string userId = 1;</code>
         */
        public com.google.protobuf.ByteString
        getUserIdBytes() {
            java.lang.Object ref = userId_;
            if (ref instanceof java.lang.String) {
                com.google.protobuf.ByteString b =
                        com.google.protobuf.ByteString.copyFromUtf8(
                                (java.lang.String) ref);
                userId_ = b;
                return b;
            } else {
                return (com.google.protobuf.ByteString) ref;
            }
        }

        /**
         * <code>int32 age = 2;</code>
         */
        public int getAge() {
            return age_;
        }

        /**
         * <code>string userName = 3;</code>
         */
        public java.lang.String getUserName() {
            java.lang.Object ref = userName_;
            if (ref instanceof java.lang.String) {
                return (java.lang.String) ref;
            } else {
                com.google.protobuf.ByteString bs =
                        (com.google.protobuf.ByteString) ref;
                java.lang.String s = bs.toStringUtf8();
                userName_ = s;
                return s;
            }
        }

        /**
         * <code>string userName = 3;</code>
         */
        public com.google.protobuf.ByteString
        getUserNameBytes() {
            java.lang.Object ref = userName_;
            if (ref instanceof java.lang.String) {
                com.google.protobuf.ByteString b =
                        com.google.protobuf.ByteString.copyFromUtf8(
                                (java.lang.String) ref);
                userName_ = b;
                return b;
            } else {
                return (com.google.protobuf.ByteString) ref;
            }
        }

        /**
         * <code>repeated string favorite = 4;</code>
         */
        public com.google.protobuf.ProtocolStringList
        getFavoriteList() {
            return favorite_;
        }

        /**
         * <code>repeated string favorite = 4;</code>
         */
        public int getFavoriteCount() {
            return favorite_.size();
        }

        /**
         * <code>repeated string favorite = 4;</code>
         */
        public java.lang.String getFavorite(int index) {
            return favorite_.get(index);
        }

        /**
         * <code>repeated string favorite = 4;</code>
         */
        public com.google.protobuf.ByteString
        getFavoriteBytes(int index) {
            return favorite_.getByteString(index);
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
            if (!getUserIdBytes().isEmpty()) {
                com.google.protobuf.GeneratedMessageV3.writeString(output, 1, userId_);
            }
            if (age_ != 0) {
                output.writeInt32(2, age_);
            }
            if (!getUserNameBytes().isEmpty()) {
                com.google.protobuf.GeneratedMessageV3.writeString(output, 3, userName_);
            }
            for (int i = 0; i < favorite_.size(); i++) {
                com.google.protobuf.GeneratedMessageV3.writeString(output, 4, favorite_.getRaw(i));
            }
            unknownFields.writeTo(output);
        }

        @java.lang.Override
        public int getSerializedSize() {
            int size = memoizedSize;
            if (size != -1) return size;

            size = 0;
            if (!getUserIdBytes().isEmpty()) {
                size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, userId_);
            }
            if (age_ != 0) {
                size += com.google.protobuf.CodedOutputStream
                        .computeInt32Size(2, age_);
            }
            if (!getUserNameBytes().isEmpty()) {
                size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, userName_);
            }
            {
                int dataSize = 0;
                for (int i = 0; i < favorite_.size(); i++) {
                    dataSize += computeStringSizeNoTag(favorite_.getRaw(i));
                }
                size += dataSize;
                size += 1 * getFavoriteList().size();
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
            if (!(obj instanceof UserModule.User)) {
                return super.equals(obj);
            }
            UserModule.User other = (UserModule.User) obj;

            if (!getUserId()
                    .equals(other.getUserId())) return false;
            if (getAge()
                    != other.getAge()) return false;
            if (!getUserName()
                    .equals(other.getUserName())) return false;
            if (!getFavoriteList()
                    .equals(other.getFavoriteList())) return false;
            return unknownFields.equals(other.unknownFields);
        }

        @java.lang.Override
        public int hashCode() {
            if (memoizedHashCode != 0) {
                return memoizedHashCode;
            }
            int hash = 41;
            hash = (19 * hash) + getDescriptor().hashCode();
            hash = (37 * hash) + USERID_FIELD_NUMBER;
            hash = (53 * hash) + getUserId().hashCode();
            hash = (37 * hash) + AGE_FIELD_NUMBER;
            hash = (53 * hash) + getAge();
            hash = (37 * hash) + USERNAME_FIELD_NUMBER;
            hash = (53 * hash) + getUserName().hashCode();
            if (getFavoriteCount() > 0) {
                hash = (37 * hash) + FAVORITE_FIELD_NUMBER;
                hash = (53 * hash) + getFavoriteList().hashCode();
            }
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
        public com.google.protobuf.Parser<User> getParserForType() {
            return PARSER;
        }

        @java.lang.Override
        public UserModule.User getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        /**
         * Protobuf type {@code User}
         */
        public static final class Builder extends
                com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
                // @@protoc_insertion_point(builder_implements:User)
                UserModule.UserOrBuilder {
            private int bitField0_;
            private java.lang.Object userId_ = "";
            private int age_;
            private java.lang.Object userName_ = "";
            private com.google.protobuf.LazyStringList favorite_ = com.google.protobuf.LazyStringArrayList.EMPTY;

            // Construct using   UserModule.User.newBuilder()
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
                return UserModule.internal_static_User_descriptor;
            }

            @java.lang.Override
            protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internalGetFieldAccessorTable() {
                return UserModule.internal_static_User_fieldAccessorTable
                        .ensureFieldAccessorsInitialized(
                                UserModule.User.class, UserModule.User.Builder.class);
            }

            private void maybeForceBuilderInitialization() {
                if (com.google.protobuf.GeneratedMessageV3
                        .alwaysUseFieldBuilders) {
                }
            }

            @java.lang.Override
            public Builder clear() {
                super.clear();
                userId_ = "";

                age_ = 0;

                userName_ = "";

                favorite_ = com.google.protobuf.LazyStringArrayList.EMPTY;
                bitField0_ = (bitField0_ & ~0x00000008);
                return this;
            }

            @java.lang.Override
            public com.google.protobuf.Descriptors.Descriptor
            getDescriptorForType() {
                return UserModule.internal_static_User_descriptor;
            }

            @java.lang.Override
            public UserModule.User getDefaultInstanceForType() {
                return UserModule.User.getDefaultInstance();
            }

            @java.lang.Override
            public UserModule.User build() {
                UserModule.User result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            @java.lang.Override
            public UserModule.User buildPartial() {
                UserModule.User result = new UserModule.User(this);
                int from_bitField0_ = bitField0_;
                int to_bitField0_ = 0;
                result.userId_ = userId_;
                result.age_ = age_;
                result.userName_ = userName_;
                if (((bitField0_ & 0x00000008) != 0)) {
                    favorite_ = favorite_.getUnmodifiableView();
                    bitField0_ = (bitField0_ & ~0x00000008);
                }
                result.favorite_ = favorite_;
                result.bitField0_ = to_bitField0_;
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
                if (other instanceof UserModule.User) {
                    return mergeFrom((UserModule.User) other);
                } else {
                    super.mergeFrom(other);
                    return this;
                }
            }

            public Builder mergeFrom(UserModule.User other) {
                if (other == UserModule.User.getDefaultInstance()) return this;
                if (!other.getUserId().isEmpty()) {
                    userId_ = other.userId_;
                    onChanged();
                }
                if (other.getAge() != 0) {
                    setAge(other.getAge());
                }
                if (!other.getUserName().isEmpty()) {
                    userName_ = other.userName_;
                    onChanged();
                }
                if (!other.favorite_.isEmpty()) {
                    if (favorite_.isEmpty()) {
                        favorite_ = other.favorite_;
                        bitField0_ = (bitField0_ & ~0x00000008);
                    } else {
                        ensureFavoriteIsMutable();
                        favorite_.addAll(other.favorite_);
                    }
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
                UserModule.User parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                    parsedMessage = (UserModule.User) e.getUnfinishedMessage();
                    throw e.unwrapIOException();
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            /**
             * <code>string userId = 1;</code>
             */
            public java.lang.String getUserId() {
                java.lang.Object ref = userId_;
                if (!(ref instanceof java.lang.String)) {
                    com.google.protobuf.ByteString bs =
                            (com.google.protobuf.ByteString) ref;
                    java.lang.String s = bs.toStringUtf8();
                    userId_ = s;
                    return s;
                } else {
                    return (java.lang.String) ref;
                }
            }

            /**
             * <code>string userId = 1;</code>
             */
            public Builder setUserId(
                    java.lang.String value) {
                if (value == null) {
                    throw new NullPointerException();
                }

                userId_ = value;
                onChanged();
                return this;
            }

            /**
             * <code>string userId = 1;</code>
             */
            public com.google.protobuf.ByteString
            getUserIdBytes() {
                java.lang.Object ref = userId_;
                if (ref instanceof String) {
                    com.google.protobuf.ByteString b =
                            com.google.protobuf.ByteString.copyFromUtf8(
                                    (java.lang.String) ref);
                    userId_ = b;
                    return b;
                } else {
                    return (com.google.protobuf.ByteString) ref;
                }
            }

            /**
             * <code>string userId = 1;</code>
             */
            public Builder setUserIdBytes(
                    com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                checkByteStringIsUtf8(value);

                userId_ = value;
                onChanged();
                return this;
            }

            /**
             * <code>string userId = 1;</code>
             */
            public Builder clearUserId() {

                userId_ = getDefaultInstance().getUserId();
                onChanged();
                return this;
            }

            /**
             * <code>int32 age = 2;</code>
             */
            public int getAge() {
                return age_;
            }

            /**
             * <code>int32 age = 2;</code>
             */
            public Builder setAge(int value) {

                age_ = value;
                onChanged();
                return this;
            }

            /**
             * <code>int32 age = 2;</code>
             */
            public Builder clearAge() {

                age_ = 0;
                onChanged();
                return this;
            }

            /**
             * <code>string userName = 3;</code>
             */
            public java.lang.String getUserName() {
                java.lang.Object ref = userName_;
                if (!(ref instanceof java.lang.String)) {
                    com.google.protobuf.ByteString bs =
                            (com.google.protobuf.ByteString) ref;
                    java.lang.String s = bs.toStringUtf8();
                    userName_ = s;
                    return s;
                } else {
                    return (java.lang.String) ref;
                }
            }

            /**
             * <code>string userName = 3;</code>
             */
            public Builder setUserName(
                    java.lang.String value) {
                if (value == null) {
                    throw new NullPointerException();
                }

                userName_ = value;
                onChanged();
                return this;
            }

            /**
             * <code>string userName = 3;</code>
             */
            public com.google.protobuf.ByteString
            getUserNameBytes() {
                java.lang.Object ref = userName_;
                if (ref instanceof String) {
                    com.google.protobuf.ByteString b =
                            com.google.protobuf.ByteString.copyFromUtf8(
                                    (java.lang.String) ref);
                    userName_ = b;
                    return b;
                } else {
                    return (com.google.protobuf.ByteString) ref;
                }
            }

            /**
             * <code>string userName = 3;</code>
             */
            public Builder setUserNameBytes(
                    com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                checkByteStringIsUtf8(value);

                userName_ = value;
                onChanged();
                return this;
            }

            /**
             * <code>string userName = 3;</code>
             */
            public Builder clearUserName() {

                userName_ = getDefaultInstance().getUserName();
                onChanged();
                return this;
            }

            private void ensureFavoriteIsMutable() {
                if (!((bitField0_ & 0x00000008) != 0)) {
                    favorite_ = new com.google.protobuf.LazyStringArrayList(favorite_);
                    bitField0_ |= 0x00000008;
                }
            }

            /**
             * <code>repeated string favorite = 4;</code>
             */
            public com.google.protobuf.ProtocolStringList
            getFavoriteList() {
                return favorite_.getUnmodifiableView();
            }

            /**
             * <code>repeated string favorite = 4;</code>
             */
            public int getFavoriteCount() {
                return favorite_.size();
            }

            /**
             * <code>repeated string favorite = 4;</code>
             */
            public java.lang.String getFavorite(int index) {
                return favorite_.get(index);
            }

            /**
             * <code>repeated string favorite = 4;</code>
             */
            public com.google.protobuf.ByteString
            getFavoriteBytes(int index) {
                return favorite_.getByteString(index);
            }

            /**
             * <code>repeated string favorite = 4;</code>
             */
            public Builder setFavorite(
                    int index, java.lang.String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                ensureFavoriteIsMutable();
                favorite_.set(index, value);
                onChanged();
                return this;
            }

            /**
             * <code>repeated string favorite = 4;</code>
             */
            public Builder addFavorite(
                    java.lang.String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                ensureFavoriteIsMutable();
                favorite_.add(value);
                onChanged();
                return this;
            }

            /**
             * <code>repeated string favorite = 4;</code>
             */
            public Builder addAllFavorite(
                    java.lang.Iterable<java.lang.String> values) {
                ensureFavoriteIsMutable();
                com.google.protobuf.AbstractMessageLite.Builder.addAll(
                        values, favorite_);
                onChanged();
                return this;
            }

            /**
             * <code>repeated string favorite = 4;</code>
             */
            public Builder clearFavorite() {
                favorite_ = com.google.protobuf.LazyStringArrayList.EMPTY;
                bitField0_ = (bitField0_ & ~0x00000008);
                onChanged();
                return this;
            }

            /**
             * <code>repeated string favorite = 4;</code>
             */
            public Builder addFavoriteBytes(
                    com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                checkByteStringIsUtf8(value);
                ensureFavoriteIsMutable();
                favorite_.add(value);
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


            // @@protoc_insertion_point(builder_scope:User)
        }

    }

    // @@protoc_insertion_point(outer_class_scope)
}