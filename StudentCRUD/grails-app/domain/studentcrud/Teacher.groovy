package studentcrud

import groovy.transform.ToString

@ToString
class Teacher {

    Integer tid
    String name

    static constraints = {
        tid unique: true, nullable: false
        name blank: false
    }
}
