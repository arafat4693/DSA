package kthdsa.F1;

import java.util.ArrayList;
import java.util.List;

public class PhoneDirectory {

    private List<DirectoryEntry> phoneList;

    public PhoneDirectory() {
        this.phoneList = new ArrayList<>();
    }

    public void addEntry(String name, String number) {
        phoneList.add(new DirectoryEntry(name, number));
    }

    public int indexOf(String name) {
        for (int i = 0; i < phoneList.size(); i++) {
            if (phoneList.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public DirectoryEntry get(int index) {
        if (index >= 0 && index < phoneList.size()) {
            return phoneList.get(index);
        } else {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + phoneList.size());
        }
    }
}