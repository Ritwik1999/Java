package classexercises.aprilextwosix;

public class CourseThread {
    public static void main(String[] args) throws InterruptedException {
        CourseRegistration course = new CourseRegistration("Java Programming", "Satish", 0);

        Runnable r1 = () -> {
            try {
                course.registerSeat();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Runnable r2 = () -> {
            try {
                course.registerSeat();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Runnable r3 = () -> {
            course.allotSeats(30);
        };

        Runnable r4 = () -> {
            System.out.println("Registration complete. Remaining seats are: " + course.numberOfSeats);
        };

        Thread thr1 = new Thread(r1);
        Thread thr2 = new Thread(r2);
        Thread thr3 = new Thread(r3);
        Thread thr4 = new Thread(r4);

        thr1.start();
        thr2.start();
        thr3.start();

        thr1.join();
        thr2.join();
        thr3.join();

        thr4.start();
    }
}

class CourseRegistration {
    String courseName;
    String facultyName;
    int numberOfSeats;

    CourseRegistration(String courseName, String facultyName, int numberOfSeats) {
        this.courseName = courseName;
        this.facultyName = facultyName;
        this.numberOfSeats = numberOfSeats;
    }

    synchronized void registerSeat() throws InterruptedException {
        while (this.numberOfSeats == 0) {
            wait();
        }
        System.out.println("Seat Registered");
        this.numberOfSeats -= 1;
    }

    synchronized void allotSeats(int seats) {
        this.numberOfSeats += seats;
        notifyAll();
    }
}