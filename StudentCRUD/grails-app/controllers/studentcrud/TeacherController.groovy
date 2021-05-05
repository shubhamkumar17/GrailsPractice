package studentcrud

import grails.transaction.Transactional
import org.springframework.beans.factory.annotation.Autowired

class TeacherController {

    TeacherService teacherService

    def index() {
        [teachers: teacherService.findAll()]
    }

    def create() {}

    def save(Teacher teacher) {
        //Teacher teacher = new Teacher(params)
        println teacher
        if (teacher) {

            if(teacherService.saveTeacherDetails(teacher)) {
                flash.message = "Teacher Added!!"
            } else {
                flash.message = "Fields cannot be empty!!"
            }
            redirect(action: "create")
        }
        else
            println "Not Saving the data."
    }

    def update(Teacher teacher) {

        if(teacherService.updateTeacherDetails(teacher)) {
            flash.message = "Data updated for Teacher ID: " + params.tid
        } else {
            flash.message = " Teacher Id: " + params.tid + " not found!!"
        }
        redirect (action: "index")
    }

    def delete() {
        println "Params: " + params
        Integer success = teacherService.deleteTeacherDetails(params.id as Integer)
        println "Success: " + success
        if(success) {
            flash.message = "Teacher with Teacher ID: " + success + " deleted."
        } else {
            flash.message = "Cannot delete, Teacher with ID: " + success
        }
        redirect(action: "index")
    }

    def edit() {
        Teacher t = teacherService.getTeacherDetails(params.id as Integer)
        if(t) {
            render (view: "edit", model: [teacher: t])
        } else {
            flash.message = "Some error occured!!"
            redirect(action: "index")
        }
    }
}
