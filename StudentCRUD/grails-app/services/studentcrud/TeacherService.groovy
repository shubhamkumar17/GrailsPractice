package studentcrud

import grails.transaction.Transactional


@Transactional
class TeacherService {

    def saveTeacherDetails(Teacher t) {
        if (t == null) {
            return
        }
        if(t.validate()) {
            t.errors
        }

        t.save flush:true
    }

    Integer updateTeacherDetails(Teacher t) {
        Teacher newT = Teacher.findByTid(t.getTid())
        if(newT) {
            t.save flush: true
            return 1
        }

        return 0
    }


    Integer deleteTeacherDetails(Integer tId) {
        Teacher t = Teacher.findByTid(tId)
        if(t) {
            t.delete()
            return 1
        }
        return  0
    }

    def findAll() {
        Teacher.findAll()
    }
}
