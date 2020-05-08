package lib.github1552980358.labourforce.commands

import android.content.Context
import java.io.File

/**
 * @File    : LabourSource
 * @Author  : 1552980358
 * @Date    : 2020/5/8
 * @TIME    : 10:01
 **/

interface LabourSource {
    
    companion object {
        
        /** [PRIVATE_FILE] **/
        private const val PRIVATE_FILE = "LabourForce"
        
    }
    
    /**
     * [longTermLabour]
     * @param context [Context]
     * @param labourCommand [LabourCommand]
     * @author 1552980358
     * @since v0.1
     **/
    fun longTermLabour(context: Context, labourCommand: LabourCommand) {
        File(context.dataDir.absolutePath, PRIVATE_FILE).apply {
            // Check if file not exists
            // 检查文件是否存在
            if (!exists()) {
                createNewFile()
                return
            }
            
            // Read and employ
            // 读取并聘用
            for (i in readLines()) {
                labourCommand.employLabour(
                    i.substring(0, i.indexOf('=')),
                    LabourLv.values()[i.substring(i.lastIndex).toInt()]
                )
            }
            
        }
    }
    
    /**
     * [registerLongTermLabour]
     * @param context [Context]
     * @param name [String]
     * @author 1552980358
     * @since v0.1
     **/
    fun registerLongTermLabour(context: Context, name: String, labourLv: LabourLv) {
        // Check if repeated
        // 检查是否重复
        File(context.dataDir.absolutePath, PRIVATE_FILE).apply {
            // Check if file not exists
            // 检查文件是否存在
            if (!exists()) {
                createNewFile()
            }
            
            this.readLines().apply {
                if (isNotEmpty()) {
                    for (i in this) {
                        if (i.substring(0, i.indexOf('=')) == name) {
                            return
                        }
                    }
                }
            }
            
            appendText(name + '=' + labourLv.ordinal)
        }
        
    }
    
    /**
     * [unregisterLongTermLabour]
     * @param context [Context]
     * @param name [String]
     * @author 1552980358
     * @since v0.1
     **/
    fun unregisterLongTermLabour(context: Context, name: String) {
        File(context.dataDir.absolutePath, PRIVATE_FILE).apply {
            // Check if file not exists
            // 检查文件是否存在
            if (!exists()) {
                createNewFile()
                return
            }
            
            // Read file
            // 读取文件
            var arrayList = readLines().toMutableList() as ArrayList<String>?
            
            // Empty file
            // 空文件
            arrayList ?: return
            
            if (arrayList.isEmpty()) {
                return
            }
            
            for ((i, j) in arrayList.withIndex()) {
                // Check if exists
                // 检查是否存在
                if (j.substring(0, j.indexOf('=')) != name) {
                    continue
                }
                
                // Found and remove
                // 已找到并删除
                arrayList.removeAt(i)
                writeText("")
                
                // Save
                // 保存
                arrayList.forEach { line ->
                    appendText(line)
                }
                break
            }
            
            arrayList.clear()
            // Recycle
            // 回收
            @Suppress("UNUSED_VALUE")
            arrayList = null
        }
    }
    
}