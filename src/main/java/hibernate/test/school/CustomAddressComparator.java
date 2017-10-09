package hibernate.test.school;

import java.util.Comparator;

public class CustomAddressComparator implements Comparator<Address> {
    public int compare(Address o1, Address o2) {
        return o1.getLocation().compareTo(o2.getLocation());
    }
}
