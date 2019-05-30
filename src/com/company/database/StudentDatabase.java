package com.company.database;

import com.company.dto.Student;
import com.company.utils.ConsoleUtils;
import com.company.utils.StringUtils;

import java.util.*;

public class StudentDatabase {

//    private Set<Student> database = new HashSet<>();

    private int initialCount = 0;

    private Map<Integer, Student> idStudents = new HashMap<>();
    private Map<String, Set<Student>> nameStudents = new HashMap<>();
    private Map<String, Set<Student>> groupStudents = new HashMap<>();
    private Map<Integer, Set<Student>> yearOfEducationStudents = new HashMap<>();

    public Student save(Student dto) {

        dto.setId(++initialCount);
        idStudents.put(dto.getId(), dto);

        addStudentToNamesMap(dto);
        return dto;
    }

    public Student saveOrUpdate(Student dto) {
        if (dto.getId() == null) {
            return save(dto);
        }
        //What if dto has ID, that does not exist in idStudents MAP?

        //What if student does not have name?
        //What if student's name == null?
        //What if student's name is empty?
        //What if student's name is blank?

        //removes student from namesMap if his/her name differs from the existing in namesMap
        removeStudentFromNamesMap(dto);

        idStudents.put(dto.getId(), dto);
        addStudentToNamesMap(dto);

        return dto;
    }

    private void addStudentToNamesMap(Student newStudent) {
        Set<Student> studentsByName = nameStudents.get(newStudent.getFullName());
        if (studentsByName == null) {
            studentsByName = new HashSet<>();
        }

        if (!StringUtils.isNullOrEmptyOrBlank(newStudent.getFullName())) {
            studentsByName.add(newStudent);
            nameStudents.put(newStudent.getFullName(), studentsByName);
        }
    }

    //                                                3, John Doe
    private void removeStudentFromNamesMap(Student studentToUpdate) {

        //       3, Marry Simons                                  id - 3
        Student oldStudentRecord = idStudents.get(studentToUpdate.getId());
        boolean isEmptyName = StringUtils.isNullOrEmptyOrBlank(oldStudentRecord.getFullName());
        if (isEmptyName) {
            return;
        }

        Set<Student> studentsByName = nameStudents.get(oldStudentRecord.getFullName());

        //finding current student (in namesMap) and detecting him/her by ID
        for (Student student : studentsByName) {
            if (student.equals(studentToUpdate)) {
                oldStudentRecord = student;
            }
        }
        //if names differ - removing from list
        if (!studentToUpdate.getFullName().equals(oldStudentRecord.getFullName())) {
            studentsByName.remove(oldStudentRecord);
        }

        nameStudents.put(oldStudentRecord.getFullName(), studentsByName);
    }




    public void deleteById(Integer id) {
        if (id != null) {
            idStudents.remove(id);
        }
    }

    public Student findById(Integer id) {
        if (id == null) {
            return null;
        }
        return idStudents.get(id);
    }

    public List<Student> findAll() {
        Collection<Student> values = idStudents.values();
        return new ArrayList<>(values);
    }

    public Set<Student> findAllByName(String name) {
        //Entry
//        Entry<Integer, Student> entry = new Entry<>(1, new Student());
//        Entry<Integer, Student> entry2 = new Entry<>(2, new Student());
//        Entry<Integer, Student> entry3 = new Entry<>(3, new Student());
//
//        Set<Entry<Integer, Student>> entrySet = new HashSet<>();
//        entrySet.add(entry);
//        entrySet.add(entry2);
//        entrySet.add(entry3);
//
//        for (Entry<Integer, Student> e : entrySet) {
//            e.getKey();
//        }

        return nameStudents.get(name);

    }
//
//    public List<Student> findAllByMajor(String major) {
//    }

    public void printStudents() {

        ConsoleUtils.print("ID STUDENTS");
        for (Map.Entry<Integer, Student> entry : idStudents.entrySet()) {
            ConsoleUtils.print(String.format("%s - %s\n",
                    entry.getKey(),
                    entry.getValue()));
        }
        ConsoleUtils.print("NAME STUDENTS");
        for (Map.Entry<String, Set<Student>> entry : nameStudents.entrySet()) {
            ConsoleUtils.print(String.format("%s - %s\n",
                    entry.getKey(),
                    entry.getValue()));
        }

    }
}

class Entry<K, V> {
    private K key;
    private V value;

    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}