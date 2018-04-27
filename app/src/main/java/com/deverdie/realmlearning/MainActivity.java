package com.deverdie.realmlearning;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.deverdie.realmlearning.javas.Util;
import com.deverdie.realmlearning.models.Test;
import com.deverdie.realmlearning.realmmodel.Student;
import com.orhanobut.hawk.Hawk;

import java.util.Locale;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "dlg";
    private Realm realm;
    private RealmResults allPersons;
    private RealmChangeListener realmListener = new RealmChangeListener() {
        @Override
        public void onChange(Object o) {
            // Just redraw the views. `allPersons` already contain the
            // latest data.
//            invalidateView();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize Realm
        Realm.init(getApplicationContext());
//
//        Hawk.put("KEY1", 1);
//        Hawk.put("KEY2", "Tanakorn Phongsing");
//        Hawk.put("KEY3", new Test("nineNeung", 38));
//        Hawk.put("KEY4", true);

        Log.d(TAG, "Hawk.count(): " + Hawk.count());
        int num = Hawk.get("KEY1");
        String str = Hawk.get("KEY2");
        Test obj = Hawk.get("KEY3");
        boolean bool = Hawk.get("KEY4");

        Log.d(TAG, "num: " + num);
        Log.d(TAG, "str: " + str);
        Log.d(TAG, String.format("Object-> %s:%s", obj.getName(), obj.getAge()));
        Log.d(TAG, "bool: " + bool);

        String name = Util.getLocaleStringResource(new Locale(""), R.string.test, getApplicationContext());
        String englishName = Util.getLocaleStringResource(new Locale("en"), R.string.test, getApplicationContext());
        String thaiName = Util.getLocaleStringResource(new Locale("th"), R.string.test, getApplicationContext());

        Log.d(TAG, "default: " + name);
        Log.d(TAG, "en: " + englishName);
        Log.d(TAG, "th: " + thaiName);

//        Insert
//        List<Student> students = new ArrayList<>();
//
//        Student student = new Student();
//
//        student.setStudentId(10001);
//        student.setFirstName("Alex");
//        student.setLastName("Ferguson");
//        student.setGender("male");
//        student.setCity("Scotland");
//        student.setAge(19);
//        students.add(student);
//
//        student = new Student();
//        student.setStudentId(10002);
//        student.setFirstName("Ronaldo");
//        student.setLastName("Santos Aveiro");
//        student.setGender("male");
//        student.setCity("Portugal");
//        student.setAge(22);
//        students.add(student);
//
//        for (Student stu : students) {
//            StudentManager.getInstance().addStudent(stu);
//        }

//        Update
//        StudentManager.getInstance().updateStudent(10001, "Jedsada");

//        Delete
//        StudentManager.getInstance().deleteStudent(10001);

//        List All
        for (Student stu : StudentManager.getInstance().getStudents()) {
            Log.d(TAG, stu.getStudentId() + "\n"
                    + stu.getFirstName() + "\t" + stu.getLastName() + "\n"
                    + stu.getGender() + "\n"
                    + stu.getAge() + "\n"
                    + stu.getCity() + "\n");
        }
    }

//        // Get a Realm instance for this thread
//        realm = Realm.getDefaultInstance();
//
//        realm.executeTransaction(new Realm.Transaction() {
//            @Override
//            public void execute(Realm realm) {
//                User user = realm.createObject(User.class);
//                user.setName("John");
//                user.setAge(22);
//            }
//        });


//        realm.addChangeListener(realmListener);
//        allPersons = realm.where(Person.class).findAll(); // Create the "live" query result
//        setupViews(); // Initial setup of views
//        invalidateView(); // Redraw views with data

//    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        realm.close();
    }


}
