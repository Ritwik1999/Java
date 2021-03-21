package oops;

public class javalabclass {
    public static void main(String[] args) {
        professor satish = new professor("satish", "vellore", "111", "a06");
        satish.display_professor();
    }
}

class person {
    protected String name;
    protected String address;

    person(String iname, String iaddress) {
        name = iname;
        address = iaddress;
    }

    public final void display_vitadd() {
        System.out.println(name + address);
    }
}

class faculty extends person {
    public String empid;

    public void display_faculty() {
        System.out.println(name + address + empid);
    }

    faculty(String iname, String iaddress, String iempid) {
        super(iname, iaddress);
        empid = iempid;
    }
}

class professor extends faculty {
    public String cabinno;

    professor(String iname, String iaddress, String iempid, String icabinno) {
        super(iname, iaddress, iempid);
        cabinno = icabinno;
    }

    public void display_professor() {
        System.out.println(name + address + empid + cabinno);
    }
}