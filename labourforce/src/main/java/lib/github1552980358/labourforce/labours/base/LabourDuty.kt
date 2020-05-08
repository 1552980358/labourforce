package lib.github1552980358.labourforce.labours.base

/**
 * @File    : [LabourDuty]
 * @Author  : 1552980358
 * @Date    : 2020/5/7
 * @TIME    : 19:50
 **/

enum class LabourDuty(var duty: Int) {
    DoWork(0),
    DoNextWork(1),
    EndWork(2)
}