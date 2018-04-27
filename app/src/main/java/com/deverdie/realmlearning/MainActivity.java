package com.deverdie.realmlearning;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.deverdie.realmlearning.javas.Util;
import com.deverdie.realmlearning.models.Columnes;
import com.deverdie.realmlearning.models.Test;
import com.deverdie.realmlearning.realmmodel.Student;
import com.orhanobut.hawk.Hawk;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
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

//        List<Test> tests = new ArrayList<>();
//
//        tests.add(new Test("nineNeung", 38));
//        tests.add(new Test("nineNeung1", 37));
//        tests.add(new Test("nineNeung2", 36));
//        tests.add(new Test("nineNeung3", 35));
//        tests.add(new Test("nineNeung4", 34));
//        tests.add(new Test("nineNeung5", 33));

//        Hawk.put("KEY5", tests);


        Log.d(TAG, "Hawk.count(): " + Hawk.count());
        int num = Hawk.get("KEY1");
        String str = Hawk.get("KEY2");
        Test obj = Hawk.get("KEY3");
        boolean bool = Hawk.get("KEY4");
        List<Test> testList = Hawk.get("KEY5");


        Log.d(TAG, "num: " + num);
        Log.d(TAG, "str: " + str);
        Log.d(TAG, String.format("Object-> %s:%s", obj.getName(), obj.getAge()));
        Log.d(TAG, "bool: " + bool);

        for (Test test : testList) {
            Log.d(TAG, String.format("Object-> %s:%s", test.getName(), test.getAge()));
        }
        List<Columnes> columnesList = new ArrayList<>();
        columnesList.add(new Columnes("Barcode", "ProductTableBarcode", 1));
        columnesList.add(new Columnes("ProdCode", "ProductTableProdCode", 2));
        columnesList.add(new Columnes("ProdType", "ProductTableProdType", 3));
        columnesList.add(new Columnes("ProdName", "ProductTableProdName", 4));
        columnesList.add(new Columnes("UnitName", "ProductTableUnitName", 5));
        columnesList.add(new Columnes("ProdPrice", "ProductTableProdPrice", 6));

        JSONObject productObj = new JSONObject();
        JSONArray productArray = new JSONArray();
        JSONObject Barcode = new JSONObject();
        JSONObject ProdCode = new JSONObject();
        JSONObject ProdType = new JSONObject();
        JSONObject ProdName = new JSONObject();
        JSONObject UnitName = new JSONObject();
        JSONObject ProdPrice = new JSONObject();

        try {
            Barcode.put("DbColName", "Barcode");
            Barcode.put("DbColKey", Util.getLocaleStringResourceByName(new Locale("th"), "ProductTableBarcode", getApplicationContext()));
            Barcode.put("colIndex", 1);
            productArray.put(Barcode);

            ProdCode.put("DbColName", "ProdCode");
            ProdCode.put("DbColKey", "ProductTableProdCode");
            ProdCode.put("colIndex", 2);
            productArray.put(ProdCode);

            ProdType.put("DbColName", "ProdType");
            ProdType.put("DbColKey", "ProductTableProdType");
            ProdType.put("colIndex", 3);
            productArray.put(ProdType);

            ProdName.put("DbColName", "ProdName");
            ProdName.put("DbColKey", "ProductTableProdName");
            ProdName.put("colIndex", 4);
            productArray.put(ProdName);

            UnitName.put("DbColName", "UnitName");
            UnitName.put("DbColKey", "ProductTableUnitName");
            UnitName.put("colIndex", 5);
            productArray.put(UnitName);

            ProdPrice.put("DbColName", "ProdPrice");
            ProdPrice.put("DbColKey", "ProductTableProdPrice");
            ProdPrice.put("colIndex", 5);
            productArray.put(ProdPrice);

            productObj.put("Product", productArray);
            Log.d(TAG, "JSON: " + productObj.toString());

        } catch (JSONException e) {
            e.printStackTrace();
        }

//        {Barcode:1,ProdCode:2,ProdType:3,ProdName:4,UnitName:5,ProdPrice:6}
        try {
            JSONArray testArray = new JSONArray();
            JSONObject testObj = new JSONObject();
            for (Columnes columnes : columnesList) {
                JSONObject object = new JSONObject();
                object.put("DbColName", columnes.getDbName());
                object.put("DbColKey", Util.getLocaleStringResourceByName(new Locale("th"), columnes.getDbColKey(), getApplicationContext()));
                object.put("colIndex", columnes.getColIndex());
                testArray.put(object);
                Log.d(TAG, String.format("Object-> %s, %s, %s", columnes.getDbName(), columnes.getDbColKey(), columnes.getColIndex()));
            }

            testObj.put("Product", testArray);
            Log.d(TAG, "JSON: " + testObj.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        String name = Util.getLocaleStringResource(new Locale(""), R.string.test, getApplicationContext());
        String englishName = Util.getLocaleStringResource(new Locale("en"), R.string.test, getApplicationContext());
        String thaiName = Util.getLocaleStringResource(new Locale("th"), R.string.test, getApplicationContext());


        Log.d(TAG, "ProductTable: " + Util.getLocaleStringArrayResource(new Locale("th"), R.array.ProductTable, getApplicationContext())[0]);

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
