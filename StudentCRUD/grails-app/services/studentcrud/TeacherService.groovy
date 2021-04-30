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

        t.save()
    }


    Integer deleteTeacherDetails(Integer tId) {
        Teacher t = Teacher.findByTid(tId)
        if(t) {
            t.delete()
            return 1
        }
        return  0
    }
}
