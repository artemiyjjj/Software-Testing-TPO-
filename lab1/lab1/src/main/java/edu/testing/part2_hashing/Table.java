package edu.testing.part2_hashing;

public interface Table<K> {
    int insert(K k);

    int find(K k);

    int delete(K k);
//    void clear();
}
