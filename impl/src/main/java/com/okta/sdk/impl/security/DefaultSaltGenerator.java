/*
 * Copyright 2014 Stormpath, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.okta.sdk.impl.security;

import com.okta.sdk.impl.util.Base64;

import java.security.SecureRandom;

/**
 * @since 0.5.0
 */
public class DefaultSaltGenerator implements SaltGenerator {

    private static final int DEFAULT_BYTES_SIZE = 16;
    private final int bytesSize;

    public DefaultSaltGenerator() {
        this(DEFAULT_BYTES_SIZE);
    }

    public DefaultSaltGenerator(int bytesSize) {
        this.bytesSize = bytesSize;
    }

    @Override
    public String generate() {
        SecureRandom random = new SecureRandom();
        byte[] byteArr = new byte[bytesSize];
        random.nextBytes(byteArr);
        return Base64.encodeBase64URLSafeString(byteArr);
    }
}
