package studentcrud

class Student {

    Integer rollNo
    String name

    static constraints = {
        rollNo unique: true, nullable: false
        name blank: false
    }
}
