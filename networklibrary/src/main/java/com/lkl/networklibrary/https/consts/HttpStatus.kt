package com.lkl.demo.https.consts

object HttpStatus {
    /**
     * 响应成功
     */
    @JvmField
    val SUCCESS = 0

    @JvmField
    val ERROR = -1
    /**
     * 服务器内部错误
     */
    @JvmField
    val SERVER_ERROR = 1
    @JvmField
    val SOCKET_TIMEOUT = -2

    @JvmField
    val AUTHENTICATION_FAILED = 10
    @JvmField
    val TOKEN_HAS_EXPIRED = 11

    @JvmField
    val WRONG_USERNAME = 20
    @JvmField
    val WRONG_PASSWORD = 21

    @JvmField
    val VERIFICATION_CODE_INVALID = 201
    @JvmField
    val VERIFICATION_CODE_ERROR = 202
    @JvmField
    val PHONE_NOT_REGISTERED = 203
    @JvmField
    val PHONE_HAS_REGISTERED = 210
}