package com.deverdie.realmlearning;

import com.deverdie.realmlearning.realmmodel.Student;

import io.realm.Realm;
import io.realm.RealmResults;

public class StudentManager {
    private final Realm realm;
    private static StudentManager instance;

    public StudentManager() {
        realm = Realm.getDefaultInstance();
    }

    public static StudentManager getInstance() {
        if (instance == null)
            instance = new StudentManager();

        return instance;
    }

    public Realm getRealm() {
        return realm;
    }

    public void clearAll() {
        realm.beginTransaction();
        realm.delete(Student.class);
        realm.commitTransaction();
    }

    public void deleteStudent(int id) {
        realm.beginTransaction();
        realm.where(Student.class)
                .equalTo("studentId", id)
                .findFirst()
                .deleteFromRealm();
        realm.commitTransaction();
    }

    public RealmResults<Student> getStudents() {
        return realm.where(Student.class).findAll();
    }

    public RealmResults<Student> getStudents(int studentId) {
        return realm.where(Student.class).equalTo("studentId", studentId).findAll();
    }

    public RealmResults<Student> queryedStudent(String firstName) {
        return realm.where(Student.class)
                .contains("firstName", firstName)
                .findAll();
    }

    public void addStudent(Student student) {
        realm.beginTransaction();
        realm.insert(student);
        realm.commitTransaction();
    }

    public void updateStudent(int id, String name) {
        Student student = realm.where(Student.class)
                .equalTo("studentId", id)
                .findFirst();

        realm.beginTransaction();
        student.setFirstName(name);
        realm.insertOrUpdate(student);
        realm.commitTransaction();
    }

    public int nextId() {
        Number student = realm.where(Student.class).max("studentId");
        if (student == null)
            return 10001;
        else
            return student.intValue() + 1;
    }
}
