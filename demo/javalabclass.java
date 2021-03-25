package demo;

public class javalabclass {
    public static void main(String[] args) {
        System.out.println();
        professor satish = new professor("ritwik", "vellore", "c19", "s003");
        satish.display_professor();
        System.out.println();
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

class teacher extends person {
    public String empid;

    public void display_teacher() {
        System.out.println(name + address + empid);
    }

    teacher(String iname, String iaddress, String iempid) {
        super(iname, iaddress);
        empid = iempid;
    }
}

class professor extends teacher {
    public String cabinno;

    professor(String iname, String iaddress, String iempid, String icabinno) {
        super(iname, iaddress, iempid);
        cabinno = icabinno;
    }

    public void display_professor() {
        System.out.println(name + " " + address + " " + empid + " " + cabinno);
    }
}