package com.gacrnd.gcs.common.utils

import java.lang.StringBuilder

/**
 * @author Jack_Ou  created on 2020/8/3.
 */
object JsonUtil {

    /**
     * 格式化string字符串成json格式
     *
     */
    fun formatJson(srcString: String): String {
        if (null == srcString || "" == srcString) return ""
        val sb = StringBuilder()
        var last = '\u0000'
        var current = '\u0000'
        var indent = 0
        for (i in 0 until srcString.length) {
            last = current
            current = srcString[i]
            when (current) {
                '{', '[' -> {
                    sb.append(current)
                    sb.append('\n')
                    indent++
                    addIndentBlank(sb, indent)
                }
                '}', ']' -> {
                    indent--
                    sb.append('\n')
                    addIndentBlank(sb, indent)
                    sb.append(current)
                }
                ',' -> {
                    sb.append(current)
                    if (last != '\\') {
                        sb.append('\n')
                        addIndentBlank(sb, indent)
                    }
                }
                else -> sb.append(current)
            }
        }
        return sb.toString()
    }

    /**
     * 增加tab空格
     */
    private fun addIndentBlank(sb: StringBuilder, indent: Int) {
        for (i in 0 until indent) {
            sb.append('\t')
        }
    }
}