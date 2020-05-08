package lib.github1552980358.labourforce.labours.message

/**
 * @File    : [WorkMessage]
 * @Author  : 1552980358
 * @Date    : 2020/5/8
 * @TIME    : 11:28
 **/

abstract class WorkMessage {
    /**
     * [messages]
     * @author 1552980358
     * @since v0.1
     **/
    private val messages = mutableMapOf<String, Any?>()
    
    /**
     * [getMessage]<T>
     * @param msgName [String]
     * @return <T>?
     * @author 1552980358
     * @since v0.1
     **/
    fun<T> getMessage(msgName: String): T? {
        @Suppress("UNCHECKED_CAST")
        return if (messages.contains(msgName)) messages[msgName] as T? else null
    }
    
    /**
     * [addMessage]
     * @param msgName [String]
     * @param message [Any]?
     * @param cover [Boolean]<false>
     * @return [WorkMessage]
     * @author 1552980358
     * @since v0.1
     **/
    fun addMessage(msgName: String, message: Any?, cover: Boolean = false): WorkMessage {
        if (messages.contains(msgName) && !cover)
            return this
        
        messages[msgName] = message
        return this
    }
    
    /**
     * [removeMessage]
     * @param msgName [String]
     * @return [WorkMessage]
     * @author 1552980358
     * @since v0.1
     **/
    fun removeMessage(msgName: String): WorkMessage {
        if (!messages.contains(msgName))
            return this
        
        messages.remove(msgName)
        return this
    }
    
}