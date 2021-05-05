package studentcrud

import grails.transaction.Transactional


@Transactional
class TeacherService {

    Integer saveTeacherDetails(Teacher t) {
        if (t == null) {
            return
        }
        if(!t.validate()) {
            return 0
        }

        t.save flush:true
        return 1
    }

    Integer updateTeacherDetails(Teacher t) {


        if(t) {
            t.save flush: true
            return 1
        }

        return 0
    }


    Integer deleteTeacherDetails(Integer id) {
        Teacher t = Teacher.findById(id)
        if(t) {
            t.delete()
            return t.tid
        }
        return  0
    }

    Teacher getTeacherDetails(Integer id) {
        Teacher t = Teacher.findById(id)
        if(t) {
            return t
        }
        return  0
    }

    def findAll() {
        Teacher.list()
    }
}
