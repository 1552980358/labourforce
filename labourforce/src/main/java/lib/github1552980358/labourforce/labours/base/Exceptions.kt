package lib.github1552980358.labourforce.labours.base

/**
 * @File    : Exceptions
 * @Author  : 1552980358
 * @Date    : 2020/5/7
 * @TIME    : 20:39
 **/

class WorkDoneSignal : RuntimeException()

class DutyEndSignal : RuntimeException("Duty time of labour is done.")