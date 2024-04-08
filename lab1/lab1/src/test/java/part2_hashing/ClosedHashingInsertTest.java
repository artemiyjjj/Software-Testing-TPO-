package part2_hashing;

import edu.testing.part2_hashing.ClosedHashingTable;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ClosedHashingInsertTest {

    protected final static int tableSize = 29;
    @Test
    public void testInsertLinearProbing() {
        ClosedHashingTable table = new ClosedHashingTable(tableSize, ClosedHashingTable.sampleMainHash(tableSize), ClosedHashingTable.getLinearProbing());
        table.insert(1);
        Assertions.assertEquals(table.getTable().get(1).getValue(), 1);
        table.insert(1);
        Assertions.assertEquals(table.getTable().get(2).getValue(), 1);
        table.insert(2);
        Assertions.assertEquals(table.getTable().get(2).getValue(), 1);
        Assertions.assertEquals(table.getTable().get(3).getValue(), 2);
    }

    @Test
    public void testInsertQuadraticProbing() {
        ClosedHashingTable table = new ClosedHashingTable(tableSize, ClosedHashingTable.sampleMainHash(tableSize), ClosedHashingTable.getQuadraticProbing());
        table.insert(1);
        Assertions.assertEquals(table.getTable().get(1).getValue(), 1);
        table.insert(1);
        Assertions.assertEquals(table.getTable().get(1).getValue(), 1);
        Assertions.assertEquals(table.getTable().get(2).getValue(), 1);
        table.insert(1);
        Assertions.assertEquals(table.getTable().get(1).getValue(), 1);
        Assertions.assertEquals(table.getTable().get(2).getValue(), 1);
        Assertions.assertEquals(table.getTable().get(5).getValue(), 1);
        table.insert(5);
        Assertions.assertEquals(table.getTable().get(5).getValue(), 1);
        Assertions.assertEquals(table.getTable().get(6).getValue(), 5);
        table.insert(5);
        Assertions.assertEquals(table.getTable().get(5).getValue(), 1);
        Assertions.assertEquals(table.getTable().get(6).getValue(), 5);
        Assertions.assertEquals(table.getTable().get(9).getValue(), 5);
    }

    @Test
    public void testInsertDoubleProbing() {
        ClosedHashingTable table = new ClosedHashingTable(tableSize, ClosedHashingTable.sampleMainHash(tableSize),
                ClosedHashingTable.getDoubleProbing(ClosedHashingTable.sampleHash2()));
        table.insert(7);
        Assertions.assertEquals(table.getTable().get(7).getValue(), 7);
        table.insert(10);
        Assertions.assertEquals(table.getTable().get(10).getValue(), 10);
        table.insert(10);
        Assertions.assertEquals(table.getTable().get(10).getValue(), 10);
        Assertions.assertEquals(table.getTable().get(14).getValue(), 10);
        table.insert(14);
        Assertions.assertEquals(table.getTable().get(14).getValue(), 10);
        Assertions.assertEquals(table.getTable().get(21).getValue(), 14);
        table.insert(7);
        Assertions.assertEquals(table.getTable().get(21).getValue(), 14);
        Assertions.assertEquals(table.getTable().get(14).getValue(), 10);
        Assertions.assertEquals(table.getTable().get(28).getValue(), 7);
    }
}
