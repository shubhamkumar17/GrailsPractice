package studentcrud

import grails.transaction.Transactional


@Transactional
class TeacherService {

    def saveTeacherDetails(Teacher t) {
        if (t == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }
        if(t.validate()) {
            t.errors
        }

        t.save flush:true
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
