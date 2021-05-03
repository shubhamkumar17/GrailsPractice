package studentcrud

import grails.transaction.Transactional
import org.springframework.beans.factory.annotation.Autowired

class TeacherController {

    TeacherService teacherService

    def index() {
        render("Welcome! This is homepage.")
    }

    def create() {
        def tid = params.tid
        def name = params.name
        Teacher t = new Teacher(tid: (tid), name: (name))
        println t
        if(t)
            teacherService.saveTeacherDetails(t)
        else
            println "Not Saving the data."
        render("Teachers Details saved for Tid: ${params.tid}")
    }

    def update() {
        def tid = params.tid
        def name = params.name
        Teacher t = new Teacher(tid: (tid), name: (name))
        println t
        if(t)
            if(teacherService.updateTeacherDetails(t))
                render("Teachers Details Updated for Tid: ${params.tid}")
            else
                render("Teacher ${tid} not found")
        else
            println "Not Saving the data."

    }

    def delete() {
        Integer tid = params.tid as Integer
        Integer val = teacherService.deleteTeacherDetails(tid)
        if(val) {
            render "Teacher ${tid} Deleted!"
        } else {
            render "Teacher $tid not found"
        }
    }

    def show() {
        render (teacherService.findAll())
    }
}
