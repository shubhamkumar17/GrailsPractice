package studentcrud

import grails.transaction.Transactional
import org.springframework.beans.factory.annotation.Autowired

class TeacherController {

    TeacherService teacherService

    def index() {
        def tid = params.tid
        def name = params.name
        Teacher t = new Teacher(tid: (tid), name: (name))
        println t
        if(t)
            teacherService.saveTeacherDetails(t)
        else
            println "Not Saving the data."
        render("Teachers Details: ${params.tid}")
    }

    def create() {
        Integer tid = params.tid as Integer
        Integer val = teacherService.deleteTeacherDetails(tid)
        if(val) {
            render "Teacher ${tid} Deleted!"
        } else {
            render "Teacher $tid not found"
        }
    }
}
