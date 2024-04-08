package edu.testing.part2_hashing;

import edu.testing.part2_hashing.utils.FullTableException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.BinaryOperator;
import java.util.function.Function;

public class ClosedHashingTable implements Table<Integer> {
    private final List<Node<Integer>> table;
    private int elementsAmount;
    private final Integer tableSize;


    private final Function<Integer, Integer> hashingAlgorithm;

    private final BinaryOperator<Integer> probingAlgorithm;



    public static BinaryOperator<Integer> getLinearProbing() {
        return (i, x) -> i;
    }

    public static BinaryOperator<Integer> getQuadraticProbing() {
        return (i, x) -> i * i ;
    }

    public static BinaryOperator<Integer> getDoubleProbing(Function<Integer, Integer> hash2) {
        return (i, x) -> i * hash2.apply(x);
    }

    public static Function<Integer, Integer> sampleMainHash(int tableSize) {
        return k -> k % tableSize;
    }

    public static Function<Integer, Integer> sampleHash2() {
        return x -> 7 - x % 7;
    }


    public ClosedHashingTable(int tableSize, Function<Integer, Integer> mainAlgorithm, BinaryOperator<Integer> probingAlgorithm) {
        this.table = new ArrayList<>();
        for (int i = 0; i < tableSize; i++) {
            table.add(new Node<>());
        }
        this.tableSize = tableSize;
        this.elementsAmount = 0;
        this.probingAlgorithm = probingAlgorithm;
        this.hashingAlgorithm = mainAlgorithm;
    }

    @Override
    public int insert(Integer key) throws FullTableException {
        if (elementsAmount == tableSize) {
            throw new FullTableException("Table is full.");
        }
        int i = 0;
        int hashingResult = hashingAlgorithm.apply(key);
        int position = hashingResult;
        do  {
            var element = table.get(position);
            if (element.getNodesState() != Node.NodesState.PRESENT) {
                table.get(position).setValue(key);
                elementsAmount++;
                return position;
            }
            i++;
            position = hashingResult + probingAlgorithm.apply(i, key);
        } while (true);
    }

    @Override
    public int find(Integer key) {
        int i = 0;
        int hashingResult = hashingAlgorithm.apply(key);
        int position = hashingResult;
        do {
            var element = table.get(position);
            if (element.getNodesState() == Node.NodesState.PRESENT && Objects.equals(element.getValue(), key)) {
                return position;
            }
            i++;
            position = hashingResult + probingAlgorithm.apply(i, key);
        } while (true);
    }

    @Override
    public int delete(Integer key) {
        int i = 0;
        int hashingResult = hashingAlgorithm.apply(key);
        int position = hashingResult;
        do {
            var element = table.get(position);
            if (element.getNodesState() == Node.NodesState.PRESENT && Objects.equals(element.getValue(), key)) {
                element.setValue(null);
                return position;
            }
            i++;
            position = hashingResult + probingAlgorithm.apply(i, key);
        } while (true);
    }

//    @Override
//    public void clear() {
//        for (int i = 0; i < table.length; i++) {
//
//        }
//    }


    public List<Node<Integer>> getTable() {
        return table;
    }

    public int getElementsAmount() {
        return elementsAmount;
    }

    public Integer getTableSize() {
        return tableSize;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < tableSize; i++) {
            s.append(i).append(", ").append(table.get(i)).append(";\n");
        }
        return "table=[" + s + "]";
    }
}
