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
package com.okta.sdk.impl.error

import com.okta.sdk.error.authc.InvalidAuthenticationException
import com.okta.sdk.error.authc.OAuthAuthenticationException
import org.testng.annotations.Test

import static org.testng.Assert.assertEquals

/**
 * @since 1.0.RC9
 */
class ApiAuthenticationExceptionFactoryTest {

    @Test
    void testInvalidAuthenticationException() {

        def devMessage = "Testing InvalidAuthenticationException"

        def r = ApiAuthenticationExceptionFactory.newApiAuthenticationException(
            InvalidAuthenticationException, devMessage
        )

        assertEquals r.code, ApiAuthenticationExceptionFactory.AUTH_EXCEPTION_CODE
        assertEquals r.status, ApiAuthenticationExceptionFactory.AUTH_EXCEPTION_STATUS
        assertEquals r.moreInfo, ApiAuthenticationExceptionFactory.MORE_INFO
        assertEquals r.message,
            "HTTP " + ApiAuthenticationExceptionFactory.AUTH_EXCEPTION_CODE +
            ", Okta " + ApiAuthenticationExceptionFactory.AUTH_EXCEPTION_STATUS +
            " (" + ApiAuthenticationExceptionFactory.MORE_INFO + "): " + devMessage
        assertEquals r.developerMessage, devMessage
    }
    @Test
    void testOAuthAuthenticationException() {

        def devMessage = "Testing OAuthenticationException"

        def r = ApiAuthenticationExceptionFactory.newOAuthException(OAuthAuthenticationException, devMessage)

        assertEquals r.code, ApiAuthenticationExceptionFactory.AUTH_EXCEPTION_CODE
        assertEquals r.status, ApiAuthenticationExceptionFactory.AUTH_EXCEPTION_STATUS
        assertEquals r.moreInfo, ApiAuthenticationExceptionFactory.MORE_INFO
        assertEquals r.message,
            "HTTP " + ApiAuthenticationExceptionFactory.AUTH_EXCEPTION_CODE +
            ", Okta " + ApiAuthenticationExceptionFactory.AUTH_EXCEPTION_STATUS +
            " (" + ApiAuthenticationExceptionFactory.MORE_INFO + "): " + devMessage

        assertEquals r.developerMessage, devMessage
    }

}
