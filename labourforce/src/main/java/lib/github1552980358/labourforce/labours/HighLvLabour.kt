package lib.github1552980358.labourforce.labours

import lib.github1552980358.labourforce.labours.base.BaseLabour
import lib.github1552980358.labourforce.labours.base.LabourDuty
import lib.github1552980358.labourforce.labours.base.LabourIdentity
import lib.github1552980358.labourforce.labours.base.LabourWork
import lib.github1552980358.labourforce.labours.base.WorkPriority

/**
 * @File    : HighLvLabour
 * @Author  : 1552980358
 * @Date    : 2020/5/7
 * @TIME    : 22:10
 **/

class HighLvLabour: BaseLabour(), LabourIdentity {
    /** [max] **/
    private val max = arrayListOf<LabourWork>()
    /** [mid] **/
    private val mid = arrayListOf<LabourWork>()
    /** [min] **/
    private val min = arrayListOf<LabourWork>()
    
    override fun run() {
        
        while (dutyStatus != LabourDuty.EndWork) {
            
            // Check whether work has received
            // 检查是否接收到新工作
            currentWork = if (max.isNotEmpty()) {
                max.removeAt(0)
            } else if (mid.isNotEmpty()) {
                mid.removeAt(0)
            } else if (min.isNotEmpty()) {
                min.removeAt(0)
            } else {
                sleep(checkInterval)
                continue
            }
            
            if (dutyStatus == LabourDuty.EndWork)
                break
            
            super.run()
        }
    }
    
    /**
     * [onWorkReceive]
     **/
    @Synchronized
    override fun onWorkReceive(labourWork: LabourWork?) {
        labourWork?:return
        when (labourWork.priority) {
            null, WorkPriority.MID -> {
                mid.add(labourWork)
            }
            WorkPriority.MAX -> {
                max.add(labourWork)
            }
            WorkPriority.MIN -> {
                min.add(labourWork)
            }
        }
    }
    
    /**
     * [offDuty]
     **/
    override fun offDuty() {
        dutyStatus = LabourDuty.EndWork
        max.clear()
        mid.clear()
        min.clear()
        currentWork = null
    }
    
    /**
     * [isWorking]
     **/
    override fun isWorking(): Boolean {
        return currentWork == null
    }
    
    /**
     * [onReceiveMessage]
     **/
    override fun onReceiveMessage() {
    
    }
}