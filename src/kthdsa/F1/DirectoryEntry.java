package kthdsa.F1;

public class DirectoryEntry {
    private String name;
    private String number;

    public DirectoryEntry(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof DirectoryEntry that){
            return this.getName().equals(that.getName()) && this.getNumber().equals(that.getNumber());
        }
        return false;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Number: " + number;
    }
}
