package com.thread.premessage;
/**
 * 　Thread-Per-Message
 *   Main 向host发送字符串请求
 *   Host 针对请求创建线程的类
 *   Helper 提供字符显示功能的被动类
 *
 *
 *   host 角色启动新的西线程，
 *   由于启动线程也会花费时间， 所以要提高响应性，取决于handle操作花费的时间
 *   和线程启动花费的时间
 *
 */