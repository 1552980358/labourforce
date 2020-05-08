package lib.github1552980358.labourforce.labours.work

import lib.github1552980358.labourforce.commands.LabourCommand

/**
 * @File    : LabourWorkBuilder
 * @Author  : 1552980358
 * @Date    : 2020/5/8
 * @TIME    : 10:32
 **/

class LabourWorkCommander {
    companion object {
    
        /**
         * [asCommander]
         * @return [LabourWorkCommander]
         * @author 1552980358
         * @since v0.1
         **/
        @JvmStatic
        fun asCommander(): LabourWorkCommander {
            return LabourWorkCommander()
        }
        
    }
    
    /**
     * [labours]
     * @author 1552980358
     * @since v0.1
     **/
    private var labours = arrayListOf<String>()
    
    /**
     * [labourWorks]
     * @author 1552980358
     * @since v0.1
     **/
    private var labourWorks = arrayListOf<LabourWork>()
    
    /**
     * [addLabourWork]
     * @param name [String]
     * @param labourWork [LabourWork]
     * @return [LabourWorkCommander]
     * @author 1552980358
     * @since v0.1
     **/
    @Synchronized
    fun addLabourWork(name: String, labourWork: LabourWork): LabourWorkCommander {
        labours.add(name)
        labourWorks.add(labourWork)
        return this
    }
    
    /**
     * [send]
     * @param labourCommand [LabourCommand]
     * @author 1552980358
     * @since v0.1
     **/
    fun send(labourCommand: LabourCommand) {
        for ((i,j) in labours.withIndex()) {
            labourCommand.sendWork2Labour(j, labourWorks[i])
        }
    }
    
}