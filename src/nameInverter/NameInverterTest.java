/*
* Notice Name Inverter function is directly reference form Uncle Bob tutorials.
*/
package nameInverter;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NameInverterTest {

    private NameInverter nameInverter;

    @Before
    public void setup() {
        nameInverter = new NameInverter();
    }

    private void assertInverted(String originalName, String invertedName) {
        assertEquals(invertedName, nameInverter.invertName(originalName));
    }

    @Test
    public void givenNull_returnsEmptyString() throws Exception {
        assertInverted(null, "");
    }

    @Test
    public void givenEmptyString_returnsEmptyString() throws Exception {
        assertInverted("", "");
    }

    @Test
    public void givenSampleName_returnsSampleName() throws Exception {
        assertInverted("Name", "Name");
    }

    @Test
    public void givenASimpleNameWithSpace_returnSimpleNameWithoutSpace() throws Exception {
        assertInverted(" Name ", "Name");
    }

    @Test
    public void givenFirstLast_returnLastFirst() throws Exception {
        assertInverted("First Last", "Last, First");
    }

    @Test
    public void givenFirstLastWithExtraSpaces_returnLastFirst() throws Exception {
        assertInverted(" First  Last ", "Last, First");
    }

    @Test
    public void ignoreHonorific() throws Exception {
        assertInverted("Mr. First Last", "Last, First");
        assertInverted("Mrs. First Last", "Last, First");
    }

    @Test
    public void postNominals_stayAtEnd() throws Exception {
        assertInverted("First Last Sr.", "Last, First Sr.");
        assertInverted("First Last Bs. Phd.", "Last, First Bs. Phd.");
    }

    @Test
    public void integration() throws Exception {
        assertInverted(" Robert Martin III esq. ", "Martin, Robert III esq.");
    }
}
