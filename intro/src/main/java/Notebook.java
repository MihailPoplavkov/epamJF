/*
Спроектировать и разработать классы Запись в блокноте и Блокнот (записи блокнота хранятся в массиве).
Реализовать методы: Добавить запись, Удалить запись, Редактировать запись, Посмотреть все записи.
Написать для данного кода javadoc-документацию.
 */

import lombok.Getter;

/**
 * Class {@code Notebook} represents notebook.
 * @author mihailpoplavkov
 * @version 1.0
 * @since 2017-07-08
 * @see Record
 */

@SuppressWarnings("WeakerAccess")
@Getter
public class Notebook {
    private Record[] records;
    private int size = 0;
    @SuppressWarnings("FieldCanBeLocal")
    private int capacity;

    /**
     * Creates notebook with the given capacity
     * @param capacity initial capacity of the notebook. Immutable
     */
    public Notebook(int capacity) {
        this.capacity = capacity;
        records = new Record[capacity];
    }

    /**
     * Inserts {@code record} into notebook
     * @param record record to insert
     * @return inserted record's id
     */
    public int addRecord(Record record) {
        if (findRecordById(record.getId()) != -1)
            throw new IllegalArgumentException("This record is already in notebook");
        records[size++] = record;
        return record.getId();
    }

    /**
     * Inserts new record into notebook with content of the given {@code text}
     * @param text text to create record
     * @return inserted record's id
     */
    public int addRecord(String text) {
        return addRecord(new Record(text));
    }

    /**
     * Delete record from notebook by the given {@code id} and shift all records after it.
     * Decrements {@code size}
     * @param id record's id to delete
     * @return {@code true} if was deletion and {@code false} if no record were found by the given {@code id}
     */
    public boolean deleteRecord(int id) {
        int i = findRecordById(id);
        if (i == -1) return false;
        System.arraycopy(records, i + 1, records, i, records.length - i - 1);
        size--;
        return true;
    }

    /**
     * Replaces record with the given {@code id} by {@code newRecord}
     * @param id replaced record's id
     * @param newRecord record to replace
     * @throws IllegalArgumentException if no such id were found
     */
    public void changeRecord(int id, Record newRecord) {
        int i = findRecordById(id);
        if (i == -1) throw new IllegalArgumentException("No such id");
        records[i] = newRecord;
    }

    /**
     * Searches for record with the given {@code id} in the notebook
     * @param id record's id
     * @return record's place into notebook or -1 if no record were found
     */
    private int findRecordById(int id) {
        for (int i = 0; i < size; i++) {
            if (records[i].getId() == id) {
                return i;
            }
        }
        return -1;
    }
}
