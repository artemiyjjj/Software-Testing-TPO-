package part2_hashing;

import edu.testing.part2_hashing.ClosedHashingTable;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ClosedHashingFindTest {
    protected final static int tableSize = 29;

    @Test
    public void testFindKeysWithLinearProbing() {
        ClosedHashingTable table = new ClosedHashingTable(tableSize, ClosedHashingTable.sampleMainHash(tableSize), ClosedHashingTable.getLinearProbing());
        table.insert(15);
        table.insert(15);
        table.insert(16);
        table.insert(17);
        Assertions.assertEquals(table.find(16), 17);
        Assertions.assertEquals(table.find(17), 18);
    }

    @Test
    public void testFindKeysWithQuadraticProbing() {
        ClosedHashingTable table = new ClosedHashingTable(tableSize, ClosedHashingTable.sampleMainHash(tableSize), ClosedHashingTable.getQuadraticProbing());
        table.insert(15);
        table.insert(15);
        table.insert(15);
        table.insert(19);
        Assertions.assertEquals(table.find(15), 15);
        Assertions.assertEquals(table.find(19), 20);
    }

    @Test
    public void testFindKeysWithDoubleProbing() {
        ClosedHashingTable table = new ClosedHashingTable(tableSize, ClosedHashingTable.sampleMainHash(tableSize), ClosedHashingTable.getDoubleProbing(ClosedHashingTable.sampleHash2()));
        table.insert(11);
        table.insert(11);
        table.insert(14);
        table.insert(21);
        Assertions.assertEquals(table.find(11), 11);
        Assertions.assertEquals(table.find(14), 21);
        Assertions.assertEquals(table.find(21), 28);
    }
}
